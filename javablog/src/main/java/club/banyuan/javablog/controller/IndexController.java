package club.banyuan.javablog.controller;

import club.banyuan.javablog.mapper.QuestionMapper;
import club.banyuan.javablog.model.Question;
import club.banyuan.javablog.model.QuestionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @Autowired
    private QuestionMapper questionMapper;

    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("name","半圆");

        QuestionExample example = new QuestionExample();
        example.setOrderByClause("id DESC");
        List<Question> questions = questionMapper.selectByExample(example);

        model.addAttribute("questions",questions);
        return "Index";
    }

    @GetMapping(value = "/articles")
    public String articles(Model model){
        List<String> articles = new ArrayList<>();
        articles.add("钢铁是怎样炼成的");
        articles.add("巴黎圣母院");
        articles.add("双城记");
        articles.add("雾都孤儿");
        articles.add("悲惨世界");
        model.addAttribute("articles",articles);
        return "articles";
    }

    @GetMapping(value = "/article/{name}")
    public String article(@PathVariable("name") String name, Model model){
        model.addAttribute("name",name);
        return "article";
    }
}
