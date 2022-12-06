package com.itwillbs.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
// @Service : 스프링이 해당파일을 서비스 객체(bean)로 인식

import com.itwillbs.domain.MemberVO;
import com.itwillbs.persistence.MemberDAO;

@Service
public class MemverSeviceImpl implements MemberService {
	// 컨트롤러 - DAO 연결
	// 수행해야하는 동작 구현
	
	private static final Logger mylog = LoggerFactory.getLogger(MemverSeviceImpl.class);
	
	// DAO 객체 필요함
	@Inject
	private MemberDAO dao;
	

	@Override
	public void memberJoin(MemberVO vo) {
		mylog.info(" 컨트롤러 호출 -> 서비스 -> DAO 호출 ");
		dao.insertMember(vo);
		mylog.info(" DAO 호출 -> 서비스 -> 컨트롤러 ");
	}


	@Override
	public boolean memberLogin(MemberVO vo) {
		mylog.info(" memberLogin(vo) 호출 ");
		
		MemberVO resultVO = dao.loginMember(vo);
		
		mylog.debug(" DAO 처리 결과 : " + resultVO);
		// null-false, not null-true
//		if(resultVO != null) 
//			return true;
//		else
//			return false;
		
		return resultVO != null ? true:false;
	}
	
	
	
}
