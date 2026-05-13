package com.triathlon.demo.modelo;

import com.triathlon.demo.modelo.enums.Genero;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase base pa representar cualquier persona en el sistema.
 * Es abstracta porque nunca se va a crear una persona sola,
 * siempre va a ser un atleta.
 */
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Persona {

    /** id unico que genera jpa solo, nunca lo toca el usuario */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** numero de documento de la persona */
    private String identificacion;

    /** nombre de la persona */
    private String nombre;

    /** correo electronico */
    private String email;

    /** edad de la persona */
    private int edad;

    /** foto guardada en bytes en la bd */
    @Lob
    private byte[] foto;

    /** genero de la persona, se guarda como texto en la bd */
    @Enumerated(EnumType.STRING)
    private Genero genero;
}