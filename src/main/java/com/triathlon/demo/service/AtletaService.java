package com.triathlon.demo.service;

import com.triathlon.demo.modelo.Atleta;
import com.triathlon.demo.modelo.enums.*;

import java.util.*;

public interface AtletaService {
    Atleta crearAtleta(Atleta atleta);
    Atleta configurarPreferencias(Long id, Especialidad especialidad, boolean modalidadCross);
    Atleta modificarNombre(Long id, String nombre);
    Atleta modificarIdentificacion(Long id, String identificacion);
    Atleta modificarCategoria(Long id, Categoria categoria);
    Optional<Atleta> consultarPorIdentificacion(String identificacion);
    List <Atleta> consultarPorCategoria(Categoria categoria);
    List <Atleta> consultarPorGenero(Genero genero);
    List <Atleta> consultarPorEspecialidad(Especialidad especialidad);
    List <Atleta> consultarPorModalidadCross(boolean modalidadCross);
    void eliminarAtleta(Long id);

}
