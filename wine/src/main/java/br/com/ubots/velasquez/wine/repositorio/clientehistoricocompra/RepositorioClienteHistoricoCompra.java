package br.com.ubots.velasquez.wine.repositorio.clientehistoricocompra;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ubots.velasquez.wine.entidade.clientehistoricocompra.ClienteHistoricoCompra;

@Repository
public interface RepositorioClienteHistoricoCompra extends MongoRepository<ClienteHistoricoCompra, String>{

}
