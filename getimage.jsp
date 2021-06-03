<%-- 
    Document   : getimage
    Created on : 11-Apr-2021, 7:01:25 pm
    Author     : ssubb
--%>

<%@page import="java.io.InputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <form action="getimage.jsp" name="event" enctype = "multipart/form-data">          
         <b>UPLOAD hotel image</b>
  <input type = "file" name = "file" size = "50" /><br/>
 <input type="submit" name="submit" value="submit"/>
       </form>  
        
    </body>
</html>
<%
try {HttpSession sessions=request.getSession(false);
    String phone="9056740458";//(String)sessions.getAttribute("user");
    out.write(phone);
String imgpath=request.getParameter("file");
out.write(imgpath);
Class.forName("org.apache.derby.jdbc.ClientDriver");
Connection con=DriverManager.getConnection("jdbc:derby://localhost:1527/stakeholders","koushi","Subbu2177");
PreparedStatement psmnt = null;
FileInputStream fis;
File image = new File(imgpath);
psmnt = con.prepareStatement("insert into hotelimage(hphone,imgdata)"+"values(?,?)");
fis = new FileInputStream(image); 
psmnt.setString(1, phone);
psmnt.setBinaryStream(2, (InputStream)fis, (int)(image.length()));
int flag= psmnt.executeUpdate();
out.print("hi"+flag);
if(flag>0)
    {
       out.print("saved image <img src='displayimage.jsp?pid=1001'>");%> <jsp:forward page="bookroom.jsp"></jsp:forward> <%
    }
    else
    {
        out.print("Error");

    }
}

catch (Exception e){
    out.print(e);
}%>
        