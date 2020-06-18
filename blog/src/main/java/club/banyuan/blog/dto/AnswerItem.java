package club.banyuan.blog.dto;

import club.banyuan.blog.model.Answer;
import club.banyuan.blog.model.User;

public class AnswerItem extends Answer {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
