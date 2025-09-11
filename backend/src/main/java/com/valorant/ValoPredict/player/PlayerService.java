package com.valorant.ValoPredict.player;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
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

    public List<Player> filterPlayers(PlayerFilterRequest filter){
        Specification<Player> spec = Specification.unrestricted();

        if(filter.getRounds_played() != null){
            if(filter.getRoundsOp().equals("GT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.asc(root.get("rounds_played")));
                    return cb.greaterThanOrEqualTo(root.get("rounds_played"), filter.getRounds_played());
                });
            }

            if(filter.getRoundsOp().equals("LT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.desc(root.get("rounds_played")));
                    return cb.lessThanOrEqualTo(root.get("rounds_played"), filter.getRounds_played());
                });
            }
        }

        if(filter.getRating() != null){
            if(filter.getRatingOp().equals("GT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.asc(root.get("rating")));
                    return cb.greaterThanOrEqualTo(root.get("rating"), filter.getRating());
                });
            }

            if(filter.getRatingOp().equals("LT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.desc(root.get("rating")));
                    return cb.lessThanOrEqualTo(root.get("rating"), filter.getRating());
                });
            }
        }

        if(filter.getAcs() != null){
            if(filter.getAcsOp().equals("GT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.asc(root.get("acs")));
                    return cb.greaterThanOrEqualTo(root.get("acs"), filter.getAcs());
                });
            }

            if(filter.getAcsOp().equals("LT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.desc(root.get("acs")));
                    return cb.lessThanOrEqualTo(root.get("acs"), filter.getAcs());
                });
            }
        }

        if(filter.getKd() != null){
            if(filter.getKdOp().equals("GT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.asc(root.get("kd")));
                    return cb.greaterThanOrEqualTo(root.get("kd"), filter.getKd());
                });
            }

            if(filter.getKdOp().equals("LT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.desc(root.get("kd")));
                    return cb.lessThanOrEqualTo(root.get("kd"), filter.getKd());
                });
            }
        }

        if(filter.getKast() != null){
            if(filter.getKastOp().equals("GT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.asc(root.get("kast")));
                    return cb.greaterThanOrEqualTo(root.get("kast"), filter.getKast());
                });
            }

            if(filter.getKastOp().equals("LT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.desc(root.get("kast")));
                    return cb.lessThanOrEqualTo(root.get("kast"), filter.getKast());
                });
            }
        }

        if(filter.getAdr() != null){
            if(filter.getAdrOp().equals("GT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.asc(root.get("adr")));
                    return cb.greaterThanOrEqualTo(root.get("adr"), filter.getAdr());
                });
            }

            if(filter.getAdrOp().equals("LT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.desc(root.get("adr")));
                    return cb.lessThanOrEqualTo(root.get("adr"), filter.getAdr());
                });
            }
        }

        if(filter.getKpr() != null){
            if(filter.getKprOp().equals("GT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.asc(root.get("kpr")));
                    return cb.greaterThanOrEqualTo(root.get("kpr"), filter.getKpr());
                });
            }

            if(filter.getKprOp().equals("LT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.desc(root.get("kpr")));
                    return cb.lessThanOrEqualTo(root.get("kpr"), filter.getKpr());
                });
            }
        }

        if(filter.getApr() != null){
            if(filter.getAprOp().equals("GT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.asc(root.get("apr")));
                    return cb.greaterThanOrEqualTo(root.get("apr"), filter.getApr());
                });
            }

            if(filter.getAprOp().equals("LT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.desc(root.get("apr")));
                    return cb.lessThanOrEqualTo(root.get("apr"), filter.getApr());
                });
            }
        }

        if(filter.getFkpr() != null){
            if(filter.getFkprOp().equals("GT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.asc(root.get("fkpr")));
                    return cb.greaterThanOrEqualTo(root.get("fkpr"), filter.getFkpr());
                });
            }

            if(filter.getFkprOp().equals("LT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.desc(root.get("fkpr")));
                    return cb.lessThanOrEqualTo(root.get("fkpr"), filter.getFkpr());
                });
            }
        }

        if(filter.getFdpr() != null){
            if(filter.getFdprOp().equals("GT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.asc(root.get("fdpr")));
                    return cb.greaterThanOrEqualTo(root.get("fdpr"), filter.getFdpr());
                });
            }

            if(filter.getFdprOp().equals("LT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.desc(root.get("fdpr")));
                    return cb.lessThanOrEqualTo(root.get("fdpr"), filter.getFdpr());
                });
            }
        }

        if(filter.getHs_percentage() != null){
            if(filter.getHs_percentageOp().equals("GT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.asc(root.get("hs_percentage")));
                    return cb.greaterThanOrEqualTo(root.get("hs_percentage"), filter.getHs_percentage());
                });
            }

            if(filter.getHs_percentageOp().equals("LT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.desc(root.get("hs_percentage")));
                    return cb.lessThanOrEqualTo(root.get("hs_percentage"), filter.getHs_percentage());
                });
            }
        }

        if(filter.getClutch_success_percentage() != null){
            if(filter.getClutch_success_percentageOp().equals("GT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.asc(root.get("clutch_success_percentage")));
                    return cb.greaterThanOrEqualTo(root.get("clutch_success_percentage"), filter.getClutch_success_percentage());
                });
            }

            if(filter.getClutch_success_percentageOp().equals("LT")){
                spec = spec.and((root, query, cb) -> {
                    query.orderBy(cb.desc(root.get("clutch_success_percentage")));
                    return cb.lessThanOrEqualTo(root.get("clutch_success_percentage"), filter.getClutch_success_percentage());
                });
            }
        }

        return playerRepository.findAll(spec);
    }
}
