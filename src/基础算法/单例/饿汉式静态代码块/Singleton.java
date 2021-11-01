package 基础算法.单例.饿汉式静态代码块;

public class Singleton {
    private static Singleton singleton;

    static {
        singleton = new Singleton();
    }

    private Singleton() {
    }

    public static Singleton get() {
        return singleton;
    }
}
