package com.devsuperior.dslist.dtos;

import com.devsuperior.dslist.entities.ListEntity;

public class ListDTO {
   
   private Long id;
   private String name;

   public ListDTO(ListEntity entity) {
      this.id = entity.getId();
      this.name = entity.getName();
   }

   public Long getId() {
      return id;
   }

   public String getName() {
      return name;
   }
}
