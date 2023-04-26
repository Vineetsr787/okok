package com.example.adminservice.Model;




import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="loan_details")
public class Loan {
	
	@Id
	String customer_number; 
	String branch_id;
	Double loan_amount;
	
	/*@OneToOne
	@JoinColumn(name="customer_number")
	@MapsId
	public Customer customer;*/
	
	public Loan() {
		
	}

	public Loan(String customer_number, String branch_id, Double loan_amount) {
		super();
		this.customer_number = customer_number;
		this.branch_id = branch_id;
		this.loan_amount = loan_amount;
	}

	public String getCustomer_number() {
		return customer_number;
	}

	public void setCustomer_number(String customer_number) {
		this.customer_number = customer_number;
	}

	public String getBranch_id() {
		return branch_id;
	}

	public void setBranch_id(String branch_id) {
		this.branch_id = branch_id;
	}

	public Double getLoan_amount() {
		return loan_amount;
	}

	public void setLoan_amount(Double loan_amount) {
		this.loan_amount = loan_amount;
	}
	

}
