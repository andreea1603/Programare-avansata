import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    DrawingPanel canvas;
    ConfigPanel configPanel;
    ControlPanel controlPanel;
    Panel newPanel;

    public MainFrame(){
        super("My Drawing App");
        init();
    }
    public void init(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        canvas= new DrawingPanel(this);
        configPanel= new ConfigPanel(this);
        controlPanel= new ControlPanel(this);
        newPanel= new Panel(this);

        add(canvas, BorderLayout.CENTER);
        add(newPanel, BorderLayout.EAST);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel, BorderLayout.SOUTH);

        pack();
    }
}
