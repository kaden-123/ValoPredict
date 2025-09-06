package com.valorant.ValoPredict.player;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name="valo_statistics")
public class Player {

    @Id
    private int id;

    @Column(name="player_name")
    private String name;

    private String org;

    @ElementCollection
    @CollectionTable(
            name = "player_agents",
            joinColumns = @JoinColumn(name="player_id")
    )
    @Column(name="agent")
    private List<String> agents;

    private int rounds_played;

    private double rating;

    private double acs;

    private double kd;

    private int kast;

    private double adr;

    private double kpr;

    private double apr;

    private double fkpr;

    private double fdpr;

    private int hs_percentage;

    private int clutch_success_percentage;

    public Player() {
    }

    public Player(int id, String name, String org, List<String> agents, int rounds_played, double rating, double acs, double kd, int kast, double adr, double kpr, double apr, double fkpr, double fdpr, int hs_percentage, int clutch_success_percentage) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<String> getAgents() {
        return agents;
    }

    public void setAgents(List<String> agents) {
        this.agents = agents;
    }

    public int getRounds_played() {
        return rounds_played;
    }

    public void setRounds_played(int rounds_played) {
        this.rounds_played = rounds_played;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public double getAcs() {
        return acs;
    }

    public void setAcs(double acs) {
        this.acs = acs;
    }

    public double getKd() {
        return kd;
    }

    public void setKd(double kd) {
        this.kd = kd;
    }

    public int getKast() {
        return kast;
    }

    public void setKast(int kast) {
        this.kast = kast;
    }

    public double getAdr() {
        return adr;
    }

    public void setAdr(double adr) {
        this.adr = adr;
    }

    public double getKpr() {
        return kpr;
    }

    public void setKpr(double kpr) {
        this.kpr = kpr;
    }

    public double getApr() {
        return apr;
    }

    public void setApr(double apr) {
        this.apr = apr;
    }

    public double getFkpr() {
        return fkpr;
    }

    public void setFkpr(double fkpr) {
        this.fkpr = fkpr;
    }

    public double getFdpr() {
        return fdpr;
    }

    public void setFdpr(double fdpr) {
        this.fdpr = fdpr;
    }

    public int getHs_percentage() {
        return hs_percentage;
    }

    public void setHs_percentage(int hs_percentage) {
        this.hs_percentage = hs_percentage;
    }

    public int getClutch_success_percentage() {
        return clutch_success_percentage;
    }

    public void setClutch_success_percentage(int clutch_success_percentage) {
        this.clutch_success_percentage = clutch_success_percentage;
    }
}
