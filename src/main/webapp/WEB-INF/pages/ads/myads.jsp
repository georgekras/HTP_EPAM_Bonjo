<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags/"%>
<%@ include file="/WEB-INF/include/header.jsp"%>
<fmt:setLocale value="${currentLocale}" />
<fmt:bundle basename="localization.msg" prefix="msg.jsp.userAds.">
	<fmt:message key="header" var="headerLoc" />
</fmt:bundle>
<div align="center">
	<br>
	<div class="container">
		<div class="page-header">
			<h2>${headerLoc}</h2>
		</div>

		<br>

		<div class="container">
			<div class="row">
				<c:forEach items="${ads}" var="ad">
					<div class=" col-md-4">
						<div class="card text-white bg-primary mb-3"
							style="max-width: 20rem;">
							<div class="card-header">
								<c:forEach items="${categories}" var="category">
									<c:if test="${category.id==ad.category_ID}">
                        ${category.name}
                    </c:if>
								</c:forEach>
							</div>
							<div class="card-body">
								<a href="bonjo?command=editad&adId=<c:out value="${ad.id}"/>"
									style="color: white;">
									<h4 class="card-title">${ad.title}</h4>
								</a>
								<p class="card-text">${ad.smallDesc}</p>
							</div>
						</div>
						<br>
					</div>
				</c:forEach>
			</div>
			<div class="row col-md-1">
				<mytag:paginator count="${adsSize}" step="9"
					urlprefix="?command=userads&ads=" />
			</div>
		</div>
		<br>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>