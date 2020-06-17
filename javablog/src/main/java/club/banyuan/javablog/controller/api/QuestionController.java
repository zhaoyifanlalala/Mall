package club.banyuan.javablog.controller.api;

import club.banyuan.javablog.common.CommonResult;
import club.banyuan.javablog.mapper.QuestionMapper;
import club.banyuan.javablog.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
    @Autowired
    private QuestionMapper questionMapper;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Question question){
        questionMapper.insertSelective(question);
        return CommonResult.success("OK");
    }

    @PostMapping(value = "/update")
    public CommonResult update(@RequestBody Question question) {
        questionMapper.updateByPrimaryKeySelective(question);
        return CommonResult.success("OK");
    }
}
