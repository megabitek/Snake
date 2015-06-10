/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake;

/**
 *
 * @author admin
 */
public class Cell {

    //атрибут показывает что находится в ячейке, определяется из значения свойства cellCode класса Frog и Snake
    int code;

    void setCode(int code) {
        this.code = code;
    }

    int getCode() {
        return this.code;
    }

}
