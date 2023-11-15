import java.util.ArrayList;
import java.util.concurrent.TimeUnit ;
/**
 * Our world class that adds each robot in the list
 * 
 * @author Groupe2-COOPOO
 * @Version 0.01 ALPHA
 */
public class ListOfRobot
{
    private ArrayList<Robot> list;
    
    private CanvasRobot canvasRobot;

    /**
     * Create the list
     */
    public ListOfRobot()
    {
        list = new ArrayList<Robot>();
    }
    /**
     * Creation of all the robots
     */
    public void newRobot(){
        // Creation of Terminabot
        TerminaBot robot1 = new TerminaBot();
        canvasRobot = new CanvasRobot(robot1.getColorbody());
        list.add(robot1);
        robot1.setList(this);
        
        //Creation of Valsobot
        Valsobot robot2 = new Valsobot();
        canvasRobot = new CanvasRobot(robot2.getColorbody());
        list.add(robot2);
        robot2.setList(this);
        
        //Creation of DiscoBot    
        DiscoBot robot3 = new DiscoBot();
        canvasRobot = new CanvasRobot(robot3.getColorbody());
        list.add(robot3);
        robot3.setList(this);
        
        // Creation of SaraCoBot       
        SaraCoBot robot4 = new SaraCoBot(robot1);
        canvasRobot = new CanvasRobot(robot4.getColorbody());
        list.add(robot4);
        robot4.setList(this);
        
        // Creation of RandoR       
        RandomR robot5 = new RandomR();
        canvasRobot = new CanvasRobot(robot5.getColorbody());
        list.add(robot5);
        robot5.setList(this);
        
        //Creation of DiagoBot        
        DiagoBot robot6 = new DiagoBot();
        canvasRobot = new CanvasRobot(robot6.getColorbody());
        list.add(robot6);
        robot6.setList(this);        
    }
    
    /**
     * A method that allows to avoid collisions between the robots
     * @param r a robot
     */
    private boolean antiCollision(Robot r){
        boolean collision=false;
        int ox= r.getX();
        int oy= r.getY();
            for(Robot e : list){
                if (e!=r){
                int vx = e.getX();
                int vy = e.getY();
                if (ox == vx && oy == vy){
                    collision=true;
                }
            }
        }
        return collision;
    }
    /**
     * Loop for the movement from each robot
     */
    public void moveAll() throws InterruptedException {
        while (true){
            for (Robot r:list){
                int rX= r.getX();
                int rY= r.getY();
                r.avancer();
                if (antiCollision(r)==true){
                    r.setX(rX);
                    r.setY(rY);
                }
                r.getCanvasRobot().drawRobot(r.getX(),r.getY());
                if (r instanceof TerminaBot==true){
                    for (Robot searchR:list){
                        if (searchR instanceof SaraCoBot==true){
                            ((TerminaBot)r).chercherSaracoBot(r,searchR);
                        }
                    }
                }
            }
            Thread.sleep(500);
        }
    }
}


