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

import pe.upc.experimentos.entity.Deporte;
import pe.upc.experimentos.service.IDeporteService;

@Controller
public class DeporteController {
	
	@Autowired
	private IDeporteService deporteService;
	
	@PostMapping("/registrarDeporte")
	public String registrarDeporte(@Valid Deporte deporte, BindingResult result, Model model, SessionStatus status, RedirectAttributes redirectAttrs) {
		
		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("mensaje", "El campo no puede estar vacío");
			return "redirect:/deportes";
			
		} else {
			
			int EsRegistro = deporte.getIdDeporte();
			
			int rpta = deporteService.save(deporte);
			if (rpta >0) {
				redirectAttrs.addFlashAttribute("mensajeDobleDeporte", "Ya existe este deporte");
				
				
				
				return "redirect:/deportes";
			}else {
				
				
				if (EsRegistro==0) {
					redirectAttrs.addFlashAttribute("mensajeExito", "¡Deporte registrado!");
				} else {
					
					redirectAttrs.addFlashAttribute("mensajeExito", "¡Deporte actualizado!");
					
				}
				
				
				status.setComplete();
			}
			
			
			
		}
		
		
		
		return "redirect:/deportes";
		
	}
	
	

	@GetMapping("/editarDeporte/{idDeporte}")
	public String editarDeporte(@PathVariable("idDeporte")int idDeporte, Model model) {
		
		Deporte deporte = deporteService.findByIdDeporte(idDeporte);
		
		model.addAttribute("deporte", deporte);
		
		return "deportes";
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		
		model.addAttribute("listadoDeportes", deporteService.findAll());
		
	}
	
	
	@GetMapping("/eliminarDeporte/{idDeporte}")
	public String eliminarDeporte(@PathVariable("idDeporte")int idDeporte, RedirectAttributes attributes) {
	
		deporteService.delete(idDeporte);
		
		attributes.addFlashAttribute("mensajeExito", "El deporte fue eliminado correctamente");
		
		
		return "redirect:/deportes";
	}

}
