import java.util.*;
/**
 * The mother class of the specific robots
 *
 * @author Groupe2-COOPOO
 * @version 15/10/22
 */
public class Robot
{
    private int x;
    private int y;
    private int direction;
    private String colorBody;
    private String colorHead;
    private ListOfRobot list;
    private int vitesse;
    private CanvasRobot canvasRobot;
    
    /**
     * Robot's constructor
     * @param x x position
     * @param y y position
     * @param direction the robot's direction
     * @param vitesse the robot's speed
     * @param Color the color of the robot's body
     */
    public Robot(int x,int y,int direction,int vitesse,String Color)
    {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.vitesse = vitesse;
        this.colorBody = Color;
        canvasRobot = new CanvasRobot(Color);
        canvasRobot.drawRobot(x,y);
    }
    
    /**
     * Creates a list of robots
     * @param world the list of the robots
     */
    public void setList(ListOfRobot world){
        list = world;
    }
    
    /**
     * Draws the robot
     * @return the drawing of the robot
     */
    public CanvasRobot getCanvasRobot(){
        return canvasRobot;
    }
    
    /**
     * Allows a robot to change direction
     * @param i the direction of the robot
     */
    public void setDirection(int i){
        if (i>-1 && i<4){
            direction=i;
        }else{
            System.out.print("Direction incorrecte, veuillez la sélectionner entre 0 et 3");
        }
        
    }
    /**
     * Security for the robot to not get out of the canvas
     */
    public boolean sécurité()
    {
        int ox,oy;
        boolean error;
        error=false;
        ox=this.x;
        oy=this.y;
        switch(direction) {
                case 0:
                    ox++;
                    if (ox>11){
                        error=true;
                    }
                    break;
                case 1:
                    oy++;
                    if (oy>11){
                        error=true;
                    }
                    break;
                case 2:
                    ox--;
                    if (ox<0){
                        error=true;
                    }
                    break;
                case 3:
                    oy--;
                    if (oy<0){
                        error=true;
                    }
                    break;
            }
        return error;
    }
    /**
    * Allows the robot to move
     */
    public void avancer()
    {
            for (int v=vitesse; v>0; v--){
    
                switch(direction) {
                    case 0:
                        this.x++;
                        if (sécurité()==true){
                            this.x=11;
                        }                     
                        break;
                    case 1:
                        this.y++;
                        if (sécurité()==true){
                            this.y=11;
                        }
                        break;
                    case 2:
                        this.x--;
                        if (sécurité()==true){
                            this.x=0;
                        }
                        break;
                    case 3:
                        this.y--;
                        if (sécurité()==true){
                            this.y=0;
                        }
                        break;
                    }
            
            }   
    }
    
    
    /**
     * Allows the robot to turn to the right
     */
    public void tournerD()
    {
        direction=(direction+1)%4;
    }
    
    /**
     * Allows the robot to turn to the left
     */
    public void tournerG()
    {
        if (direction==0){
            direction=3;}
        else { direction-=1;}
    }
    
    /**
     * Getter of the X position of the robot
     */
    public int getX()
    {
         return x;   
    }
    
    /**
     * Setter of the X position of the robot
     * @param newX the new X position
     */
    public void setX(int newX)
    {
         this.x = newX;   
    }
    
    /**
     * Getter of the Y position of the robot
     * @return the y position
     */
    public int getY()
    {
         return y;   
    }
       
    /**
     * Setter of the Y position of the robot
     * @param newY the new Y position
     */
    public void setY(int newY){
        this.y = newY;
    }
    
    /**
     * Getter of the speed of the robot
     * @returns the speed value 
     */
    public int getVitesse()
    {
         return vitesse;   
    }
    
    /**
     * Getter of the direction of the robot
     * @return the direction value 
     */
    public int getDirection()
    {
         return direction;   
    }
    
    /**
     * Getter the robot's head color
     * @return the colorHead value 
     */
    public String getColorHead()
    {
         return colorHead;   
    }
     
    /**
     * Getter the robot's body color
     * @return the colorBody value 
     */
    public String getColorbody()
    {
         return colorBody;   
    }
    
    /**
     * Allows to change the color of the body of the robot
     * @param newColor the new color of the robot
     */
    public void changeColor(String newColor){
        this.colorBody = newColor;
        canvasRobot.setColourBody(this.colorBody);
    }
}
