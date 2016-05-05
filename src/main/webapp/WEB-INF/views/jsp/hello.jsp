<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<title>Accueil</title>
</head>
<body>
<p>
		
		<c:if test="${empty name}">
			Bienvenue sur la page d'accueil !
			<br/>
			<a href ="https://rocky-gorge-86159.herokuapp.com/web2project/stbs"> Cliquez donc sur ce lien pour visualiser les stbs.</a>
			<hr/>
			<p> Membres du projet : Capet Thomas et Mellet David. </p>
			
		</c:if>
		<c:if test="${not empty name}">
			Hello ${name}
		</c:if>
 
		
    </p>
</body>
</html>