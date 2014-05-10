
package hr.igord.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncoderImpl implements PasswordEncoder {

    private PasswordEncoder passwordEncoder;

    public PasswordEncoderImpl() {
        passwordEncoder = new BCryptPasswordEncoder(14);
    }
    
    @Override
    public String encode(CharSequence cs) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return passwordEncoder.encode(cs);
    }

    @Override
    public boolean matches(CharSequence cs, String string) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return passwordEncoder.matches(cs, string);
    }
}
