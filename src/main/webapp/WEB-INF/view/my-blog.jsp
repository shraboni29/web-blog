
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="top text-center">
<c:forEach var="temp" items="${bloginfo}">
<c:url var="editlink" value="/editPost">
<c:param name="postId" value="${temp.postId}" />
						 						
</c:url>
<c:url var="deletelink" value="/deleteFile">
<c:param name="postId" value="${temp.postId}" />
						 						
</c:url>
				
<h1 style="background-color:powderblue;"> <a href="${pageContext.request.contextPath}/blog/${temp.postId}">${temp.title}</a></h1>
<br>

 <i class="fa fa-quote-left" aria-hidden="true"></i>
 <p>${temp.body}</p>
<i class="fa fa-quote-right" aria-hidden="true"></i>
<br>
<a class="glyphicon glyphicon-pencil" href="${editlink}"><b>EditPost</b></a>
<br>
<a class="glyphicon glyphicon-trash" href="${deletelink}">DeletePost</a>

</c:forEach>

</div>
