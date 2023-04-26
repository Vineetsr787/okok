package com.example.springjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.springjpa.dao.postDao;
import com.example.springjpa.model.CommentsDto;
import com.example.springjpa.model.post;
import com.example.springjpa.proxy.CommentProxy;

@Service
public class postServiceImpl implements postService {
	
	@Autowired
	postDao dao;
	
	@Autowired
	CommentProxy temp;
	
	@Autowired
	RestTemplate template;

	@Override
	public List<post> getAllPosts() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public post InsertPost(post Post) {
		// TODO Auto-generated method stub
		return dao.save(Post);
	}

	@Override
	public Optional<post> findPost(Integer pid) {
		// TODO Auto-generated method stub
		return dao.findById(pid);
	}

	@Override
	public void deletePost(Integer pid) {
		// TODO Auto-generated method stub
		 dao.deleteById(pid);
	}

	@Override
	public List<post> findByAuthor(String author) {
		// TODO Auto-generated method stub
		return dao.findByAuthor(author);
	}

	@Override
	public List<post> findByTitle(String title) {
		// TODO Auto-generated method stub
		return dao.findByTitle(title);
	}
	
	

	@Override
	public List<post> findByTitleAuthor(String title, String author) {
		// TODO Auto-generated method stub
		return dao.findByTitleAndAuthor(title, author);
	}

	@Override
	public List<CommentsDto> getCommentsForPost(Integer pid) {
		// TODO Auto-generated method stub
		//String url = "http://COMMENT-SERVICES/comments/findcmmtbypid/"+pid;
		//return template.getForObject(url,List.class);
		//String url = "http://localhost:8085/comments/findcmmntbyPid/"+pid;
		return temp.findcmmntbyPid(pid);
	}
	
	@Override
	public String getCommentsPort() {
		// TODO Auto-generated method stub
		//String url = "http://COMMENT-SERVICES/comments/port/";
		//return template.getForObject(url,String.class);
		return temp.getPort();
	}
	
	

}
