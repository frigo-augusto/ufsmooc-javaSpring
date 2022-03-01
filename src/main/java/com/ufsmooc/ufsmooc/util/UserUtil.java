package com.ufsmooc.ufsmooc.util;

import lombok.experimental.UtilityClass;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.InvalidParameterException;

@UtilityClass
public class UserUtil {


    public boolean isCpfValid(String cpf){
        return true;
    }

    public String getCurrentUserEmail(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentEmail = authentication.getName();
            System.out.println(currentEmail);
            return currentEmail;
        }
        throw new InvalidParameterException();
    }

}
