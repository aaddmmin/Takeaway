package Takeaway.com.service;

import com.baomidou.mybatisplus.extension.service.IService;
import Takeaway.com.entity.Category;

public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}
