

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

import task.GrafanaJsonGenerator;

public class Main {

	public static void main(String[] args) {
		
		GrafanaJsonGenerator generator =new GrafanaJsonGenerator();
		try {
			
			/*This one returns the string*/
			//System.out.println(generator.generate("F:\\config.properties"));
			
			/*This one for generating json file*/
			generator.generate("F:\\config.properties", "F:\\output1", "aa.json");
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
			//e.printStackTrace();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (ParseException e) {
			System.err.println(e.getMessage());
			//e.printStackTrace();
		}
		
	}
	
}
