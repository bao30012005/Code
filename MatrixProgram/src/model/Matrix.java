/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dell
 */
public class Matrix {

    private int row;
    private int column;
    private int[][] data;

    public Matrix(int row, int column) {
        this.row = row;
        this.column = column;
        data = new int[row][column];
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int[][] getData() {
        return data;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setValueAt(int i, int j, int value) {
        data[i][j] = value;
    }

    public int getValueAt(int i, int j) {
        return data[i][j];
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                result += "[" + data[i][j] + "]";
            }
            if (i != row - 1) {
                result += "\n";
            }
        }
        return result;
    }

    private boolean checkAddAndSub(Matrix second) {
        return (getRow() == second.getRow() && getColumn() == second.getColumn());
    }

    private boolean checkMultiple(Matrix second) {
        return getColumn() == second.getRow();
    }

    public Matrix addOrSub(Matrix second, boolean isAdd) throws Exception {
        if (!checkAddAndSub(second)) {
            throw new Exception("Two matrix no have the same size");
        }
        Matrix add = new Matrix(getRow(), getColumn());
        for (int i = 0; i < getRow(); i++) {
            for (int j = 0; j < getColumn(); j++) {
                int value;
                if (isAdd) {
                    value = Math.addExact(getValueAt(i, j), second.getValueAt(i, j));
                } else {
                    value = Math.subtractExact(getValueAt(i, j), second.getValueAt(i, j));
                }
                add.setValueAt(i, j, value);
            }
        }
        return add;
    }

    public Matrix add(Matrix second) throws Exception {
        return addOrSub(second, true);
    }

    public Matrix subtract(Matrix second) throws Exception {
        return addOrSub(second, false);
    }

    public Matrix multiple(Matrix second) throws Exception {
        if (!checkMultiple(second)) {
            throw new Exception("Matrix one can not multiple with matrix two");
        }
        Matrix mul = new Matrix(getRow(), second.getColumn());
        for (int i = 0; i < getRow(); i++) {
            for (int j = 0; j < second.getColumn(); j++) {
                int value = 0;
                for (int k = 0; k < getColumn(); k++) {
                    value = Math.addExact(value, Math.multiplyExact(getValueAt(i, k), second.getValueAt(k, j)));
                }
                mul.setValueAt(i, j, value);
            }
        }
        return mul;
    }
}
