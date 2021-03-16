package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        VideoPlayer videoPlayer=new VideoPlayer("file:///C:/Users/VARDHIT%20JAIN/Desktop/Tiger%20Zinda%20Hai%20%20%20Official%20Trailer%20%20%20Salman%20Khan%20%20%20Katrina%20Kaif.mp4");
        Scene scene=new Scene(videoPlayer,1280,1080, Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
