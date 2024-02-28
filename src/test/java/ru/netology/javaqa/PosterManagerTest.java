package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class PosterManagerTest {

    @Test
    public void zeroFilms() {
        PosterManager manager = new PosterManager();
        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void severalFilms() {
        PosterManager manager = new PosterManager();

        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель <Белград> ");

        String[] expected = {"Бладшот", "Вперёд", "Отель <Белград> "};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void lastFilms() {
        PosterManager manager = new PosterManager();

        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель <Белград> ");

        String[] expected = {"Отель <Белград> ", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void moreLimit() {
        PosterManager manager = new PosterManager();

        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель <Белград>");
        manager.add("Джентельмены");
        manager.add("Человек-невидимка");
        manager.add("Тролли. Мировой тур");

        String[] expected = {"Тролли. Мировой тур", "Человек-невидимка", "Джентельмены", "Отель <Белград>", "Вперёд"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void moreLimitConst() {
        PosterManager manager = new PosterManager(5);

        manager.add("Бладшот");
        manager.add("Вперёд");
        manager.add("Отель <Белград>");
        manager.add("Джентельмены");
        manager.add("Человек-невидимка");
        manager.add("Тролли. Мировой тур");

        String[] expected = {"Тролли. Мировой тур", "Человек-невидимка", "Джентельмены", "Отель <Белград>", "Вперёд"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

}
