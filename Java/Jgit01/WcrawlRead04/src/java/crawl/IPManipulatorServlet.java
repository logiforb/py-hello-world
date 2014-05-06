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
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.ini4j.Wini;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Kantaus
 */
public class IPManipulatorServlet extends HttpServlet {

    private static final transient Logger LOG = LoggerFactory.getLogger(IPManipulatorServlet.class);
    
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
        
//        testProcessing(response, request);
        
        String id = request.getParameter("id");
        LOG.debug("id = " + id);
        if (id != null) {
            
            // @todo DAL factory
            DAL dal = new PsqlDALImpl();
            String source = null;
            try {
                source = dal.getSource(Integer.parseInt(id));
            } catch (Exception dalEx) {
                logErr(dalEx);
                
                // @todo better ex. handling
                return;
            }
            
            if (source == null) {
                throw new IllegalStateException("Source must not be null");
            };
            
            String sharedPath = getSharedPath();
            if (sharedPath == null) {
                throw new FileNotFoundException("INI file needed");
            }
            
            String fname = sharedPath + File.separator + "crawled.html";
            
            PrintWriter outsh = null;
            try {
                outsh = new PrintWriter(fname);
                outsh.println(source);
                LOG.info("Wrote [" + source.length() + "] to " + fname);
            } catch (Exception e) {
                logErr(e);
            } finally {
                try {
                    if (outsh != null) {
                        outsh.close();
                    }
                } catch (Exception e) {
                    logErr(e);
                }
            }
        }
    }
    
    private void logErr(Exception ex) {
        LOG.error(ex.getMessage());
    }
    
    // @todo save to cookie
    private String getSharedPath() {
//        LOG.info("Started testing ini");
        try {
            String iniPath = getServletContext().getRealPath("/WEB-INF/crawlread.ini");
            LOG.debug("Ini path = " + iniPath);
            Wini ini = new Wini(new File(iniPath));
            String sharedPath = ini.get("path", "shared", String.class);
            LOG.debug("Shared path = " + sharedPath);

            return sharedPath;

        } catch (Exception ex) {
            LOG.error(ex.getMessage());

            return null;
        }
//        LOG.info("Ended testing ini");
    }

    private void testProcessing(HttpServletResponse response, HttpServletRequest request) throws IOException {
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet IPManipulatorrServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet IPManipulatorrServlet at " + request.getContextPath() + "</h1>");
            String id = request.getParameter("id");
            LOG.info("IPManipulatorServlet accessed, id = " + id);
            out.println("<h2>" + id + "</h2>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
