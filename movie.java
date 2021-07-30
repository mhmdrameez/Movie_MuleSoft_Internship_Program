package JavaDB_001;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class movie extends JFrame implements ActionListener{
    JLabel JL_actor,JL_actress,JL_year,JL_movie,JL_director;
    JTextField JT_actor,JT_actress,JT_year,JT_movie,JT_director;
    JButton btn_search,btn_insert;


    public movie(){
        super("movies");
        JL_movie = new JLabel("Enter movie name:");
        JL_movie.setBounds(20, 20, 200, 20);
        JT_movie = new JTextField(20);
        JT_movie.setBounds(130, 20, 150, 20);
        btn_search = new JButton("Search");
        btn_search.setBounds(300, 20, 80, 20);
        btn_search.addActionListener(this);

        btn_insert = new JButton("Insert");
        btn_insert.setBounds(300, 60, 80, 20);
        btn_insert.addActionListener(this);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500,200);


        JL_director = new JLabel(" Director name: ");
        JL_director.setBounds(20, 140, 100, 20);
        JT_director = new JTextField(20);
        JT_director.setBounds(130, 140, 150, 20);

        JL_actor = new JLabel(" Actor name: ");
        JL_actor.setBounds(20, 50, 100, 20);
        JT_actor = new JTextField(20);
        JT_actor.setBounds(130, 50, 150, 20);
        JL_actress = new JLabel("Actress name: ");
        JL_actress.setBounds(20, 80, 100, 20);
        JT_actress = new JTextField(20);
        JT_actress.setBounds(130, 80, 150, 20);
        JL_year = new JLabel("Year: ");
        JL_year.setBounds(20, 110, 100, 20);
        JT_year = new JTextField(20);
        JT_year.setBounds(130, 110, 150, 20);
        setLayout(null);
        add(btn_search);
        add(btn_insert);
        add(JL_actor);
        add(JT_actor);
        add(JL_actress);
        add(JT_actress);
        add(JL_year);
        add(JT_year);
        add(JL_movie);
        add(JT_movie);
        add(JL_director);
        add(JT_director);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Function f = new Function();
        ResultSet rs = null;
        String fn = "actor";
        String ln = "actress";
        String ag = "year";
        String am= "director";

        rs = f.find(JT_movie.getText());
        try{
            if(rs.next()){
                JT_actor.setText(rs.getString("actor"));
                JT_actress.setText(rs.getString("actress"));
                JT_year.setText(rs.getString("year"));
                JT_director.setText(rs.getString("director"));
            }  else{
                JOptionPane.showMessageDialog(null, "NO DATA FOUND");
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    public class Function{
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        public ResultSet find(String s){
            try{
                 Class.forName("org.sqlite.JDBC");
                con = DriverManager.getConnection("jdbc:sqlite:C://sqlite/movies.db");
            }catch(Exception e){
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            return rs;
        }

    }


    public static void main(String[] args){
        new movie();
    }

}
/////////////////// END :)
