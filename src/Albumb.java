import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Albumb {
    private String name;
    private String artist;
    private List<Song> songs;

    public Albumb(String name, String artist ) {
        this.name = name;
        this.artist = artist;
        songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

//    creating a function to check weather the song is already present or not

//Searching for a song through its title

    public boolean findSong(String title)
    {
        for(Song s : songs)
        {
            if(s.getTitle().equals(title))
                return true;
        }
        return false;
    }

//    creating a function to add a song to albumb
    public void addSongtoAlbumb(String title, double duration)
    {

//        to add a song first i creat an object of song
        Song s = new Song(title,duration);

//        before adding check weather this particular song is already present or not
//        for that to implement first i have to make a function for finding a song
        if(findSong(s.getTitle())== true)
        {
            System.out.println("This Song is already Present ");
        }
        else {
            songs.add(s);
            System.out.println("New Song has been added");
        }
        return;
    }

//    polymorphism
//playList is my own collwction of songs
    public void addSongtoMyPlaylist(String title, LinkedList<Song> playList){
        if(findSong(title) == true)
        {
            for(Song song : songs)
            {
                if(song.getTitle().equals(title)){
                    playList.add(song);
                    System.out.println("Song has been added ot your PlayList");
                    break;
                }
            }

        }
        else {
            System.out.println("Song is not present in the Album");
        }
        return;
    }
    public  void addSongtoMyPlaylist(int tackNo , LinkedList<Song> playList){
        int index = tackNo - 1;
        if(index >= 0 && index < songs.size())
        {
            System.out.println("Song has been added ot your PlayList");
            playList.add(songs.get(index));
        }
        else
        {
            System.out.println("Invalid track number");
        }
        return;
    }

}
