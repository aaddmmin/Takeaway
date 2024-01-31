package Takeaway.com.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import Takeaway.com.entity.Employee;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee>{
}
