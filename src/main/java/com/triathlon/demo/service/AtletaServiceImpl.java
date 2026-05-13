package com.triathlon.demo.service;
import com.triathlon.demo.dto.AtletaRequestDTO;
import com.triathlon.demo.dto.AtletaResponseDTO;
import com.triathlon.demo.mapper.AtletaMapper;
import com.triathlon.demo.modelo.Atleta;
import com.triathlon.demo.modelo.enums.Categoria;
import com.triathlon.demo.modelo.enums.Especialidad;
import com.triathlon.demo.modelo.enums.Genero;
import com.triathlon.demo.repository.AtletaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

@Service
public class AtletaServiceImpl implements AtletaService {
    @Autowired
    private AtletaRepository atletaRepository;

    @Override
    public AtletaResponseDTO crearAtleta(AtletaRequestDTO dto) {
        Atleta atleta = AtletaMapper.toEntity(dto);
        atleta.setCategoria(calcularCategoria(atleta.getEdad()));
        return AtletaMapper.toResponse(atletaRepository.save(atleta));
    }

    @Override
    public AtletaResponseDTO configurarPreferencias(Long id, Especialidad especialidad, boolean modalidadCross) {
        Atleta atleta = atletaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atleta no encontrado"));
        atleta.setEspecialidad(especialidad);
        atleta.setModalidadCross(modalidadCross);
        return AtletaMapper.toResponse(atletaRepository.save(atleta));
    }

    @Override
    public AtletaResponseDTO modificarNombre(Long id, String nombre) {
        Atleta atleta = atletaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atleta no encontrado"));
        atleta.setNombre(nombre);
        return AtletaMapper.toResponse(atletaRepository.save(atleta));
    }

    @Override
    public AtletaResponseDTO modificarIdentificacion(Long id, String identificacion) {
        Atleta atleta = atletaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atleta no encontrado"));
        atleta.setIdentificacion(identificacion);
        return AtletaMapper.toResponse(atletaRepository.save(atleta));
    }

    @Override
    public AtletaResponseDTO modificarCategoria(Long id, Categoria categoria) {
        Atleta atleta = atletaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Atleta no encontrado"));
        atleta.setCategoria(categoria);
        return AtletaMapper.toResponse(atletaRepository.save(atleta));
    }

    @Override
    public Optional<AtletaResponseDTO> consultarPorIdentificacion(String identificacion) {
        return atletaRepository.findByIdentificacion(identificacion)
                .map(AtletaMapper::toResponse);
    }

    @Override
    public List<AtletaResponseDTO> consultarPorCategoria(Categoria categoria) {
        return atletaRepository.findByCategoria(categoria)
                .stream()
                .map(AtletaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<AtletaResponseDTO> consultarPorGenero(Genero genero) {
        return atletaRepository.findByGenero(genero)
                .stream()
                .map(AtletaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<AtletaResponseDTO> consultarPorEspecialidad(Especialidad especialidad) {
        return atletaRepository.findByEspecialidad(especialidad)
                .stream()
                .map(AtletaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<AtletaResponseDTO> consultarPorModalidadCross(boolean modalidadCross) {
        return atletaRepository.findByModalidadCross(modalidadCross)
                .stream()
                .map(AtletaMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public void eliminarAtleta(Long id) {
        atletaRepository.deleteById(id);
    }

    private Categoria calcularCategoria(int edad) {
        if (edad == 7)  return Categoria.PRE_BENJAMIN;
        if (edad <= 9)  return Categoria.BENJAMIN;
        if (edad <= 11) return Categoria.ALEVIN;
        if (edad <= 13) return Categoria.INFANTIL;
        if (edad <= 15) return Categoria.CADETE;
        if (edad <= 17) return Categoria.JUVENIL;
        if (edad <= 19) return Categoria.JUNIOR;
        if (edad <= 23) return Categoria.SUB23;
        if (edad <= 39) return Categoria.ABSOLUTA;
        if (edad <= 49) return Categoria.VETERANO1;
        if (edad <= 59) return Categoria.VETERANO2;
        return           Categoria.VETERANO3;
    }
}