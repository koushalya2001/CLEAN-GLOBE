/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package registration;
import java.util.UUID;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
@ManagedBean
@RequestScoped
/**
 *
 * @author ssubb
 */
public class shopkeeperdb {
    private int id;
    private int _phno;
    private String _name;
    private String _email;
    private String _password;
    private String _address;
    private String _message;
    private java.util.Date _date;

    public java.util.Date getDate() {
        return _date;
    }

    public void setDate(java.util.Date _date) {
        this._date = _date;
    }

    public ArrayList getMsgList() {
        return msgList;
    }

    public void setMsgList(ArrayList msgList) {
        this.msgList = msgList;
    }
    public ArrayList msgList;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return _message;
    }

    public void setMessage(String _message) {
        this._message = _message;
    }
    public void setPhno(int _phno) {
        this._phno = _phno;
    }

    public void setName(String _name) {
        this._name = _name;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public void setAddress(String _address) {
        this._address = _address;
    }

    public int getPhno() {
        return _phno;
    }

    public String getName() {
        return _name;
    }

    public String getEmail() {
        return _email;
    }

    public String getPassword() {
        return _password;
    }

    public String getAddress() {
        return _address;
    }
    public String addShopkeeper() throws SQLException{
        String om="99e99";
        try {    
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/stakeholders","koushi","Subbu2177");
       //#Statement stmt=con.createStatement();
        //stmt.executeUpdate("insert into shopkeeper values ('"+_name+"','"+_phno+"','"+_email+"','"+_address+"','"+_password+"'+'")"');
        PreparedStatement stmt;  
        stmt = con.prepareStatement("insert into shopkeeper values(?,?,?,?,?,?,?,?)");
stmt.setInt(1, this.getId());
stmt.setString(2, this.getName());  
stmt.setInt(3, this.getPhno());
stmt.setString(5, this.getEmail());  
stmt.setString(4, this.getAddress()); 
stmt.setString(6, this.getPassword());  
stmt.setString(7, this.getMessage());
java.sql.Date sqlDate=new java.sql.Date(this.getDate().getTime());
stmt.setDate(8, sqlDate);  
stmt.executeUpdate();  
con.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(shopkeeperdb.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "shopkeeperresponse";
        
    }
    public ArrayList usersList(){  
try{  
msgList = new ArrayList();  
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/stakeholders","koushi","Subbu2177");
Statement stmt=con.createStatement();
ResultSet rs=stmt.executeQuery("select * from shopkeeper");    
while(rs.next()){  
shopkeeperdb user = new shopkeeperdb();  
user.setId(rs.getInt("id")); 
user.setPhno(rs.getInt("phone"));
user.setMessage(rs.getString("message"));  
user.setName(rs.getString("name"));  
user.setEmail(rs.getString("email"));  
user.setDate(rs.getDate("date"));   
user.setAddress(rs.getString("address"));
msgList.add(user);  
}  
con.close();          
}catch(Exception e){  
System.out.println(e);  
}  
return msgList;  
}
    
}
