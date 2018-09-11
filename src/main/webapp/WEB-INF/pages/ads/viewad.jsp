<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/include/begin-html.jsp"%>
<fmt:setLocale value="${currentLocale}" />
<fmt:bundle basename="localization.msg" prefix="msg.jsp.viewAd.">
	<fmt:message key="adDetails" var="adDetailsLoc" />
	<fmt:message key="adCategory" var="categoryLoc" />
	<fmt:message key="adSmallDesc" var="smallDescLoc" />
	<fmt:message key="adDescription" var="descriptionLoc" />
	<fmt:message key="adPrice" var="priceLoc" />
	<fmt:message key="userDetails" var="userDetailsLoc" />
	<fmt:message key="userNickname" var="userNicknameLoc" />
	<fmt:message key="userPhoneNumber" var="userPhoneNumberLoc" />
</fmt:bundle>
<br>
<div class="page-header">
	<h2 align="center">${ad.title}</h2>
</div>

<br>
<br>

<div class="container">
	<div class="row">
		<div class="col-md-7">
			<h4>${adDetailsLoc}</h4>
			<br>
			<p>
				<b>${categoryLoc}</b>
				<c:if test="${category.id==ad.category_ID}">
                        ${category.name}
	</c:if>
			</p>
			<p>
				<b>${smallDescLoc}</b>${ad.smallDesc}</p>
			<p>
				<b>${descriptionLoc}</b>${ad.description}</p>
			<p>
				<b>${priceLoc}</b>${ad.price}$</p>
		</div>

		<div class="col-md-5">
			<h4>${userDetailsLoc}</h4>
			<br>
			<p>
				<b>${userNicknameLoc}</b>${user_nickname}</p>
			<p>
				<b>${userPhoneNumberLoc}</b>${user_phone}</p>
		</div>
	</div>
</div>


<%@ include file="/include/end-html.jsp"%>