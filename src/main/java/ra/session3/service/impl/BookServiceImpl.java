package ra.session3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ra.session3.model.dto.request.FormBookAdd;
import ra.session3.model.entity.Book;
import ra.session3.model.mapper.BookMapper;
import ra.session3.repository.IBookRepository;
import ra.session3.service.IBookService;

import java.util.List;
import java.util.Optional;
@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    IBookRepository bookRepository;
//    @Override
//    public List<Book> findAll() {
//        return bookRepository.findAll();
//    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public void save(FormBookAdd request) {
        Book book = BookMapper.mapRequestToEntity(request);
        bookRepository.save(book);
    }

    @Override
    public void update(Book request) {
        bookRepository.save(request);
    }

    @Override
    public void remove(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Page<Book> findAllByNameContainingOrCategoryNameContaining(String Name, String categoryName, Pageable pageable) {
      return   bookRepository.findAllByNameContainingOrCategoryNameContaining(Name, categoryName, pageable);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
}
