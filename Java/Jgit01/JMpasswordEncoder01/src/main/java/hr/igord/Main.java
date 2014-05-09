
package hr.igord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Main {

    private static final transient Logger LOG = LoggerFactory.getLogger(Main.class);
    
    public Main() {
        
//        PasswordEncoder pe = new BCryptPasswordEncoder();
//        String password = "password";
//        String encoded = pe.encode(password);
//        System.out.println(password);
//        System.out.println(encoded);
//        System.out.println("$2a$10$06aeTQU2O4xfzHfIKDkI6.15pscSSVpsHW1Tjl2oYjAgCYVO4pBky");
//        System.out.println("$2a$10$1o.ldBclqSXSmxsZDTt5Ouy8F4O0KwShyhUKBaJngj4HiPNtEpbQq");
//        boolean matches = pe.matches(password, "$2a$10$06aeTQU2O4xfzHfIKDkI6.15pscSSVpsHW1Tjl2oYjAgCYVO4pBky");
//        System.out.println(matches);
//        matches = pe.matches(password, "$2a$10$1o.ldBclqSXSmxsZDTt5Ouy8F4O0KwShyhUKBaJngj4HiPNtEpbQq");
//        System.out.println(matches);
//        System.out.println("$2a$10$1o.ldBclqSXSmxsZDTt5Ouy8F4O0KwShyhUKBaJngj4HiPNtEpbQq".length());
//        
//        LOG.debug("TEST DEBUG");
        
//        PasswordEncoder pe = new BCryptPasswordEncoder(18);
        PasswordEncoder pe = new BCryptPasswordEncoder(16);
        String password = "password";
        long pre = System.nanoTime();
        pe.encode(password);
        long post = System.nanoTime();
        System.out.println((post - pre) * 0.000001);
        
        String mkyong = "123456";
        System.out.println(pe.encode(mkyong));
    }
    
    public static void main(String[] args) {
        new Main();
    }

}
