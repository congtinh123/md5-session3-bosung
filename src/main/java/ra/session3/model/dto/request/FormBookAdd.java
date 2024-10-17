package ra.session3.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FormBookAdd {
    private String name;
    private Double price;
    private Integer stock;
    private String categoryName;
}
