package com.shoppingweb.service.impl;

import com.shoppingweb.bean.User;
import com.shoppingweb.mapper.UserMapper;
import com.shoppingweb.service.UserService;
import com.sun.mail.smtp.SMTPMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     *根据用户输入的账号以及密码获取用户的信息
     */
    @Override
    public User findUserByNameAndPass(User user) {
        // TODO Auto-generated method stub
        User u = userMapper.findUserByNameAndPass(user);
        return u;
    }

    /*
     * 异步校验账号是否存在
     */
    @Override
    public String validLoginName(String loginName) {
        // TODO Auto-generated method stub

        User user = userMapper.validLoginName(loginName);
        if(user != null) {
            return "您输入的账号已经存在！";
        }
        return "";
    }

    /*
     * 用户注册
     */
    @Override
    public void saveUser(User user, HttpServletRequest request) {
        try {
            //生成激活码
            String active = UUID.randomUUID().toString();
            user.setCreateDate(new Date());
            user.setActive(active);
            userMapper.saveUser(user);

            //开始发送邮件给用户
            //创建Properties对象，用来封装邮件服务器相关信息
            Properties props = new Properties();
            //设置邮件服务器的地址
            props.setProperty("mail.smtp.host", "smtp.126.com");
            //邮件服务器需要权限，指定用户必须登录邮件服务器才能发送邮件
            props.setProperty("mail.smtp.auth", "true");

            //创建Authenticator的实例，实现账户、授权码的鉴权。
            Authenticator auth = new Authenticator(){
                protected PasswordAuthentication getPasswordAuthentication()
                {
                    return new PasswordAuthentication("cenlaihaotest@126.com", "NCNUXCHTLRIEIMEZ");
                }
            };

            //通过Session与服务器建立连接
            Session session = Session.getInstance(props,auth);

            //创建发送邮件对象，该对象主要用于封装邮件相关信息，比如  主题  发件人  邮件内容等
            SMTPMessage message = new SMTPMessage(session);

            //设置邮件的主题
            message.setSubject("用户注册激活邮件，请勿回复，按照指引激活");
            //设置邮件的内容
            message.setContent("<a href='http://127.0.0.1:8080"+request.getContextPath()+"/user/active?activeCode="+user.getActive()+"' target='_blank'>恭喜您注册成功，请点击该链接进行激活，无需回复！</a>", "text/html;charset=utf-8");

            //设置发件人
            message.setFrom(new InternetAddress("cenlaihaotest@126.com"));

            //设置收件人   接收者类型由：TO(收件人)、CC(抄送)、BCC(密送)
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));

            //发送邮件
            Transport.send(message);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    /*
     * 用户信息激活
     */
    @Override
    public String active(String activeCode) {
        // TODO Auto-generated method stub
        //根据激活码获取用户信息，如果找不到说明  激活码不正确，或者已经激活过
        User user = userMapper.getUserByActive(activeCode);
        if(user!=null) {
            userMapper.active(activeCode);
            return "";
        }else {
            return "激活码失效！";
        }
    }

    //更新个人信息
    @Override
    public void userUpdate(User user) {
        // TODO Auto-generated method stub
        userMapper.userUpdate(user);
    }

}
