package br.edu.catolicasc.pac.repository.config;

import br.edu.catolicasc.pac.config.address.Address;
import org.springframework.data.repository.CrudRepository;

public interface AddressRepository extends CrudRepository<Address, Long> {
}
