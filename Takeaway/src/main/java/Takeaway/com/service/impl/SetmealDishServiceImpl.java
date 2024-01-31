package Takeaway.com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import Takeaway.com.entity.SetmealDish;
import Takeaway.com.mapper.SetmealDishMapper;
import Takeaway.com.service.SetmealDishService;
@Service
@Slf4j
public class SetmealDishServiceImpl extends ServiceImpl<SetmealDishMapper, SetmealDish>implements SetmealDishService {
}
