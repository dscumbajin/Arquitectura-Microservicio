package com.example.restfull.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name= "movimientos")
@Table(name = "movimientos")
public class Movimiento {

    @GeneratedValue
    @Id
    @Column(name = "idMovimiento")
    private int idMovimiento;

    @Column(name = "fecha", nullable = false)
    @NotNull
    private Date fecha;

    @Column(name = "tipo", nullable = false)
    @NotNull
    private String tipo;

    @Column(name = "valor", nullable = false)
    @NotNull
    private String valor;

    @Column(name = "saldo", nullable = false)
    @NotNull
    private Double saldo;

    @ManyToOne
    @JoinColumn( name = "cue_numero", nullable = false)
    Cuenta cuenta;
}
