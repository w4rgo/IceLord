/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IceLord;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.File;

/**
 * Lord 0.4
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
public class Config {

    private static String configPath = "plugins/Icelord/config.properties";
    private static String configFile = "config.properties";

    private static Properties config;
    private static FileInputStream fi;
    

    public static int getExplosionForce() {
        return explosionForce;
    }

    public static void setExplosionForce(int explosionForce) {
        Config.explosionForce = explosionForce;
    }
   
    private static int helmId = 310;
    private static int chestId = 311;
    private static int legsId = 312;
    private static int bootsId = 313;

    private static int swordId = 276;
    private static int shovelId = 277;
    private static int pickId = 278;
    private static int axeId = 279;
    
    private static boolean Sword = true;
    private static boolean Pick = true;
    private static boolean Axe = true;
    private static boolean Shovel = true;
    private static boolean Resist = true;
    private static boolean Reflect = true;
    private static boolean Step = false;
    private static boolean StepFly = true;
    private static boolean overWater = false;
    private static boolean overLava = false;
    private static boolean underWater = false;
    private static boolean allowedPvp = true;
    
    private static int Duration = 50;
    private static int ReflectDuration = 40;
    private static int percentage = 100;
    static boolean isAllowedMolotov = true;

    
    

    ///ICELORD
    private static int stepRadius = 0;//-
    private static int pillarRadius = 1;//-
    private static int pillarHeight = 2;//-
    private static int explosionForce = 3;//-
    private static boolean expansive = true;//
    private static int expansiveQuantum = 300;//-
    private static int expansiveMaxRadius =5;//-
    private static boolean fallDmg = true;//-


    public static int getPillarHeight() {
        return pillarHeight;
    }



    public static boolean isIsAllowedMolotov() {
        return isAllowedMolotov;
    }

    public static void setIsAllowedMolotov(boolean isAllowedMolotov) {
        Config.isAllowedMolotov = isAllowedMolotov;
    }

    public static int getPillarRadius() {
        return pillarRadius;
    }



    private static boolean boolValue(String value) {
        if (value.equalsIgnoreCase("true")) {
            return true;
        } else if (value.equalsIgnoreCase("false")) {
            return false;
        } else {
            return false;
        }
    }

    public static void loadConfig(File filePath) throws IOException {
        boolean changed = false;
        configPath = filePath.toString() + File.separator + configFile;
        config = new Properties();
        try {
            fi = new FileInputStream(Config.configPath);

            config.load(fi);
        } catch (FileNotFoundException e) {
            File f = new File(configPath);
            f.createNewFile();
            fi = new FileInputStream(Config.configPath);
        }


        if (config.getProperty("ReflectDuration") != null) {
            ReflectDuration = Integer.valueOf(config.getProperty("ReflectDuration")) * 20;
        } else {
            config.setProperty("ReflectDuration", String.valueOf(ReflectDuration));
            changed = true;
        }
        if (config.getProperty("duration") != null) {
            Duration = Integer.valueOf(config.getProperty("duration")) * 20;
        } else {
            config.setProperty("duration", String.valueOf(Duration));
            changed = true;
        }
        if (config.getProperty("Sword") != null) {
            Sword = boolValue(config.getProperty("Sword"));
        } else {
            config.setProperty("Sword", String.valueOf(Sword));
            changed = true;
        }
        if (config.getProperty("fallDmg") != null) {
            fallDmg = boolValue(config.getProperty("fallDmg"));
        } else {
            config.setProperty("fallDmg", String.valueOf(fallDmg));
            changed = true;
        }
        if (config.getProperty("Pick") != null) {
            Pick = boolValue(config.getProperty("Pick"));
        } else {
            config.setProperty("Pick", String.valueOf(Pick));
            changed = true;
        }
        if (config.getProperty("Axe") != null) {
            Axe = boolValue(config.getProperty("Axe"));
        } else {
            config.setProperty("Axe", String.valueOf(Axe));
            changed = true;
        }
        if (config.getProperty("Shovel") != null) {
            Shovel = boolValue(config.getProperty("Shovel"));
        } else {
            config.setProperty("Shovel", String.valueOf(Shovel));
            changed = true;
        }
        if (config.getProperty("Resist") != null) {
            Resist = boolValue(config.getProperty("Resist"));
        } else {
            config.setProperty("Resist", String.valueOf(Resist));
            changed = true;
        }
        if (config.getProperty("Reflect") != null) {
            Reflect = boolValue(config.getProperty("Reflect"));
        } else {
            config.setProperty("Reflect", String.valueOf(Reflect));
            changed = true;
        }
        if (config.getProperty("Step") != null) {
            Step = boolValue(config.getProperty("Step"));
        } else {
            config.setProperty("Step", String.valueOf(Step));
            changed = true;
        }
        if (config.getProperty("overWater") != null) {
            overWater = boolValue(config.getProperty("overWater"));
        } else {
            config.setProperty("overWater", String.valueOf(overWater));
            changed = true;
        }
        if (config.getProperty("overLava") != null) {
            overLava = boolValue(config.getProperty("overLava"));
        } else {
            config.setProperty("overLava", String.valueOf(overLava));
            changed = true;
        }
        if (config.getProperty("underWater") != null) {
            underWater = boolValue(config.getProperty("underWater"));
        } else {
            config.setProperty("underWater", String.valueOf(underWater));
            changed = true;
        }
        
        //Item Ids

        if (config.getProperty("boots") != null) {
            bootsId = Integer.valueOf(config.getProperty("boots"));
        } else {
            config.setProperty("boots", String.valueOf(bootsId));
            changed = true;
        }
        if (config.getProperty("chestplate") != null) {
            chestId = Integer.valueOf(config.getProperty("chestplate"));
        } else {
            config.setProperty("chestplate", String.valueOf(chestId));
            changed = true;
        }
        if (config.getProperty("helmet") != null) {
            helmId = Integer.valueOf(config.getProperty("helmet"));
        } else {
            config.setProperty("helmet", String.valueOf(helmId));
            changed = true;
        }
        if (config.getProperty("leggings") != null) {
            legsId = Integer.valueOf(config.getProperty("leggings"));
        } else {
            config.setProperty("leggings", String.valueOf(legsId));
            changed = true;
        }
        if (config.getProperty("sword") != null) {
            swordId = Integer.valueOf(config.getProperty("sword"));
        } else {
            config.setProperty("sword", String.valueOf(swordId));
            changed = true;
        }
        if (config.getProperty("pick") != null) {
            pickId = Integer.valueOf(config.getProperty("pick"));
        } else {
            config.setProperty("pick", String.valueOf(pickId));
            changed = true;
        }
        if (config.getProperty("axe") != null) {
            axeId = Integer.valueOf(config.getProperty("axe"));
        } else {
            config.setProperty("axe", String.valueOf(axeId));
            changed = true;
        }
        if (config.getProperty("shovel") != null) {
            shovelId = Integer.valueOf(config.getProperty("shovel"));
        } else {
            config.setProperty("shovel", String.valueOf(shovelId));
            changed = true;
        }
        
        if (config.getProperty("allowedPvp") != null) {
            allowedPvp = boolValue(config.getProperty("allowedPvp"));
        } else {
            config.setProperty("allowedPvp", String.valueOf(allowedPvp));
            changed = true;
        }
        if(config.getProperty("luck") != null) {
            percentage = Integer.valueOf(config.getProperty("luck"));
        } else {
            config.setProperty("luck", String.valueOf(percentage));
            changed = true;
        }
        if(config.getProperty("stepRadius") != null) {
            stepRadius = Integer.valueOf(config.getProperty("stepRadius"));
        } else {
            config.setProperty("stepRadius", String.valueOf(stepRadius));
            changed = true;
        }
        if(config.getProperty("expansiveQuantum") != null) {
            expansiveQuantum = Integer.valueOf(config.getProperty("expansiveQuantum"));
        } else {
            config.setProperty("expansiveQuantum", String.valueOf(expansiveQuantum));
            changed = true;
        }
        if(config.getProperty("pillarRadius") != null) {
            pillarRadius = Integer.valueOf(config.getProperty("pillarRadius"));
        } else {
            config.setProperty("pillarRadius", String.valueOf(pillarRadius));
            changed = true;
        }
        
        if(config.getProperty("pillarHeight") != null) {
            pillarHeight = Integer.valueOf(config.getProperty("pillarHeight"));
        } else {
            config.setProperty("pillarHeight", String.valueOf(pillarHeight));
            changed = true;
        }

        
        if(config.getProperty("expansiveMaxRadius") != null) {
            expansiveMaxRadius = Integer.valueOf(config.getProperty("expansiveMaxRadius"));
        } else {
            config.setProperty("expansiveMaxRadius", String.valueOf(expansiveMaxRadius));
            changed = true;
        }
        
        
        if (config.getProperty("expansive") != null) {
            expansive = boolValue(config.getProperty("expansive"));
        } else {
            config.setProperty("expansive", String.valueOf(expansive));
            changed = true;
        }
        
        if (changed) {
            FileOutputStream fo = new FileOutputStream(configPath);
            config.store(fo, configPath);
            fo.close();
        }

    }
    
    
        public static void setExpansive(boolean value) {
        FileOutputStream fo = null;
        try {
            expansive = value;
            config.setProperty("expansive", String.valueOf(value));
            fo = new FileOutputStream(configPath);
            config.store(fo, configPath);
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public static void setExpansiveQuantum(int value) {
        FileOutputStream fo = null;
        try {
            expansiveQuantum = value; //In Milliseconds
            config.setProperty("expansiveQuantum", String.valueOf(value));
            fo = new FileOutputStream(configPath);
            config.store(fo, configPath);
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      public static void setExpansiveMaxRadius(int value) {
        FileOutputStream fo = null;
        try {
            expansiveMaxRadius = value; 
            config.setProperty("expansiveMaxRadius", String.valueOf(value));
            fo = new FileOutputStream(configPath);
            config.store(fo, configPath);
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            public static void setPillarRadius(int value) {
        FileOutputStream fo = null;
        try {
            pillarRadius = value; 
            config.setProperty("pillarRadius", String.valueOf(value));
            fo = new FileOutputStream(configPath);
            config.store(fo, configPath);
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
                        public static void setPillarHeight(int value) {
        FileOutputStream fo = null;
        try {
            pillarHeight= value; 
            config.setProperty("pillarHeight", String.valueOf(value));
            fo = new FileOutputStream(configPath);
            config.store(fo, configPath);
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    public static void setStepRadius(int value) {
        FileOutputStream fo = null;
        try {
            stepRadius = value; //Translation into bukkit ticks 1 s -> 1/20 ticks
            config.setProperty("stepRadius", String.valueOf(value));
            fo = new FileOutputStream(configPath);
            config.store(fo, configPath);
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public static void setDuration(int value) {
        FileOutputStream fo = null;
        try {
            Duration = value * 20; //Translation into bukkit ticks 1 s -> 1/20 ticks
            config.setProperty("duration", String.valueOf(value));
            fo = new FileOutputStream(configPath);
            config.store(fo, configPath);
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setReflectDuration(int value) {
        FileOutputStream fo = null;
        try {
            ReflectDuration = value * 20; //Translation into bukkit ticks 1 s -> 1/20 ticks
            config.setProperty("ReflectDuration", String.valueOf(value));
            fo = new FileOutputStream(configPath);
            config.store(fo, configPath);
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setStep(boolean value) {
        FileOutputStream fo = null;
        try {
            Step = value;
            config.setProperty("Step", String.valueOf(value));
            fo = new FileOutputStream(configPath);
            config.store(fo, configPath);
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void setFly(boolean value) {
        FileOutputStream fo = null;
        try {
            StepFly = value;
            config.setProperty("iceStepFly", String.valueOf(value));
            fo = new FileOutputStream(configPath);
            config.store(fo, configPath);
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setSword(boolean value) {
        FileOutputStream fo = null;
        try {
            Sword = value;
            config.setProperty("Sword", String.valueOf(value));
            fo = new FileOutputStream(configPath);
            config.store(fo, configPath);
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setPick(boolean value) {
        FileOutputStream fo = null;
        try {
            Pick = value;
            config.setProperty("Pick", String.valueOf(value));
            fo = new FileOutputStream(configPath);
            config.store(fo, configPath);
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setAxe(boolean value) {
        FileOutputStream fo = null;
        try {
            Axe = value;
            config.setProperty("Axe", String.valueOf(value));
            fo = new FileOutputStream(configPath);
            config.store(fo, configPath);
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setShovel(boolean value) {
        FileOutputStream fo = null;
        try {
            Shovel = value;
            config.setProperty("Shovel", String.valueOf(value));
            fo = new FileOutputStream(configPath);
            config.store(fo, configPath);
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setReflect(boolean value) {
        FileOutputStream fo = null;
        try {
            Reflect = value;
            config.setProperty("Reflect", String.valueOf(value));
            fo = new FileOutputStream(configPath);
            config.store(fo, configPath);
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setResist(boolean value) {
        FileOutputStream fo = null;
        try {
            Resist = value;
            config.setProperty("Resist", String.valueOf(value));
            fo = new FileOutputStream(configPath);
            config.store(fo, configPath);
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setOverWater(boolean value) {
        FileOutputStream fo = null;
        try {
            overWater = value;
            config.setProperty("overWater", String.valueOf(value));
            fo = new FileOutputStream(configPath);
            config.store(fo, configPath);
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setOverLava(boolean value) {
        FileOutputStream fo = null;
        try {
            overLava = value;
            config.setProperty("overLava", String.valueOf(value));
            fo = new FileOutputStream(configPath);
            config.store(fo, configPath);
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setUnderWater(boolean value) {
        FileOutputStream fo = null;
        try {
            underWater = value;
            config.setProperty("underWater", String.valueOf(value));
            fo = new FileOutputStream(configPath);
            config.store(fo, configPath);
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void setAllowedPvp(boolean value) {
        FileOutputStream fo = null;
        try {
            allowedPvp = value;
            config.setProperty("allowedPvp", String.valueOf(value));
            fo = new FileOutputStream(configPath);
            config.store(fo, configPath);
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void setFallDmg(boolean value) {
        FileOutputStream fo = null;
        try {
            fallDmg = value;
            config.setProperty("fallDmg", String.valueOf(value));
            fo = new FileOutputStream(configPath);
            config.store(fo, configPath);
            fo.close();
        } catch (IOException ex) {
            Logger.getLogger(Config.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean isFallDmg() {
        return fallDmg;
    }


    public static int getLegsId() {
        return legsId;
    }

    public static int getBootsId() {
        return bootsId;
    }

    public static int getChestId() {
        return chestId;
    }

    public static int getHelmId() {
        return helmId;
    }

    public static int getSwordId() {
        return swordId;
    }

    public static int getPickId() {
        return pickId;
    }

    public static int getAxeId() {
        return axeId;
    }

    public static int getShovelId() {
        return shovelId;
    }

    public static int getDuration() {
        return Duration;
    }

    public static int getReflectDuration() {
        return ReflectDuration;
    }

    public static boolean isReflect() {
        return Reflect;
    }

    public static boolean isResist() {
        return Resist;
    }

    public static boolean isStep() {
        return Step;
    }

    public static boolean isSword() {
        return Sword;
    }

    public static boolean isPick() {
        return Pick;
    }

    public static boolean isAxe() {
        return Axe;
    }

    public static boolean isShovel() {
        return Shovel;
    }

    public static boolean isOverLava() {
        return overLava;
    }

    public static boolean isOverWater() {
        return overWater;
    }

    public static boolean isUnderWater() {
        return underWater;
    }

    public static boolean isAllowedPvp() {
        
        return allowedPvp;
    }

    public static int getPercentage() {
        return percentage;
    }

    public static void setPercentage(int percentage) {
        Config.percentage = percentage;
    }

    public static boolean isExpansive() {
        return expansive;
    }

    public static int getExpansiveMaxRadius() {
        return expansiveMaxRadius;
    }

    public static int getExpansiveQuantum() {
        return expansiveQuantum;
    }

    public static int getStepRadius() {
        return stepRadius;
    }
    
    public static boolean getStepFly() {
        return StepFly;
    }
}
