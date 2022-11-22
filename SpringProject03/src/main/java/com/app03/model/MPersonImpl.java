package com.app03.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository  // dao 객체를 만들어줌 -> 이걸 써주지 않으면 null값이 넘어감
public class MPersonImpl implements MPersonDAO{

	@Autowired
	private JdbcTemplate template;
	
	@Override
	public void person_Insert(PersonDTO person) {
		String sql = "insert into person values(?,?,?,?,?)";
		Object[] param = new Object[] {
			person.getId(), person.getName(), person.getPassword(),
			person.getGender(), person.getJob()
		};
		template.update(sql, param);
	}

	@Override
	public List<PersonDTO> person_List() {
	
		String sql = "select * from person";
		List<PersonDTO> personlist = template.query(sql, new RowMapper<PersonDTO>() {

			@Override
			public PersonDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				PersonDTO person = new PersonDTO();
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
	public PersonDTO person_View(String id) {
		String sql = "select * from person where id='"+id+"'";
		PersonDTO person = template.queryForObject(sql, new RowMapper<PersonDTO>() {

			@Override
			public PersonDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				PersonDTO user = new PersonDTO();
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

	@Override
	public void Person_Update(PersonDTO person) {
	
		String sql = "update person set name=?, password=?, gender=?, job=? where id=?";
		Object[] param = new Object[] {
			person.getName(), person.getPassword(), person.getGender(),
			person.getJob(), person.getId()
		};
		template.update(sql, param);
	}

	@Override
	public void Person_Delete(String id) {
		String sql = "delete from person where id='"+id+"'";
		template.update(sql);
		
	}

	@Override
	public int person_Count() {
		String sql = "select count(*) from person";
		// 리턴되는 것이 하나이기에 queryForObject를 사용
		int count = template.queryForObject(sql,Integer.class);
	
		return count;
	}


}
