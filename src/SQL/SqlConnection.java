

package SQL;
import DataBase.BussExpedition;
import DataBase.Busses;
import DataBase.Cities;
import DataBase.Customers;
import DataBase.Drivers;
import DataBase.Expeditions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Denizhan
 */

public class SqlConnection {
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private PreparedStatement preparedStatement=null;
    
    public SqlConnection() {
         String fileName = "BussOtomation.accdb";
    String directoryPath = System.getProperty("user.dir");
    String msAccDB = "C:\\Users\\deniz\\Documents\\NetBeansProjects\\BussOtomation\\BussOtomation.accdb";
    String dbURL = "jdbc:ucanaccess://" + msAccDB;
            
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
           } catch (ClassNotFoundException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        try {
            connection=DriverManager.getConnection(dbURL);
            statement=connection.createStatement();
            System.out.println("Bağlantı Başarılı");
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    public boolean userLogin(String userName,String password){
         try {
             String sorgu="SELECT * FROM `USERS` WHERE KullaniciAdi=? AND KullaniciSifre=?";
             preparedStatement = connection.prepareStatement(sorgu);
             preparedStatement.setString(1, userName);
             preparedStatement.setString(2, password);
             ResultSet rs=preparedStatement.executeQuery();
             return rs.next();
         } catch (SQLException ex) {
             Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
         }
       }
    public void passwordChange(String userName,String newPassword){
        String result="UPDATE `USERS` SET KullaniciSifre=? WHERE KullaniciAdi=?";
        try {
            preparedStatement=connection.prepareStatement(result);
            preparedStatement.setString(1,newPassword);
            preparedStatement.setString(2,userName);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //-----------------------DRİVER---------------------------------------------
    public ArrayList<Drivers> driverCome(){
        ArrayList<Drivers>driver=new ArrayList<Drivers>();
        String result="SELECT * FROM `SURUCULER`";
        try {
            statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(result);
            while (rs.next()){
            int driverNo=rs.getInt("DriverNo");
            String driverName=rs.getString("driverName");
            int driverAge=rs.getInt("DriverAge");
            String driverTel=rs.getString("DriverTel");
            
            driver.add(new Drivers(driverNo, driverName, driverAge, driverTel));
            
            }
            return driver;
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }
    }
    public void driverAdd(String driverName,int driverAge,String driverTel){
        String result="INSERT INTO `SURUCULER` (`DriverNo`, `DriverName`, `DriverAge`, `DriverTel`) VALUES (NULL, ?,?,?)";
        try {
            preparedStatement=connection.prepareStatement(result);
            preparedStatement.setString(1, driverName);
            preparedStatement.setInt(2,driverAge);
            preparedStatement.setString(3, driverTel);
            preparedStatement.executeUpdate();
            connection.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void driverChange(int driverId,String driverName,int driverAge,String driverTel){
     String result="UPDATE `SURUCULER` SET `DriverName` = ?, `DriverAge` =?, `DriverTel` = ? WHERE `SURUCULER`.`DriverNo` = ?";   
        try {
            preparedStatement=connection.prepareStatement(result);
            preparedStatement.setString(1,driverName);
             preparedStatement.setInt(2,driverAge);
             preparedStatement.setString(3,driverTel);
             preparedStatement.setInt(4, driverId);
             preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void driverDelete(int driverId){
        String result="DELETE FROM SURUCULER WHERE `SURUCULER`.`DriverNo` = ?";
        try {
            preparedStatement=connection.prepareStatement(result);
            preparedStatement.setInt(1, driverId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //----------------------------CUSTOMER-----------------------------------
    public ArrayList<Customers> bringCustomer(){
        ArrayList<Customers>customers=new ArrayList<Customers>();
        String result="SELECT * FROM `MUSTERİLER`";
        try {
            statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(result);
            while(rs.next()){
            int customerId=rs.getInt("CustomerNo");
            String cstomerName=rs.getString("CustomerNameSurName");
            String genders=rs.getString("Gender");
            String telNo=rs.getString("CustomerTel");
            String adress=rs.getString("Adress");
            customers.add(new Customers(customerId, cstomerName, genders, telNo, adress));
            }
            return customers;
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
          return null;
        }
    }
    public void customerAdd(String customerName,String gender,String customerTel,String adress){
        String result="INSERT INTO `MUSTERİLER` (`CustomerNo`, `CustomerNameSurName`, `CustomerTel`, `Gender`, `Adress`) \n" +
"SELECT NULL, ?, ?, ?, ? \n" +
"FROM DUAL \n" +
"WHERE NOT EXISTS (SELECT 1 FROM `MUSTERİLER` WHERE `CustomerNameSurName` = ?)";
        try {
            preparedStatement=connection.prepareStatement(result);
            preparedStatement.setString(1, customerName);
            preparedStatement.setString(2,customerTel);
            preparedStatement.setString(3, gender);
            preparedStatement.setString(4,adress);
            preparedStatement.setString(5, customerName);
            preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void customerChange(int customerId,String customerName,String gender,String customerTel,String adress){
     String result="UPDATE `MUSTERİLER` SET `CustomerNameSurName` = ?, `CustomerTel` =?, `Gender` = ?,`Adress` = ? WHERE `MUSTERİLER`.`CustomerNo` = ?";   
        try {
            preparedStatement=connection.prepareStatement(result);
            preparedStatement.setString(1,customerName);
             preparedStatement.setString(2,customerTel);
             preparedStatement.setString(3,gender);
             preparedStatement.setString(4, adress);
             preparedStatement.setInt(5, customerId);
             preparedStatement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void customerDelete(int customerId){
        String result="DELETE FROM MUSTERİLER WHERE `MUSTERİLER`.`CustomerNo` = ?";
        try {
            preparedStatement=connection.prepareStatement(result);
            preparedStatement.setInt(1, customerId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //-----------------------buss screen---------------------------------
    public ArrayList<Busses> bringBusses(){
        ArrayList<Busses>busses=new ArrayList<Busses>();
        String result="SELECT OTOBUSLER.OtobusNo, OTOBUSLER.OtobüsPlaka, OTOBUSLER.OtobüsMarka, SURUCULER.DriverName\n" +
"FROM SURUCULER INNER JOIN OTOBUSLER ON SURUCULER.DriverNo = OTOBUSLER.Sürücü;";
        try {
            statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(result);
            while (rs.next()){
                int otobusNo=rs.getInt("OtobusNo");
                String busPlate=rs.getString("OtobüsPlaka");
                String bussModelNo=rs.getString("OtobüsMarka");
                String driverName=rs.getString("DriverName");
                busses.add(new Busses(otobusNo, bussModelNo, driverName, busPlate));
            }
            return busses;
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
           return null;       
        }
    }
 public void bussUpdate(String bussPlate,String bussModel,int driverId,int bussId){
     String result="UPDATE `OTOBUSLER` SET `OtobüsPlaka` = ?, `OtobüsMarka` =?, `Sürücü` = ? WHERE `OTOBUSLER`.`OtobusNo` = ?";
        try {
            preparedStatement=connection.prepareStatement(result);
            preparedStatement.setString(1,bussPlate);
            preparedStatement.setString(2,bussModel);
            preparedStatement.setInt(3, driverId);
            preparedStatement.setInt(4, bussId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
 public void bussAdd(String bussPlate,String bussModel,int driverId){
     String result="INSERT INTO `OTOBUSLER` (`OtobüsPlaka`, `OtobüsMarka`, `Sürücü`) VALUES (?,?,?)";
        try {
            preparedStatement=connection.prepareStatement(result);
            preparedStatement.setString(1, bussPlate);
            preparedStatement.setString(2, bussModel);
            preparedStatement.setInt(3, driverId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
    public int getDriverId(String driverName){
            int driverId=0;
        try {
            String result="SELECT SURUCULER.DriverNo, SURUCULER.DriverName FROM SURUCULER WHERE SURUCULER.DriverName = ?";
            //SELECT SURUCULER.DriverNo, SURUCULER.DriverName FROM SURUCULER WHERE (((SURUCULER.DriverName)="dawdawd"));
            PreparedStatement statement = connection.prepareStatement(result);
            statement.setString(1, driverName);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                driverId=rs.getInt("DriverNo");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
           
        }
         return driverId;  
    }
    public void bussDelete(int bussId){
        String result="DELETE FROM OTOBUSLER WHERE `OTOBUSLER`.`OtobusNo` = ?";
        try {
            preparedStatement=connection.prepareStatement(result);
            preparedStatement.setInt(1, bussId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //------------------------Expeditions Area ------------------------------------------
    public ArrayList<Expeditions> bringExpeditions(){
        ArrayList<Expeditions>expeditions=new ArrayList<Expeditions>();
        String result="SELECT SEFERLER.SEFERNO, COUNTRIES.CountryName AS KALKIS, COUNTRIES_1.CountryName AS VARIS, SEFERLER.TARİH, SEFERLER.SEFERSAATİ, OTOBUSLER.OtobüsPlaka, SEFERLER.TAHMİNİSURE, SEFERLER.UCRET, SURUCULER.DriverName, SEFERLER.OTOBUS\n" +
"FROM SURUCULER INNER JOIN (OTOBUSLER INNER JOIN (COUNTRIES AS COUNTRIES_1 INNER JOIN (COUNTRIES INNER JOIN SEFERLER ON COUNTRIES.CountryId = SEFERLER.KALKIS) ON COUNTRIES_1.CountryId = SEFERLER.VARIS) ON OTOBUSLER.OtobusNo = SEFERLER.OTOBUS) ON SURUCULER.DriverNo = OTOBUSLER.Sürücü;";
        try {
            statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(result);
            while(rs.next()){
            int exNo=rs.getInt("SEFERNO");
            String departure=rs.getString("KALKIS");
            String arrival=rs.getString("VARIS");
            String date=rs.getString("TARİH");
            String hour=rs.getString("SEFERSAATİ");
            int bussNo=rs.getInt("OTOBUS");
            int time=rs.getInt("TAHMİNİSURE");
            int price=rs.getInt("UCRET");
            String bussPlate=rs.getString("OtobüsPlaka");
            String driverName=rs.getString("DriverName");
              expeditions.add(new Expeditions(exNo, departure, arrival, date, hour, bussNo, time, price, bussPlate,driverName));
            }
            return expeditions;
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        }
    }
    public int getCityId(String city){
          
        try {
            String result="SELECT COUNTRIES.CountryId, COUNTRIES.CountryName FROM COUNTRIES WHERE (((COUNTRIES.CountryName)=?));";
            //SELECT SURUCULER.DriverNo, SURUCULER.DriverName FROM SURUCULER WHERE (((SURUCULER.DriverName)="dawdawd"));
            PreparedStatement statement = connection.prepareStatement(result);
            statement.setString(1, city);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
               int cityId=rs.getInt("CountryId");
                return cityId;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
           
        }
         return 0;  
    }
    public int getBusId(String bussPlate){
            int bussId=0;
        try {
            String result="SELECT OTOBUSLER.OtobusNo, OTOBUSLER.OtobüsPlaka FROM OTOBUSLER WHERE (((OTOBUSLER.OtobüsPlaka)=?));";
            //SELECT OTOBUSLER.OtobusNo, OTOBUSLER.OtobüsPlaka FROM OTOBUSLER WHERE (((OTOBUSLER.OtobüsPlaka)=?));

            PreparedStatement statement = connection.prepareStatement(result);
            statement.setString(1, bussPlate);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                bussId=rs.getInt("OtobusNo");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
           
        }
         return bussId;  
    }
    public ArrayList<Cities>bringCity(){
        try {
            ArrayList<Cities>cities=new ArrayList<Cities>();
            String result="SELECT COUNTRIES.CountryId, COUNTRIES.CountryName\n" +
                    "FROM COUNTRIES;";
            statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(result);
            while(rs.next()){
                int cityId=rs.getInt("CountryId");
                String cityName=rs.getString("CountryName");
                cities.add(new Cities(cityId, cityName));
            }
            return cities;
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        return null;
        }
    }
    public void addExpedition(int dep,int arrival,String date,String hour,int busId,int estTime,int price){
        String result="INSERT INTO `SEFERLER` (`SEFERNO`,`KALKIS`, `VARIS`, `TARİH`, `SEFERSAATİ`, `OTOBUS`, `TAHMİNİSURE`, `UCRET`) VALUES (NULL,?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(result);
            statement.setInt(1, dep);
            statement.setInt(2, arrival);
            statement.setString(3, date);
            statement.setString(4, hour);
            statement.setInt(5, busId);
            statement.setInt(6, estTime);
            statement.setInt(7, price);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean bussExpCheck(int expNo){
        String resultCheck="SELECT OTOBUSSEFER.SEFERNO\n" +
"FROM OTOBUSSEFER\n" +
"WHERE (((OTOBUSSEFER.SEFERNO)=?));";
        try {
           PreparedStatement statement = connection.prepareStatement(resultCheck);
        statement.setInt(1, expNo); // Parametre değerini belirtin
        ResultSet rs = statement.executeQuery();
           return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        return false;
        }
    }
    public void addBussExp(int expNo){
        
        String result="INSERT INTO `OTOBUSSEFER` (`ID`,`SEFERNO`,`KOLTUKNO`, `MUSTERIID`) VALUES (NULL,?,?,1)";
       PreparedStatement statement;
        try {
           
            for (int i = 1; i < 48; i++) {
               statement = connection.prepareStatement(result);  
                statement.setInt(1, expNo); // Sütuna eklenecek veriyi belirtin
                statement.setInt(2,i);
                statement.executeUpdate();
            }
         } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    //------------------------------------------------------------
    public ArrayList<Expeditions>expeditionSelect(String departureCity,String arrivalCity,String cdate){
        ArrayList<Expeditions>expeditionSelect=new ArrayList<Expeditions>();
        String result="SELECT SEFERLER.SEFERNO, COUNTRIES.CountryName AS KALKIS, COUNTRIES_1.CountryName AS VARIS, SEFERLER.TARİH, SEFERLER.SEFERSAATİ, OTOBUSLER.OtobüsPlaka, SEFERLER.TAHMİNİSURE, SEFERLER.UCRET, SURUCULER.DriverName, SEFERLER.OTOBUS\n" +
"FROM SURUCULER INNER JOIN (OTOBUSLER INNER JOIN (COUNTRIES AS COUNTRIES_1 INNER JOIN (COUNTRIES INNER JOIN SEFERLER ON COUNTRIES.CountryId = SEFERLER.KALKIS) ON COUNTRIES_1.CountryId = SEFERLER.VARIS) ON OTOBUSLER.OtobusNo = SEFERLER.OTOBUS) ON SURUCULER.DriverNo = OTOBUSLER.Sürücü\n" +
"WHERE (((COUNTRIES.CountryName)=?) AND ((COUNTRIES_1.CountryName)=?) AND ((SEFERLER.TARİH)=?));";
        try {
           PreparedStatement statement = connection.prepareStatement(result);
        statement.setString(1, departureCity);
        statement.setString(2, arrivalCity);
        statement.setString(3, cdate);
        
        ResultSet rs = statement.executeQuery();
            
            
            while(rs.next()){
            int exNo=rs.getInt("SEFERNO");
            String departure=rs.getString("KALKIS");
            String arrival=rs.getString("VARIS");
            String date=rs.getString("TARİH");
            String hour=rs.getString("SEFERSAATİ");
            int bussNo=rs.getInt("OTOBUS");
            int time=rs.getInt("TAHMİNİSURE");
            int price=rs.getInt("UCRET");
            String bussPlate=rs.getString("OtobüsPlaka");
            String driverName=rs.getString("DriverName");
              expeditionSelect.add(new Expeditions(exNo, departure, arrival, date, hour, bussNo, time, price, bussPlate,driverName));
            }
            return expeditionSelect;
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
           return null;
        } 
    }
    public ArrayList<BussExpedition>getBussExpedition(int expId){
        ArrayList<BussExpedition>bussExpeditionSelect=new ArrayList<BussExpedition>();
        String result="SELECT OTOBUSSEFER.ID, SEFERLER.SEFERNO, OTOBUSSEFER.KOLTUKNO, MUSTERİLER.CustomerNameSurName, MUSTERİLER.Gender, MUSTERİLER.CustomerTel\n" +
"FROM OTOBUSLER INNER JOIN (MUSTERİLER INNER JOIN (SEFERLER INNER JOIN OTOBUSSEFER ON SEFERLER.SEFERNO = OTOBUSSEFER.SEFERNO) ON MUSTERİLER.CustomerNo = OTOBUSSEFER.MUSTERIID) ON OTOBUSLER.OtobusNo = SEFERLER.OTOBUS\n" +
"WHERE (((SEFERLER.SEFERNO)=?))\n" +
"ORDER BY OTOBUSSEFER.KOLTUKNO;";
        try {
            
            PreparedStatement statement = connection.prepareStatement(result);
            statement.setInt(1, expId);
            ResultSet rs = statement.executeQuery();
            
            
             while(rs.next()){
            int id=rs.getInt("ID");
            int expNo=rs.getInt("SEFERNO");
            int seatNo=rs.getInt("KOLTUKNO");
            String customerName=rs.getString("CustomerNameSurName");
             String gender=rs.getString("Gender");
             bussExpeditionSelect.add(new BussExpedition(id, expNo, seatNo, customerName, gender));
             }
             return bussExpeditionSelect;
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
          return null;
        }
      }
    public int getCustomerId(String customerName){
        int customerId=0;
        try {
            String result="SELECT MUSTERİLER.CustomerNameSurName, MUSTERİLER.CustomerNo\n" +
                    "FROM MUSTERİLER\n" +
                    "WHERE (((MUSTERİLER.CustomerNameSurName)=?));";
            PreparedStatement statement = connection.prepareStatement(result);
            statement.setString(1, customerName);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
               customerId = rs.getInt("CustomerNo");
                }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customerId;
    }
    public void addTicket(int expNo,int seatNumber,int customerId ){
       String result="UPDATE OTOBUSSEFER SET OTOBUSSEFER.MUSTERIID = ? WHERE (((OTOBUSSEFER.SEFERNO)=?) AND ((OTOBUSSEFER.KOLTUKNO)=?));";
        try {
            preparedStatement=connection.prepareStatement(result);
            preparedStatement.setInt(1, customerId);
            preparedStatement.setInt(2, expNo);
            preparedStatement.setInt(3, seatNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public String getGender(int expNo,int seatNo){
        String gender=null;
        try {
            String result="SELECT OTOBUSSEFER.SEFERNO, OTOBUSSEFER.KOLTUKNO, MUSTERİLER.Gender\n" +
                    "FROM MUSTERİLER INNER JOIN OTOBUSSEFER ON MUSTERİLER.CustomerNo = OTOBUSSEFER.MUSTERIID\n" +
                    "WHERE (((OTOBUSSEFER.SEFERNO)=?) AND ((OTOBUSSEFER.KOLTUKNO)=?));";
            PreparedStatement statement = connection.prepareStatement(result);
            statement.setInt(1, expNo); // Parametre değerini belirtin
            statement.setInt(2, seatNo);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                gender=rs.getString("Gender");
              
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
         
        }
        return gender;
    }
    public void deleteExpedition(int expId){
        String result="DELETE FROM SEFERLER WHERE `SEFERLER`.`SEFERNO` = ?";
        
         try {
            preparedStatement=connection.prepareStatement(result);
            preparedStatement.setInt(1, expId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void deleteBussSeat(int expId){
      String result="DELETE FROM OTOBUSSEFER WHERE `OTOBUSSEFER`.`SEFERNO` = ?";
       
         try {
            preparedStatement=connection.prepareStatement(result);
            preparedStatement.setInt(1, expId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SqlConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }


    
    

