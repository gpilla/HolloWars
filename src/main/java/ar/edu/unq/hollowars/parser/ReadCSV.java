package ar.edu.unq.hollowars.parser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class ReadCSV {

	String csvFile; // = "/Users/mkyong/Downloads/GeoIPCountryWhois.csv";
	ArrayList<String[]> oleadas = new ArrayList<String[]>();
//  public static void main(String[] args) {
//
//	ReadCSV obj = new ReadCSV();
//	obj.run();
//
//  }
	
	public ReadCSV(String fullFileName){
		this.csvFile = fullFileName;
	}
	

  public ArrayList<String[]> run() throws Exception {

	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ",";

	try {

		br = new BufferedReader(new FileReader(this.csvFile));
		//salto la linea de encabezados
		br.readLine();
		while ((line = br.readLine()) != null) {

		        // use comma as separator
			String[] linea = line.split(cvsSplitBy);
			oleadas.add(linea);
		}

	} catch (FileNotFoundException e) {
		e.printStackTrace();
		throw e;
	} catch (IOException e) {
		e.printStackTrace();
		throw e;

	} finally {
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw e;
			}
		}
	}


	return oleadas;
  }

}