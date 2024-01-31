package Takeaway.com.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import Takeaway.com.Dto.SetmealDto;
import Takeaway.com.common.R;
import Takeaway.com.entity.Category;
import Takeaway.com.entity.Setmeal;
import Takeaway.com.service.CategoryService;
import Takeaway.com.service.SetmealDishService;
import Takeaway.com.service.SetmealService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 套餐管理
 */
@RestController
@RequestMapping("/setmeal")
@Slf4j
public class SetmeaController {
    @Autowired
    private  SetmealDishService setmealDishService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private SetmealService setmealService;

    /**
     * 新增套餐
     * @param setmealDto
     * @return
     */
    @PostMapping
    public R<String> save(@RequestBody SetmealDto setmealDto){
        log.info("套餐信息{}",setmealDto);
        setmealService.saveWithDish(setmealDto);
        return R.success("新增套餐成功");
    }

    /**
     * 套餐管理分页查询
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page,int pageSize,String name){
        //分页构造器
        Page<Setmeal> pageinfo = new Page<>(page,pageSize);
        Page<SetmealDto> dtoPage = new Page<>();

        //条件构造器
        LambdaQueryWrapper<Setmeal> queryWrapper =new LambdaQueryWrapper<>();
        //模糊查询
        queryWrapper.like(name != null, Setmeal::getName,name);
        //排序条件,降序
        queryWrapper.orderByDesc(Setmeal::getUpdateTime);
        setmealService.page(pageinfo,queryWrapper);
        //拷贝对象
        BeanUtils.copyProperties(pageinfo,dtoPage,"records");
        //忽略records集合，需要自己创建一个records集合
        List<Setmeal> records = pageinfo.getRecords();
        //将records的值赋给list
        List<SetmealDto> list= records.stream().map((item)->{
            //构造元素，获取categoryName的值
            SetmealDto setmealDto = new SetmealDto();

            //将item的数据拷贝到setmealDto
            BeanUtils.copyProperties(item,setmealDto);

            //分类id
            Long categoryId = item.getCategoryId();

            //根据分类id获取分类名称
            Category category = categoryService.getById(categoryId);
            if(category !=null){
                //获取分类名称
                String categoryName = category.getName();
                setmealDto.setCategoryName(categoryName);
            }
            return setmealDto;
        }).collect(Collectors.toList());
        dtoPage.setRecords(list);
            return R.success(dtoPage);
    }
    @PostMapping("/status/{status}")
    public R<String> status(@PathVariable("status") Integer status,@RequestParam List<Long> ids){
        LambdaQueryWrapper<Setmeal> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.in(ids != null, Setmeal::getId,ids);
        List<Setmeal> list = setmealService.list(queryWrapper);
        for (Setmeal setmeal : list){
            if(setmeal !=null){
                setmeal.setStatus(status);
                setmealService.updateById(setmeal);
            }
        }
        return R.success("售卖状态修改成功");
    }
    /**
     * 套餐管理删除
     * @param ids
     * @return
     */
    @DeleteMapping
    public  R<String> delete(@RequestParam List<Long> ids){
        setmealService.removeWithDish(ids);
        LambdaQueryWrapper<Setmeal> queryWrapper =new LambdaQueryWrapper<>();
        queryWrapper.in(Setmeal::getId,ids);
        setmealService.remove(queryWrapper);
        return R.success("删除成功");
    }
}
