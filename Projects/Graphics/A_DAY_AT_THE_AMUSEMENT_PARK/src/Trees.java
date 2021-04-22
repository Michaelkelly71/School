import java.applet.Applet;
import java.awt.*;

public class Trees extends Applet {

    GraphicsPrimitives gp = new GraphicsPrimitives();

    public void trees(Graphics g, int x, int y){

        Color c = new Color(34,177,76);
        Color t1 = new Color(185, 122, 87);

        g.setColor(Color.black);
        gp.verticalLine(68, 550, 700, g);
        gp.verticalLine(84, 550, 700, g);
        gp.verticalLine(136, 560, 710, g);
        gp.verticalLine(152, 560, 710, g);


        for (int i = 1; i <= 15; i++) {

            g.setColor(t1);
            gp.verticalLine(68+i, 550, 710, g);
            gp.verticalLine(136+i, 560, 710, g);

        }

        //Outlining the tree
        g.setColor(Color.black);
        //top semi-circle of tree
        gp.arc7(75+x,475+y,30,g);
        gp.arc8(75+x,475+y,30,g);
        gp.arc1(75+x,475+y,30,g);
        gp.arc2(75+x,475+y,30,g);

        //button semi-circle of tree
        gp.arc3(75+x,525+y,30,g);
        gp.arc4(75+x,525+y,30,g);
        gp.arc5(75+x,525+y,30,g);
        gp.arc6(75+x,525+y,30,g);

        g.setColor(Color.black);
        //right semi-circle of tree
        gp.arc8(100+x,500+y,30,g);
        gp.arc1(100+x,500+y,30,g);
        gp.arc4(100+x,500+y,30,g);
        gp.arc5(100+x,500+y,30,g);
        gp.arc6(100+x,500+y,30,g);
        gp.arc7(100+x,500+y,30,g);

        g.setColor(Color.black);
        //left semi-circle of tree
        gp.arc1(50+x,500+y,30,g);
        gp.arc2(50+x,500+y,30,g);
        gp.arc3(50+x,500+y,30,g);
        gp.arc4(50+x,500+y,30,g);
        gp.arc5(50+x,500+y,30,g);


        for (int i = 1; i <= 50; i++) {

            g.setColor(c);
            //left semi-circle of tree
            gp.arc8(50+x+i,500+y,30,g);
            gp.arc1(50+x+i,500+y,30,g);
            gp.arc2(50+x+i,500+y,30,g);
            gp.arc3(50+x+i,500+y,30,g);
            gp.arc4(50+x+i,500+y,30,g);
            gp.arc5(50+x+i,500+y,30,g);

            //right semi-circle of tree
            gp.arc8(100+x-i,500+y,30,g);
            gp.arc1(100+x-i,500+y,30,g);
            gp.arc4(100+x-i,500+y,30,g);
            gp.arc5(100+x-i,500+y,30,g);
            gp.arc6(100+x-i,500+y,30,g);
            gp.arc7(100+x-i,500+y,30,g);
        }

        for (int i = 1; i <= 56; i++) {
            g.setColor(c);

            //top semi-circle of tree
            gp.arc7(75+x,475+y+i,30,g);
            gp.arc8(75+x,475+y+i,30,g);
            gp.arc1(75+x,475+y+i,30,g);
            gp.arc2(75+x,475+y+i,30,g);

            //button semi-circle of tree
            gp.arc3(75+x,525+y-i,30,g);
            gp.arc4(75+x,525+y-i,30,g);
            gp.arc5(75+x,525+y-i,30,g);
            gp.arc6(75+x,525+y-i,30,g);

        }


    }
}
