import java.applet.Applet;
import java.awt.*;

public class Moutain extends Applet {
    GraphicsPrimitives gp = new GraphicsPrimitives();

    public void mountain(Graphics g){
        /**
         * code for mountain
         */

        Color c = new Color(127,127,127);
        g.setColor(Color.black);
        gp.vertEllipse(1400, 228, 90, g);
        gp.tweakedvertEllipse(1320, 245, 70, g);
        gp.tweakedvertEllipse(1255, 260, 50, g);
        gp.tweakedvertEllipse(1205, 275, 30, g);
        gp.tweakedvertEllipse2(1180, 298, 30, g);

        for (int i = 1; i < 90; i++) {
            g.setColor(c);
            gp.vertEllipse(1401+i, 228, 90, g);
            gp.tweakedvertEllipse(1321+i, 245, 70, g);
            gp.tweakedvertEllipse(1255+i, 260, 50, g);
            gp.tweakedvertEllipse(1205+i, 275, 30, g);
            gp.tweakedvertEllipse2(1180, 298, 30-i, g);

        }

    }

    public void water(Graphics g) {
        //Outlining the hole of water
        g.setColor(Color.black);
        //top semi-circle of tree
        gp.arc7(1320,460,40,g);
        gp.arc8(1320,460,40,g);
        gp.arc1(1320,460,40,g);
        gp.arc2(1320,460,40,g);

        //coloring it
        for (int i = 1; i <= 30; i++) {

            g.setColor(Color.black);
            //left semi-circle of tree
            gp.arc7(1320, 460, 40-i, g);
            gp.arc8(1320, 460, 40-i, g);
            gp.arc1(1320, 460+i, 40-i, g);
            gp.arc2(1320, 460+i, 40-i, g);

        }

        Color w = new Color(153, 217, 234);

        g.setColor(Color.black);
        gp.negativeLine(1295, 450, 1440, 860, g);
        gp.negativeLine(1355, 450, 1500, 860, g);

        for (int i = 1; i < 30; i++) {
            g.setColor(w);
            gp.negativeLine(1295 + i, 450 + i, 1440 + i, 860 + i, g);
            gp.negativeLine(1355-i-i, 450, 1500, 860, g);

        }


    }
}
