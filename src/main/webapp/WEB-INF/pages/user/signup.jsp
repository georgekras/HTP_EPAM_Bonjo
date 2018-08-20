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
			<form class="form-horizontal" action="bonjo?command=signup"
				method="post">
				<fieldset>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="login">Login</label>
						<div class="col-md-4">
							<input id="login" name="user_login" type="text"
								title="login must be 5-15 characters" placeholder="ExampleLogin"
								class="form-control input-md" required="">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="email">Email</label>
						<div class="col-md-4">
							<input id="email" name="user_email" type="text"
								placeholder="example@google.com" class="form-control input-md"
								required="">
						</div>
					</div>

					<!-- Password input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="password">Password</label>
						<div class="col-md-4">
							<input id="password" name="user_password" type="password"
								title="password must be 5-15 characters"
								placeholder="min 5 symbols" class="form-control input-md"
								required="">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="nickname">Nickname</label>
						<div class="col-md-4">
							<input id="nickname" name="user_nickname" type="text"
								placeholder="example" class="form-control input-md" required="">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="phoneNumber">Phone
							Number</label>
						<div class="col-md-4">
							<input id="phoneNumber" name="user_phone" type="text"
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