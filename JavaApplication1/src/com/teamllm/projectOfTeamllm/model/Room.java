 
package com.teamllm.projectOfTeamllm.model;
 
public class Room {
    private int idRoom;
    private String nameRoom;
    private int idFlat;
    private int idHouse;
    private String gender;
    private int amount;
    private int currentAmount;
    private String nameHouse;
    private String nameFlat;

    public String getNameFlat() {
        return nameFlat;
    }

    public void setNameFlat(String nameFlat) {
        this.nameFlat = nameFlat;
    }
    
    
    public String getNameHouse() {
        return nameHouse;
    }

    public void setNameHouse(String nameHouse) {
        this.nameHouse = nameHouse;
    }
    
    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

    public int getIdFlat() {
        return idFlat;
    }

    public void setIdFlat(int idFlat) {
        this.idFlat = idFlat;
    }

    public int getIdHouse() {
        return idHouse;
    }

    public void setIdHouse(int idHouse) {
        this.idHouse = idHouse;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(int currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Room(int idRoom, String nameRoom, int idFlat, int idHouse, String gender, int amount, int currentAmount, String nameHouse, String nameFlat) {
        this.idRoom = idRoom;
        this.nameRoom = nameRoom;
        this.idFlat = idFlat;
        this.idHouse = idHouse;
        this.gender = gender;
        this.amount = amount;
        this.currentAmount = currentAmount;
        this.nameHouse = nameHouse;
        this.nameFlat = nameFlat;
    }
 

    public Room(int idRoom,String nameRoom, String gender, int amount, int currentAmount, String nameHouse, String nameFlat) {
        this.idRoom = idRoom;
        this.nameRoom = nameRoom;
        this.gender = gender;
        this.amount = amount;
        this.currentAmount = currentAmount;
        this.nameHouse = nameHouse;
        this.nameFlat = nameFlat;
    }

    public Room() {
    }

    public Room(int idRoom, String nameRoom) {
        this.idRoom = idRoom;
        this.nameRoom = nameRoom;
    }
    
    
}
