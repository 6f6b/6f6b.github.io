package JMeter;

import bsh.*;

public class BSH extends This{
    public String[] args;
    public Primitive evalOnly;
    public ConsoleInterface console;
    public This system;
    public This shared;
    public String cwd;
    public Primitive interactive;
    public Object $_;
    public Throwable $_e;

    public BSH(NameSpace namespace, Interpreter declaringInterpreter) {
        super(namespace, declaringInterpreter);
    }
}
