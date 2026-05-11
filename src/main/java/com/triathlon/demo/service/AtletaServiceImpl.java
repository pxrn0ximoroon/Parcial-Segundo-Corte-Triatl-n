package com.triathlon.demo.service;
import com.triathlon.demo.modelo.Atleta;
import com.triathlon.demo.modelo.enums.Categoria;
import com.triathlon.demo.modelo.enums.Especialidad;
import com.triathlon.demo.modelo.enums.Genero;
import com.triathlon.demo.repository.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtletaServiceImpl implements AtletaService{
    @Autowired
    private AtletaRepository atletaRepository;

    @Override
    public Atleta crearAtleta(Atleta atleta) {
     return atletaRepository.save(atleta);

    }

    @Override
    public Atleta configurarPreferencias(Long id, Especialidad especialidad, boolean modalidadCross) {
        Atleta atleta = atletaRepository.findById(id).orElseThrow(()-> new RuntimeException("Atleta no encontrada"));
        atleta.setEspecialidad(especialidad);
        atleta.setModalidadCross(modalidadCross);
        return atletaRepository.save(atleta);
    }

    @Override
    public Atleta modificarNombre(Long id, String nombre) {
        Atleta atleta = atletaRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Atleta no encontrado"));
        atleta.setNombre(nombre);
        return atletaRepository.save(atleta);
    }

    @Override
    public Atleta modificarIdentificacion(Long id, String identificacion) {
        Atleta atleta = atletaRepository.findById(id).orElseThrow(()-> new RuntimeException("Atleta no encontrado"));
        atleta.setIdentificacion(identificacion);
        return atletaRepository.save(atleta);
    }

    @Override
    public Atleta modificarCategoria(Long id, Categoria categoria) {
        Atleta atleta = atletaRepository.findById(id).orElseThrow(()-> new RuntimeException("Atleta no encontrado"));
        atleta.setCategoria(categoria);
        return atletaRepository.save(atleta);
    }

    @Override
    public Optional<Atleta> consultarPorIdentificacion(String identificacion) {
        return atletaRepository.findByIdentificacion(identificacion);
    }

    @Override
    public List<Atleta> consultarPorCategoria(Categoria categoria) {
        return atletaRepository.findByCategoria(categoria);
    }

    @Override
    public List<Atleta> consultarPorGenero(Genero genero) {
        return atletaRepository.findByGenero(genero);
    }

    @Override
    public List<Atleta> consultarPorEspecialidad(Especialidad especialidad) {
        return atletaRepository.findByEspecialidad(especialidad);
    }

    @Override
    public List<Atleta> consultarPorModalidadCross(boolean modalidadCross) {
        return atletaRepository.findByModalidadCross(modalidadCross);
    }

    @Override
    public void eliminarAtleta(Long id) {
        atletaRepository.deleteById(id);
    }
}
