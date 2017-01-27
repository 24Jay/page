package edu.zju.page;

public class Singer
{
	private String id;

	private String name;

	private String albums;

	private String songs;

	private String mvs;

	public Singer()
	{

	}

	public Singer(String id, String name, String albums, String songs, String mvs)
	{
		this.id = id;
		this.name = name;
		this.albums = albums;
		this.songs = songs;
		this.mvs = mvs;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getAlbums()
	{
		return albums;
	}

	public void setAlbums(String albums)
	{
		this.albums = albums;
	}

	public String getSongs()
	{
		return songs;
	}

	public void setSongs(String songs)
	{
		this.songs = songs;
	}

	public String getMvs()
	{
		return mvs;
	}

	public void setMvs(String mvs)
	{
		this.mvs = mvs;
	}

}
