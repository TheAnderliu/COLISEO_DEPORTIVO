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

import pe.upc.experimentos.entity.Cancha;
import pe.upc.experimentos.service.ICanchaService;
import pe.upc.experimentos.service.IDeporteService;
import pe.upc.experimentos.service.IHorarioService;
import pe.upc.experimentos.service.ILocalService;

@Controller
public class CanchaController {
	
	@Autowired
	private ICanchaService canchaService;
	
	@Autowired
	private IDeporteService deporteService;
	
	@Autowired
	private ILocalService localService;
	
	@Autowired
	private IHorarioService horarioService;
	
	@PostMapping("/registrarCancha")
	public String registrarCancha(@Valid Cancha cancha, BindingResult result, Model model, SessionStatus status, RedirectAttributes redirectAttrs) {
		
		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("mensaje", "Los campos no pueden estar vacíos");
			return "redirect:/canchas";
			
		} else {
			
			int EsRegistro = cancha.getIdCancha();
			
				if (EsRegistro==0) {
					
				
				
				int rpta = canchaService.save(cancha);
				
				
				
					if (rpta >0) {
						redirectAttrs.addFlashAttribute("mensajeDobleCancha", "Ya existe esta cancha");
						
					
						
						return "redirect:/canchas";
					}else {
						redirectAttrs.addFlashAttribute("mensajeExito", "¡Cancha registrada!");
						status.setComplete();
					}
				
				} else {
					
					int rpta = canchaService.update(cancha);
					
					System.out.println("Despues del save");
					System.out.println(rpta);
					
					if (rpta >0) {
						redirectAttrs.addFlashAttribute("mensajeDobleCancha", "Ya existe esta cancha");
						
					
						
						return "redirect:/canchas";
					}else {
						redirectAttrs.addFlashAttribute("mensajeExito", "¡Cancha actualizada!");
						status.setComplete();
					}
				}
			
				
		}
		
		
		
		return "redirect:/canchas";
		
	}

	
	@GetMapping("/editarCancha/{idCancha}")
	public String editarCancha(@PathVariable("idCancha")int idCancha, Model model) {
		
		Cancha cancha = canchaService.findByIdCancha(idCancha);
		
		model.addAttribute("cancha", cancha);
		
		return "canchas";
	}
	
	@ModelAttribute
	public void setGenericos(Model model) {
		
		model.addAttribute("listadoCanchas", canchaService.findAll());
		
		model.addAttribute("listadoDeportes", deporteService.findAll());
		
		model.addAttribute("listadoLocales", localService.findAll());
		
		model.addAttribute("listadoHorarios", horarioService.findAll());
		
	}
	
	@GetMapping("/eliminarCancha/{idCancha}")
	public String eliminarCancha(@PathVariable("idCancha")int idCancha, RedirectAttributes attributes) {
	
		canchaService.delete(idCancha);
		
		attributes.addFlashAttribute("mensajeExito", "La cancha fue eliminada");
		
		
		return "redirect:/canchas";
	}	

}
