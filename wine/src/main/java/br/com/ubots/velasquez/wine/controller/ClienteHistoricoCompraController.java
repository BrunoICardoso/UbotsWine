package br.com.ubots.velasquez.wine.controller;

import java.lang.annotation.Annotation;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.repository.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ubots.velasquez.wine.entidade.clientehistoricocompra.ClienteHistoricoCompra;
import br.com.ubots.velasquez.wine.repositorio.clientehistoricocompra.RepositorioClienteHistoricoCompra;


@RestController
@RequestMapping("/ClienteHistCompra")
public class ClienteHistoricoCompraController {

	private RepositorioClienteHistoricoCompra repositorioClienteHistoricoCompra;

   public ClienteHistoricoCompraController(RepositorioClienteHistoricoCompra repositorioClienteHistoricoCompra) {
		
		this.repositorioClienteHistoricoCompra = repositorioClienteHistoricoCompra;
	}
	
	@GetMapping("/ListaCompraClienteValorTotalDesc")
	 public List<ClienteHistoricoCompra> ListaCompraClienteValorTotalDesc() {
		 
		return repositorioClienteHistoricoCompra.findAll(new Sort(Direction.DESC, "historicoCompra.ValorTotal"));
		 
	 }
	
	
	@GetMapping("/ListaCompraClienteMaiorCompraUnicaUltimoAno")
	 public List<ClienteHistoricoCompra> ListaCompraClienteMaiorCompraUnicaUltimoAno() {

		// Não está terminanda
		
		return repositorioClienteHistoricoCompra.findAll(new Sort(Direction.DESC, "historicoCompra.ValorTotal"));
	 }

}
