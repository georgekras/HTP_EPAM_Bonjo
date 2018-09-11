<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags/"%>
<%@ include file="/include/begin-html.jsp"%>
<fmt:setLocale value="${currentLocale}" />
<fmt:bundle basename="localization.msg" prefix="msg.jsp.editUsers.">
	<fmt:message key="userLogin" var="loginLoc" />
	<fmt:message key="userEmail" var="emailLoc" />
	<fmt:message key="userPassword" var="passwordLoc" />
	<fmt:message key="userNickname" var="nicknameLoc" />
	<fmt:message key="userPhoneNumber" var="phoneNumberLoc" />
	<fmt:message key="userUpdateButton" var="userUpdateButtonLoc" />
	<fmt:message key="userDeleteButton" var="userDeleteButtonLoc" />
</fmt:bundle>
<div align="center">
	<br>
	<div class="container">
		<div class="row">
			<div class=col-md-2>${loginLoc}</div>
			<div class=col-md-2>${emailLoc}</div>
			<div class=col-md-2>${passwordLoc}</div>
			<div class=col-md-2>${nicknameLoc}</div>
			<div class=col-md-2>${phoneNumberLoc}</div>
		</div>
	</div>
	<br>
	<div class="container">
		<c:forEach items="${users}" var="user">
			<form id="editusersForm" class="form-horizontal"
				action="bonjo?command=editusers" method=post>
				<div class="row">
					<input id="login" class="form-control input-md" name="user_id"
						type="hidden" value="${user.id}" />
					<div class=col-md-2>
						<input id="login" class="form-control input-md" name="user_login"
							value="${user.login}" />
					</div>
					<div class=col-md-2>
						<input id="email" class="form-control input-md" name="user_email"
							value="${user.email}" />
					</div>
					<div class=col-md-2>
						<input id="password" class="form-control input-md"
							name="user_password" value="${user.password}" />
					</div>
					<div class=col-md-2>
						<input id="nickname" class="form-control input-md"
							name="user_nickname" value="${user.nickname}" />
					</div>
					<div class=col-md-2>
						<input id="phonenumber" class="form-control input-md"
							name="user_phone" value="${user.phoneNumber}" />
					</div>
					<input id="login" class="form-control input-md"
						name="user_roles_id" type="hidden" value="${user.roles_ID}" />

					<div class=col-md-1>
						<button id="Update" value="Update" name="Update"
							class="btn btn-success">${userUpdateButtonLoc}</button>
					</div>

					<div class=col-md-1>
						<button id="Delete" value="Delete" name="Delete"
							class="btn btn-danger">${userDeleteButtonLoc}</button>
					</div>
				</div>
			</form>
			<br>
		</c:forEach>
		<c:if test="${msg!=null}">
			<div class="alert alert-success" role="alert">
				<c:out value="${msg}"></c:out>
			</div>
		</c:if>
		<c:if test="${msg_alert!=null}">
			<div class="alert alert-danger" role="alert">
				<c:out value="${msg_alert}"></c:out>
			</div>
		</c:if>
	</div>
	<div class="row col-md-2">
		<mytag:paginator count="${usersSize}" step="9"
			urlprefix="?command=editusers&users=" />
	</div>
</div>
<%@ include file="/include/end-html.jsp"%>