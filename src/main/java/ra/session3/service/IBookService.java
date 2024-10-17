package ra.session3.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ra.session3.model.dto.request.FormBookAdd;
import ra.session3.model.entity.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
//    List<Book> findAll();
    Optional<Book> findById(Long id);
    void save(FormBookAdd request);
    void remove(Long id);
    void update(Book request);
    Page<Book> findAll(Pageable pageable);
    Page<Book> findAllByNameContainingOrCategoryNameContaining(String Name, String categoryName, Pageable pageable);
}
