import java.applet.Applet;
import java.awt.*;

public class Sea_Saw extends Applet {

    GraphicsPrimitives gp = new GraphicsPrimitives();

    public void seaSaw(Graphics g){

        //Sea - Saw
        g.setColor(Color.black);
        gp.horizontalLine(190,570,360, g);
        gp.negativeLine(280,570, 307, 1080,g);
        gp.positiveLine(280,570, 307, 1080, g);

    }
}
