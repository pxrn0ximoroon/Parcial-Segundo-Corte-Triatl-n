package com.triathlon.demo.modelo;

import com.triathlon.demo.modelo.enums.Genero;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String identificacion;
    private String nombre;
    private String email;
    private int edad;

    @Lob
    private byte[] foto;
    @Enumerated(EnumType.STRING)
    private Genero genero;



}
