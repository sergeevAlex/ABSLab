package com.lehich;
import javax.swing.*;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
public class Matrix {
    private int[][] matrix;
    public Matrix() {
    }
    //Размер матрицы
    public void setSize(int colrow) {
        matrix = new int[colrow][colrow];
        // matrix = new List<List<Integer>>();
        // matrix.add(new ArrayList<Integer>(colrow));
    }
    //Задание элемента
    public void setElem(int row, int col, int value) {
        matrix[row][col] = value;
       // matrix.add(row,value);
    }
    //Получение элемента
    public int getElem(int row, int col) {
       return matrix[row][col];
    }
    public static Matrix createMatrix(int size) {
        Matrix mt = new Matrix();
        mt.setSize(size);
        return mt;
    }
    //Свап двух строк матрицы
    public static Matrix swapLine(int swopLine, int targetLine, Matrix mt1, int size) {
        int tmp;
        int secondLine = targetLine;
        for (int firstLine = swopLine; swopLine < size; swopLine++) {
            for (int j = 0; j < size; j++) {
                tmp = mt1.getElem(firstLine, j);
                mt1.setElem(firstLine, j, mt1.getElem(secondLine, j));
                mt1.setElem(secondLine, j, tmp);
            }
        }
        return mt1;
    }
    public static double gauss(Matrix mt1, int size) {
        double result = 1;
        int count;
        Matrix mt = new Matrix();
        mt.setSize(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mt.setElem(i, j, mt1.getElem(i, j));
            }
        }
        Matrix mt2 = new Matrix();
        mt2.setSize(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mt2.setElem(i, j, mt1.getElem(i, j));
            }
        }
        for (int i = 0; i < size; i++) {
            //проверка на НЕнулевой i-тый элемент строки
            if (mt.getElem(i, i) == 0 && i < size-1) {
                count = i;
                do {
                    if(count < size ){count = size;}
                    mt.getElem(count, 0);
                    count++;


                    //Проблема в счетчике count >size - выход за рамки
                    //if(count > size){count = size;}
                }
                while (mt.getElem(count, 0) == 0);
                mt = swapLine(i, count, mt, size);
                result = -result; // Если была совершена перестановка —
            }                 // меняем знак определителя
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    mt2.setElem(x, y, mt.getElem(x, y));
                }
            }
            //зануление i-того столбца
            for (int j = i + 1; j < size; j++) {
                for (int k = i; k < size; k++) {
                    int tmp = mt.getElem(j, k) - ((mt.getElem(i, k) * mt2.getElem(j, i)) / mt.getElem(i, i));
                    mt.setElem(j, k, tmp);
                }
            }
        }
        //Вычисление определителя
        for (int x = 0; x < size; x++) {
            result = result * mt.getElem(x, x);
        }
        return result;
    }
    public int getSize(){
        int a = matrix.length;
        return a;
    }
    public static void printMatrix(Matrix mt){
        for(int i = 0;i <mt.getSize();i++)
        {
            for(int j=0;j<mt.getSize();j++)
            {
                System.out.print(mt.getElem(i,j)+" ");
            }
            System.out.println();
        }
    }
}