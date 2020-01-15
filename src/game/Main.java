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
import view.LevelView;

public class Main extends Application {

    private Pane pane = new Pane();
    private Stage stage;
    private Text title = new Text();
    private Button newGameButton = new Button();
    private Button exitButton = new Button();

    @Override
    public void start(Stage primaryStage) throws Exception{
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
        title.setText(MainConst.titleText);
        title.setTextOrigin(VPos.CENTER);
        title.setTextAlignment(TextAlignment.CENTER);
        title.setWrappingWidth(MainConst.paneWidth);
        title.setLayoutY(100);
    }

    public void setExitButton (){
        pane.getChildren().add(exitButton);
        exitButton.setPrefSize(MainConst.buttonWidth, MainConst.buttonHeight);
        exitButton.setLayoutX(MainConst.exitButtonX);
        exitButton.setLayoutY(MainConst.exitButtonY);
        exitButton.setText(MainConst.exitButtonText);

        exitButton.setOnMouseClicked(mouseEvent -> Platform.exit());
    }

    public void setNewGameButton (){
        pane.getChildren().add(newGameButton);
        newGameButton.setPrefSize(MainConst.buttonWidth, MainConst.buttonHeight);
        newGameButton.setLayoutX(MainConst.newGameButtonX);
        newGameButton.setLayoutY(MainConst.newGameButtonY);
        newGameButton.setText(MainConst.newGameButtonText);

        newGameButton.setOnMouseClicked(mouseEvent -> {
            LevelView view = new LevelView();
            stage.setScene(view.getScene());
        });
    }

}
