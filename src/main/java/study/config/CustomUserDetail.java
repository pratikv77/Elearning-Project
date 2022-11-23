package study.config;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import study.Pojo.User;

public class CustomUserDetail implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	
	public CustomUserDetail(User user) {
		super();
		this.user = user;
	}

	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		HashSet<SimpleGrantedAuthority> set =new HashSet<>();
		set.add(new SimpleGrantedAuthority(this.user.getRole()));

		return set;
	}
	
	

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	public String getUser() {
		// TODO Auto-generated method stub
		return this.user.getName();
	}
	public int getId() {
		// TODO Auto-generated method stub
		return this.user.getId();
	}

}