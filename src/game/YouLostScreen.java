package game;

import javafx.stage.Stage;
import model.Stats;

public class YouLostScreen extends EndScreen {

    public YouLostScreen(Stage stage, Stats stats) {
        super(stage, MainConst.lostTitleText, stats);
        setStats();
    }

}
