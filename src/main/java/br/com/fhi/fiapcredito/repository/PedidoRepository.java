package br.com.fhi.fiapcredito.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fhi.fiapcredito.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, String> {

}
