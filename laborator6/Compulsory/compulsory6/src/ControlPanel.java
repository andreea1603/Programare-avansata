import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");

    public ControlPanel(MainFrame frame){
        this.frame=frame; init();
    }
    private void init(){
        setLayout(new GridLayout(1,4));
        add(saveBtn, BorderLayout.SOUTH);
        add(loadBtn, BorderLayout.SOUTH);
        add(resetBtn, BorderLayout.SOUTH);
        add(exitBtn, BorderLayout.SOUTH);

        saveBtn.addActionListener(this::save);
        resetBtn.addActionListener(this::reset);
        loadBtn.addActionListener(this::load);
        exitBtn.addActionListener(this::exit);
    }
    private void save(ActionEvent e) {
        final JFileChooser fc= new JFileChooser();
        fc.setCurrentDirectory(new File("C:\\Users\\andre\\OneDrive\\Desktop\\testgrafica\\src"));
        int result= fc.showOpenDialog(getParent());
        File selectedFile= fc.getSelectedFile();

        try {
            ImageIO.write(frame.canvas.image, "PNG", selectedFile);
        } catch (IOException ex) { System.err.println(ex); }
    }
    private void reset(ActionEvent e) {
        super.paint(this.frame.canvas.graphics);
        this.frame.canvas.graphics.setColor(Color.WHITE);

        this.frame.canvas.image= new BufferedImage(this.frame.canvas.W, this.frame.canvas.H, BufferedImage.TYPE_INT_ARGB);
        this.frame.canvas.graphics= this.frame.canvas.image.createGraphics();
        this.frame.canvas.graphics.setBackground(Color.WHITE);
        this.frame.canvas.graphics.fillRect(0,0,this.frame.canvas.W,this.frame.canvas.H);
    }
    private void reset(){
        super.paint(this.frame.canvas.graphics);
        this.frame.canvas.graphics.setColor(Color.WHITE);

        this.frame.canvas.image= new BufferedImage(this.frame.canvas.W, this.frame.canvas.H, BufferedImage.TYPE_INT_ARGB);
        this.frame.canvas.graphics= this.frame.canvas.image.createGraphics();
        this.frame.canvas.graphics.setBackground(Color.WHITE);
        this.frame.canvas.graphics.fillRect(0,0,this.frame.canvas.W,this.frame.canvas.H);

    }
    private void load(ActionEvent e){
        BufferedImage img = null;

        final JFileChooser fc= new JFileChooser();
        fc.setCurrentDirectory(new File("C:\\Users\\andre\\OneDrive\\Desktop\\testgrafica\\src"));
        int result= fc.showOpenDialog(getParent());
        File selectedFile= fc.getSelectedFile();

        try{
            img=ImageIO.read(selectedFile);
        }
        catch (IOException ioException) {
            ioException.printStackTrace();
        }
        this.frame.canvas.image=img;

        this.frame.canvas.graphics= this.frame.canvas.image.createGraphics();

    }
    private void exit(ActionEvent e){
            System.exit(0);
    }
}
