package com.triathlon.demo.dto;

import com.triathlon.demo.modelo.enums.Especialidad;
import com.triathlon.demo.modelo.enums.Genero;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class AtletaRequestDTO {

    @NotBlank(message = "La identificación es obligatoria")
    private String identificacion;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Email(message = "El email no es válido")
    @NotBlank(message = "El email es obligatorio")
    private String email;

    @Min(value = 7, message = "La edad mínima es 7 años")
    @Max(value = 120, message = "La edad no es válida")
    private int edad;

    @NotNull(message = "El género es obligatorio")
    private Genero genero;

    @NotNull(message = "La especialidad es obligatoria")
    private Especialidad especialidad;
    private String foto;
    private boolean modalidadCross;
}