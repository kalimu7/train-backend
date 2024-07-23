package filerouge.demo.config;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SecurityUtils {


    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // Verify a password
    public static boolean verifyPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
