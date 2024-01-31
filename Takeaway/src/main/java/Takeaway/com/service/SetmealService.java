package Takeaway.com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import Takeaway.com.Dto.SetmealDto;
import Takeaway.com.entity.Setmeal;

import java.util.List;


public interface SetmealService extends IService<Setmeal> {
    /**
     * 新增套餐，同时保存套餐和菜品的关联关系
     * @param setmealDto
     */
    public void saveWithDish(SetmealDto setmealDto);
    public void removeWithDish(List<Long> ids);
}
