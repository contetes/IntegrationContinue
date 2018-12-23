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
<title>Distance</title>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link" href="accueil">Accueil</a></li>
		<li class="nav-item"><a class="actived" href="distance">Distance</a></li>
		<li class="nav-item"><a class="nav-link" href="villes">Villes</a></li>
	</ul>
	<br />
	<h1>Calculer la distance entre deux villes</h1>
	<form method="post" action="calculDistance">
		<br />
		<fieldset class="bordure">
			<legend>Entrez le nom des deux villes</legend>
			<br />
			<div class="form-group">
				<div class="row">
					<div class="col-sm">
						<label for="villeUn">Départ : <span class="requis"></span></label>
						<input type="text" id="villeUn" name="villeUn" value="" size="20"
							maxlength="60" /> *
					</div>
					<div class="col-sm">
						<label for="villeDeux">Arrivée : <span class="requis"></span>
						</label> <input type="text" id="villeDeux" name="villeDeux" value=""
							size="20" maxlength="20" /> *
					</div>
				</div>
			</div>
		</fieldset>
		<input type="submit" value="Calculer" class="subm" /> <br />
	</form>
	<br />
	<c:if test="${distance != null}">
		<fieldset class="bordure">
			<legend>Résultat</legend>
			<c:choose>
				<c:when test="${distance == erreur }">
					<p>
						<c:out value="${distance}" />
					</p>
				</c:when>
				<c:when test="${distance != erreur }">
					<p>
						La distance calculée entre les deux villes est de :
						<c:out value="${distance}" />
						km(s)
					</p>
				</c:when>
			</c:choose>
		</fieldset>
	</c:if>
</body>
</html>