package hopeloop.book_springboot.repository;

import hopeloop.book_springboot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book,Integer> {

}
