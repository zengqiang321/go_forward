package com.jack.jdk8.stream;

import com.jack.jdk8.domain.Goods;
import com.jack.jdk8.domain.Sku;
import com.jack.jdk8.domain.SkuImage;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by manchong on 2019/6/5.
 */
public class T1 {


    public static void main(String[] args) {
        T1 t1 = new T1();
        List<Goods> goodsList = t1.getGoods();

//        System.out.println("onsaleGoodsCount ->"+t1.countOnsaleGoodsCount(goodsList));
//        System.out.println("totalGoodsNum ->"+t1.countOnsaleGoodsNum(goodsList));
//        System.out.println("totalGoodsPrice ->"+t1.countTotalGoodsPrice(goodsList));
//        t1.sortByGoodsNumDesc(goodsList);
//        t1.filterOnsaleList(goodsList);
//        t1.toMap(goodsList);
//        t1.stringToList();
//        t1.getGoodsTitles(goodsList);



//        BinaryOperator<Integer> operator = (x,y) -> x+y;
//        System.out.println(operator.apply(readme,2));
//
//        t1.getMaxSkuGoods(goodsList);
//
//        t1.multG(goodsList);


        Arrays.asList(1,2,3,4).stream().filter(x->x>2).forEach(System.out::println);
    }


    public void multG(List<Goods> goodsList){
        goodsList.add(getGoodsWithImg());
        boolean si=goodsList.stream().filter(goods -> goods.getGoodsId().equals(1000L) && goods.getSkuList()!=null)
                .flatMap(goods ->
                        goods.getSkuList().stream()
                                .filter(sku->sku.getSkuValue().equalsIgnoreCase("COLOR:RED")&&sku.getImageList()!=null)
                                .map(sku->sku.getImageList()))
                .flatMap(List::stream)
                .anyMatch(img->img.getImageId().equals(1));

        System.out.println(si);

    }


    public Goods mapJdk8() {

        Map<Long,Goods> goodsMap = new HashMap<>();
        Long key=1L;
        //JDK1.7以前写法
//        Goods goods = goodsMap.get(key);
//        if(goods == null) {
//            goods = new Goods();
//            goodsMap.put(key,goods);
//        }
//        return goods;

        //迭代Map
        goodsMap.forEach((ky,goods) -> {
            System.out.println(ky+"=="+goods.getGoodsNum());
            System.out.println(ky+"=="+goods.getGoodsId());
        });


        //JDK1.8写法
        return goodsMap.computeIfAbsent(key , k -> genGoods());

    }

    private Goods genGoods(){
        return new Goods();
    }

    /**
     * 数据分组
     * @param goodsList
     */
    public void groupBy(List<Goods> goodsList) {
        //按true|false分组
        Map<Boolean, List<Goods>> booleanListMap = goodsList.stream().collect(
                Collectors.partitioningBy(goods -> goods.getOnsale()));
        //按某种共性分组
        Map<Integer, List<Goods>> numMap = goodsList.stream().collect(
                Collectors.groupingBy(goods -> goods.getGoodsNum()));

        Map<Integer, List<String>> listMap = goodsList.stream().collect(
                Collectors.groupingBy(Goods::getGoodsNum,
                        Collectors.mapping(Goods::getTitle, Collectors.toList())));
    }

    /**
     * 将集合转换为指定的集合类型
     * @param goodsList
     */
    public void toTreeSetTest(List<Goods> goodsList) {
        TreeSet<Goods> collect = goodsList.stream().collect(Collectors.toCollection(TreeSet::new));
    }

    /**
     * 获取队列中最大。最小
     * @param goodsList
     */
    public void getMaxSkuGoods(List<Goods> goodsList) {

        Function<Goods,Long> function=goods -> goods.getGoodsId();
        Optional<Goods> collect = goodsList.stream().collect(Collectors.maxBy(Comparator.comparing(function)));
        if(collect.isPresent()){
            System.out.println(collect.get().getTitle()+"---");
        }


        Optional<Goods> collect1 = goodsList.stream().collect(Collectors.maxBy(Comparator.comparing(goods -> goods.getGoodsNum())));

        Optional<Goods> collect2 = goodsList.stream().collect(Collectors.minBy(Comparator.comparingInt(Goods::getGoodsNum)));

    }




    /**
     * 如果有一个函数可以将一种类型的值转换成另外一种类型，map 操作就可以 使用该函数，将一个流中的值转换成一个新的流
     */
    public List<String> getGoodsTitles(List<Goods> goodsList) {
        //中间过程-类型转换
        List<String> titles=goodsList.stream()
                .filter(goods -> goods.getOnsale())
                .map(goods -> goods.getTitle())
                .filter(string -> {
                    Integer num=Integer.parseInt(string.substring(string.length()-1,string.length()));
                    return num>3;
                })
                .collect(Collectors.toList());
        titles.stream().forEach(System.out::println);
        return titles;
    }

    public List<String> stringToList() {
        String str = "a,b,c,d,e,f,g";
        List<String> list =  Stream.of(str.split(",")).collect(Collectors.toList());
        list.stream().forEach(System.out::println);
        return list;
    }

    /**
     * 统计在架商品记录数
     * @param goodsList
     * @return
     */
    public Integer countOnsaleGoodsCount(List<Goods> goodsList) {
        return (int)goodsList.stream().filter(goods -> goods.getOnsale()).count();
    }

    /**
     * 场景1.: 统计商品对象下架的商品总数
     */

