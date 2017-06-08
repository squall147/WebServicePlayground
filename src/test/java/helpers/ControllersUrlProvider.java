package helpers;

public enum ControllersUrlProvider {

    SQRT_CALCULATION("http://localhost:%d/calculation/sqrt/");

    private final static int PORT_NUMBER = 8181;
    private final String url;

    ControllersUrlProvider(String url) {
        this.url = url;
    }

    public String getUrl() {
        return String.format(url, PORT_NUMBER);
    }
}
