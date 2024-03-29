package pe.upc.experimentos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.upc.experimentos.dto.UserRegistrationDto;
import pe.upc.experimentos.entity.Equipo;
import pe.upc.experimentos.entity.User;
import pe.upc.experimentos.service.UserService;


@Controller
@RequestMapping("/registrarAdministrador")
public class UserRegistrationController {

	 @Autowired
	    private UserService userService;

	    @ModelAttribute("user")
	    public UserRegistrationDto userRegistrationDto() {
	        return new UserRegistrationDto();
	    }

	    @GetMapping
	    public String showRegistrationForm(Model model) {
	        return "registrarAdministrador";
	    }

	    @PostMapping
	    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto,
	                                      BindingResult result,  Model model, SessionStatus status){

	        User existing = userService.findByUsername(userDto.getUsername());
	        if (existing != null){
	            result.rejectValue("username", null, "El usuario ya existe");
	            model.addAttribute("mensaje", "Ya existe un usuario registrado con el mismo nombre de usuario");
	        }

	        else if (result.hasErrors()){
	        	 model.addAttribute("mensaje", "Llene todos los campos correctamente");
	            return "registrarAdministrador";
	        }
	        
	        else {
	        	
		        userService.save(userDto);
		        
		        model.addAttribute("mensajeExito", "¡Registro exitoso!");
		        
		        status.setComplete();
		        
		        }
	        
	        model.addAttribute("user", new UserRegistrationDto());
		    return "registrarAdministrador";
	        
	    }
}
