package com.example.restfull.controller;

import com.example.restfull.dto.ClienteDTO;
import com.example.restfull.entity.Cliente;
import com.example.restfull.service.ClienteServiceImpl;
import com.example.restfull.utils.ApiUnprocessableEntity;
import com.example.restfull.validator.ClienteValidatorImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private ClienteValidatorImpl clienteValidator;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>  saveCliente(@RequestBody Cliente cliente) throws ApiUnprocessableEntity {
        clienteValidator.validador(cliente);
        clienteService.save(cliente);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @PostMapping(value = "saveAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> saveAllClientes (@RequestBody List<Cliente> clientes){
        clienteService.saveAll(clientes);
        return ResponseEntity.ok(Boolean.TRUE);
    }
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updateCliente(@RequestBody Cliente cliente){
        clienteService.update(cliente);
        return ResponseEntity.ok(Boolean.TRUE);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteCliente(@PathVariable("id") int id){
        clienteService.delete(id);
        return ResponseEntity.ok(Boolean.TRUE);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object>  findAll(){
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes.stream().map(this::convertToDto).collect(Collectors.toList()));
    }
    @GetMapping(value = "/{identificacion}", produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<Object> findByIdentificacion(@PathVariable("identificacion") String identificacion){
        return ResponseEntity.ok( clienteService.findByIdentificacion(identificacion));
    }

    private ClienteDTO convertToDto(Cliente cliente){
        ClienteDTO clienteDTO= modelMapper.map(cliente, ClienteDTO.class);
        return  clienteDTO;
    }
}
