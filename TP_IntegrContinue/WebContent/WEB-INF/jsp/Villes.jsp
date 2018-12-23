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
<title>Villes</title>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link" href="accueil">Accueil</a></li>
		<li class="nav-item"><a class="nav-link" href="distance">Distance</a></li>
		<li class="nav-item"><a class="actived" href="villes">Villes</a></li>
	</ul>
	<br />
	<!-- Message " pas de résultat" -->
	<c:if test="${empty villes}">
		<div class="alert alert-warning" role="alert">Aucune ville trouvée
		</div>
	</c:if>

	<!-- Affichage résultat -->
	<div class="container-fluid">
		<div class="row">
			<c:forEach items="${villes}" var="ville">
				<div class="col-sm-4 col-xs-4">
					<div class="card">
						<div class="card-header">
							<c:out value="${ville.nomCommune}" />
						</div>
						<div class="card-body">
							<h6 class="card-title">Résumé :</h6>
							<ul>
								<li>Code INSEE : <c:out value="${ville.codeCommune}" /></li>
								<li>Code postal : <c:out value="${ville.codePostal}" /></li>
								<li>Libellé d'acheminement : <c:out value="${ville.libelleAcheminement}" /></li>
								<c:if test="${!empty ville.complementAdresse }">
									<li>Complément d'adresse : <c:out value="${ville.complementAdresse}" /></li>
								</c:if>
								<li>Latitude : <c:out value="${ville.latitude}" /></li>
								<li>Longitude : <c:out value="${ville.longitude}" /></li>
							</ul>
						</div>
					</div>
					<br>
				</div>
			</c:forEach>
		</div>
		<br>
	</div>
</body>
</html>