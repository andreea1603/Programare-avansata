import javax.swing.*;

public class ConfigPanel extends JPanel{

    final MainFrame frame;
    JLabel label;
    JSpinner sidesField;
    JComboBox colorCombo;


    public ConfigPanel(MainFrame frame){
        this.frame= frame;
        init();
    }
    private void init(){
        label= new JLabel("Number of sides: ");
        sidesField =new JSpinner(new SpinnerNumberModel(4,3,100,1));
        sidesField.setValue(6);

        String[] colors={"black", "Random"};
        colorCombo= new JComboBox(colors);
        add(label);
        add(sidesField);
        label= new JLabel("Color: ");
        add(label);
        add(colorCombo);
        label= new JLabel("Size: ");
        add(label);
        JSpinner sizeField= new JSpinner(new SpinnerNumberModel(2,0,50,1));
        add(sizeField);
        String value= (String) colorCombo.getSelectedItem();
        System.out.println("Valoare" + value);


    }
}
