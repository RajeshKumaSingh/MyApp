<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>

	<title>Try</title>
	<link rel="stylesheet" href="css/myCss.css" />
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
	<style>
		thead {color:green;}
		tbody {color:blue;}
		table, th, td {
		    border: 1px solid black;
		}
	</style>
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
<form:form modelAttribute="form" method="post">
	<table id="mapping">	
		<thead>
	    	<tr>
	    		<th>Check Box</th>
	    		<th>Savings</th>
	    	
	    	</tr>
	   </thead>
	  
	  <tbody id="mappingBody">
	    <c:forEach items="${form.mapping }" var="map" varStatus="mapStatus" >
	    <tr>
	    	<td>
	    		<form:checkbox path="selected"/>
	    	</td>
	    	<td><form:input path="mapping[${mapStatus.index}]" />
	    		<form:hidden path="values[${mapStatus.index}]"/>
	    	</td>
	    </tr>
	    </c:forEach>
	  </tbody>
	  
	</table>
	<button type="button" onclick="duplicateRows()" >Copy Row</button>
	<button type="button" onclick="addRow()" >Add Row</button>
	<br />
	<input type="submit" value="Submit" />
	

</form:form>
</section>
<footer><div id='fooContnent'>Copyright © 2014 XYZ Technologies</div></footer>

<script src="js/myLightbox.js"></script>
</body>
<script type="text/javascript">

function duplicateRows(){

	alert(" No check box"); 
	var table = document.getElementById('mapping'); //html table

 	var rowCount = table.rows.length; //no. of rows in table

 	var columnCount =  table.rows[0].cells.length; //no. of columns in table 
 
 	for(var i=0; i < rowCount ; i++){
 		var row = table.rows[i];
           var node=row.cloneNode(true); r
 		   table.appendChild(node);
 	}  

}

 function addRow(){
// alert(" add Row Called ");  

 var table = document.getElementById('mapping'); //html table

 var rowCount = table.rows.length; //no. of rows in table

 var columnCount =  table.rows[0].cells.length; //no. of columns in table         

 var row = table.insertRow(rowCount); //insert a row   
 
	 var cell = row.insertCell(0);
 	var element1 = document.createElement("input");
 	element1.type = "checkbox";
 	element1.value="false";
 	element1.name='selected';
 	cell.appendChild(element1); 
 
 for(var i=1;i<columnCount;i++){
 	var cell = row.insertCell(i);
 	var element1 = document.createElement("input");
 	element1.type = "text";
 	element1.value="Data : 5";
 	element1.name = "mapping[5]";
 	element1.setAttribute('id', 'mapping6');
 	cell.appendChild(element1);
 }  
 }
 
 
 </script>
</html>