<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="addAddress" method="post">
  <div class="container">
    <h1>Add Address</h1>
    <input type="hidden" name="addressId_0_" id="addressId" value="0">
	<input type="hidden" name="userId_0_" id="userId" value="${userId}">
			
	<label for="street"><b>Street :</b></label>
	<input type="text" placeholder="Enter Street" name="street_0_" id="street" required><br/><br/>
			
	<label for="city"><b>City :</b></label>
	<input type="text" placeholder="Enter City" name="city_0_" id="city" required><br/><br/>
	
	<label for="country"><b>Country :</b></label>
	<input type="text" placeholder="Enter Country" name="country_0_" id="country" required><br/><br/>
    <div id="czContainer">
		<div id="first">
			<div class="recordset">
				<input type="hidden" name="addressId_1_" id="addressId" value="0">
			    <input type="hidden" name="userId_1_" id="userId" value="${userId}">
			
				<label for="street"><b>Street :</b></label>
			    <input type="text" placeholder="Enter Street" name="street_1_" id="street" required><br/><br/>
			
			    <label for="city"><b>City :</b></label>
			    <input type="text" placeholder="Enter City" name="city_1_" id="city" required><br/><br/>
			
			    <label for="country"><b>Country :</b></label>
			    <input type="text" placeholder="Enter Country" name="country_1_" id="country" required><br/><br/>
			</div>
		</div>
	</div>	 
    <button type="submit">Add Address</button><br/><br/>
  </div>

</form>
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script src="js/jquery.czMore-1.5.3.2.js"></script>
<script type="text/javascript">
	$("#czContainer").czMore({
		countFieldPrefix:'_czMore_txtCount'
	});
</script>
</body>
</html>