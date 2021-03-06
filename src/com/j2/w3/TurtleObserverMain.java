package com.j2.w3;

import ch.aplu.turtle.*;
import java.util.Observer;
import java.util.Observable;
import java.util.ArrayList;
import java.awt.geom.Point2D.Double;
import java.awt.Color;
import ch.aplu.turtle.*;

public class TurtleObserverMain {
  public static void main(String[] args) {
    BabyTurtle baby=new BabyTurtle();
    MomTurtle mom=new MomTurtle();
    MomTurtle dad=new MomTurtle();
    MomTurtle teacher=new MomTurtle();
    baby.addObserver(mom);
    baby.addObserver(dad);
    baby.addObserver(teacher);
    mom.setColor(Color.red);
    dad.setColor(Color.green);
    teacher.setColor(Color.yellow);
    mom.label("mom Turtle");
    dad.label("dad Turtle");
    teacher.label("teacher Turtle");
    mom.moveTo(100,100);
    baby.move(100,-100);
    baby.setChanged();
    baby.notifyObservers();
  }
}                     

class MomTurtle extends Turtle implements Observer {
  Double babyCurpos;
  
  public void update(Observable o, Object arg) {
    System.out.println("update() called,count is "+((Integer)arg).intValue());
    babyCurpos=((BabyTurtle)o).myCurpos;
    System.out.println("current pos"+babyCurpos);
    moveTo(babyCurpos);
  }
}

class BabyTurtle extends Observable {
  Turtle baby;
  Double myCurpos;
  ArrayList<Observer> obs;
  public BabyTurtle() {
    baby=new Turtle();
    myCurpos=baby.getPos();
    obs=new ArrayList<Observer>();
  }
  public void addObserver (Observer o){
    obs.add(o);
  }
  protected void setChanged(){
    myCurpos=baby.getPos();
  }
  public void notifyObservers(){
    for(Observer o:obs)
      o.update(this, 1);
  }
  public void move(int x, int y){
    baby.moveTo(x,y);
  }
}

  