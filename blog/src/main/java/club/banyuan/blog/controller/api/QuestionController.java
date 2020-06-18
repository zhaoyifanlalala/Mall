package club.banyuan.blog.controller.api;

import club.banyuan.blog.common.CommonResult;
import club.banyuan.blog.dto.QuestionCreateParam;
import club.banyuan.blog.mapper.QuestionMapper;
import club.banyuan.blog.mapper.TagMapper;
import club.banyuan.blog.mapper.TagQuestionRelationMapper;
import club.banyuan.blog.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RequestMapping(value = "/api/question")
@RestController
public class QuestionController {

    @Autowired
    private QuestionMapper questionMapper;

    @Autowired
    private TagQuestionRelationMapper relationMapper;

    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody QuestionCreateParam param, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return CommonResult.failed("您尚未登录！");
        }

        Question question = new Question();
        question.setTitle(param.getTitle());
        question.setContent(param.getContent());
        question.setUserId(user.getId());
        questionMapper.insertSelective(question);

        // 标签
        if (!CollectionUtils.isEmpty(param.getTagIds())) {
            for (Integer tagId : param.getTagIds()) {
                TagQuestionRelation relation = new TagQuestionRelation();
                relation.setQuestionId(question.getId());
                relation.setTagId(tagId);
                relationMapper.insertSelective(relation);
            }
        }
        return CommonResult.success("OK");
    }

    @PostMapping(value = "/update")
    public CommonResult update(@RequestBody Question question) {
        questionMapper.updateByPrimaryKeySelective(question);
        return CommonResult.success("OK");
    }

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private TagQuestionRelationMapper tagQuestionRelationMapper;

    @GetMapping(value = "/getTags/{questionId}")
    public CommonResult getTags(@PathVariable("questionId") Integer questionId) {

        TagQuestionRelationExample example1 = new TagQuestionRelationExample();
        example1.createCriteria().andQuestionIdEqualTo(questionId);
        List<TagQuestionRelation> relations = tagQuestionRelationMapper.selectByExample(example1);

        List<Integer> tagIds = new ArrayList<>();
        for (TagQuestionRelation relation : relations) {
            tagIds.add(relation.getTagId());
        }

        // tag
        TagExample example2 = new TagExample();
        example2.createCriteria().andIdIn(tagIds);
        List<Tag> tags = tagMapper.selectByExample(example2);

        return CommonResult.success(tags);
    }
}
