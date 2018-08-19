<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/include/begin-html.jsp"%>

<br>
<div class="page-header">
	<h2 align="center">${ad.title}</h2>
</div>

<br>
<br>

<div class="container">
	<div class="row">
		<div class="col-md-7">
			<h4>Ad details:</h4>
			<br>
			<p>
				<b>Category: </b>
				<c:if test="${category.ID==ad.category_ID}">
                        ${category.name}
	</c:if>
			</p>
			<p>
				<b>Small Description: </b>${ad.smallDesc}</p>
			<p>
				<b>Description: </b>${ad.description}</p>
			<p>
				<b>Price: </b>${ad.price}$</p>
		</div>

		<div class="col-md-5">
			<h4>User details:</h4>
			<br>
			<p>
				<b>Nickname: </b>${user_nickname}</p>
			<p>
				<b>Phone Number: </b>${user_phone}</p>
		</div>
	</div>
</div>


<%@ include file="/include/end-html.jsp"%>