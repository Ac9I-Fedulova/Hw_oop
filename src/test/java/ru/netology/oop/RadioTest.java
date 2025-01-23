package ru.netology.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

// граничные значения ввода радиостанции ( 10, -1,)

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

// границные значения Next (=max, !=max, 0) + граничные значения ввода номера станции ( 1, 9, 0)

    @Test
    public void shouldSwitchToNextRadioStationFromFirst() {    // нажмем Next находясь на 1 станции
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
        radio.next();

        int expected = 0;
        int actual = radio.getCurrentStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSwitchToNextRadioStationFromMin() {   // нажмем Next находясь на минимальной станции
        Radio radio = new Radio();

        radio.setCurrentStationNumber(0);
        radio.next();

        int expected = 1;
        int actual = radio.getCurrentStationNumber();

        Assertions.assertEquals(expected, actual);
    }

// // границные значения Prev (=min, !=min, 0) + граничные значения ввода номера станции ( 8, 9, 0)

    @Test
    public void shouldSwitchToPrevRadioStationFromEighth() {   // нажмем Prev находясь на 8 станции
        Radio radio = new Radio();

        radio.setCurrentStationNumber(8);
        radio.prev();

        int expected = 7;
        int actual = radio.getCurrentStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSwitchToPrevRadioStationUnderMin() {  // нажмем Prev находясь на минимальной станции
        Radio radio = new Radio();

        radio.setCurrentStationNumber(0);
        radio.prev();

        int expected = 9;
        int actual = radio.getCurrentStationNumber();

        Assertions.assertEquals(expected, actual);
    }

// верхние граничные значения увеличение громкости (99, 100, 101)

    @Test
    public void shouldIncreaseVolumeWithinLimit() {  // увеличение звука в существующем диапазоне
        Radio radio = new Radio();

        radio.increaseVolume(99);
        radio.louder();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotIncreaseVolumeAboveMax() {  // не должен увеличить звук выше максимального
        Radio radio = new Radio();

        radio.increaseVolume(100);
        radio.louder();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSwitchVolumeAboveMax() {  // не должен увеличить звук выше максимального
        Radio radio = new Radio();

        radio.increaseVolume(101);
        radio.louder();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    // нижние граничные значения уменьшения громкости (-1, 1, 0)

    @Test
    public void shouldNotSwitchVolumeUnderMin() {  // не должен переключать звук ниже минимального
        Radio radio = new Radio();

        radio.increaseVolume(-1);
        radio.quieter();


        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDecreaseVolumeWithinLimit() {  // понижение звука в существующем диапазоне ( c 1)
        Radio radio = new Radio();

        radio.increaseVolume(1);
        radio.quieter();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotDecreaseVolumeUnderMin() {  // не должен понижать звук ниже минимального
        Radio radio = new Radio();

        radio.increaseVolume(0);
        radio.quieter();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}