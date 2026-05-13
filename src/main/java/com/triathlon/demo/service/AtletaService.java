package com.triathlon.demo.service;

import com.triathlon.demo.dto.AtletaRequestDTO;
import com.triathlon.demo.dto.AtletaResponseDTO;
import com.triathlon.demo.modelo.Atleta;
import com.triathlon.demo.modelo.enums.*;

import java.util.*;
/**
 * Esta es la interfaz que define todo lo que se puede hacer con los atletas.
 * se ponen los nombres de los métodos para que luego la clase Impl
 * se encargue de escribir la lógica real de cada uno.
 */
public interface AtletaService {
    /**
     * Para registrar un atleta nuevo en el sistema.
     */
    AtletaResponseDTO crearAtleta(AtletaRequestDTO atletaRequestDTO);
    /**
     * modifica la especialidad y si el atleta hace cross.
     */
    AtletaResponseDTO configurarPreferencias(Long id, Especialidad especialidad, boolean modalidadCross);
    /**
     * Para modificar nombre     */
    AtletaResponseDTO modificarNombre(Long id, String nombre);

    /**
     *Metodo para modificar identificacion     */
    AtletaResponseDTO modificarIdentificacion(Long id, String identificacion);

    /**
     * metodo modificar categoria     */
    AtletaResponseDTO modificarCategoria(Long id, Categoria categoria);

    /**
     * metodo modificar especialidad     */
    AtletaResponseDTO modificarEspecialidad(Long id, Especialidad especialidad);

    /**
     * metodo para modificar cross
     */
    AtletaResponseDTO modificarCross(Long id, boolean modalidadCross);
    /**
     * metodo para consultar por identificacion
     */
    Optional<AtletaResponseDTO> consultarPorIdentificacion(String identificacion);
    /**
     * metodo para consultar por categoria
     */
    List <AtletaResponseDTO> consultarPorCategoria(Categoria categoria);
    /**
     * metodo para consultar por genero
     */
    List <AtletaResponseDTO> consultarPorGenero(Genero genero);
    /**
     * metodo para consultar por especialidad
     */
    List <AtletaResponseDTO> consultarPorEspecialidad(Especialidad especialidad);
    /**
     * metodo para consultar por imodalidadCross
     */
    List <AtletaResponseDTO> consultarPorModalidadCross(boolean modalidadCross);
    /**
     * metodo para eliminar por id
     */
    void eliminarAtleta(Long id);
    /**
     * metodo para eliminar por identificacion
     */
    void eliminarPorIdentificacion(String identificacion);
}
