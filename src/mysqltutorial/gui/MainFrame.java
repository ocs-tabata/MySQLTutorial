package mysqltutorial.gui;

import java.awt.CardLayout;
import java.awt.Container;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
    public String[] PanelNames = { "Main" };
    public JPanel main = new MainPanel(this, PanelNames[0]);
    public JPanel[] jps = { main };
    private final CardLayout layout = new CardLayout();
    
    public MainFrame() {
	this.setTitle("MySQL");
	this.setVisible(true);
	this.setBounds(0, 0, 1024, 768);
	this.setResizable(false);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	
        // CardLayoutを使用。
        Container contentPane = this.getContentPane();
        JPanel mainPanel = new JPanel();
        
        mainPanel.setLayout(layout);
        
        for (JPanel panel : jps) {
            mainPanel.add(panel, panel.getName());
        }
        
        contentPane.add(mainPanel);
        
        setVisible(true);
    }
    
    public void changePanel(String str) {
        int index = Arrays.asList(PanelNames).indexOf(str);
        layout.show(jps[index].getParent(), jps[index].getName());
    }
}