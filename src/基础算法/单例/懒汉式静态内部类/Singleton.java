package 基础算法.单例.懒汉式静态内部类;

public class Singleton {

    private static class SingletonInstance {
        private static final Singleton singleton = new Singleton();
    }

    private Singleton() {
    }

    public static Singleton get() {
        return SingletonInstance.singleton;
    }
}
