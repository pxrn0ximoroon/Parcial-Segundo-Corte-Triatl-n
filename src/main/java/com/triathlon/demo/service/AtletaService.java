package com.triathlon.demo.service;

import com.triathlon.demo.dto.AtletaRequestDTO;
import com.triathlon.demo.dto.AtletaResponseDTO;
import com.triathlon.demo.modelo.Atleta;
import com.triathlon.demo.modelo.enums.*;

import java.util.*;

public interface AtletaService {
    AtletaResponseDTO crearAtleta(AtletaRequestDTO atletaRequestDTO);
    AtletaResponseDTO configurarPreferencias(Long id, Especialidad especialidad, boolean modalidadCross);
    AtletaResponseDTO modificarNombre(Long id, String nombre);
    AtletaResponseDTO modificarIdentificacion(Long id, String identificacion);
    AtletaResponseDTO modificarCategoria(Long id, Categoria categoria);
    AtletaResponseDTO modificarEspecialidad(Long id, Especialidad especialidad);
    AtletaResponseDTO modificarCross(Long id, boolean modalidadCross);
    Optional<AtletaResponseDTO> consultarPorIdentificacion(String identificacion);
    List <AtletaResponseDTO> consultarPorCategoria(Categoria categoria);
    List <AtletaResponseDTO> consultarPorGenero(Genero genero);
    List <AtletaResponseDTO> consultarPorEspecialidad(Especialidad especialidad);
    List <AtletaResponseDTO> consultarPorModalidadCross(boolean modalidadCross);
    void eliminarAtleta(Long id);
    void eliminarPorIdentificacion(String identificacion);
}