    public Long countOnsaleGoodsNum(List<Goods> goodsList) {

        IntSummaryStatistics summaryStatistics = goodsList.stream().collect(Collectors.summarizingInt(Goods::getGoodsNum));

        Integer count=goodsList.stream().mapToInt(goods -> goods.getGoodsNum()).reduce(0,(acc,goods) -> acc+goods);
        System.out.println(count+"===="+summaryStatistics.getSum());
//        Integer count2=goodsList.stream().reduce(0,(acc,goods) -> acc.getGoodsNum()+goods.getGoodsNum() );

        return summaryStatistics.getSum();
    }

    /**
     * 统计商品的总价格
     * @param goodsList
     * @return
     */
    public BigDecimal countTotalGoodsPrice(List<Goods> goodsList) {
        BigDecimal totalGoodsPrice = goodsList.stream().collect(Collectors.reducing(BigDecimal.ZERO, Goods::getPrice, BigDecimal::add));
        System.out.println(totalGoodsPrice);
        return totalGoodsPrice;
    }

    /**
     * 对列表排序
     * @param goodsList
     */
    public void sortByGoodsNumDesc(List<Goods> goodsList) {
        System.out.println("原始列表:");
        goodsList.stream().forEach(goods -> {System.out.println(goods.getTitle()+"==");});
        System.out.println("正序列表:");
        //正序
        goodsList.stream().sorted(Comparator.comparingInt(Goods::getGoodsNum)).forEach(goods -> {System.out.println(goods.getTitle()+"=="+goods.getGoodsNum());} );
        System.out.println("倒序列表:");
        //倒序
        goodsList.stream().sorted(Comparator.comparingInt(Goods::getGoodsNum).reversed()).forEach(goods -> {System.out.println(goods.getTitle()+"<=>"+goods.getGoodsNum());} );

        //倒序
        goodsList.stream().sorted(Comparator.reverseOrder()).forEach(goods -> {System.out.println(goods.getTitle()+"=="+goods.getGoodsNum());} );

        goodsList.stream().sorted((x1,x2) -> x1.getGoodsNum().compareTo(x2.getGoodsNum()));

    }


    /**
     * 过滤列表
     * @param goodsList
     */
    public void filterOnsaleList(List<Goods> goodsList) {
        System.out.println("过滤前列表:");
        goodsList.stream().forEach(goods -> {System.out.println(goods.getTitle()+"=="+goods.getOnsale());});

        System.out.println("过滤后列表:");
        goodsList.stream().filter(goods -> goods.getOnsale()).forEach(action -> System.out.println(action.getTitle()+"=="+action.getOnsale()) );
    }

    public Map<Long,Goods> toMap(List<Goods> goodsList) {
        //不允许空值，不允许Key重复.不然会抛异常
        Map<Long, Goods> goodsM = goodsList.stream().collect(Collectors.toMap(Goods::getGoodsId, Function.identity()));

        //Function.identity()获取List里面的泛型属性实体
        //JDK1.7前迭代方式
        for (Iterator<Map.Entry<Long,Goods>> it=goodsM.entrySet().iterator();it.hasNext();) {
            Map.Entry<Long, Goods> entry = it.next();
            System.out.println(entry.getKey()+"=="+entry.getValue().getTitle());
        }

        //新迭代方式
        goodsM.forEach((k,v)-> System.out.println(k+"=="+v.getTitle()) );

        return goodsM;
    }

    public void toMapSameKey() {
        //sameKey throw "Duplicate Key Error"解决
        List<String> list = Arrays.asList("readme:readme","2:readme","3:readme","readme:2");
        Map<String, String> map = list.stream().collect(Collectors.toMap(s -> s.split(":")[0],
                Function.identity(),(oldValue,newValue)-> newValue));
        for (Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey()+"--"+entry.getValue());
        }
    }


    public List<Goods> getGoods() {
        List<Goods> list = new ArrayList<Goods>();
        for (int i=0;i<10;i++) {
            Goods goods = new Goods();
            goods.setGoodsId((long)i);
            Double num=Math.random()*100;
            goods.setGoodsNum(num.intValue());
            goods.setOnsale(i%2==1);
            goods.setPrice(BigDecimal.valueOf(100D));
            goods.setTitle("title "+i);
            goods.setSkuList(getSkus(goods.getGoodsId()));
            list.add(goods);
        }
        return list;
    }

    public List<Sku> getSkus(Long goodsId) {
        List<Sku> skuList = new ArrayList<>();
        for (int i=0;i<2;i++) {
            Sku sku = new Sku();
            sku.setGoodsId(goodsId);
            sku.setSkuId((long)i);
            sku.setSkuValue(genSkuValue());
            skuList.add(sku);
        }
        return skuList;
    }

    public Goods getGoodsWithImg() {
        Goods goods = new Goods();
        goods.setGoodsId(1000L);

        Sku sku = new Sku();
        sku.setGoodsId(goods.getGoodsId());
        sku.setSkuValue("COLOR:RED");
        sku.setSkuId(100000000L);

        SkuImage skuImage = new SkuImage();
        skuImage.setImageId(1);
        skuImage.setPath("/path");
        List<SkuImage> skuImages = new ArrayList<>();
        skuImages.add(skuImage);
        sku.setImageList(skuImages);

        List<Sku> skus = new ArrayList<>();
        skus.add(sku);

        goods.setSkuList(skus);
        return goods;
    }

    final static String COLORS="red,black,grace,yellow,orange,white,purple";
    final static String SIZES="XL,L,X,M,XXL,XXXL,32,33,34,35,36,37,38,39";

    public String genSkuValue(){
        Double m= Math.random()*10;
        String[] colors=COLORS.split(",");
        String[] sizes=SIZES.split(",");
        int colorIndex= m.intValue()>=colors.length ? colors.length-1 : m.intValue();
        m= Math.random()*10;
        int sizeIndex=m.intValue()>=sizes.length ? sizes.length-1 : m.intValue();
        return colors[colorIndex]+":"+sizes[sizeIndex];
    }
}
