package br.com.ubots.velasquez.wine.ConfigCadastro;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.ubots.velasquez.wine.dto.cliente.DTOCliente;
import br.com.ubots.velasquez.wine.dto.historicocompra.DTOHistoricoCompra;
import br.com.ubots.velasquez.wine.dto.historicocompra.DTOItens;
import br.com.ubots.velasquez.wine.entidade.cliente.Cliente;
import br.com.ubots.velasquez.wine.entidade.clientehistoricocompra.ClienteHistoricoCompra;
import br.com.ubots.velasquez.wine.entidade.historicocompra.HistoricoCompra;
import br.com.ubots.velasquez.wine.entidade.historicocompra.Item;
import br.com.ubots.velasquez.wine.repositorio.clientehistoricocompra.RepositorioClienteHistoricoCompra;

@EnableMongoRepositories(basePackageClasses = RepositorioClienteHistoricoCompra.class)
@Configuration
public class Cadastro {

	private static final Logger log = LoggerFactory.getLogger(Cadastro.class);
	private List<Cliente> ListaClientes;
	private List<HistoricoCompra> ListaHistoricoCompras;
	
	private List<Cliente> RetornarListaClientes(){
		
		try {
			
			List<Cliente> ListaEntidadecliente = new ArrayList<Cliente>();

			String UrlCliente = "http://www.mocky.io/v2/598b16291100004705515ec5";

			ResponseEntity<List<DTOCliente>> EntidadeJSONRespostaClientes = new RestTemplate()
																							 .exchange(UrlCliente,
																									   HttpMethod.GET, 
																									   null, 
																									   new ParameterizedTypeReference<List<DTOCliente>>() {
					});
			
			List<DTOCliente> Listacliente = EntidadeJSONRespostaClientes.getBody();

			for (DTOCliente dtocliente : Listacliente) {

				ListaEntidadecliente.add(new Cliente(dtocliente.getId(), 
													 dtocliente.getNome(), 
													 dtocliente.getCpf()));
			}
			
			return ListaEntidadecliente;

			
		}
		
		catch (Exception e) {
			log.error("Ocorreu erro na função RetornarListaClientes: {} ", e.getMessage());
			
			return null;
		}
		
			}
	
	private List<HistoricoCompra>  RetornarListaHistoricoCompras(){
		
		try {
		
			List<HistoricoCompra> ListaEntidadeHistCompra = new ArrayList<HistoricoCompra>();
			
			String UrlHistoricoCompra = "http://www.mocky.io/v2/598b16861100004905515ec7";

			ResponseEntity<List<DTOHistoricoCompra>> EntidadeJSONRespostaHisCompra = new RestTemplate()
																							.exchange(UrlHistoricoCompra,
																									  HttpMethod.GET, 
																									  null, 
																									  new ParameterizedTypeReference<List<DTOHistoricoCompra>>() {
																						});
			
			List<DTOHistoricoCompra> Listacliente = EntidadeJSONRespostaHisCompra.getBody();

			for (DTOHistoricoCompra dtohiscompra : Listacliente) {
				
				List<Item> ListaItem = new ArrayList<Item>();
				
				for(DTOItens dtoitem : dtohiscompra.getItens()) {
					
					ListaItem.add(new Item(dtoitem.getProduto(),
										   dtoitem.getVariedade(),
										   dtoitem.getPais(),
										   dtoitem.getCategoria(),
										   dtoitem.getSafra(),
										   dtoitem.getPreco()
										   ));
				}
				
				
				ListaEntidadeHistCompra.add(new HistoricoCompra(dtohiscompra.getCodigo(), 
																dtohiscompra.getData(), 
																dtohiscompra.getCliente(),
																dtohiscompra.getValorTotal(),
																ListaItem
																));			
				}

			return ListaEntidadeHistCompra;

			
			
		} 
		catch (Exception e) {

			log.error("Ocorreu erro na função RetornarListaHistoricoCompras: {} ", e.getMessage());
			
			return null;

		}
		
	}
	
	private List<ClienteHistoricoCompra> RetornarListaClienteHistoricoCompra(){
		
			ListaClientes = RetornarListaClientes();
			ListaHistoricoCompras = RetornarListaHistoricoCompras();
			List<ClienteHistoricoCompra> ListaClienteHistoricoCompras = new ArrayList<ClienteHistoricoCompra>();
			
			for(Cliente cliente : ListaClientes) {
				
				for(HistoricoCompra historicoCompra : ListaHistoricoCompras) {
					
					if(cliente.getCpf().equals(historicoCompra.getCliente())) {
						
						ListaClienteHistoricoCompras.add(new ClienteHistoricoCompra(cliente, historicoCompra));
						
					}
				}
			}
			
			return ListaClienteHistoricoCompras;
	}
	

	@Bean
	CommandLineRunner commandLineRunnerHistoricoCompra(RepositorioClienteHistoricoCompra repositorioClienteHistoricoCompra) {
		return strings -> {
			
			log.info("Cadastrando Cliente Historico de Compra através da API de Velasquez");

			repositorioClienteHistoricoCompra.saveAll(RetornarListaClienteHistoricoCompra());
		};

	}

	
}
