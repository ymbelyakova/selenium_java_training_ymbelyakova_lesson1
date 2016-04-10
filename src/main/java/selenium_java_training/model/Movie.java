package selenium_java_training.model;

import java.io.File;

public class Movie {
    private String imdbsearch;
    private String imdbid;
    private String title;
    private String aka;
    private String year;
    private String duration;
    private String rating;
    private String format;
    private boolean own;
    private boolean seen;
    private boolean loaned;
    private File cover;
    private String trailer;
    private String notes;
    private String taglines;
    private String plotoutline;
    private String plots;
    private String languages;
    private String subtitles;
    private String audio;
    private String video;
    private String country;
    private String genres;
    private String director;
    private String writer;
    private String producer;
    private String music;
    private String cast;

    public String getImdbsearch() {
        return imdbsearch;
    }

    public Movie setImdbsearch(String imdb) {
        this.imdbsearch = imdb;
        return this;
    }

    public String getImdbid() {
        return imdbid;
    }

    public Movie setImdbid(String imdbid) {
        this.imdbid = imdbid;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Movie setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getAka() {
        return aka;
    }

    public Movie setAka(String aka) {
        this.aka = aka;
        return this;
    }

    public String getYear() {
        return year;
    }

    public Movie setYear(String year) {
        this.year = year;
        return this;
    }

    public String getDuration() {
        return duration;
    }

    public Movie setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    public String getRating() {
        return rating;
    }

    public Movie setRating(String rating) {
        this.rating = rating;
        return this;
    }

    public String getFormat() {
        return format;
    }

    public Movie setFormat(String format) {
        this.format = format;
        return this;
    }

    public boolean isOwn() {
        return own;
    }

    public Movie setOwn(boolean own) {
        this.own = own;
        return this;
    }

    public boolean isSeen() {
        return seen;
    }

    public Movie setSeen(boolean seen) {
        this.seen = seen;
        return this;
    }

    public boolean isLoanedOut() {
        return loaned;
    }

    public Movie setLoanedOut(boolean loanedOut) {
        this.loaned = loanedOut;
        return this;
    }

    public File getCover() {
        return cover;
    }

    public Movie setCover(File cover) {
        this.cover = cover;
        return this;
    }

    public String getTrailer() {
        return trailer;
    }

    public Movie setTrailer(String trailerUrl) {
        this.trailer = trailerUrl;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public Movie setNotes(String personalNotes) {
        this.notes = personalNotes;
        return this;
    }

    public String getTaglines() {
        return taglines;
    }

    public Movie setTaglines(String taglines) {
        this.taglines = taglines;
        return this;
    }

    public String getPlotOutline() {
        return plotoutline;
    }

    public Movie setPlotOutline(String plotOutline) {
        this.plotoutline = plotOutline;
        return this;
    }

    public String getPlots() {
        return plots;
    }

    public Movie setPlots(String plots) {
        this.plots = plots;
        return this;
    }

    public String getLanguages() {
        return languages;
    }

    public Movie setLanguages(String languages) {
        this.languages = languages;
        return this;
    }

    public String getSubtitles() {
        return subtitles;
    }

    public Movie setSubtitles(String subtitles) {
        this.subtitles = subtitles;
        return this;
    }

    public String getAudio() {
        return audio;
    }

    public Movie setAudio(String audio) {
        this.audio = audio;
        return this;
    }

    public String getVideo() {
        return video;
    }

    public Movie setVideo(String video) {
        this.video = video;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Movie setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getGenres() {
        return genres;
    }

    public Movie setGenres(String genres) {
        this.genres = genres;
        return this;
    }

    public String getDirector() {
        return director;
    }

    public Movie setDirector(String director) {
        this.director = director;
        return this;
    }

    public String getWriter() {
        return writer;
    }

    public Movie setWriter(String writer) {
        this.writer = writer;
        return this;
    }

    public String getProducer() {
        return producer;
    }

    public Movie setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    public String getMusic() {
        return music;
    }

    public Movie setMusic(String music) {
        this.music = music;
        return this;
    }

    public String getCast() {
        return cast;
    }

    public Movie setCast(String cast) {
        this.cast = cast;
        return this;
    }

}
