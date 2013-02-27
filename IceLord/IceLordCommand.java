package IceLord;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/**
 * IceLord 0.4
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
public class IceLordCommand implements CommandExecutor {

    public static final Logger log = Logger.getLogger("Minecraft");
    public static IceLord plugin = null;

    IceLordCommand(IceLord icelord) {
        plugin = icelord;
    }

    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
                String[] split =strings;
        Player player = (Player) cs;
        if (!PlayerChecks.isAdmin((Player) cs)) {
            return false;
        }

            if (split.length > 0) {
                if (split[0].equalsIgnoreCase("ecircle")) {
                    if (split.length > 1) {
                        String radius = split[1];
                        Block blockOn = player.getLocation().getBlock();
                        try {
                            //Config.setIceDuration(Integer.valueOf(fdur));
                            //BlocksOper.rasterCircle(blockOn.getLocation(), Integer.valueOf(radius),-1, player.getWorld() , Material.SNOW,true);
                            BlocksOper.createExpansiveCircle(blockOn.getLocation(), player.getWorld(), Material.SNOW, 4, Integer.valueOf(radius),Config.getExpansiveQuantum(),false);
                            player.sendMessage( ChatColor.RED +  "IceLord: Circle of radius " + radius + " s");
                        } catch (NumberFormatException e) {
                            player.sendMessage( ChatColor.RED +  "You have to select a numeric value.");
                        }
                    } else {
                        player.sendMessage( ChatColor.RED +  "USAGE: /fl|icelord seticedur [num]");
                    }
                }else if (split[0].equalsIgnoreCase("pradius")) {
                    if (split.length > 1) {
                        String radius = split[1];
                        //Block blockOn = player.getLocation().getBlock();
                        try {
                            Config.setPillarRadius(Integer.valueOf(radius));
                            //BlocksOper.rasterCircle(blockOn.getLocation(), Integer.valueOf(radius),-1, player.getWorld() , Material.SNOW,true);
                            //BlocksOper.createExpansiveCircle(blockOn.getLocation(), player.getWorld(), Material.SNOW, 4, Integer.valueOf(radius));
                            player.sendMessage( ChatColor.RED +  "IceLord: Radius of pilar is now " + radius + " s");
                        } catch (NumberFormatException e) {
                            player.sendMessage( ChatColor.RED +  "You have to select a numeric value.");
                        }
                    } else {
                        player.sendMessage( ChatColor.RED +  "USAGE: /fl|icelord seticedur [num]");
                    }
                }else if (split[0].equalsIgnoreCase("pheight")) {
                    if (split.length > 1) {
                        String radius = split[1];
                        //Block blockOn = player.getLocation().getBlock();
                        try {
                            Config.setPillarHeight(Integer.valueOf(radius));
                            //BlocksOper.rasterCircle(blockOn.getLocation(), Integer.valueOf(radius),-1, player.getWorld() , Material.SNOW,true);
                            //BlocksOper.createExpansiveCircle(blockOn.getLocation(), player.getWorld(), Material.SNOW, 4, Integer.valueOf(radius));
                            player.sendMessage( ChatColor.RED +  "IceLord: Height of pilar is now " + radius + " s");
                        } catch (NumberFormatException e) {
                            player.sendMessage( ChatColor.RED +  "You have to select a numeric value.");
                        }
                    } else {
                        player.sendMessage( ChatColor.RED +  "USAGE: /fl|icelord seticedur [num]");
                    }
                } else
                if (split[0].equalsIgnoreCase("circle")) {
                    if (split.length > 1) {
                        String radius = split[1];
                        Block blockOn = player.getLocation().getBlock();
                        try {
                            //Config.setIceDuration(Integer.valueOf(fdur));
                            BlocksOper.rasterCircle(blockOn.getLocation(), Integer.valueOf(radius),-1, player.getWorld() , Material.SNOW,true,false);
                    
                            player.sendMessage( ChatColor.RED +  "IceLord: Circle of radius " + radius + " s");
                        } catch (NumberFormatException e) {
                            player.sendMessage( ChatColor.RED +  "You have to select a numeric value.");
                        }
                    } else {
                        player.sendMessage( ChatColor.RED +  "USAGE: /fl|icelord seticedur [num]");
                    }
                } else if (split[0].equalsIgnoreCase("setexplosionforce")) {
                    if (split.length > 1) {
                        int fdur = Integer.valueOf(split[1]);
                        try {
                            //Config.setIceReflectDuration(Integer.valueOf(fdur));
                            Config.setExplosionForce(fdur);
                            
                            player.sendMessage( ChatColor.RED +  "Icelord: Explosion force is  " + fdur + " s");
                        } catch (NumberFormatException e) {
                            player.sendMessage( ChatColor.RED +  "You have to select a numeric value.");
                        }
                    } else {
                        player.sendMessage( ChatColor.RED +  "USAGE: /fl|icelord seticedur [num]");
                    }
                } else if (split[0].equalsIgnoreCase("line")) {
                    if (split.length > 1) {
                        int fdur = Integer.valueOf(split[1]);
                        try {
                            //Config.setIceReflectDuration(Integer.valueOf(fdur));
                            int x=player.getLocation().getBlockX();
                            int y = player.getLocation().getBlockY();
                            int z = player.getLocation().getBlockZ();
                            BlocksOper.createLine(player.getLocation() ,player.getWorld().getBlockAt(x+fdur,y,z).getLocation(),player.getWorld(),Material.SNOW,6,false);
                            
                            player.sendMessage( ChatColor.RED +  "Icelord: Explosion force is  " + fdur + " s");
                        } catch (NumberFormatException e) {
                            player.sendMessage( ChatColor.RED +  "You have to select a numeric value.");
                        }
                    } else {
                        player.sendMessage( ChatColor.RED +  "USAGE: /fl|icelord seticedur [num]");
                    }
                } else if (split[0].equalsIgnoreCase("seticesword")) {
                    if (split.length > 1) {
                        String value = split[1];
                        if (value.equalsIgnoreCase("on")) {
                            Config.setSword(true);
                            player.sendMessage( ChatColor.RED +  "IceLord Sword Activated");
                        } else if (value.equalsIgnoreCase("off")) {
                            Config.setSword(false);
                            player.sendMessage( ChatColor.RED +  "IceLord Sword Deactivated");
                        } else {
                            player.sendMessage( ChatColor.RED +  "Write on / off");
                        }
                    } else {
                        player.sendMessage( ChatColor.RED +  "USAGE: /fl|icelord icesword on/off");
                    }
                } else if (split[0].equalsIgnoreCase("iceresist")) {
                    if (split.length > 1) {
                        String value = split[1];
                        if (value.equalsIgnoreCase("on")) {
                            Config.setResist(true);
                            player.sendMessage( ChatColor.RED +  "IceLord ice resist Activated");
                        } else if (value.equalsIgnoreCase("off")) {
                            Config.setResist(false);
                            player.sendMessage( ChatColor.RED +  "IceLord ice resist Deactivated");
                        } else {
                            player.sendMessage( ChatColor.RED +  "Write on / off");
                        }
                    } else {
                        player.sendMessage( ChatColor.RED +  "USAGE: /fl|icelord iceresist on/off");
                    }
                } else if (split[0].equalsIgnoreCase("icereflect")) {
                    if (split.length > 1) {
                        String value = split[1];
                        if (value.equalsIgnoreCase("on")) {
                            Config.setReflect(true);
                            player.sendMessage( ChatColor.RED +  "IceLord ice reflect Activated");
                        } else if (value.equalsIgnoreCase("off")) {
                            Config.setReflect(false);
                            player.sendMessage( ChatColor.RED +  "IceLord ice reflect Deactivated");
                        } else {
                            player.sendMessage( ChatColor.RED +  "Write on / off");
                        }
                    } else {
                        player.sendMessage( ChatColor.RED +  "USAGE: /fl|icelord icereflect on/off");
                    }
                } else if (split[0].equalsIgnoreCase("icestep")) {
                    if (split.length > 1) {
                        String value = split[1];
                        if (value.equalsIgnoreCase("on")) {
                            Config.setStep(true);
                            player.sendMessage( ChatColor.RED +  "IceLord ice step Activated");
                        } else if (value.equalsIgnoreCase("off")) {
                            Config.setStep(false);
                            player.sendMessage( ChatColor.RED +  "IceLord ice step Deactivated");
                        } else {
                            player.sendMessage( ChatColor.RED +  "Write on / off");
                        }
                    } else {
                        player.sendMessage( ChatColor.RED +  "USAGE: /fl|icelord icestep on/off");
                    }
                } else if (split[0].equalsIgnoreCase("overwater")) {
                    if (split.length > 1) {
                        String value = split[1];
                        if (value.equalsIgnoreCase("on")) {
                            Config.setOverWater(true);
                            player.sendMessage( ChatColor.RED +  "IceLord over water Activated");
                        } else if (value.equalsIgnoreCase("off")) {
                            Config.setOverWater(false);
                            player.sendMessage( ChatColor.RED +  "IceLord over water Deactivated");
                        } else {
                            player.sendMessage( ChatColor.RED +  "Write on / off");
                        }
                    } else {
                        player.sendMessage( ChatColor.RED +  "USAGE: /fl|icelord overwater on/off");
                    }
                } else if (split[0].equalsIgnoreCase("overlava")) {
                    if (split.length > 1) {
                        String value = split[1];
                        if (value.equalsIgnoreCase("on")) {
                            Config.setOverLava(true);
                            player.sendMessage( ChatColor.RED +  "IceLord over lava Activated");
                        } else if (value.equalsIgnoreCase("off")) {
                            Config.setOverLava(false);
                            player.sendMessage( ChatColor.RED +  "IceLord over lava Deactivated");
                        } else {
                            player.sendMessage( ChatColor.RED +  "Write on / off");
                        }
                    } else {
                        player.sendMessage( ChatColor.RED +  "USAGE: /fl|icelord overlava on/off");
                    }
                } else if (split[0].equalsIgnoreCase("underwater")) {
                    if (split.length > 1) {
                        String value = split[1];
                        if (value.equalsIgnoreCase("on")) {
                            Config.setUnderWater(true);
                            player.sendMessage( ChatColor.RED +  "IceLord under water Activated");
                        } else if (value.equalsIgnoreCase("off")) {
                            Config.setUnderWater(false);
                            player.sendMessage( ChatColor.RED +  "IceLord under water Deactivated");
                        } else {
                            player.sendMessage( ChatColor.RED +  "Write on / off");
                        }
                    } else {
                        player.sendMessage( ChatColor.RED +  "USAGE: /fl|icelord underwater on/off");
                    }
                } else if (split[0].equalsIgnoreCase("icetools")) {
                    if (split.length > 1) {
                        String value = split[1];
                        if (value.equalsIgnoreCase("on")) {
                            Config.setPick(true);
                            Config.setAxe(true);
                            Config.setShovel(true);
                            player.sendMessage( ChatColor.RED +  "IceLord tools activated (pick/shovel/axe) Thanks Samkio!!");
                        } else if (value.equalsIgnoreCase("off")) {
                            Config.setPick(false);
                            Config.setAxe(false);
                            Config.setShovel(false);
                            player.sendMessage( ChatColor.RED +  "IceLord tools dectivated");
                        } else {
                            player.sendMessage( ChatColor.RED +  "Write on / off");
                        }
                    } else {
                        player.sendMessage( ChatColor.RED +  "USAGE: /fl|icelord icetools on/off");
                    }
                } else if (split[0].equalsIgnoreCase("luck")) {
                    if (split.length > 1) {
                        int value = Integer.getInteger(split[1]);
                        
                            Config.setPercentage(value);
                            player.sendMessage( ChatColor.RED +  "Luck set to " + value);
                      
                    } else {
                        player.sendMessage( ChatColor.RED +  "USAGE: /fl|icelord luck [value]");
                    }
                } else if (split[0].equalsIgnoreCase("status")) {
                    player.sendMessage( ChatColor.RED +  "############################");
                    player.sendMessage( ChatColor.RED +  "# FIRELORD FEATURES STATUS #");
                    player.sendMessage( ChatColor.RED +  "############################");
                    player.sendMessage( ChatColor.RED +  "");
                    player.sendMessage( ChatColor.RED +  "  Ice Sword = " + Config.isSword());
                    player.sendMessage( ChatColor.RED +  "  Ice Reflect Duration = " + Config.getReflectDuration() / 20);
                    player.sendMessage( ChatColor.RED +  "  Ice Duration = " + Config.getDuration() / 20);
                    player.sendMessage( ChatColor.RED +  "  Ice Resist = " + Config.isResist());
                    player.sendMessage( ChatColor.RED +  "  Ice Reflect = " + Config.isReflect());
                    player.sendMessage( ChatColor.RED +  "  Ice Step = " + Config.isStep());
                    player.sendMessage( ChatColor.RED +  "  Over Water = " + Config.isOverWater());
                    player.sendMessage( ChatColor.RED +  "  Over Lava = " + Config.isOverLava());
                    player.sendMessage( ChatColor.RED +  "  Under water = " + Config.isUnderWater());
                    player.sendMessage( ChatColor.RED +  "  Ice axe = " + Config.isAxe());
                    player.sendMessage( ChatColor.RED +  "  Ice pick = " + Config.isPick());
                    player.sendMessage( ChatColor.RED +  "  Ice shovel = " + Config.isShovel());
                    player.sendMessage( ChatColor.RED +  "");
                    player.sendMessage( ChatColor.RED +  "############################");
                    //player.sendMessage( ChatColor.RED + "Write on / off");
                }
            } else {
                //Commands explanation
                player.sendMessage( ChatColor.RED +  "############################");
                player.sendMessage( ChatColor.RED +  "# FIRELORD COMMANDS BRIEF  #");
                player.sendMessage( ChatColor.RED +  "############################");
                player.sendMessage( ChatColor.RED +  "");
                player.sendMessage( ChatColor.RED +  "  /fl|icelord");
                player.sendMessage( ChatColor.RED +  "  /fl|icelord status");
                player.sendMessage( ChatColor.RED +  "  /fl|icelord seticerefdur ");
                player.sendMessage( ChatColor.RED +  "  /fl|icelord seticedur");
                player.sendMessage( ChatColor.RED +  "  /fl|icelord iceresist on/off");
                player.sendMessage( ChatColor.RED +  "  /fl|icelord icereflect on/off");
                player.sendMessage( ChatColor.RED +  "  /fl|icelord icestep on/off");
                player.sendMessage( ChatColor.RED +  "  /fl|icelord overwater on/off");
                player.sendMessage( ChatColor.RED +  "  /fl|icelord overlava on/off");
                player.sendMessage( ChatColor.RED +  "  /fl|icelord underwater on/off");
                player.sendMessage( ChatColor.RED +  "  /fl|icelord icetools on/off");
                player.sendMessage( ChatColor.RED +  "  /fl|icelord luck [value]");
                
                player.sendMessage( ChatColor.RED +  "");
                player.sendMessage( ChatColor.RED +  "############################");
            }
            
            return true;
        }

    
}
