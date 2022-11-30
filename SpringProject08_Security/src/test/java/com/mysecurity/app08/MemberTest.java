package com.mysecurity.app08;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 미리 단위 테스트를 하기 위해 만듦
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"
}) // 환경설정을 하기 위해 선언
public class MemberTest {

	@Autowired
	private PasswordEncoder pwencoder;  // Spring Security에서 비밀번호를 (단방향) 암호화하여 저장하기 위한 인터페이스이다.
	@Autowired
	private DataSource ds;
	
	@Test // 메소드위에 선언하면 해당 메소드를 테스트 대상으로 지정가능
	public void testInsertMethod(){
		String sql = "insert into tbl_member(userid,userpw,username) values(?,?,?)";
		
		for(int i=0; i<100; i++) {
			Connection con = null;
			PreparedStatement ps = null;
			
			try {
				con = ds.getConnection();
				ps = con.prepareStatement(sql);
				ps.setString(2, pwencoder.encode("pw"+i));
				if(i<80) {
					ps.setString(1, "user"+i);
					ps.setString(3, "일반사용자"+i);
				} else if(i<90) {
					ps.setString(1, "manager"+i);
					ps.setString(3, "운영자"+i);
				} else {
					ps.setString(1, "admin"+i);
					ps.setString(3, "관리자"+i);
				}
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
					try {
						if(ps!=null) ps.close();
						if(con!=null) con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
	} //testInsertMethod()
	
	@Test
	public void testInsertAuth() {
		String sql = "insert into tbl_member_auth(userid,auth) values(?,?)";
		for(int i=0; i<100; i++) {
			Connection con = null;
			PreparedStatement ps = null;
			
			try {
				con = ds.getConnection();
				ps = con.prepareStatement(sql);
				if(i<80) {
					ps.setString(1, "user"+i);
					ps.setString(2, "ROLE_USER");
				}
				else if(i<90) {
					ps.setString(1, "manager"+i);
					ps.setString(2, "ROLE_MANAGER");
				}
				else {
					ps.setString(1, "admin"+i);
					ps.setString(2, "ROLE_ADMIN");
				}
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(ps!=null) ps.close();
					if(con!=null) con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}  // MemberTest
