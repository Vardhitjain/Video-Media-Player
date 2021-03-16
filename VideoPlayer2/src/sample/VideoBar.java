package sample;

import com.sun.deploy.security.SelectableSecurityManager;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;//horizontal box
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

public class VideoBar extends HBox {
    Slider timeslider=new Slider();
    Slider volumeslider=new Slider();
    Button playbutton=new Button("||");
    Label volume =new Label("Volume");

    MediaPlayer player;

    public VideoBar(MediaPlayer play) {
        player=play;

        setAlignment(Pos.CENTER);
        setPadding(new Insets(5,10,5,10));
        volumeslider.setPrefWidth(70.0);
        volumeslider.setMinWidth(30.0);
        volumeslider.setValue(100);

        HBox.setHgrow(timeslider, Priority.ALWAYS);
        playbutton.prefWidth(40.0);

        getChildren().add(playbutton);
        getChildren().add(timeslider);
        getChildren().add(volume);
        getChildren().add(volumeslider);

        playbutton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Status status= player.getStatus();
                if(status==Status.PLAYING)
                {
                    if(player.getCurrentTime().greaterThanOrEqualTo(player.getTotalDuration()))
                    {
                        player.seek(player.getStartTime());
                        player.play();

                    }
                    else{
                        player.pause();
                        playbutton.setText(">");
                }
                }
                if(status==Status.PAUSED||status==Status.STOPPED)
                {
                    player.play();
                    playbutton.setText("||");

                }
                player.currentTimeProperty().addListener(new InvalidationListener() {
                    @Override
                    public void invalidated(Observable observable) {
                        moveslider();
                    }
                });

                
            }
        });

    }
    private void moveslider(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                timeslider.setValue(player.getCurrentTime().toSeconds()/player.getTotalDuration().toSeconds()*100);

            }
        });
        volumeslider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if(volumeslider.isPressed())
                {
                    player.setVolume(volumeslider.getValue()/100);
                }
            }
        });
    }

}
