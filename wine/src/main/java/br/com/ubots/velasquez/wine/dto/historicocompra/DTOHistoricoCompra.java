package br.com.ubots.velasquez.wine.dto.historicocompra;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.ubots.velasquez.wine.entidade.historicocompra.Item;

public class DTOHistoricoCompra {

	private int id;
	private String codigo;
	private String data;
	private String cliente;
	private double valorTotal;
	private List<DTOItens> itens;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
		
	}
	public double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		
		if (cliente.equals(null) || cliente.equals("") || cliente.isEmpty()) {
		
			this.cliente = cliente;
			
		}else {

			cliente = cliente.replace(".", "").replace("-", "")	;
			cliente = cliente.length() == 11 ? cliente : cliente.substring(1);

			this.cliente = cliente;
		}

	}
	
	public List<DTOItens> getItens() {
		return itens;
	}
	public void setItens(List<DTOItens> itens) {
		this.itens = itens;
	} 


	
}
