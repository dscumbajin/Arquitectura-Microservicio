package com.example.restfull.controller;

import com.example.restfull.entity.Cliente;
import com.example.restfull.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteServiceImpl clienteService;


    @PostMapping()
    public boolean addCliente(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @GetMapping()
    public List<Cliente> findAll(){
        return clienteService.findAll();
    }

    @PutMapping()
    public boolean updateCliente(@RequestBody Cliente cliente){
        return clienteService.update(cliente);
    }

    @DeleteMapping("/{id}")
    public boolean deleteCliente(@PathVariable("id") int id){
        return clienteService.delete(id);
    }
    @GetMapping("/{identificacion}")
    public  Cliente findByIdentificacion(@PathVariable("identificacion") String identificacion){
        return clienteService.findByIdentificacion(identificacion);
    }

}
