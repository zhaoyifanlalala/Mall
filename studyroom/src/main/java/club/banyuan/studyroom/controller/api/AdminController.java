package club.banyuan.studyroom.controller.api;
import club.banyuan.studyroom.common.CommonResult;
import club.banyuan.studyroom.dto.AdminBooks;
import club.banyuan.studyroom.mapper.BooksMapper;
import club.banyuan.studyroom.mapper.SeatMapper;
import club.banyuan.studyroom.mapper.UserMapper;
import club.banyuan.studyroom.model.Seat;
import club.banyuan.studyroom.model.Books;
import club.banyuan.studyroom.model.BooksExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/admin")
public class AdminController {

    @Autowired
    private SeatMapper seatMapper;
    @Autowired
    private BooksMapper booksMapper;
    @Autowired
    private UserMapper userMapper;


    @PostMapping(value = "/create")
    public CommonResult create(@RequestBody Seat seat) {
        seatMapper.insertSelective(seat);
        return CommonResult.success("OK");
    }

    @GetMapping(value = "/books")
    public CommonResult books() {
        BooksExample example = new BooksExample();
        example.setOrderByClause("id");
        List<Books> books = booksMapper.selectByExample(example);
        List<AdminBooks> adminBooks = new ArrayList<>();
        for (Books book : books) {
            AdminBooks adminBooks1 = new AdminBooks();
            adminBooks1.setUserId(book.getUserId());
            adminBooks1.setUser(userMapper.selectByPrimaryKey(book.getUserId()));
            adminBooks1.setSeatId(book.getSeatId());
            adminBooks1.setSeat(seatMapper.selectByPrimaryKey(book.getSeatId()));
            adminBooks1.setBookStatus(book.getBookStatus());
            adminBooks1.setHours(book.getHours());
            adminBooks1.setCreatedAt(book.getCreatedAt());

            adminBooks.add(adminBooks1);
        }

        return CommonResult.success(adminBooks);

    }
}