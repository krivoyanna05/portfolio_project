import components.queue.Queue;
import components.queue.Queue2;

/**
 * Our element playList represented by a queue to maintain order and allow
 * effiency with adding/removing objects... after class I am thinking best way
 * to do with woudld be linkedList?
 */
public class Playlist {

    public Playlist() {
        this.createNewRep();
    }

    @Override
    public String toString() {
        String output = "[";
        for (Song s : this.playList) {
            output += "(" + s.artist + ", " + s.title + ")";
        }
        output += "]";
        return output;
    }

    /**
     * private member in our class.
     */
    private Queue<Song> playList;

    private class Song {
        private String artist;
        private String title;
        //private String pathToSongFile;
        //private String pathToAlbumArt;

        public Song(String artist, String title) {
            this.artist = artist;
            this.title = title;
        }
    }

    private Song currSong;

    //I want the user to be able to store a string as a playlist name.
    //see to create a library I could now create a map that stores string (playListName) and the queue?
    //idk if I would need this actually...
    private String playListName;

    //also like are we doing this with osu components? or nurr?

    /**
     * initial representation will be a queue. Sooo idk if I want to do a queue
     * of strings or a queue of map<index, title> or even map<artist, title> I
     * am thinking that the maps would make it easy to access elements to remove
     * them from the playList, but not necessarily.
     */
    private void createNewRep() {
        this.playList = new Queue2<Song>();
        //do I need to represent song and playList name here?
    }

    /**
     * no argument constructor for song?? whats going on, idk do i need an
     * initial representaiton of song?? I have it?
     */

    //setter method for song..
    public final void addSongToQueue(String artist, String title) {
        this.playList.enqueue(new Song(artist, title));
    }

    //setter for PlayList name
    public final void setPlayListName(String PLname) {
        this.playListName = PLname;
    }

    //getter for PlayList name
    public final String getPlayListName() {
        return this.playListName;
    }

    /**
     * adding our kernel method, can I not just already use queue's kernel
     * methods? Also I will need to implement standard methods like
     * newInstance(), clear()
     */

    // size()
    public final int size() {
        //use kernel size method
        return this.playList.size();
    }

    /**
     * removeLast() or removeSong(Stringg song), should removeLast be a kernel
     * method used to build removeSong, or should I skill removeFirst, like what
     * real purpose does it serve? I will probably be using a remove method to
     * build shuffle, I feel like I could build shuffle with either, but it
     * might be easier with removeSong(), can I build secondary methods with
     * secondary methods?
     */
    public final String removeFirst() {
        //I can either use queues poll or remove methods..... what are the benefits of throwing an exception
        return null;//this.playList.remove();
    }

    //adding our secondary methods (we use kernel methods to build secondary)

    /**
     * shuffle, it takes in a playlist to be shuffled and either creates a new
     * one entirely or I make this a void method and just update the playList
     * passed in.... I should just update the playList passed in I think. This
     * would just shuffle my queue, could the user restore their playlist???
     * Then it can't be void because a new play list would need to be created,
     * either a copy of the original or the shuffled one, but I can store the
     * original one under the hood somehwere???
     */
    public final Playlist shuffle(Playlist toBeShuffled) {
        //actually feeling stupid, but yeah I guess i would need to build some standard methods??
        //playList copy = toBeShuffled.transferFrom();

        /**
         * at this point, like again I don't know if we are or aren't using java
         * components or osu components okay I reread instructions and it says
         * it needs to be adapted to OSU's discipline, so I am assuming I cannot
         * use java's List to implement a playList from the beginning very sad..
         *
         * given my restriction my only options to shuffle osu's queue would be
         * to convert it to an array/arrayList and shuffle that and then convert
         * it bac into a the queue..
         *
         * or idea 1: manually shuffle stuff by removing everything from my
         * queue and randomly storing each element in some amount of queues?
         * Then piecing those randomly shuffled queues back together into one...
         * How would i chose the number of queues?
         */

        //when user presses shuffle, we want to shuffle the playlist but return the original copy to be stored somewhere
        while (toBeShuffled.size() > 0) {

            String element = toBeShuffled.removeFirst();
            /**
             * something like.. if random = 1, add element to playList 1 if
             * random = 2, add element to playList 2 if random = 3, add element
             * to playList 3 if random = 4, add element to playList 4 then all
             * the playlists together back into toBeShuffled... there is
             * probably something more efficient to be done, but its shuffled
             * enough for it and it works so?
             */
        }
        return null;//copy;
    }

    /**
     * getter and setter methods?? declare a public variable song? You can set
     * the name of song and then pass that song into the playlist??
     */

    //for some reason when i leave this here i don't get ugly errors about all my comments exceding 95 characters
    public static void main(String[] args) {
        Playlist p = new Playlist();
        p.addSongToQueue("Espresso", "Sabrina Carpenter");
        System.out.println(p);
    }
}
