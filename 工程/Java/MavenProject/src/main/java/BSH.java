import bsh.*;

public class BSH extends This{
    String[] args;
    Primitive evalOnly;
    ConsoleInterface console;
    This system;
    This shared;
    String cwd;
    Primitive interactive;
    Object $_;
    Throwable $_e;

    public BSH(NameSpace namespace, Interpreter declaringInterpreter) {
        super(namespace, declaringInterpreter);
    }
}
