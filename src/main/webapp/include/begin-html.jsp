<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
			<a class="navbar-brand" href="bonjo?command=home">Bonjo</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarColor01">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"
						href="bonjo?command=home">Home</a></li>
					<c:if test="${currentUser!=null && currentUser.roles_ID==1}">
						<li class="nav-item active"><a class="nav-link"
							href="bonjo?command=edit_users">Edit Users</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="bonjo?command=create_category">Create Category</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="bonjo?command=edit_category">Edit Category</a></li>
					</c:if>
					<c:if test="${currentUser!=null && currentUser.roles_ID==2}">
						<li class="nav-item active"><a class="nav-link"
							href="bonjo?command=createad">Create Ad</a></li>
<!-- 						<li class="nav-item active"><a class="nav-link"
							href="bonjo?command=user_ads">My Ads</a></li> -->
					</c:if>
				</ul>
				<ul class="navbar-nav navbar-right">
					<c:choose>
						<c:when test="${currentUser==null}">
							<li class="nav-item active"><a class="nav-link"
								href="bonjo?command=login">Login</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="bonjo?command=signup">Sign Up</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item active"><a class="nav-link"
								href="bonjo?command=profile">Profile</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="bonjo?command=logout">Logout</a></li>
						</c:otherwise>
					</c:choose>

				</ul>
			</div>
		</nav>
	</div>
	<div align="center">