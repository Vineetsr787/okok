package com.example.springjpa.service;

import java.util.List;
import java.util.Optional;

import com.example.springjpa.model.CommentsDto;
import com.example.springjpa.model.post;

public interface postService {
	public List<post> getAllPosts();
	public post InsertPost(post Post);
	public Optional<post> findPost(Integer pid);
	public void deletePost(Integer pid);
	public List<post> findByAuthor(String author);
	public List<post> findByTitle(String title);
	public List<post> findByTitleAuthor(String title,String author);
	public List<CommentsDto> getCommentsForPost(Integer pid);
	public String getCommentsPort();

}
