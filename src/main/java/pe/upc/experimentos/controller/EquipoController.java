package pe.upc.experimentos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.upc.experimentos.entity.Equipo;
import pe.upc.experimentos.service.IEquipoService;
import pe.upc.experimentos.serviceimpl.EquipoService;

@Controller
public class EquipoController {

	@Autowired
	private IEquipoService equipoService;
	
	@PostMapping("/registrarEquipo")
	public String registrarEquipo(@Valid Equipo equipo, BindingResult result, Model model, SessionStatus status) {
		
		if (result.hasErrors()) {
			model.addAttribute("mensaje", "El campo no puede estar vacío");
			return "equipos";
			
		} else {
			
			int EsRegistro = equipo.getIdEquipo();

			
			int rpta = equipoService.save(equipo);
			if (rpta >0) {
				model.addAttribute("mensaje", "Ya existe un equipo registrado con el mismo nombre");
				
				model.addAttribute("listadoEquipos", equipoService.findAll());
				
				return "equipos";
			}else {
				
				if (EsRegistro==0) {
					model.addAttribute("mensajeExito", "¡Equipo registrado!");
				} else {
					
					model.addAttribute("mensajeExito", "¡Equipo actualizado!");
					
				}
				
				
				
				
				status.setComplete();
			}
			
			
			
		}
		
		model.addAttribute("listadoEquipos", equipoService.findAll());
		
		model.addAttribute("equipo", new Equipo());
		
		return "equipos";
		
	}
	
	
	@GetMapping("/editarEquipo/{idEquipo}")
	public String editarEquipo(@PathVariable("idEquipo")int idEquipo, Model model) {
		
		Equipo equipo = equipoService.findByIdEquipo(idEquipo);
		
		model.addAttribute("equipo", equipo);
		
		return "equipos";
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		
		model.addAttribute("listadoEquipos", equipoService.findAll());
		
	}
	
	
	@GetMapping("/eliminarEquipo/{idEquipo}")
	public String eliminarEquipo(@PathVariable("idEquipo")int idEquipo, RedirectAttributes attributes) {
	
		equipoService.delete(idEquipo);
		
		attributes.addFlashAttribute("mensajeExito", "El equipo fue eliminado correctamente");
		
		
		return "redirect:/equipos";
	}
	
	
}
