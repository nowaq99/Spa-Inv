package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
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
    private ArrayList<Projectile> projectiles = new ArrayList<>();

    private int projectileId;

    private Timeline userMove = new Timeline(new KeyFrame(Duration.millis(25), ev -> {

        model.getUser().move();
        userView.update(model.getUser().getPositionX(), model.getUser().getPositionY());

    }));

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

            projectileId = 0;
        }

        MySpaceship user = model.getUser();
        userView = new MySpaceshipView(user.getPositionX(), user.getPositionY(), user.getWidth(), user.getHeight());
        view.getPane().getChildren().add(userView.getDrawable());

        view.getScene().setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()){
                case LEFT:
                    model.getUser().setMovingLeft(true);
                    break;
                case RIGHT:
                    model.getUser().setMovingRight(true);
                    break;
                case SPACE:
                    Projectile projectile = model.getUser().shot();
                    projectile.setId(projectileId);
                    projectiles.add(projectile);
                    MyProjectileView myProjectileView = new MyProjectileView(projectile.getPositionX(), projectile.getPositionY(), projectile.getWidth(), projectile.getHeight());
                    myProjectileView.setId(projectileId);
                    view.getPane().getChildren().add(myProjectileView.getDrawable());
                    projectileId++;
            }
        });

        view.getScene().setOnKeyReleased(keyEvent -> {
            switch (keyEvent.getCode()){
                case LEFT:
                    model.getUser().setMovingLeft(false);
                    break;
                case RIGHT:
                    model.getUser().setMovingRight(false);
                    break;
            }
        });

    }

    public void startGame(Stage stage){

        stage.setScene(view.getScene());
        userMove.setCycleCount(Animation.INDEFINITE);
        userMove.play();

    }





}
