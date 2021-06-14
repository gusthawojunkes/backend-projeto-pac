package br.edu.catolicasc.pac.repository.config;

import br.edu.catolicasc.pac.config.permissions.Permission;
import org.springframework.data.repository.CrudRepository;

public interface PermissionRepository extends CrudRepository<Permission, Long> {
}
