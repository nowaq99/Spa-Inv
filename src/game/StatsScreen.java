package game;

import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.Stats;


public class StatsScreen {

    private Pane pane = new Pane();
    private Scene scene;
    private Scene backScene;
    private Text title = new Text();
    private Button backButton = new Button();
    private Stage controllerStage;

    StatsScreen(Stage stage, Scene backScene, Stats stats) {

        controllerStage = stage;
        scene = new Scene(pane);
        this.backScene = backScene;
        setPane();
        setTitle();
        setBackButton();

        int posX = 150;
        int posY = 250;
        int interspaceY = 40;

        setSimpleStat(posX,posY,"Alien Shots", stats.getAlienShots());
        posY += interspaceY;
        setSimpleStat(posX,posY,"Your Shots", stats.getYourShots());
        posY += interspaceY;
        setSimpleStat(posX,posY,"Accuracy [%]", stats.getAccuracy());
        posY += interspaceY;
        setSimpleStat(posX,posY,"Time [s]", stats.getTime());
        posY += interspaceY;
        setSimpleStat(posX,posY,"Score", stats.getPoints());

        posX = 450;
        posY = 200;

        setSimpleStat(posX,posY,"Longest Game [s]", stats.getHighestTime());
        posY += interspaceY;
        setSimpleStat(posX,posY,"Shortest Game [s]", stats.getLowestTime());
        posY += interspaceY;
        setSimpleStat(posX,posY,"High Score", stats.getHighScore());
        posY += interspaceY;
        setSimpleStat(posX,posY,"Your Total Shots", stats.getYourTotalShots());
        posY += interspaceY;
        setSimpleStat(posX,posY,"Medium Accuracy [%]", stats.getTotalAccuracy());
        posY += interspaceY;
        setSimpleStat(posX,posY,"Lost Lives", stats.getAlienAccurateShots());
        posY += interspaceY;
        setSimpleStat(posX,posY,"Total Games", stats.getTotalGames());
        posY += interspaceY;
        setSimpleStat(posX,posY,"Win Games", stats.getWinGames());

    }

    private void setSimpleStat(int posX, int posY, String name, int value) {

        Text stat = new Text();
        stat.setFont(Font.font(MainConst.font, MainConst.statSize));
        stat.setLayoutY(-MainConst.statSize);
        stat.setX(posX);
        stat.setY(posY);
        stat.setText(name + ": " + value);
        pane.getChildren().add(stat);

    }

    private void setTitle(){

        pane.getChildren().addAll(title);
        title.setFont(Font.font(MainConst.font, MainConst.titleSize));
        title.setTextOrigin(VPos.CENTER);
        title.setTextAlignment(TextAlignment.CENTER);
        title.setWrappingWidth(MainConst.paneWidth);
        title.setY(100);
        title.setText(MainConst.statsTitle);

    }

    private void setBackButton(){

        pane.getChildren().add(backButton);
        backButton.setPrefSize(MainConst.backButtonWidth, MainConst.backButtonHeight);
        backButton.setLayoutX(MainConst.backButtonX);
        backButton.setLayoutY(MainConst.backButtonY);
        backButton.setText(MainConst.backButtonText);

        backButton.setOnMouseClicked(mouseEvent -> controllerStage.setScene(backScene));


    }

    public Scene getScene(){

        return scene;

    }

    private void setPane() {
        pane.setPrefSize(MainConst.paneWidth, MainConst.paneHeight);
    }

}
