/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
* FireLord 0.4
* Copyright (C) 2011 W4rGo , Francisco Ruiz Valdes <franrv@gmail.com>
*   
* This program is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 2 of the License, or
* (at your option) any later version.
*
* This program is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
* GNU General Public License for more details.
*
* You should have received a copy of the GNU General Public License
* along with this program. If not, see <http://www.gnu.org/licenses/>.
*/


package IceLord;

import IceLord.tools.Scheduler;
import IceLord.perks.IceStep;
import IceLord.tools.Dbg;
import IceLord.tools.IcePerm;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.event.Event;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author franrv
 *

 */
public class IceLord extends JavaPlugin{
    private String name = "[IceLord]";
    private String version = "0.1.1";
    public static final Logger log = Logger.getLogger("Minecraft");
    private Permission perm;
    //public final TrashBufferThread trash = new TrashBufferThread();
    private Scheduler scheduler=new Scheduler(this);;
    
    
    
    
    
    public void onDisable() {
            log.info(name + " version " + version + " disabled");
    }

    private boolean setupVault() {
        
        Plugin test = this.getServer().getPluginManager().getPlugin("Vault");
        
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            perm = permissionProvider.getProvider();
        }
        return (perm != null);
        

      }
  
    private void setupBukkitPerm() {
        IcePerm.setPermissions(true);
    }
    
    //Java is like a beautifull woman. Beautifull but you have to understand it.
    @Override
    public void onEnable() {   
        try {
            Config.loadConfig(this.getDataFolder());
            if(setupVault()) {
                System.out.println("[Icelord] Valut is enabled, Using vault!");
                
                IcePerm.setPermVault(perm);

            } else {
                setupBukkitPerm();
                System.out.println("[Icelord] You should use vault...");
            }
        } catch (IOException ex) {
            Logger.getLogger(IceLord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        //System.out.println("QUE PASA ?");
        //Dbg.p("LO INTENTAMOS FERVIENTEMENTE!!!!!!!!!!!!!!!!!!!!!!!!!");
        scheduler = new Scheduler(this);
        
        new IceStep(this);
        //trash.start();
    }

    public Scheduler getScheduler() {
        return scheduler;
    }

    public void setScheduler(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    
    
}
