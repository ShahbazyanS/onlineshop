package online.shop.onlineshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.shop.onlineshop.model.Color;
import online.shop.onlineshop.model.Countrie;
import online.shop.onlineshop.model.Image;
import online.shop.onlineshop.model.Size;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private String name;
    private String description;
    private double price;
    private List<Image> images;
    private List<Color> colors;
    private List<Size> sizes;
    private List<Countrie> countries;
}
