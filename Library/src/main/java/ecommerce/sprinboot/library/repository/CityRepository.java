package ecommerce.sprinboot.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecommerce.sprinboot.library.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
