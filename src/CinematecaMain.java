import java.sql.SQLException;
import java.util.List;

public class CinematecaMain {

    public static void main(String[] args) throws SQLException {
        FilmesDAO dao = new FilmesDAO();
        List<Filmes> filmes = dao.retrive();

        for (Filmes f: filmes){
            System.out.println(f);
        }

    }
}
