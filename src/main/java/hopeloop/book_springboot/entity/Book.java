package hopeloop.book_springboot.entity;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//和数据表绑定
@Entity //表名和类名的映射关系，类名小写就是表明
@Data   //lombok注解，自动生成get方法
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//设置ID自增
    private Integer id;
    private String name;
    private String author;

}
