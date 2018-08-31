<%@ page language="java" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
</head>
<body>
	<form id="loginForm" action="bonjo?command=error" method="post">
		<div class="form-group col-md-4">
			<input id="login" name="user_login" type="text"
				class="form-control input-md">
		</div>

		<div class="form-group col-md-4">
			<input id="password" name="user_password" type="password"
				class="form-control input-md">
		</div>

		<input type="submit" class="btn btn-primary" id="submit-button"
			value="Submit">
	</form>
	<script src="assets/js/jquery-1.9.1.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.validate.js"></script>
	<script src="assets/js/login.validation.js"></script>
</body>
</html>