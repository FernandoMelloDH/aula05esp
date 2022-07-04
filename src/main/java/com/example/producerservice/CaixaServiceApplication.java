package com.example.producerservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class CaixaServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(CaixaServiceApplication.class, args);
	}
}

@RestController
class CaixaController {
	@Value("${valor_maximo_em_dinheiro}")
	private int maxValorCaixa;
	
	@Value("${notas_tipos}")
	private int[] tiposNotas;
	
	@RequestMapping(method = RequestMethod.GET, path ="/caixa/info")
	public Map<String, String> message() {
		Map<String, String> response = new HashMap<>();
		
		response.put("\n" +
				"Quantidade máxima de dinheiro por caixa: ",String.valueOf(maxValorCaixa));

		int i = 1;
		for (int domain:tiposNotas) {
			response.put("Tipos " + i, String.valueOf(domain));
			i++;
		}

		return response;
	}
}