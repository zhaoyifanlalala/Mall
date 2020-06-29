package club.banyuan.studyroom.controller.api;

import club.banyuan.studyroom.Appconst.AppConst;
import club.banyuan.studyroom.common.CommonResult;
import club.banyuan.studyroom.dto.BookHour;
import club.banyuan.studyroom.dto.SeatShow;
import club.banyuan.studyroom.mapper.BooksMapper;
import club.banyuan.studyroom.mapper.SeatMapper;
import club.banyuan.studyroom.model.Books;
import club.banyuan.studyroom.model.BooksExample;
import club.banyuan.studyroom.model.Seat;
import club.banyuan.studyroom.model.SeatExample;
import club.banyuan.studyroom.utils.DateUtils;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/seat")
public class SeatController {

    @Autowired
    private SeatMapper seatMapper;
    @Autowired
    private BooksMapper booksMapper;

    @GetMapping(value = "/show")
    public CommonResult<List<Seat>> show() {
        SeatExample example = new SeatExample();
        List<Seat> positions = seatMapper.selectByExample(example);
        return CommonResult.success(positions);
    }

    @GetMapping(value = "/seatshow/{id}")
    public CommonResult seatShow(@PathVariable Integer id) {

        // 查询 AppConst. 个
        String todayDate = DateUtils.getTodayDate();
        BooksExample example = new BooksExample();
        example.createCriteria()
                .andSeatIdEqualTo(id)
                .andBookStatusEqualTo(false)
                .andHoursEqualTo(todayDate);
        List<Books> books = booksMapper.selectByExample(example);

        // 预处理一下数据
        List<String> bookKeys = new ArrayList<>();
        for (Books book : books) {
            bookKeys.add(book.getCreatedAt() + "-" + book.getHours());
        }

        // 组装 48 个坑位
        Date dateObj = new Date();
        List<BookHour> bookHours = new ArrayList<>();
        for (int i = 0; i < AppConst.BOOK_HOURS_LIMIT; i++) {
            DateTime dateTime = DateUtil.offsetHour(dateObj, 1);
            dateObj = dateTime.toJdkDate();
            String date = DateUtil.format(dateObj, DateUtils.DATE_STYLE);
            String hour = DateUtil.format(dateObj, "HH"); // 硬编码 code smell

            BookHour bookHour = new BookHour();
            bookHour.setDate(date);
            bookHour.setHour(Integer.parseInt(hour));
            String key = date + "-" + hour;
            if (bookKeys.contains(key)) {
                bookHour.setHasbooked(true);
            } else {
                bookHour.setHasbooked(false);
            }
            bookHours.add(bookHour);
        }

        SeatShow seatShow = new SeatShow();
        seatShow.setSeat(seatMapper.selectByPrimaryKey(id));
        seatShow.setBookHours(bookHours);

        return CommonResult.success(seatShow);
    }
}
