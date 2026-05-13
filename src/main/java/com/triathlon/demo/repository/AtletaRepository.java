package com.triathlon.demo.repository;

import com.triathlon.demo.modelo.Atleta;
import com.triathlon.demo.modelo.enums.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

/**
 * Repositorio pa manejar los atletas en la bd.
 * Spring genera todo el sql solo segun el nombre de cada metodo,
 * no toca escribir nada de sql a mano.
 */
public interface AtletaRepository extends JpaRepository<Atleta, Long> {

    /** trae todos los atletas de un genero */
    List<Atleta> findByGenero(Genero genero);

    /** busca un atleta por su numero de documento, retorna optional por si no existe */
    Optional<Atleta> findByIdentificacion(String identificacion);

    /** trae todos los atletas de una categoria */
    List<Atleta> findByCategoria(Categoria categoria);

    /** trae todos los atletas de una especialidad */
    List<Atleta> findByEspecialidad(Especialidad especialidad);

    /** trae atletas segun si participan en cross o no */
    List<Atleta> findByModalidadCross(boolean modalidadCross);

    /** borra un atleta de la bd usando su numero de documento */
    void deleteByIdentificacion(String identificacion);
}