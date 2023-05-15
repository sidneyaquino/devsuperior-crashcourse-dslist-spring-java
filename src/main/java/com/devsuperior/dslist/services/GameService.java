package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dtos.GameBasicDTO;
import com.devsuperior.dslist.dtos.GameDTO;
import com.devsuperior.dslist.projection.GameBasicProjection;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameService {

   @Autowired
   private GameRepository repository;

   @Transactional(readOnly = true)
   public GameDTO findById(Long id) {
      // var entity = repository.findById(id).get();
      var entity = repository.getReferenceById(id);
      return new GameDTO(entity);
   }

   @Transactional(readOnly = true)
   public List<GameBasicDTO> findAll() {
      var list = repository.findAll();
      return list.stream().map(entity -> new GameBasicDTO(entity)).toList();
   }

   @Transactional(readOnly = true)
   public List<GameBasicDTO> findByList(Long id) {
      List<GameBasicProjection>  list = repository.findByList(id);
      return list.stream().map(projection -> new GameBasicDTO(projection)).toList();
   }
}