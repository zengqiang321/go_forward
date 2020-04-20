    package com.jack.serialize;

    import com.alibaba.fastjson.JSON;
    import com.esotericsoftware.kryo.Kryo;
    import com.esotericsoftware.kryo.io.Input;
    import com.esotericsoftware.kryo.io.Output;
    import com.google.gson.Gson;

    import java.io.ByteArrayInputStream;
    import java.io.ByteArrayOutputStream;
    import java.io.ObjectInputStream;
    import java.io.ObjectOutputStream;

    /**
     * Created by manchong on 2019/8/5.
     */
    public class SerialzationUtil {



        public static Order javaSerial(Order orgOrder) {
            try {
                ByteArrayOutputStream baout = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(baout);
                out.writeObject(orgOrder);
                out.flush();
                byte[] aorder = baout.toByteArray();
                out.close();

                System.out.println("java serival:len:"+aorder.length+"\n"+new String(aorder)+"\n\n");

                ByteArrayInputStream bain = new ByteArrayInputStream(aorder);
                ObjectInputStream in = new ObjectInputStream(bain);

                Order order = (Order)in.readObject();
                in.close();
                return order;
            } catch (Exception e) {
                e.getMessage();
            }
            return null;
        }

        public static Order fastjsonSerial(Order orgOrder) {
            String jsonOrder = JSON.toJSONString(orgOrder);
            System.out.println("fastjson:len"+jsonOrder.length()+"\n"+jsonOrder+"\n\n");
            return JSON.parseObject(jsonOrder,Order.class);
        }
        final static Gson gson = new Gson();
        public static Order gsonSerial(Order orgOrder) {

            String gsonOrder = gson.toJson(orgOrder);
            System.out.println("gson:len:"+gsonOrder.length()+"\n"+gsonOrder+"\n\n");
            return gson.fromJson(gsonOrder,Order.class);
        }
       final static Kryo kryo = new Kryo();
        public static Order kryoSerial(Order orgOrder) {

            ByteArrayOutputStream baout = new ByteArrayOutputStream();
            Output output = new Output(baout);
            kryo.writeObject(output,orgOrder);
            output.flush();
            byte[] aorder = baout.toByteArray();
            output.close();
            System.out.println("kryo serival:len:"+aorder.length+"\n"+new String(aorder)+"\n\n");
            ByteArrayInputStream bain = new ByteArrayInputStream(aorder);
            Input input = new Input(bain);
            Order order=kryo.readObject(input,Order.class);
            input.close();
            return  order;
        }

        public static Order deepClone(Order orgOrder) {
            return orgOrder.clone();
        }

    }
