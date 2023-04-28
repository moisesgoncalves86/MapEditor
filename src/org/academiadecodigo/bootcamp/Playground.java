package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.graphics.Grid;
import org.academiadecodigo.bootcamp.graphics.Picasso;

public class Playground {
    public static void main(String[] args) {
        Grid grid = new Grid(30, 30);
        Picasso cursor = new Picasso(0, 0, grid);
        Boss boss = new Boss(cursor, grid);
        KeyboardManager.initKeyEvents(boss);
    }
}
