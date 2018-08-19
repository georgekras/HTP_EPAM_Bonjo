<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/begin-html.jsp"%>
<div align="center">
	<br>
	<div align="center">
		<div class="container">
			<div class="page-header">
				<h2>Hello new Bonjo user!</h2>
			</div>
			<br>
			<form class="form-horizontal" action="signup_action" method="post">
				<fieldset>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="Login">Login</label>
						<div class="col-md-4">
							<input id="Login" name="user_login" type="text"
								pattern="[A-Za-z0-9]{5-15}"
								title="login must be 5-15 characters" placeholder="ExampleLogin"
								class="form-control input-md" required="">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="Email">Email</label>
						<div class="col-md-4">
							<input id="Email" name="user_email" type="text"
								placeholder="example@google.com" class="form-control input-md"
								required="">
						</div>
					</div>

					<!-- Password input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="Password">Password</label>
						<div class="col-md-4">
							<input id="Password" name="user_password" type="password"
								pattern="[A-Za-z0-9]{5-15}"
								title="password must be 5-15 characters"
								placeholder="min 5 symbols" class="form-control input-md"
								required="">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="Nickname">Nickname</label>
						<div class="col-md-4">
							<input id="Nickname" name="user_nickname" type="text"
								placeholder="example" class="form-control input-md" required="">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="PhoneNumber">Phone
							Number</label>
						<div class="col-md-4">
							<input id="PhoneNumber" name="user_phone" type="text"
								placeholder="+375297777777" class="form-control input-md"
								required="">
						</div>
					</div>

					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="singlebutton"></label>
						<div class="col-md-4">
							<button id="singlebutton" name="singlebutton"
								class="btn btn-outline-primary">Sign Up</button>
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