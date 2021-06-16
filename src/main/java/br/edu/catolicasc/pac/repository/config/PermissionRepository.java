package br.edu.catolicasc.pac.repository.config;

import br.edu.catolicasc.pac.config.permission.Permission;
import org.springframework.data.repository.CrudRepository;

public interface PermissionRepository extends CrudRepository<Permission, Long> {
}
