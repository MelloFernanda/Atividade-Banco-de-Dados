import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class FilmesTableModel extends AbstractTableModel implements TableModelListener{

    FilmesDAO dao;
    List<Filmes> filmes;
    List<String> colunas;

    public FilmesTableModel(FilmesDAO dao){
        this.dao = dao;
        filmes = dao.retrive();
        colunas = List.of("Título","Diretor","Gênero", "Ano");
        this.addTableModelListener(this);
    }

    @Override
    public int getRowCount() {
        return filmes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Filmes filme = filmes.get(rowIndex);
        switch (columnIndex){
            case 0: return filme.getTitulo();
            case 1: return filme.getDirector();
            case 2: return filme.getGenero();
            case 3: return filme.getAno();
        }
        return null;
    }

    @Override
    public String getColumnName(int column){
        return colunas.get(column);
    }

    @Override
    public boolean isCellEditable (int rowIndex, int columnIndex){
        return columnIndex != 0;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Filmes filme = filmes.get(rowIndex);
        switch (columnIndex) {
            case 1:
                filme.setDirector((String) aValue);
                break;
            case 2:
                filme.setGenero((String) aValue);
                break;
            case 3:
                filme.setAno((String) aValue);
                break;
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

       @Override
        public void tableChanged(TableModelEvent e) {
            int i = e.getFirstRow();
            System.out.println(i);
            Filmes filme = filmes.get(i);
            dao.update(filme);
        }

}
