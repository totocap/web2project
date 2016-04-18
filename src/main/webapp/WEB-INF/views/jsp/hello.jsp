<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<title>Présentation</title>
</head>
<body>
<p>
		
		<c:if test="${empty name}">
			Bienvenu sur la page d'accueil!
			<br/>
			<a href ="http://localhost:8080/web2project/stbs"> Cliquez donc sur ce lien pour visualiser les stbs.</a>
			<hr/>
			<p> membres du projet : Capet Thomas et Mellet David. </p>
			
		</c:if>
		<c:if test="${not empty name}">
			Hello ${name}
		</c:if>
 
		
    </p>
</body>
</html>