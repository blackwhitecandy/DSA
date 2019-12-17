package com.toffee.dsa.Service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @Author: glz
 * @Description:
 * @Date: Create in 10:18 2019/12/11
 */
@Service
@Primary
public class DogShoutService implements AnimalShout {
    @Override
    public String shout() {
        return "汪汪汪~~~";
    }
}
