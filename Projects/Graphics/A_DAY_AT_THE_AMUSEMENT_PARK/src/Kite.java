import java.applet.Applet;
import java.awt.*;

public class Kite extends Applet {

    GraphicsPrimitives gp = new GraphicsPrimitives();

    public void kite(Graphics g){

        //Kite

        //drawing out kite
        Color c = new Color(195,195,195);
        g.setColor(Color.black);
        gp.negativeLine(330,170, 360, 1080,g);
        gp.positiveLine(330,170, 360, 1080, g);
        gp.negativeLine(360,200, 390, 1080,g);
        gp.positiveLine(300,200, 330, 1080, g);

        //colouring kite
        for (int i = 0; i < 32; i++) {
            g.setColor(c);
            gp.negativeLine(329+i,169+i, 360+i, 200+i,g);

        }

        //rope of kite
        g.setColor(c);
        gp.arc3(628,230, 300, g);
        gp.arc7(235,620, 250, g);

    }
}
