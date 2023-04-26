package Studentjdbc.Controller;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Studentjdbc.Configs.StudentConfigs;
import Studentjdbc.model.Student;
import Studentjdbc.service.StudentService;

public class StudentAnnotationController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				// TODO Auto-generated method stub
				AnnotationConfigApplicationContext context
				= new AnnotationConfigApplicationContext(StudentConfigs.class);
				
				StudentService service= (StudentService)context.getBean("iservice");
				
				
				List<Student> data = service.listAll();
				data.forEach(System.out::println);
				

			}

		

	}


