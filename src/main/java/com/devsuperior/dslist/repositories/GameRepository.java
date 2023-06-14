package com.devsuperior.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.GameEntity;
import com.devsuperior.dslist.projection.GameBasicProjection;

public interface GameRepository extends JpaRepository<GameEntity, Long> {

   @Query(nativeQuery = true, value = """
            SELECT tbl_games.id,
               tbl_games.title,
               tbl_games.year_release AS gameYear,
               tbl_games.img_url AS imgUrl,
               tbl_games.short_description AS shortDescription,
               tbl_belonging.position
            FROM tbl_games, tbl_belonging
            WHERE tbl_games.id = tbl_belonging.id_games
               AND tbl_belonging.id_lists = :listId
            ORDER BY tbl_belonging.position
         """)
   List<GameBasicProjection> findByList(Long listId);
}