<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
   <head>
   <title>Person Create/Update</title>
   </head>
   <body>
	<br/>
		<h3><font color="blue">${resultmsg}</font></h3>
	<br/>
	<br/>
		<h3><font color="red"><form:errors path="person.*"></form:errors></font></h3>
	<br/>	
	<form:form method="POST" action="saveperson" modelAttribute="person">
		<form:hidden path="pk" />
		<table>
                <tr>
                    <td>First Name</td>
                    <td><form:input path="firstName"/>&nbsp;<font color="red"><form:errors path="firstName"></form:errors></font></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><form:input path="lastName"/>&nbsp;<font color="red"><form:errors path="lastName"></form:errors></font></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Save Person"/></td>
                </tr>
		</table>
	</form:form>
	

   </body>
</html>