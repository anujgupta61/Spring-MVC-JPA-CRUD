<%-- 
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    --%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View People list</title>
<script>
	function enableFields(index, id) {
		if(document.getElementById("name" + index).disabled){
			document.getElementById("name" + index).disabled = false;
			document.getElementById("email" + index).disabled = false;
		} else {
			var name = document.getElementById("name" + index).value;
			var email = document.getElementById("email" + index).value;
			//window.location.replace("updatePeople/" + id + "/name/" + name + "/email/" + email);
			var emailFull = email.split(".");
			var emailPrefix = emailFull[0], emailSuffix = emailFull[1];	
			window.location.href = "http://localhost:8080/HelloWorldJavaConfig/updatePeople/" + id + "/" + name + "/" + emailPrefix + "/" + emailSuffix;
		}
	}
</script>
</head>
<body>
	<fieldset>
    <legend>People List</legend>
    <table class="resltTable">
      <c:forEach items="${peopleList}" var="people" varStatus="loop">
        <tr>
	        <td>
	        	<form>
				 	<input type="text" id='id${loop.index}' name="id" value="${people.id}" disabled>&nbsp;&nbsp;&nbsp;
				 	<input type="text" id='name${loop.index}' name="name" value="${people.name}" disabled>&nbsp;&nbsp;&nbsp;
				 	<input type="text" id='email${loop.index}' name="email" value="${people.email}" disabled>&nbsp;&nbsp;&nbsp;
				</form>
			</td>
			<td>
				<a href="deletePeople/${people.id}">Delete</a>
			</td>
			<td>
				<a href="javascript:void(0);" onclick="enableFields(${loop.index}, ${people.id});">Update</a>
			</td>
        </tr>
      </c:forEach>
    </table>
  </fieldset>
  <a href="Home">Home</a>
</body>
</html>