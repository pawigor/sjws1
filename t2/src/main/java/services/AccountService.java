package services;

import java.util.HashMap;
import java.util.Map;

public class AccountService {

    private Map<String, String> usersCredentionals = new HashMap<>();

    public boolean signUp(String login, String password) {

        usersCredentionals.put(login, password);
        return true;
    }

    public boolean signIn(String login, String password) {
        return usersCredentionals.containsKey(login) && usersCredentionals.get(login).equals(password);
    }
}
