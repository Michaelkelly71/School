import java.applet.Applet;
import java.awt.*;

public class Ground extends Applet {

    GraphicsPrimitives gp = new GraphicsPrimitives();

    public void ground(Graphics g){
        //Ground

        Color c = new Color(23,123,53);

        gp.horizontalLine(150,596,1400, g);
        for (int i = 0; i < 200; i++) {
            g.setColor(c);
            gp.horizontalLine(150,596+i,1400, g);
        }

        gp.groundhEllipse(90,477, 120, g);
        for (int i = 0; i < 200; i++) {
            g.setColor(c);
            gp.groundhEllipse(90,477, 120+i, g);
        }

        //water on ground
        g.setColor(Color.black);
        gp.hEllipse(544,771,175, g);
        gp.hEllipse(604,771,175, g);

        Color w = new Color(153, 217, 234);
        for (int i = 1; i < 60; i++) {
            g.setColor(w);
            gp.hEllipse(544+i,771,175, g);


        }
    }
}
