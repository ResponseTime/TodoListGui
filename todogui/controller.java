package todogui;



import java.sql.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class controller extends Thread {
    private String tk;
    @FXML
    TextField task;
    @FXML
    ListView<String> shown;
    @FXML
    private static Statement stmt;
    private static ResultSet r;
    @Override
    public void run(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3309/todo", "root","root");
            stmt = con.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
   }
    @FXML
    public void add(ActionEvent e) throws Exception{
        shown.getItems().clear();
        tk = task.getText();
        stmt.executeUpdate("INSERT INTO TODO VALUES ('"+tk+"')");
    }
    public void showTasks(ActionEvent e) throws Exception{
        r = stmt.executeQuery("SELECT TASK FROM TODO");
        if(r.next()==false){
            shown.getItems().add("No tasks found");
        }
        while(r.next()){
            shown.getItems().add(r.getString(1));
        }
    }  
    public void removeTask(ActionEvent e) throws Exception{
        shown.getItems().clear();
        String tw = task.getText();
        stmt.executeUpdate("DELETE FROM TODO WHERE TASK = '"+tw+"'");
        
    }
}
