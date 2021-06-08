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
import pe.upc.experimentos.entity.Jugador;
import pe.upc.experimentos.service.IEquipoService;
import pe.upc.experimentos.service.IJugadorService;

@Controller
public class JugadorController {

	@Autowired
	private IJugadorService jugadorService;
	
	@Autowired
	private IEquipoService equipoService;
	
	@PostMapping("/registrarJugador")
	public String registrarJugador(@Valid Jugador jugador, BindingResult result, Model model, SessionStatus status, RedirectAttributes redirectAttrs) {
		
		if (result.hasErrors()) {
			redirectAttrs.addFlashAttribute("mensaje", "Ingrese los datos correctamente en todos los campos");
			return "redirect:/jugadores";
			
		} else {

			int EsRegistro = jugador.getIdJugador();

			int rpta = jugadorService.save(jugador);

			if (EsRegistro == 0) {

				if (rpta > 0) {
					redirectAttrs.addFlashAttribute("mensajeDobleJugador",
							"Ya existe un jugador registrado con el mismo DNI");

					model.addAttribute("listadoEquipos", equipoService.findAll());

					model.addAttribute("listadoJugadores", jugadorService.findAll());

					return "redirect:/jugadores";
				} else {
					redirectAttrs.addFlashAttribute("mensajeExito", "¡Jugador registrado!");
					status.setComplete();
				}

			} else {

				if (rpta > 0) {
					redirectAttrs.addFlashAttribute("mensajeDobleJugador",
							"Ya existe un jugador registrado con el mismo DNI");

					model.addAttribute("listadoEquipos", equipoService.findAll());

					model.addAttribute("listadoJugadores", jugadorService.findAll());

					return "redirect:/jugadores";
				} else {

					jugadorService.update(jugador);
					redirectAttrs.addFlashAttribute("mensajeExito", "¡Jugador actualizado!");
					status.setComplete();
				}




			}

		}

		
		
		return "redirect:/jugadores";
		
	}
	
	@GetMapping("/editarJugador/{idJugador}")
	public String editarJugador(@PathVariable("idJugador")int idJugador, Model model) {
		
		Jugador jugador = jugadorService.findByIdJugador(idJugador);
		
		model.addAttribute("jugador", jugador);
		
		return "jugadores";
	}
	
	
	
	@ModelAttribute
	public void setGenericos(Model model) {
		
		model.addAttribute("listadoEquipos", equipoService.findAll());
		
		model.addAttribute("listadoJugadores", jugadorService.findAll());
		
	}
	
	
	
	@GetMapping("/eliminarJugador/{idJugador}")
	public String eliminarJugador(@PathVariable("idJugador")int idJugador, RedirectAttributes attributes) {
	
		jugadorService.delete(idJugador);
		
		attributes.addFlashAttribute("mensajeExito", "El jugador fue eliminado correctamente");
		
		
		return "redirect:/jugadores";
	}
	
}
