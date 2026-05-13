package com.triathlon.demo.controller;

import com.triathlon.demo.dto.AtletaRequestDTO;
import com.triathlon.demo.dto.AtletaResponseDTO;
import com.triathlon.demo.modelo.enums.*;
import com.triathlon.demo.service.AtletaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador rest para manejar todo lo relacionado con los atletas
 * Aqui estan todos los endpoints que el frontend puede consumir
 */
@RestController
@RequestMapping("/atleta")
public class AtletaController {

    /** servicio donde esta la logica de los atletas */
    @Autowired
    private AtletaService atletaService;

    /** endpoint para registrar un atleta nuevo, recibe el json del frontend */
    @PostMapping("/crear")
    public AtletaResponseDTO crearAtleta(@RequestBody @Valid AtletaRequestDTO dto) {
        return atletaService.crearAtleta(dto);
    }

    /** guarda las preferencias de especialidad y modalidad cross del atleta */
    @PutMapping("/{id}/preferencias")
    public AtletaResponseDTO configurarPreferencias(@PathVariable Long id,
                                                    @RequestParam Especialidad especialidad,
                                                    @RequestParam boolean modalidadCross) {
        return atletaService.configurarPreferencias(id, especialidad, modalidadCross);
    }

    /** cambia el nombre de un atleta buscandolo por su id */
    @PutMapping("/{id}/nombre")
    public AtletaResponseDTO modificarNombre(@PathVariable Long id,
                                             @RequestParam String nombre) {
        return atletaService.modificarNombre(id, nombre);
    }

    /** cambia el numero de documento de un atleta */
    @PutMapping("/{id}/identificacion")
    public AtletaResponseDTO modificarIdentificacion(@PathVariable Long id,
                                                     @RequestParam String identificacion) {
        return atletaService.modificarIdentificacion(id, identificacion);
    }

    /** cambia la categoria de un atleta */
    @PutMapping("/{id}/categoria")
    public AtletaResponseDTO modificarCategoria(@PathVariable Long id,
                                                @RequestParam Categoria categoria) {
        return atletaService.modificarCategoria(id, categoria);
    }

    /** busca un atleta por su numero de documento */
    @GetMapping("/identificacion/{identificacion}")
    public Optional<AtletaResponseDTO> consultarPorIdentificacion(@PathVariable String identificacion) {
        return atletaService.consultarPorIdentificacion(identificacion);
    }

    /** retorna todos los atletas de un genero */
    @GetMapping("/genero/{genero}")
    public List<AtletaResponseDTO> consultarPorGenero(@PathVariable Genero genero) {
        return atletaService.consultarPorGenero(genero);
    }

    /** retorna todos los atletas de una categoria */
    @GetMapping("/categoria/{categoria}")
    public List<AtletaResponseDTO> consultarPorCategoria(@PathVariable Categoria categoria) {
        return atletaService.consultarPorCategoria(categoria);
    }

    /** retorna todos los atletas de una especialidad */
    @GetMapping("/especialidad/{especialidad}")
    public List<AtletaResponseDTO> consultarPorEspecialidad(@PathVariable Especialidad especialidad) {
        return atletaService.consultarPorEspecialidad(especialidad);
    }

    /** retorna atletas segun si participan en modalidad cross o no */
    @GetMapping("/cross/{modalidadCross}")
    public List<AtletaResponseDTO> consultarPorModalidadCross(@PathVariable boolean modalidadCross) {
        return atletaService.consultarPorModalidadCross(modalidadCross);
    }

    /** elimina un atleta por su id interno de la bd */
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        atletaService.eliminarAtleta(id);
    }

    /** elimina un atleta por su numero de documento */
    @DeleteMapping("/identificacion/{identificacion}")
    public void eliminarPorIdentificacion(@PathVariable String identificacion) {
        atletaService.eliminarPorIdentificacion(identificacion);
    }

    /** cambia la especialidad de un atleta */
    @PutMapping("/{id}/especialidad")
    public AtletaResponseDTO modificarEspecialidad(@PathVariable Long id,
                                                   @RequestParam Especialidad especialidad) {
        return atletaService.modificarEspecialidad(id, especialidad);
    }

    /** cambia si el atleta participa en cross o no */
    @PutMapping("/{id}/cross")
    public AtletaResponseDTO modificarCross(@PathVariable Long id,
                                            @RequestParam boolean modalidadCross) {
        return atletaService.modificarCross(id, modalidadCross);
    }
}