package com.thiagobrito.xbrain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thiagobrito.xbrain.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, String> {

}
