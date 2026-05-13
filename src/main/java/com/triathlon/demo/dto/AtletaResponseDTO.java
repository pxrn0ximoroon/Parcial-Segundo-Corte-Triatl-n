package com.triathlon.demo.dto;

import com.triathlon.demo.modelo.enums.Categoria;
import com.triathlon.demo.modelo.enums.Especialidad;
import com.triathlon.demo.modelo.enums.Genero;
import lombok.Data;

/**
 * DTO con los datos del atleta que se le manda al frontend.
 * La foto se manda en base64 para que el frontend la pueda mostrar
 */
@Data
public class AtletaResponseDTO {

    /** id interno del atleta en la bd */
    private Long id;

    /** numero de documento del atleta */
    private String identificacion;

    /** nombre del atleta */
    private String nombre;

    /** correo del atleta */
    private String email;

    /** edad del atleta */
    private int edad;

    /** genero del atleta */
    private Genero genero;

    /** categoria del atleta segun su edad */
    private Categoria categoria;

    /** especialidad en la que participa el atleta */
    private Especialidad especialidad;

    /** si participa en modalidad cross o no */
    private boolean modalidadCross;

    /** foto del atleta convertida a base64 para mostrarla en el frontend */
    private String fotoBase64;
}