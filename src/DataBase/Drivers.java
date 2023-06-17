/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

/**
 *
 * @author Denizhan
 */
public class Drivers {
    private int driverNo;
    String driverName;
    int driverAge;
    String driverTel;

    public Drivers(int driverNo, String driverName, int driverAge, String driverTel) {
        this.driverNo = driverNo;
        this.driverName = driverName;
        this.driverAge = driverAge;
        this.driverTel = driverTel;
    }

    public int getDriverNo() {
        return driverNo;
    }

    public void setDriverNo(int driverNo) {
        this.driverNo = driverNo;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getDriverAge() {
        return driverAge;
    }

    public void setDriverAge(int driverAge) {
        this.driverAge = driverAge;
    }

    public String getDriverTel() {
        return driverTel;
    }

    public void setDriverTel(String driverTel) {
        this.driverTel = driverTel;
    }
    
    
}
