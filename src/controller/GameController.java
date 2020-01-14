package controller;

import model.Character;
import view.CharacterView;

public class GameController {

    private Character model;
    private CharacterView view = new CharacterView();

    public GameController(Character model){
        this.model = model;
    }

    public void update(int newX, int newY){

        view.getCharacter().setX(newX);
        view.getCharacter().setY(newY);

        model.setBottomBorder((int) (view.getCharacter().getY() + view.getPane().getPrefHeight()/2));
        model.setTopBorder((int) (view.getCharacter().getY() - view.getPane().getPrefHeight()/2));
        model.setLeftBorder((int) (view.getCharacter().getX() - view.getPane().getPrefWidth()/2));
        model.setRightBorder((int) (view.getCharacter().getX() + view.getPane().getPrefWidth()/2));

    }

}
