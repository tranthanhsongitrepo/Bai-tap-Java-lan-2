package com.company;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MaterialList {
    ArrayList<Material> materials;

    public MaterialList() {
        this.materials = new ArrayList<>();
    }

    public void add(Material m){
        this.materials.add(m);
    }

    public void remove(int m){
        this.materials.remove(m);
    }

    public void replace(int n, Material m){
        this.materials.set(n, m);
    }

    public MaterialList getMaterialsWith(String feature, String... value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MaterialList res = new MaterialList();
        for (Material m : materials){
            Object val = m.getClass().getMethod("get" + feature).invoke(m);
            for (String v : value) {
                if (v.equals(val))
                    res.add(m);
            }
        }
        return res;
    }

    public MaterialList  getMaterialsWith(String feature, int from, int to) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        MaterialList res = new MaterialList();
        for (Material m : materials) {
            int value = (int) m.getClass().getMethod("get" + feature).invoke(m);
            if (value >= from && value <= to) {
                res.add(m);
            }
        }
            return res;
    }

    public int getIndexOf(String id){
        for (int i = 0; i < materials.size(); i ++)
            if (materials.get(i).getId().equals(id))
                return i;
        return -1;
    }
    public void sortByFeature(String feature) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException{
        materials.sort(new Comparator<Material>(){
            @Override
            public int compare(Material material1, Material material2) {
                try {
                    Method method = material1.getClass().getMethod("get" + feature);
                    return method.invoke(material1).toString().compareTo(method.invoke(material2).toString());
                }
                catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException ignored){}
                return -1;
            }
        });
    }

    public int[] getTotalPublishedNumberOf(String... type){
        int[] s = new int[type.length];
        Arrays.fill(s, 0);
        for (Material m : materials) {
            for (int i = 0; i < type.length; i ++) {
                if (m.getClass().getName().equals(type[i]))
                    s[i] += m.getNumberOfCopies();
            }
        }

        return s;
    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Material m : materials){
            res.append(m).append("\n");
        }
        return res.toString();
    }
}
