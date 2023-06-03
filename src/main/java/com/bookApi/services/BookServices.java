package com.bookApi.services;

import com.bookApi.dao.BookRepository;
import com.bookApi.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class BookServices {
    @Autowired
    private BookRepository bookRepository;
//    public static List<Book> list=new ArrayList<>();
//    static{
//        list.add(new Book(101,"Java Complete","ABC"));
//        list.add(new Book(102,"Python Complete","XYZ"));
//        list.add(new Book(103,"ReactJs Complete","DEF"));
//    }

    public List<Book> getAllBooks() {
       List list=(List<Book>)this.bookRepository.findAll();
        return list;
    }
    public Book getBookById(int id){
        Book book=null;
//        book=list.stream().filter(e->e.getId()==id).findFirst().get();
        try {
           book= this.bookRepository.findById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return book;
    }

    //adding
    public Book addBook(Book book){
        //list.add(book);
        Book result=this.bookRepository.save(book);
        return result;
    }

    //for deleting
    public void deleteBook(int id){
      //  list = list.stream().filter(book->book.getId()!=id).collect(Collectors.toList());
        this.bookRepository.deleteById(id);
    }
    public void updateBook(Book book ,int bookId){
//        list=list.stream().map(b->{
//            if(book.getId()==bookId){
//                b.setTitle(book.getTitle());
//                b.setAuthor(book.getAuthor());
//            }
//            return b;
//        }).collect(Collectors.toList());
        book.setId(bookId);
        this.bookRepository.save(book);
    }
}
