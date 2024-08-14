package org.chothet.restapifive.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.chothet.restapifive.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {


}
