package bussotomation;


import DataBase.BussExpedition;
import SQL.SqlConnection;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JButton;



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Denizhan
 */
public class TicketSelectionScreen extends javax.swing.JFrame{

    /**
     * Creates new form TicketSelectionScreen
     */
    Color famaleColor=Color.decode("#FFAFEF");
    Color maleColor=Color.decode("#7EA0FF");
    Color emptyColor=Color.decode("#9E9E9E");
    
    SQL.SqlConnection sql=new SqlConnection();
    JButton[]buttons=new JButton[47];
    String gender=null;
   MainScreen main=new MainScreen();
   int expNo=0;
   int choosenSeat;

    
    public TicketSelectionScreen() {
      
      
        initComponents();
        setTitle("Biletleme Ekranı");
      // labelExpNo.setText(String.valueOf(expNo));
        creditCardPanel.setVisible(false);
    }
     
   public String getGenderForSeat(int seatNumber) {
       
    ArrayList<BussExpedition> bussSeats = sql.getBussExpedition(expNo);
    if (bussSeats != null) {
        for (BussExpedition bussSeat : bussSeats) {
            int seat = bussSeat.getSeat();
            if (seat == seatNumber) {
                return bussSeat.getGender();
            }
        }
    }
    return null;
}
    public void paintButton() {
        ArrayList<BussExpedition>bussSeats=new ArrayList<BussExpedition>();

        bussSeats=sql.getBussExpedition(expNo);
        if(bussSeats!=null){
            for(BussExpedition bussSeat:bussSeats){
               int seat=bussSeat.getSeat();
               String gender=bussSeat.getGender();
               buttons[0]=seat1;
               buttons[1]=seat2;
               buttons[2]=seat3;
               buttons[3]=seat4;
               buttons[4]=seat5;
               buttons[5]=seat6;
               buttons[6]=seat7;
               buttons[7]=seat8;
               buttons[8]=seat9;
               buttons[9]=seat10;
               buttons[10]=seat11;
               buttons[11]=seat12;
               buttons[12]=seat13;
               buttons[13]=seat14;
               buttons[14]=seat15;
               buttons[15]=seat16;
               buttons[16]=seat17;
               buttons[17]=seat18;
               buttons[18]=seat19;
               buttons[19]=seat20;
               buttons[20]=seat21;
               buttons[21]=seat22;
               buttons[22]=seat23;
               buttons[23]=seat24;
               buttons[24]=seat25;
               buttons[25]=seat26;
               buttons[26]=seat27;
               buttons[27]=seat28;
               buttons[28]=seat29;
               buttons[29]=seat30;
               buttons[30]=seat31;
               buttons[31]=seat32;
               buttons[32]=seat33;
               buttons[33]=seat34;
               buttons[34]=seat35;
               buttons[35]=seat36;
               buttons[36]=seat37;
               buttons[37]=seat38;
               buttons[38]=seat39;
               buttons[39]=seat40;
               buttons[40]=seat41;
               buttons[41]=seat42;
               buttons[42]=seat43;
               buttons[43]=seat44;
               buttons[44]=seat45;
               buttons[45]=seat46;
               buttons[46]=seat47;
              JButton button = buttons[seat - 1];
               if (gender != null) {
               if (gender.equals("-")) {
                button.setEnabled(true);
                button.setBackground(emptyColor);
               } else if (gender.equals("Erkek")) {
                button.setBackground(maleColor);
               } else if (gender.equals("Kadın")) {
                button.setBackground(famaleColor);
               }
            }
    }
    }
    }
    
