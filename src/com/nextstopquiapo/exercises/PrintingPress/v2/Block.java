package com.nextstopquiapo.exercises.PrintingPress.v2;

public class Block {
    private char[][] letter;
    private char symbol;
    private int height;
    
    public Block(char symbol, int height){
    	letter = new char[height][height];
    	this.symbol = symbol;
    	this.height = height;
    	
    	imprint();
    }
    
    private void imprint(){
        char[][] c = new char[height][height];
        for(int i = 0; i < c.length; i++){
            for(int j = 0; j < c[i].length; j++){
                if(applyRulesFor(i, j)){
                    c[i][j] = '*';  
                } else{
                	c[i][j] = ' ';
                }
            }
        }
    }
    
    private boolean applyRulesFor(int row, int col){
        switch (symbol){
        case 'N': return (col == 0) || (col == height -1) || (row == col);
        case 'E': return (col == 0) || (row == 0) || (row == height - 1) || (row == (height - 1)/2);
        case 'X': return (row == col) || (row + col == height - 1);
        case 'T': return (row == 0) || (col == (height - 1)/2);
        default: return false;
        }
    }

    public char[][] get(){
    	return letter;
    }

}
