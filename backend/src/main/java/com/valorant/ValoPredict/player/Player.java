package com.valorant.ValoPredict.player;

import jakarta.persistence.*;

@Entity
@Table(name="valo_stats")
public class Player {

    @Id
    private Integer id;

    @Column(name="player")
    private String name;

    private String org;

    private String agents;

    private Integer rounds_played;

    private Double rating;

    private Double acs;

    private Double kd;

    private Integer kast;

    private Double adr;

    private Double kpr;

    private Double apr;

    private Double fkpr;

    private Double fdpr;

    private Integer hs_percentage;

    private Integer clutch_success_percentage;

    public Player() {
    }

    public Player(Integer id, String name, String org, String agents, Integer rounds_played, Double rating, Double acs, Double kd, Integer kast, Double adr, Double kpr, Double apr, Double fkpr, Double fdpr, Integer hs_percentage, Integer clutch_success_percentage) {
        this.id = id;
        this.name = name;
        this.org = org;
        this.agents = agents;
        this.rounds_played = rounds_played;
        this.rating = rating;
        this.acs = acs;
        this.kd = kd;
        this.kast = kast;
        this.adr = adr;
        this.kpr = kpr;
        this.apr = apr;
        this.fkpr = fkpr;
        this.fdpr = fdpr;
        this.hs_percentage = hs_percentage;
        this.clutch_success_percentage = clutch_success_percentage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getAgents() {
        return agents;
    }

    public void setAgents(String agents) {
        this.agents = agents;
    }

    public Integer getRounds_played() {
        return rounds_played;
    }

    public void setRounds_played(Integer rounds_played) {
        this.rounds_played = rounds_played;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Double getAcs() {
        return acs;
    }

    public void setAcs(Double acs) {
        this.acs = acs;
    }

    public Double getKd() {
        return kd;
    }

    public void setKd(Double kd) {
        this.kd = kd;
    }

    public Integer getKast() {
        return kast;
    }

    public void setKast(Integer kast) {
        this.kast = kast;
    }

    public Double getAdr() {
        return adr;
    }

    public void setAdr(Double adr) {
        this.adr = adr;
    }

    public Double getKpr() {
        return kpr;
    }

    public void setKpr(Double kpr) {
        this.kpr = kpr;
    }

    public Double getApr() {
        return apr;
    }

    public void setApr(Double apr) {
        this.apr = apr;
    }

    public Double getFkpr() {
        return fkpr;
    }

    public void setFkpr(Double fkpr) {
        this.fkpr = fkpr;
    }

    public Double getFdpr() {
        return fdpr;
    }

    public void setFdpr(Double fdpr) {
        this.fdpr = fdpr;
    }

    public Integer getHs_percentage() {
        return hs_percentage;
    }

    public void setHs_percentage(Integer hs_percentage) {
        this.hs_percentage = hs_percentage;
    }

    public Integer getClutch_success_percentage() {
        return clutch_success_percentage;
    }

    public void setClutch_success_percentage(Integer clutch_success_percentage) {
        this.clutch_success_percentage = clutch_success_percentage;
    }
}
