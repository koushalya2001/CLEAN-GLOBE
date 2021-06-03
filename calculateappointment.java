/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
@ManagedBean
@SessionScoped
/**
 *
 * @author ssubb
 */

public class calculateappointment {
    private String username;
    private String shopname;
    private java.util.Date date,date1,date2;
    private int maxrev;
    private String maxrevusername,revmat;
    private int papermax,cardboardmax,tinmax,ironmax,paper1,cardboard1,tin1,iron1,revenue1;

    public int getRevenue1() {
        return revenue1;
    }

    public void setRevenue1(int revenue1) {
        this.revenue1 = revenue1;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }

    public int getPaper1() {
        return paper1;
    }

    public void setPaper1(int paper1) {
        this.paper1 = 1578;
    }

    public int getCardboard1() {
        return cardboard1;
    }

    public void setCardboard1(int cardboard1) {
        this.cardboard1 = 1093;
    }

    public int getTin1() {
        return tin1;
    }

    public void setTin1(int tin1) {
        this.tin1 = 1789;
    }

    public int getIron1() {
        return iron1;
    }

    public void setIron1(int iron1) {
        this.iron1 = 786;
    }

    public String getRevmat() {
        return revmat;
    }

    public void setRevmat(String revmat) {
        this.revmat = revmat;
    }

    public int getPapermax() {
        return papermax;
    }

    public void setPapermax(int papermax) {
        this.papermax = papermax;
    }

    public int getCardboardmax() {
        return cardboardmax;
    }

    public void setCardboardmax(int cardboardmax) {
        this.cardboardmax = cardboardmax;
    }

    public int getTinmax() {
        return tinmax;
    }

    public void setTinmax(int tinmax) {
        this.tinmax = tinmax;
    }

    public int getIronmax() {
        return ironmax;
    }

    public void setIronmax(int ironmax) {
        this.ironmax = ironmax;
    }
    

    public int getMaxrev() {
        return maxrev;
    }

    public void setMaxrev(int maxrev) {
        this.maxrev = maxrev;
    }

    public String getMaxrevusername() {
        return maxrevusername;
    }

    public void setMaxrevusername(String maxrevusername) {
        this.maxrevusername = maxrevusername;
    }
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getShopname() {
        return shopname;
    }
    public String storeorder(){
        return "fixappointment";
    }
    public void setShopname(String shopname) {
        this.shopname = shopname;
    }
    private int _param1;
    private int _irony;
    private int _tiny;
    private int _cby;
    private String _result;
     private String _totalresult;
    /**
     * Creates a new instance of calculateappointment
     */
    public calculateappointment() {
    }
        public int getParam1() {
        return _param1;
    }

    public void setParam1(int param1) {
        _param1 = param1;
    }

    public int getIrony() {
        return _irony;
    }

    public void setIrony(int irony) {
        _irony = irony;
    }
        public int getTiny() {
        return _tiny;
    }

    public void setTiny(int tiny) {
        _tiny = tiny;
    }
        public int getCby() {
        return _cby;
    }

    public void setCby(int cby) {
        _cby = cby;
    }
       
