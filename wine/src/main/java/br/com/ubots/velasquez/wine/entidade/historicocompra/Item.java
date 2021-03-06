package br.com.ubots.velasquez.wine.entidade.historicocompra;

public class Item {

	private String produto;
	private String variedade;
	private String pais;
	private String categoria;
	private String safra;
	private Double preco;
	
	

	public Item(String produto, String variedade, String pais, String categoria, String safra, Double preco) {

		this.produto = produto;
		this.variedade = variedade;
		this.pais = pais;
		this.categoria = categoria;
		this.safra = safra;
		this.preco = preco;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getProduto() {
		return produto;
	}
	public void setProduto(String produto) {
		this.produto = produto;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getVariedade() {
		return variedade;
	}
	public void setVariedade(String variedade) {
		this.variedade = variedade;
	}
	public String getSafra() {
		return safra;
	}
	public void setSafra(String safra) {
		this.safra = safra;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
	

