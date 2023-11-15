/** The class for Zoé's specific robot which role is to move like a square and die for 3 rounds if TerminaBot is near
 * @author (Zoé Devoyon)
 * @version (15/10/2022)
 */
public class SaraCoBot extends Robot
{ 
     private int mouv = 0;
     private TerminaBot r; 
    /**
     * SaraCoBot's constructor thanks to the Robot class inheritance
     * @param x x position at 11
     * @param y y position at 11
     * @param direction the robot's direction at 3
     * @param vitesse the robot's speed at 1
     * @param Color the color of the robot's body which will be green 
     * @ param r added : r robot belongs to the TerminaBot class for the SaraOff function 
     */
    public SaraCoBot(TerminaBot r)
    {
        super(11,11,3,1,"GREEN");
        this.r = r;
    }
    
    /**
     * This function purpose is to check if the robot r choosen before is 
     * next to SaraCoBot by checking the x and y position of both
     *
     */
    public void SaraOff()
    {
        if (( r.getX() == this.getX()-1 && r.getY() == this.getY()) || (r.getY() == this.getY()+1 && r.getX() == this.getX()) || (r.getX() == this.getX()+1 && r.getY() == this.getY()) || (r.getY() == this.getY()-1 && r.getX() == this.getX())) 
        {
            mouv = -2; 
        }
    }
    
    /**
     * SaraCoBot robot mouvements according to a square creation.
     * the SaraOff() method is called and if the r robot is next to SaraCoBot, it stops mouving for 3 rounds
     */
    public void avancer()
    {
        SaraOff(); 
        switch (mouv){
            case 1 : 
                super.avancer(); 
                super.tournerG();
                mouv = mouv+1; 
                break; 
            case 2 : 
                super.avancer(); 
                super.tournerG();
                mouv = mouv+1; 
                break; 
            case 3 : 
                super.avancer(); 
                super.tournerG();
                mouv = mouv+1; 
                break; 
            case 4 : 
                super.avancer(); 
                super.tournerG();
                mouv = 1; 
                break; 
            case -1 : 
                mouv += 1;break;
            case 0 : 
                mouv += 1;break;
            case -2:
                mouv+=1; break;
        }
        
    }
    
}