package com.cc.provider.service.impl;

import com.cc.provider.service.RedisService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.connection.ReturnType;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: cheng.chen
 * Date: 2019/9/18 20:02
 * Description:
 */
@Service
@Log4j2
public class RedisServiceImpl implements RedisService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    private static final Long RELEASE_SUCCESS = 1L;
    private static final String RELEASE_LOCK_SCRIPT = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";


    @Override
    public void set(String key, Object value){
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public Object get(String key){
        return redisTemplate.opsForValue().get(key);
    }

    @Override
    public void set(String key, Object value, long time, TimeUnit timeUnit){
        redisTemplate.opsForValue().set(key, value, time, timeUnit);
    }

    @Override
    public Boolean expire(String key, long time, TimeUnit timeUnit){
        return redisTemplate.expire(key, time, timeUnit);
    }

    @Override
    public Boolean delete(String key){
        return redisTemplate.delete(key);
    }

    @Override
    public long increment(String key){
        return redisTemplate.opsForValue().increment(key);
    }

    /**
     *
     * @param key
     * @param value
     * @param seconds
     * @return
     */
    @Override
    public Boolean tryLock(final String key, final String value, final long seconds) {
        return (Boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                Boolean result = redisConnection.set(key.getBytes(Charset.forName("UTF-8")), value.getBytes(Charset.forName("UTF-8")),
                        Expiration.from(seconds, TimeUnit.MILLISECONDS), RedisStringCommands.SetOption.SET_IF_ABSENT);
                if (result!=null && result) {
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
        });
    }

    /**
     * 与 tryLock 相对应，用作释放锁
     *
     * @param key
     * @param value
     * @return
     */
    @Override
    public Boolean releaseLock(final String key, final String value) {
        return (Boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                byte[][] keysAndArgs = new byte[2][];
                keysAndArgs[0] = key.getBytes(Charset.forName("UTF-8"));
                keysAndArgs[1] = value.getBytes(Charset.forName("UTF-8"));
                Long result = (Long)redisConnection.scriptingCommands().eval(RELEASE_LOCK_SCRIPT.getBytes(Charset.forName("UTF-8")), ReturnType.INTEGER, 1, keysAndArgs);
                if (RELEASE_SUCCESS.equals(result)) {
                    return Boolean.TRUE;
                }
                return Boolean.FALSE;
            }
        });
    }
}
