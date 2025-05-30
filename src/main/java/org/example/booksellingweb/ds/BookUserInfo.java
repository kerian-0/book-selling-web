package org.example.booksellingweb.ds;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public record BookUserInfo(
     Long id,
     String bookName,
     String username,
     LocalDate date)

    {


}
