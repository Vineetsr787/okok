package Studentjdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import Studentjdbc.model.Student;
import Studentjdbc.model.StudentMapper;

public class StudentdaoImpl implements Studentdao {
JdbcTemplate template;
	

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public List<Student> listAll() {
		// TODO Auto-generated method stub
		String sql = "select * from student";
		return template.query(sql, new StudentMapper());
	}

	public String addData(Student std) {
		// TODO Auto-generated method stub
		String sql = "insert into student values(?,?,?,?)";
		template.update(sql,std.getFname(),std.getLname(),std.getAge(),std.getGender());
		
		return "data is inserted";
	}

	public String deleteData(String fname) {
		// TODO Auto-generated method stub
		String sql = "delete from salestable where ename=?";
		template.update(sql,fname);
		return null;
	}

	public Student searchTable(String fname) {
		// TODO Auto-generated method stub
		String sql = "select * from salestable";
		String sql1 = "select ename,job from salestable";
		Student table=null;
		boolean found=false;
		List<Student> results = template.query(sql, new StudentMapper());
		for(Student t :results) {
			if(t.getFname().equals(fname)) {
				found=true;
				table=t;
				break;
			}
		}
		if(found)
			return table;
		else
			return null;
	}

}
