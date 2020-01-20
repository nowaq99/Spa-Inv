package game;

import javafx.stage.Stage;
import model.Stats;

public class YouWinScreen extends EndScreen {

    public YouWinScreen(Stage stage, Stats stats){
        super(stage, MainConst.winTitleText, stats);
        setStats();
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
            getStats().setLowestTime(getStats().getTime());
        }

    }

}
