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
    private ArrayList<AlienProjectileView> alienProjectileViews = new ArrayList<>();
    private ArrayList<MyProjectileView> myProjectileViews = new ArrayList<>();

    private int projectileId;


    private Timeline userMove = new Timeline(new KeyFrame(Duration.millis(20), ev -> {

        model.getUser().move();
        userView.update(model.getUser().getPositionX(), model.getUser().getPositionY());

    }));

    private Timeline alienMove = new Timeline(new KeyFrame(Duration.millis(model.getAliens().getAnimationTime()), ev -> {

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
            alienProjectileViews.add(alienProjectileView);
            view.getPane().getChildren().add(alienProjectileView.getDrawable());
            projectileId++;

        }
    }));

    private Timeline projecileMoving = new Timeline(new KeyFrame(Duration.millis(20), ev -> {

        Projectile outOfScreen = null;
        Projectile crashedProjectile = null;
        Alien crashedAlien = null;

        for (Projectile projectile : projectiles){
            int id = projectile.getId();
            projectile.move();
            if (projectile.getProperty() == Projectile.Property.My){
                if (projectile.getMaxTop() > projectile.getPositionY()){
                    outOfScreen = projectile;
                } else {
                    for ( MyProjectileView projectileView : myProjectileViews){
                        if (projectileView.getId() == id){
                            projectileView.update(projectile.getPositionX(), projectile.getPositionY());
                            break;
                        }
                    }
                }

                for (Alien alien : model.getAliens().getList()){

                    if (projectile.getPositionY() > alien.getTopBorder() && projectile.getPositionY() < alien.getBottomBorder() && projectile.getPositionX() > alien.getLeftBorder() && projectile.getPositionX() < alien.getRightBorder()){

                        crashedProjectile = projectile;
                        crashedAlien = alien;
                        break;

                    }

                }

            } else if (projectile.getProperty() == Projectile.Property.Alien){
                if (projectile.getMaxBottom() < projectile.getPositionY()){
                    outOfScreen = projectile;
                } else {
                    for ( AlienProjectileView projectileView : alienProjectileViews){
                        if (projectileView.getId() == id){
                            projectileView.update(projectile.getPositionX(), projectile.getPositionY());
                            break;
                        }
                    }
                }
            }
        }

        if (crashedAlien != null){

            int id = model.getAliens().getList().indexOf(crashedAlien);
            int proId = crashedProjectile.getId();
            model.getAliens().getList().remove(crashedAlien);
            AlienView alienView = alienViews.get(id);
            view.getPane().getChildren().remove(alienView.getDrawable());
            alienViews.remove(alienView);

            projectiles.remove(crashedProjectile);

            for ( MyProjectileView projectileView : myProjectileViews){
                if (projectileView.getId() == proId){
                    view.getPane().getChildren().remove(projectileView.getDrawable());
                    myProjectileViews.remove(projectileView);
                    break;
                }
            }

        }


        if (outOfScreen != null){
            int id = outOfScreen.getId();
            projectiles.remove(outOfScreen);
            if(outOfScreen.getProperty() == Projectile.Property.My){
                for ( MyProjectileView projectileView : myProjectileViews){
                    if (projectileView.getId() == id){
                        view.getPane().getChildren().remove(projectileView.getDrawable());
                        myProjectileViews.remove(projectileView);
                        break;
                    }
                }
            } else if (outOfScreen.getProperty() == Projectile.Property.Alien){
                for ( AlienProjectileView projectileView : alienProjectileViews){
                    if (projectileView.getId() == id){
                        view.getPane().getChildren().remove(projectileView.getDrawable());
                        alienProjectileViews.remove(projectileView);
                        break;
                    }
                }
            }
        }

    }));

    //private Timeline

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
                        myProjectileViews.add(myProjectileView);
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
        alienMove.setCycleCount(Animation.INDEFINITE);
        alienMove.play();
        userShooting.setCycleCount(Animation.INDEFINITE);
        userShooting.play();
        alienShooting.setCycleCount(Animation.INDEFINITE);
        alienShooting.play();
        projecileMoving.setCycleCount(Animation.INDEFINITE);
        projecileMoving.play();

    }





}
