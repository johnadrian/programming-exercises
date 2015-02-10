package com.nextstopquiapo.exercises.PrintingPress.v2;

public class PrintingPress {

	public static void main(String[] args) {
		String word = "NEXT";
		int height = 7;
		
		embiggen(word, height);
	}
	
    private static void embiggen(String word, int height){
        Canvas c = new Canvas(word, height);
        c.print();
    }
}
