package com.example.quartzdemo.jobs;

public interface JobResolver {
    /**
     * 解析工作内容
     * @param jobContent
     */
    public void excute(String jobContent);

    /**
     * 解析器识别号 resolverID
     */
}
