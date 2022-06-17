package com.example.restfull.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name= "cuentas")
@Table(name = "cuentas", uniqueConstraints = {@UniqueConstraint(columnNames = {"numero"})})
public class Cuenta {

    @GeneratedValue
    @Id
    @Column(name = "idCuenta")
    private int idCuenta;

    @Column(name = "numero", nullable = false)
    @NotNull
    private String numero;

    @Column(name = "tipo", nullable = false)
    @NotNull
    private String tipo;

    @Column(name = "saldoInicial", nullable = false)
    @NotNull
    private double saldoInicial;

    @Column(name = "estado", nullable = false)
    @NotNull
    private boolean estado;

    @ManyToOne
    @JoinColumn( name = "idCliente", nullable = false)
    Cliente cliente;

    @OneToMany(mappedBy = "cuenta")
    List<Movimiento> movimientos;
}
