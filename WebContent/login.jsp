<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>iNube</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap-theme.min.css">

    <link rel="stylesheet" href="css/login.css">

</head>
<body>

<div id="wrapper">

    <div class="title">
        iNube
    </div>

		<form id="loginForm" action="LoginServlet">
			<c:if test="${alertNotOk != null}">
				<div id="error">${ alertNotOk }</div>
			</c:if>
			Merchant ID: <input id="password" name="merchantId" type="password">
			<button id="login">Login</button>
		</form>
		<p>
        <a href="register.jsp">¿No eres usuario? Regístrate</a>
    </p>
    <p>
        <a href="forgetPassword.html">¿Has olvidado tu contraseña?</a>
    </p>

</div>


</body>
</html>