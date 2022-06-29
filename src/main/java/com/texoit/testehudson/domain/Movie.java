package com.texoit.testehudson.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "movie")
public class Movie implements Serializable{

	private static final long serialVersionUID = 7499167601991997727L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mov_id", updatable = false)
    private Long id;

    @NotNull
    @Column(name = "mov_year", length = 255, nullable = false)
    private Long year;

    @NotEmpty
    @Size(max = 255)
    @Column(name = "mov_title", length = 255, nullable = false)
    private String title;

    @NotEmpty
    @Size(max = 255)
    @Column(name = "mov_studio", length = 255, nullable = false)
    private String studio;

    @NotEmpty
    @Size(max = 255)
    @Column(name = "mov_producer", length = 255, nullable = false)
    private String producer;

    @NotNull
    @Column(name = "mov_winner", nullable = false)
    private Boolean winner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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