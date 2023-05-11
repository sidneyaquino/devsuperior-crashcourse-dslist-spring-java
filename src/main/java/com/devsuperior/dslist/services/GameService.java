package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dtos.GameBasicDTO;
import com.devsuperior.dslist.entities.GameEntity;
import com.devsuperior.dslist.repositories.GameRepository;



@Service
public class GameService {

   @Autowired
   private GameRepository repository;

   public List<GameBasicDTO> findAll(){
      var list = repository.findAll();
      return list.stream().map(item -> new GameBasicDTO(item)).toList();
   }
}