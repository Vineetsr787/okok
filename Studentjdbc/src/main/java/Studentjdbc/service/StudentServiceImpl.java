package Studentjdbc.service;

import java.util.List;

import Studentjdbc.dao.StudentdaoImpl;
import Studentjdbc.model.Student;

public class StudentServiceImpl implements StudentService {
	
	
	StudentdaoImpl dao;

	public StudentdaoImpl getDao() {
		return dao;
	}

	public void setDao(StudentdaoImpl dao) {
		this.dao = dao;
	}

	public List<Student> listAll() {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	public String addData(Student std) {
		// TODO Auto-generated method stub
		return dao.addData(std);
	}

	public String deleteData(String fname) {
		// TODO Auto-generated method stub
		return dao.deleteData(fname);
	}

	public Student searchTable(String fname) {
		// TODO Auto-generated method stub
		return dao.searchTable(fname);
	}

}
