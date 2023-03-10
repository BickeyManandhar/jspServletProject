<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Registration  List</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>Registration  List</h2>
            
  <table class="table">
    <thead>
      <tr>
        <th>Email</th>
        <th>Name</th>
        <th>Password</th>
        <th>Contact Number</th>
      </tr>
    </thead>
    <tbody>
		<%@ page import="java.util.List, java.util.ArrayList, com.DTO.RegistrationDTO" %>
			<%
  List<RegistrationDTO> registrationList = (List<RegistrationDTO>)request.getAttribute("signuplist");
  if(registrationList==null){
	  registrationList=new ArrayList();
  }
  for(RegistrationDTO registrationDto:registrationList){
  %>
			<tr>
				<td>
					<%=registrationDto.getEmail()%>
				</td>
				<td>
					<%=registrationDto.getName()%>
				</td>
				<td>
					<%=registrationDto.getPassword()%>
				</td>
				<td>
					<%=registrationDto.getContact()%>
				</td>
			</tr>
			<%
  }%>
		</tbody>
  </table>
</div>

<h2><a href="login.jsp">Click here to Login.</a></h2>
</body>
</html>