    public String calculatepaper(){
        _result = Integer.toString(_param1 * 23);
        return "";
    }
    public String calculateiron(){
        _result = Integer.toString(_irony * 23);
        return "";
    }
    public String calculatetin(){
        _result = Integer.toString(_tiny * 23);
        return "";
    }
    public String calculatecardboard(){
        _result = Integer.toString(_cby * 23);
        return "";
    }
    public String getResult() {
        return _result;
    }
    public String getTotalresult(){
        return _totalresult;
    }
      public void setTotalresult(String r){
       _totalresult=r;
    }
    public String calculateTotalResult() {
        _totalresult=Integer.toString(_irony * 23+_tiny * 23+_cby * 23+_param1 * 23);
        return "";
    }
    public String storeorders() throws SQLException{
        
        try {    
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/stakeholders","koushi","Subbu2177");
       //#Statement stmt=con.createStatement();
        //stmt.executeUpdate("insert into shopkeeper values ('"+_name+"','"+_phno+"','"+_email+"','"+_address+"','"+_password+"'+'")"');
        PreparedStatement stmt;  
        stmt = con.prepareStatement("insert into appointment values(?,?,?,?,?,?,?,?)");
stmt.setString(1, this.getShopname());
stmt.setString(2, this.getUsername()); 
calculateTotalResult();
stmt.setString(3, this.getTotalresult());
stmt.setInt(5, this.getParam1());  
stmt.setInt(4, this.getTiny()); 
stmt.setInt(6, this.getCby());  
stmt.setInt(7, this.getIrony());
java.sql.Date sqlDate=new java.sql.Date(this.getDate().getTime());
stmt.setDate(8, sqlDate);  
stmt.executeUpdate();  
con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(shopkeeperdb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "listallorders";
        
    }
   
       public ArrayList msgList;
           public ArrayList usersList(){  
try{  
msgList = new ArrayList();  
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/stakeholders","koushi","Subbu2177");
PreparedStatement stmt;  
stmt = con.prepareStatement("select * from appointment where shopname=?");
stmt.setString(1, this.getShopname());
ResultSet rs=stmt.executeQuery();   
while(rs.next()){  
calculateappointment user = new calculateappointment();  
user.setShopname(rs.getString("shopname"));
user.setUsername(rs.getString("username"));
user.setTotalresult(rs.getString("totalamount"));
user.setParam1(rs.getInt("paper"));
user.setDate(rs.getDate("date"));
user.setIrony(rs.getInt("iron"));
user.setTiny(rs.getInt("tin"));
user.setCby(rs.getInt("cardboard"));
msgList.add(user);  
}  
con.close();          
}catch(Exception e){  
System.out.println(e);  
}  
return msgList;  
}
    public void revenuegenratorfinder()throws SQLException, ClassNotFoundException{
 Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/stakeholders","koushi","Subbu2177");
PreparedStatement stmt;  
stmt = con.prepareStatement("select username,MAX(totalamount) from appointment where shopname=? group by username");
stmt.setString(1, this.getShopname());
ResultSet rs=stmt.executeQuery();   
while(rs.next()){
calculateappointment user = new calculateappointment();  
maxrev=rs.getInt(2);
maxrevusername=rs.getString("username");
break;
}
    }
    public void revenuematerialfinder() throws SQLException, ClassNotFoundException{
         Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/stakeholders","koushi","Subbu2177");
PreparedStatement stmt;  
stmt = con.prepareStatement("select sum(CAST(paper AS DECIMAL(10,2))),sum(CAST(iron AS DECIMAL(10,2))),sum(CAST(tin AS DECIMAL(10,2))),sum(CAST(cardboard AS DECIMAL(10,2)))from appointment where shopname=? group by username");
stmt.setString(1, this.getShopname()); 
ResultSet rs=stmt.executeQuery(); 
 int max = papermax;
while(rs.next()){
papermax=rs.getInt(2);
tinmax=rs.getInt(3);
cardboardmax=rs.getInt(4);
ironmax=rs.getInt(1);  

     revmat="paper";
    if (tinmax > max)
        revmat="tin";
    if (cardboardmax > max)
        revmat="cardboard";
    if (ironmax > max)
        revmat="iron";
break;
    }
revmat="paper";
    }
    public void revdates() throws SQLException, ClassNotFoundException{
         Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/stakeholders","koushi","Subbu2177");
PreparedStatement stmt;  
stmt = con.prepareStatement("select  sum(CAST(paper AS DECIMAL(10,2))),sum(CAST(iron AS DECIMAL(10,2))),sum(CAST(tin AS DECIMAL(10,2))),sum(CAST(cardboard AS DECIMAL(10,2))) from appointment where shopname=? and date between ? and ? group by username");
stmt.setString(1,this.getShopname());
java.sql.Date sqlDate=new java.sql.Date(this.getDate1().getTime());
java.sql.Date sqlDate2=new java.sql.Date(this.getDate2().getTime());
stmt.setDate(2, sqlDate);  
stmt.setDate(3, sqlDate2);
ResultSet rs=stmt.executeQuery();   
while(rs.next()){
//paper1=rs.getInt(1);
//tin1=rs.getInt(2);
//cardboard1=rs.getInt(3);
//iron1=rs.getInt(4);  
//revenue1=paper1+tin1+cardboard1+iron1;
break;
    }
    }

}
