package ecommerce.sprinboot.library.service;

import java.util.List;

import ecommerce.sprinboot.library.model.Complain;

public interface ComplainService {
    List<Complain> listAll();
    Complain get(long id);
    void delete(long id);
    void updateStatus(long id);
    void save(Complain complain);
}
