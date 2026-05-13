package com.triathlon.demo.controller;

import com.triathlon.demo.dto.AtletaRequestDTO;
import com.triathlon.demo.dto.AtletaResponseDTO;
import com.triathlon.demo.modelo.enums.*;
import com.triathlon.demo.service.AtletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atleta")
public class AtletaController {

    @Autowired
    private AtletaService atletaService;

    @PostMapping("/crear")
    public AtletaResponseDTO crearAtleta(@RequestBody AtletaRequestDTO dto) {
        return atletaService.crearAtleta(dto);
    }

    @PutMapping("/{id}/preferencias")
    public AtletaResponseDTO configurarPreferencias(@PathVariable Long id,
                                                    @RequestParam Especialidad especialidad,
                                                    @RequestParam boolean modalidadCross) {
        return atletaService.configurarPreferencias(id, especialidad, modalidadCross);
    }

    @PutMapping("/{id}/nombre")
    public AtletaResponseDTO modificarNombre(@PathVariable Long id,
                                             @RequestParam String nombre) {
        return atletaService.modificarNombre(id, nombre);
    }

    @PutMapping("/{id}/identificacion")
    public AtletaResponseDTO modificarIdentificacion(@PathVariable Long id,
                                                     @RequestParam String identificacion) {
        return atletaService.modificarIdentificacion(id, identificacion);
    }

    @PutMapping("/{id}/categoria")
    public AtletaResponseDTO modificarCategoria(@PathVariable Long id,
                                                @RequestParam Categoria categoria) {
        return atletaService.modificarCategoria(id, categoria);
    }

    @GetMapping("/identificacion/{identificacion}")
    public Optional<AtletaResponseDTO> consultarPorIdentificacion(@PathVariable String identificacion) {
        return atletaService.consultarPorIdentificacion(identificacion);
    }

    @GetMapping("/genero/{genero}")
    public List<AtletaResponseDTO> consultarPorGenero(@PathVariable Genero genero) {
        return atletaService.consultarPorGenero(genero);
    }

    @GetMapping("/categoria/{categoria}")
    public List<AtletaResponseDTO> consultarPorCategoria(@PathVariable Categoria categoria) {
        return atletaService.consultarPorCategoria(categoria);
    }

    @GetMapping("/especialidad/{especialidad}")
    public List<AtletaResponseDTO> consultarPorEspecialidad(@PathVariable Especialidad especialidad) {
        return atletaService.consultarPorEspecialidad(especialidad);
    }

    @GetMapping("/cross/{modalidadCross}")
    public List<AtletaResponseDTO> consultarPorModalidadCross(@PathVariable boolean modalidadCross) {
        return atletaService.consultarPorModalidadCross(modalidadCross);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        atletaService.eliminarAtleta(id);
    }
    @DeleteMapping("/identificacion/{identificacion}")
    public void eliminarPorIdentificacion(@PathVariable String identificacion) {
        atletaService.eliminarPorIdentificacion(identificacion);
    }
    @PutMapping("/{id}/especialidad")
    public AtletaResponseDTO modificarEspecialidad(@PathVariable Long id,
                                                   @RequestParam Especialidad especialidad) {
        return atletaService.modificarEspecialidad(id, especialidad);
    }

    @PutMapping("/{id}/cross")
    public AtletaResponseDTO modificarCross(@PathVariable Long id,
                                            @RequestParam boolean modalidadCross) {
        return atletaService.modificarCross(id, modalidadCross);
    }
}