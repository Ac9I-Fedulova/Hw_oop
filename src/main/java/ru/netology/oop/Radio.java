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

    public int getCurrentVolume() {
        return currentVolume;
    }

    public  void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume > 100) {
            return;
        }
        if (newCurrentVolume < 0) {
            return;
        }
        currentVolume = newCurrentVolume;
    }

    public void louder() {
        if (currentVolume < 100) {
            currentVolume = currentVolume + 1;
        }
    }

    public void quieter() {
        if (currentVolume > 0) {
            currentVolume = currentVolume - 1;
        }
    }

}