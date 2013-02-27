package IceLord.tools;

import IceLord.Config;

import java.util.HashMap;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ajax
 */
public class IcePlayer {

    private IcePerm perms;
    private Player player;
    private Block lastBlock;
    private static HashMap<Integer, Block> lastBlocks = new HashMap<Integer, Block>();

    public IcePlayer(Player player) {
        this.player = player;
        perms = new IcePerm(this);

    }

    public Player getPlayer() {
        return player;
    }

    public IcePerm getPerm() {
        return perms;
    }

    public boolean hasArmor() {
        return hasHelmet() && hasChest() && hasLegs();
    }

    public boolean hasSword() {
        if (this.player.getInventory().getItemInHand() != null) {
            return ((this.player.getItemInHand().getTypeId() == Config.getAxeId()) || (this.player.getItemInHand().getTypeId() == Config.getPickId()) || (this.player.getItemInHand().getTypeId() == Config.getShovelId()) || (this.player.getItemInHand().getTypeId() == Config.getSwordId()));
        } else {
            return false;
        }
    }

    public boolean hasHelmet() {
        if (this.player.getInventory().getHelmet() != null) {
            return this.player.getInventory().getHelmet().getTypeId() == Config.getHelmId();
        } else {
            return false;
        }
    }

    public boolean hasChest() {
        if (this.player.getInventory().getChestplate() != null) {
            return this.player.getInventory().getChestplate().getTypeId() == Config.getChestId();
        } else {
            return false;
        }
    }

    public boolean hasLegs() {
        if (this.player.getInventory().getLeggings() != null) {
            return this.player.getInventory().getLeggings().getTypeId() == Config.getLegsId();
        } else {
            return false;
        }
    }

    public boolean hasBoots() {
        if (this.player.getInventory().getBoots() != null) {
            return this.player.getInventory().getBoots().getTypeId() == Config.getBootsId();
        } else {
            return false;
        }
    }

    public boolean checkLuck() {
        double luck = Math.random() * 100;
        if (Config.getPercentage() >= luck) {
            return true;
        } else {
            return false;
        }
    }

    public Block getLastBlock() {
        return this.lastBlock;
    }

    public void setLastBlock(Block block) {
        this.lastBlock = block;
    }
}
