package com.jack.modifer_symbol.symbol;

/**
 * Created by manchong on 2020/3/26.
 */
public class SymbolClass {


    private String privateField;
    String defaultField;
    protected String protectedField;
    protected void protectedTest2() {}

    class DefaultSymbolClass{

    }

    private  class PrivateSymbolClass{

    }


    protected  class ProtectedSymbolClass {

    }

   public class T extends DefaultSymbolClass{

    }
}
