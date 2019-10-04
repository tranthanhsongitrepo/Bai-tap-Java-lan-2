package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;

public class ProfessorList {
    ArrayList<Professor> professors;

    public ProfessorList(){
        professors = new ArrayList<>();
    }

    public void add(Professor professor){
        professors.add(professor);
    }

    public void printProfessors(String mode){
        int c = 0;
        for (Professor professor : professors){
            if (professor.getClass().getName().equals(mode) || mode.equals(Professor.class.getName())) {
                System.out.println(professor);
                c ++;
            }
        }
        System.out.println("Tổng số giảng viên: " + c);
    }

    public int indexOf(String id){
        for (int i = 0; i < professors.size(); i ++){
            if (professors.get(i).getId().equals(id))
                return i;
        }
        return -1;
    }

    public void remove(String id){
        professors.remove(this.indexOf(id));
    }

    public void replace(String id, Professor professor){
        professors.set(this.indexOf(id), professor);
    }

    public ProfessorList getProfessorsWith(String feature, String value) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ProfessorList professorList = new ProfessorList();
        for (Professor professor : professors){
            if (professor.getFeature(feature).equals(value))
                professorList.add(professor);
        }

        return professorList;
    }

    public void sortBy(String feature){
        this.professors.sort(new Comparator<Professor>() {
            @Override
            public int compare(Professor professor1, Professor professor2) {
                try {
                    return professor1.getFeature(feature).toString().compareTo(professor2.getFeature(feature).toString());
                } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
                    e.printStackTrace();
                }
                return -1;
            }
        });
    }

    public float totalSalary(){
        float s = 0f;
        for (Professor professor : professors)
            s += professor.getSalary();
        return s;
    }

    public float getAvarage(){
        return this.totalSalary() / ((float) professors.size());
    }

    public Professor higestSalary(){
        Professor max = professors.get(0);

        for (Professor professor : professors){
            if (professor.getSalary() > max.getSalary())
                max = professor;;
        }

        return max;
    }
}
