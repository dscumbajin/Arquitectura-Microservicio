package com.example.restfull.service;

import com.example.restfull.entity.Cliente;
import com.example.restfull.repository.ClienteRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Log4j2
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public boolean save(Cliente cliente) {

        log.info("Ingreso metodo save cliente");
        try {
            clienteRepository.save(cliente);
            log.info("Cliente Creado");
            return true;
        }catch (Exception e){
            log.error(e);
            return false;
        }

    }

    @Override
    public boolean saveAll(List<Cliente> clientes) {
        log.info("Ingreso metodo save cliente");
        try {
            clienteRepository.saveAll(clientes);
            log.info("Cliente Creado");
            return true;
        }catch (Exception e){
            log.error(e);
            return false;
        }
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public boolean update(Cliente cliente) {

        log.info("Ingreso metodo update cliente");
        try {
            clienteRepository.save(cliente);
            log.info("Cliente Actualizado");
            return true;
        }catch (Exception e){
            log.error(e);
            return false;
        }
    }

    @Override
    public boolean delete(int idCliente) {
        try {
            Optional<Cliente> cliente = clienteRepository.findById(idCliente);
            clienteRepository.delete(cliente.get());
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Cliente findByIdentificacion(String idenitficacion) {
        return clienteRepository.findByIdentificacion(idenitficacion);
    }


}
