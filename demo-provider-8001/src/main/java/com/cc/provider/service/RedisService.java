package com.cc.provider.service;

import java.util.concurrent.TimeUnit;

public interface RedisService {

    void set(String key, Object value);

    Object get(String key);

    void set(String key, Object value, long time, TimeUnit timeUnit);

    Boolean expire(String key, long time, TimeUnit timeUnit);

    Boolean delete(String key);

    long increment(String key);

    /**
     * 单节点Redis加锁
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    Boolean tryLock(final String key, final String value, final long seconds);

    /**
     * 单节点Redis解锁
     * @param key
     * @param value
     * @return
     */
    Boolean releaseLock(final String key, final String value);
}
