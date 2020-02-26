package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import manager.DigimonManager;

@RestController
public class DigimonController {

	@RequestMapping("/obtenerDigimon")
	public String getDigimon(@RequestParam(value = "nombre") String nombre) {
		
		return new DigimonManager().getDigimon(nombre);
	}
	
	
}
