package ru.netology.oop;

public class Radio {
    private int currentStationNumber;
    private int currentVolume;

    public int getCurrentStationNumber() {
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
        if (currentStationNumber != 9) {
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
            currentStationNumber = 9;
        }
        return currentStationNumber;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume > 100) {
            return;
        }
        if (newCurrentVolume < 0) {
            return;
        }
        currentVolume = newCurrentVolume;
    }

    public void louder() {    // повышает громкость на 1
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void quieter() {    // понижает громкость на 1
        if (currentVolume > 0) {
            currentVolume--;
        }
    }

    public void increaseVolume(int volume) { // увеличивает до нужной громкости
        int target = currentVolume;

        if (volume > 0) {
            while (target < volume) {
                louder();
                target++;
            }
        } else {
            while (target > volume) {
                quieter();
                target--;
            }
        }
        setCurrentVolume(target);
    }
}