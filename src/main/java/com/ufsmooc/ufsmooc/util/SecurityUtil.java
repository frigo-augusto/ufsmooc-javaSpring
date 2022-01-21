package com.ufsmooc.ufsmooc.util;

import lombok.experimental.UtilityClass;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@UtilityClass
public class SecurityUtil {

    public BCryptPasswordEncoder encryptPassword(){
        return new BCryptPasswordEncoder();
    }
}
