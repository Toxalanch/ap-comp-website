package com.toxalanch.apCompWebsite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AppUtilTester {

    @Test
    void findClass() {
        assertEquals("Hello", AppUtil.findClass("public class Hello {"));
        assertEquals("Hello", AppUtil.findClass("public class Hello{"));
    }
    
}
