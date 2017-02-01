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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RoomLookup {

    public static void main(String[] args) {
        Campus newC = new Campus();

        Scanner input = new Scanner(System.in);
        String sInput;
        System.out.println("Welcome to SBGetARoom, Stony Brook's premium room lookup system.");
        try {
            FileInputStream file = new FileInputStream("campus.obj");
            ObjectInputStream inStream = new ObjectInputStream(file);
            newC = (Campus) inStream.readObject();
            inStream.close();
            System.out.println("Saved file loaded...");
        } catch (IOException e) {
            System.out.println("No save file found. Creating an empty campus.");
        } catch (ClassNotFoundException ei) {
            System.out.println("Class not found.");
        }
        System.out.println("Main Menu:");
        System.out.println("\tA) Add a building");
        System.out.println("\tD) Delete a building");
        System.out.println("\tE) Edit a building");
        System.out.println("\tF) Find a room");
        System.out.println("\tS) Search for rooms");
        System.out.println("\tC) List all buildings on Campus");
        System.out.println("\tL) List building details");
        System.out.println("\tQ) Quit");
        System.out.print("Please select an option:");
        sInput = input.nextLine();

        while (true) {
            if (sInput.equalsIgnoreCase("A")) {
                System.out.print("Please enter a building name:");
                sInput = input.nextLine();
                try {
                    newC.addBuilding(sInput, new Building());
                    System.out.println("Building " + sInput + " added.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (sInput.equalsIgnoreCase("D")) {
                System.out.print("Please enter a building name:");
                sInput = input.nextLine();
                try {
                    newC.removeBuilding(sInput);
                    System.out.println("Building " + sInput + " deleted.");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } else if (sInput.equalsIgnoreCase("E")) {
                System.out.print("Please enter a building name:");
                String bn = input.nextLine();
                if (!newC.containsKey(bn)) {
                    System.out.println("Building not found.");
                } else {
                    System.out.println("Building " + bn + " selected:");
                    System.out.println("Options:");
                    System.out.println("\tA) Add room");
                    System.out.println("\tD) Delete room");
                    System.out.println("\tE) Edit room");
                    System.out.print("Please select an option:");
                    sInput = input.nextLine();
                    if (sInput.equalsIgnoreCase("A")) {
                        System.out.print("Please enter room number:");
                        int roomN = input.nextInt();
                        sInput = input.nextLine();
                        System.out.print("Please enter number of seats:");
                        int nSeat = input.nextInt();
                        sInput = input.nextLine();
                        System.out.print("Please enter AV Equipment (separated by commas):");
                        String equiment = input.nextLine();
                        System.out.print("Does it have a whiteboard?(Y/n):");
                        String wb = input.nextLine();
                        System.out.print("Does it have a chalkboard?(Y/n):");
                        String cb = input.nextLine();
                        Classroom newCr = new Classroom();
                        try {
                            newC.getBuilding(bn).addClassroom(roomN, newCr);

                            newCr.setNumSeats(nSeat);
                            newCr.setArrayList(equiment);
                            if (wb.equalsIgnoreCase("Y")) {
                                newCr.setHasWhiteboard(true);
                            } else {
                                newCr.setHasWhiteboard(false);
                            }
                            if (cb.equalsIgnoreCase("Y")) {
                                newCr.setHasChalkboard(true);
                            } else {
                                newCr.setHasChalkboard(false);
                            }
                            System.out.println("Room " + bn + " " + roomN + " Added.");
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (sInput.equalsIgnoreCase("D")) {
                        if (newC.getBuilding(bn).isEmpty()) {
                            System.out.println("No room in the building.");
                        } else {
                            System.out.print("Please enter room number:");
                            int roomN = input.nextInt();
                            sInput = input.nextLine();
                            try {
                                newC.getBuilding(bn).removeClassroom(roomN);
                                System.out.println("Room " + bn + " " + roomN + " Deleted.");
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    } else if (sInput.equalsIgnoreCase("E")) {
                        if (newC.getBuilding(bn).isEmpty()) {
                            System.out.println("No room in the building.");
                        } else {
                            System.out.print("Please enter room number:");
                            int roomN = input.nextInt();
                            sInput = input.nextLine();
                            try {
                                newC.getBuilding(bn).getClassroom(roomN);

                                System.out.println("Old number of seats:" + newC.getBuilding(bn).getClassroom(roomN).printNumSeats());
                                System.out.print("Please enter number of seats or press enter to skip:");
                                String newNumSeats = "";
                                newNumSeats = input.nextLine();
                                System.out.println("Old AV Equipment:" + newC.getBuilding(bn).getClassroom(roomN).printAVEquipmentList());
                                System.out.print("Please enter newAV Equipment (separated by commas) or press enter to skip:");
                                String newEquiment = "";
                                newEquiment = input.nextLine();
                                System.out.print("Does it have a whiteboard?(Y/n) or press enter to skip:");
                                String newWB = "";
                                newWB = input.nextLine();
                                System.out.print("Does it have a chalkboard?(Y/n) or press enter to skip:");
                                String newCB = "";
                                newCB = input.nextLine();
                                if (!newNumSeats.equals("")) {
                                    newC.getBuilding(bn).getClassroom(roomN).setNumSeats(Integer.parseInt(newNumSeats));
                                }
                                if (!newEquiment.equals("")) {
                                    newC.getBuilding(bn).getClassroom(roomN).setArrayList(newEquiment);
                                }
                                if (!newWB.equals("")) {
                                    if (newWB.equalsIgnoreCase("Y")) {
                                        newC.getBuilding(bn).getClassroom(roomN).setHasWhiteboard(true);
                                    } else {
                                        newC.getBuilding(bn).getClassroom(roomN).setHasWhiteboard(false);
                                    }
                                }
                                if (!newCB.equals("")) {
                                    if (newCB.equalsIgnoreCase("Y")) {
                                        newC.getBuilding(bn).getClassroom(roomN).setHasChalkboard(true);
                                    } else {
                                        newC.getBuilding(bn).getClassroom(roomN).setHasChalkboard(false);
                                    }
                                }
                                System.out.println("Javits " + roomN + " updated.");

                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }
            } else if (sInput.equalsIgnoreCase("F")) {
                System.out.print("Please enter a room name:");
                String roomName = input.nextLine();
                String[] tempRoomName = roomName.split(" ");
                if (tempRoomName.length != 2) {
                    System.out.println("The room name is invaild.");
                } else {
                    String bName = tempRoomName[0];
                    int rNum = Integer.parseInt(tempRoomName[1]);
                    Classroom cn = new Classroom();
                    try {
                        cn = newC.getBuilding(bName).getClassroom(rNum);

                        System.out.println("Room Details:");
                        System.out.print("\tSeats:" + cn.printNumSeats() + "\n");
                        System.out.print("\t" + cn.printHasWhiteboard() + "\n");
                        System.out.print("\t" + cn.printHasChalkboard() + "\n");
                        System.out.print("\t" + "AV Amenities:" + cn.printAVEquipmentList() + "\n");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else if (sInput.equalsIgnoreCase("S")) {
                System.out.println("Options:");
                System.out.println("\tB) Blackboard");
                System.out.println("\tW) Whiteboard");
                System.out.println("\tA) AV Equipment");
                System.out.print("Please select options:");
                sInput = input.nextLine();
                if (sInput.equalsIgnoreCase("B")) {
                    System.out.println("Rooms with blackboard:");
                    int isFirst = 0;
                    String outPut = "";
                    String[] temp = newC.keySet().toArray(new String[newC.size()]);
                    for (int i = 0; i < temp.length; i++) {
                        boolean isCont = false;
                        Integer[] iTemp = newC.getBuilding(temp[i]).keySet().toArray(new Integer[newC.getBuilding(temp[i]).size()]);
                        for (int j = 0; j < iTemp.length; j++) {
                            if (newC.getBuilding(temp[i]).getClassroom(iTemp[j]).getHasChalkboard()) {
                                isFirst++;
                                if (isFirst == 1 && j == iTemp.length - 1) {
                                    outPut += "\t" + temp[i] + ": " + iTemp[j];
                                } else if (isFirst == 1) {
                                    outPut += "\t" + temp[i] + ": " + iTemp[j] + ",";
                                } else if (j == iTemp.length - 1) {
                                    outPut += iTemp[j];
                                } else {
                                    outPut += iTemp[j] + ",";
                                }
                                isCont = true;
                            }
                        }
                        if (isCont) {
                            outPut += "\n";
                        }
                        isFirst = 0;
                    }
                    System.out.println(outPut);
                }
                if (sInput.equalsIgnoreCase("W")) {
                    System.out.println("Rooms with whiteboard:");
                    int isFirst = 0;
                    String outPut = "";
                    String[] temp = newC.keySet().toArray(new String[newC.size()]);
                    for (int i = 0; i < temp.length; i++) {
                        boolean isCont = false;
                        Integer[] iTemp = newC.getBuilding(temp[i]).keySet().toArray(new Integer[newC.getBuilding(temp[i]).size()]);
                        for (int j = 0; j < iTemp.length; j++) {
                            if (newC.getBuilding(temp[i]).getClassroom(iTemp[j]).getHasWhiteboard()) {
                                isFirst++;
                                if (isFirst == 1 && j == iTemp.length - 1) {
                                    outPut += "\t" + temp[i] + ": " + iTemp[j];
                                } else if (isFirst == 1) {
                                    outPut += "\t" + temp[i] + ": " + iTemp[j] + ",";
                                } else if (j == iTemp.length - 1) {
                                    outPut += iTemp[j];
                                } else {
                                    outPut += iTemp[j] + ",";
                                }
                                isCont = true;
                            }
                        }
                        if (isCont) {
                            outPut += "\n";
                        }
                        isFirst = 0;
                    }
                    System.out.println(outPut);
                }
                if (sInput.equalsIgnoreCase("A")) {
                    int isFirst = 0;
                    System.out.print("Please enter a keyword:");
                    String keyword = input.nextLine();
                    System.out.println("Rooms with AVEquipment:");
                    String outPut = "";
                    String[] temp = newC.keySet().toArray(new String[newC.size()]);
                    for (int i = 0; i < temp.length; i++) {
                        boolean isCont = false;
                        Integer[] iTemp = newC.getBuilding(temp[i]).keySet().toArray(new Integer[newC.getBuilding(temp[i]).size()]);
                        for (int j = 0; j < iTemp.length; j++) {
                            ArrayList<String> tempA = newC.getBuilding(temp[i]).getClassroom(iTemp[j]).getArrayList();
                            if (tempA.contains(keyword)) {
                                isFirst++;
                                if (isFirst == 1 && j == iTemp.length - 1) {
                                    outPut += "\t" + temp[i] + ": " + iTemp[j];
                                } else if (isFirst == 1) {
                                    outPut += "\t" + temp[i] + ": " + iTemp[j] + ",";
                                } else if (j == iTemp.length - 1) {
                                    outPut += iTemp[j];
                                } else {
                                    outPut += iTemp[j] + ",";
                                }
                                isCont = true;
                            }
                        }
                        if (isCont) {
                            outPut += "\n";
                        }
                        isFirst = 0;
                    }
                    System.out.println(outPut);
                }
            } else if (sInput.equalsIgnoreCase("C")) {
                String outPut = "";
                String[] temp = newC.keySet().toArray(new String[newC.size()]);
                for (int i = 0; i < temp.length; i++) {
                    Integer[] iTemp = newC.getBuilding(temp[i]).keySet().toArray(new Integer[newC.getBuilding(temp[i]).size()]);
                    outPut += "\t" + temp[i] + ": ";
                    for (int j = 0; j < iTemp.length; j++) {
                        if (j != iTemp.length - 1) {
                            outPut += iTemp[j] + ",";
                        } else {
                            outPut += iTemp[j];
                        }
                    }
                    outPut += "\n";
                }
                System.out.println(outPut);
            } else if (sInput.equalsIgnoreCase("L")) {
                int totalSeats = 0;
                String rooms = "", avEqui = "";
                int countTotal = 0, countWB = 0, countBB = 0;
                double pWB = 0.0, pBB = 0.0;
                System.out.print("Please enter a building name:");
                String bName = input.nextLine();
                Building bTemp = new Building();
                try {
                    bTemp = newC.getBuilding(bName);
                    Integer[] iTemp = bTemp.keySet().toArray(new Integer[bTemp.size()]);
                    for (int i = 0; i < iTemp.length; i++) {
                        if (i != iTemp.length - 1) {
                            rooms += iTemp[i] + ",";
                        } else {
                            rooms += iTemp[i];
                        }
                        totalSeats += bTemp.getClassroom(iTemp[i]).getNumSeats();
                        ArrayList<String> tempA = bTemp.getClassroom(iTemp[i]).getArrayList();
                        if (bTemp.getClassroom(iTemp[i]).getHasChalkboard()) {
                            countBB++;
                            countTotal++;
                        }
                        if (bTemp.getClassroom(iTemp[i]).getHasWhiteboard()) {
                            countWB++;
                            countTotal++;
                        }
                        for (int j = 0; j < tempA.size(); j++) {
                            if (i == iTemp.length - 1 && j == tempA.size() - 1) {
                                if (!avEqui.contains(tempA.get(j))) {
                                    avEqui += tempA.get(j);
                                }
                            } else if (!avEqui.contains(tempA.get(j))) {
                                avEqui += tempA.get(j) + ",";
                            }
                        }
                    }
                    if (countTotal == 0) {
                        pBB = 0;
                        pWB = 0;
                    } else {
                        pBB += (countBB / countTotal) * 100;
                        pWB += (countWB / countTotal) * 100;
                    }
                    System.out.println("Details:");
                    System.out.print("\tRooms: " + rooms + "\n");
                    System.out.print("\tTotal seats: " + totalSeats + "\n");
                    System.out.println("\t" + pWB + "% of rooms have whiteboards");
                    System.out.println("\t" + pBB + "% of rooms have blackboards");
                    System.out.print("\tAV Equipment present: " + avEqui + "\n");
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }

            } else if (sInput.equalsIgnoreCase("Q")) {
                System.out.println("\tS - Save");
                System.out.println("\tD - Don't Save");
                System.out.print("Select an option:");
                sInput = input.nextLine();
                if (sInput.equalsIgnoreCase("S")) {
                    System.out.println("Saving and closing ...");
                    try {
                        FileOutputStream file = new FileOutputStream("campus.obj");
                        ObjectOutputStream outStream;
                        try {
                            outStream = new ObjectOutputStream(file);
                            outStream.writeObject(newC);
                            outStream.close();
                            break;
                        } catch (IOException ex) {
                            Logger.getLogger(RoomLookup.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } catch (FileNotFoundException ei) {
                        System.out.println("File not Found.");
                    }
                } else if (sInput.equalsIgnoreCase("D")) {
                    System.out.println("Closing without saving ...");
                    break;
                }
            }
            System.out.print("Please select an option:");
            sInput = input.nextLine();
        }

    }
}
