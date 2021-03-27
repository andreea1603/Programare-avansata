import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends JPanel{

    final MainFrame frame;
    JLabel label, labelForSize;
    JComboBox sidesField;
    JComboBox colorCombo;
    JSpinner sizeField;
    JComboBox drawDelete;

    public ConfigPanel(MainFrame frame){
        this.frame= frame;
        init();
    }
    private void init(){
            label = new JLabel("Number of sides: ");
           // sidesField = new JSpinner(new SpinnerNumberModel(4, 3, 100, 1));
           // sidesField.setValue(6);
        String[] sides={"3", "4", "5", "6", "7", "8", "9", "10", "11"};
        sidesField= new JComboBox(sides);

        String[] colors={"black", "Random"}; String[] delete={"drawing", "delete"};
        colorCombo= new JComboBox(colors);
        add(label);
        add(sidesField);
        labelForSize= new JLabel("Color: ");
        add(labelForSize);
        add(colorCombo);
        labelForSize= new JLabel("Size: ");
        add(labelForSize);
        sizeField= new JSpinner(new SpinnerNumberModel(30,0,100,1));
        add(sizeField);
        labelForSize = new JLabel("Delete/Draw");
        add(labelForSize);
        drawDelete= new JComboBox(delete);
        add(drawDelete);

    }
}
