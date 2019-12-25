package com.leo.study.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

/**
 * @author chao.li@quvideo.com
 * @date 2019/12/24 10:30
 */
public class PhaserTest {

    public static void main(String[] args) {
        MyPhaser myPhaser = new MyPhaser(5);
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(myPhaser, "游客1"));
        personList.add(new Person(myPhaser, "游客2"));
        personList.add(new Person(myPhaser, "游客3"));
        personList.add(new Person(myPhaser, "驴友1"));
        personList.add(new Person(myPhaser, "驴友2"));
        for (Person person : personList) {
            new Thread(person).start();
        }
    }

    public static class MyPhaser extends Phaser {

        public MyPhaser(int parties) {
            super(parties);
        }

        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println(String.format("%s个人上车，发车", registeredParties));
                    return false;
                case 1:
                    System.out.println(String.format("%s个人下车了", registeredParties));
                    return false;
                case 2:
                    System.out.println(String.format("%s个人返程", registeredParties));
                    return false;
                case 3:
                    System.out.println(String.format("%s个人到家了", registeredParties));
                    return true;
                default:
                    return true;
            }
        }
    }

    public static class Person implements Runnable {
        Phaser phaser;

        String name;

        public Person(Phaser phaser, String name) {
            this.phaser = phaser;
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(String.format("%s 上车", name));
            phaser.arriveAndAwaitAdvance();
            System.out.println(String.format("%s 下车", name));
            phaser.arriveAndAwaitAdvance();
            if (name.startsWith("驴友")) {
                System.out.println(String.format("%s 留下观光", name));
                phaser.arriveAndDeregister();
            } else {
                System.out.println(String.format("%s 返程", name));
                phaser.arriveAndAwaitAdvance();
                System.out.println(String.format("%s 到家", name));
                phaser.arriveAndAwaitAdvance();
            }
        }
    }
}
