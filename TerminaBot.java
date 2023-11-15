import java.util.Random;
import javax.swing.JOptionPane;
/**
 * Terminabot wanders randomly around the field looking for SaraCoBot.
 * If he finds her, he prevents her from moving during 3 turns.
 *
 * @author Corentin Lespagnol
 * @version 12/10/2022
 */
public class TerminaBot extends Robot


{
    
       /**
     * Constructor of objects of class TerminaBot
     */
    public TerminaBot()
    {
        super(0,0,1,3,"BLACK");
    }
    
        /**
         * Randomly determines a value between min and max (inclusive). 
         * Allows you to randomly determine the direction.
         * @return a integer corresponding to the direction
         */
    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    
    /**
     * Causes a message to appear when a robot of class SaracoBot is adjacent to a robot of class TerminaBot
     */
    public void chercherSaracoBot(Robot r1,Robot r2){
        
        if (r1.getX()==r2.getX() && r1.getY()==(r2.getY()-1)){
            JOptionPane.showMessageDialog( null, "SaracoBot has been found!!! Target neutralized!");
        }else if (r1.getX()==r2.getX() && r1.getY()==(r2.getY()+1)){
            JOptionPane.showMessageDialog( null, "SaracoBot has been found!!! Target neutralized!");
        }else if (r1.getY()==r2.getY() && r1.getX()==(r2.getX()-1)){
            JOptionPane.showMessageDialog( null, "SaracoBot has been found!!! Target neutralized!");
        }else if (r1.getY()==r2.getY() && r1.getX()==(r2.getX()+1)){
            JOptionPane.showMessageDialog( null, "SaracoBot has been found!!! Target neutralized!");
        }
        
        }
        
    
    
    
        /**
         * Moves the robot in a random direction
         */
    public void avancer()
    {
        
        for (int v=super.getVitesse(); v>0; v--){
                super.setDirection(getRandomNumberInRange(0,3));
                switch(super.getDirection()) {
                    case 0:
                        super.setX(super.getX()+1);
                        if (super.sécurité()==true){
                            super.setX(11);
                        }
                        
                        break;
                    case 1:
                        super.setY(super.getY()+1);
                        if (super.sécurité()==true){
                            super.setY(11);
                        }
                        break;
                    case 2:
                        super.setX(super.getX()-1);
                        if (super.sécurité()==true){
                            super.setX(0);
                        }
                        break;
                    case 3:
                        super.setY(super.getY()-1);
                        if (super.sécurité()==true){
                            super.setY(0);
                        }
                        break;
                    }
            
            }
    }
    
    
}