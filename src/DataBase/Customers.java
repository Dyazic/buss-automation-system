/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

/**
 *
 * @author Denizhan
 */
public class Customers {
    private int customerId;
    private String cstomerName;
    private String Gender;
    private String telNo;
    private String adress;

    public Customers(int customerId, String cstomerName, String Gender, String telNo, String adress) {
        this.customerId = customerId;
        this.cstomerName = cstomerName;
        this.Gender = Gender;
        this.telNo = telNo;
        this.adress = adress;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCstomerName() {
        return cstomerName;
    }

    public void setCstomerName(String cstomerName) {
        this.cstomerName = cstomerName;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    
   
   
    
}
