/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.util.Arrays;

/**
 *
 * @author Amr
 */
public class Player {

    public Player() {
        this.kalah = 0;
        Arrays.fill(this.pits, 6);
    }

    // value here is the number of pebbles per pit
    public Player(int kal, int value, int index) {
        this.kalah = kal;
        Arrays.fill(this.pits, value);
        this.index = index;
    }

    public Player(int kal, int[] pits, int index) {
        this.kalah = kal;
        this.pits = pits;
        this.index = index;
    }

    /**
     * @return the kalah
     */
    public int getKalah() {
        return kalah;
    }

    /**
     * @param kalah the kalah to set
     */
    public void setKalah(int kalah) {
        this.kalah = kalah;
    }

    /**
     * @return the pits
     */
    public int[] getPits() {
        return pits;
    }

    /**
     * @param pits the pits to set
     */
    public void setPits(int[] pits) {
        this.pits = pits;
    }

    private int kalah;
    private int[] pits;
    private int index;

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

}
