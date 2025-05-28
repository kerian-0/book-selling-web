package org.example.booksellingweb.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles=
            new HashSet<Role>();

    @OneToMany(mappedBy = "user")
    private List<BookUserOrder> bookUserOrders=new ArrayList<>();

    public  void addBookUserOrder(BookUserOrder bookUserOrder){
        bookUserOrder.setUser(this);
        bookUserOrders.add(bookUserOrder);


    }

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;

    }
    public void addRole(Role role) {
        roles.add(role);
    }

}
