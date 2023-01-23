import java.util.*;

public class Main {

    public static List<Albumb> albums = new ArrayList<>();
    public static void main(String[] args) {


        Albumb albumb1 = new Albumb("Rap-Songs","Eminem");

        albumb1.addSongtoAlbumb("Loose-Yourself",4.8);
        albumb1.addSongtoAlbumb("Rap-God",5.0);
        albumb1.addSongtoAlbumb("Slim-Shady",3.5);
        albumb1.addSongtoAlbumb("Godzilla",4.0);

        Albumb albumb2 = new Albumb("clam","Vijay Prakash");

        albumb2.addSongtoAlbumb("Kavithe",3.5);
        albumb2.addSongtoAlbumb("Kali quaturu Batli",4.0);
        albumb2.addSongtoAlbumb("Singara Siriye",4.41);


        albums.add(albumb1);
        albums.add(albumb2);

        System.out.println(albumb1.findSong("Godzilla"));

        LinkedList<Song> myPlayList = new LinkedList<>();

        albumb1.addSongtoMyPlaylist("Loose-Yourself",myPlayList);
        albumb2.addSongtoMyPlaylist("Singara Siriye",myPlayList);
        albumb2.addSongtoMyPlaylist("Kali quaturu Batli",myPlayList);
        albumb1.addSongtoMyPlaylist("Godzilla",myPlayList);

        play(myPlayList);
    }
//  iterating over the list using the list Iterator
    public static void play(LinkedList<Song>
                                    playList) {
        ListIterator<Song> itr = playList.listIterator();
        Scanner sc = new Scanner(System.in);

//        Making a boolean variable to keep track of direction in which song is moving weather next otr previous
        boolean isForward = false;


//        when i want to play a song there should songs in the playlist , so checking them
        if(playList.size() > 0)
        {
//to play a song just do this
            System.out.println("Currently playing: ");
            System.out.println(itr.next());
//            since we have moved one position forward setting isFarword to true
            isForward = true;
        }
        else {
            System.out.println("Playlist is empty");
            return;
        }
//        here taking the user choice what to next and calling the printMenu fun to perform
        System.out.println("Enter your choice");
//        to achive these function i use while loop

        boolean quite = false;
//         if Exit is pressed i will set quite to true
        while (!quite){
//            taking the users choice
            int choice  = sc.nextInt();
//            using switch case to execute the Menu
            switch (choice){
                case 1:
//                    implementation of PlayMenu starts from here
//                    checking is song is coming from previous , if it is then
                    if(isForward == false)
                    {
                        itr.next();
//                        moved forward so setting it to true
                        isForward = true;
                    }
//                    if it has next Song then go to next song
//                    this condition will obviously get executed
                    if(itr.hasNext())
                    {
                        System.out.println(itr.next());
                    }
                    else
                    {
                        System.out.println("Bro you have reached the end of the PlayList , its better to play from beginnig");
                        isForward = false;
                    }
                    break;

                case 2:
                    if(isForward == true)
                    {
                        itr.previous();
                        isForward = false;
                    }
//                    case 2 is to play previous song and it can be done using hasPrevious() function
                    if(itr.hasPrevious())
                    {
                        System.out.println(itr.previous());
                    }
                    else {
                        System.out.println("Man you are at start of PlayList and there will be no previous Songs");
                        isForward = true;
                    }
                    break;
                case 3:
//                    This is for repeating the same song
                    if(isForward == true)
                    {
                        if(itr.hasPrevious()) {
                            System.out.println(itr.previous());
//                            since I am coming back , setting isFarward to true
                            isForward = false;
                        }
                    }
                    else {
                        if(itr.hasNext()) {
                            System.out.println(itr.next());
                            isForward = true;
                        }
                    }
                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    break;
                case 6:

//                    I have a function called printSongs it prints all the songs
                    printSongs(playList);
                    break;
                case 7:
                    quite = true;
                    break;


            }
        }
    }

//    implementing the print song function to print all songs
    public static void printSongs(LinkedList<Song> playList){
//        iterating over these songs
        for(Song song:playList)
        {
            System.out.println(song);
            return;
        }

    }
    public static void printMenu(){

        System.out.println("1 - to play next Song");
        System.out.println("2 - to play previous Song");
        System.out.println("3 - repeat the current song");
        System.out.println("4 - Show menu again");
        System.out.println("5 - Delete the current song");
        System.out.println("6 - Print all the songs in the playlist");
        System.out.println("7 - Exit");
        return;
    }
}