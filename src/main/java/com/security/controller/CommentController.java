package com.security.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class CommentController {
	@Autowired
	public CommentService commentService;
	@Autowired
	public BlogService blogService;
	@Autowired
	public UserService userService;

	
	@RequestMapping("/createComment")
	public String createComment(Model themodel) {
		CommentCommandForm c2 = new CommentCommandForm();
		themodel.addAttribute("commentPost", c2);
		return "new-home";
	}

	@RequestMapping("/saveComment")
	public String saveComment(@ModelAttribute("userComment") CommentCommandForm ccf) {

		commentService.saveComment(ccf);

		return "redirect:/blog/" + ccf.getPostId();
	}

}
