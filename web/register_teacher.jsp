<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<title>学工助理签到平台 V1.0</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<link href="./css/style_register.css" rel="stylesheet" type="text/css" media="all" />
</head>
<body>
	<!-- main -->
		<div class="main">
			<h1>学工助理签到平台-教工注册</h1>
			<div class="input_form">
				<form id="register_form" method="post" action="register_teacher.action" onkeypress="if(event.keyCode==13||event.which==13){ register();}">
                    <input type="hidden" name="type" value="teacher"/>
                    <input placeholder="教工号" type="text" name="username"/>
                    <input placeholder="姓名" type="text" name="name"/>
                    <input placeholder="密码" type="password" name="password" >
                    <input placeholder="再次输入密码" type="password" name="verifypassword">
                    <input placeholder="部门" type="text" name="department">
                    <input placeholder="邮箱" type="text" name="mail">
				</form>
			</div>

			<div class="ckeck-bg">
				<div class="checkbox-form">
                    <div class="check-left">
							<input onclick="location='register_student.java'" type="submit" value="助理注册">
					</div>
					<div class="check-right">
							<input onclick="register()" type="submit" value="注册">
					</div>
                    <div class="clearfix"></div>
				</div>
			</div>
            <div class="ckeck-bg">
				<p><a href="login.java">&lt;&lt;&lt;返回登陆界面</a></p>
			</div>
		</div>
		<div class="footer">
		</div>
	<!-- //main -->
    <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
    <script>
        function register() {
            login_form = document.getElementById('register_form');
            login_form.submit();
        }
    </script>
  ${msg }

</body>
</html>