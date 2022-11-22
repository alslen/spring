package com.person2.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository  // 객체를 자동으로 생성시켜줌 -> 스프링 컨터이너가 자동으로 연결시켜줌
public class Person2DAOImpl implements Person2DAO{

	@Autowired // 객체가 생성되어있기에 @Autowired로 값을 넣어준다.
	private JdbcTemplate template;  
	
	@Override
	public void person_Insert(PersonVO person) {
		String sql = "insert into person values(?,?,?,?,?)";
		Object[] param = new Object[] {  // ?에 값을 넣기 위해 Object형으로 param변수를 선언
			person.getId(), person.getName(), person.getPassword(),
			person.getGender(), person.getJob()
		};
		
		template.update(sql, param);  // sql문 실행하는 명령어
	}

	// 전체보기
	@Override
	public List<PersonVO> person_List() {
		String sql = "select * from person";
		List<PersonVO> personlist = template.query(sql, new RowMapper<PersonVO>() {
			// query는 여러행의 값을 담을 때 사용
			@Override
			public PersonVO mapRow(ResultSet rs, int arg1) throws SQLException {
				PersonVO person = new PersonVO();
				person.setGender(rs.getString("gender"));
				person.setId(rs.getString("id"));
				person.setJob(rs.getString("job"));
				person.setName(rs.getString("name"));
				person.setPassword(rs.getString("password"));
				return person;
			}
			
		});
		return personlist;
	}

	@Override
	public PersonVO person_View(String id) {
		String sql = "select * from person where id='"+id+"'";
		PersonVO person = template.queryForObject(sql, new RowMapper<PersonVO>() {

			@Override
			public PersonVO mapRow(ResultSet rs, int arg1) throws SQLException {
				PersonVO user = new PersonVO();
				user.setGender(rs.getString("gender"));
				user.setId(rs.getString("id"));
				user.setJob(rs.getString("job"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		});
		return person;
	}

	// 수정
	@Override
	public void Person_Update(PersonVO person) {
		String sql = "update person set name=?, password=?, gender=?, job=? where id=?";
		Object[] param = new Object[] {
			person.getName(), person.getPassword(), person.getGender(),
			person.getJob(), person.getId()
		};
		template.update(sql, param);
	}

	// 삭제
	@Override
	public void Person_Delete(String id) {
		String sql = "delete from person where id='"+id+"'";
		template.update(sql);
	}

	@Override
	public int person_Count() {
		
		return 0;
	}

}
