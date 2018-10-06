<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags/"%>
<%@ include file="/WEB-INF/include/header.jsp"%>
<fmt:setLocale value="${currentLocale}" />
<fmt:bundle basename="localization.msg" prefix="msg.jsp.viewUsers.">
	<fmt:message key="userLogin" var="loginLoc" />
	<fmt:message key="userEmail" var="emailLoc" />
	<fmt:message key="userPassword" var="passwordLoc" />
	<fmt:message key="userNickname" var="nicknameLoc" />
	<fmt:message key="userPhoneNumber" var="phoneNumberLoc" />
	<fmt:message key="userUpdateButton" var="userUpdateButtonLoc" />
	<fmt:message key="userDeleteButton" var="userDeleteButtonLoc" />
</fmt:bundle>
<fmt:bundle basename="localization.msg" prefix="msg.message.editUser.">
	<fmt:message key="editUserError" var="editUserErrorLoc" />
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
				action="bonjo?command=viewusers" method=post>
				<div class="row">
					<input id="id" class="form-control input-md" name="user_id"
						type="hidden" value="${user.id}" />
					<%-- 			<input id="login" class="form-control input-md" name="user_login"
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
 --%>
					<div class=col-md-2>${user.login}</div>
					<div class=col-md-2>${user.email}</div>
					<div class=col-md-2>${user.password}</div>
					<div class=col-md-2>${user.nickname}</div>
					<div class=col-md-2>${user.phoneNumber}</div>

					<div class=col-md-1>
						<a href="bonjo?command=edituser&userId=${user.id}">${userUpdateButtonLoc}</a>
					</div>

					<div class=col-md-1>
						<button id="Delete" value="Delete" name="Delete"
							class="btn btn-danger">${userDeleteButtonLoc}</button>
					</div>
				</div>
			</form>
			<br>
		</c:forEach>
		<c:if test="${not empty requestScope.editUserError}">
			<div class="alert alert-danger" role="alert">
				<c:out value="${editUserErrorLoc}"></c:out>
			</div>
		</c:if>
	</div>
	<div class="row col-md-2">
		<mytag:paginator count="${usersSize}" step="8"
			urlprefix="?command=viewusers&users=" />
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>