package pe.upc.experimentos.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import pe.upc.experimentos.dto.UserRegistrationDto;
import pe.upc.experimentos.entity.User;


public interface UserService extends UserDetailsService {

	User findByUsername(String username);

	User save(UserRegistrationDto registration);
}
