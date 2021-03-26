import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

    public class FreeDrawing extends JPanel implements  MouseListener, MouseMotionListener {
    List<Points> positions= new ArrayList<Points>();
    float startX,startY, finishX, finishY;
    final Frame frame;
    Graphics2D graphics;

    public FreeDrawing(MainFrame frame, Graphics2D graphics){
        super();
        System.out.println("Hei");
        this.graphics= graphics;
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.frame= frame;
        frame.add(this);
        setBackground(Color.BLUE);
        frame.setVisible(true);
        System.out.println("Heiyo");

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("efse");

        startX=e.getX(); startY= e.getY();
        System.out.println(startX + startY);

        repaint();

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("hahah");
        repaint();

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Hoo");

        positions.add(new Points(e.getX(), e.getY()));
        System.out.println(positions.get(positions.size()).x);
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
        public void paintComponent(Graphics g) {
            super.paintComponents(g);
            for (int i = 0; i < positions.size()-2; i++) {
                g.drawLine((int)positions.get(i).x,(int) positions.get(i).y, (int)positions.get(i+1).x, (int)positions.get(i+1).y);
            }
            System.out.println("Helloo");
        }

}

class Points{
    float x, y;
    public Points(float x, float y){
        this.x=x; this.y=y;
    }
}
