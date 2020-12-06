package ru.xorsiphus;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.xorsiphus.configuration.MechanismConfig;

public class TestSpring {
    public static void main(String[] args){
        SpringApplication.run(TestSpring.class, args);

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MechanismConfig.class);
        MechanismConfig config = context.getBean(MechanismConfig.class);

        MechanismUser user1 = config.user1();
        MechanismUser user2 = config.user2();
        MechanismUser user3 = context.getBean("user3", MechanismUser.class);
        MechanismUser userByFabric = context.getBean("UserByFabric", MechanismUser.class);
        MechanismUser defaultUser = context.getBean("UserComponent", MechanismUser.class);
        MechanismUser userProt1 = context.getBean("userProt", MechanismUser.class);
        MechanismUser userProt2 = context.getBean("userProt", MechanismUser.class);
        MechanismUser userProt3 = context.getBean("userProt", MechanismUser.class);

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
        System.out.println(userByFabric);
        System.out.println(defaultUser);
        System.out.println(userProt1);
        System.out.println(userProt2);
        System.out.println(userProt3);

        System.out.println("[LOG]: Total defined beans count: " +
                context.getBeanDefinitionCount());
        for (String beanName : context.getBeanDefinitionNames())
        {
            System.out.println("[LOG]: " + beanName);
        }

        context.close();
    }
}
