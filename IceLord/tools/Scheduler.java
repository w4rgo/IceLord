/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IceLord.tools;

import IceLord.BlockList;
import IceLord.BlockLog;
import net.minecraft.server.Block;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Ajax
 */
public class Scheduler {
    
    private BlockList blocks = new BlockList();
    //private BlockList blocksToAir = new BlockList();
    private Plugin plugin;
    private int taskId;


    public Scheduler(Plugin plugin) {
        this.plugin = plugin;
    }

    public void restoreBlocksRepeat() {
        int timeToStart=  0;
        int timeToRepeat= 10;
         Dbg.p("RestoreBlocks");
         taskId=plugin.getServer().getScheduler().scheduleAsyncRepeatingTask(plugin, new TrashBufferThread(this), timeToStart , timeToRepeat);
        
    }

    
    public void cancelTask() {
         plugin.getServer().getScheduler().cancelTask(taskId);
    }
    public BlockList getBlocks() {
        return blocks;
    }
    
    public synchronized void addBlock(BlockLog block) {
        if(!blocks.getBlocks().contains(block))
        blocks.getBlocks().add(block);
        
    }
    public synchronized void addBlockToAir(BlockLog block) {
        if(!blocks.getBlocks().contains(block))
        blocks.getBlocks().add(block);
        
    }
    public  synchronized void removeBlockToAir(BlockLog block) {
        blocks.getBlocks().remove(block);
    }
    
    public synchronized void addBlocks(BlockList bks) {
        blocks.getBlocks().addAll(bks.getBlocks());
    }
    public synchronized void removeBlock(BlockLog block) {
        blocks.getBlocks().remove(block);
    }
}
