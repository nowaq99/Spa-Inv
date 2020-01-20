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
import java.io.PrintWriter;

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
    private Stats stats;

    public EndScreen(Stage stage, String title1, Stats stats){

        controllerStage = stage;
        setPane();
        scene = new Scene(pane);
        setTitle();
        setExitButton();
        setNewGameButton();
        setStatsButton();
        title.setText(title1);
        this.stats = stats;

    }

    public void setStats(){

        if (stats.getYourShots() != 0){
            stats.setAccuracy(stats.getYourAccurateShots()*100/stats.getYourShots());
        }
        if (stats.getYourTotalShots() != 0){
            stats.setTotalAccuracy(stats.getYourTotalAccurateShots()*100/stats.getYourTotalShots());
        }

    }

    public void saveStats() throws FileNotFoundException {

        PrintWriter file = new PrintWriter("src/stats/stats.txt");
        file.println("STATS:\n");
        file.println("highest_time:");
        file.println(stats.getHighestTime());
        file.println("lowest_time:");
        file.println(stats.getLowestTime());
        file.println("high_score:");
        file.println(stats.getHighScore());
        file.println("your_total_shots:");
        file.println(stats.getYourTotalShots());
        file.println("your_accuracy_shots:");
        file.println(stats.getYourTotalAccurateShots());
        file.println("get_hurt:");
        file.println(stats.getAlienAccurateShots());
        file.println("total_games:");
        file.println(stats.getTotalGames());
        file.println("win_games:");
        file.println(stats.getWinGames());
        file.close();

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

    public Stats getStats() {
        return stats;
    }

    public void setTitle (){
        pane.getChildren().addAll(title, score);
        title.setFont(Font.font(MainConst.font, MainConst.titleSize));
        score.setFont(Font.font(MainConst.font, MainConst.titleSize));
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

        statsButton.setOnMouseClicked(mouseEvent -> {

            StatsScreen screen = new StatsScreen(controllerStage, scene, stats);
            controllerStage.setScene(screen.getScene());

        });
    }


}
