package com.devsuperior.dslist.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class BelonginPK {

   @ManyToOne
   @JoinColumn(name = "id_games")
   private GameEntity game;
   @ManyToOne
   @JoinColumn(name = "id_lists")
   private ListEntity list;

   // public BelonginPK() {
   // }

   // public BelonginPK(GameEntity game, ListEntity list) {
   // this.game = game;
   // this.list = list;
   // }

   public GameEntity getGame() {
      return game;
   }
   // public void setGame(GameEntity game) {
   // this.game = game;
   // }

   public ListEntity getList() {
      return list;
   }
   // public void setList(ListEntity list) {
   // this.list = list;
   // }

   // @Override
   // public int hashCode() {
   // final int prime = 31;
   // int result = 1;
   // result = prime * result + ((game == null) ? 0 : game.hashCode());
   // result = prime * result + ((list == null) ? 0 : list.hashCode());
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
   // BelonginPK other = (BelonginPK) obj;
   // if (game == null) {
   // if (other.game != null)
   // return false;
   // } else if (!game.equals(other.game))
   // return false;
   // if (list == null) {
   // if (other.list != null)
   // return false;
   // } else if (!list.equals(other.list))
   // return false;
   // return true;
   // }
}