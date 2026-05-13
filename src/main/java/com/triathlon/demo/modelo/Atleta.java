package com.triathlon.demo.modelo;

import com.triathlon.demo.modelo.enums.Categoria;
import com.triathlon.demo.modelo.enums.Especialidad;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad que representa un atleta del triatlon.
 * Hereda los datos basicos de Persona y le agrega
 * los atributos propios del deporte.
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Atleta extends Persona {

    /** si el atleta participa en modalidad cross o no */
    private boolean modalidadCross;

    /** categoria del atleta, se calcula sola segun la edad */
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    /** distancia en la que va a competir el atleta */
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
}