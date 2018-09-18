<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/begin-html.jsp"%>
<fmt:setLocale value="${currentLocale}" />
<fmt:bundle basename="localization.msg" prefix="msg.jsp.login.">
	<fmt:message key="header" var="headerLoc" />
	<fmt:message key="login" var="loginLoc" />
	<fmt:message key="password" var="passwordLoc" />
	<fmt:message key="buttonLogin" var="buttonLoginLoc" />
</fmt:bundle>
<fmt:bundle basename="localization.msg" prefix="msg.message.login.">
	<fmt:message key="loginError" var="loginErrorLoc" />
	<fmt:message key="loginDuplication" var="loginDuplicationLoc" />
</fmt:bundle>
<div align="center">
	<br>
	<div class="container">
		<div class="page-header">
			<h2>${headerLoc}</h2>
		</div>
		<br>
		<form id="loginForm" class="form-horizontal"
			action="bonjo?command=login" method="post">
			<fieldset>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="login">${loginLoc}</label>
					<div class="col-md-4">
						<input id="login" name="user_login" type="text"
							placeholder="put your login here" class="form-control input-md">
					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="password">${passwordLoc}</label>
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
							class="btn btn-outline-primary">${buttonLoginLoc}</button>
					</div>
				</div>

			</fieldset>
		</form>

		<c:if test="${not empty requestScope.loginError}">
			<div class="alert alert-danger" role="alert">
				<c:out value="${loginErrorLoc}"></c:out>
			</div>
		</c:if>
		<c:if test="${not empty requestScope.loginDuplication}">
			<div class="alert alert-danger" role="alert">
				<c:out value="${loginDuplicationLoc}"></c:out>
			</div>
		</c:if>
	</div>
</div>
<script src="assets/js/jquery-1.9.1.js"></script>
<script src="assets/js/jquery.validate.js"></script>
<script src="assets/js/login.validate.js"></script>
<%@ include file="/include/end-html.jsp"%>