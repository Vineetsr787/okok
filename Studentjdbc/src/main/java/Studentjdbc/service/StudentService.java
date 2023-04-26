package Studentjdbc.service;

import java.util.List;

import Studentjdbc.model.Student;

public interface StudentService {
	public List<Student> listAll();
	public String addData(Student std);
	public String deleteData(String fname);
	public Student searchTable(String fname);

}
