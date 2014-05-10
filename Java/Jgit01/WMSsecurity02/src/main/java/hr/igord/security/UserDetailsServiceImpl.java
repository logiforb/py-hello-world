
package hr.igord.security;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * http://kh-yiu.blogspot.com/2012/12/spring-mvc-security-custom.html
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    private static Map<String, UserDetails> userRepository = new HashMap<String, UserDetails>();
    
    static {
        GrantedAuthority authorityAdmin = new GrantedAuthorityImpl("admtest");
        GrantedAuthority authorityGuest = new GrantedAuthorityImpl("guetest");
        
        Set<GrantedAuthority> authorities3 = new HashSet<GrantedAuthority>();
        authorities3.add(authorityAdmin);
        authorities3.add(authorityGuest);
        UserDetails qw = new UserDetailsImpl("q", "$2a$14$XFS5wl8MyrCZuSbvfePigeEgo1GoljRts6ZAs9aNRxnSeWcLWHgwy", authorities3);
        userRepository.put("q", qw);
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails matchingUser = userRepository.get(username);

        if (matchingUser == null) {
            throw new UsernameNotFoundException("Wrong username or pass(TEST)word");
        }

        return matchingUser;
    }
}
