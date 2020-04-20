package com.jack.design.structural.composite.t2;

import com.jack.design.structural.composite.t2.Department;
import com.jack.design.structural.composite.t2.Employee;

/**
 * Created by manchong on 2020/4/9.
 */
public class T2 {

    public static void main(String[] args) {
        Department jolly = new Department("jolly");

        Department hr = new Department("hr");

        Department ceoOffice =new  Department("ceo office");

        Department technology = new Department("technology");

        Department hr_admin = new Department("行政部门");
        Department hr_zp = new Department("招聘部门");

        Department technology_front = new Department("前端部门");
        Department technology_ios = new Department("ios部门");
        Department technology_server = new Department("服务端部门");


        Employee ceo = new Employee("ceo","老李");

        Employee hrLeader = new Employee("HrLeader","老夏");

        Employee hr_engineering = new Employee("招聘专员","小孙");
        Employee hr_engineering2 = new Employee("招聘专员","小汪");

        Employee hr_admin_e = new Employee("行政部前台","小丽");
        Employee hr_admin_e2 = new Employee("行政部专员","小六");

        Employee ceo_Office = new Employee("ceo秘书","小爱");


        Employee cto = new Employee("cto","周王");
        Employee front_leader = new Employee("front leader","爱生");
        Employee ios_leader = new Employee("ios leader","大山");
        Employee server_leader = new Employee("server leader","圆圆");
        Employee front_e1 = new Employee("front pepole 1","t1");
        Employee front_e2 = new Employee("front pepole 2","t2");
        Employee ios_e1 = new Employee("ios pepole 1","ios 111");
        Employee server_e1 = new Employee("server pepole 1","server 111");

        jolly.add(ceo);
        jolly.add(hr);
        jolly.add(technology);
        jolly.add(ceoOffice);

        hr.add(hrLeader);
        hr.add(hr_admin);
        hr.add(hr_zp);

        hr_admin.add(hr_admin_e);
        hr_admin.add(hr_admin_e2);


        hr_zp.add(hr_engineering);
        hr_zp.add(hr_engineering2);

        ceoOffice.add(ceo_Office);

        technology.add(cto);
        technology.add(technology_front);
        technology.add(technology_ios);
        technology.add(technology_server);

        technology_front.add(front_leader);
        technology_front.add(front_e1);
        technology_front.add(front_e2);

        technology_ios.add(ios_leader);
        technology_ios.add(ios_e1);

        technology_server.add(server_leader);
        technology_server.add(server_e1);

        jolly.sameleOperation();
    }

}
