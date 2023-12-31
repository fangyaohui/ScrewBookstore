package com.fang.screwbookstore.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fang.screwbookstore.common.Result;
import com.fang.screwbookstore.dto.BookDto;
import com.fang.screwbookstore.entity.Book;
import com.fang.screwbookstore.entity.TbBookexpand;
import com.fang.screwbookstore.mapper.BookMapper;
import com.fang.screwbookstore.service.BookService;
import com.fang.screwbookstore.service.TbBookexpandService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {

    @Autowired
    private TbBookexpandService tbBookexpandService;
    /**
     *
     * @param s
     * @return R<list<Book>>
     */
    @Override
    public Result queryBookByX(String s) {

        LambdaQueryWrapper<TbBookexpand> queryWrapper = new LambdaQueryWrapper<>();
        if(s.equals("buynum")){
            queryWrapper.orderBy(true, false, TbBookexpand::getBuynum).last("LIMIT 19");
        }
        if(s.equals("price")){
            queryWrapper.orderBy(true, true, TbBookexpand::getPrice).last("LIMIT 19");
        }
        if(s.equals("grade")){
            queryWrapper.orderBy(true, false, TbBookexpand::getGrade).last("LIMIT 19");
        }
        List<TbBookexpand> list = tbBookexpandService.list(queryWrapper);
//        System.out.println(list.toString());

        List<Integer> bookids = list.stream().map(TbBookexpand::getBookId).collect(Collectors.toList());

        List<Book> bookList = new ArrayList<>();
        for(int id : bookids){
            Book book = getById(id);
            bookList.add(book);
        }
//        R<List<Book>> ha= new R<>();
        return Result.ok(bookList);
    }

    /**
     * 该函数：
     *      1、通过使用DTO从后端返回数据（DTO用于封装特定领域的数据，并提供一个清晰的接口来传输数据。它可以将相关的数据字段组合在一起，形成一个逻辑上的数据单元，方便在不同模块之间传递和处理）
     *      2、通过BeanUtils.copyProperties(book,bookDto);进行复制实现DTO
     * @param id
     * @return
     */
    @Override
    public Result queryBookById(int id) {
        Book book =  query().eq("id",id).one();

        TbBookexpand tbBookexpand = tbBookexpandService.query().eq("book_id",id).one();

        BookDto bookDto = new BookDto();
        BeanUtils.copyProperties(book,bookDto);
        bookDto.setTbBookexpand(tbBookexpand);

        return Result.ok(bookDto);
    }


}
