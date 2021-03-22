import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W=800, H=600;
    BufferedImage image;
    Graphics2D graphics;

    public DrawingPanel(MainFrame frame){
        this.frame= frame;
        createOffscreenImage();

    }
    private void createOffscreenImage(){
        image= new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics= image.createGraphics();
        graphics.setBackground(Color.WHITE);
        graphics.fillRect(0,0,W,H);
        init();
    }
    private void init(){
        setPreferredSize(new Dimension(W, H));
        setBorder(BorderFactory.createEtchedBorder());
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY()); repaint();
            }
        });
    }
    private void drawShape(int x, int y){
        int radius= ((int)(Math.random()*1000000))%100;

        int sides= (int)frame.configPanel.sidesField.getValue();
        //System.out.println("Valoare Sides 1 " + sides1);
        int R = (int)(Math.random()*256);
        int B = (int)(Math.random()*256);
        int G = (int)(Math.random()*256);
        Color color = new Color(R, G, B);

        graphics.setColor(color);
        graphics.fill(new RegularPolygon(x, y, radius, sides));
    }
    @Override
    public void update(Graphics g) { }
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }

}
