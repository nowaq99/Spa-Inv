package game;

import controller.GameController;
import javafx.application.Platform;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.Stats;

import java.io.FileNotFoundException;

public class EndScreen {

    private Pane pane = new Pane();
    private Scene scene;
    private Text title = new Text();
    private Text score = new Text("0");
    private Button newGameButton = new Button();
    private Button exitButton = new Button();
    private Button statsButton = new Button();
    private GameController controller = new GameController();
    private Stage controllerStage;

    public EndScreen(Stage stage, String title1){

        controllerStage = stage;
        setPane();
        scene = new Scene(pane);
        setTitle();
        setExitButton();
        setNewGameButton();
        setStatsButton();
        title.setText(title1);

    }

    public void setScore(int score) {
        this.score.setText(Integer.toString(score));
    }

    public void setPane() {
        pane.setPrefSize(MainConst.paneWidth, MainConst.paneHeight);
    }

    public Pane getPane() {
        return pane;
    }

    public Scene getScene() {
        return scene;
    }

    public void setTitle (){
        pane.getChildren().addAll(title, score);
        title.setFont(Font.font(MainConst.titleFont, MainConst.titleSize));
        score.setFont(Font.font(MainConst.titleFont, MainConst.titleSize));
        title.setTextOrigin(VPos.CENTER);
        score.setTextOrigin(VPos.CENTER);
        title.setTextAlignment(TextAlignment.CENTER);
        score.setTextAlignment(TextAlignment.CENTER);
        title.setWrappingWidth(MainConst.paneWidth);
        score.setWrappingWidth(MainConst.paneWidth);
        title.setY(100);
        score.setY(170);
    }

    public void setExitButton (){
        pane.getChildren().add(exitButton);
        exitButton.setPrefSize(MainConst.buttonWidth, MainConst.buttonHeight);
        exitButton.setLayoutX(MainConst.endExitButtonX);
        exitButton.setLayoutY(MainConst.endExitButtonY);
        exitButton.setText(MainConst.exitButtonText);

        exitButton.setOnMouseClicked(mouseEvent -> Platform.exit());
    }

    public void setNewGameButton (){
        pane.getChildren().add(newGameButton);
        newGameButton.setPrefSize(MainConst.buttonWidth, MainConst.buttonHeight);
        newGameButton.setLayoutX(MainConst.endNewGameButtonX);
        newGameButton.setLayoutY(MainConst.endNewGameButtonY);
        newGameButton.setText(MainConst.newGameButtonText);

        newGameButton.setOnMouseClicked(mouseEvent -> {

            try {
                controller.startGame(controllerStage, new Stats(false));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        });
    }

    public void setStatsButton () {
        pane.getChildren().add(statsButton);
        statsButton.setPrefSize(MainConst.buttonWidth, MainConst.buttonHeight);
        statsButton.setLayoutX(MainConst.endStatsButtonX);
        statsButton.setLayoutY(MainConst.endStatsButtonY);
        statsButton.setText(MainConst.statsButtonText);
    }


}
