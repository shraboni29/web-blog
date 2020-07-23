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
					 
					   
					<form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data">
     			 <input type="file" name="files" multiple>
     			 <input type="submit" value="Upload Files"></input>
  	
  	
  					 </form>
  					 
					
					<form:form action="${pageContext.request.contextPath}/saveBlog" modelAttribute="bloginfo">
					
					<form:hidden path="username"/>
						<form:hidden path="postId"/>
					
				
					
					<div class="sign-u">
						<div class="sign-up1">
							<h4 class="a">BLOG TITLE* :</h4>
						</div>
						<div class="sign-up2">
						<form:errors path="title" cssClass="error" />
							<form:input path="title" placeholder="title (*)"/>

							
							
			<!--  <input type="text" class="text" value="Name" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Name';}">-->

							
						</div>
						<div class="clearfix"> </div>
					</div>
					
					
					<div class="sign-u">
						<div class="sign-up1">
							<h4 class="b">BLOG* :</h4>
						</div>
						<div class="sign-up2">
							
									<form:errors path="body" cssClass="error" />
							<form:input path="body" placeholder="body (*)" class="text"/>

							
						</div>
						<div class="clearfix"> </div>
					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4 class="a">Attach file* :</h4>
						</div>
						<div class="sign-up2">
						
							<input type="file" />
							
						</div>
						<div class="clearfix"> </div>
					</div>
					
					
					
					
						
					 
					
						<input type="submit" value="Submit">
					</form:form>
				</div>
			</div>
<!-- //register -->
