package com.abuhijleh.openId.Services;

import com.abuhijleh.openId.Models.MyUserDetails;
import com.abuhijleh.openId.Models.User;
import com.abuhijleh.openId.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    public MyUserDetailsService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUserName(s);

        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + s));

        return user.map(MyUserDetails::new).get();
    }
}
