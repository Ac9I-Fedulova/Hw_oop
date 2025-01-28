package ru.netology.oop;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Radio {
    private int currentStationNumber;
    private int currentVolume;
    private int maxStation;

    public Radio() {
        this.maxStation = 9;
    }

    public Radio(int numberStations) {
        this.maxStation = numberStations - 1;
    }

    public int getCurrentStationNumber() {
        return this.currentStationNumber;
    }

    public void setCurrentStationNumber(int newCurrentStationNumber) {
        if (newCurrentStationNumber <= this.maxStation) {
            if (newCurrentStationNumber >= 0) {
                this.currentStationNumber = newCurrentStationNumber;
            }
        }
    }

    public int next() {
        if (this.currentStationNumber != this.maxStation) {
            ++this.currentStationNumber;
        } else {
            this.currentStationNumber = 0;
        }

        return this.currentStationNumber;
    }

    public int prev() {
        if (this.currentStationNumber != 0) {
            --this.currentStationNumber;
        } else {
            this.currentStationNumber = this.maxStation;
        }

        return this.currentStationNumber;
    }

    public int getCurrentVolume() {
        return this.currentVolume;
    }

    public void setCurrentVolume(int newCurrentVolume) {
        if (newCurrentVolume <= 100) {
            if (newCurrentVolume >= 0) {
                this.currentVolume = newCurrentVolume;
            }
        }
    }

    public void louder() {
        if (this.currentVolume < 100) {
            ++this.currentVolume;
        }

    }

    public void quieter() {
        if (this.currentVolume > 0) {
            --this.currentVolume;
        }

    }

    public int getMaxStation() {
        return this.maxStation;
    }

    public void setMaxStation(int maxStation) {
        this.maxStation = maxStation;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Radio)) {
            return false;
        } else {
            Radio other = (Radio) o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCurrentStationNumber() != other.getCurrentStationNumber()) {
                return false;
            } else if (this.getCurrentVolume() != other.getCurrentVolume()) {
                return false;
            } else {
                return this.getMaxStation() == other.getMaxStation();
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Radio;
    }

    public int hashCode() {
        int prime = 59;
        int result = 1;
        result = result * 59 + this.getCurrentStationNumber();
        result = result * 59 + this.getCurrentVolume();
        result = result * 59 + this.getMaxStation();
        return result;
    }

    public String toString() {
        int var10000 = this.getCurrentStationNumber();
        return "Radio(currentStationNumber=" + var10000 + ", currentVolume=" + this.getCurrentVolume() + ", maxStation=" + this.getMaxStation() + ")";
    }
}