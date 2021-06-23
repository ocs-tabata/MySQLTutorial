package mysqltutorial;

import mysqltutorial.database.MySQL;
import mysqltutorial.gui.MainFrame;

public class MySQLTutorial {
    private static MySQLTutorial instance;
    private static final MySQL mysql = new MySQL();
    
    public MySQLTutorial() {
        // Initialization of variables
        instance = this;
    }
    
    public static void main(String[] args) {
        // MySQL接続
        mysql.connect();
        
        // GUI起動
        MainFrame frame = new MainFrame();
    }
    
    public static void exit() {
        // MySQL切断
        mysql.disconnect();
        
        // System終了
	System.exit(0);
    }
    
    /**
     * Get the current instance of this class.
     * @return instance
     */
    public static MySQLTutorial getInstance() {
        return instance;
    }
}
