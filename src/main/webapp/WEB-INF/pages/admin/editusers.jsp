<%@ page contentType="text/html;charset=UTF-8" language="java"
	pageEncoding="UTF-8"%>
<%@ include file="/include/begin-html.jsp"%>
<div align="center">
	<br>
	<div class="container">
		<div class="row">
			<div class=col-md-2>Login</div>
			<div class=col-md-2>Email</div>
			<div class=col-md-2>Password</div>
			<div class=col-md-2>Nickname</div>
			<div class=col-md-2>Phone Number</div>
		</div>
	</div>
	<br>
	<div class="container">
		<c:forEach items="${user_list}" var="user">
			<form class="form-horizontal" action="edit_users_action" method=post>
				<div class="row">
					<input id="login" class="form-control input-md" name="user_id"
						type="hidden" value="${user.ID}" />
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
							class="btn btn-success">Update</button>
					</div>

					<div class=col-md-1>
						<button id="Delete" value="Delete" name="Delete"
							class="btn btn-danger">Delete</button>
					</div>
				</div>
			</form>
			<br>
		</c:forEach>
		<c:if test="${msg_success!=null}">
			<div class="alert alert-success" role="alert">
				<c:out value="${msg_success}"></c:out>
			</div>
		</c:if>
		<c:if test="${msg!=null}">
			<div class="alert alert-danger" role="alert">
				<c:out value="${msg}"></c:out>
			</div>
		</c:if>
	</div>
</div>
<%@ include file="/include/end-html.jsp"%>