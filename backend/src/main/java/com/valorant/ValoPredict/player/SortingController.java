package com.valorant.ValoPredict.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sorting")
public class SortingController {

    private final SortingService sortingService;

    @Autowired
    public SortingController(SortingService sortingService) {
        this.sortingService = sortingService;
    }

    @GetMapping
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
            return sortingService.sortPlayersByRoundsPlayed(reversed);
        }

        else if(rating){
            return sortingService.sortPlayersByRating(reversed);
        }

        else if(acs){
            return sortingService.sortPlayersByAcs(reversed);
        }

        else if(kd){
            return sortingService.sortPlayersByKd(reversed);
        }

        else if(kast){
            return sortingService.sortPlayersByKast(reversed);
        }

        else if(adr){
            return sortingService.sortPlayersByAdr(reversed);
        }

        else if(kpr){
            return sortingService.sortPlayersByKpr(reversed);
        }

        else if(apr){
            return sortingService.sortPlayersByApr(reversed);
        }

        else if(fkpr){
            return sortingService.sortPlayersByFkpr(reversed);
        }

        else if(fdpr){
            return sortingService.sortPlayersByFdpr(reversed);
        }

        else if(hs_percentage){
            return sortingService.sortPlayersByHsPercentage(reversed);
        }

        else if(clutch_success_percentage){
            return sortingService.sortPlayersByClutchSuccessPercentage(reversed);
        }

        else{
            return sortingService.getPlayerRepository().findAll();
        }
    }
}
