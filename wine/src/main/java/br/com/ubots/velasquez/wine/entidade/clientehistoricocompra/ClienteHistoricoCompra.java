package br.com.ubots.velasquez.wine.entidade.clientehistoricocompra;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.ubots.velasquez.wine.entidade.cliente.Cliente;
import br.com.ubots.velasquez.wine.entidade.historicocompra.HistoricoCompra;

@Document
public class ClienteHistoricoCompra {

	@Id
	private String id;
	private Cliente cliente;
	private HistoricoCompra historicoCompra;

	public ClienteHistoricoCompra(Cliente cliente, HistoricoCompra historicoCompra) {
		
		this.cliente = cliente;
		this.historicoCompra = historicoCompra;
	}
	public String getid() {
		return id;
	}
	public void setid(String id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public HistoricoCompra getHistoricoCompra() {
		return historicoCompra;
	}
	public void setHistoricoCompra(HistoricoCompra historicoCompra) {
		this.historicoCompra = historicoCompra;
	}
	
}
