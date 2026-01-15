package com.github.flimnk.book_service.repo;

import com.github.flimnk.book_service.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
