import java.applet.Applet;
import java.awt.*;

public class Sun extends Applet {

    GraphicsPrimitives gp = new GraphicsPrimitives();

    public void sun(Graphics g){

        /**
         * code for sun
         */
        Color c = new Color(255,214,72);

        //Sun
        for (int i = -1; i < 10; i--) {
            g.setColor(c);
            gp.circle(1367, 40, 50+i, g);
        }

        //suns brightness
        g.setColor(Color.black);
        gp.horizontalLine(1280,  2, 1338, g);
        gp.positiveLine(1280,  2,  1320,  40, g);          // 1st line backwards slanted
        gp.negativeLine(1320,  40,  1360,  140, g);        // 2nd line forwards slanted
        gp.horizontalLine(1280,  80, 1340, g);                // 3rd line flat line
        gp.positiveLine(1340,  81,  1370,  123, g);        // 4rd line backwards slanted
        gp.negativeLine(1395,  81,  1425,  123, g);        // 5nth line forwards slanted


        for (int i = 1; i < 35; i++) {
            g.setColor(c);
            gp.horizontalLine(1281+i+(2),  2+i, 1338, g);
            gp.horizontalLine(1281+i+(2),  79-i, 1340, g);
        }

        for (int i = 1; i < 15; i++) {
            g.setColor(c);
            gp.negativeLine(1394-i,  81,  1423-i*(2),  123, g);
            gp.positiveLine(1340+i+(2),  81,  1370,  123, g);

        }

        g.setColor(Color.black);
        gp.circle(1367, 40, 50, g);
    }


}
