	
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
	<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
   
 <style>
    h4 { color: #FFFFFF; }
  </style>
	
	<!-- header-section-starts -->
      <div class="h-top" id="home">
		   <div class="top-header">
				  <ul class="cl-effect-16 top-nag">
				  <li>
				  <security:authorize access= "isAuthenticated()"> 
							
								<h4><security:authentication var="user" property="Principal.username"/></h4>
								<img src="${pageContext.request.contextPath}/resources/images/user_default_profiles/${fn:substring(user, 0, 1)}.png" class="img-responsive"width="50" height="60" alt=""/>
								<h4><security:authentication var="user" property="Principal.username"/></h4>
								
								
								
								<form:form action="${pageContext.request.contextPath}/logout"
			  			 method="POST">
			
						<input type="submit" value="LOGOUT"/>
							</form:form>
								
							
							</security:authorize>
							</li>
							<security:authorize access="!isAuthenticated()"> <li><a href="${pageContext.request.contextPath}/addUser" data-hover="Registration">Registration</a></li> </security:authorize>
						
						<li><a href="${pageContext.request.contextPath}/" data-hover="HOME">HOME</a></li>
						
						<security:authorize access="!isAuthenticated()"> <li><a href="${pageContext.request.contextPath}/showLogin" data-hover="Login">Login</a></li> </security:authorize>
						 
						<security:authorize access="hasRole('BLOGGER')"><li><a href="${pageContext.request.contextPath}/createBlog" data-hover="Create Blog">Create Blog</a></li>
						</security:authorize>
						<security:authorize access="hasRole('BLOGGER')"><li><a href="${pageContext.request.contextPath}/myBlog" data-hover="MY BLOGS">MY BLOGS</a></li>
					</security:authorize>
				

						</ul>
						
						
					<div class="search-box">
					    <div class="b-search">
								<form:form action="${pageContext.request.contextPath}/search/">
										<input type="text" value="Search" name="searchName" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
										<input type="submit" value="">
								</form:form>
							</div>
						</div>

					<div class="clearfix"></div>
				</div>
       </div>
      