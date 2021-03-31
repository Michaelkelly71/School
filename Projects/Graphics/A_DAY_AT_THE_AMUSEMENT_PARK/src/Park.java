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

    public void groundhEllipse(int centerX,int centerY,int r,Graphics g)
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
            g.drawString(".",d*(xc-xo),yc+yo);//5th clockwise
            g.drawString(".",d*(xc-yo),yc+xo);//6th clockwise

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

    public void positiveLine(int a, int b, int a1, int b1, Graphics g)
    {
        int x1=a;
        int y1=b;
        int x2=a1;
        int y2=b1;
        int dx=x2-x1;
        int dy=y2-y1;
        int tdx=-5*dx;
        int tdy=2*dy;
        int p=2*dy-dx;

        for(int k=0;k<dx;k++)
        {
            g.drawString(".",x1,y1);
            if(p<0)
            {
                x1++;
                p=tdy-dx;
            }
            else
            {
                x1++;
                y1++;
                p=p+tdy-tdx;
            }
        }
    }

    public void negativeLine(int a,int b,int a1,int b1,Graphics g)
    {
        int x1=a;
        int y1=b;
        int x2=a1;
        int y2=b1;
        int dx=x2-x1;
        int dy=y2-y1;
        int tdy=2*dy;
        int p=2*dy-dx;

        for(int k=0;k<dx;k++)
        {
            g.drawString(".",x1,y1);
            if(p<0)
            {
                x1++;
                y1--;

                p=p+tdy;
            }
            else
            {
                x1--;
                y1++;

                p=p+tdy-(2*dx);
            }
        }
    }

    public  void string (int xc, int yc, int r, Graphics g)
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




    public void paint(Graphics g){

        /**
         * code for sun
         */
        circle(1367, 40, 50, g);    //Sun


        //suns brightness
        horizontalLine(1280,  2, 1338, g);
        positiveLine(1280,  2,  1320,  40, g);          // 1st line backwards slanted
        negativeLine(1320,  40,  1360,  140, g);            // 2nd line forwards slanted
        horizontalLine(1280,  80, 1340, g);               // 3rd line flat line
        positiveLine(1340,  81,  1370,  123, g);        // 4rd line backwards slanted
        negativeLine(1395,  81,  1425,  123, g);         // 5nth line forwards slanted



        /**
         * code for ferris wheel
         */
        circle(700, 400, 150, g);                           // wheel's outer circle
        circle(705, 400, 30, g);                            // wheel's inner circle
        circle(650, 285, 12, g);
        circle(705, 275, 15, g);
        circle(760, 285, 12, g);




        // Octagon in ferris
        horizontalLine(620, 300,780,g);                             //
        negativeLine(620,300, 670, 400,g);
        verticalLine(570, 350, 450, g);
        positiveLine(570,450, 620, 530,g);
        horizontalLine(620, 500,780,g);
        positiveLine(780,300, 830, 400,g);
        verticalLine(830, 350, 450, g);
        negativeLine(830,450, 880, 550,g);



        // Ferris Stand
        horizontalLine(685, 400,725,g);                             // bar for stand
        negativeLine(685,400, 880, 810,g);                      // left stand outer forwards slanted line
        positiveLine(725,400, 920, 810, g);
        negativeLine(705,410, 890, 810,g);
        positiveLine(705,410, 890, 810, g);
        horizontalLine(490,595, 520, g);
        horizontalLine(890,595, 920, g);

        //Ground
        horizontalLine(150,596,1440, g);
        groundhEllipse(90,477, 120, g);


        //Sea - Saw
        horizontalLine(190,570,360, g);
        negativeLine(280,570, 307, 1080,g);
        positiveLine(280,570, 307, 1080, g);

        //Kite
        negativeLine(330,170, 360, 1080,g);
        positiveLine(330,170, 360, 1080, g);
        negativeLine(360,200, 390, 1080,g);
        positiveLine(300,200, 330, 1080, g);

    }
}
