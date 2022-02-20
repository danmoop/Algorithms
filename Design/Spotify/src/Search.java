import java.util.List;

public interface Search {
    List<Song> searchByTitle(String title);

    List<Song> searchByArtist(String artist);

    List<Song> searchByGenre(String genre);

    List<Song> searchByYear(int year);
}