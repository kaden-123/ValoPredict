package com.valorant.ValoPredict.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class SortingService {

    private final PlayerRepository playerRepository;

    @Autowired
    public SortingService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> sortPlayersByRoundsPlayed(boolean reversed){
        List<Player> allPlayers = playerRepository.findAll();

        if(!reversed) {
            allPlayers.sort(Comparator.comparing(Player::getRounds_played, Comparator.nullsFirst(Integer::compareTo)));
            return allPlayers;
        }

        allPlayers.sort(Comparator.comparing(Player::getRounds_played, Comparator.nullsFirst(Integer::compareTo).reversed()));
        return allPlayers;
    }

    public List<Player> sortPlayersByRating(boolean reversed){
        List<Player> allPlayers = playerRepository.findAll();

        if(!reversed){
            allPlayers.sort(Comparator.comparing(Player::getRating, Comparator.nullsFirst(Double::compareTo)));
            return allPlayers;
        }

        allPlayers.sort(Comparator.comparing(Player::getRating, Comparator.nullsFirst(Double::compareTo).reversed()));
        return allPlayers;
    }

    public List<Player> sortPlayersByAcs(boolean reversed){
        List<Player> allPlayers = playerRepository.findAll();

        if(!reversed){
            allPlayers.sort(Comparator.comparing(Player::getAcs, Comparator.nullsFirst(Double::compareTo)));
            return allPlayers;
        }

        allPlayers.sort(Comparator.comparing(Player::getAcs, Comparator.nullsFirst(Double::compareTo).reversed()));
        return allPlayers;
    }

    public List<Player> sortPlayersByKd(boolean reversed){
        List<Player> allPlayers = playerRepository.findAll();

        if(!reversed){
            allPlayers.sort(Comparator.comparing(Player::getKd, Comparator.nullsFirst(Double::compareTo)));
            return allPlayers;
        }

        allPlayers.sort(Comparator.comparing(Player::getKd, Comparator.nullsFirst(Double::compareTo).reversed()));
        return allPlayers;
    }

    public List<Player> sortPlayersByKast(boolean reversed){
        List<Player> allPlayers = playerRepository.findAll();

        if(!reversed){
            allPlayers.sort(Comparator.comparing(Player::getKast, Comparator.nullsFirst(Integer::compareTo)));
            return allPlayers;
        }

        allPlayers.sort(Comparator.comparing(Player::getKast, Comparator.nullsFirst(Integer::compareTo).reversed()));
        return allPlayers;
    }

    public List<Player> sortPlayersByAdr(boolean reversed){
        List<Player> allPlayers = playerRepository.findAll();

        if(!reversed){
            allPlayers.sort(Comparator.comparing(Player::getAdr, Comparator.nullsFirst(Double::compareTo)));
            return allPlayers;
        }

        allPlayers.sort(Comparator.comparing(Player::getAdr, Comparator.nullsFirst(Double::compareTo).reversed()));
        return allPlayers;
    }

    public List<Player> sortPlayersByKpr(boolean reversed){
        List<Player> allPlayers = playerRepository.findAll();

        if(!reversed){
            allPlayers.sort(Comparator.comparing(Player::getKpr, Comparator.nullsFirst(Double::compareTo)));
            return allPlayers;
        }

        allPlayers.sort(Comparator.comparing(Player::getKpr, Comparator.nullsFirst(Double::compareTo).reversed()));
        return allPlayers;
    }

    public List<Player> sortPlayersByApr(boolean reversed){
        List<Player> allPlayers = playerRepository.findAll();

        if(!reversed){
            allPlayers.sort(Comparator.comparing(Player::getApr, Comparator.nullsFirst(Double::compareTo)));
            return allPlayers;
        }

        allPlayers.sort(Comparator.comparing(Player::getApr, Comparator.nullsFirst(Double::compareTo).reversed()));
        return allPlayers;
    }

    public List<Player> sortPlayersByFkpr(boolean reversed){
        List<Player> allPlayers = playerRepository.findAll();

        if(!reversed){
            allPlayers.sort(Comparator.comparing(Player::getFkpr, Comparator.nullsFirst(Double::compareTo)));
            return allPlayers;
        }

        allPlayers.sort(Comparator.comparing(Player::getFkpr, Comparator.nullsFirst(Double::compareTo).reversed()));
        return allPlayers;
    }

    public List<Player> sortPlayersByFdpr(boolean reversed){
        List<Player> allPlayers = playerRepository.findAll();

        if(!reversed){
            allPlayers.sort(Comparator.comparing(Player::getFdpr, Comparator.nullsFirst(Double::compareTo)));
            return allPlayers;
        }

        allPlayers.sort(Comparator.comparing(Player::getFdpr, Comparator.nullsFirst(Double::compareTo).reversed()));
        return allPlayers;
    }

    public List<Player> sortPlayersByHsPercentage(boolean reversed){
        List<Player> allPlayers = playerRepository.findAll();

        if(!reversed){
            allPlayers.sort(Comparator.comparing(Player::getHs_percentage, Comparator.nullsFirst(Integer::compareTo)));
            return allPlayers;
        }

        allPlayers.sort(Comparator.comparing(Player::getHs_percentage, Comparator.nullsFirst(Integer::compareTo).reversed()));
        return allPlayers;
    }

    public List<Player> sortPlayersByClutchSuccessPercentage(boolean reversed){
        List<Player> allPlayers = playerRepository.findAll();

        if(!reversed){
            allPlayers.sort(Comparator.comparing(Player::getClutch_success_percentage, Comparator.nullsFirst(Integer::compareTo)));
            return allPlayers;
        }

        allPlayers.sort(Comparator.comparing(Player::getClutch_success_percentage, Comparator.nullsFirst(Integer::compareTo).reversed()));
        return allPlayers;
    }

    public PlayerRepository getPlayerRepository() {
        return playerRepository;
    }
}
