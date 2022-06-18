package com.example.restfull.controller;

import com.example.restfull.dto.ClienteDTO;
import com.example.restfull.entity.Cliente;
import com.example.restfull.service.ClienteServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping()
    public boolean addCliente(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @PostMapping("saveAll")
    public boolean saveAllClientes (@RequestBody List<Cliente> clientes){
        return clienteService.saveAll(clientes);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClienteDTO> findAll(){
        List<Cliente> clientes = clienteService.findAll();
        return clientes.stream().map(this::convertToDto).collect(Collectors.toList());
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

    private ClienteDTO convertToDto(Cliente cliente){
        ClienteDTO clienteDTO= modelMapper.map(cliente, ClienteDTO.class);
        return  clienteDTO;
    }
}
