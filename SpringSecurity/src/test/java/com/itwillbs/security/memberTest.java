package com.itwillbs.security;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
					"file:src/main/webapp/WEB-INF/spring/security-context.xml"
					})
public class memberTest {

	
	private static final Logger mylog = LoggerFactory.getLogger(memberTest.class);
	
	// 디비 연결
	@Autowired
	private DataSource ds;
	
	// 비밀번호 암호화(security-context.xml)
	@Autowired
	private PasswordEncoder pw;
	
	@Test
	public void 회원가입_테스트() {
		String sql = "insert into tbl_member(userid, userpw, username, useremail) "
				+ "values(?,?,?,?)";
			
		Connection con = null;
		PreparedStatement pstmt = null;
		
		for(int i=0; i<10; i++) {
			
			try {
				con = ds.getConnection();
				pstmt = con.prepareStatement(sql);
				
				// ????
				if(i < 8 ) {
					pstmt.setString(1, "user"+i);
					pstmt.setString(3, "사용자"+i);
					pstmt.setString(4, "user"+i+"@itwill.com");
				}else if(i <9) {
					pstmt.setString(1, "manager"+i);
					pstmt.setString(3, "운영자"+i);
					pstmt.setString(4, "manager"+i+"@itwill.com");
				}else {
					pstmt.setString(1, "admin"+i);
					pstmt.setString(3, "관리자"+i);
					pstmt.setString(4, "admin"+i+"@itwill.com");
				}

				// 비밀번호 입력(암호화)
				pstmt.setString(2, pw.encode("pw"+i));
				
				// 쿼리 실행
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
