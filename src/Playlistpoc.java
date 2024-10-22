import java.util.concurrent.ThreadLocalRandom;

import components.queue.Queue;
import components.queue.Queue2;

/**
 * Our element playList represented by a queue to maintain order and allow
 * effiency with adding/removing objects... after class I am thinking best way
 * to do with woudld be linkedList?
 */
public class Playlistpoc {

    public Playlistpoc() {
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
    /**
     * private member in our class.
     */
    private String playListName = "untitled";

    /**
     * private class song object, represented by a pair of strings...
     */
    private class Song {

        /**
         * private member in our class.
         */
        private String artist;
        /**
         * private member in our class.
         */
        private String title;

        /**
         * idk what to write here.
         */
        public Song(String artist, String title) {
            this.artist = artist;
            this.title = title;
        }
    }

    /**
     * representation will be a queue of songs user passes in string to set
     * playList name?
     */
    private void createNewRep() {
        this.playList = new Queue2<Song>();
    }

    //setter method for song..
    // can i add this to my kernel interface?
    /**
     * To add a song you need to input the artist and title...
     *
     * @param artist
     *            string to be stored as artist for object song
     * @param title
     *            string to be stored as title for object song
     * @updates this.playList
     * @ensures this.playList size > 1 (even 2, bc dummySong plus what was
     *          added) what else should I add for ensures?
     */
    public final void addSongToQueue(String artist, String title) {
        this.playList.enqueue(new Song(artist, title));
    }

    /**
     * getter method for current song using .front() makes more sence bc song
     * stays in the playlist
     *
     * To add a song you need to input the artist and title...
     *
     * @param p
     *            playlist to grab current Song from
     * @updates this.CurrSong (or replaces?)
     * @requires p.size > 0
     * @ensures this.CurrSong != null... ??
     */
    public final void getCurrentSong(playList p) {
        this.currSong = p.front();
    }

    /**
     * Set PlayList Name.
     *
     * @param PLname
     *            string to be passed in to name playlist
     * @updates this.playListName
     * @ensures this.playListName = #this.playListName ?? idk looks familiar
     */
    public final void setPlayListName(String PLname) {
        this.playListName = PLname;
    }

    /**
     * Get PlayList Name.
     *
     * @return the name of playList
     */
    public final String getPlayListName() {
        return this.playListName;
    }

    /**
     * adding our kernel method Also I will need to implement standard methods
     * like newInstance(), clear()
     */

    public final int size() {
        //calling queue kernel length
        return this.playList.length();
    }

    /*
     * I am keeping removeLast as the kernel method because I will be still be
     * able to create my shuffle method with it, but I also think it serves as a
     * nice purpose to serve as an "undo" function.
     *
     * The user can access this kernel method, so maybe I will call this method
     * undoLast, this would remove the last the user put in the playList
     */
    public final Song undoLast() {
        return this.playList.dequeue();
    }

    /*
     * we want it to update this.playList //but also create somewhere to store
     * the original copy bf shuffle, idk what I would do with this copy tbh
     */
    public final void shuffle() {

        //create a copy with CopyFrom, avoiding aliases no?
        Playlistpoc original = this.copyFrom();
        /*
         * we are going to disperse our orignial playlist among like 5 and then
         * just piece them back together, boom shuffled.
         */
        Playlistpoc a = this.newInstance();
        Playlistpoc b = this.newInstance();
        Playlistpoc c = this.newInstance();
        Playlistpoc d = this.newInstance();
        Playlistpoc e = this.newInstance();

        //remove everything but the dummy node, thats why <
        while (this.size != 0) {
            Song temp = this.dequeue();
            int rand = ThreadLocalRandom.current().nextInt();

            //idk i was trying to do too much here, but based on a random number
            //we are popping temp into one of the queues
            final int magicNumer = 250;
            if (rand % 2 == 0 && rand < magicNumber) {
                a.enqueue(temp);
            } else if (rand < magicNumber) {
                b.enqueue(temp);
            } else if (rand < magicNumber * 2) {
                c.enqueue(temp);
            } else if (rand < magicNumber * 3) {
                d.enqueue(temp);
            } else {
                e.enqueue(temp);
            }
        }
        //can i append multiple at a time in one call like this?
        this.append(a, b, c, d, e);
    }

    public static void main(String[] args) {

        Playlistpoc p = new Playlistpoc();
        p.addSongToQueue("Espresso", "Sabrina Carpenter");
        p.addSongToQueue("Von Dutch", "Charlie XCX");
        p.addSongToQueue("Chappell Roan", "Feminiminomenon");

        p.setPlayListName("pop");

        System.out.println(p);

        p.shuffle();
        System.out.println(p);

    }
}
