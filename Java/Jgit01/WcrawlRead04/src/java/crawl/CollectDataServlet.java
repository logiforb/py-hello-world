/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package crawl;

import data.DAL;
import data.PsqlDALImpl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ini4j.Wini;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Kantaus
 */
public class CollectDataServlet extends HttpServlet {

    private static final transient Logger LOG = LoggerFactory.getLogger(CollectDataServlet.class);
    
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
        
//        String data = "data1";
//        request.setAttribute("data", data);
        
        DAL dal = new PsqlDALImpl();
        List<IPInfoHeavy> ips = dal.main();
        
        IPInfoHeavy ip;
        int removedIPsCount = 0;
        for (int i = ips.size() - 1; i >= 0; i--) {
            
            ip = ips.get(i);
            String source = ip.getSource();
            
            if (source != null) {
                Document sourceParsed = Jsoup.parse(source);
                String title = sourceParsed.title();
                
                if (title.isEmpty()) {
                    ips.remove(i);
                    removedIPsCount++;
                    
                } else {
                    ip.setTitle(title);
                }
            }
        }
        
        ////<editor-fold defaultstate="collapsed" desc="Test">
        //        List<String> strings = new ArrayList<String>();
        //        strings.add("D");
        //        strings.add("E");
        //        strings.add("A");
        //        strings.add("D");
        //        strings.add("B");
        //        strings.add("F");
        //        request.setAttribute("data", strings);
        //</editor-fold>
        
        request.setAttribute("data", ips);
        request.setAttribute("removedIPsCount", removedIPsCount);
        
        getServletContext().getRequestDispatcher("/dataview.jsp").forward(request, response);
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
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
