package com.example.restfull.service;

import com.example.restfull.entity.Cliente;

import java.util.List;

public interface IClienteService {

    public boolean save(Cliente cliente);
    public List<Cliente> findAll();

    public boolean update(Cliente cliente);

    public boolean delete(int idCliente);

    public Cliente findByIdentificacion(String idenitficacion);

}
