package com.valorant.ValoPredict.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/playerSearch")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getPlayers(
            @RequestParam(required = false) String org,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String agent){
        if(org != null && agent != null){
            return playerService.getPlayersByOrgAndAgent(org, agent);
        }

        else if(org != null){
            return playerService.getPlayersFromOrg(org);
        }

        else if(agent != null){
            return playerService.getPlayersByAgent(agent);
        }

        else if(name != null){
            return playerService.getPlayersByName(name);
        }

        else{
            return playerService.getPlayers();
        }
    }

    @GetMapping("/sort")
    public List<Player> getSortingMethod(
            @RequestParam(required = false) boolean rounds_played,
            @RequestParam(required = false) boolean rating,
            @RequestParam(required = false) boolean acs,
            @RequestParam(required = false) boolean kd,
            @RequestParam(required = false) boolean kast,
            @RequestParam(required = false) boolean adr,
            @RequestParam(required = false) boolean kpr,
            @RequestParam(required = false) boolean apr,
            @RequestParam(required = false) boolean fkpr,
            @RequestParam(required = false) boolean fdpr,
            @RequestParam(required = false) boolean hs_percentage,
            @RequestParam(required = false) boolean clutch_success_percentage,
            @RequestParam(required = false) boolean reversed){
        if(rounds_played){
            return playerService.sortPlayersByRoundsPlayed(reversed);
        }

        else if(rating){
            return playerService.sortPlayersByRating(reversed);
        }

        else if(acs){
            return playerService.sortPlayersByAcs(reversed);
        }

        else if(kd){
            return playerService.sortPlayersByKd(reversed);
        }

        else if(kast){
            return playerService.sortPlayersByKast(reversed);
        }

        else if(adr){
            return playerService.sortPlayersByAdr(reversed);
        }

        else if(kpr){
            return playerService.sortPlayersByKpr(reversed);
        }

        else if(apr){
            return playerService.sortPlayersByApr(reversed);
        }

        else if(fkpr){
            return playerService.sortPlayersByFkpr(reversed);
        }

        else if(fdpr){
            return playerService.sortPlayersByFdpr(reversed);
        }

        else if(hs_percentage){
            return playerService.sortPlayersByHsPercentage(reversed);
        }

        else if(clutch_success_percentage){
            return playerService.sortPlayersByClutchSuccessPercentage(reversed);
        }

        else{
            return playerService.getPlayers();
        }
    }

    @GetMapping("/filter")
    public List<Player> getFilteredPlayers(@ModelAttribute PlayerFilterRequest filter){
        return playerService.filterPlayers(filter);
    }

    @PostMapping
    public ResponseEntity<Player> addPlayer(@RequestBody Player player){
        Player newPlayer = playerService.addPlayer(player);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody Player player){
        Player updatedPlayer = playerService.updatePlayer(player);

        if(updatedPlayer != null){
            return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
        }

        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{playerId}")
    public ResponseEntity<String> deletePlayer(@PathVariable Integer playerId){
        playerService.deletePlayer(playerId);
        return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
    }
}
