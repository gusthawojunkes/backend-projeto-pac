package br.edu.catolicasc.pac.repository.user;

import br.edu.catolicasc.pac.config.user.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByName(String name);
}
