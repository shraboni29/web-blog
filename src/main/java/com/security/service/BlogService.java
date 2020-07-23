package com.security.service;

import java.util.List;

import com.security.commandform.CommentCommandForm;
import com.security.commandform.PostCommandForm;
import com.security.entity.Post;

public interface BlogService {

	void saveBlog(PostCommandForm p2);

	List<Post> getPosts();

	Post getPost(int theid);

	List<Post> searchBlog(String searchName);

	List<Post> findPostByUserid(int userId);

	void deletePostById(int postId);
	

	
	
	
}
