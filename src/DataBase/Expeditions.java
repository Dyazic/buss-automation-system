/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

/**
 *
 * @author Denizhan
 */
public class Expeditions {
    private int exNo;
    private String departure;
    private String arrival;
    private String date;
    private String hour;
    private int bussNo;
    private int time;
    private int price;
    private String bussPlate;
    private String bussDriver;

    public Expeditions(int exNo, String departure, String arrival, String date, String hour, int bussNo, int time, int price, String bussPlate, String bussDriver) {
        this.exNo = exNo;
        this.departure = departure;
        this.arrival = arrival;
        this.date = date;
        this.hour = hour;
        this.bussNo = bussNo;
        this.time = time;
        this.price = price;
        this.bussPlate = bussPlate;
        this.bussDriver = bussDriver;
    }

    public int getExNo() {
        return exNo;
    }

    public void setExNo(int exNo) {
        this.exNo = exNo;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getBussNo() {
        return bussNo;
    }

    public void setBussNo(int bussNo) {
        this.bussNo = bussNo;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getBussPlate() {
        return bussPlate;
    }

    public void setBussPlate(String bussPlate) {
        this.bussPlate = bussPlate;
    }

    public String getBussDriver() {
        return bussDriver;
    }

    public void setBussDriver(String bussDriver) {
        this.bussDriver = bussDriver;
    }
    
   
}
