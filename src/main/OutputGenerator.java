package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class OutputGenerator {
	
	private class StreamWrapper extends Thread {
		String output;
		InputStream is = null;     
		
		StreamWrapper(InputStream is) {
		    this.is = is;
		}
		
		public void run() {
			String msg = "";
		    try {
		        BufferedReader br = new BufferedReader(new InputStreamReader(is));
		        String line = null;
		        while ( (line = br.readLine()) != null) {
		        	msg += line+"\n";
//		        	System.out.println(line);
		        }
		    } catch (IOException ioe) {
		        ioe.printStackTrace(); 
		    }
		    output = msg;
		}
		
		public String getResult() {
			return output;
		}
	}

	StreamWrapper error, stream;
	Process p;
	BufferedWriter writer;
	BufferedReader input;
	
	OutputGenerator(BufferedReader in) {
		input = in;
	}
	
	public StreamWrapper getStreamWrapper(InputStream is){
        return new StreamWrapper(is);
	}
	
	public String read() throws IOException, InterruptedException {
		p = Runtime.getRuntime().exec("/opt/adt-bundle-linux-x86_64-20131030/eclipse/jre/bin/java -classpath /home/mongskie/workspace/BotIO/src/main Dummy");
		writer = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
        error = getStreamWrapper(p.getErrorStream());
        stream = getStreamWrapper(p.getInputStream());

        stream.start();
        error.start();
        
        // use defined inputs
        String buff;
        while((buff = input.readLine()) != null) {
    		writer.write(buff);
    		writer.newLine();
        }
		writer.flush();
		
		p.waitFor();
		return stream.getResult();
	}
	
	public void compile() throws IOException {
		p = Runtime.getRuntime().exec("/opt/adt-bundle-linux-x86_64-20131030/eclipse/jre/bin/javac /home/mongskie/workspace/BotIO/src/main/Dummy.java");
	}
	
}
