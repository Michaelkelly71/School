import java.applet.Applet;
import java.awt.*;

public class Ferris extends Applet {
    GraphicsPrimitives gp = new GraphicsPrimitives();

    public void ferris(Graphics g){
        /**
         * code for ferris wheel
         */
        g.setColor(Color.black);
        gp.circle(700, 400, 150, g);                           // wheel's outer circle
        gp.circle(705, 400, 30, g);                            // wheel's inner circle


    g.setColor(Color.black);
        // Octagon in ferris
        gp.horizontalLine(620, 300,780,g);                             //
        gp.negativeLine(620,300, 670, 400,g);
        gp.verticalLine(570, 350, 450, g);
        gp.positiveLine(570,450, 620, 530,g);
        gp.horizontalLine(620, 500,780,g);
        gp.positiveLine(780,300, 830, 400,g);
        gp.verticalLine(830, 350, 450, g);
        gp.negativeLine(830,450, 880, 550,g);


        // Ferris Stand
        gp.horizontalLine(685, 400,725,g);                             // bar for stand
        gp.negativeLine(685,400, 880, 810,g);                      // left stand outer forwards slanted line
        gp.positiveLine(725,400, 920, 810, g);
        gp.negativeLine(705,410, 890, 810,g);
        gp.positiveLine(705,410, 890, 810, g);
        gp.horizontalLine(490,595, 520, g);
        gp.horizontalLine(890,595, 920, g);

        //object for colors
        Color c = new Color(127,127,127);
        Color c1 = new Color(195,195,195);

        //color for stand
        for (int i = 1; i < 15; i++) {
            g.setColor(c);
            gp.negativeLine(685+i,400+i, 880+i, 810+i,g);
            gp.positiveLine(725-i,400+i, 920-i, 810+i, g);

        }
        //color for stand
        for (int i = 1; i < 14; i++) {
            g.setColor(c);
            gp.horizontalLine(685, 400+i,725,g);

        }

        //color for horizontals upwards
        for (int i = 1; i < 45; i++) {
            g.setColor(c1);
            gp.horizontalLine(620+i, 300-i,780-i,g);
            gp.horizontalLine(620+i, 500+i,780-i,g);

        }

        //color for horizontals downwards
        for (int i = 1; i < 11; i++) {
            g.setColor(c1);
            gp.horizontalLine(620-i, 300-i,780+i,g);
            gp.horizontalLine(620-i, 500+i,780+i,g);

            gp.verticalLine(830+i, 350, 450, g);
            gp.verticalLine(570-i, 350, 450, g);

        }

        //color for ferris outer circle
        for (int i = -1; i >= -9; i--) {
            g.setColor(c1);
            gp.circle(700, 400, 150+i, g);
        }

        //Color for 3 small circles at the top of ferris
        g.setColor(Color.red);
        gp.circle(650, 285, 12, g);

        g.setColor(Color.yellow);
        gp.circle(705, 275, 15, g);

        g.setColor(Color.green);
        gp.circle(760, 285, 12, g);


    }
}
