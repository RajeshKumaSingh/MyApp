<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet" href="css/login.css" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<div id='dialog_login'>
<div id='dailog_bar'>
	<div id='dialog_title'>LOG IN TO XYZ</div>
	<div id='dialog_close'><a class='lightbox_close' id='dialog_login_close' href='#'>X</a></div>
</div>
<form:form method="post" action="submitLogin" id='loginForm' commandName="login" >
 	<div id='result'></div>
    <table>
    <tr>
        <td><label>USer Name </label></td>
        <td><form:input path="username" />
        <form:errors path="username" cssclass="error"></form:errors></td> 
    </tr>
    <tr>
        <td><label>Last Name</label></td>
        <td><form:input path="password" />
        <form:errors path="password" cssclass="error"></form:errors></td>
    </tr>
    
    <tr>
        <td colspan="2">
            <input type="submit" value="LOGIN"/>
        </td>
    </tr>
</table>     
</form:form>
</div>
<script src="js/myLightbox.js" ></script>
 <script src="js/myAjax.js"></script>