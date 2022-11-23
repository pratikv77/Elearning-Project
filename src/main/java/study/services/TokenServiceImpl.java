package study.services;

import java.util.Arrays;
import java.util.HashMap;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import study.Dao.TokenDao;
import study.Pojo.TokenPojo;
import study.Pojo.ZoomDetailsPojo;
import study.entity.Token;

@Service
public class TokenServiceImpl implements TokenService {

	@Autowired
	TokenDao dao;

	@Autowired
	ZoomDetailsPojo details;

	@Override
	public boolean createToken(String code) {

		ResponseEntity<TokenPojo> response = null;
		System.out.println("Authorization Code------" + code); // authorization code coming from zoom oAuth

		RestTemplate restTemplate = new RestTemplate();

		String credentials = details.getApiKey() + ":" + details.getApiSecret(); /* client ID : client secret */
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Basic " + encodedCredentials);

		HttpEntity<String> request = new HttpEntity<String>(headers);

		String access_token_url = "https://zoom.us/oauth/token";
		access_token_url += "?code=" + code;
		access_token_url += "&grant_type=authorization_code";
		access_token_url += "&redirect_uri=http://localhost:8080/getcode";

		response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, TokenPojo.class);
		TokenPojo t = response.getBody();
		System.out.println("Access Token Response ---------" + response);

		long token_expiresIn = System.currentTimeMillis() + (t.getExpires_in() * 1000);
		Token token = new Token(t.getAccess_token(), t.getRefresh_token(), token_expiresIn);
			return this.insert(token);
		
	}

	@Override
	public synchronized boolean refreshToken() {
		ResponseEntity<TokenPojo> response = null;

		RestTemplate restTemplate = new RestTemplate();

		String credentials = details.getApiKey() + ":" + details.getApiSecret(); /* client ID : client secret */
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("Authorization", "Basic " + encodedCredentials);

		HttpEntity<String> request = new HttpEntity<String>(headers);

		String access_token_url = "https://zoom.us/oauth/token";
		access_token_url += "?refresh_token=" + dao.getRefreshToken();
		access_token_url += "&grant_type=refresh_token";

		response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, TokenPojo.class);
		TokenPojo t = response.getBody();
		System.out.println("Access Token Response ---------" + response);

		long token_expiresIn = System.currentTimeMillis() + (t.getExpires_in() * 1000);
		Token token = new Token(t.getAccess_token(), t.getRefresh_token(), token_expiresIn);
//		if(this.insert(token))
//		{
//			notify();
//			return true;
//		}
//		else
//		{
//			return false;
//		}
		
		return this.insert(token);
		
	}

	@Override
	public boolean insert(Token token) {
		try {
			if (dao.count() == 0) {
				dao.save(token);
			} else {
				
				dao.updateToken(token.getAccess_token(), token.getRefresh_token(), token.getExpires_in());
				
			}
		} catch (Exception e) {
			return false;
		}
/*		try {
			if (dao.count() > 1) {
				dao.deleteAll();
				dao.save(token);
			} else if (dao.count() == 0) {
				dao.save(token);
			} else {
				Token t = dao.findById(1).get();
				t.setAccess_token(token.getAccess_token());
				t.setRefresh_token(token.getRefresh_token());
				t.setExpires_in(token.getExpires_in());
				dao.save(t);
			}
		} catch (Exception e) {
			return false;
		}*/
		return true;
	}

	@Override
	public synchronized HashMap<String, String> getToken() {
		
		HashMap<String, String> hmap = new HashMap<String, String>();
		Token token = dao.findById(1).get();

		long expiry_time = token.getExpires_in();
		long current_time = System.currentTimeMillis();
		System.out.println(current_time > expiry_time - 180000);
		System.out.println("Token expires in "+token.getExpires_in());
		System.out.println("current time "+ System.currentTimeMillis());
		if (current_time > expiry_time - 180000 && this.refreshToken()) {
			System.out.println("in if condition of refresh token");
			//if token is expired it get refreshed here using this.refresh token method
//			if(!this.refreshToken())
//			{
//				try {
//					wait();
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//			
			
			hmap.put("error", "Please try again token refreshed");
			hmap.put("status", "sucess");
			hmap.put("Token", token.getAccess_token());
			return hmap;
		} else {
			
			System.out.println("in rlse of token");
			hmap.put("status", "sucess");
			hmap.put("Token", token.getAccess_token());
			return hmap;
		}


	}

}
