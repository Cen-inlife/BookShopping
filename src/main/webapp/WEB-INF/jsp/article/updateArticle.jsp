<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>商品首页</title>
    <!-- Bootstrap core CSS -->
    <%-- c:url 标签的作用：
    	1.自动在URL的前面加上context path
    	2.如果客户端禁用了Cookie，自动使用URL重写技术，把jsessionid放到url的分号后面
    	/taobao/resources/bootstrap/css/bootstrap.css;jsessionid=xxxxx
     --%>
    <link href="<c:url value="/resources/bootstrap/css/bootstrap.css"/>" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/resources/css/taobao.css" rel="stylesheet" />
    <script src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
 <script type="text/javascript">
    
 $(function(){
	 
	 //获取商品所属的二级类型
	 var typeCode = "${article.typeCode}";
	 
	 $("#sCode").val(typeCode);
	 
	 
	 //获取商品所属的一级类型
	 var fCode = typeCode.substring(0,4);
	 $("#fCode").val(fCode);
	 
	 
	 
	//为一级商品类型绑定 onchange事件
     $("#fCode").change(function(){
    	   
    	    //获取用户选中的  一级商品类型
    	    var val = this.value;
    	    if(val != "0"){
    	    	
    	    	 $.ajax({
    	    		  type : "post",
    	    		  url : "${pageContext.request.contextPath}/article_manager/ajaxLoadSeTypes.action",
    	    		  data : "code="+val,
    	    		  dataType : "json",
    	    		  success : function(arr){
    	    			  $("#sCode").empty();
    	    			   $.each(arr,function(){
    	    				   $("#sCode").append("<option value="+this.code+">"+this.name+"</option>").val(typeCode);
    	    				   
    	    			   })
    	    		  },error : function(){
    	    			  alert("网路加载异常");
    	    		  }
    	    		 
    	    	 })
    	    } 
     })
     
     
     //触发 一级类型的  onchange事件
	 $("#fCode").trigger("change");
	
	 
   })
 
    function valNum(obj){
    	if(isNaN(obj.value) || obj.value<=0 || obj.value >1){
    		obj.value = "${article.discount}";
    	}
    }
   
   </script>
</head>

<body>

<!-- 横幅导航条开始 -->
	<jsp:include page="/WEB-INF/jsp/common/nva_back.jsp"></jsp:include>

<!-- 横幅导航条结束 -->

<div class="container">

    <div class="row row-offcanvas row-offcanvas-right">
        <fieldset style="width:700px;"><legend>修改物品</legend>
            <span style="color: red">${tip}</span>
            <form name="articleform" class="form-horizontal" action="${pageContext.request.contextPath}/article_manager/updateArticle.action"
                  method="post" enctype="multipart/form-data">
                <!-- 隐藏表单用来传输要修改的物品编号 -->
                <input type="hidden" name="id" value="${article.id}"/>
             

                <div class="form-group">
                    <label class="col-sm-3 control-label">一级类型：</label>
                    <div class="col-sm-3">
                        <select    class="form-control" id="fCode">
                            <c:forEach items="${types}" var="type">
                                <option value="${type.code}">${type.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    
                    <label class="col-sm-3 control-label">二级类型：</label>
                    <div class="col-sm-3">
                        <select   class="form-control" name="code" id="sCode">
                            
                        </select>
                    </div>
                   
                </div>

                <div class="form-group">
                     <label class="col-sm-3 control-label">标题：</label>
                    <div class="col-sm-3">
                        <input type=text value="${article.title}" required="required" class="form-control" name="title" size="50">
                    </div>
                   
                    <label class="col-sm-3 control-label">地区：</label>
                    <div class="col-sm-3">
                        <input type=text class="form-control" required="required" value="${article.locality}" name="locality" size="50">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">价格：</label>
                    <div class="col-sm-3">
                        <input type=text class="form-control" required="required" value="${article.price}" name="price" size="50">
                    </div>
                    <label class="col-sm-3 control-label">库存数量：</label>
                    <div class="col-sm-3">
                        <input type=text class="form-control" required="required" value="${article.storage}" name="storage" size="50">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-3 control-label">折扣：</label>
                    <div class="col-sm-3">
                        <input type="text" class="form-control" id="discount" required="required"  name="discount" value="${article.discount}" size="50" />
                        <span id="discountTip"><font color="red">请输入0到1之间的数值</font></span>
                    </div>
                    <label class="col-sm-3 control-label">物品封面：</label>
                    <div class="col-sm-3">
                         <input type="hidden" value="${article.image}" name="image"/>
                        <input type="file" class="form-control"  name="pic" size="40" />
                    </div>
                </div>

                <div class="form-group">
                
                     <label class="col-sm-3 control-label">供应商：</label>
                    <div class="col-sm-3">
                        <input type=text value="${article.supplier}" required="required" class="form-control" name="supplier" size="50">
                    </div>
                    
                    <label class="col-sm-3 control-label">书面描述：</label>
                    <div class="col-sm-3">
                        <textarea rows="5" cols="60" required="required"  class="form-control" name="description">${article.description}</textarea>
                    </div>
                </div>
                <table align="center">
                    <tr>
                        <td><input type="submit" class="btn btn-success btn-sm" value="提交" /></td>
                        <td>&nbsp;&nbsp;<input type="button" onclick="history.back()"  class="btn btn-danger btn-sm" data-dismiss="modal" value="返回" /></td>
                    </tr>
                </table>
            </form>
        </fieldset>
            </div>
    </div>
    <hr>

</div>
<script src="${pageContext.request.contextPath }/resources/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/bootstrap/js/bootstrap.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/taobao.js"></script>
</body>
</html>