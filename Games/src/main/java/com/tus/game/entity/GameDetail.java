package com.tus.game.entity;

import javax.persistence.*;

@Entity
@Table(name = "game_detail") 
public class GameDetail
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String genre;
    private int price;

    public GameDetail()
    {
    }

	public GameDetail(Long id, String genre, int price) {
		super();
		this.id = id;
		this.genre = genre;
		this.price = price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

    
}
