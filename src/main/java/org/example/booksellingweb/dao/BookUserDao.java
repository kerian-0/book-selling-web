package org.example.booksellingweb.dao;

import org.example.booksellingweb.ds.BookUserInfo;
import org.example.booksellingweb.entity.BookUserOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookUserDao extends JpaRepository<BookUserOrder, Long> {

@Query("""
    select new org.example.booksellingweb.ds.BookUserInfo(bo.id, b.bookName, u.username, bo.date)
    from Book b join b.bookUserOrders bo join bo.user u where u.username = ?1
            """)
List<BookUserInfo> findByUsername(String username);

}
