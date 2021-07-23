<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div id="czContainer">
		<div id="first">
			<div class="recordset">
				<input type="text" name="_1_" id="stock" />
			</div>
		</div>
	</div>
	<input id="czContainer_czMore_txtCount" name="czContainer_czMore_txtCount" type="hidden" value="0" size="5" />
	<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="js/jquery.czMore-1.5.3.2.js"></script>
	<script type="text/javascript">
		$("#czContainer").czMore();
	</script>
</body>
</html>