
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<div>
 ${commentPost.body}

<form:form action="${pageContext.request.contextPath}/saveComment" modelAttribute="commentPost">


 <h5>COMMMENT:</h5>
  <input type="text" name="body">
   <input type="submit" value="comment">

</form:form>

</div>