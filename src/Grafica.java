import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class Grafica extends JComponent implements Runnable {

    Thread random;
    double angleStart1=0.0, angleExtent1, angleStart2, angleExtent2, angleStart3, angleExtent3, angleStart4, angleExtent4;
    double a,b,c,d, total;

    private static double getRandom(){
        return ((Math.random() * (1500 - 100)) + 100);
    }

    public Grafica(){
        random = new Thread(this);
        random.start();
    }

    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;

        Arc2D.Double arc = new Arc2D.Double(Arc2D.PIE);
        arc.setFrame(getWidth()/4,getHeight()/4,250,250);

        arc.setAngleStart(angleStart1);
        arc.setAngleExtent(angleExtent1);
        g2.setColor(new Color(221,160,221));
        g2.draw(arc);
        g2.fill(arc);

        arc.setAngleStart(angleStart2);
        arc.setAngleExtent(angleExtent2);
        g2.setColor(new Color(244, 164, 96));
        g2.draw(arc);
        g2.fill(arc);

        arc.setAngleStart(angleStart3);
        arc.setAngleExtent(angleExtent3);
        g2.setColor(new Color(173, 216, 230));
        g2.draw(arc);
        g2.fill(arc);

        arc.setAngleStart(angleStart4);
        arc.setAngleExtent(angleExtent4);
        g2.setColor(new Color(152, 251, 152));
        g2.draw(arc);
        g2.fill(arc);
    }

    public void run(){
        while(true){
            a=getRandom();
            b=getRandom();
            c=getRandom();
            d=getRandom();
            total = a+b+c+d;
            angleExtent1=(a/total)*360;
            angleExtent2=(b/total)*360;
            angleExtent3=(c/total)*360;
            angleExtent4=(d/total)*360;
            angleStart2=angleStart1+angleExtent1;
            angleStart3=angleStart2+angleExtent2;
            angleStart4=angleStart3+angleExtent3;
            repaint();
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){
                System.out.println("Error");
            }
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Gráfica :)");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(new Color(255, 235, 205));
        frame.setSize(500, 500);

        Grafica pie = new Grafica();
        frame.add(pie);
        frame.setVisible(true);
    }
}


