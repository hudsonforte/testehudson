package com.texoit.testehudson.configuration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import com.texoit.testehudson.csvreader.CsvReader;
import com.texoit.testehudson.domain.Movie;
import com.texoit.testehudson.repository.MovieRepository;

@Configuration
public class MovieConfiguration implements ApplicationRunner{

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		ClassPathResource resource =  new ClassPathResource("movielist.csv");
		
		InputStream inputStream = resource.getInputStream();
		File file = File.createTempFile("movielist", ".csv");
		try {
		    copyInputStreamToFile(inputStream, file);
		} finally {
			inputStream.close();
		}

        CsvReader reader = new CsvReader(file);
        reader.execute().forEach(data -> {
            Movie movie = new Movie();
            movie.setYear(data.getYear());
            movie.setTitle(data.getTitle());
            movie.setStudio(data.getStudio());
            movie.setProducer(data.getProducer());
            movie.setWinner(data.getWinner());
            movieRepository.save(movie);
        }); 
		
	}
	

    private static void copyInputStreamToFile(InputStream inputStream, File file)
            throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(file, false)) {
            int read;
            byte[] bytes = new byte[8192];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
        }

    }
}