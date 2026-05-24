package config;

import dao.HibernateUserDao;
import dao.UserDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import service.UserService;
import service.UserServiceImpl;

@Configuration
@ComponentScan({"model", "dao", "service"})
public class AppConfig {

    @Bean
    public UserDao userDao() {
        return new HibernateUserDao();
    }

    @Bean
    public UserService userService(UserDao userDao) {
        return new UserServiceImpl(userDao);
    }

}
