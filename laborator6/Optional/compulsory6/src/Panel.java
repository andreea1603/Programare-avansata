import javax.swing.*;

public class Panel extends JPanel{
    final MainFrame frame;
    JComboBox typeOfShape;
    JLabel label;



    public Panel(MainFrame frame){
        this.frame= frame;
        init();
    }
    private void init() {
        label = new JLabel("Type of shape:  ");
        String[] types={"polygon", "circle"};
        typeOfShape= new JComboBox(types);
        add(label);
        add(typeOfShape);
    }
}
