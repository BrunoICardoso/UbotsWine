package br.com.ubots.velasquez.wine.entidade.historicocompra;

import java.util.List;

public class HistoricoCompra {
	
	private String id;
	private String codigo;
	private String data;
	private String cliente;
	private Double valorTotal;
	private List<Item> itens;

	public HistoricoCompra(String codigo, String data, String cliente, Double valorTotal, List<Item> itens) {
		
		this.codigo = codigo;
		this.data = data;
		this.cliente = cliente;
		this.valorTotal = valorTotal;
		this.itens = itens;
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
		this.cliente = cliente;
	}
	
	public List<Item> getItens() {
		return itens;
	}
	public void setItens(List<Item> itens) {
		this.itens = itens;
	} 

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
