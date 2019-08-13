package com.lihegang.aop;

import org.springframework.stereotype.Component;

/**
 * Created by dong-er on 2019-08-12.
 */
@Component
public class MathCalculator {

    public int div(int i, int j) {
        return i / j;
    }
}
