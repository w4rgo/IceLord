/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IceLord.perks;

import IceLord.BlockList;
import IceLord.BlockLog;
import IceLord.tools.IcePlayer;
import IceLord.BlocksChecks;
import IceLord.BlocksOper;
import IceLord.Config;
import IceLord.IceLord;
import IceLord.tools.Dbg;
import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.plugin.Plugin;

/**
 *
 * @author Fran
 */
public class IceStep implements Perk, CommandExecutor {
//Hacer que de vez en cuando te salga un bloque de hielo en el inventario cuando piques.
    //Usar lo del bloque para desactivar las botas.

    private IceLord father;
    private ArrayList<Player> activatedPlayers = new ArrayList<Player>();    
    
    public IceStep(IceLord firelord) {
        //if(active()) {
        father = firelord;
        father.getServer().getPluginManager().registerEvents(this, father);
        father.getScheduler().restoreBlocksRepeat();
        father.getCommand("icestep").setExecutor(this);
        //}
    }
    
    public void activate() {
        father.getServer().getPluginManager().registerEvents(this, father);
    }
    
    public boolean active() {
        return Config.isStep();
    }
    
    public boolean allowed(Player player) {
        
        IcePlayer fp = new IcePlayer(player);

        //Have Firelord Bootes.
        boolean hasBoots = fp.hasBoots();
        //Have Permissions
        boolean allowedPerk = fp.getPerm().allowedIceStep();
        //Has icestep activated himself
        
        
        return hasBoots && allowedPerk && active();
    }
    
    public boolean activatedIcestep(Player player) {
        
        if (this.activatedPlayers.contains(player)) {
            return true;
        } else {
            return false;
        }
        
        
    }

    public boolean allowedToFly(Player player) {
        IcePlayer fp = new IcePlayer(player);
        boolean hasBoots = fp.hasBoots();
        boolean allowedPerk = fp.getPerm().allowedIceStep();
        return hasBoots && allowedPerk && Config.getStepFly();
    }
    
    @EventHandler(priority = EventPriority.LOW)
    public void onPlayerMove(PlayerMoveEvent event) throws InterruptedException {





        //If the player is allowed to do IceStep
        if (allowed(event.getPlayer()) && activatedIcestep(event.getPlayer())) {
            //If The block where the player is walking to is the same as his location,
            //Calculate the possible next blocks in the future.
            
            if (event.getPlayer().isSneaking()) iceStep(event,false);
            else iceStep(event,true);
//            if (from.equals(to)) {
//                BlockList nextBlocks = BlocksOper.calculateNextBlocks(event.getPlayer());
//
//                for (BlockLog block : nextBlocks.getBlocks()) {
//                    Block nextBlock = block.getLoc().getBlock().getRelative(BlockFace.DOWN);
//                    playerSetBlock(event.getPlayer(), nextBlock, Material.ICE);
//                }
//            } else {//If the block "to" is another one, set it on ice faster.
//                playerSetBlock(event.getPlayer(), to, Material.ICE);
//            }
        }
    }
//Direction false=down,true = up

    public void iceStep(PlayerMoveEvent event, boolean direction) {
        Block from = event.getFrom().getBlock().getRelative(BlockFace.DOWN);
        Block to = event.getTo().getBlock().getRelative(BlockFace.DOWN);
        
        if (direction) {
            //UP
            if (from.equals(to)) {
                BlockList nextBlocks = BlocksOper.calculateNextBlocks(event.getPlayer());
                
                for (BlockLog block : nextBlocks.getBlocks()) {
                    Block nextBlock = block.getLoc().getBlock().getRelative(BlockFace.DOWN);
                    playerSetBlock(event.getPlayer(), nextBlock, Material.ICE);
                }
            } else {//If the block "to" is another one, set it on ice faster.
                playerSetBlock(event.getPlayer(), to, Material.ICE);
            }
        } else {
            if (from.equals(to)) {
                BlockList nextBlocks = BlocksOper.calculateNextBlocks(event.getPlayer());
                
                for (BlockLog block : nextBlocks.getBlocks()) {
                    Block nextBlock = block.getLoc().getBlock().getRelative(BlockFace.DOWN).getRelative(BlockFace.DOWN);
                    playerSetBlock(event.getPlayer(), nextBlock, Material.ICE);
                }
            } else {//If the block "to" is another one, set it on ice faster.
                playerSetBlock(event.getPlayer(), to.getRelative(BlockFace.DOWN), Material.ICE);
            }
        }
        //event.getPlayer().setSneaking(false);
    }
    
    @EventHandler(priority = EventPriority.HIGH)    
    public void onPlayerRightClick(PlayerInteractEvent event) {
        if( allowed( event.getPlayer() ) && activatedIcestep(event.getPlayer())) {
            event.getPlayer().setSneaking(true);
        }
        
    }
    
    private void playerSetBlock(Player player, Block block, Material mat) {
        
        
        if (allowedToFly(player)) {
            setBlock(player, block, mat);
        } else {
            if (((block.getType() == Material.STATIONARY_WATER) && (block.getRelative(BlockFace.UP).getType() == Material.AIR))
                    || ((block.getType() == Material.WATER) && (block.getRelative(BlockFace.UP).getType() == Material.AIR))) {
                setBlock(player, block, mat);
            }
        }
        
    }
    
    private void setBlock(Player player, Block block, Material mat) {
        //  
        //If block down is air or water ?
        //
        if (isWater(block) || (block.getType() == Material.AIR)) {
            // if ( (block.getType() != mat) && (  (block.getRelative(BlockFace.UP).getType()==Material.AIR) || (block.getType()==Material.WATER) )) {
            BlockLog nextBlockLog = new BlockLog(player, block);
            //Dbg.p("Bloque despues de bloqueloguearo: " + nextBlockLog.getTypeId());
            father.getScheduler().addBlock(nextBlockLog);
            block.setType(mat);
            //Dbg.p("BlockLog despues de cambiar el bloque normal : " + nextBlockLog.getTypeId());
        }
    }
    
    private boolean isWater(Block block) {
        return ((block.getType() == Material.WATER) || (block.getType() == Material.STATIONARY_WATER));
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = null;
        if (sender instanceof Player) {
            player = (Player) sender;
        }
        
        if (command.getName().equalsIgnoreCase("icestep")) {
            if (player == null) {
                sender.sendMessage("this command can only be run by a player");
            } else if (allowed(player)) {
                
                if (activatedPlayers.contains(player)) {
                    activatedPlayers.remove(player);
                    sender.sendMessage("Icestep deactivated.");
                } else {
                    activatedPlayers.add(player);
                    sender.sendMessage("Icestep Activated.");
                    sender.sendMessage("Right Click on ice block: Go down.");
                    sender.sendMessage("Press shift key once ice block: Go up.");
                }
            }
            return true;
        }
        return false;
    }
}
