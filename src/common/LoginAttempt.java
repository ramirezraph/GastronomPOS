package common;

public class LoginAttempt {

    private String username;
    private int numberOfAttempt;
    private String status;

    public LoginAttempt(String username){
        this(username, 1, "Not locked");
    }

    public LoginAttempt(String username, int numberOfAttempt, String status) {
        this.username = username;
        this.numberOfAttempt = numberOfAttempt;
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumberOfAttempt() {
        return numberOfAttempt;
    }

    public void setNumberOfAttempt(int numberOfAttempt) {
        this.numberOfAttempt = numberOfAttempt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

