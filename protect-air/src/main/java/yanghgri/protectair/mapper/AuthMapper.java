package yanghgri.protectair.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import yanghgri.protectair.entity.Role;
import yanghgri.protectair.entity.User;

import java.util.Set;

@Mapper
@Repository
public interface AuthMapper {
    User selectOneByName(@Param("name") String username);

    Set<Role> selectRoleSetByUserId(@Param("userId") Long userId);
}