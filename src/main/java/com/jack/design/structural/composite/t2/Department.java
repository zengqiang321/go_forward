package com.jack.design.structural.composite.t2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by manchong on 2020/4/9.
 */
public class Department implements JollyModel {

    private String name;


    List<JollyModel> componentList = new ArrayList<>();


    public Department(String name) {
        this.name = name;
    }

    @Override
    public void sameleOperation() {
        System.out.println("部门名称："+name);

        Iterator<JollyModel> it = iterator();
            while (it.hasNext()) {
                JollyModel model=it.next();
                model.sameleOperation();
            }
    }


    public void add(JollyModel jollyModel){
        this.componentList.add(jollyModel);
    }

    public void remove(){

    }

    public Iterator<JollyModel> iterator(){
        return componentList.iterator();
    }



}
