package com.triathlon.demo.dto;

import com.triathlon.demo.modelo.enums.Categoria;
import com.triathlon.demo.modelo.enums.Especialidad;
import com.triathlon.demo.modelo.enums.Genero;
import lombok.Data;

@Data
public class AtletaResponseDTO {

    private Long id;
    private String identificacion;
    private String nombre;
    private String email;
    private int edad;
    private Genero genero;
    private Categoria categoria;
    private Especialidad especialidad;
    private boolean modalidadCross;
    private String fotoBase64;
}