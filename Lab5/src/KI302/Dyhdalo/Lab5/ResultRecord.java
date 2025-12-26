package KI302.Dyhdalo.Lab5;

import java.time.LocalDateTime;

public class ResultRecord {
    private LocalDateTime timestamp;
    private double x;
    private double y;
    private String status;
    private String message;

    public ResultRecord(LocalDateTime timestamp, double x, double y, String status, String message) {
        this.timestamp = timestamp;
        this.x = x;
        this.y = y;
        this.status = status;
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return String.format("%s | x=%.10f | y=%.10f | %s | %s",
                timestamp, x, y, status, message);
    }
}
