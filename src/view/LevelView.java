package view;

import game.LevelConst;
import game.MainConst;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.ArrayList;


public class LevelView {

    private Pane pane = new Pane();
    private Scene scene;
    private ArrayList<Rectangle> lives = new ArrayList<>();
    private Text score = new Text("Score: 0");

    public LevelView(){
        setPane();
        scene = new Scene(pane);

        int lifeX = MainConst.lifeStartX;
        int lifeY = MainConst.lifeY;

        for (int i = 1; i <= 5; ++i){

            Rectangle life = new Rectangle();
            life.setLayoutX((float) -MainConst.lifeWidth/2);
            life.setLayoutY((float) -MainConst.lifeHeight/2);
            life.setX(lifeX);
            life.setY(lifeY);
            life.setWidth(MainConst.lifeWidth);
            life.setHeight(MainConst.lifeHeight);
            life.setFill(new ImagePattern(new Image("textures/life.png")));
            lives.add(life);
            lifeX -= MainConst.lifeInterspace;

            if (i <= LevelConst.startLives){
                pane.getChildren().add(life);
            }

        }

        score.setFont(Font.font(MainConst.scoreSize));
        score.setX(MainConst.scoreX);
        score.setY(MainConst.scoreY);
        pane.getChildren().add(score);

    }


    public void updateScore(int score){

        this.score.setText("Score: " + score);

    }


    public void loseLive (){

        Rectangle last = null;

        for(Rectangle life : lives){

            if (pane.getChildren().contains(life)){
                last = life;
            } else {
                break;
            }

        }

        pane.getChildren().remove(last);

    }

    private void setPane(){
        pane.setPrefSize(MainConst.paneWidth, MainConst.paneHeight);
    }

    public Pane getPane() {
        return pane;
    }

    public Scene getScene() {
        return scene;
    }

}
