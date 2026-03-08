package com.kclm.owep.utils.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SnowFlakeIdTest {


    @Test
    public void testGenerateId() {
        //
        SnowFlakeId snowFlakeId = new SnowFlakeId(1, 1);
        //
        long result = 1L;
        //
        for(int i = 0;i<100;i++) {
            result = snowFlakeId.nextId();
            System.out.println("result = " + result+ " -> "+Long.toBinaryString(result));
        }
    }
}