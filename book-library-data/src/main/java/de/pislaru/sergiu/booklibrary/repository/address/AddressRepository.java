package de.pislaru.sergiu.booklibrary.repositories.address;

import de.pislaru.sergiu.booklibrary.domain.entity.address.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
    List<Address> findAllByUserIdOrderByIdAsc(Long userId);
}
