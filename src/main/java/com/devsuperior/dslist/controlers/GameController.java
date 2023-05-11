package com.devsuperior.dslist.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dtos.GameBasicDTO;
import com.devsuperior.dslist.services.GameService;

@RestController
@RequestMapping("/games")
public class GameController {

   @Autowired
   GameService service;

   @GetMapping
   public List<GameBasicDTO> findAll() {
      return service.findAll();
   }
}