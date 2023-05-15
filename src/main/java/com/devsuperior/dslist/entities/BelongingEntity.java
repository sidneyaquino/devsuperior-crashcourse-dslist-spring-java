package com.devsuperior.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_belonging")
public class BelongingEntity {

   @EmbeddedId
   private BelonginPK id = new BelonginPK();
   private Integer position;

   // public BelongingEntity() {
   // }

   // public BelongingEntity(GameEntity game, ListEntity list, Integer position) {
   // this.id.setGame(game);
   // this.id.setList(list);
   // this.position = position;
   // }

   public BelonginPK getId() {
      return id;
   }
   // public void setId(BelonginPK id) {
   // this.id = id;
   // }

   public Integer getPosition() {
      return position;
   }
   // public void setPosition(Integer position) {
   // this.position = position;
   // }

   // @Override
   // public int hashCode() {
   // final int prime = 31;
   // int result = 1;
   // result = prime * result + ((id == null) ? 0 : id.hashCode());
   // return result;
   // }

   // @Override
   // public boolean equals(Object obj) {
   // if (this == obj)
   // return true;
   // if (obj == null)
   // return false;
   // if (getClass() != obj.getClass())
   // return false;
   // BelongingEntity other = (BelongingEntity) obj;
   // if (id == null) {
   // if (other.id != null)
   // return false;
   // } else if (!id.equals(other.id))
   // return false;
   // return true;
   // }
}