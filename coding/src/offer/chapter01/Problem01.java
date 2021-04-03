package offer.chapter01;

import sun.security.jca.GetInstance;

/**
 * 实现单例模式
 */
public class Problem01 {
    /**
     * 单例模式，懒汉式，线程安全
     */
    static  class Solution1{
        private final static Solution1 INSTANCE = new Solution1();
        private Solution1(){}
        public static Solution1 getInstance() {
            return INSTANCE;
        }
    }
    /**
     * 单例模式，饿汉式，线程不安全
     */
    static class Solution2{
        private static Solution2 instance = null;

        private Solution2(){}
        public static Solution2 getInstance(){
            if(instance == null){
                instance = new Solution2();
            }
            return instance;
        }
    }
    /**
     * 单例模式，饿汉式，线程安全，多线程环境下效率不高
     */
    static class Solution3{
        private static Solution3 instance = null;
        private Solution3(){}
        public static synchronized Solution3 getInstance(){
            if (instance == null){
                instance = new Solution3();
            }
            return instance;
        }
    }

    /**
     * 单例模式，饿汉式，变种，线程安全
     */
    public static class Solution4 {
        private static Solution4 instance = null;

        static {
            instance = new Solution4();
        }

        private Solution4() {}

        public static Solution4 getInstance() {
            return instance;
        }
    }

    /**
     * 单例模式，懒汉式，使用静态内部类，线程安全
     */
    public static class Solution5 {
        private final static class SingletonHolder {
            private static final Solution5 INSTANCE = new Solution5();
        }

        private Solution5() {}

        public static Solution5 getInstance() {
            return SingletonHolder.INSTANCE;
        }
    }

    /**
     * 静态内部类，使用枚举方式，线程安全
     */
    public enum Solution6 {
        INSTANCE;
    }

    /*
     * 静态内部类，使用双重校验锁，线程安全
     */
    public static class Solution7 {
        private volatile static Solution7 instance = null;

        private Solution7() {}

        public static Solution7 getInstance() {
            if (instance == null) {
                synchronized (Solution7.class) {
                    if (instance == null) {
                        instance = new Solution7();
                    }
                }
            }

            return instance;
        }
    }
}
