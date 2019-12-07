/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teamllm.projectOfTeamllm.model;

/**
 *
 * @author MaiTuanAnhLapTop
 */
public class Flat {
    private int idFlat;
    private int numberFlat;
    private String nameFlat;
    private int idHouse_Flat;

    public String getNameFlat() {
        return nameFlat;
    }

    public void setNameFlat(String nameFlat) {
        this.nameFlat = nameFlat;
    }

    
    
    public int getIdFlat() {
        return idFlat;
    }

    public void setIdFlat(int idFlat) {
        this.idFlat = idFlat;
    }

    public int getNumberFlat() {
        return numberFlat;
    }

    public void setNumberFlat(int numberFlat) {
        this.numberFlat = numberFlat;
    }

    public int getIdHouse_Flat() {
        return idHouse_Flat;
    }

    public void setIdHouse_Flat(int idHouse_Flat) {
        this.idHouse_Flat = idHouse_Flat;
    }

    public Flat(int idFlat, String nameFlat) {
        this.idFlat = idFlat;
        this.nameFlat = nameFlat;
    }

    public Flat() {
    }

    
}
