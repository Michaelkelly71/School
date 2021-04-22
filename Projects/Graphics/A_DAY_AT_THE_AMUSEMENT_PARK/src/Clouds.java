import java.applet.Applet;
import java.awt.*;

public class Clouds extends Applet {
    GraphicsPrimitives gp = new GraphicsPrimitives();

    public void clouds(Graphics g, int x, int y, int r){
        //Cloud

        g.setColor(Color.white);

        Color c = new Color(255,255,255);

        for (int i = -1; i >= -150; i--) {
            g.setColor(c);

            //left semi-circle of cloud
            gp.arc8(100+x-i,100+y,r,g);
            gp.arc1(100+x-i,100+y,r,g);
            gp.arc2(100+x-i,100+y,r,g);
            gp.arc3(100+x-i,100+y,r,g);
            gp.arc4(100+x-i,100+y,r,g);
            gp.arc5(100+x-i,100+y,r,g);

            //right semi-circle of cloud
            gp.arc8(260+x+i,100+y,r,g);
            gp.arc1(260+x+i,100+y,r,g);
            gp.arc4(260+x+i,100+y,r,g);
            gp.arc5(260+x+i,100+y,r,g);
            gp.arc6(260+x+i,100+y,r,g);
            gp.arc7(260+x+i,100+y,r,g);
        }

        for (int i = -1; i >= -50; i--) {
            g.setColor(c);

            //top semi-circle of cloud
            gp.arc7(150+x,50+y-i,r,g);
            gp.arc8(150+x,50+y-i,r,g);
            gp.arc1(150+x,50+y-i,r,g);
            gp.arc2(150+x,50+y-i,r,g);

            //button semi-circle of cloud
            gp.arc3(150+x,150+y+i,r,g);
            gp.arc4(150+x,150+y+i,r,g);
            gp.arc5(150+x,150+y+i,r,g);
            gp.arc6(150+x,150+y+i,r,g);

            //right side cloud closer
            gp.arc1(210+x,50+y-i,r,g);
            gp.arc8(210+x,50+y-i,r,g);
            gp.arc7(210+x,50+y-i,r,g);

            gp.arc6(210+x,150+y+i,r,g);
            gp.arc5(210+x,150+y+i,r,g);
            gp.arc4(210+x,150+y+i,r,g);


        }

        g.setColor(Color.black);
        gp.negativeLine(108,50, 138, 80,g);
        gp.positiveLine(50,50, 80, 80, g);


    }
}
