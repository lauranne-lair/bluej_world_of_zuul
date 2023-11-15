import java.awt.*;
import java.util.Random;
/**
 * The RandomR class allows the RandomR robot to be moved randomly.
 * The X and Y coordinates are determined by the Random function between 0 and 11.
 * The robot has a one in three chance of staying at the same position while the other robots perform a move.
 * The robot has a one in three chance of staying in the same position while the other robots are making a move.
 * With each move the RandomR robot changes the colour of its body between yellow and
 * purple.
 * 
 * @author SCHOTT Fanny
 * @version 14th October 2022
 */
public class RandomR extends Robot {

    private int id = 5;
    private int i = 1;
    int xdep = 2;
    int ydep = 2;
    int mouv;
    int j =0;
    
/**
 * allows to create the RandomR robot according to the parent class Robot
 * X is initialized at 5
 * Y at 5
 * the direction at 2
 * the speed at 2
 * the body color at yellow
 */
public RandomR()
{
    // Constructor of the RandomR class
    super(5,5,2,2,"YELLOW");
}

/**
 * allows the robot to mouve with random values for x and y 
 * it allows the colorbody to change while mouving
 */
public void avancer() {  
        // xdep and ydep are integer variables containing the coordinates
        // to X and Y respectively
        xdep = new Random().nextInt(12);
        ydep = new Random().nextInt(12);
        // The variable move contains the random value between 0 and 8, in order to
        // make the robot move two times out of three.
        mouv = new Random().nextInt(9);
        
        // This condition changes the colour of the robot's body 
        //for each movement
        if (j % 2 == 0) {
            this.changeColor("PURPLE");
        }
        else {
            this.changeColor("YELLOW");
        }
        
        // This condition allows to send the coordinates of the robot only if 
        // the random motion is strictly less than 6, 1 chance out of 3 that the 
        // robot moves, otherwise it stays at the same position
        if (mouv < 6) {
                this.setX(xdep);
                this.setY(ydep);
                j++;
        }
    }
}

