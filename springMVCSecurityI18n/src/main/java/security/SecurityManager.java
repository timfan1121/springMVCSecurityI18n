package security;

import java.util.ArrayList;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class SecurityManager implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		// TODO Auto-generated method stub
		ArrayList<User> userList = new ArrayList<User>();
		userList.add(new User("Lawrence", "123456"));
		userList.add(new User("Tom", "654321"));
		userList.add(new User("Terry", "321456"));
		for (int i = 0; i < userList.size(); i++) {
			User user = (User) userList.get(i);
			if (user.getUsername().equals(username))
				return user;
		}
		throw new UsernameNotFoundException("User " + username
				+ " has no GrantedAuthority");
	}
}