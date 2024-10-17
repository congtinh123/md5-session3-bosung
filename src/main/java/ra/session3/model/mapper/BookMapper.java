package ra.session3.model.mapper;

import ra.session3.model.dto.request.FormBookAdd;
import ra.session3.model.entity.Book;

public class BookMapper {
    public static Book mapRequestToEntity(FormBookAdd request){
        return Book.builder()
                .name(request.getName())
                .price(request.getPrice())
                .stock(request.getStock())
                .categoryName(request.getCategoryName())
                .status(true)
                .build();
    }
}
