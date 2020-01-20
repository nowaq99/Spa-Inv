package game;

import javafx.stage.Stage;
import model.Stats;

import java.io.FileNotFoundException;

public class YouLostScreen extends EndScreen {

    public YouLostScreen(Stage stage, Stats stats) throws FileNotFoundException {
        super(stage, MainConst.lostTitleText, stats);
        setStats();
        saveStats();
    }

}
