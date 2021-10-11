package com.anish.calabashbros;

import java.util.*;
import java.awt.Color;

public class Matrix {

    private Monster[][] monsters;

    public Matrix(int num, World world) {
        monsters = new Monster[num][num];

        int[] r = getRandomList(256);
        int[] g = getRandomList(256);
        int[] b = getRandomList(256);
        int[] ranks = getRandomList(num * num);
        
        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                int index=i*num+j;
                monsters[i][j]=new Monster(new Color(r[index],g[index],b[index]), ranks[index], world);
                world.put(monsters[i][j], 10+j*2, 10+i*2);
            }
        }
        
    }

    public Monster[] getAsList(){
        int height=monsters.length;
        int width=monsters[0].length;
        Monster[] res=new Monster[height*width];
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                res[i*width+j]=monsters[i][j];
            }
        }
        return res;
    }

    public static int[] getRandomList(int num) {
        int[] source = new int[num];
        for (int i = 0; i < num; i++) {
            source[i] = i;
        }
        int[] result = new int[num];
        Random rd = new Random();
        int index = 0;
        int len = num;
        for (int i = 0; i < num; i++) {
            index = Math.abs(rd.nextInt() % len--);
            result[i] = source[index];
            source[index] = source[len];
        }
        return result;
    }

}
