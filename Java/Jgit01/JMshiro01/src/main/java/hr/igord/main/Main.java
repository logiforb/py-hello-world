
package hr.igord.main;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final transient Logger LOG = LoggerFactory.getLogger(Main.class);
    
    public static void main(String[] args) {
        
        LOG.info("main1");
        Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject currentUser = SecurityUtils.getSubject();
        if (!currentUser.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken("mujo", "fata", false);
//            try {
//                currentUser.login(token);
//            } catch (UnknownAccountException uae) {
//                LOG.info("There is no user with username of " + token.getPrincipal());
//            } catch (IncorrectCredentialsException ice) {
//                LOG.info("Password for account " + token.getPrincipal() + " was incorrect!");
//            } catch (LockedAccountException lae) {
//                LOG.info("The account for username " + token.getPrincipal() + " is locked.  " +
//                        "Please contact your administrator to unlock it.");
//            } catch (AuthenticationException ae) {
//                LOG.error("ae ex: " + ae.getMessage());
//            }
            try {
                currentUser.login(token);
            } catch (AuthenticationException ae) {
                LOG.error("[token:" + token.getPrincipal() + "] - " + ae.getMessage());
            }
        }
        if (currentUser.getPrincipal() == null) {
            LOG.info("currentUser.getPrincipal() is null!");
        } else {
            LOG.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");
        }
        currentUser.logout();
    }

}
