package club.banyuan.studyroom.dto;

import club.banyuan.studyroom.model.Books;
import club.banyuan.studyroom.model.Seat;


import java.util.List;

public class SeatShow {
    private Seat seat;
    private List<BookHour> bookHours;

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public List<BookHour> getBookHours() {
        return bookHours;
    }

    public void setBookHours(List<BookHour> bookHours) {
        this.bookHours = bookHours;
    }
}
