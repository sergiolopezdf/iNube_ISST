<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Registro | iNube</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap-theme.min.css">

    <link rel="stylesheet" href="css/login.css">

</head>
<body>

<div id="wrapper">

    <form id="loginForm" action="RegisterServlet" method="post">

			<c:if test="${alertOk != null}">
				<div id="success">${ alertOk }</div>
			</c:if>
			<c:if test="${alertNotOk != null}">
				<div id="error">${ alertNotOk }</div>
			</c:if>
			
			<table class="users">
            <tr>
                <th>Nombre del negocio:</th>
                <td><input name="name" type="text" class="styledInput"/></td>
            </tr>
            <tr>
                <th>Código postal:</th>
                <td><input name="cp" type="text" class="styledInput"/></td>
            </tr>
            <tr>
                <th>Merchant ID:</th>
                <td><input name="merchantId" type="password" class="styledInput"/></td>
            </tr>

        </table>
        <button id="login">Registrarse</button>
    </form>
</div>


</body>
</html>