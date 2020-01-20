package game;

import controller.GameController;
import javafx.application.Application;
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

public class Main extends Application {

    private Pane pane = new Pane();
    private Stage stage;
    private Text title = new Text();
    private Button newGameButton = new Button();
    private Button exitButton = new Button();
    private GameController controller = new GameController();
    private Stats stats = new Stats(true);

    public Main() throws FileNotFoundException {
    }

    @Override
    public void start(Stage primaryStage) {
        this.setPane();
        this.setTitle();
        this.setExitButton();
        this.setNewGameButton();
        Scene scene = new Scene(pane);
        stage = primaryStage;
        primaryStage.setScene(scene);
        primaryStage.setTitle("Space Invaders");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Stage getStage() {
        return stage;
    }

    public void setPane (){
        pane.setPrefSize(MainConst.paneWidth, MainConst.paneHeight);
    }

    public void setTitle (){
        pane.getChildren().add(title);
        title.setFont(Font.font(MainConst.titleFont, MainConst.titleSize));
        title.setText(MainConst.mainTitleText);
        title.setTextOrigin(VPos.CENTER);
        title.setTextAlignment(TextAlignment.CENTER);
        title.setWrappingWidth(MainConst.paneWidth);
        title.setLayoutY(100);
    }

    public void setExitButton (){
        pane.getChildren().add(exitButton);
        exitButton.setPrefSize(MainConst.buttonWidth, MainConst.buttonHeight);
        exitButton.setLayoutX(MainConst.mainExitButtonX);
        exitButton.setLayoutY(MainConst.mainExitButtonY);
        exitButton.setText(MainConst.exitButtonText);

        exitButton.setOnMouseClicked(mouseEvent -> Platform.exit());
    }

    public void setNewGameButton (){
        pane.getChildren().add(newGameButton);
        newGameButton.setPrefSize(MainConst.buttonWidth, MainConst.buttonHeight);
        newGameButton.setLayoutX(MainConst.mainNewGameButtonX);
        newGameButton.setLayoutY(MainConst.mainNewGameButtonY);
        newGameButton.setText(MainConst.newGameButtonText);

        newGameButton.setOnMouseClicked(mouseEvent -> controller.startGame(stage, stats));
    }

}
