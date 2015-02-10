package com.nextstopquiapo.exercises.PrintingPress.v2;

public class Canvas {
    private char[][] canvas;
    private Block[] letters;
    private int height;
    
    public Canvas(String word, int height){
        letters = new Block[word.length()];
        for(int i = 0; i < word.length(); i++){
            letters[i] = new Block(word.charAt(i), height);
        }
        
        this.height = height;
        canvas = new char[height][(word.length() + 1) * height];
        
        transpose();
    }
    
    private void transpose(){
        int offset = 0;
        
        for(int c = 0; c < letters.length; c++){
            char[][] cur = letters[c].get();
            for(int i = 0; i < cur.length; i++){
                for(int j = 0; j < cur[i].length; j++){
                	canvas[j][i+offset] = cur[j][i];
                }
            }
            offset += height + 1;
        }   
    }
    
    public void print(){
        for(int i = 0; i < canvas.length; i++){
            for(int j = 0; j < canvas[i].length; j++){
                System.out.print(canvas[i][j]);
            }
            System.out.println("");
        }
    }
}