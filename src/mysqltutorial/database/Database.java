package mysqltutorial.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Database {
    protected static Connection connection = null;
    
    public abstract void connect();
    
    public abstract void disconnect();
    
    public Connection getConnection() {
	return connection;
    }
    
    public static void execute(String sql) throws SQLException, ClassNotFoundException {
        Statement stmt = connection.createStatement();
        
        stmt.execute(sql);
    }
    
    public static ResultSet executeQuery(String sql) throws SQLException, ClassNotFoundException {
	Statement stmt = connection.createStatement();
	
	ResultSet result = stmt.executeQuery(sql);
	
	return result;
    }
    
    public static int executeUpdate(String sql) throws SQLException, ClassNotFoundException {
	Statement statement = connection.createStatement();
	
	int result = statement.executeUpdate(sql);
	
	return result;
    }
}