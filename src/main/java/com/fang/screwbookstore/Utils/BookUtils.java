package com.fang.screwbookstore.Utils;

import com.fang.screwbookstore.entity.Book;
import org.springframework.beans.factory.annotation.Value;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BookUtils {

//    private static String ImagePath = SystemConstants.BOOK_IMAGE_PATH;

    public static List<Book> BookImagePath(List<Book> books,String pre){
//        System.out.println(ImagePath);
        for(Book book : books){
            String path = book.getImgpath();
//            path = path.substring(1);
//            System.out.println(path);
            book.setImgpath(pre + path);
//            System.out.println(book);
//            break;
        }

        return books;
    }

    public static Set<Integer> generateRandomNumbers(int count) {
        Set<Integer> randomNumbers = new HashSet<>();
        Random random = new Random();

        while (randomNumbers.size() < count) {
            int randomNumber = random.nextInt(SystemConstants.BOOK_NUM); // 生成0到99之间的随机数
            randomNumbers.add(randomNumber);
        }

        return randomNumbers;
    }

}
