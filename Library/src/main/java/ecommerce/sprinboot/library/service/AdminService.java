package ecommerce.sprinboot.library.service;

import ecommerce.sprinboot.library.dto.AdminDto;
import ecommerce.sprinboot.library.model.Admin;

public interface AdminService {
    Admin findByUsername(String username);

    Admin save(AdminDto adminDto);
}
