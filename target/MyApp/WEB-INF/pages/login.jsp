<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%-- <form id="form" method="get">
    <select id="selected" name="selected">
        <option value="1">First value</option>
        <option value="2">Second value</option>
    </select>
     <input type="submit" value="SELECTED"/>
</form> --%>
<form:form method="post" action="submitLogin" commandName="login" >
 
    <table>
    <tr>
        <td><form:label path="username">USer Name </form:label></td>
        <td><form:input path="username" /></td> 
    </tr>
    <tr>
        <td><form:label path="password">Last Name</form:label></td>
        <td><form:input path="password" /></td>
    </tr>
    
    <tr>
        <td colspan="2">
            <input type="submit" value="LOGIN"/>
        </td>
    </tr>
</table>  
     
</form:form>
</body>
</html>