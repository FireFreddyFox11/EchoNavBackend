package Verification;


import Entities.Users;
import Enumerations.UserRole;
import Queries.UserQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class VerifyUser {

    @Autowired
    private UserQueries userQueries;

    public boolean verifyUser(Users user) {
        return isValidEmail(user.getEmail()) && isValidPassword(user.getPassword());
    }
    public boolean addUser(Users user) {
        boolean hasAdded = false;
        if (verifyUser(user)) {
            Users.builder()
                    .userID(user.getUserID())
                    .organization(user.getOrganization())
                    .name(user.getName())
                    .surname(user.getSurname())
                    .email(user.getEmail())
                    .country(user.getCountry())
                    .password(user.getPassword())
                    .pin(user.getPin())
                    .build();
            userQueries.save(user);
            hasAdded = true;
        }
        return hasAdded;
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
