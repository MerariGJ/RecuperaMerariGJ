package com.recuperaMerari.demo.repository;


import com.recuperaMerari.demo.model.GeneroMusical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeneroRepository  extends JpaRepository <GeneroMusical, Integer> {

}
