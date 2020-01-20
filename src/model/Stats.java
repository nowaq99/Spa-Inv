package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Stats {

    private int alienShots;
    private int yourShots;
    private int yourAccurateShots;
    private int accuracy;
    private int time;
    private int points;


    private int highestTime;
    private int lowestTime;
    private int highScore;
    private int yourTotalShots;
    private int yourTotalAccurateShots;
    private int alienAccurateShots;
    private int totalGames;
    private int winGames;
    private int totalAccuracy;


    public int getYourTotalShots() {
        return yourTotalShots;
    }

    public int getYourTotalAccurateShots() {
        return yourTotalAccurateShots;
    }

    public int getAlienShots() {
        return alienShots;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getAlienAccurateShots() {
        return alienAccurateShots;
    }

    public int getTotalGames() {
        return totalGames;
    }

    public int getWinGames() {
        return winGames;
    }

    public int getTotalAccuracy() {
        return totalAccuracy;
    }


    public void setTotalAccuracy(int totalAccuracy) {
        this.totalAccuracy = totalAccuracy;
    }

    public int getYourShots() {
        return yourShots;
    }

    public int getYourAccurateShots() {
        return yourAccurateShots;
    }

    public int getTime() {
        return time;
    }

    public int getPoints() {
        return points;
    }

    public int getHighestTime() {
        return highestTime;
    }

    public int getLowestTime() {
        return lowestTime;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighestTime(int highestTime) {
        this.highestTime = highestTime;
    }

    public void setLowestTime(int lowestTime) {
        this.lowestTime = lowestTime;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public Stats () throws FileNotFoundException {

        readStats();
        resetStats();

    }

    private void readStats() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/stats/stats.txt"));

        while (scanner.hasNext()){

            String line = scanner.nextLine();

            switch (line) {
                case "highest_time:":
                    highestTime = scanner.nextInt();
                    break;
                case "lowest_time:":
                    lowestTime = scanner.nextInt();
                    break;
                case "high_score:":
                    highScore = scanner.nextInt();
                    break;
                case "your_total_shots:":
                    yourTotalShots = scanner.nextInt();
                    break;
                case "your_accuracy_shots:":
                    yourTotalAccurateShots = scanner.nextInt();
                    break;
                case "get_hurt:":
                    alienAccurateShots = scanner.nextInt();
                    break;
                case "total_games:":
                    totalGames = scanner.nextInt();
                    break;
                case "win_games:":
                    winGames = scanner.nextInt();
                    break;
            }

        }

    }

    private void resetStats(){

        setAccuracy(0);
        setAlienShots(0);
        setPoints(0);
        setTime(0);
        setYourAccurateShots(0);
        setYourShots(0);

    }

    public void addToWinGames(){

        winGames += 1;

    }

    public void addToAlienShots(){

        alienShots += 1;

    }

    public void addToMyShots(){

        yourShots += 1;

    }

    public void addToMyAccurateShots(){

        yourAccurateShots += 1;

    }

    public void addToTime(){

        time += 1;

    }

    public void addToPoints(int points){

        this.points += points;

    }

    public void addToMyTotalShots(){

        yourTotalShots += 1;

    }

    public void addToMyTotalAccurateShots(){

        yourTotalAccurateShots += 1;

    }

    public void addToAlienAccurateShots(){

        alienAccurateShots += 1;

    }

    public void addToTotalGames(){

        totalGames += 1;

    }


    private void setAlienShots(int alienShots) {
        this.alienShots = alienShots;
    }

    private void setYourShots(int yourShots) {
        this.yourShots = yourShots;
    }

    private void setYourAccurateShots(int yourAccurateShots) {
        this.yourAccurateShots = yourAccurateShots;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    private void setTime(int time) {
        this.time = time;
    }

    private void setPoints(int points) {
        this.points = points;
    }

}
