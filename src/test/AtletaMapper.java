package com.triathlon.demo.mapper;

import com.triathlon.demo.dto.AtletaRequestDTO;
import com.triathlon.demo.dto.AtletaResponseDTO;
import com.triathlon.demo.modelo.Atleta;
import java.util.Base64;

/**
 * Clase para convertir entre la entidad atleta y los dtos.
 * Se usa para no exponer la entidad directamente al frontend.
 */
public class AtletaMapper {

    /**
     * Convierte un requestdto a entidad atleta para guardarla en la bd.
     * si el atleta mando foto la decodifica de base64 a bytes.
     */
    public static Atleta toEntity(AtletaRequestDTO dto) {
        Atleta atleta = new Atleta();
        atleta.setIdentificacion(dto.getIdentificacion());
        atleta.setNombre(dto.getNombre());
        atleta.setEmail(dto.getEmail());
        atleta.setEdad(dto.getEdad());
        atleta.setGenero(dto.getGenero());
        atleta.setEspecialidad(dto.getEspecialidad());
        atleta.setModalidadCross(dto.isModalidadCross());
        if (dto.getFoto() != null && !dto.getFoto().isEmpty()) {
            byte[] fotoBytes = Base64.getDecoder().decode(dto.getFoto());
            atleta.setFoto(fotoBytes);
        }

        return atleta;
    }

    /**
     * Convierte una entidad atleta a responseDto para mandarla al frontend.
     * si el atleta tiene foto la convierte a base64 para mostrarla en el html.
     */
    public static AtletaResponseDTO toResponse(Atleta atleta) {
        AtletaResponseDTO dto = new AtletaResponseDTO();
        dto.setId(atleta.getId());
        dto.setIdentificacion(atleta.getIdentificacion());
        dto.setNombre(atleta.getNombre());
        dto.setEmail(atleta.getEmail());
        dto.setEdad(atleta.getEdad());
        dto.setGenero(atleta.getGenero());
        dto.setCategoria(atleta.getCategoria());
        dto.setEspecialidad(atleta.getEspecialidad());
        dto.setModalidadCross(atleta.isModalidadCross());

        if (atleta.getFoto() != null) {
            String b64 = Base64.getEncoder().encodeToString(atleta.getFoto());
            dto.setFotoBase64("data:image/jpeg;base64," + b64);
        }

        return dto;
    }
}