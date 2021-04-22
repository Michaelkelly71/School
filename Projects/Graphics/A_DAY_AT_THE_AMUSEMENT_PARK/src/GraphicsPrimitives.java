import java.awt.*;

public class GraphicsPrimitives {
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

    public  void tweakedvertEllipse (int xc, int yc, int r, Graphics g)
    {
        int x0 = 0;
        int y0 = r;

        int p0 = (5/4) - r;

        while(x0 <= y0)
        {
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

    public  void tweakedvertEllipse2 (int xc, int yc, int r, Graphics g)
    {
        int x0 = 0;
        int y0 = r;

        int p0 = (5/4) - r;

        while(x0 <= y0)
        {
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
//            g.drawString(".",d*(xc+xo),yc-yo);//1st clockwise
//            g.drawString(".",d*(xc+yo),yc-xo);//2nd clockwise
//            g.drawString(".",d*(xc+yo),yc+xo);//3rd clockwise
//            g.drawString(".",d*(xc+xo),yc+yo);//4th clockwise
//            g.drawString(".",d*(xc-xo),yc+yo);//5th clockwise
//            g.drawString(".",d*(xc-yo),yc+xo);//6th clockwise
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

    public void arc1(int x_axis, int y_axis, int radius, Graphics g){

        int x0 = 0;
        int y0; y0 = radius;


        int p0 = (5/4) - radius;

        while(x0 <= y0){

            g.drawString(".", x_axis - x0,y_axis - y0); //1st arc from the top of circle anticlockwise




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

    public void arc2(int x_axis, int y_axis, int radius, Graphics g){

        int x0 = 0;
        int y0; y0 = radius;


        int p0 = (5/4) - radius;

        while(x0 <= y0){

            g.drawString(".", x_axis - y0,y_axis - x0); //2nd arc from the top of circle anticlockwise

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

    public void arc3(int x_axis, int y_axis, int radius, Graphics g){

        int x0 = 0;
        int y0; y0 = radius;


        int p0 = (5/4) - radius;

        while(x0 <= y0){


            g.drawString(".", x_axis - y0,y_axis + x0); //3rd arc from the top of circle anticlockwise

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

    public void arc4(int x_axis, int y_axis, int radius, Graphics g){

        int x0 = 0;
        int y0; y0 = radius;


        int p0 = (5/4) - radius;

        while(x0 <= y0){


            g.drawString(".", x_axis - x0,y_axis + y0); //4th arc from the top of circle anticlockwise

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

    public void arc5(int x_axis, int y_axis, int radius, Graphics g){

        int x0 = 0;
        int y0; y0 = radius;


        int p0 = (5/4) - radius;

        while(x0 <= y0){

            g.drawString(".", x_axis + x0,y_axis + y0); //5th arc from the top of circle anticlockwise

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

    public void arc6(int x_axis, int y_axis, int radius, Graphics g){

        int x0 = 0;
        int y0; y0 = radius;


        int p0 = (5/4) - radius;

        while(x0 <= y0){

            g.drawString(".", x_axis + y0,y_axis + x0); //6th arc from the top of circle anticlockwise

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

    public void arc7(int x_axis, int y_axis, int radius, Graphics g){

        int x0 = 0;
        int y0; y0 = radius;


        int p0 = (5/4) - radius;

        while(x0 <= y0){

            g.drawString(".", x_axis + y0,y_axis - x0); //7th arc from the top of circle anticlockwise

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

    public void arc8(int x_axis, int y_axis, int radius, Graphics g){

        int x0 = 0;
        int y0; y0 = radius;


        int p0 = (5/4) - radius;

        while(x0 <= y0){

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

    public void negativeLine(int a, int b, int a1, int b1, Graphics g)
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

}
