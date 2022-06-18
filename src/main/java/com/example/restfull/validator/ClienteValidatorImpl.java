package com.example.restfull.validator;

import com.example.restfull.entity.Cliente;
import com.example.restfull.service.ClienteServiceImpl;
import com.example.restfull.utils.ApiUnprocessableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClienteValidatorImpl implements IClienteValidador{
    @Autowired
    private ClienteServiceImpl clienteService;
    @Override
    public void validador(Cliente cliente) throws ApiUnprocessableEntity {
        if(cliente.getIdentificacion() == null || cliente.getIdentificacion().isEmpty()){
            message("La identificacion es requerida");
        }
        if(cliente.getIdentificacion().length() > 11){
            message("La identificacion debe tener 10 caracteres");
        }

        if(!cliente.getIdentificacion().isEmpty() ){
            Cliente buscado = clienteService.findByIdentificacion(cliente.getIdentificacion());
            if (buscado != null ){
            message("La identificacion debe ser unica");
            }
        }
    }

    private void message(String message) throws ApiUnprocessableEntity{
        throw new ApiUnprocessableEntity(message);
    }
}
