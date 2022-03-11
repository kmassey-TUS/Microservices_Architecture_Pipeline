package com.tus.game.entity;

import javax.persistence.*;


@Entity
@Table(name = "Games") 
public class Games
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "console")
    private String console;

    @Column(name = "game_name")
    private String game_name;
    
    @Column(name = "game_detail_id")
    private long game_detail_id;
    
    @Column(name = "age_rating")
    private long age_rating;


    public Games()
    {
    }
    
    

	public Games(Long id, String console, String game_name, long game_detail_id, long age_rating) {
		super();
		this.id = id;
		this.console = console;
		this.game_name = game_name;
		this.game_detail_id = game_detail_id;
		this.age_rating = age_rating;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConsole() {
		return console;
	}

	public void setConsole(String console) {
		this.console = console;
	}

	public String getGame_name() {
		return game_name;
	}

	public void setGame_name(String game_name) {
		this.game_name = game_name;
	}

	public long getGame_detail_id() {
		return game_detail_id;
	}

	public void setGame_detail_id(long game_detail_id) {
		this.game_detail_id = game_detail_id;
	}

	public long getAge_rating() {
		return age_rating;
	}

	public void setAge_rating(long age_rating) {
		this.age_rating = age_rating;
	}
    

    
}
