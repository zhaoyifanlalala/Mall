package club.banyuan.blog.dto;

import club.banyuan.blog.model.Question;
import club.banyuan.blog.model.User;

public class QuestionItem extends Question {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
