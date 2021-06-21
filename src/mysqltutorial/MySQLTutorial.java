package mysqltutorial;

import mysqltutorial.database.MySQL;
import mysqltutorial.gui.MainFrame;

public class MySQLTutorial {
    private static MySQLTutorial instance;
    
    public MySQLTutorial() {
        // Initialization of variables
        instance = this;
    }
    
    public static void main(String[] args) {
        MySQL mysql = new MySQL();
        
        // MySQL接続
        mysql.connect();
        
        // GUI起動
	new MainFrame();
    }
    
    public static void exit() {
        MySQL mysql = new MySQL();
        
        // MySQL切断
        mysql.disconnect();
        
        // System終了
	System.exit(0);
    }
    
    public static MySQLTutorial getInstance() {
        return instance;
    }
}
