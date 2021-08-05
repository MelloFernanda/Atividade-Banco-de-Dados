public class Filmes {
    private String titulo;
    private String director;
    private String genero;
    private String ano;


    public Filmes(String titulo, String director, String genero, String ano) {
        super();
        this.titulo = titulo;
        this.director = director;
        this.genero = genero;
        this.ano = ano;
    }


    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }


    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }


    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        return "Filmes{" +
                "titulo='" + titulo + '\'' +
                ", director='" + director + '\'' +
                ", genero='" + genero + '\'' +
                ", ano='" + ano + '\'' +
                '}';
    }
}
