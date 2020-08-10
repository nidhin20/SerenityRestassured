package starter;

public enum WebServiceEndPoints {
    STATUS("http://localhost:8080"),
    TRADE("http://localhost:8080"),
    LOGIN("http://localhost:8080");

    private final String url;

    WebServiceEndPoints(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
