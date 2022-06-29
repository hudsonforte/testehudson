package com.texoit.testehudson.csvreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.util.Strings;


public class CsvReader implements MovieReader{

	private static final String DELIMITER = ";";
    private static final String IGNORE = "year";
    private static final Integer YEAR = 0;
    private static final Integer TITLE = 1;
    private static final Integer STUDIOS = 2;
    private static final Integer PRODUCERS = 3;
    private static final Integer WINNER = 4;
	
    private File file;
    
    public CsvReader(File file) {
    	this.file = file;
    }

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public List<MovieProperties> execute() {
		List<MovieProperties> properties = new ArrayList<>();
		try {
			fetchRecords().forEach(values -> {
			    String[] producers = values[PRODUCERS].split("(and|,)");
			    for (String producer : producers) {
			        if (!Strings.isBlank(producer)) {
			        	MovieProperties property = new MovieProperties();
			            property.setYear(Long.valueOf(values[YEAR]));
			            property.setTitle(values[TITLE].trim());
			            property.setStudio(values[STUDIOS].trim());
			            property.setWinner(false);
			            if (values.length > 4 && values[WINNER] != null) {
			            	property.setWinner(values[WINNER].equalsIgnoreCase("yes"));
			            }
			            property.setProducer(producer.trim());
			            properties.add(property);
			        }
			    }
			});
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return properties;
	}
    
    private List<String[]> fetchRecords() throws FileNotFoundException, IOException {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader csvReader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = csvReader.readLine()) != null) {
                String[] values = line.split(DELIMITER);
                if (!values[YEAR].equalsIgnoreCase(IGNORE)) {
                    records.add(values);
                }
            }
        }
        return records;
    }
}