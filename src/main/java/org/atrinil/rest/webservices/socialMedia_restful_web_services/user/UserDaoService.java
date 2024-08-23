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

    static {
        users.add(new User(1, "AdiShakti", LocalDate.now().minusYears(50000)));
        users.add(new User(2, "KashiKshetraPaal", LocalDate.now().minusYears(40000)));
        users.add(new User(3, "Shiv", LocalDate.now().minusYears(10000)));
    }

    //get all users
    //get one user
    //create one user
    //delete one user

    public List<User> retrieveAllUsers() {
        return users;
    }

    public User retrieveUser(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }

    public void save(User user) {
        if(!checkUserExists(user)) {
            users.add(new User(users.size()+1, user.getName(), user.getBirthDate()));
        }
    }

    public void deleteUser(User user) {
        Predicate<? super User> predicate = u -> u.getId().equals(user.getId())
                && u.getName().contentEquals(user.getName())
                && u.getBirthDate().isEqual(user.getBirthDate());

        users.remove(users.stream().filter(predicate).findFirst().get());
    }

    private boolean checkUserExists(User user) {
        Predicate<? super User> predicate = u -> u.getBirthDate().isEqual(user.getBirthDate()) && u.getName().equalsIgnoreCase(user.getName());
        return users.stream().anyMatch(predicate);
    }
}
