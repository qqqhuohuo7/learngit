<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import= "ss.ctl.*,ss.fun.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	//alert("loading");
	exam();
});
function exam(){
	$.post("/exam_3/test/exam?"+Math.random(),function(data){
		if(data>"0"){
			$("#login").hide();
			$("#logout").show();
		}else{
			$("#login").show();
			$("#logout").hide();
		}
    });
}
function login(){
	var param = {
		"name":$("#name").val(),
		"passwd":$("#passwd").val()
	};
	$.post("/exam_3/test/login?"+Math.random(),param,function(data){
        //exam();
        self.location.reload();
    });
}
function logout(){
	$.post("/exam_3/test/logout?"+Math.random(),function(){
		//exam();
		self.location.reload();
	});
}
</script>
</head>
<body style="font-family:微软雅黑">
<%LoginController logctl = new LoginController();
String status = logctl.logStatus(session);%>
<p><%=status %></p>
	<div id = "login">
		name:<input id="name" value=""/>
		passwd:<input id="passwd" value=""/><br>
		<p><button onclick = "login()">login</button></p>
	</div>
	<div id = "logout">
		<button onclick = "logout()">logout</button>
	</div>
</body>
</html>