<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
<link rel="stylesheet" href="assets/css/mystyle.css">
</head>
<body>
	<fmt:setLocale value="${currentLocale}" />
	<fmt:bundle basename="localization.msg" prefix="msg.jsp.header.">
		<fmt:message key="home" var="homeLoc" />
		<fmt:message key="editUsers" var="editUsersLoc" />
		<fmt:message key="createCategory" var="createCategoryLoc" />
		<fmt:message key="editCategory" var="editCategoryLoc" />
		<fmt:message key="createAd" var="createAdLoc" />
		<fmt:message key="usersAds" var="usersAdsLoc" />
		<fmt:message key="login" var="loginLoc" />
		<fmt:message key="signup" var="signupLoc" />
		<fmt:message key="profile" var="profileLoc" />
		<fmt:message key="logout" var="logoutLoc" />
	</fmt:bundle>
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
						href="bonjo?command=home">${homeLoc}</a></li>
					<c:if test="${currentUser!=null && currentUser.roles_ID==1}">
						<li class="nav-item active"><a class="nav-link"
							href="bonjo?command=viewusers">${editUsersLoc}</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="bonjo?command=createcategory">${createCategoryLoc}</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="bonjo?command=editcategory">${editCategoryLoc}</a></li>
					</c:if>
					<c:if test="${currentUser!=null && currentUser.roles_ID==2}">
						<li class="nav-item active"><a class="nav-link"
							href="bonjo?command=createad">${createAdLoc}</a></li>
						<li class="nav-item active"><a class="nav-link"
							href="bonjo?command=userads">${usersAdsLoc}</a></li>
					</c:if>
				</ul>
				<ul class="navbar-nav navbar-right">
					<li class="nav-item active"><a class="nav-link"
						href="bonjo?command=changelocale&locale=en_US">EN</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="bonjo?command=changelocale&locale=ru_RU">RU</a></li>
					<c:choose>
						<c:when test="${currentUser==null}">
							<li class="nav-item active"><a class="nav-link"
								href="bonjo?command=login">${loginLoc}</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="bonjo?command=signup">${signupLoc}</a></li>
						</c:when>
						<c:otherwise>
							<li class="nav-item active"><a class="nav-link"
								href="bonjo?command=profile">${profileLoc}</a></li>
							<li class="nav-item active"><a class="nav-link"
								href="bonjo?command=logout">${logoutLoc}</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</nav>
	</div>