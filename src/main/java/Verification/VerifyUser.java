package Verification;


import Entities.Users;
import Enumerations.UserRole;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class VerifyUser {
    public boolean verifyUser(Users user) {
        boolean result = false;
        if (isValidEmail(user.getEmail()) && isValidPassword(user.getPassword())) {
            result = true;
        }
        return result;
    }
    public boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find();
    }
    public boolean isValidPassword(String password) {
        if  (password == null) return false;
        String regex = "^(?=.*[A-Z])(?=.*\\d)(?=\\S+$).{8,}$";
        return password.matches(regex);
    }
}
