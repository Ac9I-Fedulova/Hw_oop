package ru.netology.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {

// граничные значения ввода радиостанции ( 10, -1,)

    @Test
    public void shouldInsertRadioStationAboveMax() {    // включит станцию выше максимальной
        Radio radio = new Radio();

        radio.setCurrentStationNumber(10);

        int expected = 0;
        int actual = radio.getCurrentStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertRadioStationUnderMin() {    // не должен включить станцию ниже минимальной
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
    public void shouldSwitchFromMaxToMinRadioStation() {   // Next с 9 станции должен переключить на 0
        Radio radio = new Radio();

        radio.setCurrentStationNumber(9);
        radio.next();

        int expected = 0;
        int actual = radio.getCurrentStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSwitchToNextRadioStationFromMin() {   // нажмем Next находясь на 0 станции
        Radio radio = new Radio();

        radio.setCurrentStationNumber(0);
        radio.next();

        int expected = 1;
        int actual = radio.getCurrentStationNumber();

        Assertions.assertEquals(expected, actual);
    }

// // границные значения Prev (=min, !=min, 0) + граничные значения ввода номера станции ( 8, 0)

    @Test
    public void shouldSwitchToPrevRadioStationFromEighth() {   // Prev с 8 станции переключит на 7ую
        Radio radio = new Radio();

        radio.setCurrentStationNumber(8);
        radio.prev();

        int expected = 7;
        int actual = radio.getCurrentStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSwitchFromMinToMaxRadioStation() {  //  Prev с 0 станции должен переключить на 9
        Radio radio = new Radio();

        radio.setCurrentStationNumber(0);
        radio.prev();

        int expected = 9;
        int actual = radio.getCurrentStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertStationAboveMaxIndicatingStations() {    // включит станцию выше мах при указании станций
        Radio radio = new Radio(30);

        radio.setCurrentStationNumber(30);

        int expected = 0;
        int actual = radio.getCurrentStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldInsertStationWithinLimitIndicatingStations() {   // включит станцию в сущ-ем диапазоне
        // при указании станций
        Radio radio = new Radio(30);

        radio.setCurrentStationNumber(10);

        int expected = 10;
        int actual = radio.getCurrentStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSwitchFromMaxToMinStationIndicatingStations() {   // Next с мах станции переключит на 0
        Radio radio = new Radio(30);

        radio.setCurrentStationNumber(29);
        radio.next();

        int expected = 0;
        int actual = radio.getCurrentStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSwitchFromMinToMaxStationIndicatingStations() {  //  Prev с 0 станции переключит на мах
        // при указании числа станций
        Radio radio = new Radio(30);

        radio.setCurrentStationNumber(0);
        radio.prev();

        int expected = 29;
        int actual = radio.getCurrentStationNumber();

        Assertions.assertEquals(expected, actual);
    }

// верхние граничные значения увеличение громкости (99, 100)

    @Test
    public void shouldIncreaseVolumeWithinLimit() {  // увеличение звука в существующем диапазоне с 99
        Radio radio = new Radio();

        for (int volume = 0; volume < 99; volume++) {
            radio.louder();
        }
        radio.louder();

        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotIncreaseVolumeAboveMax() {  // не должен увеличить звук выше максимального
        Radio radio = new Radio();

        for (int volume = 0; volume < 100; volume++) {
            radio.louder();
        }
        radio.louder();


        int expected = 100;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    // нижние граничные значения уменьшения громкости ( 1, 0)

    @Test
    public void shouldNotSwitchVolumeUnderMin() {  // не должен переключать звук ниже минимального
        Radio radio = new Radio();

        radio.quieter();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldDecreaseVolumeWithinLimit() {  // понижение звука в существующем диапазоне ( c 2 до 0)
        Radio radio = new Radio();

        for (int volume = 0; volume < 2; volume++) {
            radio.louder();
        }
        radio.quieter();
        radio.quieter();

        int expected = 0;
        int actual = radio.getCurrentVolume();

        Assertions.assertEquals(expected, actual);
    }
}