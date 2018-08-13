<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>

<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="do?command=Home">Bonjo</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarColor01">
            <ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link"
						href="Controller?command=main_page">Home</a></li>
<%--                 <c:if test="${user!=null && user.roles_ID==1}">
                    <mytag:menu command="EditUsers" text="Edit Users"/>
                    <mytag:menu command="CreateCategory" text="Create Category"/>
                    <mytag:menu command="EditCategory" text="Edit Category"/>
                    <mytag:menu command="ResetDB" text="Reset DB"/>
                </c:if>
                <c:if test="${user!=null && user.roles_ID==2}">
                    <mytag:menu command="CreateAd" text="Create Ad"/>
                    <mytag:menu command="MyAds" text="My Ads"/>
                </c:if>
            </ul>
            <ul class="navbar-nav navbar-right">
                <c:choose>
                    <c:when test="${user==null}">
                        <mytag:menu command="Login" text="Login"/>
                        <mytag:menu command="SignUp" text="Sign Up"/>
                    </c:when>
                    <c:otherwise>
                        <mytag:menu command="Profile" text="Profile"/>
                        <mytag:menu command="Logout" text="Logout"/>
                    </c:otherwise>
                </c:choose> --%>

            </ul>
        </div>
    </nav>
</div>
<div align="center">