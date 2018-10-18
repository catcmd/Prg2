import java.util.Scanner;

/**
 * Simple simulation for the "Game of Life"
 * Created by Wolfgang Mühlbauer on 20.03.2017.
 */
public class GameOfLife {

    /**
     * prints living cells to console. Living cells are marked as "X", dead cells as "O".
     * @param c array of cells. True denotes living cells.
     */
    private static void printCells(boolean[][] c) {

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                if (c[i][j])    // cell is alife
                    System.out.print("X ");
                else            // cell is dead
                    System.out.print("  ");
            }
            System.out.println();
        }
    }

    /**
     * count number of neighboring cells that are alife 
     * @param c 2-dimensional boolean array of cells (true means that cell is alife)
     * @param x row of considered cell
     * @param y column of considered cell
     * @return number of living cells that are neighbors to cell c[x][y]
     */
    private static int countLivingNeighbors(boolean[][] c, int x, int y) {

        int count = 0;


		int g = 0;
		int h = 0;
		
        // iterate over all 8 neighbors of cell c[x][y]
        for (int i = (x - 1); i < x + 2; i++) {
            for (int j = (y - 1); j < (y + 2); j++) {

                // take care of edge cases: e.g. a visited cell has no left/right/upper/lower neighbor
				if (i >= 0 && i < c.length && j >= 0 && j < c[0].length && c[i][j]) {
					count++;
				}
				
				// We do the bagle thing and right neighbours are on the left and
				// top neighbours are on the bottom (and vice versa)
				/*
				g=(i+10)%(c.length);
				h=(j+10)%(c[0].length);
				if(c[g][h]){
					count++;
				}
				*/
				
            }
        }
        // correction: cell c[x]c[y] has been counted twice
        if (c[x][y])
            count--;
        return count;
    }

    /**
     * compute next iteration / next generation of cells based on given rules
     * @param cells current generation: 2-dimensional boolean array of cells (true means that cell is alife)
     * @return next generation, same representation as 2-dimensional array of cells
     */
    private static boolean[][] computeNextGenCells(boolean[][] cells) {

        // initialize new array to store result
        boolean[][] nextGenCells = new boolean[cells.length][cells[0].length];

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[0].length; j++) {

                // How many neighbors has cell[i][j]?
                int neighbors = countLivingNeighbors(cells, i, j);

                if (cells[i][j]) {
                    // Rule 1, 2: living cell with less than 2 neighbors or more than 3 neighbors die
                    if ((neighbors < 2) || (neighbors > 3))
                        nextGenCells[i][j] = false;

                    // Rule 3: living cell with 2 or 3 neighbors stays alife
                    if ((neighbors == 2) || (neighbors == 3))
                        nextGenCells[i][j] = true;
                }

                else {
                    // Rule 4: Dead cell with exactly 3 neighbors is reborn in next generation
                    if (neighbors == 3)
                        nextGenCells[i][j] = true;
                }
            }
        }
        return nextGenCells;
    }


    /**
     * main method
     */
    public static void main(String[] args) {

        // world consists 0f 10 x 10 elements
        boolean[][] cells = new boolean[10][10];

        // initialize "cells": likelihood shall be 50% that a cell is alife
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (Math.random() >= 0.5) {
                    cells[i][j] = true;
                    // Hint: No initialization -> default value is false in Java
                }
            }
        }

        // print out first generation
        System.out.println("Generation #1");
        printCells(cells);

        Scanner scanner = new Scanner(System.in);
        int i = 1;
        do {

            cells = computeNextGenCells(cells);
            System.out.println("Generation #:" + (++i));
            printCells(cells);
            System.out.println("Should I compute another generation? 'y' for \"yes\"");
        } while (scanner.next().equals("y"));


        System.out.println("Terminating");
    }
}