package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException, InterruptedException {		
		File file = new File("test.in");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		OutputGenerator og = new OutputGenerator(br);
		String result = og.read();
		
		boolean eval = Evaluator.evaluate(result, "test.ot");
		if(eval)
			System.out.println("Correct Solution!");
		else 
			System.out.println("Invalid Solution!");
	}
	
	/* TODO:
	 * 1.) READ A ZIP FILE
	 * 
	 */

}
