package components.playlist;

import components.standard.Standard;

/**
 * Java doc.
 */
public interface PlaylistKernel extends Standard<Playlist> {

    public interface Song {

    }

    /**
     * To add a song you need to input the artist and title...
     *
     * @param artist
     *            string to be stored as artist for object song
     * @param title
     *            string to be stored as title for object song
     * @updates this.playList
     * @ensures #this.playList.size = this.playList.size + 1 Im trying to say
     *          that new size is = old size + 1
     */
    void addSongToQueue(String artist, String title);

    /**
     * getter method for current song using .front() makes more sence bc song
     * stays in the playlist
     *
     * To add a song you need to input the artist and title...
     *
     * @param p
     *            playlist to grab current Song from
     * @updates this.CurrSong (or replaces?)
     * @requires this.size > 0;
     * @ensures this.CurrSong != null... ?? idk it wont be null bc of dummySong
     *
     *          Instead: should I check if size = 0; set currSong to dummy node,
     *          else use.front()?? this way I don't have a dummy node in each
     *          playList]
     */
    void getCurrentSong(playList p);

    /**
     * Set PlayList Name.
     *
     * @param PLname
     *            string to be passed in to name playlist
     * @updates this.playListName
     * @requires PLname.length()>0 (I don't want the user to be able to set the
     *           playList name to empty string)
     * @ensures this.playListName = #this.playListName ?? idk looks familiar
     *          basically saying old name becomes new name?
     */
    void setPlayListName(String PLname);

    /**
     * Get PlayList Name.
     *
     * @return the name of playList
     */
    String getPlayListName();

    /**
     * @return the size of the playList
     */
    int size();

    /**
     * @return the last song that was added to the Playlist
     * @requires this.size > 0
     * @updates this.size, to be one less than before we called the method.
     * @updates this.playList
     * @ensures that the size will decrease by 1.
     */
    Song undoLast();

}
