/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package IceLord;

import java.util.ArrayList;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

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

public class PlayerChecks {

    private static final String armorPerm = "icelord.armor";
    private static final String bootsPerm = "icelord.boots";
    private static final String iceStepPerm = "icelord.boots.icestep";
    private static final String overFluidsPerm = "icelord.boots.overfluids";
    private static final String fallDamage = "icelord.boots.falldamage";
    private static final String swordPerm = "icelord.sword";
    private static final String pickPerm = "icelord.pick";
    private static final String axePerm = "icelord.axe";
    private static final String shovelPerm = "icelord.shovel";
    private static final String helmetPerm = "icelord.helmet";
        private static final String underPerm = "icelord.helmet.underwater";
    private static final String adminPerm = "icelord.admins";
    
    
    private static boolean permissionsOn = false;

    private static ArrayList<Pig> burntPigs = new  ArrayList<Pig>();

    public static boolean hasIcelordArmor(Player player) {

            ItemStack helm = player.getInventory().getHelmet();
            ItemStack breast = player.getInventory().getChestplate();
            ItemStack legs = player.getInventory().getLeggings();

            if((helm.getTypeId() == Config.getHelmId())&&(breast.getTypeId() == Config.getChestId())&&(legs.getTypeId() == Config.getLegsId())) {
                return true;
            } else return false;
    }

        public static boolean allowedFallDmg(Player player) {
        if(permissionsOn) {
            if (player.hasPermission( fallDamage)) {
                return true;
            } else return false;
        } else return true;
    }
    public static boolean allowedArmor(Player player) {
            if(permissionsOn) {
                if (player.hasPermission(armorPerm)) {
                    return true;
                } else return false;
            } else return true;
    }
    public static boolean allowedSword(Player player) {
        if(permissionsOn) {
            if (player.hasPermission(swordPerm)) {
                return true;
            } else return false;
        } else return true;
    }
    public static boolean allowedPick(Player player) {
        if(permissionsOn) {
            if (player.hasPermission( pickPerm)) {
                return true;
            } else return false;
        } else return true;
    }
    public static boolean allowedAxe(Player player) {
        if(permissionsOn) {
            if (player.hasPermission( axePerm)) {
                return true;
            } else return false;
        } else return true;
    }
    public static boolean allowedShovel(Player player) {
        if(permissionsOn) {
            if (player.hasPermission( shovelPerm)) {
                return true;
            } else return false;
        } else return true;
    }
    public static boolean allowedBoots(Player player) {
        if(permissionsOn) {
            if (player.hasPermission( bootsPerm)) {
                return true;
            } else return false;
        } else return true;
    }
    public static boolean allowedIceStep(Player player) {
        if(permissionsOn) {
            if (player.hasPermission( iceStepPerm)) {
                return true;
            } else return false;
        } else return true;
    }
    public static boolean allowedOverFluids(Player player) {
        if(permissionsOn) {
            if (player.hasPermission(overFluidsPerm)) {
                return true;
            } else return false;
        } else return true;
    }
        public static boolean allowedUnderwater(Player player) {
        if(permissionsOn) {
            if (player.hasPermission(underPerm)) {
                return true;
            } else return false;
        } else return true;
    }
    public static boolean allowedHelmet(Player player) {
        if(permissionsOn) {
            if (player.hasPermission( helmetPerm)) {
                return true;
            } else return false;
        } else return true;
    }

    public static boolean isAdmin(Player player) {
        if(permissionsOn) {
            if (player.hasPermission(adminPerm)) {
                return true;
            } else return false;
        } else if(player.isOp()) {
            return true;
        } else return false;
    }
    public static boolean hasIcelordSword(Player player) {
        return ((player.getItemInHand().getTypeId() == Config.getAxeId()) ||(player.getItemInHand().getTypeId() == Config.getPickId()) || (player.getItemInHand().getTypeId() == Config.getShovelId()) || (player.getItemInHand().getTypeId() == Config.getSwordId()));
    }
    public static boolean hasIcelordHelmet(Player player) {
        return player.getInventory().getHelmet().getTypeId() == Config.getHelmId();
    }
    public static boolean hasIcelordBoots(Player player) {
        return player.getInventory().getBoots().getTypeId() == Config.getBootsId();
    }
    public static void setPermissions(boolean value) {
        permissionsOn=value;
    }

    public static boolean pigBurnt(Pig pig) {
        if( burntPigs.contains(pig)) {
            burntPigs.remove(pig);
            return true;
        } else return false;
    }
    public static void burnPig(Pig pig) {
        if(!burntPigs.contains(pig)) burntPigs.add(pig);
    }

    public static boolean playerSetIceOnHit(Player player) {
        return ((PlayerChecks.allowedSword(player)&&Config.isSword())
             || (PlayerChecks.allowedPick(player)&&Config.isPick())
             || (PlayerChecks.allowedAxe(player)&&Config.isAxe())
             || (PlayerChecks.allowedShovel(player)&&Config.isShovel()));
    }
    
    public static boolean checkLuck() {
        double luck =  Math.random()*100;
        if(Config.getPercentage() >= luck) {
            return true;
        } else return false;
    } 
    
    //USABLES
    public static boolean canStep(Player player) {
        return hasIcelordBoots(player)&&allowedBoots(player)&&allowedIceStep(player)&&Config.isStep();
    }
    public static boolean canNegateFall(Player player) {
        return hasIcelordBoots(player)&&allowedBoots(player)&&allowedFallDmg(player)&&Config.isFallDmg();
        
    }
    public static boolean canUnderwater(Player player) {
        return hasIcelordHelmet(player)&&allowedHelmet(player)&&allowedUnderwater(player)&&Config.isUnderWater();
    }
    public static boolean canElementalDamage(Player player) {
        return hasIcelordSword(player)&&allowedSword(player)&&Config.isSword();
    }
//    public static boolean wasBurnt() {
//        if(lavaTicker > 0) {
//            return true;
//            
//        } else return false;
//    }
}
