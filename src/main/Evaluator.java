package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Evaluator {
	
	static class LineReader {
		
		int curPos = -1;
		String arr[];
		
		public LineReader(String in) {
			arr = in.split("\\n");
		}
		
		public String next() {
			curPos++;
			return arr[curPos];
		}
	}

	public static boolean evaluate(String result, String expURI) throws IOException {
		File file = new File(expURI);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		LineReader lr = new LineReader(result);
		
		String buff;
		while((buff = br.readLine()) != null) {
			if(!lr.next().equals(buff))
				return false;
		}
		return true;
	}

}
