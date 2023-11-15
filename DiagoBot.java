import java.util.Random;

/**
 * A robot moving diagonaly, turning on the rigth and changing color randomly
 * while bouncing on the borders
 * 
 * @author Mélyna LEFEVRE--ROMY
 * @version 14/10/22
 */
public class DiagoBot extends Robot
{
    private int x;
    private int y;
    private boolean border = false;
    
    /**
     * DiagoBot's constructor
     */
    public DiagoBot(){ 
        super(10,8,2,1,"WHITE");
    }
    
    /**
     * Allows the robot to move
     */
    public void avancer(){  
        if(borders()){
            super.tournerD();
            randoColour();
            diagonal();
        }
        else{
            diagonal();
        }
    }
    
    /**
     * Allows the robot to move diagonaly while turning towards the left
     */
    public void diagonal(){
        super.avancer();
        super.tournerG();
        super.avancer();
        super.tournerD();
    }
    
    /**
     * Allows to know if a border is reached
     * @return true if a border is reached, false otherwise
     */
    public boolean borders(){
        if (getX()==0 || getX()==11 || getY()==0 || getY()==11){
            return true;
        }
        else{
            return false;
        }
    }
     
    /**
     * Choose a new color randomly
     */
    public void randoColour(){
        int colo = new Random().nextInt(8);
        switch (colo){
        case 1 : changeColor("RED");break;
        case 2 : changeColor("BLACK");break;
        case 3 : changeColor("BLUE");break;
        case 4 : changeColor("YELLOW");break;
        case 5 : changeColor("GREEN");break;
        case 6 : changeColor("MAGENTA");break;
        case 7 : changeColor("WHITE");break;
        case 0 : changeColor("PURPLE");break;
        }
    }
}