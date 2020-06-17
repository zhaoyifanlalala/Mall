package club.banyuan.javablog.controller.api;
import club.banyuan.javablog.mapper.AnswerMapper;
import club.banyuan.javablog.model.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/answer")
public class AnswerController {
    @Autowired
    private AnswerMapper answerMapper;

    @PostMapping(value = "/create")
    public String create(@RequestBody Answer answer) {
        answerMapper.insertSelective(answer);
        return "OK";
    }
}