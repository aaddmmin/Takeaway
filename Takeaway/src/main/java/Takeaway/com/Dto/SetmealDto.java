package Takeaway.com.Dto;

import lombok.Data;
import Takeaway.com.entity.Setmeal;
import Takeaway.com.entity.SetmealDish;

import java.util.List;

/**
 * 继承集合
 * setmealDishes继承Setmeal了和SetmealDish
 */
@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
