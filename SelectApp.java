package JavaDB_001;
import javax.swing.*;
import java.sql.Connection;  
import java.sql.DriverManager;  
import java.sql.SQLException;  
import java.awt.event.*;

public class SelectApp extends JFrame implements ActionListener{
    JLabel JL_actor,JL_actress,JL_year,JL_movie,JL_director;
    JTextField JT_actor,JT_actress,JT_year,JT_movie,JT_director;
    JButton btn_search;


    public Work(){
        super("Search movies");
        JL_movie = new JLabel("Enter movie name:");
        JL_movie.setBounds(20, 20, 200, 20);
        JT_movie = new JTextField(20);
        JT_movie.setBounds(130, 20, 150, 20);
        btn_search = new JButton("Search");
        btn_search.setBounds(300, 20, 80, 20);
        btn_search.addActionListener(this);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(500,200);

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
        add(JL_actor);
        add(JT_actor);
        add(JL_actress);
        add(JT_actress);
        add(JL_year);
        add(JT_year);
        add(JL_movie);
        add(JT_movie);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Function f = new Function();
        ResultSet rs = null;
        String fn = "actor";
        String ln = "actress";
        String ag = "year";

        rs = f.find(JT_movie.getText());
        try{
            if(rs.next()){
                JT_actor.setText(rs.getString("actor"));
                JT_actress.setText(rs.getString("actress"));
                JT_year.setText(rs.getString("year"));
                JT_year.setText(rs.getString("year"));
            }  else{
                JOptionPane.showMessageDialog(null, "NO DATA FOR THIS ID");
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
                 String url = "jdbc:sqlite:C:/sqlite/database.db";  
                  conn = DriverManager.getConnection(url); 
                  System.out.println("Connection to SQLite has been established."); 
            }catch(Exception ex){
                System.out.println(e.getMessage()); 
            }
            return rs;
        }

    }


    public static void main(String[] args){
        new Work();
    }

}

