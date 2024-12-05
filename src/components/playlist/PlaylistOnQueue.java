package components.playlist;

import components.queue.Queue;
import components.queue.Queue2;

/**
 * java doc.
 **/
public class PlaylistOnQueue extends PlaylistSecondary {

    //put my representation/queue in here:

    /**
     * java doc.
     */
    private Queue<Song> playlist;
     /**
     * java doc.
     */
    private String playlistName;
     /**
     * java doc.
     */
    private String currSong;

    /**
     * initial representation of playList
     */
    public void createNewRep() {
        this.playlist = new Queue2<Song>();
        this.currSong = "";
        this.playlistName = "Untitled";
    }

    /**
     * constructor.
     *
     * @param plName
     *            playlist name specified by user
     */
    public PlaylistOnQueue(String plName) {

        //create a new Rep and then update playlist name according to what user gave
        this.createNewRep();
        this.playlistName = plName;

    }

    //kernel method bodies go here:

    /**
     * AddSongToQueue.
     */
    @Override
    public final void addSongToQueue(Song song) {
        this.playlist.enqueue(song);
    }

    /**
     * getCurrentSong.
     */
    @Override
    public final void getCurrentSong(Playlist p) {
        this.currSong = this.playlist.front().toString();
    }

    /**
     * Set PlayList Name.
     */
    @Override
    public final void setPlayListName(String plName) {
        this.playlistName = plName;
    }

    /**
     * Get PlayList Name.
     *
     * @return string storing PL name
     */
    @Override
    public final String getPlayListName() {
        return this.playlistName;
    }

    /**
     * get size.
     *
     * @return # of songs in playList
     */
    @Override
    public final int size() {
        //calling queue kernel length
        return this.playlist.length();
    }

    /**
     * Undo Last. //uhh literally need this string to be able to implement my
     * shuffle method...
     *
     * @return the last song put into the playList, and remove it from playlist
     */
    @Override
    public final Song undoLast() {
        return this.playlist.dequeue();
    }

    //how do i go about implementing the standard methods?
    /**
     * java doc.
     */
    @Override
    public void clear() {
        //create a new representation just sets it to initial representation, empty/clear
        this.createNewRep();
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

      /**
     * java doc.
     */
    @Override
    public Playlist newInstance() {
        //not gonna lie, i copied this project our nn string project
        //bc i didn't know what else to do, its not yelling at me yet
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    /**
     * java doc.
     */
    @Override
    public void transferFrom(Playlist arg0) {

        Playlist localSource = this.newInstance();
        this.playlistName = localSource.getPlayListName();
        this.equals(localSource);
        ((PlaylistOnQueue) localSource).createNewRep();
        throw new UnsupportedOperationException(
                "Unimplemented method 'transferFrom'");
    }

}
