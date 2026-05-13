package com.triathlon.demo.repository;

import com.triathlon.demo.modelo.Atleta;
import com.triathlon.demo.modelo.enums.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AtletaRepository extends JpaRepository<Atleta, Long> {
     List<Atleta> findByGenero(Genero genero);

    Optional<Atleta> findByIdentificacion(String identificacion);

    List<Atleta> findByCategoria(Categoria categoria);
    List<Atleta> findByEspecialidad(Especialidad especialidad);
    List<Atleta> findByModalidadCross(boolean modalidadCross);
    void deleteByIdentificacion(String identificacion);
}
