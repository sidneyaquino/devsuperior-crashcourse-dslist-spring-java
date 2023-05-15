package com.devsuperior.dslist.dtos;

import com.devsuperior.dslist.entities.GameEntity;
import com.devsuperior.dslist.projection.GameBasicProjection;

public class GameBasicDTO {

   private Long id;
   private String title;
   private Integer year;
   private String imgUrl;
   private String shortDescription;

   // public GameBasicDTO() {
   // }

   // public GameBasicDTO(Long id, String title, Integer year, String imgUrl,
   // String shortDescription) {
   // this.id = id;
   // this.title = title;
   // this.year = year;
   // this.imgUrl = imgUrl;
   // this.shortDescription = shortDescription;
   // }

   public GameBasicDTO(GameEntity entity) {
      this.id = entity.getId();
      this.title = entity.getTitle();
      this.year = entity.getYear();
      this.imgUrl = entity.getImgUrl();
      this.shortDescription = entity.getShortDescription();
   }

   public GameBasicDTO(GameBasicProjection projection) {
      this.id = projection.getId();
      this.title = projection.getTitle();
      this.year = projection.getYear();
      this.imgUrl = projection.getImgUrl();
      this.shortDescription = projection.getShortDescription();
   }

   public Long getId() {
      return id;
   }
   // public void setId(Long id) {
   // this.id = id;
   // }

   public String getTitle() {
      return title;
   }
   // public void setTitle(String title) {
   // this.title = title;
   // }

   public Integer getYear() {
      return year;
   }
   // public void setYear(Integer year) {
   // this.year = year;
   // }

   public String getImgUrl() {
      return imgUrl;
   }
   // public void setImgUrl(String imgUrl) {
   // this.imgUrl = imgUrl;
   // }

   public String getShortDescription() {
      return shortDescription;
   }
   // public void setShortDescription(String shortDescription) {
   // this.shortDescription = shortDescription;
   // }
}