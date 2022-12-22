package com.itwillbs.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
// @Repository -> bean형태로 만들어줌. root-context에 등록됨 

import com.itwillbs.domain.BoardVO;
import com.itwillbs.domain.Criteria;

@Repository 
public class BoardDAOImpl implements BoardDAO {

	private static final Logger mylog = LoggerFactory.getLogger(BoardDAOImpl.class);
	
	// 디비연결 -> bean 주입(root-context.xml)
	@Inject
	private SqlSession sqlSession;
	
	// mapper NAMESPACE 정보
	private static final String NAMESPACE
			= "com.itwillbs.mapper.BoardMapper";
	
	@Override
	public String getTime() {
		return sqlSession.selectOne(NAMESPACE + ".getTime");
	}

	@Override
	public void createBoard(BoardVO vo) throws Exception {
		mylog.debug(" createBoard(BoardVO vo) -> mapper 호출");
		
		sqlSession.insert(NAMESPACE+".create",vo);
		
		mylog.debug(" 회원가입 완료! -> 서비스 ");
	}

	@Override
	public List<BoardVO> getBoardListAll() throws Exception {
		
		mylog.debug(" getBoardListAll() -> sqlSession-mapper 호출 ");
		
		List<BoardVO> boarList = sqlSession.selectList(NAMESPACE+".listAll");
		mylog.debug("게시판 글 개수 : "+boarList.size()+"");
		return boarList;
	}

	@Override
	public void updateViewcnt(Integer bno) throws Exception {
		mylog.debug(" updateViewcnt(Integer bno) -> sqlSession 객체 ");
		
		sqlSession.update(NAMESPACE+".updateViewcnt",bno);
	}

	@Override
	public BoardVO getBoard(Integer bno) throws Exception {
		mylog.debug("getBoard(Integer bno) 호출");
		
		BoardVO vo = sqlSession.selectOne(NAMESPACE + ".getBoard",bno);
		return vo;
	}

	@Override
	public Integer updateBoard(BoardVO vo) throws Exception {
		mylog.debug("updateBoard(BoardVO vo) 호출");
		
		//sqlSession.update(NAMESPACE+".modifyBoard",bno);
		return sqlSession.update(NAMESPACE+".updateBoard",vo);
	}

	@Override
	public void deleteBoard(Integer bno) throws Exception {
		sqlSession.delete(NAMESPACE+".deleteBoard", bno);
		
	}

	@Override
	public List<BoardVO> getListPage(Integer page) throws Exception {
		
		// 페이지정보 계산
		if(page < 0) {
			page = 1;
		}
		
		// 디비에서 10개씩 조회
		// 1 - 0 / 2 - 10 / 3 - 20 / 4 - 30 / 5 - 40
		page = (page -1) * 10;
		
		return sqlSession.selectList(NAMESPACE+".listPage", page);
	}

	@Override
	public List<BoardVO> getListPage(Criteria cri) throws Exception {
		mylog.debug(" getListPage(Criteria cri) 페이징처리 ");
		
		return sqlSession.selectList(NAMESPACE+".listPage2", cri);
	}
	
	
	
	
	
	
	
	
}
