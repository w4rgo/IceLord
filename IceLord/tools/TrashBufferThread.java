package IceLord.tools;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import IceLord.BlockLog;
import IceLord.tools.Scheduler;
import IceLord.tools.Dbg;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.minecraft.server.Block;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author Fran
 */
public class TrashBufferThread extends Thread {

    //List list = Collections.synchronizedList(new ArrayList(...));
    //List list =Collections.synchronizedList(new ArrayList());
    //private BlockList blocks = new BlockList();
    boolean trigger = true;
    private Scheduler s;

    public TrashBufferThread(Scheduler s) {
        super();
        this.s = s;
    }

//    TrashBufferThread(BlockList blocks) {
//        this.blocks = blocks;
//    }

    @Override
    public void run() {

        int decay = 4000;
        long time = System.currentTimeMillis();
        //Dbg.p("Repeticion de tarea: " + time);

            for (BlockLog block : new ArrayList<BlockLog>(s.getBlocks().getBlocks()) ) {
                if(decay < System.currentTimeMillis()-block.getTimePlaced()) {
                    if (block != null) {
                    try {
                        //Dbg.p("Decayed:"+ block.getTypeId() + "-" + block.getTypeId());
                        sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TrashBufferThread.class.getName()).log(Level.SEVERE, null, ex);
                    }
                        if(block.restore()) {
                            //synchronized(s.getBlocks().getBlocks()) {
                                s.removeBlock(block);    
                            //}
                        }
                        


                    }
                }

            }


    }
}

