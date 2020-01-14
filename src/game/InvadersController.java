package game;

import javafx.application.Platform;
import javafx.geometry.VPos;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import model.Level;

public class InvadersController {

    private Invaders model;

    public InvadersController(Invaders model){
        this.model = model;
    }

    public void setPane (){
        model.getPane().setPrefSize(InvadersView.getPaneWidth(), InvadersView.getPaneHeight());
    }

    public void setTitle (){
        model.getPane().getChildren().add(model.getTitle());
        model.getTitle().setFont(Font.font(InvadersView.getTitleFont(), InvadersView.getTitleSize()));
        model.getTitle().setText(InvadersView.getTitleText());
        model.getTitle().setTextOrigin(VPos.CENTER);
        model.getTitle().setTextAlignment(TextAlignment.CENTER);
        model.getTitle().setWrappingWidth(InvadersView.getPaneWidth());
        model.getTitle().setLayoutY(100);
    }

    public void setExitButton (){
        model.getPane().getChildren().add(model.getExitButton());
        model.getExitButton().setPrefSize(InvadersView.getButtonWidth(), InvadersView.getButtonHeight());
        model.getExitButton().setLayoutX(InvadersView.getExitButtonX());
        model.getExitButton().setLayoutY(InvadersView.getExitButtonY());
        model.getExitButton().setText(InvadersView.getExitButtonText());

        model.getExitButton().setOnMouseClicked(mouseEvent -> Platform.exit());
    }

    public void setNewGameButton (){
        model.getPane().getChildren().add(model.getNewGameButton());
        model.getNewGameButton().setPrefSize(InvadersView.getButtonWidth(), InvadersView.getButtonHeight());
        model.getNewGameButton().setLayoutX(InvadersView.getNewGameButtonX());
        model.getNewGameButton().setLayoutY(InvadersView.getNewGameButtonY());
        model.getNewGameButton().setText(InvadersView.getNewGameButtonText());

        model.getNewGameButton().setOnMouseClicked(mouseEvent -> {
            Level level = new Level();
            model.setScene(level.getScene());
        });
    }

}
