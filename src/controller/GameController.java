package controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.*;
import view.*;

import java.util.ArrayList;

public class GameController {

    private Level model = new Level();
    private LevelView view = new LevelView();
    private ArrayList<AlienView> alienViews = new ArrayList<>();
    private MySpaceshipView userView;

    public GameController(){

        for (Alien alien : model.getAliens().getList()){
            if (alien.getClass() == Krzychu.class){
                AlienView alienView = new KrzychuView(alien.getPositionX(), alien.getPositionY(), alien.getWidth(), alien.getHeight());
                alienViews.add(alienView);
                view.getPane().getChildren().add(alienView.getDrawable());
            } else if (alien.getClass() == Rychu.class){
                AlienView alienView = new RychuView(alien.getPositionX(), alien.getPositionY(), alien.getWidth(), alien.getHeight());
                alienViews.add(alienView);
                view.getPane().getChildren().add(alienView.getDrawable());
            } else if (alien.getClass() == Zdzichu.class){
                AlienView alienView = new ZdzichuView(alien.getPositionX(), alien.getPositionY(), alien.getWidth(), alien.getHeight());
                alienViews.add(alienView);
                view.getPane().getChildren().add(alienView.getDrawable());
            }
        }

        MySpaceship user = model.getUser();
        userView = new MySpaceshipView(user.getPositionX(), user.getPositionY(), user.getWidth(), user.getHeight());
        view.getPane().getChildren().add(userView.getDrawable());

    }

    public void startGame(Stage stage){

        stage.setScene(view.getScene());

    }




}
