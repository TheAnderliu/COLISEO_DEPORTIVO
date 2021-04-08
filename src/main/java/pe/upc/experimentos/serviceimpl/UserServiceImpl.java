package pe.upc.experimentos.serviceimpl;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.upc.experimentos.dto.UserRegistrationDto;
import pe.upc.experimentos.entity.Role;
import pe.upc.experimentos.entity.User;
import pe.upc.experimentos.repository.UserRepository;
import pe.upc.experimentos.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }

    public User save(UserRegistrationDto registration){
        User user = new User();
        user.setFirstName(registration.getFirstName());
        user.setLastpName(registration.getLastpName());
        user.setLastmName(registration.getLastmName());
        user.setUsername(registration.getUsername());
        user.setPassword(passwordEncoder.encode(registration.getPassword()));
        user.setRoles(Arrays.asList(new Role("ROLE_USER")));
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("Usuario o contraseña inválida");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }
	
	
}
