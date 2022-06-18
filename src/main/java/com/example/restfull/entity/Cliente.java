package com.example.restfull.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "clientes")
@Table(name = "clientes")
@PrimaryKeyJoinColumn(name ="idCliente")
public class Cliente extends Persona {

    @Column(name ="contrasena", nullable = false)
    private String contrasena;

    @Column(name ="estado", nullable = false)
    private boolean estado;

    @OneToMany(mappedBy = "cliente")
    List<Cuenta> cuentas;

}
