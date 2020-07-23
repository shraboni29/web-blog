	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    <style type="text/css">
.error {color: red;
}
</style>
	<!-- register -->
	
			<div class="sign-up-form">
			
				 <h3 class="tittle">START YOUR FIRST BLOG <i class="glyphicon glyphicon-file"></i></h3>
					
				<div class="sign-up">
					 <h3 class="tittle reg">Submit All Information <i class="glyphicon glyphicon-user"></i></h3>
					
					<form:form action="${pageContext.request.contextPath}/saveUser" modelAttribute="users1" method="get">
					
					<div class="sign-u">
						<div class="sign-up1">
							<h4 class="a">First Name* :</h4>
						</div>
						<div class="sign-up2">
						<form:errors path="firstName" cssClass="error" />
							<form:input path="firstName" placeholder="firstname (*)"/>

							
							
			

							
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4 class="b">Last Name* :</h4>
						</div>
						<div class="sign-up2">
							
									<form:errors path="lastName" cssClass="error" />
							<form:input path="lastName" placeholder="lastname (*)" class="text"/>

							
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4 class="c">Email Address* :</h4>
						</div>
						<div class="sign-up2">
						<form:errors path="email" cssClass="error" />
							<form:input path="email" placeholder="Email Address (*)" class="text"/>

							
							
								

							
						</div>
						<div class="clearfix"> </div>
					</div>
					 <div class="sign-u">
						<div class="sign-up1">
							<h4>Username* :</h4>
						</div>
						<div class="sign-up2">
							
	
						<form:errors path="username" cssClass="error" />
		<form:input path="username" placeholder="User Name (*)" class="text"/>

							
						</div>
						
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4 class="d">Password* :</h4>
						</div>
						<div class="sign-up2">
							
								<form:errors path="password" cssClass="error" />
		<form:input type="password" path="password" placeholder="Password (*)" class="password"/>

							
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4>Confirm Password* :</h4>
						</div>
						<div class="sign-up2">
							
								<form:errors path="matchingPassword" cssClass="error" />
		<form:input path="matchingPassword" type="password" placeholder="Confirm Password (*)" class="password"/>
							
						</div>
						
						
						<div class="clearfix"> </div>
					</div>
					
					
						<div class="sign-u">
						<div class="sign-up1">
							<h4>You want to written an blogs* :</h4>
						</div>
						<div class="sign-up2">
						<br>
						<label>YES</label>
						<form:radiobutton path="role" value="BLOGGER" />
						<label>NO</label>
						<form:radiobutton path="role" value="VIEWER" />
							
						</div>
						
						
						<div class="clearfix"> </div>
					</div>
					 
					
						<input type="submit" value="Submit">
					</form:form>
				</div>
			</div>
<!-- //register -->
