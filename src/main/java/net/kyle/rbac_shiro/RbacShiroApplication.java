package net.kyle.rbac_shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("net.xdclass.rbac_shiro.dao")
public class RbacShiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(RbacShiroApplication.class, args);
	}

}
