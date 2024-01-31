package Takeaway.com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import Takeaway.com.Dto.DishDto;
import Takeaway.com.entity.Dish;

import java.util.List;

public interface DishService extends IService<Dish> {
    //新增菜品，dish，dishflavor，同时插入菜品口味数据
    public void saveWithFlavor(DishDto dishDto);

    //根据id查询菜品信息和对应的口味信息
    public DishDto getByIdWithFlavor(Long id);

    //更新菜品信息，同时更新对应的口味信息
    public void updateWithFlavor(DishDto dishDto);
    //根据传过来的id批量或者是单个的删除菜品
    void deleteByIds(List<Long> ids);
}
