package com.example.springjpa.proxy;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import com.example.springjpa.model.CommentsDto;


@FeignClient("COMMENT-SERVICES/comments")
public interface CommentProxy {
	@GetMapping("/port")
	public String getPort();
	
	@GetMapping("/findcmmtbypid/{pid}")
	public List<CommentsDto> findcmmntbyPid(@PathVariable("pid")int pid);
	
	

}
