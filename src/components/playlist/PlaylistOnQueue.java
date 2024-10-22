package components.playlist;

public class PlaylistOnQueue extends PlaylistSecondary {

    //put my representation/queue in here:

    //kernel method bodies go here:

    /**
     * AddSongToQueue.
     */
    @Override
	public final void addSongToQueue(String artist, String title) {
        this.playList.enqueue(new Song(artist, title));
    }

    /**
     * getCurrentSong.
     */
    public final void getCurrentSong(playList p) {
        this.currSong = p.front();
    }

    /**
     * Set PlayList Name.
     */
    @Override
	public final void setPlayListName(String PLname) {
        this.playListName = PLname;
    }

    /**
     * Get PlayList Name.
     * 
     * @return string storing PL name
     */
    @Override
	public final String getPlayListName() {
        return this.playListName;
    }

    /**
     * get size.
     * 
     * @return # of songs in playList
     */
    @Override
	public final int size() {
        //calling queue kernel length
        return this.playList.length();
    }

    /**
     * Undo Last.
     * 
     * @return the last song put into the playList, and remove it from playlist
     */
    @Override
	public final Song undoLast() {
        return this.playList.dequeue();
    }

}
