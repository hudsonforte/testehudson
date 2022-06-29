package com.texoit.testehudson.csvreader;

import java.util.List;

public interface MovieReader {

	class MovieProperties {
        private Long year;
        private String title;
        private String studio;
        private String producer;
        private Boolean winner;
        
		public Long getYear() {
			return year;
		}
		public void setYear(Long year) {
			this.year = year;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getStudio() {
			return studio;
		}
		public void setStudio(String studio) {
			this.studio = studio;
		}
		public String getProducer() {
			return producer;
		}
		public void setProducer(String producer) {
			this.producer = producer;
		}
		public Boolean getWinner() {
			return winner;
		}
		public void setWinner(Boolean winner) {
			this.winner = winner;
		}
        
        
    }

    List<MovieProperties> execute();
	
}