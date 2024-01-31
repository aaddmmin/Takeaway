package Takeaway.com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import Takeaway.com.entity.Dish;

@Mapper
public interface DishMapper extends BaseMapper<Dish> {
}
