package br.edu.catolicasc.pac.repository.user;

import br.edu.catolicasc.pac.config.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.userName = :p1")
    public User findByUserName(@Param("p1") String userName);
}
