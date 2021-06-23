package mysqltutorial.gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import mysqltutorial.MySQLTutorial;
import mysqltutorial.database.MySQL;

public class MainPanel extends JPanel implements ActionListener {
    private final String name;
    private final MainFrame frame; // インスタンス変数でMainFrameの参照を保持
    
    public MainPanel(MainFrame frame, String name) {
        this.name = name;
        this.frame = frame;
        this.setName(this.name);
        this.setLayout(null);
        
        JButton connectButton = new JButton("接続");
        connectButton.setFont(new Font("MS UI Gothic", Font.PLAIN, 36));
	connectButton.setBounds(184, 288, 200, 100);
	connectButton.setActionCommand("Connect");
	connectButton.addActionListener(this);
	this.add(connectButton);
        
        JButton disconnectButton = new JButton("切断");
        disconnectButton.setFont(new Font("MS UI Gothic", Font.PLAIN, 36));
	disconnectButton.setBounds(584, 288, 200, 100);
	disconnectButton.setActionCommand("Disconnect");
	disconnectButton.addActionListener(this);
	this.add(disconnectButton);
        
        JButton exitButton = new JButton("終了");
        exitButton.setFont(new Font("MS UI Gothic", Font.PLAIN, 36));
	exitButton.setBounds(384, 576, 200, 100);
	exitButton.setActionCommand("Exit");
	exitButton.addActionListener(this);
	this.add(exitButton);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    	String cmd = e.getActionCommand();
        
        MySQL mysql = new MySQL();
    	
    	switch (cmd) {
            case "Connect":
                // MySQL接続
                mysql.connect();
                break;
            case "Disconnect":
                // MySQL切断
                mysql.disconnect();
                break;
            case "Exit":
		int option = JOptionPane.showConfirmDialog(this, "本当に終了しますか？", "確認	", JOptionPane.YES_NO_OPTION);
		
		if (option == JOptionPane.YES_OPTION) {
                    MySQLTutorial.exit();
		}
                
                break;
            default:
                break;
        }
    }
}
