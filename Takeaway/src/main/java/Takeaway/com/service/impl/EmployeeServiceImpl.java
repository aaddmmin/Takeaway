package Takeaway.com.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import Takeaway.com.entity.Employee;
import Takeaway.com.mapper.EmployeeMapper;
import Takeaway.com.service.EmployeeService;

@Service
public class EmployeeServiceImpl extends ServiceImpl
        <EmployeeMapper, Employee> implements EmployeeService {
}
