package club.banyuan.javablog.mapper;

import club.banyuan.javablog.model.Answer;
import club.banyuan.javablog.model.AnswerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnswerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table answer
     *
     * @mbg.generated Wed Jun 17 00:22:35 CST 2020
     */
    long countByExample(AnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table answer
     *
     * @mbg.generated Wed Jun 17 00:22:35 CST 2020
     */
    int deleteByExample(AnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table answer
     *
     * @mbg.generated Wed Jun 17 00:22:35 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table answer
     *
     * @mbg.generated Wed Jun 17 00:22:35 CST 2020
     */
    int insert(Answer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table answer
     *
     * @mbg.generated Wed Jun 17 00:22:35 CST 2020
     */
    int insertSelective(Answer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table answer
     *
     * @mbg.generated Wed Jun 17 00:22:35 CST 2020
     */
    List<Answer> selectByExampleWithBLOBs(AnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table answer
     *
     * @mbg.generated Wed Jun 17 00:22:35 CST 2020
     */
    List<Answer> selectByExample(AnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table answer
     *
     * @mbg.generated Wed Jun 17 00:22:35 CST 2020
     */
    Answer selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table answer
     *
     * @mbg.generated Wed Jun 17 00:22:35 CST 2020
     */
    int updateByExampleSelective(@Param("record") Answer record, @Param("example") AnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table answer
     *
     * @mbg.generated Wed Jun 17 00:22:35 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") Answer record, @Param("example") AnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table answer
     *
     * @mbg.generated Wed Jun 17 00:22:35 CST 2020
     */
    int updateByExample(@Param("record") Answer record, @Param("example") AnswerExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table answer
     *
     * @mbg.generated Wed Jun 17 00:22:35 CST 2020
     */
    int updateByPrimaryKeySelective(Answer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table answer
     *
     * @mbg.generated Wed Jun 17 00:22:35 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(Answer record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table answer
     *
     * @mbg.generated Wed Jun 17 00:22:35 CST 2020
     */
    int updateByPrimaryKey(Answer record);
}