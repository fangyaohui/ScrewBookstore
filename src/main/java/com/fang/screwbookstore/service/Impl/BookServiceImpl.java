package com.fang.screwbookstore.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fang.screwbookstore.common.R;
import com.fang.screwbookstore.entity.Book;
import com.fang.screwbookstore.entity.TbBookexpand;
import com.fang.screwbookstore.mapper.BookMapper;
import com.fang.screwbookstore.service.BookService;
import com.fang.screwbookstore.service.TbBookexpandService;
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
    public R queryBookByX(String s) {

        LambdaQueryWrapper<TbBookexpand> queryWrapper = new LambdaQueryWrapper<>();
        if(s.equals("buynum")){
            queryWrapper.orderBy(true, false, TbBookexpand::getBuynun).last("LIMIT 19");
        }
        if(s.equals("price")){
            queryWrapper.orderBy(true, true, TbBookexpand::getPrice).last("LIMIT 19");
        }
        if(s.equals("grade")){
            queryWrapper.orderBy(true, false, TbBookexpand::getGrade).last("LIMIT 19");
        }
        List<TbBookexpand> list = tbBookexpandService.list(queryWrapper);
        System.out.println(list.toString());

        List<Integer> bookids = list.stream().map(TbBookexpand::getBookId).collect(Collectors.toList());

        List<Book> bookList = new ArrayList<>();
        for(int id : bookids){
            Book book = getById(id);
            bookList.add(book);
        }
//        R<List<Book>> ha= new R<>();
        return R.success(bookList);
    }


}
