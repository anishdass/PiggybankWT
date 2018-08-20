package PiggyBank;

import javax.swing.*;

public class PiggybankWT {
    static private int balance;
    static private int[] lt=new int[10];
    static int count;

    public static void main(String[] args) {
        boolean flag=true;
        String ch="Q";
        while(flag){
            ch=read("Welcome to Piggybank with transaction\n"
                    +"D-Deposit"+"\n"
                    +"W-Withdraw"+"\n"
                    +"S-Statement"+"\n"
                    +"Q-Quit"+"\n");
            switch(ch) {
                case "d":
                case "D":
                    deposit(readValue("Enter value to be deposited"));
                    break;
                case "w":
                case "W":
                    withdraw(readValue("Enter value to withdraw"));
                    break;
                case "s":
                case "S":
                    statement();
                    break;
                case "q":
                case "Q":
                    JOptionPane.showMessageDialog(null, "Thank you for using Piggybank");
                    flag = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Default value");
            }
        }
    }
    static String read(String i){
        String r=JOptionPane.showInputDialog(i);
        return (r==null)?"Q":r;
    }

    static int readValue(String i){
        String v1=JOptionPane.showInputDialog(i);
        int v=0;
        try{
            v=Integer.parseInt(v1);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Invalid input");
        }
        return v;
    }
    static void deposit(int i){
        balance+=i;
        saveTransaction(i);
    }
    static void withdraw(int i){
        if(balance>=i){
            balance-=i;
            saveTransaction(-i);
        }
        else{
            JOptionPane.showMessageDialog(null,"Invalid input");
        }
    }
    static void saveTransaction(int i){
        if(count==10){
            for(int j=0; j<lt.length; j++) {
                lt[i] = lt[i + 1];
            }
            lt[9]=i;
        }
        else{
            lt[count++]=i;
        }
    }

    static void statement(){
        String statement=null;
        for(int v: lt){
            statement+=v+",";
        }
        JOptionPane.showMessageDialog(null,"Balance "+balance+" Last 10 transaction "+statement);
    }
}