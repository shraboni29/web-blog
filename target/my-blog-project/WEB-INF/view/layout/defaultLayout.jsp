<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
    
<!DOCTYPE HTML>
<html>
<head>
<title><tiles:getAsString name="title" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Blogger Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android  Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href='//fonts.googleapis.com/css?family=Open+Sans:700,700italic,800,300,300italic,400italic,400,600,600italic' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!--Custom-Theme-files-->
    
    <style type="text/css">
.error {color: red;
}
</style>
    
    
    <!--  <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">-->

	<link href="${pageContext.request.contextPath}/resources/css/style.css" rel='stylesheet' type='text/css' />	
		<link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel='stylesheet' type='text/css'/>	
		<link href="${pageContext.request.contextPath}/resources/css/font-awesome.css"rel='stylesheet' type='text/css' />
	<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"> </script>
	<script src="${pageContext.request.contextPath}/resources/js/heartButton.js"> </script>
	
	<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"> </script>
<!--/script-->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/move-top.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/easing.js"></script>
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
				});
			});
</script>

</head>
<body>
 <header id="header">
            <tiles:insertAttribute name="header" />
        </header>
     
       
             
        <section id="site-content">
            <tiles:insertAttribute name="body" />
        </section>
         
        <footer id="footer">
            <tiles:insertAttribute name="footer" />
        </footer>
</body>
</html>