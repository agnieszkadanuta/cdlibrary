package pl.dominisz.cdlibrary;

public enum Genre {

    ROCK("rock"),
    BLUES("blues"),
    TRIP_HOP("trip hop"),
    ALTERNATIVE("alternative"),
    FOLK("folk"),
    AMBIENT("ambient"),
    INDIE("indie"),
    CLASSICAL("classical");

    private String description;

    public String getDescription() {
        return description;
    }

    Genre(String description){
        this.description = description;
    }
}
