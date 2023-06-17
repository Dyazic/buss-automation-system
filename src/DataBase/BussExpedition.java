/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

/**
 *
 * @author Denizhan
 */
public class BussExpedition {
    private int id;
    private int expNo;
    private int seat;
    private String customerName;
    private String gender;

    public BussExpedition(int id, int expNo, int seat, String customerName, String gender) {
        this.id = id;
        this.expNo = expNo;
        this.seat = seat;
        this.customerName = customerName;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getExpNo() {
        return expNo;
    }

    public void setExpNo(int expNo) {
        this.expNo = expNo;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
