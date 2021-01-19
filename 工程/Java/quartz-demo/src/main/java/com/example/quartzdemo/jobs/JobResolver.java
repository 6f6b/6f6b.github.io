package com.example.quartzdemo.jobs;

import java.math.BigInteger;

public interface JobResolver {
    /**
     * 解析ID
     * @param id
     */
    public void excute(Long id);
}
