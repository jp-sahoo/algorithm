package companies;

/*
Create an Audio player with following functionalities on a playlist:
-   removeCurrentSong // ABCDE, curr = C, new_playlist = ABDE , new_curr_song : D
-   removeThisSong(songName)  // Only remove, no need to print updated playlist
-   playAfterCurrent(song)
    o   Example: Current Playlist: ABCDE
    o   Current Song: C New Song: G
    o   Updated Playlist: ABCGDE
-   addToEndOfPlaylist(song) // Only add, no need to print updated playlist
-   playNext() // Prints next song in playlist : Playing now : C
-   printCurrentPlaylist() // prints the current playlist and the current song

Guidance : Unless specified only perform the action, no need to print the playlist
*/
import java.util.*;

class UberLld {
    public static void main(String[] args) {
        // System.out.println("Hello, World");
        UberLld sol = new UberLld();
// /**
        // •    Add to endof playlist A , B , C , D , E .
        sol.addToEndOfPlaylist("A");
        sol.addToEndOfPlaylist("B");
        sol.addToEndOfPlaylist("C");
        sol.addToEndOfPlaylist("D");
        sol.addToEndOfPlaylist("E");
        sol.printCurrentPlaylist();
        // •    Print playlist
        // •    Remove current song
        // •    Print playlist
        // •    Play next
        // •    Play next
        // •    Print playlist
        // •    Remove current song
        // •    Print playlist
        // •    Remove song E
        // •    Print playlist
        // •    Play F after current song
        // •    Print playlist
        // •    Add G at end of playlist
        // •    Print playlist
        // •    Play next
        // •    Play next
        // •    Play next
        // •    Play next
        // •    Print playlist


    }

    PlayList playlist = null;

    public UberLld() {
        playlist = new PlayList();
    }

    void removeCurrentSong() {
        if (this.playlist.cur != null) {
            this.playlist.removeNode(this.playlist.cur.val);
        } else {
            System.out.print("Playlist is empty");
        }

        //remove cur
    } // ABCDE, curr = C, new_playlist = ABDE , new_curr_song : D

    void removeThisSong(String songName) {
        this.playlist.removeNode(songName);
        //get the song from map and rmeove it
    }  // Only remove, no need to print updated playlist

    void playAfterCurrent(String song) {
        playNext();
        this.playlist.addNode(this.playlist.cur, song);
    }
    // o    Example: Current Playlist: ABCDE
    // o    Current Song: C New Song: G
    // o    Updated Playlist: ABCGDE

    void addToEndOfPlaylist(String song) {
        this.playlist.addNode(this.playlist.tail.left, song);
    }

    // Only add, no need to print updated playlist
    void playNext() {
        if (this.playlist.cur != null) {
            this.playlist.cur = this.playlist.cur.right;
            if (this.playlist.cur == this.playlist.tail) {
                System.out.print("No further song ");
                this.playlist.cur = null;
            }
            System.out.print("Playing " + this.playlist.cur);
        } else {
            System.out.print("Playlist is empty");
        }

    } // Prints next song in playlist : Playing now : C

    void printCurrentPlaylist() {
        Node n = this.playlist.head.right;
        while (n != this.playlist.tail) {
            System.out.print(n.val + ", ");
            n = n.right;
        }
        System.out.println();
        if (this.playlist.cur != null) {
            System.out.println("Current. song " + this.playlist.cur.val);
        } else {
            System.out.println("No Current song");
        }
        //print the curret playlist
    } // prints the current playlist and the current song


    static class PlayList {
        public PlayList() {
            this.map = new HashMap<>();
            this.head = new Node("head");
            this.tail = new Node("tail");
            head.right = tail;
            tail.left = head;
        }

        public Map<String, Node> map;
        public Node head;
        public Node tail;
        public Node cur;

        //pass the prev node to add an element
        void addNode(Node curr, String song) {
            this.map.putIfAbsent(song, new Node(song));
            Node n = this.map.get(song);
            Node temp = curr.right;
            curr.right = n;
            n.left = curr;
            n.right = temp;
            // if(cur == null) {
            //     cur = head.right;
            // }
        }

        void removeNode(String name) {
            if (map.containsKey(name)) {
                Node song = map.get(name);
                song.left.right = song.right;
                song.right.left = song.left;
                map.remove(song.val);
                if (song == cur) {
                    if (cur.right == this.tail) {
                        this.cur = null;
                    } else {
                        this.cur = cur.right;
                    }
                }
            } else {
                System.out.println("song " + name + " not present");
            }
        }
    }

    static class Node {
        public Node(String song) {
            this.val = song;
        }

        String val;
        Node left;
        Node right;
    }

    /*
    Test Cases :
    •   Add to endof playlist A , B , C , D , E .
    •   Print playlist
    •   Remove current song
    •   Print playlist
    •   Play next
    •   Play next
    •   Print playlist
    •   Remove current song
    •   Print playlist
    •   Remove song E
    •   Print playlist
    •   Play F after current song
    •   Print playlist
    •   Add G at end of playlist
    •   Print playlist
    •   Play next
    •   Play next
    •   Play next
    •   Play next
    •   Print playlist
    */

}


