<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp"%>
<fmt:setLocale value="${currentLocale}" />
<fmt:bundle basename="localization.msg" prefix="msg.jsp.editUser.">
	<fmt:message key="header" var="headerLoc" />
	<fmt:message key="userLogin" var="loginLoc" />
	<fmt:message key="userEmail" var="emailLoc" />
	<fmt:message key="userPassword" var="passwordLoc" />
	<fmt:message key="userNickname" var="nicknameLoc" />
	<fmt:message key="userPhoneNumber" var="phoneNumberLoc" />
	<fmt:message key="userUpdateButton" var="updateButtonLoc" />
</fmt:bundle>
<fmt:bundle basename="localization.msg" prefix="msg.message.editUser.">
	<fmt:message key="editUserError" var="editUserErrorLoc" />
	<fmt:message key="editUserUpdate" var="editUserUpdateLoc" />
</fmt:bundle>
<div align="center">
	<br>
	<div align="center">
		<div class="container">
			<div class="page-header">
				<h2>${headerLoc}${user.nickname}</h2>
			</div>
			<br>
			<form id="signupForm" class="form-horizontal"
				action="bonjo?command=edituser&userId=${user.id}" method="post">
				<fieldset>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="login">${loginLoc}</label>
						<div class="col-md-4">
							<input id="login" name="user_login" type="text"
								value="${user.login}" class="form-control input-md">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="email">${emailLoc}</label>
						<div class="col-md-4">
							<input id="email" name="user_email" type="text"
								value="${user.email}" class="form-control input-md">
						</div>
					</div>

					<!-- Password input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="password">${passwordLoc}</label>
						<div class="col-md-4">
							<input id="password" name="user_password" type="text"
								value="${user.password}" class="form-control input-md">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="nickname">${nicknameLoc}</label>
						<div class="col-md-4">
							<input id="nickname" name="user_nickname" type="text"
								value="${user.nickname}" class="form-control input-md">
						</div>
					</div>

					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="phoneNumber">${phoneNumberLoc}</label>
						<div class="col-md-4">
							<input id="phoneNumber" name="user_phone" type="text"
								value="${user.phoneNumber}" class="form-control input-md">
						</div>
					</div>

					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="singlebutton"></label>
						<div class="col-md-4">
							<button id="singlebutton" name="singlebutton"
								class="btn btn-outline-primary">${updateButtonLoc}</button>
						</div>
					</div>

				</fieldset>
			</form>
			<c:if test="${not empty requestScope.editUserUpdate}">
				<div class="alert alert-danger" role="alert">
					<c:out value="${editUserUpdateLoc}"></c:out>
				</div>
			</c:if>
			<c:if test="${not empty requestScope.editUserError}">
				<div class="alert alert-danger" role="alert">
					<c:out value="${editUserErrorLoc}"></c:out>
				</div>
			</c:if>
		</div>
	</div>
</div>
<script src="/WEB-INF/assets/js/jquery-1.9.1.js"></script>
<script src="/WEB-INF/assets/js/jquery.validate.js"></script>
<script src="/WEB-INF/assets/js/signup.validate.js"></script>
<%@ include file="/WEB-INF/include/footer.jsp"%>