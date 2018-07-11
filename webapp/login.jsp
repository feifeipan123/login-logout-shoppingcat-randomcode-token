<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h3>用户登录</h3>
     <span style="color:red">${errorMsg}</span>
     <form action="/login" method="POST">
	           账户：<input type="text" name="username" required/><br/>
	           密码：<input type="text" name="password"/><br/>
           <input type="submit" value="朕要登录"/>
     </form>
</body>
</html>