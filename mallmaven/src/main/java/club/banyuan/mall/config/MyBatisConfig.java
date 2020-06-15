package club.banyuan.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"club.banyuan.mall.common.mapper","club.banyuan.mall.dao"})
public class MyBatisConfig {
}
