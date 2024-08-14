package org.chothet.restapifive.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static List<User> users = new ArrayList<>();

    private static int userCount = 0;

    static {
        users.add(new User(++userCount, "Cho Thet", LocalDate.now().minusYears(27)));
        users.add(new User(++userCount, "Ya Mone", LocalDate.now().minusYears(26)));
        users.add(new User(++userCount, "Naka No", LocalDate.now().minusYears(47)));

    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        user.setId(++userCount);
        users.add(user);
        return user;            //return user;

    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteById(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }
}
