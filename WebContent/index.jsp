<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<head>
    <meta charset="UTF-8">
    <title>Datos de mi negocio | iNube</title>

    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap-theme.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">


    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
      $( function() {
        $( ".datepicker" ).datepicker({
          changeMonth: true,
          changeYear: true
        });
      } );
    </script>

    <link rel="stylesheet" href="css/style.css"/>



</head>
<body>
	<div id="wrapper">
		<%@ include file="nav.jsp"%>

		<div id="contentWrapper">
			<%@ include file="mainOwnBusiness.jsp"%>
			<%@ include file="sidebar.jsp"%>
		</div>


	</div>


	<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
	<script>
		<%@ include file="graficas/graficaOcupacion.jsp"%>
		<%@ include file="graficas/graficaIngresos.jsp"%>
	</script>
</body>
</html>