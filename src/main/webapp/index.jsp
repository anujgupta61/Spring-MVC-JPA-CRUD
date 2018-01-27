<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MVC MySQL</title>
<style type="text/css">
fieldset {
	border: 1px solid #dedede;
}

legend {
	font-size: 20px;
	text-transform: uppercase;
}

.error {
	color: red;
}

.resltTable {
	width: 50%;
	border-collapse: collapse;
	border-spacing: 0px;
}

.resltTable td, .resltTable th {
	border: 1px solid #565454;
}
</style>
</head>
<body>
  <fieldset>
    <legend>People Input From</legend>
    <form action="savePeople" method="post">
      <table>
        <tr>
          <th>Name</th>
          <td>
            <input name="name" /> 
          </td>
          <th>Email</th>
          <td>
            <input name="email" /> 
          </td>
          <td><button type="submit">Submit</button></td>
        </tr>
      </table>
    </form>
  </fieldset>
  <br>
  <br>
	<a href="ViewPeople">View People list</a>
</body>
</html>