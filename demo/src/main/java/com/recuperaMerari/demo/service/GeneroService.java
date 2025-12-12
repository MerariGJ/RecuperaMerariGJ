package com.recuperaMerari.demo.service;

import com.recuperaMerari.demo.dto.CreateGeneroDTO;
import com.recuperaMerari.demo.model.GeneroMusical;
import com.recuperaMerari.demo.repository.GeneroRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GeneroService {

    GeneroRepository generoRepository;

    public GeneroService(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    public Map<String, Object> createGenero(CreateGeneroDTO createGeneroDTO) {
        Map<String, Object> respuesta = new HashMap<>();
        GeneroMusical unGenero = new GeneroMusical();
        unGenero.setNombre(createGeneroDTO.getNombre());
        unGenero.setDescripcion(createGeneroDTO.getDescripcion());

        generoRepository.save(unGenero);
        respuesta.put("mensaje", "Genero creado");
        return respuesta;
    }

    public Map<String, Object> getAllGeneros() {
        Map<String, Object> mapResponse = new HashMap<>();
        List listaGeneros = generoRepository.findAll();
        mapResponse.put("listaGeneros", listaGeneros);
        mapResponse.put("mensaje", "Lista de generos. Resultado exitoso");
        return mapResponse;
    }

    public Map<String, Object> getGeneroById(Integer id) {
        Map<String, Object> mapResponse = new HashMap<>();
        Optional<GeneroMusical> optionalGenero = generoRepository.findById(id);
        if (optionalGenero.isPresent()) {
            mapResponse.put("Genero", optionalGenero.get());
            mapResponse.put("mensaje", "Genero encontrado");

        } else {
            mapResponse.put("mensaje", "Genero no encontrado");
        }
        return mapResponse;
    }

    public Map<String, Object> actualizarGenero(Integer id, CreateGeneroDTO createGeneroDTO) {

        Map<String, Object> mapResponse = new HashMap<>();

        Optional<GeneroMusical> optionalGenero = generoRepository.findById(id);
        if (optionalGenero.isPresent()) {
            GeneroMusical generoExistente = optionalGenero.get();
            generoExistente.setNombre(createGeneroDTO.getNombre());
            generoExistente.setDescripcion(createGeneroDTO.getDescripcion());
            generoRepository.save(generoExistente);
            mapResponse.put("mensaje", "Genero actualizado");
            mapResponse.put("genero", generoExistente);
            mapResponse.put("code", 200);
        } else {
            mapResponse.put("mensaje", "Genero no encontrado, no se puede actualizar");
            mapResponse.put("code", 404);
            {

            }
            return mapResponse;
        }
    }
}





