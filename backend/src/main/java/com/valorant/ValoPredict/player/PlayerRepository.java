package com.valorant.ValoPredict.player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
    // void deleteById(Integer id);
    // Optional<Player> findById(Integer id);
}
