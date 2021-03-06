package com.binzeefox.foxframe.tools.dev;

import androidx.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 列表、数组工具类
 * <p>
 * TODO 随时完善
 *
 * @author binze 2019/11/29 14:41
 */
public class CollectionUtil {

    /**
     * 列表深拷贝
     *
     * @param <E> 需要实现{@link java.io.Serializable}接口
     * @author binze 2019/11/29 14:20
     */
    public static <E> List<E> deepCopySerializable(List<E> src) {
        try {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(src);
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            @SuppressWarnings("unchecked") List<E> dest = (List<E>) in.readObject();
            return dest;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * 利用Gson的深拷贝
     *
     * @author binze 2019/11/29 14:51
     */
    public static <T> List<T> deepCopyByJson(List<T> raw) {
        Gson gson = new Gson();
        String json = gson.toJson(raw);
        return gson.fromJson(json, new TypeToken<List<T>>() {
        }.getType());
    }

    /**
     * 利用Gson的深拷贝
     *
     * @author binze 2019/11/29 14:51
     */
    public static <T> Collection<T> deepCopyByJson(Collection<T> raw) {
        Gson gson = new Gson();
        String json = gson.toJson(raw);
        return gson.fromJson(json, new TypeToken<List<T>>() {
        }.getType());
    }

    /**
     * 数组转列表
     *
     * @author 狐彻 2020/09/10 13:45
     */
    public static <T> List<T> arrayToList(@NonNull T[] array){
        return new ArrayList<>(Arrays.asList(array));
    }

    /**
     * 列表转数组
     *
     * @author 狐彻 2020/09/10 13:47
     */
    public static <T> void listToArray(@NonNull List<T> list, @NonNull T[] ts){
        for (int i = 0; i < list.size(); i++){
            if (i >= ts.length) break;
            ts[i] = list.get(i);
        }
    }
}
