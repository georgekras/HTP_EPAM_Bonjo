<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/begin-html.jsp"%>
<div align="center">
	<br>
	<div class="container">
		<br> <b>
			<div class="row" align="center">
				<div class="col-md-6">Phone Number</div>
				<div class="col-md-6">Password</div>
			</div>
		</b> <br>
		<div class="row" align="center">
			<div class="col-md-6">${user.phoneNumber}</div>
			<div class="col-md-6">${user.password}</div>
		</div>
		<br>
		<form class="form-horizontal" action="profile_action" method="post">
			<fieldset>

				<!-- Form Name -->
				<legend>Edit profile</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="PhoneNumber">Phone
						Number</label>
					<div class="col-md-4">
						<input id="PhoneNumber" name="user_phone" type="text"
							placeholder="" class="form-control input-md" required=""
							value="${user.phoneNumber}">
					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="Password">Password
						Input</label>
					<div class="col-md-4">
						<input id="Password" name="user_password" type="password"
							placeholder="" class="form-control input-md" required=""
							value="${user.password}"> <span class="help-block">(min
							5 symbols)</span>
					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<div class="col-md-4">
						<button id="singlebutton" name="singlebutton"
							class="btn btn-primary">Save</button>
					</div>
				</div>
			</fieldset>
		</form>

		<c:if test="${msg_success!=null}">
			<div class="alert alert-success" role="alert">
				<c:out value="${msg_success}"></c:out>
			</div>
		</c:if>
	</div>
</div>

<%@ include file="/include/end-html.jsp"%>