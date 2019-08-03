package com.thiagobrito.xbrain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thiagobrito.xbrain.domain.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}