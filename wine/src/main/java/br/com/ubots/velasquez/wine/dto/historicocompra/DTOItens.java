package br.com.ubots.velasquez.wine.dto.historicocompra;

public class DTOItens {

	private String produto;
	private String variedade;
	private String pais;
	private String categoria;
	private String safra;
	private double preco;
	

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
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
}
