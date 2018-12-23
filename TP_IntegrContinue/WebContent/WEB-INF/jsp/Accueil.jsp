<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/styles/stylesheet.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="actived" href="accueil">Accueil</a></li>
		<li class="nav-item"><a class="nav-link" href="distance">Distance</a></li>
		<li class="nav-item"><a class="nav-link" href="villes">Villes</a></li>
	</ul>
	<br/>
	<div>
	<h5>Site développé par Estelle Contet</h5>
	<br/>
	<p class="begin">Pour calculer la distance entre deux villes, cela se passe dans l'onglet "Distance"</p>
	<p class="begin">Pour afficher les données stockées dans la bdd, allez dans l'onglet "Villes" </p>
	</div>
	
</body>
</html>