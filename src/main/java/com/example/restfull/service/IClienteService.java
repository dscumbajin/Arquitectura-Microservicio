package com.example.restfull.service;

import com.example.restfull.entity.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IClienteService {

    public boolean save(Cliente cliente);
    public boolean saveAll(List<Cliente> clientes);
    public List<Cliente> findAll();
    public boolean update(Cliente cliente);
    public boolean delete(int idCliente);
    public Cliente findByIdentificacion(String idenitficacion);

}
