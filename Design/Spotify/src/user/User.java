package user;

import playable.Song;
import search.Artist;
import search.Playlist;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String email;
    private String photo;
    private List<Playlist> privatePlaylists;
    private List<Playlist> activePlaylists;
    private List<Artist> following;
    private List<Artist> recentlyPlayed;
    private List<Artist> topArtists;
    private List<Song> topTracks;
    private List<Song> likedTracks;
    private AccountType accountType;

    public User(String username, String password, String email, String photo, AccountType accountType) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.photo = photo;
        this.privatePlaylists = new ArrayList<>();
        this.activePlaylists = new ArrayList<>();
        this.following = new ArrayList<>();
        this.recentlyPlayed = new ArrayList<>();
        this.topArtists = new ArrayList<>();
        this.topTracks = new ArrayList<>();
        this.likedTracks = new ArrayList<>();
        this.accountType = accountType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public List<Playlist> getPrivatePlaylists() {
        return privatePlaylists;
    }

    public void setPrivatePlaylists(List<Playlist> privatePlaylists) {
        this.privatePlaylists = privatePlaylists;
    }

    public List<Playlist> getActivePlaylists() {
        return activePlaylists;
    }

    public void setActivePlaylists(List<Playlist> activePlaylists) {
        this.activePlaylists = activePlaylists;
    }

    public List<Artist> getFollowing() {
        return following;
    }

    public void setFollowing(List<Artist> following) {
        this.following = following;
    }

    public List<Artist> getRecentlyPlayed() {
        return recentlyPlayed;
    }

    public void setRecentlyPlayed(List<Artist> recentlyPlayed) {
        this.recentlyPlayed = recentlyPlayed;
    }

    public List<Artist> getTopArtists() {
        return topArtists;
    }

    public void setTopArtists(List<Artist> topArtists) {
        this.topArtists = topArtists;
    }

    public List<Song> getTopTracks() {
        return topTracks;
    }

    public void setTopTracks(List<Song> topTracks) {
        this.topTracks = topTracks;
    }

    public List<Song> getLikedTracks() {
        return likedTracks;
    }

    public void setLikedTracks(List<Song> likedTracks) {
        this.likedTracks = likedTracks;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}