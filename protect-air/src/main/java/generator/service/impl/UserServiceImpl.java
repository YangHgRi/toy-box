package generator.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import generator.domain.User;
import generator.mapper.UserMapper;
import generator.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author YangHgRi
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2022-07-29 16:08:37
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
}