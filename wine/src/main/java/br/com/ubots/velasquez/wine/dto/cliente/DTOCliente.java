package br.com.ubots.velasquez.wine.dto.cliente;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonSerialize
public class DTOCliente {

		private int id;
		private String nome;
		private String cpf;

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}

		public String getCpf() {
			return cpf;
		}
		
		public void setCpf(String cpf) {
		
			if (cpf.equals(null) || cpf.equals("") || cpf.isEmpty()) {
				
				this.cpf = cpf;
	
			}else {
				
				cpf = cpf.replace(".", "").replace("-", "")	;
				cpf = cpf.length() == 11 ? cpf : cpf.substring(1);
	
				this.cpf = cpf;		
			}
			
		}
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
	
}
