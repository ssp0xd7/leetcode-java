package 基础算法.单例.懒汉式双重检查;

public class Singleton {
    private static Singleton singleton;
    private Singleton() {
    }

    public static Singleton get() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }

        return singleton;
    }
}
