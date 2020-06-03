package com.jack.spring_code_src;

/**
 * 演示 UserService被实例化各阶段执行过程
 *
 * 1。UserService先被实例化。
 * 2。UserService的setUserName属性被装载
 * 3。MyBeanPostProcesseor的 postProcessBeforeInitialization 方法被执行
 * 4.  UserService的。init方法被执行
 * 5. MyBeanPostProcesseor的 postProcessAfterInitialization 方法被执行
 *
 * BeanPostProcessor 可以通过实现接口Order  来指定顺序，默认按加载顺序执行。 数值越大优先级越低
 *
 * 注意:
 *      1.BeanFactory和ApplicationContext两个容器对待bean的后置处理器稍微有些不同。
 *      ApplicationContext容器会自动检测Spring配置文件中那些bean所对应的Java类实现了BeanPostProcessor接口，
 *      并自动把它们注册为后置处理器。在创建bean过程中调用它们，所以部署一个后置处理器跟普通的bean没有什么太大区别。
 *
 *      2. BeanFactory容器注册bean后置处理器时必须通过代码显示的注册，
 *      在IoC容器继承体系中的ConfigurableBeanFactory接口中定义了注册方法
 * Created by manchong on 2020/4/12.
 */

public class UserService {

    private GoodService goodService;

    private String username;

    public UserService() {
        System.out.println("UserService Bean is instance");
    }

    public void init() {
        System.out.println("UserService init method invoked");
    }

    public void test(){
        System.out.println("test");
    }

    public void setGoodService(GoodService goodService) {
        this.goodService = goodService;
    }

    public void setUsername(String username) {
        this.username = username;
        System.out.println("UserService setUsername "+username);
    }

    public String getUsername() {
        return username;
    }
}
