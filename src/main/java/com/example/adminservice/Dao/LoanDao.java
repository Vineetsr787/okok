package com.example.adminservice.Dao;

import org.springframework.stereotype.Repository;

import com.example.adminservice.Model.Loan;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;




@Repository

public interface LoanDao extends JpaRepository<Loan, String>{
	
	/*@Query("select u from Loan u where u.customer_number=?1 and u.branch_id=?2")
	public List<Loan> loanbyCnoAndBid(String cumstomer_number,String branch_id);*/
	/*@Query
	public Loan InsertLoan(Loan loan);*/
	

}
