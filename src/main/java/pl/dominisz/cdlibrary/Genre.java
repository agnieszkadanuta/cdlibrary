package pl.dominisz.cdlibrary;

public enum Genre {

    ROCK("rock"),
    BLUES("blues"),
    TRIP_HOP("trip hop"),
    ALTERNATIVE("alternative"),
    FOLK("folk"),
    AMBIENT("ambient"),
    INDIE("indie"),
    ELECTRONIC("electronic"),
    POP("pop"),
    R_AND_B("R&B"),
    CLASSICAL("classical");

    private String description;

    public String getDescription() {
        return description;
    }

    Genre(String description){
        this.description = description;
    }

    public static Genre fromDescription(String description){
        return null;
    }
}
