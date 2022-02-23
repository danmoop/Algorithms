package search;

import playable.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Catalog implements Search {
    private static Catalog catalog;
    private List<Category> categories;
    private List<Song> songs;

    public Catalog(List<Category> categories, List<Song> songs) {
        this.categories = categories;
        this.songs = songs;
    }

    private Catalog() {
        this.categories = new ArrayList<>();
        this.songs = new ArrayList<>();
    }

    public static Catalog getInstance() {
        if (catalog == null) {
            catalog = new Catalog();
        }

        return catalog;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        return songs.stream()
                .filter(song -> song.getTitle().contains(title))
                .collect(Collectors.toList());
    }

    @Override
    public List<Song> searchByArtist(String artist) {
        return songs.stream()
                .filter(song -> song.getArtist().getName().contains(artist))
                .collect(Collectors.toList());
    }

    @Override
    public List<Song> searchByGenre(String genre) {
        return songs.stream()
                .filter(song -> song.getGenre().contains(genre))
                .collect(Collectors.toList());
    }

    @Override
    public List<Song> searchByYear(int year) {
        return songs.stream()
                .filter(song -> song.getYear() == year)
                .collect(Collectors.toList());
    }

    public static Catalog getCatalog() {
        return catalog;
    }

    public static void setCatalog(Catalog catalog) {
        Catalog.catalog = catalog;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}