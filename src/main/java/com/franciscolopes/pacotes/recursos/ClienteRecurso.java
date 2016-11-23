package com.franciscolopes.pacotes.recursos;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteRecurso {
	@RequestMapping(method = RequestMethod.GET)
	public String todos() {
		return "Executou o metodo todos";
	}
}
