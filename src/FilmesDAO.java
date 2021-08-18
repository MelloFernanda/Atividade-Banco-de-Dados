import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FilmesDAO {

    private Connection conn;

    public FilmesDAO() throws SQLException {
        conn =  new
                ConnectionFactory().getConnection();
    }

    public void add(Filmes filme) throws SQLException {
        String sql = "INSERT INTO filmes(titulo, director, genero, ano)" +
                "VALUES (?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, filme.getTitulo());
        stmt.setString(2, filme.getDirector());
        stmt.setString(3, filme.getGenero());
        stmt.setString(4, filme.getAno());
        stmt.execute();
        stmt.close();
    }

    public List<Filmes> retrive (){
        List filmes = new ArrayList<Filmes>();

        String sql = "SELECT * FROM filmes";
        try {
            PreparedStatement stmt =
                    conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){

                String titulo = rs.getString("titulo");
                String diretor = rs.getString("director");
                String genero = rs.getString("genero");
                String ano = rs.getString("ano");

                Filmes filme = new Filmes(titulo, diretor, genero, ano);
                filmes.add(filme);
            }

            stmt.close();
        } catch (SQLException ex){
            throw new RuntimeException();
        }

        return filmes;
    }

    public void update(Filmes f){
        String sql = "update filmes set director=?, genero=?, ano=? where titulo=?";
        try {
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, f.getDirector());
            stm.setString(2, f.getGenero());
            stm.setString(3, f.getAno());
            stm.setString(4, f.getTitulo());
            stm.execute();
            stm.close();
        } catch (SQLException ex){
            throw new RuntimeException();
        }
    }

}
