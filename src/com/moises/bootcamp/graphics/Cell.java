package com.moises.bootcamp.graphics;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {
    private Rectangle representation;
    private boolean painted;

    public Cell(int row, int col) {
        representation = new Rectangle(Grid.colToX(col),Grid.rowToY(row),Grid.CELL_SIZE,Grid.CELL_SIZE);
        representation.draw();
        painted = false;
    }

    public boolean isPainted() {
        return painted;
    }

    public void clear() {
        representation.draw();
        painted = false;
    }

    public void paint() {
        representation.setColor(Color.BLUE);
        representation.fill();
        painted = true;
    }

    @Override
    public String toString() {
        return painted ? "1" : "0";
    }
}
