package com.nextstopquiapo.exercises.PrintingPress.v3;

public class Canvas {
    private char[][] canvas;
    private int height;
    private String word;
    
    public Canvas(String word, int height){
    	this.height = height;
    	this.word = word;
        canvas = new char[height][(word.length() + 1) * height];
        
        transpose();
    }
    
    private void transpose(){
        int offset = 0;
        for(char ch : word.toCharArray()){
            char[][] cur = Block.create(ch, height);
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