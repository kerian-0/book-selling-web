package org.example.booksellingweb;

import org.example.booksellingweb.entity.Book;
import org.example.booksellingweb.repostory.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class BookSellingWebApplication {
    @Autowired
    private BookRepository bookRepository;
    @Bean @Transactional @Profile("dev")
    public ApplicationRunner runer(){
        return r->{
            Book book = new Book("adolescence","James",
                    """
                    Between life and death there is a library,
                     and within that library, the shelves go on forever.
                    """

                    ,"adolescence",2.00);
            Book book1 = new Book("annihilation","James","Hey How are you I'hope you are well and happy as for me I'm fine","annihilation",2.11);
            Book book2 = new Book("arrival","James","Hey How are you I'hope you are well and happy as for me I'm fine","arrival",1.23);
            Book book3 = new Book("blade-runner-2049","James","Hey How are you I'hope you are well and happy as for me I'm fine","blade-runner-2049",2.11);
            Book book4 = new Book("booksmart","James","Hey How are you I'hope you are well and happy as for me I'm fine","booksmart",1.32);
            bookRepository.save(book);
            bookRepository.save(book1);
            bookRepository.save(book2);
            bookRepository.save(book3);
            bookRepository.save(book4);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(BookSellingWebApplication.class, args);
    }

}
//adolescence
//        annihilation
//arrival
//blade-runner-2049
//booksmart