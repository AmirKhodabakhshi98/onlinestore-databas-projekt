package database;

public class DatabaseSettings {

    private String user;

    private String password;

    private String url;

    public DatabaseSettings(String url, String user, String password) {

        this.url = url;

        this.user = user;

        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
