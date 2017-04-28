package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class historyData {
	
	private String fileName = "src/resources/historyDatabase.csv";
	private ArrayList<ArrayList<String>> wordList = new ArrayList<ArrayList<String>>();
	
	public historyData() {
		BufferedReader bufferedReader = null;
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);

			String line;

			while ((line = bufferedReader.readLine()) != null) {
				ArrayList<String> word = new ArrayList<String>();
				int i;
				while ((i = line.indexOf(";")) != -1) {
					word.add(line.substring(0, i));
					line = line.substring(i+1);
				}
				word.add(line);
				wordList.add(word);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null)
					bufferedReader.close();

				if (fileReader != null)
					fileReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}
	}
	
	public ArrayList<ArrayList<String>> get(String country) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		for (ArrayList<String> word: wordList) {
			if (word.get(1).equals(country)) {
				result.add(word);
			}
		}
		return result;
	}

}
