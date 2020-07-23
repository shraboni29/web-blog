
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!--banner-section-->
<div class="banner-section">
   <h3 class="tittle">General <i class="glyphicon glyphicon-picture"></i></h3>
    <div class="banner">
	  <div  class="callbacks_container">
		<ul class="rslides" id="slider4">
		       
				<li>
				 <a href="#"></a><img src="${pageContext.request.contextPath}/resources/images/front2.jpg" class="img-responsive" alt="" /></a>
				</li>
		</ul>
	</div>
		<!--banner-->
		
			<script src="${pageContext.request.contextPath}/resources/js/responsiveslides.min.js"></script>
	<script>
	   // You can also use "$(window).load(function() {"
	   $(function () {
	     // Slideshow 4
	     $("#slider4").responsiveSlides({
	       auto: true,
	       pager:true,
	       nav:true,
	       speed: 500,
	       namespace: "callbacks",
	       before: function () {
	         $('.events').append("<li>before event fired.</li>");
	       },
	       after: function () {
	         $('.events').append("<li>after event fired.</li>");
	       }
	     });
	
	   });
	 </script>
	 
				 <div class="clearfix"> </div>
	 </div>
	<div class="top-news">
		<div class="top-inner">
			<c:forEach var="temp" items="${posts}">
			  <c:url var="updatelink" value="/editPost">
						<c:param name="postId" value="${temp.postId}" />
						 
						
						
					</c:url>
				
				
				<div class="col-md-6 top-text">
					 <a><img src="/my-blog-project/resources/images/front1.jpg" class="img-responsive" alt=""></a>
					    <h5 class="top"><a href="${pageContext.request.contextPath}/blog/${temp.postId}">${temp.title}</a></h5>
						<c:set var="blogBody" value="${temp.body}"/>
    				    <c:set var="blogShortBody" value="${fn:substring(blogBody, 0, 120)}" />
    				   <i class="fa fa-quote-left" aria-hidden="true"></i>
    					<p>${blogShortBody}...</p>
    					
					    <p>On ${temp.postDate}<a class="span_link" href="${pageContext.request.contextPath}/blog/${temp.postId}">
					    			<span class="glyphicon glyphicon-comment"></span>
					    			<c:if test="${temp.commentEList != null}">
										${temp.commentEList.size()}
									</c:if>
									<c:if test="${temp.commentEList == null}">
										0
									</c:if>
					    			</a>
					    			
					    			
					    			
					    			<a class="span_link" href="${pageContext.request.contextPath}/blog/${temp.postId}"><span class="glyphicon glyphicon-circle-arrow-right"></span></a></p>
				 created by ${temp.username}
			
				 <br>
				 
				 </div>					 
			</c:forEach>
		</div>	
	</div>	
</div>  
<div class="clearfix"> </div>
						<!--  <div>	
											write a comment 
						<a href="${pageContext.request.contextPath}/createComment" >comment</a>
					
						</div>
						-->
						
