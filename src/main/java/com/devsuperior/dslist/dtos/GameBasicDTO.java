package com.devsuperior.dslist.dtos;

import com.devsuperior.dslist.entities.GameEntity;

public class GameBasicDTO {

   private Long id;
   private String title;
   private Integer year;
   private String imgUrl;
   private String shortDescription;

   public GameBasicDTO() {
   }

   public GameBasicDTO(Long id, String title, Integer year, String imgUrl, String shortDescription) {
      this.id = id;
      this.title = title;
      this.year = year;
      this.imgUrl = imgUrl;
      this.shortDescription = shortDescription;
   }

   public GameBasicDTO(GameEntity entity) {
      this.id = entity.getId();
      this.title = entity.getTitle();
      this.year = entity.getYear();
      this.imgUrl = entity.getImgUrl();
      this.shortDescription = entity.getShortDescription();
   }

   public Long getId() {
      return id;
   }

   public String getTitle() {
      return title;
   }

   public Integer getYear() {
      return year;
   }

   public String getImgUrl() {
      return imgUrl;
   }

   public String getShortDescription() {
      return shortDescription;
   }
}