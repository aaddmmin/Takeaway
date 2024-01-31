package Takeaway.com.Dto;

import lombok.Data;
import Takeaway.com.entity.Dish;
import Takeaway.com.entity.DishFlavor;

import java.util.ArrayList;
import java.util.List;

@Data
public class DishDto extends Dish {
    //封装口味flavors下name/value，flavors下id没有进行封装
    private List<DishFlavor> flavors = new ArrayList<>();

    private String categoryName;

    private Integer copies;
}
