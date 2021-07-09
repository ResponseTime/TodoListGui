package todogui;


import java.util.ArrayList;
import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class controller {
    private static Statement stmt;
    public static void con() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/todo", "root","root");
        stmt = con.createStatement();
    }
    private String tk;
    private static ArrayList<String> to = new ArrayList<String>();
    private static int count=1;
    @FXML
    TextField task;
    @FXML
    ListView<String> shown;
    @FXML
    public void add(ActionEvent e) throws Exception{
        tk = task.getText();
        con();
        to.ensureCapacity(500);
        to.add(tk);
        stmt.executeUpdate("INSERT INTO TODO VALUES ('"+count++ +"','"+tk+"')");
        return;
    }
    public void showTasks(ActionEvent e) throws Exception{
            for(int i =0;i<to.size()+1;i++){
                shown.getItems().add(to.get(i));
            }
            
     
        
    }
    public void removeTask(ActionEvent e) throws Exception{
        
    }
}
