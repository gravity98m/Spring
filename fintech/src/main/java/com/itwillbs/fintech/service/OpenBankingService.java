package com.itwillbs.fintech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwillbs.fintech.vo.RequestTokenVO;
import com.itwillbs.fintech.vo.ResponseTokenVO;

@Service
public class OpenBankingService {

	// 객체생성
	@Autowired
	private OpenBankingApiClient openBankingApiClient;
	
	//토큰발급 요청 메서드
	public ResponseTokenVO requestToken(RequestTokenVO requestTokenVO) {
		return openBankingApiClient.requestToken(requestTokenVO);
	}
	
}
