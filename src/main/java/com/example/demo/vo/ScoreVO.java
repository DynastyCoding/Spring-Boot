package com.example.demo.vo;

public class ScoreVO {
    public final Integer value;
    public ScoreVO(Integer value){
        if(value < 0 || value > 100)
            throw new IllegalArgumentException("score need between 0 to 100.");
        this.value = value;
    }
    public Integer getValue(){return value;}
    public String getLetterGrade(){
        if(value>=90){
            return "A";
        }else if(value>=80){
            return "B";
        }else if(value>=70){
            return "C";
        }else{
            return "F";
        }
    }
}
