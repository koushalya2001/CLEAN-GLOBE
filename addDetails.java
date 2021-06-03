/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import useful.displayeventdetails;

/**
 *
 * @author ssubb
 */
@WebServlet(urlPatterns = {"/addDetails"})
@MultipartConfig
public class addDetails extends HttpServlet {
   private static String getValue(Part part) throws IOException{

BufferedReader reader = new BufferedReader(new InputStreamReader (part.getInputStream(),"UTF-8"));

StringBuilder value = new StringBuilder(); 
char[] buffer = new char[1024];

for (int length = 8; (length = reader.read(buffer)) > 0;) { 
    value.append(buffer, 0, length);
}
return value.toString();
       } 

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addDetails</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addDetails at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    //@Override
    @EJB
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String name=getValue(request.getPart("name"));
        String area=getValue(request.getPart("area"));
        String address=getValue(request.getPart("address"));
        String description=getValue(request.getPart("event"));
        System.out.println(""+ name +area+address);
        //String event=request.getParameter("event");
        //String item=request.getParameter("item");
        int maxpart=Integer.parseInt(getValue(request.getPart("maxpart")));
        int minpart=Integer.parseInt(getValue(request.getPart("minpart")));
        System.out.println(""+minpart);
        //int minage=Integer.parseInt(getValue(request.getPart("mini")));
//        int maxage=Integer.parseInt(getValue(request.getPart("maxi")));
        int fee=Integer.parseInt(getValue(request.getPart("fee")));
        int pincode=Integer.parseInt(getValue(request.getPart("pincode")));
        System.out.println(maxpart);
        PrintWriter out=response.getWriter();
        displayeventdetails e=new displayeventdetails() ;
        e.setFee(fee);
        e.setMin(minpart);
        e.setMax(maxpart);
        e.calcMaxrevenue();
        e.calcMinrevenue();
        e.calccommission();
        if(e.validatemax()==1)
        { 
         out.println("ALL DETAILS ARE VALID");
        }
        //processRequest(request, response);
        out.println("<body style='background-color:powderblue;'>");
        out.println("<fieldset>");
        out.println("<legend>THE GIST OF DETAILS OF EVENT </legend>");
        out.println("Title :"+name);
        out.println("<br/>");
        out.println("Description :"+description);
        out.println("<br/>");
        out.println("venue:-"+address);
        out.println("<br/>");
        out.println("fee:-"+fee);
        out.println("<br/>");
        out.println("maximum participants:-"+maxpart);
        out.println("<br/>");
        out.println("minimum participants:-"+minpart);
        out.println("<br/>");
       // out.println("aadhar proof:-<br/><img src='C:\\Users\\ssubb\\OneDrive\\Documents\\NetBeansProjects\\shopkeeperejb\\filesIMG_20210402_223813_697_2.jpg'>");
        out.println("<br/>");
        out.println("maximum revenue that can be achieved (CALCULATED USING EJB) is: "+ e.getMaxfee()+"\n");
        out.println("<br/>");
        out.println("minimum revenue that can be achieved (CALCULATED USING EJB)is: "+ e.getMinfee()+"\n");
        out.println("<br/>");
        out.println("maximum commision that can be provided to me (CALCULATED USING EJB)is: "+ e.getCommision()+"\n");
        out.println("</fieldset>");
        out.println("<input type ='button' value='cancel' name='cancel'/>");
        out.println("<input type ='button' value='proceed' name='proceed'/>");
          out.println("</fieldset>");
        out.println("</body>");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
