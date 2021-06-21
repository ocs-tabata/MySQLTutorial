package mysqltutorial.database;

import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL extends Database {
    private final String host, database, username, password;
    private final int port;
    
    public MySQL() {
	this.host = "localhost";
	this.port = 3306;
	this.database = "mysql";
	this.username = "root";
	this.password = "";
    }
    
    @Override
    public void connect() {
        if (connection == null) {
            try {
                // JDBCドライバのロード - JDBC4.0（JDK1.6）以降は不要
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                // MySQLに接続
                connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database + "?serverTimezone=JST", this.username, this.password);
                
                System.out.println("MySQLに接続できました。");
                System.out.println(connection);
            } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
                System.out.println("JDBCドライバのロードに失敗しました。");
            } catch (SQLException e) {
                System.out.println("MySQLに接続できませんでした。");
            }
        } else {
            System.out.println("既にMySQLに接続されています。");
        }
    }
    
    @Override
    public void disconnect() {
        if (connection != null) {
            try {
                System.out.println(connection);
                connection.close();
                connection = null;
                System.out.println("MySQLから切断しました。");
            } catch (SQLException e) {
                System.out.println("MySQLのクローズに失敗しました。");
            }
        } else {
            System.out.println("既にMySQLから切断されています。");
        }
    }
}
