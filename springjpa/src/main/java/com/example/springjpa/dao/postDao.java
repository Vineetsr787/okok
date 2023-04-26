package com.example.springjpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springjpa.model.post;

@Repository
public interface postDao extends JpaRepository<post,Integer> {

	public List<post> findByAuthor(String author);
	public List<post> findByTitle(String title);
	
	@Query("select u from post u where u.title=?1 and u.author=?2")
	public List<post> findByTitleAndAuthor(String title,String author);

}
