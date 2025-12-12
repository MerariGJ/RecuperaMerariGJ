package com.recuperaMerari.demo.controller;

import com.recuperaMerari.demo.dto.CreateGeneroDTO;
import com.recuperaMerari.demo.repository.GeneroRepository;
import com.recuperaMerari.demo.service.GeneroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/genero")
@CrossOrigin(origins = "*")

public class ControllerGenero {
    private final GeneroService generoService;
    GeneroRepository generoRepository;

    public ControllerGenero(GeneroRepository generoRepository, GeneroService generoService) {
        this.generoRepository = generoRepository;
        this.generoService = generoService;
    }

    @GetMapping("")
    public ResponseEntity<Object> getAll() {
        Map<String, Object> mapResponse = generoService.getAllGeneros();
        return new ResponseEntity<>(mapResponse, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") Integer id) {
        Map<String, Object> respuesta = generoService.getGeneroById(id);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody CreateGeneroDTO createGeneroDTO) {
        Map<String, Object> respuesta = generoService.createGenero(createGeneroDTO);

        System.out.println(createGeneroDTO.getNombre());
        System.out.println(createGeneroDTO.getDescripcion());
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(
            @PathVariable ("id") Integer id,
            @RequestBody CreateGeneroDTO createGeneroDTO) {
        Map <String, Object> respuesta = generoService.actualizarGenero(id, createGeneroDTO);

        System.out.println(createGeneroDTO.getNombre());
        System.out.println(createGeneroDTO.getDescripcion());
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }
}


