package com.lihegang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * AOP：指在程序运行期间动态的将某段代码切入到指定方法指定位置进行编程
 * 1.导入aop模块： spring-aspects
 * 2. 业务逻辑类 - MathCalculator
 * 3. 定义一个日志切面类 - LogAspects
 *      通知方法：
 *          前置通知(@Before)：logStart - div方法之前
 *          后置通知(@After)：logEnd - div方法之后运行,无论正常结束还是异常结束都调用
 *          返回通知(@AfterReturning)：logReturn - div方法正常返回之后运行
 *          异常通知(@AfterThrowing)：logException - div目标方法出现异常以后
 *          环绕通知(@Around)：around动态代理，手动推进目标方法运行  joinPoint.procced()
 *  4. 切面类什么时候运行
 *  5. 将切面类和业务逻辑类（目标方法）加入到容器中
 *  6. 告诉Spring哪个是切面类，@Aspect
 *  7. 给配置类加 @EnableAspectJAutoProxy 开启基于注解的aop
 *      Spring中很多的@EnableXXX 都是开启某项功能
 */
@EnableAspectJAutoProxy
@ComponentScan("com.lihegang.aop")
@Configuration
public class MainConfigOfAOP {
}
