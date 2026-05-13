package com.triathlon.demo.dto;

import com.triathlon.demo.modelo.enums.Especialidad;
import com.triathlon.demo.modelo.enums.Genero;
import jakarta.validation.constraints.*;
import lombok.Data;

/**
 * DTO con los datos que manda el frontend para registrar un atleta
 * Tiene validaciones para asegurarse que los datos lleguen bien.
 */
@Data
public class AtletaRequestDTO {

    /** numero de documento, no puede llegar vacio */
    @NotBlank(message = "La identificación es obligatoria")
    private String identificacion;

    /** nombre del atleta, tampoco puede llegar vacio */
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    /** correo del atleta, tiene que tener formato de email valido */
    @Email(message = "El email no es válido")
    @NotBlank(message = "El email es obligatorio")
    private String email;

    /** edad del atleta, minimo 7 años y maximo 120 */
    @Min(value = 7, message = "La edad mínima es 7 años")
    @Max(value = 120, message = "La edad no es válida")
    private int edad;

    /** genero del atleta, no puede ser nulo */
    @NotNull(message = "El género es obligatorio")
    private Genero genero;

    /** especialidad del atleta, no puede ser nula */
    @NotNull(message = "La especialidad es obligatoria")
    private Especialidad especialidad;

    /** foto del atleta en base64, puede llegar nula si no sube foto */
    private String foto;

    /** indica si el atleta participa en modalidad cross */
    private boolean modalidadCross;
}