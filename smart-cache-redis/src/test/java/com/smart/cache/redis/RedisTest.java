package com.smart.cache.redis;

import com.smart.cache.ISmartCache;
import com.smart.cache.ISmartCacheManager;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Collection;
import java.util.Set;

public class RedisTest {


    @Test
    public void test() {
        ISmartCacheManager cacheManager = new RedisManager();
        ISmartCache<String, Object> cache = cacheManager.getCache("cache_name");
        System.out.println(cache.get("lu"));
        System.out.println(cache.put("lu","heihei"));
        System.out.println(cache.get("lu"));


    }

    @Test
    public void test2() {
        ISmartCacheManager cacheManager = new RedisManager();
        ISmartCache<Object, Object> cache = cacheManager.getCache("cache_name");


        System.out.println(cache.put(123,123));
        System.out.println(cache.get(123));

    }

    @Test
    public void testRemove(){
        ISmartCacheManager cacheManager = new RedisManager();
        ISmartCache<Object, Object> cache = cacheManager.getCache("cache_name");
        System.out.println(cache.get(123));
        System.out.println(cache.remove(123));
        System.out.println(cache.get(123));
    }

    @Test
    public void testClear(){
        ISmartCacheManager cacheManager = new RedisManager();
        ISmartCache<Object, Object> cache = cacheManager.getCache("cache_name");
        System.out.println(cache.get(123));
        cache.clear();
        System.out.println(cache.get(123));
        System.out.println(cache.get("lu"));
    }

    @Test
    public void testSize(){
        ISmartCacheManager cacheManager = new RedisManager();
        ISmartCache<Object, Object> cache = cacheManager.getCache("cache_name");
        System.out.println(cache.size());
    }

    @Test
    public void testKeys(){
        ISmartCacheManager cacheManager = new RedisManager();
        ISmartCache<Object, Object> cache = cacheManager.getCache("cache_name");
        Set<Object> keys =cache.keys();
        for(Object obj:keys){
            System.out.println(obj.toString());
        }
    }

    @Test
    public void testValues(){
        ISmartCacheManager cacheManager = new RedisManager();
        ISmartCache<Object, Object> cache = cacheManager.getCache("cache_name");
        Collection<Object> list =cache.values();
        for(Object obj:list){
            System.out.println(obj.toString());
        }
    }



//    @Test
//    public void listTest() {
//        List<String> list = new ArrayList<String>();
//        list.add("A");
//        list.add("B");
//        list.add("C");
//    }
}
