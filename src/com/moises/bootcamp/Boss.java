package com.moises.bootcamp;

import com.moises.bootcamp.graphics.Grid;
import com.moises.bootcamp.graphics.Picasso;
import com.moises.bootcamp.utils.FileManager;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Boss implements KeyboardHandler {
    private Picasso cursor;
    private Grid grid;

    public Boss(Picasso cursor, Grid grid) {
        this.cursor = cursor;
        this.grid = grid;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_Q:
                System.exit(0);
                break;
            case KeyboardEvent.KEY_SPACE:
                cursor.setPaiNting(true);
                grid.paintCell(cursor.getRow(), cursor.getCol());
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                cursor.goUp();
                if(cursor.isPaiNting()){
                    grid.paintCell(cursor.getRow(), cursor.getCol());
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                cursor.goDown();
                if(cursor.isPaiNting()){
                    grid.paintCell(cursor.getRow(), cursor.getCol());
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                cursor.goLeft();
                if(cursor.isPaiNting()){
                    grid.paintCell(cursor.getRow(), cursor.getCol());
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                cursor.goRight();
                if(cursor.isPaiNting()){
                    grid.paintCell(cursor.getRow(), cursor.getCol());
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                cursor.setPaiNting(false);
                break;
            case KeyboardEvent.KEY_S:
                FileManager.write(grid.toString());
                break;
            case KeyboardEvent.KEY_L:
                grid.fromString(FileManager.read());
                break;
        }
    }
}
