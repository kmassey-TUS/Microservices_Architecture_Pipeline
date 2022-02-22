package com.tus.game.entity;

import javax.persistence.*;


@Entity
@Table(name = "games")
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

     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "user_detail_id")
  //  @Transient
    private GameDetail gameDetail;


    public Games()
    {
    }

    public Games(String console, String game_name)
    {
        this.console = console;
        this.game_name = game_name;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getConsole()
    {
        return console;
    }

    public void setConsole(String console)
    {
        this.console = console;
    }

    public String getGameName()
    {
        return game_name;
    }

    public void setGameName(String game_name)
    {
        this.game_name = game_name;
    }

    public GameDetail getGameDetail()
    {
        return gameDetail;
    }

    public void setGameDetail(GameDetail gameDetail)
    {
        this.gameDetail = gameDetail;
    }
}
