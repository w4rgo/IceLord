package IceLord.tools;


import IceLord.tools.IcePlayer;
import net.milkbowl.vault.permission.Permission;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ajax
 */
public class IcePerm {
    
    
    private static final String _armorPerm = "icelord.armor";
    private static final String _iceStepPerm = "icelord.icestep";
    private static final String _iceStepFly = "icelord.icestep.fly";
    private static final String _swordPerm = "icelord.sword";
    private static final String _fallPerm = "icelord.fall";
    private static final String _helmetPerm = "icelord.helmet";
    private static final String _adminPerm = "icelord.admins";
    private static final String _toolPerm = "icelord.tools";
    
    private static boolean _permissionsOn = false;
    private static Permission _permVault;
    private IcePlayer player;
    private static final String  _splashPerm="firelord.splash";

    public IcePerm(IcePlayer player) {
        this.player = player;
    }

    public static Permission getPermVault() {
        return _permVault;
    }

    public static void setPermVault(Permission permVault) {
        _permVault = permVault;
    }
    
    public static void setPermissions(boolean value) {
        _permissionsOn=value;
        
    }
    public boolean hasPermission(String perm) {
//        if(!perm.equals("firelord.boots.firestep")) {
//        Dbg.p("Permission try: " + perm);
//        Dbg.p("-vault:"+(_permVault!=null));
//        Dbg.p("bukkitperm: " + _permissionsOn);}
            if(_permVault!=null) {
                //USA VAULT
//                if(!perm.equals("firelord.boots.firestep")) {
//                Dbg.p("llega a dentro de permvault");
//               Dbg.p("nombre:" + player.getPlayer().getName());
//                Dbg.p(_permVault.getPrimaryGroup(player.getPlayer()));}
//                Dbg.p("Resultado : " + _permVault.has(player.getPlayer(),perm) );
//                
                //printAllPerms();
                return _permVault.has(player.getPlayer(),perm);   
            } else if(_permissionsOn) {
                //USA BUKKITPERM
                 //System.out.println("Pregunta si tiene permiso de permissions");
                 
                 return player.getPlayer().hasPermission(perm);
            } else {
                //USA OP
                return player.getPlayer().isOp();
            }
    }
    
    public boolean allowedArmor() {
        return this.hasPermission(_armorPerm);
    }
    public boolean allowedSword() {
        return hasPermission(_swordPerm);
    }

    public boolean allowedHelmet() {
        return hasPermission(_helmetPerm);
    }
    public boolean allowedIceStep() {
        return hasPermission(_iceStepPerm);
    }
    public boolean allowedFall() {
        return hasPermission(_fallPerm);
    }
    public boolean isAdmin() {
        return hasPermission(_adminPerm);
    }
    public boolean allowedTools() {
        return hasPermission(_toolPerm);
    }

    public boolean allowedFly() {
        return hasPermission(_iceStepFly);
    }

    
    
    public void printAllPerms() {
        
        Dbg.p(player.getPlayer().getName() +": - PERMISSIONS");
        Dbg.p("armor: "+this.allowedArmor());
        Dbg.p("tools: "+this.allowedTools());
        Dbg.p("helmet: "+this.allowedHelmet());
        Dbg.p("fall " + this.allowedFall());
        Dbg.p("admin: "+this.isAdmin());
        Dbg.p("icestep: "+this.allowedIceStep());
        Dbg.p("splash: "+this.allowedSplash());
        
    }

    public boolean allowedSplash() {
        return hasPermission(_splashPerm);
    }
    
    
}
