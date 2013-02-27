/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IceLord;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import sun.util.calendar.BaseCalendar.Date;

/**
 *
 * @author Ajax
 */
public class BlockLog {

    private World world;
    private Location loc;
    private int typeId;
    private long timePlaced;
    private Player player=null;
    
    
    
    public BlockLog(Block block) {
        loc =block.getLocation();
        typeId = block.getTypeId();
        world = block.getWorld();
        timePlaced = System.currentTimeMillis();
        
    }
    public BlockLog(Player player,Block block) {
        this.player = player;
        loc =block.getLocation();
        typeId = block.getTypeId();
        world = block.getWorld();
        timePlaced = System.currentTimeMillis();
        
    }
    
    public BlockLog(Location loc, int typeId) {
        this.loc = loc;
        this.typeId = typeId;
        this.world = loc.getWorld();
        timePlaced = System.currentTimeMillis();
    }

    public long getTimePlaced() {
        return timePlaced;
    }



    public Location getLoc() {
        return loc;
    }

    public void setLoc(Location loc) {
        this.loc = loc;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
    
    public synchronized boolean restore() {
        if(player!= null) {
             if(player.getLocation().distance(loc)>4) {
                 world.getBlockAt(loc).setTypeId(typeId);
                 return true;
             }
        } else {
            world.getBlockAt(loc).setTypeId(typeId);
            return true;
        }
        return false;
    }
    
    public void setType(Material material) {
        world.getBlockAt(loc).setType(material);
    }
    
}
