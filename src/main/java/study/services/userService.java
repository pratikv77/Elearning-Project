package study.services;



public interface userService {
	
	boolean isUserPresent(String email);
	
	int sendOtp(String email);

	boolean changePass(String pass,String email);
}
