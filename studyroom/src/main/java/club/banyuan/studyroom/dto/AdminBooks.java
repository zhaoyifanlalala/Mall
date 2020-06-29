package club.banyuan.studyroom.dto;

import club.banyuan.studyroom.model.Books;
import club.banyuan.studyroom.model.Seat;
import club.banyuan.studyroom.model.User;

public class AdminBooks extends Books {
    private User user;
    private Seat seat;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
}
