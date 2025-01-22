package ru.netology.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

    @Test
    public void shouldInsertRadioStationAboveMax() {    // включим станцию выше максимальной
        Radio radio = new Radio();

        radio.setCurrentStationNumber(10);

        int expected = 0;
        int actual = radio.getCurrentStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertRadioStationUnderMin() {    // включим станцию ниже максимальной
        Radio radio = new Radio();

        radio.setCurrentStationNumber(-1);

        int expected = 0;
        int actual = radio.getCurrentStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSwitchToNextRadioStationFromFirst() {    // включим станцию в диапазоне (с 1) и нажмем Next
        Radio radio = new Radio();

        radio.setCurrentStationNumber(1);

        int expected = 2;
        int actual = radio.next();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSwitchToNextRadioStationAboveMax() {   // нажмем Next находясь на максимальной станции
        Radio radio = new Radio();

        radio.setCurrentStationNumber(9);

        int expected = 0;
        int actual = radio.next();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSwitchToPrevRadioStationFromEighth() {   // включим станцию в диапазоне (c 8) и нажмем Prev
        Radio radio = new Radio();

        radio.setCurrentStationNumber(8);

        int expected = 7;
        int actual = radio.prev();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSwitchToPrevRadioStationUnderMin() {  // нажмем Prev находясь на минимальной станции
        Radio radio = new Radio();

        radio.setCurrentStationNumber(0);

        int expected = 9;
        int actual = radio.prev();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseVolumeWithinLimit() {  // увеличени звука в существующем диапазоне
        Radio radio = new Radio();

        radio.setCurrentVolume(99);
        radio.louder();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotIncreaseVolumeAboveMax() {  // не должен увеличить звук выше максимального
        Radio radio = new Radio();

        radio.setCurrentVolume(100);
        radio.louder();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDecreaseVolumeWithinLimit() {  // понижение звука в существующем диапазоне
        Radio radio = new Radio();

        radio.setCurrentVolume(1);
        radio.quieter();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotDecreaseVolumeUnderMin() {  // не должен понижать звук ниже минимального
        Radio radio = new Radio();

        radio.setCurrentVolume(0);
        radio.quieter();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }


}