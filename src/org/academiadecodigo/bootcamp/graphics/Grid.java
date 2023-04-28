package org.academiadecodigo.bootcamp.graphics;

import java.util.Arrays;

public class Grid {
    public static final int CELL_SIZE = 15;
    public static final int PADDING = 10;

    private Cell[][] cells;
    private int cols;
    private int rows;

    public Grid(int rows, int cols) {
        this.cols = cols;
        this.rows = rows;
        initCells();
    }

    private void initCells() {
        cells = new Cell[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col] = new Cell(row, col);
            }
        }
    }

    public void paintCell(int row, int col) {
        Cell c = cells[row][col];
        if (c.isPainted()) {
            c.clear();
            return;
        }
        c.paint();
    }

    public static int colToX(int col) {
        return col * CELL_SIZE + PADDING;
    }

    public static int rowToY(int row) {
        return row * CELL_SIZE + PADDING;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void fromString(String gridString) {
        if(gridString == null){
            return;
        }
        String[] lines = gridString.split("\n");
        for (int row = 0; row < lines.length; row++) {
            String[] line = lines[row].split("");
            for (int col = 0; col < line.length; col++) {
                if (line[col].equals("1")) {
                    cells[row][col].paint();
                } else {
                    cells[row][col].clear();
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Cell[] innerArray : cells) {
            for (Cell cell : innerArray) {
                builder.append(cell.toString());
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}
