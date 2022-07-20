package yanghgri.protectair.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import yanghgri.protectair.entity.Role;
import yanghgri.protectair.entity.User;
import yanghgri.protectair.mapper.AuthMapper;

import java.util.Set;

@Service
@Slf4j
public class UserDetailsServiceImpl implements UserDetailsService {
    public static void main(String[] args) {
        log.info(new BCryptPasswordEncoder().encode("S36871414"));
    }

    private final AuthMapper authMapper;

    @Autowired
    public UserDetailsServiceImpl(AuthMapper authMapper) {
        this.authMapper = authMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = authMapper.selectOneByName(username);
        Set<Role> roleSet = authMapper.selectRoleSetByUserId(user.getId());
        user.setRoleSet(roleSet);
        return user;
    }
}