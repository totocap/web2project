<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<title>Présentation</title>
</head>
<body>
<p>
		
		<c:if test="${empty name}">
			Welcome Welcome!
		</c:if>
		<c:if test="${not empty name}">
			Hello ${name}
		</c:if>
 
		
    </p>
</body>
</html>