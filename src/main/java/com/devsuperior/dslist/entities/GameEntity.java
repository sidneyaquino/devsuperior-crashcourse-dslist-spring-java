package com.devsuperior.dslist.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_games")
public class GameEntity {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   private String title;
   @Column(name = "year_release")
   private Integer year;
   private String genre;
   private String platforms;
   private Double score;
   private String imgUrl;
   @Column(columnDefinition = "TEXT")
   private String shortDescription;
   @Column(columnDefinition = "TEXT")
   private String longDescription;

   public GameEntity() {
   }

   public GameEntity(Long id, String title, Integer year, String genre,
         String platform, Double score, String imgUrl, String shortDescription,
         String longDescription) {

      this.id = id;
      this.title = title;
      this.year = year;
      this.genre = genre;
      this.platforms = platform;
      this.imgUrl = imgUrl;
      this.shortDescription = shortDescription;
      this.longDescription = longDescription;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public Integer getYear() {
      return year;
   }

   public void setYear(Integer year) {
      this.year = year;
   }

   public String getGenre() {
      return genre;
   }

   public void setGenre(String genre) {
      this.genre = genre;
   }

   public String getPlatforms() {
      return platforms;
   }

   public void setPlatforms(String platform) {
      this.platforms = platform;
   }

   public Double getScore() {
      return score;
   }

   public void setScore(Double score) {
      this.score = score;
   }

   public String getImgUrl() {
      return imgUrl;
   }

   public void setImgUrl(String imgUrl) {
      this.imgUrl = imgUrl;
   }

   public String getShortDescription() {
      return shortDescription;
   }

   public void setShortDescription(String shortDescription) {
      this.shortDescription = shortDescription;
   }

   public String getLongDescription() {
      return longDescription;
   }

   public void setLongDescription(String longDescription) {
      this.longDescription = longDescription;
   }

   @Override
   public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((id == null) ? 0 : id.hashCode());
      return result;
   }

   @Override
   public boolean equals(Object obj) {
      if (this == obj)
         return true;
      if (obj == null)
         return false;
      if (getClass() != obj.getClass())
         return false;
      GameEntity other = (GameEntity) obj;
      if (id == null) {
         if (other.id != null)
            return false;
      } else if (!id.equals(other.id))
         return false;
      return true;
   }

}