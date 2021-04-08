package pe.upc.experimentos.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pe.upc.experimentos.entity.Cancha;
import pe.upc.experimentos.entity.Deporte;
import pe.upc.experimentos.entity.Equipo;
import pe.upc.experimentos.entity.Jugador;
import pe.upc.experimentos.entity.Reserva;
import pe.upc.experimentos.service.ICanchaService;
import pe.upc.experimentos.service.IDeporteService;
import pe.upc.experimentos.service.IEquipoService;
import pe.upc.experimentos.service.IHorarioService;
import pe.upc.experimentos.service.IJugadorService;
import pe.upc.experimentos.service.ILocalService;
import pe.upc.experimentos.service.IReservaService;



@Controller
public class HomeController {

	@Autowired
	private IEquipoService equipoService;
	
	@Autowired
	private IJugadorService jugadorService;
	
	@Autowired
	private IDeporteService deporteService;
	
	@Autowired
	private ICanchaService canchaService;
	
	@Autowired
	private ILocalService localService;
	
	@Autowired
	private IHorarioService horarioService;
	
	@Autowired
	private IReservaService reservaService;
	
	@GetMapping("/")
	public String home(Model model, HttpSession session) {
		
		//model.addAttribute("administrador", new Administrador());
		
		
		return "index";
	}
	
	@GetMapping("/login" )
	public String mostrarLogin() {
	return "loginForm";
	}
	
	@GetMapping("/user")
    public String userIndex() {
        return "user/index";
    }
	
	@GetMapping("/jugadores")
	public String MostrarJugadores(Model model, HttpSession session) {
		
		model.addAttribute("jugador", new Jugador());	
		
		model.addAttribute("listadoEquipos", equipoService.findAll());
		
		model.addAttribute("listadoJugadores", jugadorService.findAll());
		
		return "jugadores";
	}
	
	
	@GetMapping("/equipos")
	public String MostrarEquipos(Model model, HttpSession session) {
		
		model.addAttribute("equipo", new Equipo());
		
		model.addAttribute("listadoEquipos", equipoService.findAll());
		
		return "equipos";
	}
	
	@GetMapping("/deportes")
	public String MostrarDeportes(Model model, HttpSession session) {
		
		model.addAttribute("deporte", new Deporte());
		
		model.addAttribute("listadoDeportes", deporteService.findAll());
		
		return "deportes";
	}
	
	@GetMapping("/canchas")
	public String MostrarCanchas(Model model, HttpSession session) {
		
		model.addAttribute("cancha", new Cancha());
		
		model.addAttribute("listadoCanchas", canchaService.findAll());
		
		model.addAttribute("listadoDeportes", deporteService.findAll());
		
		model.addAttribute("listadoLocales", localService.findAll());
		
		model.addAttribute("listadoHorarios", horarioService.findAll());
		
		return "canchas";
	}
	
	@GetMapping("/reservas")
	public String MostrarReservas(Model model, HttpSession session) {
		
		model.addAttribute("reserva", new Reserva());
		
		model.addAttribute("listadoReservas", reservaService.findAll());
		
		model.addAttribute("listadoEquipos", equipoService.findAll());
		
		model.addAttribute("listadoCanchas", canchaService.findAll());
		
		return "reservas";
	}
}
