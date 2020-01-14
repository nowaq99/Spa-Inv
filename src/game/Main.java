package game;

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
import model.Level;

public class Main extends Application {

    //private InvadersController controller = new InvadersController(this);
    private Pane pane = new Pane();
    private Scene scene = new Scene(pane);
    private Text title = new Text();
    private Button newGameButton = new Button();
    private Button exitButton = new Button();

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.setPane();
        this.setTitle();
        this.setExitButton();
        this.setNewGameButton();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Space Invaders");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
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
            Level level = new Level();
            scene = level.getScene();
        });
    }

}
