package com.itwillbs.fintech.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.itwillbs.fintech.vo.RequestTokenVO;
import com.itwillbs.fintech.vo.ResponseTokenVO;

@Service
public class OpenBankingApiClient {
	private String client_id="d7841ed1-9c06-4763-9143-8a8dd6a75e92";
	private String client_secret="79e6e487-9de1-486c-9099-d2822e0d77e7";
	private String redirect_uri="http://localhost:8080/fintech/callback";
	private String grant_type="authorization_code";
	//http 헤더 정보 관리 클래스
	private HttpHeaders httpHeaders;
	// REST방식 API요청
	private RestTemplate restTemplate;
	
	// 토큰발급 요청 메서드
	public ResponseTokenVO requestToken(RequestTokenVO requestTokenVO) {
		// HTTP URL https://testapi.openbanking.or.kr/oauth/2.0/token
		// HTTP Method POST
//		Content-Type application/x-www-form-urlencoded; charset=UTF-8
		
		// http header 지정
		httpHeaders=new HttpHeaders();
		httpHeaders.add("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
		
		// requestTokenVO code => 저장
		requestTokenVO.setClient_id(client_id);
		requestTokenVO.setClient_secret(client_secret);
		requestTokenVO.setRedirect_uri(redirect_uri);
		requestTokenVO.setGrant_type(grant_type);
		// application/x-www-form-urlencoded; charset=UTF-8 객체저장 불가능
		// 파라미터 저장해서 들고 감
		MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();
		parameters.add("code", requestTokenVO.getCode());
		parameters.add("client_id", requestTokenVO.getClient_id());
		parameters.add("client_secret", requestTokenVO.getClient_secret());
		parameters.add("redirect_uri", requestTokenVO.getRedirect_uri());
		parameters.add("grant_type", requestTokenVO.getGrant_type());
		
		// HttpHeaders,parameters 담아서 감 => HttpEntity 
		HttpEntity<MultiValueMap<String, String>> param = 
				new HttpEntity<MultiValueMap<String,String>>(parameters,httpHeaders);
		
		String requestUrl="https://testapi.openbanking.or.kr/oauth/2.0/token";
		
		restTemplate =new RestTemplate();
			
		return restTemplate.exchange(requestUrl, HttpMethod.POST,param,ResponseTokenVO.class).getBody();
	}
}
