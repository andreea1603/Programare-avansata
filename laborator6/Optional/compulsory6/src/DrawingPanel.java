import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DrawingPanel extends JPanel implements MouseMotionListener {
    final MainFrame frame;
    final static int W=800, H=600;
    BufferedImage image;
    Graphics2D graphics;
    int xi, yi, xf, yf;
    List<Shape> shapes= new ArrayList<Shape>();
    List<Points> positions= new ArrayList<Points>();


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
        //FreeDrawing f= new FreeDrawing(this.frame, this.graphics);
        this.addMouseMotionListener(this);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xi = e.getX();
                yi = e.getY();
                addMouseMotionListener(this);

                if (((String) frame.newPanel.typeOfShape.getSelectedItem()).compareTo("polygon") == 0 || ((String) frame.newPanel.typeOfShape.getSelectedItem()).compareTo("circle") == 0) {
                    xi = e.getX();
                    yi = e.getY();
                    xf = -1;
                    yf = -1;
                    drawShape(e.getX(), e.getY());
                    repaint();
                }
            } //Can’t use lambdas, JavaFX does a better job in these cases
            @Override
            public void mouseReleased(MouseEvent e) {

                if (((String) frame.newPanel.typeOfShape.getSelectedItem()).compareTo("freedrawing") == 0) {
                    xf = e.getX();
                    yf = e.getY();
                    drawFree(xi, yi, xf, yf);
                    System.out.println("hei, sunt aici");
                }
                if (((String) frame.newPanel.typeOfShape.getSelectedItem()).compareTo("drawlines") == 0){
                    xf = e.getX();
                    yf = e.getY();
                    drawShape(xi, yi, xf, yf);
                }
                repaint();

                positions.clear();

            }
        }

        );

    }
    private void drawFree(int xi, int yi,int  xf, int yf){
        System.out.println("aM apelat free");
        graphics.setColor(Color.black);
        repaint();
        for(int i=0; i<positions.size()-1; i++)
            graphics.drawLine((int)positions.get(i).x, (int)positions.get(i).y, (int)positions.get(i+1).x, (int)positions.get(i+1).y);

    }
    private void drawShape(int x, int y, int xf, int yf){
        int difX=(int)(positions.get(0).x-positions.get(positions.size()-1).x);
        System.out.println(" x: " + positions.get(0).x +  " y : " + positions.get(positions.size()-1).x);
        int difY=(int)(positions.get(0).y-positions.get(positions.size()-1).y);
        int up=0, left=0;
        int ok=1;
        System.out.println(difX);
        System.out.println("intra aici");
        if(difX>0) {
            left = 1;
            System.out.println("Merge la stanga");
        }
        if(difY>0){
            up=1;
            System.out.println("Merge sus");
        }

        for(int i=0; i<positions.size()-1; i++)
        {
                if( up==1 && left==1 && (positions.get(i).x-60>positions.get(0).x || positions.get(i).x<positions.get(positions.size()-1).x-60 || positions.get(i).y-60>positions.get(positions.size()-1).y || positions.get(i).y<positions.get(0).y-100))
                {
                    ok=0;
                }
                if(up==1 && left==0 && (positions.get(i).x<positions.get(0).x-60 || positions.get(i).x-60>positions.get(positions.size()-1).x || positions.get(i).y -60>positions.get(positions.size()-1).y|| positions.get(i).y<positions.get(0).y-100)){
                    ok=0;
                }

            }
        if(ok==1) {
            System.out.println("heeei:");
            graphics.setColor(Color.black);
            graphics.drawLine(x, y, xf, yf);
        }
    }
    private void drawShape(int x, int y)  {

        if(((String)this.frame.configPanel.drawDelete.getSelectedItem()).compareTo("delete")==0){
            delete(x, y);
        }
        else {
            if (((String) this.frame.newPanel.typeOfShape.getSelectedItem()).compareTo("polygon") == 0) {
                frame.configPanel.label.setText("Number of sides");
                frame.configPanel.sidesField.addItem(new String("3"));
                frame.configPanel.sidesField.addItem(new String("4"));
                frame.configPanel.sidesField.addItem(new String("5"));
                frame.configPanel.sidesField.addItem(new String("6"));
                frame.configPanel.sidesField.addItem(new String("7"));
                frame.configPanel.sidesField.addItem(new String("8"));
                frame.configPanel.sidesField.addItem(new String("9"));
                frame.configPanel.sidesField.addItem(new String("10"));


                int radius = ((int) (Math.random() * 1000000)) % 100;

                int sides = Integer.parseInt(((String)frame.configPanel.sidesField.getSelectedItem()));
                int size = (int) frame.configPanel.sizeField.getValue();
                int R = (int) (Math.random() * 256);
                int B = (int) (Math.random() * 256);
                int G = (int) (Math.random() * 256);

                Color color = new Color(R, G, B);
                shapes.add(new Shape(x, y, sides, size));
                graphics.setColor(color);
                graphics.fill(new RegularPolygon(x, y, size, sides));

            }
            else
                if(((String) this.frame.newPanel.typeOfShape.getSelectedItem()).compareTo("circle") == 0){
                frame.configPanel.label.setText(" ");
                this.frame.configPanel.sidesField.removeAllItems();

                int radius = ((int) (Math.random() * 1000000)) % 100;
                int size = (int) frame.configPanel.sizeField.getValue();
                int R = (int) (Math.random() * 256);
                int B = (int) (Math.random() * 256);
                int G = (int) (Math.random() * 256);
                Color color = new Color(R, G, B);

                Graphics2D g2= (Graphics2D) graphics;
                GradientPaint blackToGray = new GradientPaint(50, 50, Color.BLACK,
                        300, 100, Color.LIGHT_GRAY);
                g2.setPaint(blackToGray);

                shapes.add(new Shape(x, y, 1000, size));
                //g2.setColor(color);
                g2.fill(new NodeShape(x, y, size*2));
            }
                else{
                    int R = (int) (Math.random() * 256);
                    int B = (int) (Math.random() * 256);
                    int G = (int) (Math.random() * 256);

                    Color color = new Color(R, G, B);
                    graphics.setColor(color);
                    FreeDrawing d= new FreeDrawing(frame, graphics, image);
                }
        }
    }
    private void delete(int x, int y) {
        int ok = 0;
        for (int i = 0; i < shapes.size(); i++) {

            float area = 0;
            double alpha = 2 * Math.PI / shapes.get(i).sides;

            if (shapes.get(i).sides != 3) {
                if (((x - shapes.get(i).x) * (x - shapes.get(i).x) + (y - shapes.get(i).y) * (y - shapes.get(i).y)) < shapes.get(i).size * shapes.get(i).size) {
                    {
                        ok = 1;
                        graphics.setColor(Color.WHITE);
                        graphics.fill(new RegularPolygon(shapes.get(i).x, shapes.get(i).y, shapes.get(i).size, shapes.get(i).sides));
                        shapes.remove(i);
                    }

                }
            } else {
                double x1, x2, x3, y1, y2, y3;
                double x4 = (double) x;
                double y4 = (double) y;

                x1 = shapes.get(i).x + shapes.get(i).size * Math.cos(alpha * 0);
                x2 = shapes.get(i).x + shapes.get(i).size * Math.cos(alpha * 1);
                x3 = shapes.get(i).x + shapes.get(i).size * Math.cos(alpha * 2);
                y1 = shapes.get(i).y + shapes.get(i).size * Math.sin(alpha * 0);
                y2 = shapes.get(i).y + shapes.get(i).size * Math.sin(alpha * 1);
                y3 = shapes.get(i).y + shapes.get(i).size * Math.sin(alpha * 2);
                if (Math.floor(area(x1, x2, x3, y1, y2, y3)) == Math.floor(area(x1, x2, x4, y1, y2, y4) + area(x1, x3, x4, y1, y3, y4) + area(x2, x3, x4, y2, y3, y4))) {
                    graphics.setColor(Color.WHITE);
                    graphics.fill(new RegularPolygon(shapes.get(i).x, shapes.get(i).y, shapes.get(i).size, shapes.get(i).sides));
                    shapes.remove(i);
                }
            }
        }

    }

    double area(double x3, double x1, double x2, double y3,double y1,double y2){
        double area;
        area= Math.abs((x1*y2 + x2*y3 + x3*y1 - y1*x2 - y2*x3 - y3*x1)/2);
        return area;
    }
    @Override
    public void update(Graphics g) { }
    @Override
    protected void paintComponent(Graphics g) {
            g.drawImage(image, 0, 0, this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        positions.add(new Points(e.getX(), e.getY()));

    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
