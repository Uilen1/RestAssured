package br.com.rest_assured.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class PathDataJson {
	
	protected static FileReader JsonData;
	
	public static FileReader getJsonData() {
		return JsonData;
	}

	public static void setJsonData(String dataNameJson) throws FileNotFoundException {
		JsonData = new FileReader(new File("src/main/java/br/com/rest_assured/utilities/massaJson/"+dataNameJson+".json"));;
	}
	
}
