<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
	<!-- login-page -->
	<div class="login">
		<div class="login-grids">
			<div class="col-md-6 log">
					 <h3 class="tittle">Login <i class="glyphicon glyphicon-lock"></i></h3>
					 <p>Welcome, please enter the following to continue.</p>
					 <p>If you have previously Login with us, <a href="#">click here</a></p>
					<form:form action="${pageContext.request.contextPath}/authenticateTheUser"
			   method="POST">
			   <c:if test="${param.error != null}">
		<h3>
			 invalid username/password...
			</h3>
		</c:if>
						 <h5>User Name:</h5>	
						<input type="text"  name="username"/>
						 <h5>Password:</h5>
						 <input type="password" name="password">					
						 <input type="submit" value="Login">
						  
					 </form:form>
					
			</div>
			<div class="col-md-6 login-right">
					 <h3 class="tittle">New Registration <i class="glyphicon glyphicon-file"></i></h3>
					<p>By creating an account , you will be able to writing an Blogs.</p>
					<a href="addUser" class="hvr-bounce-to-bottom button">Create An Account</a>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
