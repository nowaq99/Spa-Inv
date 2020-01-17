package controller;

import game.LevelConst;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.*;
import view.*;

import java.util.ArrayList;
import java.util.Random;

public class GameController {

    private Level model = new Level();
    private LevelView view = new LevelView();
    private ArrayList<AlienView> alienViews = new ArrayList<>();
    private MySpaceshipView userView;
    private ArrayList<Projectile> projectiles = new ArrayList<>();

    private int projectileId;

    private Timeline userMove = new Timeline(new KeyFrame(Duration.millis(20), ev -> {

        model.getUser().move();
        userView.update(model.getUser().getPositionX(), model.getUser().getPositionY());

    }));

    private Timeline enemyMove = new Timeline(new KeyFrame(Duration.millis(model.getAliens().getAnimationTime()), ev -> {

        model.getAliens().move();

        for(Alien alien : model.getAliens().getList()){
            int id = model.getAliens().getList().indexOf(alien);
            AlienView alienView = alienViews.get(id);
            alienView.update(alien.getPositionX(), alien.getPositionY());
            if (alien.isTexture1()){
                alienView.getDrawable().setFill(new ImagePattern(alienView.getTexture2()));
                alien.setTexture1(false);
            } else {
                alienView.getDrawable().setFill(new ImagePattern(alienView.getTexture1()));
                alien.setTexture1(true);
            }
        }

    }));

    private Timeline userShooting = new Timeline(new KeyFrame(Duration.millis(400), ev -> {
        model.getUser().setShooting(true);
    }));

    private Timeline alienShooting = new Timeline(new KeyFrame(Duration.millis(LevelConst.packShotTimePerUnit), ev -> {
        if (!model.getAliens().getList().isEmpty()){

            Random generator = new Random();
            int shooting = generator.nextInt(model.getAliens().getList().size());
            Projectile projectile = model.getAliens().getList().get(shooting).shot();
            projectile.setId(projectileId);
            projectiles.add(projectile);
            AlienProjectileView alienProjectileView = new AlienProjectileView(projectile.getPositionX(), projectile.getPositionY(), projectile.getWidth(), projectile.getHeight());
            alienProjectileView.setId(projectileId);
            view.getPane().getChildren().add(alienProjectileView.getDrawable());
            projectileId++;

        }
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
                    if (user.isShooting()) {
                        Projectile projectile = model.getUser().shot();
                        projectile.setId(projectileId);
                        projectiles.add(projectile);
                        MyProjectileView myProjectileView = new MyProjectileView(projectile.getPositionX(), projectile.getPositionY(), projectile.getWidth(), projectile.getHeight());
                        myProjectileView.setId(projectileId);
                        view.getPane().getChildren().add(myProjectileView.getDrawable());
                        projectileId++;
                        model.getUser().setShooting(false);
                    }
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
        enemyMove.setCycleCount(Animation.INDEFINITE);
        enemyMove.play();
        userShooting.setCycleCount(Animation.INDEFINITE);
        userShooting.play();
        alienShooting.setCycleCount(Animation.INDEFINITE);
        alienShooting.play();

    }





}
