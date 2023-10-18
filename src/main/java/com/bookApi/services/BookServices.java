package com.bookApi.services;

import com.bookApi.dao.BookRepository;
import com.bookApi.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookServices {
    @Autowired
    private BookRepository bookRepository;
    public List<Book> getAllBooks() {
       List<Book> list=this.bookRepository.findAll();
        return list;
    }
    public Book getBookById(int id){
        Book book=null;
//        book=list.stream().filter(e->e.getId()==id).findFirst().get();
        try {
           book= this.bookRepository.findById(id).get();
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
//    public void updateBook(Book book ,int bookId){
////        list=list.stream().map(b->{
////            if(book.getId()==bookId){
////                b.setTitle(book.getTitle());
////                b.setAuthor(book.getAuthor());
////            }
////            return b;
////        }).collect(Collectors.toList());
//        book.setId(bookId);
//        this.bookRepository.save(book);
//    }
    public void updateBook(Book updatedBook, int bookId) {
        Optional<Book> existingBookOptional = this.bookRepository.findById(bookId);

        if (existingBookOptional.isPresent()) {
            Book existingBook = existingBookOptional.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            this.bookRepository.save(existingBook); // Update the existing book in the database
        } else {
            // Handle the case where the book with the given ID is not found
            System.out.println("Book "+bookId+" is not found");
        }
    }

}
