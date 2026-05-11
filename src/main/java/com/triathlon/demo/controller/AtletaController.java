package com.triathlon.demo.controller;

import java.util.*;
import com.triathlon.demo.modelo.Atleta;
import com.triathlon.demo.modelo.enums.*;
import com.triathlon.demo.service.AtletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/atleta")
public class AtletaController {

    @Autowired
    private AtletaService atletaService;

    @PostMapping("/crear")
    public Atleta crearAtleta(@RequestBody Atleta atleta) {
        return atletaService.crearAtleta(atleta);
    }

    @PutMapping("/{id}/preferencias")
    public Atleta configurarPreferencias(@PathVariable Long id,
                                         @RequestParam Especialidad especialidad,
                                         @RequestParam boolean modalidadCross) {
    return  atletaService.configurarPreferencias(id, especialidad, modalidadCross);
    }

   @PutMapping("/{id}/nombre")
   public  Atleta modificarNombre(@PathVariable Long id,
                                  @RequestParam String nombre) {
       return atletaService.modificarNombre(id, nombre);
   }

   @PutMapping("/{id}/identificacion")
   public Atleta modificarIdentificacion(@PathVariable Long id,
                                         @RequestParam String identificacion){
    return atletaService.modificarIdentificacion(id, identificacion);
    }

    @PutMapping("/{id}/categoria")
    public Atleta modificarCategoria(@PathVariable Long id,
                                     @RequestParam Categoria categoria){
    return atletaService.modificarCategoria(id, categoria);
    }

    @GetMapping("/identificacion/{identificacion}")
    public Optional<Atleta> consultarPorIdentificacion(@PathVariable String identificacion){
        return atletaService.consultarPorIdentificacion(identificacion);
    }

    @GetMapping("/genero/{genero}")
    public List<Atleta> consultarPorGenero(@PathVariable Genero genero){
        return atletaService.consultarPorGenero(genero);
    }

    @GetMapping("/categoria/{categoria}")
    public List<Atleta> consultarPorCategoria(@PathVariable Categoria categoria){
        return atletaService.consultarPorCategoria(categoria);
    }

    @GetMapping("/especialidad/{especialidad}")
    public List<Atleta> consultarPorEspecialidad(@PathVariable Especialidad especialidad){
        return atletaService.consultarPorEspecialidad(especialidad);
    }

    @GetMapping("/cross/{modalidadCross}")
    public List<Atleta> consultarPorModalidadCross(@PathVariable boolean modalidadCross){
        return atletaService.consultarPorModalidadCross(modalidadCross);
    }
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        atletaService.eliminarAtleta(id);
    }
}