import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    DrawingPanel canvas;
    ConfigPanel configPanel;
    ControlPanel controlPanel;

    public MainFrame(){
        super("My Drawing App");
        init();
    }
    public void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas= new DrawingPanel(this);
        configPanel= new ConfigPanel(this);
        controlPanel= new ControlPanel(this);

        add(canvas, BorderLayout.CENTER);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
    }
}
