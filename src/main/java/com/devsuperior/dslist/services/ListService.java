package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dtos.ListDTO;
import com.devsuperior.dslist.repositories.ListRepository;

@Service
public class ListService {

   @Autowired
   private ListRepository repository;

   @Transactional(readOnly = true)
   public ListDTO findById(Long id) {
      // var entity = repository.findById(id).get();
      var entity = repository.getReferenceById(id);
      return new ListDTO(entity);
   }

   @Transactional(readOnly = true)
   public List<ListDTO> findAll() {
      var list = repository.findAll();
      return list.stream().map(entity -> new ListDTO(entity)).toList();
   }
}