package com.security.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.security.commandform.CommentCommandForm;
import com.security.commandform.PostCommandForm;
import com.security.entity.Comment;
import com.security.entity.Post;
import com.security.service.BlogService;
import com.security.service.CommentService;

@Controller

public class HomeController {
	@Autowired
	public BlogService blogService;
	
	@Autowired
	public CommentService commentService;
	
	//private Logger logger = Logger.getLogger(getClass().getName());


	@GetMapping("/")
	
	public String showHomePage()
	{
//		List<Post> thePosts = blogService.getPosts();
//		
//		// add the post to the model
//		theModel.addAttribute("posts", thePosts);
//		//logger.info(">>>>>>>>>>hhhhhhhhhhhhhhhhhhh>>>>>>>>>>>"+  thePosts);
//		
 		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String Page(Model theModel)
	{
	
		
		
		List<Post> thePosts = blogService.getPosts();
		List<PostCommandForm> pcfList = new ArrayList<PostCommandForm>();
		for(Post post : thePosts){
			PostCommandForm pcf = new PostCommandForm();
			pcf.setBody(post.getBody());
			pcf.setPostDate(post.getPostDate());
			pcf.setPostId(post.getPostId());
			pcf.setTitle(post.getTitle());
			pcf.setUsername(post.getUserPost().getUsername());
			pcf.setCommentEList(commentService.findCommentbyPostId(post.getPostId()));
			pcfList.add(pcf);
		}
		//List<Comment> theComment=commentService.getComments();
		
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		String currentUser = null;
//		if (principal instanceof UserDetails) {
//			currentUser = ((UserDetails) principal).getUsername();
//		} else {
//			currentUser = principal.toString();
//		}
//		CommentCommandForm p = new CommentCommandForm();
//		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		if (principal instanceof UserDetails) {
//			p.setUsername(((UserDetails) principal).getUsername());
//		} else {
//			p.setUsername(principal.toString());
//		}
//				
		// add the post to the model
		theModel.addAttribute("posts", pcfList);
	//theModel.addAttribute("comments", theComment);
		//theModel.addAttribute("currentUser", p);
		//logger.info(">>>>>>>>>>hhhhhhhhhhhhhhhhhhh>>>>>>>>>>>"+  thePosts);
		
		return "new-home";
	}
   
	@GetMapping("/systems")
	public String adminHomePage()
	{
		return "admin-page";
	}
	
	@GetMapping("/leaders")
	public String managerHomePage()
	{
		return "manager-page";
	}
	
	@GetMapping("/access-denied")
	public String accessDeniedPage()
	{
		return "access-denied-page";
	}}
