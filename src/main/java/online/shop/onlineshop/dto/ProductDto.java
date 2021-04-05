package online.shop.onlineshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import online.shop.onlineshop.model.Color;
import online.shop.onlineshop.model.Countrie;
import online.shop.onlineshop.model.Image;
import online.shop.onlineshop.model.Size;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Description is required")
    private String description;
    @NotBlank(message = "Price is required")
    private double price;
    @NotNull
    private List<Image> images;
    @NotNull
    private List<Color> colors;
    @NotNull
    private List<Size> sizes;
    @NotNull
    private List<Countrie> countries;
}
