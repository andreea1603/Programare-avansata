import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

    public class FreeDrawing extends JPanel implements  MouseListener {
    List<Points> positions= new ArrayList<Points>();
    float startX,startY, finishX, finishY;
    final Frame frame;
        BufferedImage image;

        Graphics2D graphics;

    public FreeDrawing(MainFrame frame, Graphics2D graphics, BufferedImage image){
        super();
        this.frame= frame;
        this.graphics= graphics;
        this.image= image;
        this.addMouseListener
                (new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {

                            System.out.println("intru aici sia");
                    }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                        System.out.println("intru aihhhi sia");

                    }

                    @Override
                    public void mouseDragged(MouseEvent e) {
                        System.out.println("intru efesakye sia");
                    }
                });
        frame.getContentPane().add(this);
        frame.add(this);
        frame.setVisible(true);
        setBackground(Color.BLUE);

    }


        public void paintComponent(Graphics g) {
            super.paintComponents(g);
            for (int i = 0; i < positions.size()-2; i++) {
                g.drawImage(image,0,0,this);
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("intru efeakye sia");

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println("intru aihhhi sia");

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

