import java.util.Random;
/**
 * Disco_Robot's class, a robot that changecolor becuase it's like music 
 * @author Léri LAMOUR 
 * @Version 0.01 ALPHA
 * */
public class DiscoBot extends Robot
{
    static private Random randomGenerator;
    private int disco = 1;
    /**
     * Create a DiscoRobot in x=7, y=3, looking right, with the best colour
     */
    public DiscoBot()
    {
        super(7,3,0,1,"Purple");
    }
    /**
     * Random generator for changing color 
     */
    public void randoColour(){
        int a = new Random().nextInt(8);
        switch (a){
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
    /**
     * 1st part of the Snake mouvement
     */
    public void jTourne(){
        super.avancer();
        tournerD();
    }
    /**
     * 2nd part of the Snake mouvement
     */
    public void commeUnSerpent(){
        super.avancer();
        tournerG();
    }
    /**
     * OverRiding of the mouvement's method "avancer()"
     */
    
    public void avancer(){ // Polymorphisme of the movement
        if (getX()==11 || getX()==0){tournerG();}
        if(disco == 1 || disco == 4){
        jTourne();
        }else commeUnSerpent();
        if (disco == 4){
        disco =1;
        }else disco++;
        randoColour();
    }
}