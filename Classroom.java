/**
 * Xia Lin
 * 110732381
 * xia.lin@stonybrook.edu
 * Assignment 6
 * CSE214-01
 * Charles Chen
 * Shilpi Bhattacharyya
 */
package homework6;

import java.io.Serializable;
import java.util.ArrayList;

public class Classroom implements Serializable{
    private boolean hasWhiteboard;
    private boolean hasChalkboard;
    private int numSeats;
    private ArrayList<String> AVEquipmentList;
    /**
     * default constructor of Classroom
     */
    public Classroom(){
        hasWhiteboard=false;
        hasChalkboard=false;
        numSeats=0;
        AVEquipmentList = new ArrayList<String>();
    }
    /**
     * Get has White board
     * @return 
     * True if has White board,false otherwise
     */
    public boolean getHasWhiteboard(){
        return hasWhiteboard;
    }
    /**
     * Get has Black board
     * @return 
     * True if has Black board,false otherwise
     */
    public boolean getHasChalkboard(){
        return hasChalkboard;
    }
    /**
     * Get number of seats
     * @return 
     * the number of seats
     */
    public int getNumSeats(){
        return numSeats;
    }
    /**
     * Get the AV equipment
     * @return 
     * A ArrayList contain all AV equipment
     */
    public ArrayList<String> getArrayList(){
        return AVEquipmentList;
    }
    /**
     * Set has White board
     * @param wb 
     * the element to be set
     */
    public void setHasWhiteboard(boolean wb){
        hasWhiteboard=wb;
    }
    /**
     * Set has Black board
     * @param cb 
     * the element to be set
     */
    public void setHasChalkboard(boolean cb){
        hasChalkboard=cb;
    }
    /**
     * Set number of seats
     * @param ns 
     * the element to be set
     */
    public void setNumSeats(int ns){
        numSeats=ns;
    }
    /**
     * Set AV equipment ArrayList
     * @param s 
     * the element to be set
     */
    public void setArrayList(String s){
        String[] temp = s.split(",");
        for(int i=0; i<temp.length;i++){
            AVEquipmentList.add(temp[i]);
        }
    }
    /**
     * Print the number of seats
     * @return 
     * String of numSeats
     */
    public String printNumSeats(){
        return ""+numSeats;
    }
    /**
     * Print AV equipment
     * @return 
     * String of AVEquipmentList
     */
    public String printAVEquipmentList(){
        String temp="";
        for(int i=0; i<AVEquipmentList.size(); i++){
            if(i!=AVEquipmentList.size()-1){
                temp+=AVEquipmentList.get(i)+",";
            }else{
                temp+=AVEquipmentList.get(i);
            }
        }
        return temp;
    }
    /**
     * Print has white board
     * @return 
     * String of hasWhiteboard information
     */
    public String printHasWhiteboard(){
        if(hasWhiteboard)
            return "Has Whiteboard";
        else
            return "Doesn't has Whiteboard";
    }
    /**
     * Print has black board
     * @return 
     * String of hasChalkboard information
     */
    public String printHasChalkboard(){
        if(hasChalkboard)
            return "Has Chalkboard";
        else
            return "Doesn't has Chalkboard";
    }
    
}
