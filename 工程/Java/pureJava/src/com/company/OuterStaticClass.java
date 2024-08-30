package com.company;

public class OuterStaticClass {
    private static String staticOuterProperty = "staticOuterProperty";
    private String outerProperty = "outerProperty";

    private static class InnerStaticClass{
        private static String staticInnerProperty = "staticInnerProperty";
        private String innerProperty = "innerProperty";

        //内部静态类访问外部类的静态成员
        private void accessOuterStaticProperty(){
            System.out.println(staticOuterProperty);
        }
    }

    private void accessInnterProperty(){
        InnerStaticClass inner = new InnerStaticClass();
        System.out.println(InnerStaticClass.staticInnerProperty);
    }

    public static void main(String[] args) {
        OuterStaticClass.InnerStaticClass innerInstance = new OuterStaticClass.InnerStaticClass();
        innerInstance.accessOuterStaticProperty();

        OuterStaticClass outer = new OuterStaticClass();
        outer.accessInnterProperty();
    }
}
