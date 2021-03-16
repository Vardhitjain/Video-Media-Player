package sample;

import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class VideoPlayer extends BorderPane {
    Media media;
    MediaPlayer mediaplayer;
    MediaView mediaview;
    Pane pane;
    //Video Bar
    VideoBar bar;
    public VideoPlayer(String filepath) {
        media =new Media(filepath);
        mediaplayer=new MediaPlayer(media);
        mediaview=new MediaView(mediaplayer);
        pane=new Pane();

        pane.getChildren().add(mediaview);
        setCenter(pane);
        //add video bar
        bar=new VideoBar(mediaplayer);
        setBottom(bar);
        mediaplayer.play();
    }
}
