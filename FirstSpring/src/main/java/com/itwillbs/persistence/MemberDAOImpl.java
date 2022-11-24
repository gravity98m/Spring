package com.itwillbs.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

//@Repository : 스프링에서 해당파일을 DAO파일로 인식시키는 용도

@Repository
public class MemberDAOImpl implements MemberDAO{

	// 디비 연결정보 필요함 => 의존관계
	@Inject
	private SqlSession sqlSession;
	
	
	@Override
	public String getServerTime() { // 시간정보 리턴
		// 디비연결
		// sql 작성 & pstmt
		// ???
		// sql 실행
		// 데이터처리
		
		//sqlSession.selectOne(쿼리); // xml에 있는 id를 실행하겠다.
		String time = sqlSession.selectOne("com.itwillbs.mapper.MemberMapper.getTime");
		
		return time;
	}

}
