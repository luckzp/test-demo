package com.example.demo.DesignPatterns;

/**
 * @author ZhangP
 * @since 2019-07-15 9:31
 * 单例模式虽然看起来简单，但是设计的Java基础知识非常多，如static修饰符、synchronized修饰符、volatile修饰符、enum等。
 * 这里的每一个知识点都可以变成面试官下手的考点，而单例只是作为一个引子，考到最后看你到底掌握了多少。
 * 看你的广度和深度到底是怎么样的。
 */
public class Singleton {
    private volatile static Singleton singleton;

    /**
     * 私有化构造函数，禁止在类的外部实例化。
     */
    private Singleton(){}

    public static Singleton getSingleton(){
        // 第一步判空是为不必要的同步。
        // 第二步是在singleton等于null的情况下才创建实例。
        if (singleton == null){
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

}
