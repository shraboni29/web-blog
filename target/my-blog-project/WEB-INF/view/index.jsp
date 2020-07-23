	
	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
		<!--banner-section-->
		<div class="banner-section">
		   <h3 class="tittle">General <i class="glyphicon glyphicon-picture"></i></h3>
			<div class="banner">
                 <div  class="callbacks_container">
					<ul class="rslides" id="slider4">
					       <li>
							  <img src="${pageContext.request.contextPath}/resources/images/1.jpg" class="img-responsive" alt="" />

							</li>
							<li>
								 <img src="${pageContext.request.contextPath}/resources/images/2.jpg" class="img-responsive" alt="" />


							</li>
							<li>
							 <img src="${pageContext.request.contextPath}/resources/images/3.jpg" class="img-responsive" alt="" />

							
							</li>
							<li>
							 <img src="${pageContext.request.contextPath}/resources/images/3.jpg" class="img-responsive" alt="" />


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
			    <div class="b-bottom"> 
			      <h5 class="top"><a href="single.html">${bloginfo.title}</a></h5>
			      <p>On Aug 25 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>0 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>56 </a><a class="span_link" href="single.html"><span class="glyphicon glyphicon-circle-arrow-right"></span></a></p>
				</div>
			 </div>
			   <!--//banner-->
			  <!--/top-news-->
			  <div class="top-news">
				<div class="top-inner">
					<div class="col-md-6 top-text">
						 <a href="single.html"><img src="${pageContext.request.contextPath}/resources/images/pic1.jpg" class="img-responsive" alt=""></a>
						    <h5 class="top"><a href="single.html">Consetetur sadipscing elit</a></h5>
							<p>Consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt labore dolore magna aliquyam eratsed diam justo duo dolores rebum.</p>
						    <p>On Jun 25 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>0 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>56 </a><a class="span_link" href="single.html"><span class="glyphicon glyphicon-circle-arrow-right"></span></a></p>
					 </div>
					<div class="col-md-6 top-text two">
						 <a href="single.html"><img src="${pageContext.request.contextPath}/resources/images/pic2.jpg" class="img-responsive" alt=""></a>
						    <h5 class="top"><a href="single.html">Consetetur sadipscing elit</a></h5>
							<p>Consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt labore dolore magna aliquyam eratsed diam justo duo dolores rebum.</p>
						    <p>On Jun 27 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>0 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>56 </a><a class="span_link" href="single.html"><span class="glyphicon glyphicon-circle-arrow-right"></span></a></p>
					 </div>
					 
					
					<c:forEach var="temp" items="${posts}">
					 			 				  
					 <tr>
						<td> ${temp.body} </td>
						<td> ${temp.title} </td>
						<td> ${temp.userPost.username}</td>
						<td> ${temp.userPost.firstName}</td>
						
						
						
					</tr>
						</c:forEach>
					
					 <div class="clearfix"> </div>
				 </div>
				 <div class="top-inner second">
					<div class="col-md-6 top-text">
						 <a href="single.html"><img src="${pageContext.request.contextPath}/resources/images/pic3.jpg" class="img-responsive" alt=""></a>
						    <h5 class="top"><a href="single.html">Consetetur sadipscing elit</a></h5>
							<p>Consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt labore dolore magna aliquyam eratsed diam justo duo dolores rebum.</p>
						    <p>On Jun 25 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>0 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>56 </a><a class="span_link" href="single.html"><span class="glyphicon glyphicon-circle-arrow-right"></span></a></p>
					 </div>
					<div class="col-md-6 top-text two">
						 <a href="single.html"><img src="${pageContext.request.contextPath}/resources/images/pic4.jpg" class="img-responsive" alt=""></a>
						    <h5 class="top"><a href="single.html">Consetetur sadipscing elit</a></h5>
							<p>Consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt labore dolore magna aliquyam eratsed diam justo duo dolores rebum.</p>
						    <p>On Jun 27 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>0 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>56 </a><a class="span_link" href="single.html"><span class="glyphicon glyphicon-circle-arrow-right"></span></a></p>
					 </div>
					 <div class="clearfix"> </div>
				 </div>
	            </div>
					<!--//top-news-->
		     </div>
			<!--//banner-section-->
			<div class="banner-right-text">
			 <h3 class="tittle">News  <i class="glyphicon glyphicon-facetime-video"></i></h3>
			<!--/general-news-->
			 <div class="general-news">
				<div class="general-inner">
					<div class="general-text">
						 <a href="single.html"><img src="${pageContext.request.contextPath}/resources/images/gen1.jpg" class="img-responsive" alt=""></a>
						    <h5 class="top"><a href="single.html">Consetetur sadipscing elit</a></h5>
							<p>Consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt labore dolore magna aliquyam eratsed diam justo duo dolores rebum.</p>
						    <p>On Jun 25 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>0 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>56 </a><a class="span_link" href="single.html"><span class="glyphicon glyphicon-circle-arrow-right"></span></a></p>
					 </div>
					 <div class="edit-pics">
							      <div class="editor-pics">
										 <div class="col-md-3 item-pic">
										   <img src="${pageContext.request.contextPath}/resources/images/f4.jpg" class="img-responsive" alt="">

										   </div>
											<div class="col-md-9 item-details">
												<h5 class="inner two"><a href="single.html">New iPad App to simulate your Guitar</a></h5>
												 <div class="td-post-date two"><i class="glyphicon glyphicon-time"></i>Feb 22, 2015 <a href="#"><i class="glyphicon glyphicon-comment"></i>0 </a></div>
											 </div>
											<div class="clearfix"></div>
										</div>
										<div class="editor-pics">
										 <div class="col-md-3 item-pic">
										   <img src="${pageContext.request.contextPath}/resources/images/f1.jpg" class="img-responsive" alt="">

										   </div>
											<div class="col-md-9 item-details">
												<h5 class="inner two"><a href="single.html">New iPad App to simulate your Guitar</a></h5>
												 <div class="td-post-date two"><i class="glyphicon glyphicon-time"></i>Feb 22, 2015 <a href="#"><i class="glyphicon glyphicon-comment"></i>0 </a></div>
											 </div>
											<div class="clearfix"></div>
										</div>
										<div class="editor-pics">
										 <div class="col-md-3 item-pic">
										   <img src="${pageContext.request.contextPath}/resources/images/f1.jpg" class="img-responsive" alt="">

										   </div>
											<div class="col-md-9 item-details">
												<h5 class="inner two"><a href="single.html">New iPad App to simulate your Guitar</a></h5>
												 <div class="td-post-date two"><i class="glyphicon glyphicon-time"></i>Feb 22, 2015 <a href="#"><i class="glyphicon glyphicon-comment"></i>0 </a></div>
											 </div>
											<div class="clearfix"></div>
										</div>
										<div class="editor-pics">
										 <div class="col-md-3 item-pic">
										   <img src="${pageContext.request.contextPath}/resources/images/f4.jpg" class="img-responsive" alt="">

										   </div>
											<div class="col-md-9 item-details">
												<h5 class="inner two"><a href="single.html">New iPad App to simulate your Guitar</a></h5>
												 <div class="td-post-date two"><i class="glyphicon glyphicon-time"></i>Feb 22, 2015 <a href="#"><i class="glyphicon glyphicon-comment"></i>0 </a></div>
											 </div>
											<div class="clearfix"></div>
										</div>
									</div>
								<div class="media">	
								 <h3 class="tittle media">Media <i class="glyphicon glyphicon-floppy-disk"></i></h3>
								  <div class="general-text two">
									 <a href="single.html"><img src="${pageContext.request.contextPath}/resources/images/gen3.jpg" class="img-responsive" alt=""></a>
										<h5 class="top"><a href="single.html">Consetetur sadipscing elit</a></h5>
										<p>Consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt labore dolore magna aliquyam eratsed diam justo duo dolores rebum.</p>
										<p>On Jun 27 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>0 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>56 </a><a class="span_link" href="single.html"><span class="glyphicon glyphicon-circle-arrow-right"></span></a></p>
								  </div>
					         </div>
					    <div class="general-text two">
						    <a href="single.html"><img src="${pageContext.request.contextPath}/resources/images/gen2.jpg" class="img-responsive" alt=""></a>
						    <h5 class="top"><a href="single.html">Consetetur sadipscing elit</a></h5>
							<p>Consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt labore dolore magna aliquyam eratsed diam justo duo dolores rebum.</p>
						    <p>On Jun 27 <a class="span_link" href="#"><span class="glyphicon glyphicon-comment"></span>0 </a><a class="span_link" href="#"><span class="glyphicon glyphicon-eye-open"></span>56 </a><a class="span_link" href="single.html"><span class="glyphicon glyphicon-circle-arrow-right"></span></a></p>
					    </div> 
				 </div>
			</div>	
			<!--//general-news-->
			<!--/news-->
			<!--/news-->
		 </div>
			<div class="clearfix"> </div>
	