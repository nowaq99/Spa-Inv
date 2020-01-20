package game;

import javafx.stage.Stage;
import model.Stats;

import java.io.FileNotFoundException;

public class YouWinScreen extends EndScreen {

    public YouWinScreen(Stage stage, Stats stats) throws FileNotFoundException {
        super(stage, MainConst.winTitleText, stats);
        setStats();
        saveStats();
    }

    public void setStats(){

        super.setStats();

        if (getStats().getPoints() > getStats().getHighScore()){
            getStats().setHighScore(getStats().getPoints());
        }
        if (getStats().getTime() < getStats().getLowestTime()){
            getStats().setLowestTime(getStats().getTime());
        }
        if (getStats().getTime() > getStats().getHighestTime()){
            getStats().setHighestTime(getStats().getTime());
        }

    }

}
