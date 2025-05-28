package org.example.booksellingweb;

import org.example.booksellingweb.dao.BookDao;
import org.example.booksellingweb.entity.Book;
import org.example.booksellingweb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class BookSellingWebApplication {

    @Autowired
    private BookService bookService;
    @Autowired
    private BookDao bookDao;

    @Bean
    public ApplicationRunner runner(){
        return r -> {
            Book b1 = new Book("Good Night Tokyo","ATSUHIRO YOSHIDA","Slice-of-Life","Goodnight Tokyo by Atsuhiro Yoshida is a lyrical novel set in Tokyo’s nocturnal hours, " +
                    "blending interconnected stories of lonely characters—a taxi driver," +
                    " a prop procurer, an insomniac call girl, and a retired detective. ", LocalDate.of(2018,7,9),"b1.jpg");
            Book b2 = new Book("How Do You Live?", "Genzaburō Yoshino", "Literary Fiction",
                    "How Do You Live? by Genzaburō Yoshino is a heartwarming Japanese classic that follows a young boy’s journey of self-discovery, guided by his uncle’s letters, exploring themes of morality, empathy, and personal growth in a reflective narrative.",
                    LocalDate.of(2021, 10, 19), "b2.jpg");
            Book b3 = new Book("Snow Country", "Yasunari Kawabata", "Literary Fiction",
                    "Snow Country by Yasunari Kawabata is a hauntingly poetic novel about a doomed love affair between a Tokyo dilettante and a rural geisha, set against the backdrop of Japan’s snowy mountains, exploring themes of beauty, isolation, and transience.",
                    LocalDate.of(1956, 1, 1), "b3.jpg");

            Book b4 = new Book("The Magical Language of Others", "E.J. Koh", "Memoir",
                    "The Magical Language of Others by E.J. Koh is a poignant memoir exploring the author’s complex relationship with her mother through translated letters, delving into themes of family, language, and cultural identity across generations.",
                    LocalDate.of(2020, 1, 7), "b4.jpg");

            Book b5 = new Book("Kiki's Delivery Service", "Eiko Kadono", "Fantasy",
                    "Kiki's Delivery Service by Eiko Kadono is a whimsical fantasy novel about a young witch named Kiki who starts a delivery service in a new town, discovering independence, friendship, and self-confidence along the way.",
                    LocalDate.of(1985, 1, 25), "b5.jpg");

            Book b6 = new Book("Before the Coffee Gets Cold", "Toshikazu Kawaguchi", "Fantasy",
                    "Before the Coffee Gets Cold by Toshikazu Kawaguchi is a touching fantasy novel set in a Tokyo café where customers can travel back in time, exploring themes of love, regret, and the fleeting nature of life through interconnected stories.",
                    LocalDate.of(2019, 9, 19), "b6.jpg");

            Book b7 = new Book("The Convenience Store by the Sea", "Sonoko Machida", "Literary Fiction",
                    "The Convenience Store by the Sea by Sonoko Machida is a heartwarming novel about the quiet lives of people connected through a seaside convenience store, exploring themes of community, kindness, and the beauty of everyday moments.",
                    LocalDate.of(2023, 3, 14), "b7.jpg");

            Book b8 = new Book("The Lantern of Lost Memories", "Sanaka Hiiragi", "Fantasy",
                    "The Lantern of Lost Memories by Sanaka Hiiragi is a magical novel about a photo studio where people revisit their happiest memories before passing on, weaving stories of love, loss, and the power of cherished moments.",
                    LocalDate.of(2024, 10, 15), "b8.jpg");

            Book b9 = new Book("The Tale of Genji", "Murasaki Shikibu", "Historical Fiction",
                    "The Tale of Genji by Murasaki Shikibu is a classic of Japanese literature, often considered the world’s first novel, following the life and loves of Prince Genji in the Heian court, exploring themes of romance, power, and impermanence.",
                    LocalDate.of(2001, 10, 1), "b9.jpg");
            Book b10 = new Book("Night's Dark Terror", "Graeme Morris", "Fantasy",
                    "Night's Dark Terror by Graeme Morris is a classic wilderness adventure module for Dungeons & Dragons, featuring a gripping plot with grim urban and lost civilization themes, suitable for months of gameplay.",
                    LocalDate.of(1986, 6, 1), "b10.jpg");
            bookDao.save(b1);
            bookDao.save(b2);
            bookDao.save(b3);
            bookDao.save(b4);
            bookDao.save(b5);
            bookDao.save(b6);
            bookDao.save(b7);
            bookDao.save(b8);
            bookDao.save(b9);
            bookDao.save(b10);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(BookSellingWebApplication.class, args);
    }

}
