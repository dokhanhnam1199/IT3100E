public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    public java.lang.String getTitle() {
        return title;
    }

    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    public java.lang.String getCategory() {
        return category;
    }

    public void setCategory(java.lang.String category) {
        this.category = category;
    }

    public java.lang.String getDirector() {
        return director;
    }

    public void setDirector(java.lang.String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public DigitalVideoDisc(java.lang.String title) {
        this.title = title;
    }

    public DigitalVideoDisc(java.lang.String title, java.lang.String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(java.lang.String title, java.lang.String category, java.lang.String director, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
    }

    public DigitalVideoDisc(java.lang.String title, java.lang.String category, java.lang.String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
    }
}
