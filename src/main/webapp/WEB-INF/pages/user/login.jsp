<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/begin-html.jsp"%>
<div align="center">
	<br>
	<div class="container">
		<div class="page-header">
			<h2>Welcome back!</h2>
		</div>
		<br>
		<form class="form-horizontal" action="login_action" method="post">
			<fieldset>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="Login">Login</label>
					<div class="col-md-4">
						<input id="Login" name="user_login" type="text"
							placeholder="put your login here" class="form-control input-md"
							required=""> <span class="help-block">Login (hint)</span>
					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="Password">Password</label>
					<div class="col-md-4">
						<input id="Password" name="user_password" type="password"
							placeholder="put your password here"
							class="form-control input-md" required=""> <span
							class="help-block">(min 5 symbols)</span>
					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="singlebutton"></label>
					<div class="col-md-4">
						<button id="singlebutton" name="singlebutton"
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