package com.valorant.ValoPredict.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<Player> getPlayers(){
        return playerRepository.findAll();
    }

    public List<Player> getPlayersFromOrg(String searchText){
        return playerRepository.findAll().stream()
                .filter(player -> player.getOrg().equalsIgnoreCase(searchText))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByName(String searchText){
        return playerRepository.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByAgent(String searchText){
        return playerRepository.findAll().stream()
                .filter(player -> Arrays.stream(player.getAgents().split(", "))
                        .anyMatch(agent -> agent.equalsIgnoreCase(searchText)))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByOrgAndAgent(String org, String agentName){
        return playerRepository.findAll().stream()
                .filter(player -> player.getOrg().equalsIgnoreCase(org) && Arrays.stream(player.getAgents().split(", ")).anyMatch(agent -> agent.equalsIgnoreCase(agentName)))
                .collect(Collectors.toList());
    }

    public Player addPlayer(Player player){
        playerRepository.save(player);
        return player;
    }

    public Player updatePlayer(Player updatedPlayer){
        Optional<Player> existingPlayer = playerRepository.findById(updatedPlayer.getId());

        if(existingPlayer.isPresent()){
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(updatedPlayer.getName());
            playerToUpdate.setOrg(updatedPlayer.getOrg());
            playerToUpdate.setAgents(updatedPlayer.getAgents());
            playerToUpdate.setRounds_played(updatedPlayer.getRounds_played());
            playerToUpdate.setRating(updatedPlayer.getRating());
            playerToUpdate.setAcs(updatedPlayer.getAcs());
            playerToUpdate.setKd(updatedPlayer.getKd());
            playerToUpdate.setKast(updatedPlayer.getKast());
            playerToUpdate.setAdr(updatedPlayer.getAdr());
            playerToUpdate.setKpr(updatedPlayer.getKpr());
            playerToUpdate.setApr(updatedPlayer.getApr());
            playerToUpdate.setFkpr(updatedPlayer.getFkpr());
            playerToUpdate.setFdpr(updatedPlayer.getFdpr());
            playerToUpdate.setHs_percentage(updatedPlayer.getHs_percentage());
            playerToUpdate.setClutch_success_percentage(updatedPlayer.getClutch_success_percentage());

            playerRepository.save(playerToUpdate);
            return playerToUpdate;
        }
        return null;
    }

    @Transactional
    public void deletePlayer(Integer id){
        playerRepository.deleteById(id);
    }
}
