import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String DB_NAME = "Usuarios.db";
    private Connection connection;

    public Database() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_NAME);
            System.out.println("Conexão com o SQLite estabelecida. Banco: " + DB_NAME);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Erro ao conectar ao SQLite: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexão com o SQLite fechada. Banco: " + DB_NAME);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar a conexão com o SQLite: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Database db = new Database();
        db.closeConnection();
    }
}
