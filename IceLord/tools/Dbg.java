/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IceLord.tools;

/**
 *
 * @author Fran
 */
public class Dbg {
    
    private static boolean on=false;
    private static String prefix="[DBG]";
    
    public static void p(String message){
        if(on) {
            System.out.println(prefix + message);
        }
    }
    public static void p(boolean message){
        if(on) {
            System.out.println(prefix + message);
        }
    }
        public static void p(int message){
        if(on) {
            System.out.println(prefix + message);
        }
    }
}
