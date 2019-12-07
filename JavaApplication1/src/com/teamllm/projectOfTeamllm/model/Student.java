
package com.teamllm.projectOfTeamllm.model;
 
public class Student {
    private int id;
    private int code;
    private String pass;
    private String fullname;
    private int age;
    private String gender;
    private String className;
    private int idRoom;
    private String status;
    private String history;
    private int role;
    private String roomName;
    private String flatName;
    private String houseName;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    
    public String getFlatName() {
        return flatName;
    }

    public void setFlatName(String flatName) {
        this.flatName = flatName;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Student(int id, int code, String pass, String fullname, int age, String gender, String className, int idRoom, String status, String history) {
        this.id = id;
        this.code = code;
        this.pass = pass;
        this.fullname = fullname;
        this.age = age;
        this.gender = gender;
        this.className = className;
        this.idRoom = idRoom;
        this.status = status;
        this.history = history;
    }
    
    public Student(int id) {
        this.id = id;
    }

    public Student() {
    }

    public Student(int id, int code) {
        this.id = id;
        this.code = code;
    }

    public Student(int id, String roomName, String flatName, String houseName) {
        this.id = id;
        this.roomName = roomName;
        this.flatName = flatName;
        this.houseName = houseName;
    }

  
}