package Takeaway.com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Takeaway.com.common.CustomException;
import Takeaway.com.entity.Category;
import Takeaway.com.entity.Dish;
import Takeaway.com.entity.Setmeal;
import Takeaway.com.mapper.CategoryMapper;
import Takeaway.com.service.CategoryService;
import Takeaway.com.service.DishService;
import Takeaway.com.service.SetmealService;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
        @Autowired
        private DishService dishService;
        @Autowired
        private SetmealService setmealService;
    /**
     * 根据id删除分类，删除之前进行判断是否有关联
     * @param id
     */
    @Override
    public void remove(Long id) {
        LambdaQueryWrapper<Dish> dishlambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据id进行分类
        dishlambdaQueryWrapper.eq(Dish::getCategoryId,id);
        int dishcount = dishService.count(dishlambdaQueryWrapper);

        //查询当前分类是否有关联菜品，如果已关联，抛出异常
        if(dishcount > 0){
            //已关联菜品，抛出异常
            throw new CustomException("已关联菜品,不能删除");
        }

        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据id进行分类
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        int count2 = setmealService.count();

        //查询当前分类是否有关联套餐，如果已关联，抛出异常
        if (count2 < 0){
            //已关联套餐，抛出异常
            throw new CustomException("已关联套餐,不能删除");
        }
        //正常删除
        super.removeById(id);
    }
}
