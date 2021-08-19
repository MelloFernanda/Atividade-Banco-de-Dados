import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class CinematecaMain {

    public static void main(String[] args) throws SQLException {
        FilmesDAO dao = new FilmesDAO();


        FrameTable frame = new FrameTable();
        frame.setVisible(true);

    }
}
