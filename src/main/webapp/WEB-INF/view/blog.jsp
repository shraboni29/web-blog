


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!--banner-section-->

<div class="top-news">
		<div class="container blog-info">
		<div class="top-inner">
		<div class="col-md-12 top-text">
					 <a href="single.html"><img src="/my-blog-project/resources/images/front1.jpg" class="img-responsive" alt=""></a>
					 
					
					    <h5 class="top text-center">${bloginfo.title}</h5>
					     <i class="fa fa-quote-left" aria-hidden="true"></i>
						<p>${bloginfo.body}</p>
						 <i class="fa fa-quote-right" aria-hidden="true"></i>
					    <p class="text-right">On ${bloginfo.postDate}<br>
				 created by <b></b> ${bloginfo.username}<b></b>
				 </p>
				  
				 </div>
				 </div>
				<div class="col-md-12"  >
				<ul class="comment-section">
					<li class="write-new">

						<form:form action="${pageContext.request.contextPath}/saveComment/" modelAttribute="userComment" method="post">

							<form:textarea path="body" placeholder="Write your comment here" name="comment"/>
							<form:input type="hidden" path="postId"/>
							<form:input type="hidden" path="username" />
							<p>total comment</p>${totalComment}

							<div>
								
								<button type="submit">Submit</button>
							</div>

						</form:form>

					</li>
				</ul>
				
			<ul class="comment-section">	
			 <c:forEach var="comments" items="${commentview}">
			 	
			<li class="comment user-comment">

                <div class="info">
                    <a href="#">${comments.usercomment.username}</a>
                    <span>${comments.comment_date}</span>
                </div>

               

                <p>${comments.body}</p>

			</li>
			</c:forEach>
			</ul>
			<!--  
			<ul class="comment-section">
			<li class="write-new">

                <form:form action="${pageContext.request.contextPath}/saveComment/" modelAttribute="userComment" method="post">

                    <form:textarea path="body" placeholder="Write your comment here" name="comment"/>
					<form:input type="hidden" path="postId"/>
					<form:input type="hidden" path="username" />

                    <div>
                        
                        <button type="submit">Submit</button>
                    </div>

                </form:form>

            </li>
			</ul>
			-->
			<!--
			<security:authorize access="!isAuthenticated()">
			<c:if test="${Principal.username == bloginfo.username}">
		 <a href="${pageContext.request.contextPath}/edit/${bloginfo.postId}">edit</a>
			</c:if>
		
			</security:authorize>
			</div>
			  -->
			<!--
			
			 <form:form action="${pageContext.request.contextPath}/saveComment/" modelAttribute="userComment" method="post">

 				
 			<h5>COMMMENT:</h5>
 			
 			<h5>LEAVE A COMMENT</h5>
 			<form:textarea path="body" rows="10" cols="30"/>
  			<form:input type="hidden" path="postId"/>
  			<form:input type="hidden" path="username" />
    		<input type="submit" class="hvr-bounce-to-bottom button" value="comment">
   			</form:form>
   			</div>
   			</div>
   			</div>
			-->
			</div>
			</div>
			</div>
<div class="clearfix"> </div>
<a href="${pageContext.request.contextPath}/home" class="hvr-bounce-to-bottom button">GO TO HOME PAGE</a>
