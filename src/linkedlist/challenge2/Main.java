package linkedlist.challenge2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Main
{
    public static void main(String[] args)
    {
        Album album = new Album("Greatest Hits", "Queen");

        album.addSong("Bohemian Rhapsody", 5.55);
        album.addSong("Don't Stop Me Now", 3.30);

        LinkedList<Song> playList = new LinkedList<Song>();
        album.addToPlayList("Bohemian Rhapsody", playList);
        album.addToPlayList(2, playList);

        for (Song s : playList)
        {
            System.out.println(s);
        }
    }
}

class Album
{
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist)
    {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration)
    {
        if (findSong(title) == null)
        {
            songs.add(new Song(title, duration));
            return true;
        }
        else
        {
            System.out.println("Song already exists!");
            return false;
        }
    }

    private Song findSong(String title)
    {
        for (Song s : songs)
        {
            if (s.getTitle().equals(title))
            {
                return s;
            }
        }

        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList)
    {
        int index = trackNumber -1;
        if (index >= 0 && index < songs.size())
        {
            playList.add(songs.get(index));
            return true;
        }
        else
        {
            System.out.println("Track number " + trackNumber + " does not exist!");
            return false;
        }
    }

    public boolean addToPlayList(String title, LinkedList<Song> playList)
    {
        Song song = findSong(title);
        if (song != null)
        {
            playList.add(song);
            return true;
        }
        else
        {
            System.out.println("Song already exists!");
            return false;
        }
    }


}

class Song
{
    private String title;
    private double duration;

    public Song(String title, double duration)
    {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle()
    {
        return title;
    }

    @Override
    public String toString()
    {
        return title + ": " + duration;
    }
}
