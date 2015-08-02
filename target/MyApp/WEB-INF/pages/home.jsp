<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Try</title>
<link rel="stylesheet" href="css/myCss.css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>

<body>
<header>
	<div id='hdrCont'>
		<div id='siteTitle' class='fltLeft'>XYZ Technologies</div>
		<c:choose>
    		<c:when test="${!usrLoggedIn}">
       			<div id='btnLogin' class='fltRight'><a class='lightbox_init' id='dialog_login' href='#'> LOG IN</a></div>
    		</c:when>   
    		<c:otherwise>
       			 <div id='btnLogin' class='fltRight'><a id='dialog_logout' href='<%=request.getContextPath() %>/dialog_logout'> LOG OUT</a></div>
       			 ${loginForm.username}
    		</c:otherwise>
		</c:choose>
	</div>
	
</header>
<nav><ul><li>Home</li> <li>Search</li> <li>About</li><li>Contact</li></ul></nav>

<section id="sec">
Section 1
</section>
<footer><div id='fooContnent'>Copyright © 2014 XYZ Technologies</div></footer>

<script src="js/myLightbox.js"></script>
</body>

</html>