    public void genderCheck(String selectedGender,int selectedSeat,int custId){
        if(selectedSeat==1|| selectedSeat==5|| selectedSeat==9
                || selectedSeat==13 || selectedSeat==17 || selectedSeat==21
                || selectedSeat==23 || selectedSeat==27 || selectedSeat==31
                || selectedSeat==35 || selectedSeat==39 || selectedSeat==43){
            int seat=selectedSeat+1;
            String gender1=sql.getGender(expNo, seat);
           
            
            if(gender1.equals("-")){
            //  if(){
                 sql.addTicket(expNo, selectedSeat, custId);
                        paintButton(); 
                        System.out.println("İşlem başarılı");
            }else if(selectedGender.equals(gender1)){
                     sql.addTicket(expNo, selectedSeat, custId);
                  paintButton();
                   System.out.println("İşlem başarılı");
                   
                 }
               else if(!selectedGender.equals(gender1)){
                labelWarning.setText("Cinsiyet farkından dolayı işleme devam edemezsin");
                }
       
               else{
                   labelWarning.setText("Koltul dolu");
                }
        }
        else if(selectedSeat==2| selectedSeat==6|| selectedSeat==10
                || selectedSeat==14 || selectedSeat==18 || selectedSeat==22
                || selectedSeat==24 || selectedSeat==28 || selectedSeat==32
                || selectedSeat==36 || selectedSeat==40 || selectedSeat==44 || selectedSeat==45){
            int seat=selectedSeat-1;
            String gender1=sql.getGender(expNo, seat);
           
            
            if(gender1.equals("-")){
            //  if(){
                 sql.addTicket(expNo, selectedSeat, custId);
                        paintButton(); 
                        System.out.println("İşlem başarılı");
            }else if(selectedGender.equals(gender1)){
                     sql.addTicket(expNo, selectedSeat, custId);
                  paintButton();
                   System.out.println("İşlem başarılı");
                   
                 }
               else if(!selectedGender.equals(gender1)){
                labelWarning.setText("Cinsiyet farkından dolayı işleme devam edemezsin");
                }   
               else{
                   labelWarning.setText("Koltul dolu");
                }
        }
        else if(selectedSeat==3|| selectedSeat==7|| selectedSeat==11
                || selectedSeat==15 || selectedSeat==19 || selectedSeat==25
                || selectedSeat==29 || selectedSeat==33 || selectedSeat==37
                || selectedSeat==41 || selectedSeat==46){
            int seat=selectedSeat+1;
            String gender1=sql.getGender(expNo, seat);
           
            
            if(gender1.equals("-")){
            //  if(){
                 sql.addTicket(expNo, selectedSeat, custId);
                        paintButton(); 
                        System.out.println("İşlem başarılı");
            }else if(selectedGender.equals(gender1)){
                     sql.addTicket(expNo, selectedSeat, custId);
                  paintButton();
                   System.out.println("İşlem başarılı");
                   
                 }
               else if(!selectedGender.equals(gender1)){
                labelWarning.setText("Cinsiyet farkından dolayı işleme devam edemezsin");
                }   
               else{
                   labelWarning.setText("Koltul dolu");
                }
        }
        else if(selectedSeat==4|| selectedSeat==8|| selectedSeat==12
                || selectedSeat==16 || selectedSeat==20 || selectedSeat==26
                || selectedSeat==30 || selectedSeat==34 || selectedSeat==38
                || selectedSeat==42 || selectedSeat==47){
            int seat=selectedSeat-1;
            String gender1=sql.getGender(expNo, seat);
            if(gender1.equals("-")){
            //  if(){
                 sql.addTicket(expNo, selectedSeat, custId);
                        paintButton(); 
                        System.out.println("İşlem başarılı");
            }else if(selectedGender.equals(gender1)){
                     sql.addTicket(expNo, selectedSeat, custId);
                  paintButton();
                   System.out.println("İşlem başarılı");
            }
            else if(!selectedGender.equals(gender1)){
                labelWarning.setText("Cinsiyet farkından dolayı işleme devam edemezsin");
                }   
               else{
                   labelWarning.setText("Koltul dolu");
                }
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tfCustomerName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfcustomerSurname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        buttonCustomerCheck = new javax.swing.JButton();
        comboBoxPayment = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        buttonTicketSell = new javax.swing.JButton();
        creditCardPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        labelSeatNumber = new javax.swing.JLabel();
        labelExpNo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        labelBusPlate = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        seat1 = new javax.swing.JButton();
        seat2 = new javax.swing.JButton();
        seat3 = new javax.swing.JButton();
        seat4 = new javax.swing.JButton();
        seat8 = new javax.swing.JButton();
        seat7 = new javax.swing.JButton();
        seat6 = new javax.swing.JButton();
        seat5 = new javax.swing.JButton();
        seat9 = new javax.swing.JButton();
        seat10 = new javax.swing.JButton();
        seat11 = new javax.swing.JButton();
        seat12 = new javax.swing.JButton();
        seat16 = new javax.swing.JButton();
        seat15 = new javax.swing.JButton();
        seat14 = new javax.swing.JButton();
        seat13 = new javax.swing.JButton();
        seat17 = new javax.swing.JButton();
        seat18 = new javax.swing.JButton();
        seat19 = new javax.swing.JButton();
        seat20 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        seat22 = new javax.swing.JButton();
        seat21 = new javax.swing.JButton();
        seat23 = new javax.swing.JButton();
        seat24 = new javax.swing.JButton();
        seat25 = new javax.swing.JButton();
        seat26 = new javax.swing.JButton();
        seat30 = new javax.swing.JButton();
        seat29 = new javax.swing.JButton();
        seat28 = new javax.swing.JButton();
        seat27 = new javax.swing.JButton();
        seat31 = new javax.swing.JButton();
        seat32 = new javax.swing.JButton();
        seat33 = new javax.swing.JButton();
        seat34 = new javax.swing.JButton();
        seat38 = new javax.swing.JButton();
        seat37 = new javax.swing.JButton();
        seat36 = new javax.swing.JButton();
        seat35 = new javax.swing.JButton();
        seat39 = new javax.swing.JButton();
        seat40 = new javax.swing.JButton();
        seat41 = new javax.swing.JButton();
        seat42 = new javax.swing.JButton();
        seat47 = new javax.swing.JButton();
        seat46 = new javax.swing.JButton();
        seat45 = new javax.swing.JButton();
        seat44 = new javax.swing.JButton();
        seat43 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfcustomerTel = new javax.swing.JTextField();
        labelCustId = new javax.swing.JLabel();
        labelWarning = new javax.swing.JLabel();
        labelGender = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        ticketCencel = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("İsim :");

        jLabel5.setText("Soyisim :");

        jLabel7.setText("Cinsiyet :");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Erkek", "Kadın" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        buttonCustomerCheck.setText("Müşteri Onayla");
        buttonCustomerCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCustomerCheckActionPerformed(evt);
            }
        });

        comboBoxPayment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nakit", "Kredi Kartı" }));
        comboBoxPayment.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxPaymentItemStateChanged(evt);
            }
        });

        jLabel8.setText("Ödeme Şekli");

        buttonTicketSell.setText("Bilet Satış");
        buttonTicketSell.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTicketSellActionPerformed(evt);
            }
        });

        jLabel9.setText("Kredi Kartı Ödeme Bilgileri");

        jLabel10.setText("Kart Bilgisi : ");

        jLabel11.setText("Kart Sahibi Adı :");

        jLabel12.setText("Kart Son Kullanım Tarihi:");

        javax.swing.GroupLayout creditCardPanelLayout = new javax.swing.GroupLayout(creditCardPanel);
        creditCardPanel.setLayout(creditCardPanelLayout);
        creditCardPanelLayout.setHorizontalGroup(
            creditCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creditCardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(creditCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(creditCardPanelLayout.createSequentialGroup()
                        .addGroup(creditCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12))
                        .addGap(12, 12, 12)
                        .addGroup(creditCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        creditCardPanelLayout.setVerticalGroup(
            creditCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(creditCardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(creditCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(creditCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(creditCardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jLabel13.setText("Koltuk No:");

        labelBusPlate.setText("Plaka");

        jLabel3.setText("Şöför");

        jLabel4.setText("Ön Kapı");

        seat1.setText("1");
        seat1.setPreferredSize(new java.awt.Dimension(75, 25));
        seat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat1ActionPerformed(evt);
            }
        });

        seat2.setText("2");
        seat2.setPreferredSize(new java.awt.Dimension(75, 25));
        seat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat2ActionPerformed(evt);
            }
        });

        seat3.setText("3");
        seat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat3ActionPerformed(evt);
            }
        });

        seat4.setText("4");
        seat4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat4ActionPerformed(evt);
            }
        });

        seat8.setText("8");
        seat8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat8ActionPerformed(evt);
            }
        });

        seat7.setText("7");
        seat7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat7ActionPerformed(evt);
            }
        });

        seat6.setText("6");
        seat6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat6ActionPerformed(evt);
            }
        });

        seat5.setText("5");
        seat5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat5ActionPerformed(evt);
            }
        });

        seat9.setText("9");
        seat9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat9ActionPerformed(evt);
            }
        });

        seat10.setText("10");
        seat10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat10ActionPerformed(evt);
            }
        });

        seat11.setText("11");
        seat11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat11ActionPerformed(evt);
            }
        });

        seat12.setText("12");
        seat12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat12ActionPerformed(evt);
            }
        });

        seat16.setText("16");
        seat16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat16ActionPerformed(evt);
            }
        });

        seat15.setText("15");
        seat15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat15ActionPerformed(evt);
            }
        });

        seat14.setText("14");
        seat14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat14ActionPerformed(evt);
            }
        });

        seat13.setText("13");
        seat13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat13ActionPerformed(evt);
            }
        });

        seat17.setText("17");
        seat17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat17ActionPerformed(evt);
            }
        });

        seat18.setText("18");
        seat18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat18ActionPerformed(evt);
            }
        });

        seat19.setText("19");
        seat19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat19ActionPerformed(evt);
            }
        });

        seat20.setText("20");
        seat20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat20ActionPerformed(evt);
            }
        });

        jLabel2.setText("Arka Kapı");

        seat22.setText("22");
        seat22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat22ActionPerformed(evt);
            }
        });

        seat21.setText("21");
        seat21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat21ActionPerformed(evt);
            }
        });

        seat23.setText("23");
        seat23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat23ActionPerformed(evt);
            }
        });

        seat24.setText("24");
        seat24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat24ActionPerformed(evt);
            }
        });

        seat25.setText("25");
        seat25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat25ActionPerformed(evt);
            }
        });

        seat26.setText("26");
        seat26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat26ActionPerformed(evt);
            }
        });

        seat30.setText("30");
        seat30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat30ActionPerformed(evt);
            }
        });

        seat29.setText("29");
        seat29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat29ActionPerformed(evt);
            }
        });

        seat28.setText("28");
        seat28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat28ActionPerformed(evt);
            }
        });

        seat27.setText("27");
        seat27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat27ActionPerformed(evt);
            }
        });

        seat31.setText("31");
        seat31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat31ActionPerformed(evt);
            }
        });

        seat32.setText("32");
        seat32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat32ActionPerformed(evt);
            }
        });

        seat33.setText("33");
        seat33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat33ActionPerformed(evt);
            }
        });

        seat34.setText("34");
        seat34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat34ActionPerformed(evt);
            }
        });

        seat38.setText("38");
        seat38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat38ActionPerformed(evt);
            }
        });

        seat37.setText("37");
        seat37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat37ActionPerformed(evt);
            }
        });

        seat36.setText("36");
        seat36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat36ActionPerformed(evt);
            }
        });

        seat35.setText("35");
        seat35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat35ActionPerformed(evt);
            }
        });

        seat39.setText("39");
        seat39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat39ActionPerformed(evt);
            }
        });

        seat40.setText("40");
        seat40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat40ActionPerformed(evt);
            }
        });

        seat41.setText("41");
        seat41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat41ActionPerformed(evt);
            }
        });

        seat42.setText("42");
        seat42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat42ActionPerformed(evt);
            }
        });

        seat47.setText("47");
        seat47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat47ActionPerformed(evt);
            }
        });

        seat46.setText("46");
        seat46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat46ActionPerformed(evt);
            }
        });

        seat45.setText("45");
        seat45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat45ActionPerformed(evt);
            }
        });

        seat44.setText("44");
        seat44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat44ActionPerformed(evt);
            }
        });

        seat43.setText("43");
        seat43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seat43ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(labelBusPlate, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(seat21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(seat23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(seat27, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(seat31, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(seat24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(seat28, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(seat22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(seat32, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(seat33, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(seat29, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(seat25, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(seat26, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(seat30, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(seat34, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(seat9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(seat13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(seat17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(seat35, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(seat39, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(seat43, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(seat1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(seat5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(seat14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(seat15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(seat10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(seat11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(seat2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(seat6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(seat7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(seat3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(seat18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(seat19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(seat36, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(seat37, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(seat40, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(seat41, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(seat44, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(seat45, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, Short.MAX_VALUE)
                                        .addComponent(seat46, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(seat4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(seat8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(seat12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(seat16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(seat20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(seat38, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(seat42, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(seat47, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(labelBusPlate, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat14, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat15, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat18, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat20, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat22, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat23, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat25, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat26, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat27, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat29, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat30, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat28, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat31, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat34, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat33, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat32, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat35, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat38, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat36, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat37, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat39, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat42, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat40, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat41, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seat43, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat47, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat44, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat46, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seat45, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        seat5.getAccessibleContext().setAccessibleName("40");
        seat5.getAccessibleContext().setAccessibleDescription("40");

        jScrollPane1.setViewportView(jPanel1);

        jLabel6.setText("Tel:");

        labelCustId.setText(".");

        jButton1.setText("Otobüs Getir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        ticketCencel.setText("Bilet İptal");
        ticketCencel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ticketCencelActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        jMenuItem1.setText("İlk Ekran");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setText("Sefer Secim Ekranı");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem2.setText("Çıkış");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(122, 122, 122)
                                .addComponent(buttonTicketSell))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelGender, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(labelSeatNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(labelWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(creditCardPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(73, 73, 73))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(labelExpNo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel5))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(tfCustomerName)
                                            .addComponent(tfcustomerSurname, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(labelCustId)
                                                .addComponent(tfcustomerTel, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(buttonCustomerCheck))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(comboBoxPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ticketCencel)))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 887, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labelExpNo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tfcustomerSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelGender, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tfcustomerTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonCustomerCheck))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(labelCustId))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(labelSeatNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(comboBoxPayment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ticketCencel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(creditCardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonTicketSell)
                        .addGap(14, 14, 14)
                        .addComponent(labelWarning, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 298, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxPaymentItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxPaymentItemStateChanged
        // TODO add your handling code here:
        String payment= (String) comboBoxPayment.getSelectedItem();
        System.out.println(payment);
        if(payment.equals("Nakit")){
            creditCardPanel.setVisible(false);
        }
        else if(payment.equals("Kredi Kartı")){
            creditCardPanel.setVisible(true);
        }        
        

    }//GEN-LAST:event_comboBoxPaymentItemStateChanged

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        Apps appScreen=new Apps();
        setVisible(false);
        appScreen.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        MainScreen mScreen=new MainScreen();
        setVisible(false);
        mScreen.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void buttonCustomerCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCustomerCheckActionPerformed
        // TODO add your handling code here:
        String name=tfCustomerName.getText();
        String surname=tfcustomerSurname.getText();
        String customerName=name+" "+surname;        
        gender=(String)jComboBox1.getSelectedItem();
        String  customerTel=tfcustomerTel.getText();
        String adress="";
        sql.customerAdd(customerName, gender, customerTel, adress);
       int customerId=sql.getCustomerId(customerName);
       labelCustId.setText(String.valueOf(customerId));
        
    }//GEN-LAST:event_buttonCustomerCheckActionPerformed

    private void buttonTicketSellActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTicketSellActionPerformed
        // TODO add your handling code here:
        labelWarning.setText("");
        int expNo=Integer.valueOf(labelExpNo.getText());
        int seatNumber=Integer.valueOf(labelSeatNumber.getText());
        //-----------------------------
        String name=tfCustomerName.getText();
        String surname=tfcustomerSurname.getText();
        String customerName=name+" "+surname;
        String paymentMethod=(String)comboBoxPayment.getSelectedItem();
        int custId=Integer.valueOf(labelCustId.getText());
        String gender1=labelGender.getText();
        genderCheck(gender1, seatNumber, custId);
        
        //checkSeat(gender);
     // labelWarning.setText(seatNumber+" nolu koltuk "+paymentMethod+" ile \n" +customerName+"kişisine satılmıştır");
        
        
    }//GEN-LAST:event_buttonTicketSellActionPerformed

    private void seat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat2ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("2");
    }//GEN-LAST:event_seat2ActionPerformed

    private void seat3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat3ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("3");
    }//GEN-LAST:event_seat3ActionPerformed

    private void seat4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat4ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("4");
    }//GEN-LAST:event_seat4ActionPerformed

    private void seat24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat24ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("24");
    }//GEN-LAST:event_seat24ActionPerformed

    private void seat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat1ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("1");
    }//GEN-LAST:event_seat1ActionPerformed

    private void seat5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat5ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("5");
    }//GEN-LAST:event_seat5ActionPerformed

    private void seat6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat6ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("6");
    }//GEN-LAST:event_seat6ActionPerformed

    private void seat7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat7ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("7");
    }//GEN-LAST:event_seat7ActionPerformed

    private void seat8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat8ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("8");
    }//GEN-LAST:event_seat8ActionPerformed

    private void seat9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat9ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("9");
    }//GEN-LAST:event_seat9ActionPerformed

    private void seat10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat10ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("10");
    }//GEN-LAST:event_seat10ActionPerformed

    private void seat11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat11ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("11");
    }//GEN-LAST:event_seat11ActionPerformed

    private void seat12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat12ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("12");
    }//GEN-LAST:event_seat12ActionPerformed

    private void seat13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat13ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("13");
    }//GEN-LAST:event_seat13ActionPerformed

    private void seat15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat15ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("15");
    }//GEN-LAST:event_seat15ActionPerformed

    private void seat14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat14ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("14");
    }//GEN-LAST:event_seat14ActionPerformed

    private void seat16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat16ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("16");
    }//GEN-LAST:event_seat16ActionPerformed

    private void seat17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat17ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("17");
    }//GEN-LAST:event_seat17ActionPerformed

    private void seat18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat18ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("18");
    }//GEN-LAST:event_seat18ActionPerformed

    private void seat19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat19ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("19");
    }//GEN-LAST:event_seat19ActionPerformed

    private void seat20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat20ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("20");
    }//GEN-LAST:event_seat20ActionPerformed

    private void seat21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat21ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("21");
    }//GEN-LAST:event_seat21ActionPerformed

    private void seat22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat22ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("22");
    }//GEN-LAST:event_seat22ActionPerformed

    private void seat23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat23ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("23");
    }//GEN-LAST:event_seat23ActionPerformed

    private void seat25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat25ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("25");
    }//GEN-LAST:event_seat25ActionPerformed

    private void seat26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat26ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("26");
    }//GEN-LAST:event_seat26ActionPerformed

    private void seat27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat27ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("27");
    }//GEN-LAST:event_seat27ActionPerformed

    private void seat28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat28ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("28");
    }//GEN-LAST:event_seat28ActionPerformed

    private void seat29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat29ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("29");
    }//GEN-LAST:event_seat29ActionPerformed

    private void seat30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat30ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("30");
    }//GEN-LAST:event_seat30ActionPerformed

    private void seat31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat31ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("31");
    }//GEN-LAST:event_seat31ActionPerformed

    private void seat32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat32ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("32");
    }//GEN-LAST:event_seat32ActionPerformed

    private void seat33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat33ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("33");
    }//GEN-LAST:event_seat33ActionPerformed

    private void seat34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat34ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("34");
    }//GEN-LAST:event_seat34ActionPerformed

    private void seat35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat35ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("35");
    }//GEN-LAST:event_seat35ActionPerformed

    private void seat36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat36ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("36");
    }//GEN-LAST:event_seat36ActionPerformed

    private void seat37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat37ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("37");
    }//GEN-LAST:event_seat37ActionPerformed

    private void seat38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat38ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("38");
    }//GEN-LAST:event_seat38ActionPerformed

    private void seat39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat39ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("39");
    }//GEN-LAST:event_seat39ActionPerformed

    private void seat40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat40ActionPerformed
        // TODO add your handling code here:
        labelSeatNumber.setText("40");
    }//GEN-LAST:event_seat40ActionPerformed

    private void seat41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat41ActionPerformed
        // TODO add your handling code here:
         labelSeatNumber.setText("41");
    }//GEN-LAST:event_seat41ActionPerformed

    private void seat42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat42ActionPerformed
        // TODO add your handling code here:
         labelSeatNumber.setText("42");
    }//GEN-LAST:event_seat42ActionPerformed

    private void seat43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat43ActionPerformed
        // TODO add your handling code here:
         labelSeatNumber.setText("43");
    }//GEN-LAST:event_seat43ActionPerformed

    private void seat44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat44ActionPerformed
        // TODO add your handling code here:
         labelSeatNumber.setText("44");
    }//GEN-LAST:event_seat44ActionPerformed

    private void seat45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat45ActionPerformed
        // TODO add your handling code here:
         labelSeatNumber.setText("45");
    }//GEN-LAST:event_seat45ActionPerformed

    private void seat46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat46ActionPerformed
        // TODO add your handling code here:
         labelSeatNumber.setText("46");
    }//GEN-LAST:event_seat46ActionPerformed

    private void seat47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seat47ActionPerformed
        // TODO add your handling code here:
         labelSeatNumber.setText("47");
    }//GEN-LAST:event_seat47ActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        labelGender.setText(jComboBox1.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         paintButton();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void ticketCencelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ticketCencelActionPerformed
        // TODO add your handling code here:
        int expNo=Integer.valueOf(labelExpNo.getText());
        int seatNumber=Integer.valueOf(labelSeatNumber.getText());
        //-----------------------------
        String name=tfCustomerName.getText();
        String surname=tfcustomerSurname.getText();
        String customerName=name+" "+surname;
        String paymentMethod=(String)comboBoxPayment.getSelectedItem();
        int custId=1;
        labelWarning.setText(expNo+"Nolu Seferde "+seatNumber+"nolu koltuğun bileti iptal edilmiştir");
        sql.addTicket(expNo, seatNumber, custId);
        paintButton();
    }//GEN-LAST:event_ticketCencelActionPerformed

    /**
     * @param args the command line arguments
     */
   public void setExpNo(int expNo){
       this.expNo=expNo;
       System.out.println(this.expNo);
       labelExpNo.setText(String.valueOf(expNo));
      
   }
   
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TicketSelectionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TicketSelectionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TicketSelectionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicketSelectionScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TicketSelectionScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCustomerCheck;
    private javax.swing.JButton buttonTicketSell;
    private javax.swing.JComboBox<String> comboBoxPayment;
    private javax.swing.JPanel creditCardPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel labelBusPlate;
    private javax.swing.JLabel labelCustId;
    private javax.swing.JLabel labelExpNo;
    private javax.swing.JLabel labelGender;
    private javax.swing.JLabel labelSeatNumber;
    private javax.swing.JLabel labelWarning;
    private javax.swing.JButton seat1;
    private javax.swing.JButton seat10;
    private javax.swing.JButton seat11;
    private javax.swing.JButton seat12;
    private javax.swing.JButton seat13;
    private javax.swing.JButton seat14;
    private javax.swing.JButton seat15;
    private javax.swing.JButton seat16;
    private javax.swing.JButton seat17;
    private javax.swing.JButton seat18;
    private javax.swing.JButton seat19;
    private javax.swing.JButton seat2;
    private javax.swing.JButton seat20;
    private javax.swing.JButton seat21;
    private javax.swing.JButton seat22;
    private javax.swing.JButton seat23;
    private javax.swing.JButton seat24;
    private javax.swing.JButton seat25;
    private javax.swing.JButton seat26;
    private javax.swing.JButton seat27;
    private javax.swing.JButton seat28;
    private javax.swing.JButton seat29;
    private javax.swing.JButton seat3;
    private javax.swing.JButton seat30;
    private javax.swing.JButton seat31;
    private javax.swing.JButton seat32;
    private javax.swing.JButton seat33;
    private javax.swing.JButton seat34;
    private javax.swing.JButton seat35;
    private javax.swing.JButton seat36;
    private javax.swing.JButton seat37;
    private javax.swing.JButton seat38;
    private javax.swing.JButton seat39;
    private javax.swing.JButton seat4;
    private javax.swing.JButton seat40;
    private javax.swing.JButton seat41;
    private javax.swing.JButton seat42;
    private javax.swing.JButton seat43;
    private javax.swing.JButton seat44;
    private javax.swing.JButton seat45;
    private javax.swing.JButton seat46;
    private javax.swing.JButton seat47;
    private javax.swing.JButton seat5;
    private javax.swing.JButton seat6;
    private javax.swing.JButton seat7;
    private javax.swing.JButton seat8;
    private javax.swing.JButton seat9;
    private javax.swing.JTextField tfCustomerName;
    private javax.swing.JTextField tfcustomerSurname;
    private javax.swing.JTextField tfcustomerTel;
    private javax.swing.JButton ticketCencel;
    // End of variables declaration//GEN-END:variables
}
