import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private Connection conn;

    public Connection getConnection() {
        try {
            return DriverManager
                    .getConnection("jdbc:mysql://localhost/filmezeria?useTimezone=true&serverTimezone=UTC", "root", "admin");

        } catch (SQLException excecao){
            throw new RuntimeException(excecao);
        }
    }
}
