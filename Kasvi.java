public class Kasvi {
    private double koko;
    private double kasvuNopeus;
    public Kasvi(double koko) {
        this.koko = koko;
    }
    public void kasva() {
        this.koko += kasvuNopeus;
    }
}