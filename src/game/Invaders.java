package game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Invaders extends Application {

    private InvadersController controller = new InvadersController(this);
    private Pane pane = new Pane();
    private Scene scene = new Scene(pane);
    private Text title = new Text();
    private Button newGameButton = new Button();
    private Button exitButton = new Button();

    @Override
    public void start(Stage primaryStage) throws Exception{
        controller.setPane();
        controller.setTitle();
        controller.setExitButton();
        controller.setNewGameButton();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Space Invaders");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Pane getPane(){
        return this.pane;
    }

    public Text getTitle() {
        return title;
    }

    public Button getNewGameButton(){
        return newGameButton;
    }

    public Button getExitButton(){
        return exitButton;
    }

    public Scene getScene(){
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

}
