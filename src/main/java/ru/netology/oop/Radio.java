package ru.netology.oop;

public class Radio {
    private int currentStationNumber;
    private int currentVolume;
    private int maxStation;

    public Radio () {
        this.maxStation =9;
    }

    public Radio (int numberStations ) {
        this.maxStation = numberStations - 1;
    }

    public int getCurrentStationNumber() {
        return currentStationNumber;
    }

    public void setCurrentStationNumber(int newCurrentStationNumber) {
        if (newCurrentStationNumber > maxStation) {
            return;
        }
        if (newCurrentStationNumber < 0) {
            return;
        }
        currentStationNumber = newCurrentStationNumber;
    }

    public int next() {   // переключает радио станцию вперед
        if (currentStationNumber != maxStation) {
            currentStationNumber++;
        } else {
            currentStationNumber = 0;
        }
        return currentStationNumber;
    }

    public int prev() {    // переключает радио станцию назад
        if (currentStationNumber != 0) {
            currentStationNumber--;
        } else {
            currentStationNumber = maxStation;
        }
        return currentStationNumber;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

//    public void setCurrentVolume(int newCurrentVolume) {
//        if (newCurrentVolume > 100) {
//            return;
//        }
//        if (newCurrentVolume < 0) {
//            return;
//        }
//        currentVolume = newCurrentVolume;
//    }

    public void louder() {     // повышает громкость на 1
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void quieter() {    // понижает громкость на 1
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}