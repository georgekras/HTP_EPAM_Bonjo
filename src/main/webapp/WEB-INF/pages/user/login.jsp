<%@ page language="java" pageEncoding="UTF-8"%>
<script src="assets/js/jquery-1.8.3.js"></script>
<script src="assets/js/jquery.validate.min.js"></script>
<script src="assets/js/login.validation.js"></script>
<%@ include file="/include/begin-html.jsp"%>
<div align="center">
	<br>
	<div class="container">
		<div class="page-header">
			<h2>Welcome back!</h2>
		</div>
		<br>
		<form id="loginForm" class="form-horizontal"
			action="bonjo?command=login" method="post">
			<fieldset>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="login">Login</label>
					<div class="col-md-4">
						<input id="login" name="user_login" type="text"
							placeholder="put your login here" class="form-control input-md">
					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="password">Password</label>
					<div class="col-md-4">
						<input id="password" name="user_password" type="password"
							placeholder="put your password here"
							class="form-control input-md">
					</div>
				</div>

				<div class="form-group">
					<label class="col-md-4 control-label" for="singlebutton"></label>
					<div class="col-md-4">
						<button id="singlebutton" name="singlebutton" type="submit"
							class="btn btn-outline-primary">Login</button>
					</div>
				</div>

			</fieldset>
		</form>

		<c:if test="${msg!=null}">
			<div class="alert alert-danger" role="alert">
				<c:out value="${msg}"></c:out>
			</div>
		</c:if>
	</div>
</div>
<%@ include file="/include/end-html.jsp"%>