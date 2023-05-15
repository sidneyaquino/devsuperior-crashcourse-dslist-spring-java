package com.devsuperior.dslist.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dtos.GameBasicDTO;
import com.devsuperior.dslist.dtos.ListDTO;
import com.devsuperior.dslist.services.GameService;
import com.devsuperior.dslist.services.ListService;

@RestController
@RequestMapping("/lists")
public class ListController {
   
   @Autowired
   public ListService service;
   @Autowired
   public GameService gameService;

   @GetMapping
   public List<ListDTO> findAll(){
      return service.findAll();
   }

   @GetMapping("/{id}")
   public ListDTO findById(@PathVariable Long id){
      return service.findById(id);
   }

   @GetMapping("/{id}/games")
   public List<GameBasicDTO> findByList(@PathVariable Long id){
      return gameService.findByList(id);
   }
}