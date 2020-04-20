package com.jack.design.structural.decorator.decorator1.equip;


import com.jack.design.structural.decorator.decorator1.IEquip;

/**
 * Created by jingbin on 2016/11/1.
 * 鞋子
 * 攻击力: 5
 */

public class ShoeEquip implements IEquip {

    @Override
    public int caculateAttack() {
        return 5;
    }

    @Override
    public String description() {
        return "圣战靴子";
    }
}
