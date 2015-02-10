package com.nextstopquiapo.exercises.PrintingPress.v3;

public class Block {
    public static char[][] create(char ch, int height){
        return createPlainSymbol(ch, height);
    }
    
    private static char[][] createPlainSymbol(char ch, int height){
    	char[][] c = new char[height][height];
        for(int i = 0; i < c.length; i++){
            for(int j = 0; j < c[i].length; j++){
                if(applyRulesFor(ch, height, i, j)){
                    c[i][j] = '*';  
                } else{
                	c[i][j] = ' ';
                }
            }
        }
        
        return c;
    }
    
    private static boolean applyRulesFor(char symbol, int height, int row, int col){
        switch (symbol){
        case 'N': return (col == 0) || (col == height -1) || (row == col);
        case 'E': return (col == 0) || (row == 0) || (row == height - 1) || (row == (height - 1)/2);
        case 'X': return (row == col) || (row + col == height - 1);
        case 'T': return (row == 0) || (col == (height - 1)/2);
        default: return false;
        }
    }
}
