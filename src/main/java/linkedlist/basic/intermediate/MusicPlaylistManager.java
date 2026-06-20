package linkedlist.basic.intermediate;

import java.util.LinkedList;
import java.util.ListIterator;

public class MusicPlaylistManager {
    private LinkedList<String> playlist = new LinkedList<>();
    private ListIterator<String> playlistIterator;

    public void addSong(String song) {
        playlist.add(song);
        System.out.println("Added song: " + song);
    }

    public void play() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
            return;
        }
        playlistIterator = playlist.listIterator();
        System.out.println("Playing: " + playlistIterator.next());
    }

    public void nextSong() {
        if (playlistIterator.hasNext()) {
            System.out.println("Playing next song: " + playlistIterator.next());
        } else {
            System.out.println("End of playlist.");
        }
    }

    public void previousSong() {
        if (playlistIterator.hasPrevious()) {
            System.out.println("Playing previous song: " + playlistIterator.previous());
        } else {
            System.out.println("Beginning of playlist.");
        }
    }

    public static void main(String[] args) {
        // Problem 9: Create music playlist manager.
        MusicPlaylistManager playlistManager = new MusicPlaylistManager();
        playlistManager.addSong("Bohemian Rhapsody");
        playlistManager.addSong("Stairway to Heaven");
        playlistManager.addSong("Hotel California");
        playlistManager.play();
        playlistManager.nextSong();
        playlistManager.previousSong();
    }
}
