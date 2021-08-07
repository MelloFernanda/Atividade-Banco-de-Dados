import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

public class Interface extends JFrame {

    //Construtor da Classe
    public Interface(){
        super();

        //Título da janela
        setTitle("Cinemateca - Cadastro");


        //Layout de janela
        setLayout(new FlowLayout());
        //Editando tamanho
        setSize(350, 225);
        //Editando posição da janela
        setLocation(600,300);



        //Criando controles
        JPanel caixaTitulo = new JPanel();
        caixaTitulo.setLayout(new FlowLayout());
        caixaTitulo.add(new JLabel("Título:"));
        JTextField txtTitulo = new JTextField(20);
        caixaTitulo.add(txtTitulo);

        JPanel caixaDiretor = new JPanel();
        caixaDiretor.add(new JLabel("Diretor:"));
        JTextField txtDiretor = new JTextField(20);
        caixaDiretor.add(txtDiretor);

        JPanel caixaGenero = new JPanel();
        caixaGenero.add(new JLabel("Genero:"));
        JTextField txtGenero = new JTextField(20);
        caixaGenero.add(txtGenero);

        JPanel caixaAno = new JPanel();
        caixaAno.add(new JLabel("ano:"));
        JTextField txtAno = new JTextField(20);
        caixaAno.add(txtAno);

        add(caixaTitulo);
        add(caixaDiretor);
        add(caixaGenero);
        add(caixaAno);


        //Criando botão Cadastrar
        JButton bt = new JButton("Cadastrar");
        bt.setMnemonic(KeyEvent.VK_C);

        //Atribuindo ação para botão
        bt.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    //Cadastrar com txt dos controles no banco de dados
                    cadastro(txtTitulo.getText(), txtDiretor.getText(), txtGenero.getText(), txtAno.getText());

                    //caixa de mensagem
                    JOptionPane.showMessageDialog(null, "O filme foi cadastrado!!!");

                    //Limpar console
                    txtTitulo.setText("");
                    txtDiretor.setText("");
                    txtGenero.setText("");
                    txtAno.setText("");

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        //Add botão cadastrar
        add(bt);



        //Criando Botão - Fechar
        JButton btFechar = new JButton("Fechar");
        btFechar.setMnemonic(KeyEvent.VK_F);

        //Adicionar ação ao botão fechar
        btFechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(1);
            }
        });
        //Adicionar botão de fechar
        add(btFechar);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    //Método Cadastro
    private void cadastro(String titulo, String diretor, String genero, String ano) throws SQLException {
        FilmesDAO cadastroFilme = new FilmesDAO();
        cadastroFilme.add(new Filmes(titulo, diretor, genero, ano));
    }



}