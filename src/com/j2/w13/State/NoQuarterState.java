package com.j2.w13.State;

public class NoQuarterState implements State{
  GumballMachine gumballMachine;
  public NoQuarterState(GumballMachine gumballMachine){
    this.gumballMachine=gumballMachine;
  }
  public void insertQuarter(){
    System.out.println("You inserted a quarter!");
    gumballMachine.setState(gumballMachine.getHasQuarterState());
  }
  public void ejectQuarter(){
    System.out.println("You haven't inserted a quarter.");
  }
  public void turnCrank(){
    System.out.println("You turned, but no quarter.");
  }
  public void dispense(){
    System.out.println("Pay please.");
  }
  public void insertwrongcoin(){
    System.out.println("You inserted a wrong quarter.");
  }
}
    