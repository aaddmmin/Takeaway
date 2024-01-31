package Takeaway.com.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import Takeaway.com.Dto.SetmealDto;
import Takeaway.com.common.CustomException;
import Takeaway.com.entity.Setmeal;
import Takeaway.com.entity.SetmealDish;
import Takeaway.com.mapper.SetmealMapper;
import Takeaway.com.service.SetmealDishService;
import Takeaway.com.service.SetmealService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
   @Autowired
   private SetmealDishService setmealDishService;
    /**
     * 新增套餐，同时保存套餐和菜品的关联关系
     * @param setmealDto
     */
    @Transactional//数据一致性
    public void saveWithDish(SetmealDto setmealDto) {
    //保存菜品基本信息，操作setmeal，执行insert操作
        this.save(setmealDto);
        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
        setmealDishes.stream().map((item->{
            item.setSetmealId(setmealDto.getId());
            return item;
        })).collect(Collectors.toList());
        //保存菜品和套餐的关联信息，操作setmeal_dish，执行insert操作
        //saveBatch批量保存
        setmealDishService.saveBatch(setmealDishes);
    }

    /**
     * 删除套餐，同时删除菜品和套餐关联的数据
     * @param ids
     */
    public void removeWithDish(List<Long> ids) {
        //查询套餐状态，确定是否删除
        LambdaQueryWrapper<Setmeal> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.in(ids !=null, Setmeal::getId,ids);
        queryWrapper.eq(Setmeal::getStatus,1);
        List<Setmeal> list = this.list(queryWrapper);
        for(Setmeal setmeal:list){
            Integer status = setmeal.getStatus();
            if(status == 0){
                this.removeById(setmeal.getId());
            }
            throw new CustomException("删除套餐中有正在售卖菜品,无法全部删除");

        }
        /**
        int count =this.count(queryWrapper);
       if(count > 0){
            throw  new CustomException("删除套餐中有正在售卖菜品,无法全部删除");
        }
        this.removeByIds(ids);
       LambdaQueryWrapper<SetmealDish> lambdaQueryWrapper = new LambdaQueryWrapper<>();
       lambdaQueryWrapper.in(SetmealDish::getSetmealId,ids);
       setmealDishService.remove(lambdaQueryWrapper);
    }**/
}
}
