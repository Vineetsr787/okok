package com.example.springjpa.controller;

import java.util.List;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

import com.example.springjpa.model.CommentsDto;
import com.example.springjpa.model.post;
import com.example.springjpa.service.postService;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/post")
public class postController {
	
	Logger logger = LoggerFactory.getLogger(postController.class);
	
	@Autowired
	postService service;
	
	@Retry(name="comments",fallbackMethod="sendDummyData")
	@GetMapping("/getCommentsByPid/{pid}")
	public List<CommentsDto> findcmmtbypid(@PathVariable("pid") Integer pid){
	    logger.info("connecting to the comment service...");
		return service.getCommentsForPost(pid);
	}
	
	@GetMapping("/port")
	public String getPorts(){
		return service.getCommentsPort();
	}
	
	
	@GetMapping("/data")
	public List<post> showAll(){
		return service.getAllPosts();
	}
	
	@DeleteMapping("/delete/{pid}")
	public String deleteRecord(@PathVariable("pid")Integer pid) {
		service.deletePost(pid);
		return "Record deleted";
	}
	
	@PostMapping("/add")
	public post createRecord(@RequestBody post Post) {
		return service.InsertPost(Post);
	}
	
	@GetMapping("/findByPid/{pid}")
	public Optional<post> getPostId(@PathVariable("pid") Integer pid){
		return service.findPost(pid);
	}
	
	@GetMapping("/findByAuthor/{author}")
	public List<post> findAuthorData(@PathVariable("author") String author){
		return service.findByAuthor(author);
	}
	@GetMapping("/findByTitle/{title}")
	public List<post> findTitleData(@PathVariable("title") String title){
		return service.findByTitle(title);
	}
	@GetMapping("/find/{title}/{author}")
	public List<post> findTitleAuthor(@PathVariable("title") String title,
			@PathVariable("author") String author){
		return service.findByTitleAuthor(title,author);
	} 
	public List<CommentsDto> sendDummyData(Exception e){
		List<CommentsDto> data = new ArrayList<>();
		data.add(new CommentsDto(500,"temp1",200, "dummy1"));
		data.add(new CommentsDto(501,"temp2",201, "dummy2"));
		data.add(new CommentsDto(502,"temp3",202, "dummy3"));
		data.add(new CommentsDto(503,"temp4",203, "dummy4"));
		return data;
		
	}
	
}
