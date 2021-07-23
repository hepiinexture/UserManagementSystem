<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="changePassword" method="post">

  <div class="container">
   	<label for="username"><b>Username :</b></label>
    <input type="text" placeholder="Enter Username" name="username" required><br/><br/>
  
    <label for="password"><b>Password :</b></label>
    <input type="password" placeholder="Enter Password" name="password" required><br/><br/>

    <label for="password"><b>Confirm Password :</b></label>
    <input type="password" placeholder="Enter Confirm Password" name="confirmPassword" required><br/><br/>

    <button type="submit">Submit</button><br/><br/>
  </div>
  ${message }
</form>
</body>
</html>