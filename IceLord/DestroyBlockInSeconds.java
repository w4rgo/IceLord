/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IceLord;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Material;
import org.bukkit.block.Block;

/**
 *
 * @author Fran
 */
class DestroyBlockInSeconds extends Thread {
    
    private Block block;
    private int sec ;
    
   public DestroyBlockInSeconds (Block block, int sec) { // Constructor no siempre necesario
     this.block = block;
     this.sec = sec;
   }
    @Override
   public void run() { try {
            // Sobrecargando al metodo run
        java.lang.Thread.sleep(sec*1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(DestroyBlockInSeconds.class.getName()).log(Level.SEVERE, null, ex);
        }
   
   
        
       block.setType(Material.AIR);
       
   }
}
    