package patterns;

import java.util.Arrays;
import java.util.List;

/**
 * Пример использования интерфейса, полиморфизм, рефакторинг
 */
public class ClassesRefactored {

        public static void main(String[] args) {

            List<Speaker> list = Arrays.asList(new A(), new B(), new C());

            for (Speaker object : list) {
                object.say();
            }
        }

    }
    class A implements Speaker{

        @Override
        public void say() {
            System.out.println("gav");
        }
    }
    class B implements Speaker{

        @Override
        public void say() {
            System.out.println("pee");
        }
    }

    class C implements Speaker{

        @Override
        public void say() {
            System.out.println("bow");
        }
    }

    interface Speaker
    {
        void say();
    }


