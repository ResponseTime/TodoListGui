package todogui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class st extends Application{
    @Override
    public void start(Stage stage)throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("first.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Todo List");
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args) {
        controller con = new controller();
        //con.setDaemon(true);
        con.setPriority(Thread.MAX_PRIORITY);
        con.start();
        launch(args);
    }
}