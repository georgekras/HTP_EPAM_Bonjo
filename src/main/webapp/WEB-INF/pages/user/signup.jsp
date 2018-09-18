<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/begin-html.jsp"%>
<fmt:setLocale value="${currentLocale}" />
<fmt:bundle basename="localization.msg" prefix="msg.jsp.signup.">
	<fmt:message key="header" var="headerLoc" />
	<fmt:message key="login" var="loginLoc" />
	<fmt:message key="email" var="emailLoc" />
	<fmt:message key="password" var="passwordLoc" />
	<fmt:message key="nickname" var="nicknameLoc" />
	<fmt:message key="phoneNumber" var="phoneNumberLoc" />
	<fmt:message key="signupButton" var="signupButtonLoc" />
</fmt:bundle>
<fmt:bundle basename="localization.msg" prefix="msg.message.signup.">
	<fmt:message key="signupError" var="signupErrorLoc" />
	<fmt:message key="signupLoginTaken" var="signupLoginTakenLoc" />
	<fmt:message key="signupEmailTaken" var="signupEmailTakenLoc" />
</fmt:bundle>
<div align="center">
	<br>
	<div align="center">
		<div class="container">
			<div class="page-header">
				<h2>${headerLoc}</h2>
			</div>
			<br>
			<form id="signupForm" class="form-horizontal"
				action="bonjo?command=signup" method="post">
				<fieldset>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="login">${loginLoc}</label>
						<div class="col-md-4">
							<input id="login" name="user_login" type="text"
								title="login must be 5-15 characters" placeholder="ExampleLogin"
								class="form-control input-md">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="email">${emailLoc}</label>
						<div class="col-md-4">
							<input id="email" name="user_email" type="text"
								placeholder="example@google.com" class="form-control input-md">
						</div>
					</div>

					<!-- Password input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="password">${passwordLoc}</label>
						<div class="col-md-4">
							<input id="password" name="user_password" type="password"
								title="password must be 5-15 characters"
								placeholder="min 5 symbols" class="form-control input-md">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="nickname">${nicknameLoc}</label>
						<div class="col-md-4">
							<input id="nickname" name="user_nickname" type="text"
								placeholder="example" class="form-control input-md">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="phoneNumber">${phoneNumberLoc}</label>
						<div class="col-md-4">
							<input id="phoneNumber" name="user_phone" type="text"
								placeholder="+375297777777" class="form-control input-md">
						</div>
					</div>

					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="singlebutton"></label>
						<div class="col-md-4">
							<button id="singlebutton" name="singlebutton"
								class="btn btn-outline-primary">${signupButtonLoc}</button>
						</div>
					</div>

				</fieldset>
			</form>
			<c:if test="${not empty requestScope.signupEmailTaken}">
				<div class="alert alert-danger" role="alert">
					<c:out value="${signupEmailTakenLoc}"></c:out>
				</div>
			</c:if>
			<c:if test="${not empty requestScope.signupLoginTaken}">
				<div class="alert alert-danger" role="alert">
					<c:out value="${signupLoginTakenLoc}"></c:out>
				</div>
			</c:if>
			<c:if test="${not empty requestScope.signupError}">
				<div class="alert alert-danger" role="alert">
					<c:out value="${signupErrorLoc}"></c:out>
				</div>
			</c:if>
		</div>
	</div>
</div>
<script src="assets/js/jquery-1.9.1.js"></script>
<script src="assets/js/jquery.validate.js"></script>
<script src="assets/js/signup.validate.js"></script>
<%@ include file="/include/end-html.jsp"%>