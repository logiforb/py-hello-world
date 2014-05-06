/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import crawl.IPInfoHeavy;
import java.util.List;

/**
 *
 * @author Kantaus
 */
public interface DAL {
    
    public List<IPInfoHeavy> main();
    
    public String getSource(int id);
}
