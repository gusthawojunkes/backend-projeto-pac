package br.edu.catolicasc.pac.repository.config;

import br.edu.catolicasc.pac.config.user.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.userName = :p1")
    public User findByUserName(@Param("p1") String userName);

    @Modifying
    @Query(value = "DELETE FROM user WHERE id IN (SELECT students_id FROM user_students WHERE user_id = :p1)", nativeQuery = true)
    public void removeUserStudents(@Param("p1") Long id);

}
