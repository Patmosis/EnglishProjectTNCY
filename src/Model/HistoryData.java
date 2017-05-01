package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class HistoryData {
	
	private String fileName = "src/resources/historyDatabase.csv";
	private ArrayList<ArrayList<String>> dataList = new ArrayList<ArrayList<String>>();
	
	public HistoryData() {
		BufferedReader bufferedReader = null;
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(fileName);
			bufferedReader = new BufferedReader(fileReader);

			String line;

			while ((line = bufferedReader.readLine()) != null) {
				ArrayList<String> dataLine = new ArrayList<String>();
				int i;
				while ((i = line.indexOf(";")) != -1) {
					dataLine.add(line.substring(0, i));
					line = line.substring(i+1);
				}
				dataLine.add(line);
				dataList.add(dataLine);
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
	
	public ArrayList<String> getByNum(int numLine) {
		return dataList.get(numLine);
	}

}
