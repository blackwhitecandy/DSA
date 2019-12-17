package com.toffee.dsa.Controller;

import com.toffee.dsa.Service.AnimalShout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: glz
 * @Description:
 * @Date: Create in 10:20 2019/12/11
 */
@Controller
public class AnimalController {
    @Autowired
    private AnimalShout animalShout;

    public void animalShout() {
        animalShout.shout();
    }
}
