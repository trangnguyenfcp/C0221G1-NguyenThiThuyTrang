package ss16_io_text_file.exercise;

public class Nations {
    private int id;
    private String nationName;
    private String abbreviationName;
    public Nations(){}
    public Nations(int id, String abbreviationName, String nationName){
        this.id = id;
        this.abbreviationName = abbreviationName;
        this.nationName = nationName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }

    public String getAbbreviationName() {
        return abbreviationName;
    }

    public void setAbbreviationName(String abbreviationName) {
        this.abbreviationName = abbreviationName;
    }
}
