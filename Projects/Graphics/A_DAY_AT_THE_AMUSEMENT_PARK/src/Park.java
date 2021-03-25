import java.applet.Applet;
import java.awt.Graphics;


public class Park extends Applet
{
    final static int width = 1400;
    final static int height = 773;
    public  void init(){
        resize(width,height);
    }

    private static final long serialVersionUID = 1L;




    public  void vertEllipse (int xc, int yc, int r, Graphics g)
    {
        int x0 = 0;
        int y0 = r;

        int p0 = (5/4) - r;

        while(x0 <= y0)
        {
            //sectors
            g.drawString(".", xc + x0, 2 * (yc - y0));//1st clockwise
            g.drawString(".", xc + y0, 2 * (yc - x0));//2nd clockwise
            g.drawString(".", xc + y0, 2 * (yc + x0));//3rd clockwise
            g.drawString(".", xc + x0, 2 * (yc + y0));//4th clockwise
            g.drawString(".", xc - x0, 2 * (yc + y0));//5th clockwise
            g.drawString(".", xc - y0, 2 * (yc + x0));//6th clockwise
            g.drawString(".", xc - y0, 2 * (yc - x0));//7th clockwise
            g.drawString(".", xc - x0, 2 * (yc - y0));//8th clockwise

            x0++;
            if (p0 < 0)
            {
                p0 = p0 + ((2 * x0) + 2) + 1;
            }
            else
            {
                x0++;
                y0--;
                p0 = p0 + ((2 * x0) + 2) + 1 - ((2 * y0) - 2);
            }
        }

    }

    public void hEllipse(int centerX,int centerY,int r,Graphics g)
    {
        int xo=0;
        int yo=r;

        int rad=r*2;
        int d=rad/r;

        int Po=(5/4)-r;

        int xc; xc = centerX;
        int yc; yc = centerY;

        while(xo<yo)
        {
            //sectors
            g.drawString(".",d*(xc+xo),yc-yo);//1st clockwise
            g.drawString(".",d*(xc+yo),yc-xo);//2nd clockwise
            g.drawString(".",d*(xc+yo),yc+xo);//3rd clockwise
            g.drawString(".",d*(xc+xo),yc+yo);//4th clockwise
            g.drawString(".",d*(xc-xo),yc+yo);//5th clockwise
            g.drawString(".",d*(xc-yo),yc+xo);//6th clockwise
            g.drawString(".",d*(xc-yo),yc-xo);//7th clockwise
            g.drawString(".",d*(xc-xo),yc-yo);//8th clockwise

            xo++;
            if(Po<0)
            {
                Po=Po+((2*xo)+2)+1;
            }
            else
            {
                yo--;
                Po=Po+((2*xo)+2)+1-((2*yo)-2);
            }
        }
    }

    public void circle(int x_axis, int y_axis, int radius, Graphics g){

        int x0 = 0;
        int y0; y0 = radius;


        int p0 = (5/4) - radius;

        while(x0 <= y0){

            g.drawString(".", x_axis - x0,y_axis - y0); //1st arc from the top of circle anticlockwise
            g.drawString(".", x_axis - y0,y_axis - x0); //2nd arc from the top of circle anticlockwise
            g.drawString(".", x_axis - y0,y_axis + x0); //3rd arc from the top of circle anticlockwise
            g.drawString(".", x_axis - x0,y_axis + y0); //4th arc from the top of circle anticlockwise
            g.drawString(".", x_axis + x0,y_axis + y0); //5th arc from the top of circle anticlockwise
            g.drawString(".", x_axis + y0,y_axis + x0); //6th arc from the top of circle anticlockwise
            g.drawString(".", x_axis + y0,y_axis - x0); //7th arc from the top of circle anticlockwise
            g.drawString(".", x_axis + x0,y_axis - y0); //8th arc from the top of circle anticlockwise



            x0++; //Increment for x_axis

            if(p0 < 0)
            {
                p0 = p0 + ((2 * x0) + 2) + 1;
            }
            else
            {
                y0--;
                p0 = p0 + ((2 * x0) + 2) + 1 - ((2 * y0) - 2);
            }
        }
    }


    public void verticalLine(int x1, int y1, int y2,Graphics g)// put pixel for line points
    {
        int dy;
        dy = y2 - y1;
        for (int i = 0; i <= dy; i++) {
            g.drawString(".", x1, y1);

            y1++; //increment of steps
        }
    }

    public void horizontalLine(int x1, int y1, int x2,Graphics g)// put pixel for line points
    {
        int dx;
        dx = x2 - x1;
        for (int i = 0; i <= dx; i++) {
            g.drawString(".", x1,y1);

            x1++; //increment of steps
        }
    }

    public void positiveLine(int x1, int y1, int x2, int y2,Graphics g)
    {
        int dx, dy;

        dx = x2 - x1;
        dy = y2 - y1;

        int slope = dy / dx;

        for (int i = 0; i <= dy; i++) {
            g.drawString(".", x1,y1);

            x1++; //increment of steps
            y1++; //increment of steps
        }
    }

    public void negativeLine(int x1, int y1, int x2, int y2,Graphics g)// put pixel for line points
    {
        int dx, dy;

        dx = x2 - x1;
        dy = y2 - y1;

        for (int i = 0; i < dx; i++) {
            g.drawString(".", x1,y1);

            x1--; //increment of steps
            y1++; //increment of steps
        }
    }




    public void paint(Graphics g){

        /**
         * code for sun
         */
        circle(1319, 40, 50, g);    //Sun

        //suns brightness
        positiveLine(1318,  0,  1348,  40, g);          // 1st line backwards slanted
        negativeLine(1348,  36,  0,  80, g);            // 2nd line forwards slanted
        horizontalLine(1320,  75, 1440, g);               // 3rd line flat line
        positiveLine(1380,  75,  1410,  320, g);        // 4rd line backwards slanted
        //negativeLine(100,  100,  200,  200, g);         // 5nth line forwards slanted



        /**
         * code for ferris wheel
         */
        circle(700, 400, 150, g);                           // wheel's outer circle
        circle(705, 400, 30, g);                            // wheel's inner circle

        // Octagon in ferris
        horizontalLine(700, 300,800,g);

        // Ferris Stand
        horizontalLine(685, 400,800,g);             // bar for stand
        negativeLine(685,400, 800, 800,g);               // left stand outer forwards slanted line







    }
}
