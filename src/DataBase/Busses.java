/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

/**
 *
 * @author Denizhan
 */
public class Busses {
    int bussNo;
    String bussModel;
    String driverName;
    String bussPlate;

    public Busses(int bussNo, String bussModel, String driverName, String bussPlate) {
        this.bussNo = bussNo;
        this.bussModel = bussModel;
        this.driverName = driverName;
        this.bussPlate = bussPlate;
    }

    public int getBussNo() {
        return bussNo;
    }

    public void setBussNo(int bussNo) {
        this.bussNo = bussNo;
    }

    public String getBussModel() {
        return bussModel;
    }

    public void setBussModel(String bussModel) {
        this.bussModel = bussModel;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getBussPlate() {
        return bussPlate;
    }

    public void setBussPlate(String bussPlate) {
        this.bussPlate = bussPlate;
    }
    
    
    
    
}
