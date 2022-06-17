package com.example.restfull.repository;

import com.example.restfull.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Serializable> {

    public Cliente findByIdentificacion(String identificacion);

}
