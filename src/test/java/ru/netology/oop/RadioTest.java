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
    public void shouldSwitchToNextRadioStation() {    // включим станцию в диапазоне и нажмем Next
        Radio radio = new Radio();

        radio.setCurrentStationNumber(3);

        int expected = 4;
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
    public void shouldSwitchToPrevRadioStation() {   // включим станцию в диапазоне и нажмем Prev
        Radio radio = new Radio();

        radio.setCurrentStationNumber(6);

        int expected = 5;
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
    public void shouldIncreaseVolume() {  // увеличени звука в ceщ-ем диапозоне
        Radio radio = new Radio();

        radio.setCurrentVolume(100);
        radio.louder();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDecreaseVolume() {  // уменьшение звука в ceщ-ем диапозоне
        Radio radio = new Radio();

        radio.setCurrentVolume(23);
        radio.quieter();

        int expected = 22;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }


}