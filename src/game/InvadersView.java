package game;

public class InvadersView {

    private final static int paneWidth = 1000;
    private final static int paneHeight = 600;

    private final static int titleSize = 60;
    private final static String titleFont = "Verdana";
    private final static String titleText = "Space Invaders";

    private final static int buttonWidth = 200;
    private final static int buttonHeight = 100;

    private final static String exitButtonText = "Exit";
    private final static int exitButtonX = 150;
    private final static int exitButtonY = 400;

    private final static String newGameButtonText = "New Game";
    private final static int newGameButtonX = 150;
    private final static int newGameButtonY = 200;

    public static int getExitButtonX() {
        return exitButtonX;
    }

    public static int getExitButtonY() {
        return exitButtonY;
    }

    public static int getNewGameButtonX() {
        return newGameButtonX;
    }

    public static int getNewGameButtonY() {
        return newGameButtonY;
    }

    public static int getButtonWidth() {
        return buttonWidth;
    }

    public static int getButtonHeight() {
        return buttonHeight;
    }

    public static String getExitButtonText() {
        return exitButtonText;
    }

    public static String getNewGameButtonText() {
        return newGameButtonText;
    }

    public static int getPaneHeight() {
        return paneHeight;
    }

    public static int getPaneWidth() {
        return paneWidth;
    }

    public static int getTitleSize() {
        return titleSize;
    }

    public static String getTitleFont() {
        return titleFont;
    }

    public static String getTitleText() {
        return titleText;
    }
}
