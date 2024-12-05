package components.playlist;

import java.util.concurrent.ThreadLocalRandom;

public abstract class PlaylistSecondary implements Playlist {

    /*
     * Secondary Shuffle Method, create secondary method using queue kernel
     * methods, since playlist object itself is a queue
     */
    @Override
    public final void shuffle() {

        //create a copy with CopyFrom, avoiding aliases no?
        Playlist original = this.newInstance();
        /*
         * we are going to disperse our orignial playlist among like 5 and then
         * just piece them back together, boom shuffled.
         */
        Playlist a = this.newInstance();
        Playlist b = this.newInstance();
        Playlist c = this.newInstance();
        Playlist d = this.newInstance();
        Playlist e = this.newInstance();

        //remove everything but the dummy node, thats why <
        while (this.size() != 0) {
            Song temp = this.undoLast();
            int rand = ThreadLocalRandom.current().nextInt();

            //idk i was trying to do too much here, but based on a random number
            //we are popping temp into one of the queues
            final int magicNumber = 250;
            if (rand % 2 == 0 && rand < magicNumber) {
                a.addSongToQueue(temp);
            } else if (rand < magicNumber) {
                b.addSongToQueue(temp);
            } else if (rand < magicNumber * 2) {
                c.addSongToQueue(temp);
            } else if (rand < magicNumber * 3) {
                d.addSongToQueue(temp);
            } else {
                e.addSongToQueue(temp);
            }
        }
        //can i append multiple at a time in one call like this?
        this.append(a, b, c, d, e);
    }

    @Override
    public void append(Playlist... playlists) {

        //how do i iterate through implementing arguments in java?
        //basically just loop through each playList, removing each item and adding it to this
        for ( Playlist playlist : playlists) {
            while (playlist.size()>0) {
                this.addSongToQueue(playlist.undoLast());
            }
        }


    }

}
