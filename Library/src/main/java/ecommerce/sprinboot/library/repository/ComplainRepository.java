package ecommerce.sprinboot.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ecommerce.sprinboot.library.model.Complain;

@Repository
public interface ComplainRepository extends JpaRepository<Complain, Long> {
    Complain findById(long id);
}
