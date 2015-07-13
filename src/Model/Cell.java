/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author admin
 */
public class Cell {

    public static final int EMPTY_CELL_CODE = 0;
    int code;

    void setCode(int code) {
        this.code = code;
    }

    int getCode() {
        return this.code;
    }

    @Override
    public String toString() {
        return new Integer(code).toString();
    }

}
