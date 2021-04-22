import java.applet.Applet;
import java.awt.*;

public class Night extends Applet {
    GraphicsPrimitives gp = new GraphicsPrimitives();

    public void night(Graphics g){
        //Ground

        g.setColor(Color.black);
        gp.verticalLine(1400, 0, 773, g);

        for (int i = 0; i <= 1400; i++) {
            g.setColor(Color.white);
            gp.verticalLine(1400-i, 0, 773, g);
        }
    }
}
