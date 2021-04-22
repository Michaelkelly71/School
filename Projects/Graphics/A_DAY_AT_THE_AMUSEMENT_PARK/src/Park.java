import java.applet.Applet;
import java.awt.*;


public class Park extends Applet
{
    //setting screen resolution for work
    final static int width = 1400;
    final static int height = 773;
    public  void init(){
        resize(width,height);
    }

    private static final long serialVersionUID = 1L;

    //Creating objects for the various classes used in the code
    Sun s = new Sun();
    Ferris f = new Ferris();
    Ground gd = new Ground();
    Sea_Saw ss = new Sea_Saw();
    Kite k = new Kite();
    Moutain m =new Moutain();
    Clouds cl = new Clouds();
    Trees t = new Trees();
    Night n = new Night();


    public void paint(Graphics g){

        Color c =  new Color(0, 162, 232);

        //Calling instance of sun
        s.sun(g);

        //Calling instance of mountain
        m.mountain(g);

        //Calling instance of ferris
        f.ferris(g);

        //Calling instance of water
        m.water(g);

        //Setting background color
        setBackground(c);

        //Calling instance of ground
        gd.ground(g);

        //Calling instance of sea saw
        ss.seaSaw(g);
        //Calling instance of kite
        k.kite(g);


        //Calling instance of clouds with arguments for the object
        cl.clouds(g,-50,-35, 50);
        cl.clouds(g,320,40, 50);
        cl.clouds(g,620,0, 50);
        cl.clouds(g,950,20, 50);

        //Calling instance of trees
        t.trees(g,0,0);
        t.trees(g,70,10);


        //paint2(g);
    }


    public void paint2(Graphics g){
        //Night
        n.night(g);

        //Calling instance of ferris
        f.ferris(g);

        //Setting background color
        setBackground(Color.DARK_GRAY);

        //Calling instance of ground
        gd.ground(g);

        //Calling instance of sea saw
        ss.seaSaw(g);
        //Calling instance of kite
        k.kite(g);
        //Calling instance of mountain
        m.mountain(g);

        //Calling instance of trees
        t.trees(g,0,0);
        t.trees(g,70,10);
    }
}
