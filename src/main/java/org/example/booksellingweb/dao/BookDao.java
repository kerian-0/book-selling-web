package org.example.booksellingweb.dao;

import org.example.booksellingweb.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDao extends JpaRepository<Book, Long> {
}
