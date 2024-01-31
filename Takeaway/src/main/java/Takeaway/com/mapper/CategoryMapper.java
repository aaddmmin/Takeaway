package Takeaway.com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import Takeaway.com.entity.Category;

@Mapper
public interface CategoryMapper extends BaseMapper<Category> {
}
