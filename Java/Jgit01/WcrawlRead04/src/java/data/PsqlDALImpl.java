
package data;

import crawl.IPInfoHeavy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PsqlDALImpl implements DAL {

    private static final transient Logger LOG = LoggerFactory.getLogger(PsqlDALImpl.class);

    private final String URL = TrolloloConnectionStrings.URL;

    private final String QUERY 
            = "SELECT ip_info_id, ip, status_code, status_message, headers, source, \n"
            + "       exception_message, last_update, job_id\n"
            + "  FROM ip_info\n"
            + "  WHERE status_code = 200\n"
            + "  --LIMIT 10\n"
            + "  ;"
            ;
    
    // @todo stored procedure
    private final String QUERY_GET_SOURCE_INCOMPLETE = "SELECT source FROM ip_info WHERE ip_info_id = ";

    @Override
    public List<IPInfoHeavy> main() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            logErr(ex);

            return new ArrayList<IPInfoHeavy>(0);
        }

        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(URL);
            stat = con.createStatement();
            rs = stat.executeQuery(QUERY);
            List<IPInfoHeavy> ips = new ArrayList<IPInfoHeavy>();
            int index = 1;
            IPInfoHeavy ip;
            while (rs.next()) {
                
                ip = new IPInfoHeavy();
                
                ip.setId(rs.getInt(index));
                index++;
                ip.setIp(rs.getString(index));
                index++;
                ip.setStatusCode(rs.getInt(index));
                index++;
                ip.setStatusMessage(rs.getString(index));
                index++;
                ip.setHeaders(rs.getString(index));
                index++;
                ip.setSource(rs.getString(index));
                index++;
                ip.setExceptionMessage(rs.getString(index));
                index++;
                ip.setLastUpdate(rs.getTimestamp(index));
                index++;
                ip.setJobId(rs.getInt(index));
                index = 1;
                
                ips.add(ip);
                
                //<editor-fold defaultstate="collapsed" desc="Test">
                //                pln(rs.getInt(index)); // id
                //                index++;
                //                pln(rs.getString(index)); // ip
                //                index++;
                //                pln(rs.getInt(index)); // status code
                //                index++;
                //                pln(rs.getString(index)); // status message
                //                index++;
                //                pln(rs.getString(index)); // headers
                //                index++;
                //                pln(rs.getString(index)); // source
                //                index++;
                ////                pln(rs.getString(index)); // exception message
                //                index++;
                ////                pln(rs.getString(index)); // last update
                //                pln(rs.getTimestamp(index)); // last update
                //                index++;
                //                pln(rs.getInt(index)); // job id
                //                index = 1;
                //</editor-fold>
            }
            
            return ips;
            
        } catch (Exception ex) {
            logErr(ex);
            
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (stat != null) {
                    stat.close();
                }
                if (rs != null) {
                    rs.close();
                }
                
            } catch (Exception ex) {
                logErr(ex);
            }
        }
        
        return new ArrayList<IPInfoHeavy>(0);
    }

    private void logErr(Exception ex) {
        LOG.error(ex.getMessage());
    }
    
    private void pln(Object o) {
        LOG.info(o.toString());
    }

    /**
     * SQL exception protected by casting query to int (BUT not in this method, its the callers job). TODO: stored procedure
     * @param id
     * @return source or null
     */
    @Override
    public String getSource(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            logErr(ex);

            return null;
        }

        Connection con = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            con = DriverManager.getConnection(URL);
            stat = con.createStatement();
            rs = stat.executeQuery(QUERY_GET_SOURCE_INCOMPLETE + id);
            while (rs.next()) {
                
                return rs.getString(1);
            }                
            
            return null;
            
        } catch (Exception ex) {
            logErr(ex);
            
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (stat != null) {
                    stat.close();
                }
                if (rs != null) {
                    rs.close();
                }
                
            } catch (Exception ex) {
                logErr(ex);
            }
        }
        
        return null;
    }

}
