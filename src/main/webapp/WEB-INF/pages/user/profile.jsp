<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/include/begin-html.jsp"%>
<fmt:setLocale value="${currentLocale}" />
<fmt:bundle basename="localization.msg" prefix="msg.jsp.profile.">
	<fmt:message key="profilePhoneNumber" var="profilePhoneNumberLoc" />
	<fmt:message key="profilePassword" var="profilePasswordLoc" />
	<fmt:message key="title" var="titleLoc" />
	<fmt:message key="userPhoneNumber" var="userPhoneNumberLoc" />
	<fmt:message key="userPassword" var="userPasswordLoc" />
	<fmt:message key="saveButton" var="saveButtonLoc" />
</fmt:bundle>
<fmt:bundle basename="localization.msg" prefix="msg.message.profile.">
	<fmt:message key="profileUpdate" var="profileUpdateLoc" />
</fmt:bundle>
<div align="center">
	<br>
	<div class="container">
		<br> <b>
			<div class="row" align="center">
				<div class="col-md-6">${profilePhoneNumberLoc}</div>
				<div class="col-md-6">${profilePasswordLoc}</div>
			</div>
		</b> <br>
		<div class="row" align="center">
			<div class="col-md-6">${currentUser.phoneNumber}</div>
			<div class="col-md-6">${currentUser.password}</div>
		</div>
		<br>
		<form id="profileForm" class="form-horizontal"
			action="bonjo?command=profile" method="post">
			<fieldset>

				<!-- Form Name -->
				<legend>${titleLoc}</legend>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="phoneNumber">${userPhoneNumberLoc}</label>
					<div class="col-md-4">
						<input id="phoneNumber" name="user_phone" type="text"
							placeholder="" class="form-control input-md"
							value="${currentUser.phoneNumber}">
					</div>
				</div>

				<!-- Password input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="password">${userPasswordLoc}</label>
					<div class="col-md-4">
						<input id="password" name="user_password" type="password"
							placeholder="" class="form-control input-md"
							value="${currentUser.password}">
					</div>
				</div>

				<!-- Button -->
				<div class="form-group">
					<div class="col-md-4">
						<button id="singlebutton" name="singlebutton"
							class="btn btn-primary">${saveButtonLoc}</button>
					</div>
				</div>
			</fieldset>
		</form>

		<c:if test="${not empty requestScope.profileUpdate}">
			<div class="alert alert-success" role="alert">
				<c:out value="${profileUpdateLoc}"></c:out>
			</div>
		</c:if>
	</div>
</div>
<script src="assets/js/jquery-1.9.1.js"></script>
<script src="assets/js/jquery.validate.js"></script>
<script src="assets/js/profile.validate.js"></script>
<%@ include file="/include/end-html.jsp"%>