import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JFrame;
import java.sql.SQLException;

public class FrameTable extends JFrame {

    public FrameTable() throws SQLException {
        super("Filmes");
        FilmesDAO dao = new FilmesDAO();
        FilmesTableModel tableModel = new FilmesTableModel(dao);
        JTable table = new JTable(tableModel);
        JScrollPane scroll = new JScrollPane();
        scroll.setViewportView(table);
        add(scroll);
        setSize(500, 150);
    }
}
