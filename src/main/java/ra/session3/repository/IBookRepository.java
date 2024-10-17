package ra.session3.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ra.session3.model.entity.Book;

public interface IBookRepository extends JpaRepository<Book,Long> {
    Page<Book> findAllByNameContainingOrCategoryNameContaining(String Name, String categoryName, Pageable pageable);
}
