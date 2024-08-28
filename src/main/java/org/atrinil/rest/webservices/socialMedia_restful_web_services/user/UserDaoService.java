package org.atrinil.rest.webservices.socialMedia_restful_web_services.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//Used for interacting with database
@Component
public class UserDaoService {

    //JPA or Hibernate
    private static List<User> users = new ArrayList<>();
    private static int usersCreated = 0;

    static {
        users.add(new User(++usersCreated, "AdiShakti", LocalDate.now().minusYears(50000)));
        users.add(new User(++usersCreated, "KashiKshetraPaal", LocalDate.now().minusYears(40000)));
        users.add(new User(++usersCreated, "Shiv", LocalDate.now().minusYears(10000)));
    }

    //get all users
    //get one user
    //create one user
    //delete one user

    public List<User> retrieveAllUsers() {
        return users;
    }

    public User getUser(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user) {
        if(!checkUserExists(user)) {
            User newUser = new User(++usersCreated, user.getName(), user.getBirthDate());
            users.add(newUser);
            return newUser;
        } else return null;
    }

    public void deleteByUser(User user) {
        Predicate<? super User> predicate = u -> u.getId().equals(user.getId())
                && u.getName().contentEquals(user.getName())
                && u.getBirthDate().isEqual(user.getBirthDate());

        users.removeIf(predicate);
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = u -> u.getId().equals(id);
        users.removeIf(predicate);
    }

    private boolean checkUserExists(User user) {
        Predicate<? super User> predicate = u -> u.getBirthDate().isEqual(user.getBirthDate()) && u.getName().equalsIgnoreCase(user.getName());
        return users.stream().anyMatch(predicate);
    }
}
