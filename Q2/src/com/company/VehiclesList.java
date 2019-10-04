package com.company;

import java.util.ArrayList;
import java.util.Comparator;

public class VehiclesList {
    private ArrayList<Vehicles> vehicles;

    VehiclesList(){
        vehicles = new ArrayList<>();
    }
    public void add(Vehicles v){
        vehicles.add(v);
    }

    public void printVehicles(){
        for (Vehicles v : vehicles){
            System.out.print("Loại xe: ");
            switch (v.getClass().getName()) {
                case "Truck":
                    System.out.println("Xe tải");
                    break;
                case "Motorbike":
                    System.out.println("Xe máy");
                    break;
                case "Car1":
                    System.out.println("Xe ô tô");
                    break;
            }
            System.out.println(v);
        }

        System.out.println(vehicles.size());
    }

    public VehiclesList searchVehicles(String feature, String value){
        VehiclesList list = new VehiclesList();

        for (Vehicles v : vehicles){
            Object f = v.getFeature(feature);
            if (f instanceof Float)
                f = ((Integer)((Float) f).intValue());
            f = f.toString();
            if (f.equals(value))
                list.add(v);
        }

        return list;
    }

    public VehiclesList searchVehicles(String feature, String s, String e){
        VehiclesList list = new VehiclesList();
        for (Vehicles v : vehicles){
            String vFeatures = v.getFeature(feature).toString();
            if (vFeatures.compareTo(s) >= 0 &&
                    vFeatures.compareTo(e) <= 0)
                list.add(v);

        }

        return list;
    }

    public VehiclesList searchVehiclesByFeatures(String feature, ArrayList<String> features){
        VehiclesList list = new VehiclesList();

        for (Vehicles v : vehicles){
            for (String f : features)
                if (v.getFeature(feature).equals(f)) {
                    list.add(v);
                    break;
                }
        }

        return list;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Vehicles v : vehicles)
           res.append(v + "\n");

        return res.toString();
    }

    public void sort(String feature){
        vehicles.sort(Comparator.comparing(vehicles -> vehicles.getFeature(feature).toString()));
    }

    public double averagePrice(){
        double s = 0;

        for (Vehicles v : vehicles){
            s += (float) v.getFeature("price") ;
        }

        return s / (double) vehicles.size();
    }
}
