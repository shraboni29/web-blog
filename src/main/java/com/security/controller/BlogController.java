package com.security.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.security.commandform.CommentCommandForm;
import com.security.commandform.PostCommandForm;
import com.security.entity.Comment;
import com.security.entity.Post;
import com.security.entity.Users;
import com.security.service.BlogService;
import com.security.service.CommentService;
import com.security.service.UserService;

@Controller

public class BlogController {
	// private Logger logger=Logger.getLogger(getClass().getName());

	@Autowired
	public BlogService blogService;

	@Autowired
	public UserService userService;
	@Autowired
	public CommentService commentService;

	@GetMapping("/createBlog")
	public String createBlog(Model model) {
		PostCommandForm p = new PostCommandForm();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			p.setUsername(((UserDetails) principal).getUsername());
		} else {
			p.setUsername(principal.toString());
		}
		model.addAttribute("bloginfo", p);

		return "create-blog";

	}

	@RequestMapping("/saveBlog")
	public String saveBlog(@ModelAttribute("bloginfo") PostCommandForm p2) {
		blogService.saveBlog(p2);
		return "redirect:/myBlog";
	}

	@GetMapping("/blog/{postId}")
	public String showBlog(@PathVariable final int postId, Model themodel) {
		CommentCommandForm userComment = new CommentCommandForm();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			userComment.setUsername(((UserDetails) principal).getUsername());
		} else {
			userComment.setUsername(principal.toString());
		}

		Post p1 = blogService.getPost(postId);
		int postid = p1.getPostId();
		List<Comment> c1List = commentService.findCommentbyPostId(postid);
		long totalComment = c1List.size();

		themodel.addAttribute("commentview", c1List);
		PostCommandForm pcf = new PostCommandForm();
		pcf.setPostId(p1.getPostId());
		pcf.setBody(p1.getBody());
		pcf.setPostDate(p1.getPostDate());
		pcf.setTitle(p1.getTitle());
		pcf.setUsername(p1.getUserPost().getUsername());
		userComment.setPostId(pcf.getPostId());
		themodel.addAttribute("bloginfo", pcf);
		themodel.addAttribute("userComment", userComment);
		themodel.addAttribute("totalComment", totalComment);

		return "blog";
	}

	@GetMapping("/editPost")
	public String editBlog(@RequestParam("postId") int postId, Model themodel) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String currentUser = null;
		if (principal instanceof UserDetails) {
			currentUser = ((UserDetails) principal).getUsername();
		} else {
			currentUser = principal.toString();
		}
		Post p2 = blogService.getPost(postId);
		PostCommandForm pcf = new PostCommandForm();
		pcf.setPostId(p2.getPostId());
		pcf.setBody(p2.getBody());
		pcf.setPostDate(p2.getPostDate());
		pcf.setTitle(p2.getTitle());
		pcf.setUsername(p2.getUserPost().getUsername());

		themodel.addAttribute("bloginfo", pcf);
		return "create-blog";
	}

	@RequestMapping("/deleteFile")

	public String deleteFile(@RequestParam("postId") int postId) {
		blogService.deletePostById(postId);

		return "redirect:/myBlog";
	}

	@RequestMapping("/search")
	public String searchBlog(@RequestParam("searchName") String searchName, Model theModel)

	{

		List<Post> thePosts = blogService.searchBlog(searchName);

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

		// theModel.addAttribute("currentUser", currentUser);
		theModel.addAttribute("posts", pcfList);
		return "new-home";
	}

	@RequestMapping("/myBlog")
	public String myBlog(Model theModel) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String currentUser = null;
		if (principal instanceof UserDetails) {
			currentUser = ((UserDetails) principal).getUsername();
		} else {
			currentUser = principal.toString();
		}
		Users u1 = userService.findByUserName(currentUser);
		int userId = u1.getUser_id();
		List<Post> p1 = blogService.findPostByUserid(userId);
		theModel.addAttribute("bloginfo", p1);

		return "my-blog";
	}
}
