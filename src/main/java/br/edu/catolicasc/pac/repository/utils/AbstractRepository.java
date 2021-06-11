package br.edu.catolicasc.pac.repository.utils;

import br.edu.catolicasc.utils.AbstractEntity;
import org.springframework.data.repository.CrudRepository;

public interface AbstractRepository extends CrudRepository<AbstractEntity, Long> {
}
