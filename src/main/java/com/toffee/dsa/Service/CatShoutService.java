package com.toffee.dsa.Service;

import org.springframework.stereotype.Service;

/**
 * @Author: glz
 * @Description:
 * @Date: Create in 10:19 2019/12/11
 */
@Service
public class CatShoutService implements AnimalShout {
    @Override
    public String shout() {
        return "喵喵喵~~~";
    }
}
