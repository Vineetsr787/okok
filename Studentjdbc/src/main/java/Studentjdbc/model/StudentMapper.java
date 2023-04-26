package Studentjdbc.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int n) throws SQLException {
		// TODO Auto-generated method stub
		Student t= new Student();
		t.setFname(rs.getString(1));
		t.setLname(rs.getString(2));
		t.setAge(rs.getInt(3));
		t.setGender(rs.getString(4));
		return t;
	}
}