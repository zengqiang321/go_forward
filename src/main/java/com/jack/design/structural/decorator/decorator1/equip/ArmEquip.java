package com.jack.design.structural.decorator.decorator1.equip;


import com.jack.design.structural.decorator.decorator1.IEquip;

/**
 * Created by jingbin on 2016/11/1.
 * 武器
 * 攻击力 20
 */

public class ArmEquip implements IEquip {

    @Override
    public int caculateAttack() {
        return 20;
    }

    @Override
    public String description() {
        return "屠龙宝刀";
    }
}
