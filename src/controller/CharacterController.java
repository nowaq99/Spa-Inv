package controller;

import javafx.scene.layout.Pane;
import model.Character;
import view.CharacterView;

public class CharacterController {

    private Character model;
    private CharacterView view = new CharacterView();

    public CharacterController(Character model){
        this.model = model;
    }

    public void firstSetup(int posX, int posY, int width, int height, Pane pane){

        view.getCharacter().setWidth(width);
        view.getCharacter().setHeight(height);
        view.getCharacter().setLayoutX((double) width/2);
        view.getCharacter().setLayoutY((double) height/2);
        view.getCharacter().setX(posX);
        view.getCharacter().setY(posY);
        view.setPane(pane);
        view.getPane().getChildren().add(view.getCharacter());

        model.setBottomBorder((int) view.getCharacter().getY() + height/2);
        model.setTopBorder((int) view.getCharacter().getY() - height/2);
        model.setLeftBorder((int) view.getCharacter().getX() - width/2);
        model.setRightBorder((int) view.getCharacter().getX() + width/2);
        model.setMaxLeft(0);
        model.setMaxRight((int)view.getPane().getPrefWidth());
        model.setMaxBottom((int)view.getPane().getPrefHeight());
        model.setMaxTop(0);
        model.setMovingLeft(false);
        model.setMovingRight(false);
        model.setShooting(false);

    }

}
