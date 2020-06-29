package club.banyuan.studyroom.dto;

public class BookHour {
    private String date;
    private Integer hour;
    private Boolean hasbooked;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Boolean getHasbooked() {
        return hasbooked;
    }

    public void setHasbooked(Boolean hasbooked) {
        this.hasbooked = hasbooked;
    }
}
