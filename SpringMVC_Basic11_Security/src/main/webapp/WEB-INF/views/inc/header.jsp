<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"         uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="security"  uri="http://www.springframework.org/security/tags" %>
<div id="header">
	<div class="top-wrapper">
		<h1 id="logo">
			<a href="/"><img src="" alt="로고" /></a>
		</h1>
		<h2 class="hidden">메인메뉴</h2>
		<ul id="mainmenu" class="block_hlist">
			<li><a href="">kosa가이드</a></li>
			<li><a href="">kosa과정</a></li>
			<li><a href="">kosa</a></li>
		</ul>
		<form id="searchform" action="" method="get">
			<fieldset>
				<legend class="hidden"> 과정검색폼 </legend>
				<label for="query">과정검색</label> <input type="text" name="query" />
				<input type="submit" class="button" value="검색" />
			</fieldset>
		</form>
		<h3 class="hidden">로그인메뉴</h3>
		<ul id="loginmenu" class="block_hlist">
			<li><a href="${pageContext.request.contextPath}/index.htm">HOME</a></li>
			
			<%--
			EL & JSTL
			 <c:if test="${empty pageContext.request.userPrincipal}">
    				<li><a href="${pageContext.request.contextPath}/joinus/login.htm">로그인</a></li>
 			</c:if>
			<c:if test="${not empty pageContext.request.userPrincipal}">
    				<li><a href="${pageContext.request.contextPath}/logout">(${pageContext.request.userPrincipal.name})로그아웃</a></li>
 			</c:if>
			 --%>
			
			<!-- Spring security tags lib 사용하기 
			1. 회원가입시 모든 회원은 default ROLE_USER 권한
			 -->
			<security:authorize access="!hasRole('ROLE_USER')"><!-- 인증되지 않았다면, 로그인 하지 않았다면  -->
			 	<li><a href="${pageContext.request.contextPath}/joinus/login.htm">로그인</a></li>
			</security:authorize>
			
			<!-- 인증이 성공되면 Spring 내부적으로 userPrincipal 객체의 name 속성에 인증값(id >> name)  -->
			<security:authentication property="name" var="loginuser" />
			<!-- loginuser 변수에 인증된 name(id) 있어요  -->
			
			<!-- Any -> OR   ROLE_USER 또는 ROLE_ADMIN 라면 -->
			
			<security:authorize access="hasAnyRole('ROLE_USER','ROLE_ADMIN')"> 
					<li><a href="${pageContext.request.contextPath}/logout">${loginuser}:로그아웃</a></li>
			</security:authorize>
			
			<li><a href="${pageContext.request.contextPath}/joinus/join.htm">회원가입</a></li>
		</ul>
		<h3 class="hidden">회원메뉴</h3>
		<ul id="membermenu" class="clear">
			<li><a href=""><img src="${pageContext.request.contextPath}/images/menuMyPage.png" alt="마이페이지" /></a>
			</li>
			<li><a href="${pageContext.request.contextPath}/customer/notice.htm">
			    <img src="${pageContext.request.contextPath}/images/menuCustomer.png" alt="고객센터" /></a></li>
		</ul>
	</div>
</div>