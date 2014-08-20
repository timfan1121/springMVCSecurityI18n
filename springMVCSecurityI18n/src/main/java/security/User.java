package security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

public class User  implements UserDetails {
	 
	 private static final long serialVersionUID = 1L;
	 
	 private String name;
	 private String password;
	  
	 public User(String name, String password) {
	 this.name = name;
	 this.password = password;
	 }
	  
	 @Override
	 public Collection<GrantedAuthority> getAuthorities() {
	 // TODO Auto-generated method stub
	 List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
	 grantedAuthorities.add(new GrantedAuthorityImpl("ROLE_USER"));
	 return grantedAuthorities;
	 }
	  
	 @Override
	 public String getPassword() {
	 // TODO Auto-generated method stub
	 return password;
	 }
	  
	 @Override
	 public String getUsername() {
	 return name;
	 }
	  
	 @Override
	 public boolean isAccountNonExpired() {
	 return true;
	 }
	  
	 @Override
	 public boolean isAccountNonLocked() {
	 return true;
	 }
	  
	 @Override
	 public boolean isCredentialsNonExpired() {
	 return true;
	 }
	  
	 @Override
	 public boolean isEnabled() {
	 return true;
	 }
	  
}
