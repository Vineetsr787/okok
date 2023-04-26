package Studentjdbc.Configs;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import Studentjdbc.dao.StudentdaoImpl;
import Studentjdbc.service.StudentService;
import Studentjdbc.service.StudentServiceImpl;

@Configuration
public class StudentConfigs {

		@Bean
		public DataSource createDataSource() {
			DriverManagerDataSource ds = new DriverManagerDataSource();
			ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
			ds.setUrl("jdbc:mysql://localhost:3306/fisglobal");
			ds.setUsername("root");
			ds.setPassword("Rps@12345");
			return ds;
		}
		
		@Bean
		public JdbcTemplate getTemplate() {
			JdbcTemplate template = new JdbcTemplate();
			template.setDataSource(createDataSource());//a
			return template;
		}
		
		@Bean
		public StudentdaoImpl getSalesDao() {
			StudentdaoImpl dao = new StudentdaoImpl();
			dao.setTemplate(getTemplate());
			return dao;
		}
		
		@Bean("iservice")
		public StudentService getSalesServices() {
			StudentServiceImpl service = new StudentServiceImpl();
			service.setDao(getSalesDao());
			return service;
			
		}

	}

