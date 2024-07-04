package org.huy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.time.Instant;

public class TestCase1 {

    @BeforeAll
    public static void beforeAll() {
        System.out.println("TestCase1.class.getName() = " + TestCase1.class.getName());
    }

    @Order(9001)
    @Tag("Test_Case1")
    @Test()
    public void Test1() {
        System.out.println("=====================Test1===================");
        System.out.println(Instant.now());
        //throw new RuntimeException(this.getClass().getName());
    }

    @Order(9000)
    @Tag("Test_Case2")
    @Test()
    public void Test2() {
        System.out.println("=====================Test2===================");
        System.out.println(Instant.now());
        //throw new RuntimeException(this.getClass().getName());
    }
}
