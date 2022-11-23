package study.services;


import java.util.HashMap;

import study.entity.Token;

public interface TokenService {
	
	
	boolean createToken(String code);
	
	boolean refreshToken();
	
	boolean insert(Token token);
	
	HashMap<String, String> getToken();

}
