package com.jack.design.structural.decorator.decorator1;

import com.jack.design.structural.decorator.decorator1.equip.RingEquip;
import com.jack.design.structural.decorator.decorator1.equip.ShoeEquip;
import com.jack.design.structural.decorator.decorator1.gem.BlueGemDecotator;
import com.jack.design.structural.decorator.decorator1.gem.RedGemDecotator;
import com.jack.design.structural.decorator.decorator1.gem.YellowGemDecotator;

import static javafx.scene.input.KeyCode.R;

/**
 * 装饰者模式:
 * 装饰者模式：若要扩展功能，装饰者提供了比集成更有弹性的替代方案，动态地将责任附加到对象上。
 * 先简单描述下装饰者模式发挥作用的地方，当我们设计好了一个类，我们需要给这个类添加一些辅助的功能，
 * 并且不希望改变这个类的代码，这时候就是装饰者模式大展雄威的时候了。
 * 这里还体现了一个原则：类应该对扩展开放，对修改关闭。
 * eg:
 * 1、武器（攻击力20） 、戒指（攻击力5）、护腕（攻击力5）、鞋子（攻击力5）
 * 2、蓝宝石（攻击力5/颗）、黄宝石（攻击力10/颗）、红宝石（攻击力15/颗）
 * 3、每个装备可以随意镶嵌3颗
 */

public class DecoratorActivity  {



    public static void main(String[] args) {
        DecoratorActivity decoratorActivity = new DecoratorActivity();
        decoratorActivity.onClick(2);
    }


    public void onClick(int type) {
        switch (type) {
            case 1:// 外观模式
                break;

            case 2:
                System.out.println("---一个镶嵌2颗红宝石,1颗蓝宝石的靴子: ");

                IEquip iEquip = new RedGemDecotator(new RedGemDecotator(new BlueGemDecotator(new ShoeEquip())));
                System.out.println("---攻击力:" + iEquip.caculateAttack());
                System.out.println("---描述语:" + iEquip.description());
                break;

            case 3:
                System.out.println("---一个镶嵌1颗红宝石,1颗蓝宝石,1颗黄宝石的戒指: ");
                RedGemDecotator redGemDecotator = new RedGemDecotator(new BlueGemDecotator(new YellowGemDecotator(new RingEquip())));
                System.out.println("---攻击力:" + redGemDecotator.caculateAttack());
                System.out.println("---描述语:" + redGemDecotator.description());
                break;
            default:
                break;
        }
    }
}
