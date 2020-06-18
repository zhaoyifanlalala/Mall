package club.banyuan.blog.controller;

import club.banyuan.blog.dto.AnswerItem;
import club.banyuan.blog.dto.QuestionItem;
import club.banyuan.blog.mapper.AnswerMapper;
import club.banyuan.blog.mapper.QuestionMapper;
import club.banyuan.blog.mapper.UserMapper;
import club.banyuan.blog.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private AnswerMapper answerMapper;

    @Autowired
    private UserMapper userMapper;

    @GetMapping(value = "/")
    public String index(Model model, HttpSession session) {
        QuestionExample example = new QuestionExample();
        example.setOrderByClause("id DESC");
        List<Question> questions = questionMapper.selectByExampleWithBLOBs(example);


        // questions
        List<QuestionItem> questionItems = new ArrayList<>();
        for (Question question : questions) {
            QuestionItem questionItem = new QuestionItem();
            BeanUtils.copyProperties(question, questionItem);

            // 查询 user 放进 item
            User questionCreator = userMapper.selectByPrimaryKey(question.getUserId());
            questionItem.setUser(questionCreator);
            questionItems.add(questionItem);
        }

        model.addAttribute("questions", questionItems);

        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "index";
    }

    @GetMapping(value = "/question/create")
    public String questionCreate(Model model) {
        return "questionCreate";
    }

    @GetMapping(value = "/q/{id}")
    public String question(@PathVariable("id") Integer id, Model model) {
        Question question = questionMapper.selectByPrimaryKey(id);
        model.addAttribute("question", question);

        // 浏览数+1
        question.setViews(question.getViews() + 1);
        questionMapper.updateByPrimaryKeySelective(question);

        // 回答列表
        AnswerExample example = new AnswerExample();
        example.createCriteria().andQuestionIdEqualTo(id);
        example.setOrderByClause("id DESC");
        List<Answer> answers = answerMapper.selectByExampleWithBLOBs(example);

        List<AnswerItem> answerItems = new ArrayList<>();
        for (Answer answer : answers) {
            AnswerItem answerItem = new AnswerItem();
            BeanUtils.copyProperties(answer, answerItem);

            User answerCreator = userMapper.selectByPrimaryKey(answer.getUserId());
            answerItem.setUser(answerCreator);
            answerItems.add(answerItem);
        }
        model.addAttribute("answers", answerItems);

        return "question";
    }

    @GetMapping(value = "/login")
    public String login(Model model) {
        return "login";
    }


    @GetMapping(value = "/q/{questionId}/a-{answerId}/edit")
    public String editAnswer(
            @PathVariable("questionId") Integer questionId,
            @PathVariable("answerId") Integer answerId,
            Model model) {

        Question question = questionMapper.selectByPrimaryKey(questionId);
        Answer answer = answerMapper.selectByPrimaryKey(answerId);

        model.addAttribute("question", question);
        model.addAttribute("answer", answer);
        return "editAnswer";
    }

    @GetMapping(value = "/articles")
    public String articles(Model model) {
        List<String> articles = new ArrayList<>();
        articles.add("钢铁是怎样炼成的");
        articles.add("巴黎圣母院");
        articles.add("双城记");
        articles.add("雾都孤儿");
        articles.add("悲惨世界");
        model.addAttribute("articles", articles);
        return "articles";
    }

    @GetMapping(value = "/article/{name}")
    public String article(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
        return "article";
    }

    @GetMapping(value = "/demo")
    public String demo(Model model) {
        return "demo";
    }

    @GetMapping(value = "/logout")
    public String demo(Model model, HttpSession session) {
        session.removeAttribute("user");
        return "forward:/";
    }
}
