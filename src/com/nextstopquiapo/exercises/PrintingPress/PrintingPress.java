package com.nextstopquiapo.exercises.PrintingPress;

public class PrintingPress {

	public static void main(String[] args) {
		String word = "NEXT";
		int height = 7;
		
		embiggen(word, height);
	}
	
    private static void embiggen(String word, int height){
        for(char c : word.toCharArray()){
            char[][] letter = imprint(height, c);
            printLetter(letter);
            System.out.println();
        }
    }
    
    private static void printLetter(char[][] c){
        for(int i = 0; i < c.length; i++){
            for(int j = 0; j < c[i].length; j++){
                System.out.print(c[i][j]);
            }
            System.out.println("");
        }
    }
    
    private static char[][] imprint(int height, char symbol){
        char[][] c = new char[height][height];
        for(int i = 0; i < c.length; i++){
            for(int j = 0; j < c[i].length; j++){
                if(applyRulesFor(symbol, i, j, height)){
                    c[i][j] = '*';  
                } else{
                	c[i][j] = ' ';
                }
            }
        }
        
        return c;
    }
    
    private static boolean applyRulesFor(char symbol, int row, int col, int size){
        switch (symbol){
        case 'N': return (col == 0) || (col == size -1) || (row == col);
        case 'E': return (col == 0) || (row == 0) || (row == size - 1) || (row == (size - 1)/2);
        case 'X': return (row == col) || (row + col == size - 1);
        case 'T': return (row == 0) || (col == (size - 1)/2);
        default: return false;
        }
    }

}
