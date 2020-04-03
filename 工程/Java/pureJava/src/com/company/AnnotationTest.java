package com.company;

public class AnnotationTest {
    /**
     * @deprecated
     *nothing just for a test
     */
    @Deprecated
    public void testMethod(){

    }

    @SuppressWarnings("deprecation")
    public void hehe(){
        testMethod();
    }

    public static void main(String[] args) {
        AnnotationTest annotationTest  = new AnnotationTest();

    }
}
