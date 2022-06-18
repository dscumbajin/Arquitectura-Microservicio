package com.example.restfull.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "personas")
@Table(name = "personas", uniqueConstraints = {@UniqueConstraint(columnNames = {"identificacion"})})
@Inheritance( strategy = InheritanceType.JOINED )
public class Persona {
    @GeneratedValue
    @Id
    @Column(name = "idPersona")
    private int idPersona;

    @Column(name ="nombre", nullable = false)
    private String nombre;

    @Column(name ="genero")
    private String genero;

    @Column(name ="edad")
    private int edad;

    @Column(name ="identificacion", nullable = false, length = 10)
    private String identificacion;

    @Column(name ="direccion", nullable = false)
    private String direccion;

    @Column(name ="telefono", nullable = false, length = 10)
    private String telefono;

}
