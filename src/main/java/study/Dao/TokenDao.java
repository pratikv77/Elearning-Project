package study.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import study.entity.Token;

@Repository
public interface TokenDao extends JpaRepository<Token, Integer> {

	 @Query("SELECT t.refresh_token FROM Token t WHERE id=1")
	 public String getRefreshToken();
	
	 @Procedure
	 public void updateToken(String access_token,String refresh_token,long expires_in);
}
