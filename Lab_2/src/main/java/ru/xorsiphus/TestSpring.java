package ru.xorsiphus;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    public static void main(String[] args){
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");


        MechanismUser user1 = context.getBean("user1", MechanismUser.class);
        MechanismUser user2 = context.getBean("user2", MechanismUser.class);
        MechanismUser user3 = context.getBean("user3", MechanismUser.class);

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);

        System.out.println("Total defined beans count: " +
                context.getBeanDefinitionCount());
        for (String beanName : context.getBeanDefinitionNames())
        {
            System.out.println(beanName);
        }

        context.close();
    }
}
