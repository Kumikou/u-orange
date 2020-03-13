package cn.uorange.userservice;

import cn.uorange.redis.template.RedisRepository;
import cn.uorange.userservice.service.ITestService;
import cn.uorange.userservice.service.impl.TestServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author ZJared
 * @Date 2019/12/5
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceApplicationTests {

    @Autowired
    RedisRepository redisRepository;

    @Autowired
    ITestService testService;

    @Test
    public void contextLoads() {

    }


    @Test
    public void setRedisTest() {
        redisRepository.set("测试1", "sadas");
    }

    @Test
    public void getRedisTest() {
        System.out.println(redisRepository.get("测试1"));
    }

    @Test
    public void addTest() {
        testService.save(new cn.uorange.userservice.repository.entity.Test().setContent("增加測試"));
    }


    @Test
    public void updateTest() {
        testService.updateById(new cn.uorange.userservice.repository.entity.Test().setContent("更新测试").setId((long) 1));
    }

    @Test
    public void getTest() {
        log.info("getTest:{}", testService.getById(1));
    }

    @Test
    public void delTest() {
//        testService.removeById(id);
    }

}
