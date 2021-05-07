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
import pe.upc.experimentos.entity.Reserva;
import pe.upc.experimentos.service.ICanchaService;
import pe.upc.experimentos.service.IEquipoService;
import pe.upc.experimentos.service.IReservaService;

@Controller
public class ReservaController {
	
	@Autowired
	private IReservaService reservaService;
	
	@Autowired
	private IEquipoService equipoService;
	
	@Autowired
	private ICanchaService canchaService;
	
	@PostMapping("/registrarReserva")
	public String registrarReserva(@Valid Reserva reserva, BindingResult result, Model model, SessionStatus status, RedirectAttributes redirectAttrs) {
		
		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("mensaje", "El campo no puede estar vacío");
			return "redirect:/reservas";
			
		} else {
			
			int EsRegistro = reserva.getIdReserva();
			
			if (EsRegistro==0) {
			
				int rpta = reservaService.save(reserva);
				
				if (rpta >0) {
					redirectAttrs.addFlashAttribute("mensajeDobleReserva", "Ya existe una reserva registrada en la misma cancha, horario y fecha");
					
					
					
					return "redirect:/reservas";
				}else {
					redirectAttrs.addFlashAttribute("mensajeExito", "¡Reserva registrada!");
					status.setComplete();
					
					
				}
			
			}else {
				
				int rpta = reservaService.update(reserva);
				
				if (rpta >0) {
					redirectAttrs.addFlashAttribute("mensajeDobleReserva", "Ya existe una reserva registrada en la misma cancha, horario y fecha");
					
					
					
					return "redirect:/reservas";
				}else {
					redirectAttrs.addFlashAttribute("mensajeExito", "¡Reserva actualizada!");
					status.setComplete();
					
					
				}
				
				
				
			}
			
			
			
		}
	
		
		return "redirect:/reservas";
		
	}
	
	@GetMapping("/editarReserva/{idReserva}")
	public String editarReserva(@PathVariable("idReserva")int idReserva, Model model) {
		
		Reserva reserva = reservaService.findByIdReserva(idReserva);
		
		model.addAttribute("reserva", reserva);
		
		return "reservas";
	}
	
	
	
	@ModelAttribute
	public void setGenericos(Model model) {
		
		
		
		model.addAttribute("listadoReservas", reservaService.findAll());
		
		model.addAttribute("listadoEquipos", equipoService.findAll());
		
		model.addAttribute("listadoCanchas", canchaService.findAll());
		
		model.addAttribute("listadoReservasPagadas", reservaService.encontrarReservasPagadas());
		
		model.addAttribute("listadoReservasPorPagar", reservaService.encontrarReservasPorPagar());

	}
	
	
	@GetMapping("/eliminarReserva/{idReserva}")
	public String eliminarReserva(@PathVariable("idReserva")int idReserva, RedirectAttributes attributes) {
	
		reservaService.delete(idReserva);
		
		attributes.addFlashAttribute("mensajeExito", "La reserva fue eliminada correctamente");
		
		
		return "redirect:/reservas";
	}	

}
