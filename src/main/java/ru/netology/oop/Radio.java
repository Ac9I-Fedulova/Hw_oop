package ru.netology.oop;

public class Radio {
    public int currentStationNumber;
    public int currentVolume;

    public  int getCurrentStationNumber() {
        return currentStationNumber;
    }

    public void setCurrentStationNumber(int newCurrentStationNumber) {
        if (newCurrentStationNumber > 9) {
            return;
        }
        if (newCurrentStationNumber < 0) {
            return;
        }
        currentStationNumber = newCurrentStationNumber;
    }

    public int next() {   // переключает радио станцию вперед
        if (currentStationNumber == 9) {
            currentStationNumber = 0;
        }
        if (currentStationNumber > 0) {
            currentStationNumber = currentStationNumber + 1;
        }
        return currentStationNumber;
    }

    public int prev() {    // переключает радио станцию назад
        if (currentStationNumber > 0) {
            currentStationNumber = currentStationNumber - 1;
        }
        if (currentStationNumber == 0) {
            currentStationNumber = 9;
        }
        return currentStationNumber;
    }
}