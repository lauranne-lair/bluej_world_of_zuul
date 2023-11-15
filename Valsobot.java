
/**
 * Valsobot is a robot who move in a patern, up, down, right, left,
 * down, down, up, left, right, up. This is a valse (dance).
 *
 * @author DELHAYE Axel
 * @version 1.0
 */
public class Valsobot extends Robot
{
    // variables valsobot, Temps (one time in music)
    private int temps;

    /**
     * Constructor of the classes Valsobot
     */
    public Valsobot()
    {
        // initialisation des variables d'instance
        super(3,7,3,1,"BLUE");
        temps=1;
    }

    /**
     * "avancer" is a methode who gives a patern for the movement.
     */
    public void avancer()
    {
        switch (temps) {
            case 1 :
                super.avancer();
                super.tournerD();
                super.tournerD();
                temps++;
                break;
            case 2 :
                super.avancer();
                super.tournerD();
                super.tournerD();
                temps++;
                break;
            case 3 :
                super.tournerD();
                super.avancer();
                super.tournerD();
                super.tournerD();
                temps++;
                break;
            case 4 :
                super.avancer();
                super.tournerG();
                temps++;
                break;    
            case 5 :
                super.avancer();
                temps=1;
                break;
        }
    }
    
    
    


}


