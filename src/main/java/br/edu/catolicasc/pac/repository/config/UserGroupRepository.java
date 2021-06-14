package br.edu.catolicasc.pac.repository.config;

import br.edu.catolicasc.pac.config.group.UserGroup;
import org.springframework.data.repository.CrudRepository;

public interface UserGroupRepository extends CrudRepository<UserGroup, Long> {
}
