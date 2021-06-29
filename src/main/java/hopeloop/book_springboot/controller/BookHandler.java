package hopeloop.book_springboot.controller;

import hopeloop.book_springboot.entity.Book;
import hopeloop.book_springboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookHandler {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/page/{page}/{size}")
    public Page<Book> finallAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Pageable pageable = PageRequest.of(page,size);
        return bookRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Book book){
        Book res = bookRepository.save(book);
        if(res != null)
            return "success";
        else
            return "error";
    }

    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        return bookRepository.findById(id).get();
    }

    @PostMapping("/update")
    public String update(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if (result!=null){
            return "success";
        }else {
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        bookRepository.deleteById(id);
    }
}
