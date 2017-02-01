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
import java.util.HashMap;
import java.util.Iterator;

public class Building extends HashMap<Integer, Classroom> implements Serializable{
    /**
     * Add class room with roomNumber and classroom
     * @param roomNumber
     * the roomNumber to be add
     * @param classroom
     * the classroom to be add
     * @throws IllegalArgumentException 
     * if there is roomNumber exist or the roomNumber is invalid
     */
    public void addClassroom(int roomNumber, Classroom classroom) throws IllegalArgumentException {
        if (containsKey(roomNumber)) {
            throw new IllegalArgumentException("The class room is already exist.");
        }
        if (roomNumber < 0) {
            throw new IllegalArgumentException("The room number is invalid.");
        }
        put(roomNumber, classroom);
    }
    /**
     * Get class room with roomNumber
     * @param roomNumber
     * the element to be find
     * @return 
     * the Classroom to be set
     * @throws IllegalArgumentException 
     * if there is not roomNumber exist or the roomNumber is invalid
     */
    public Classroom getClassroom(int roomNumber) throws IllegalArgumentException{
        if (!containsKey(roomNumber)) {
            throw new IllegalArgumentException("The class room is not exist.");
        }
        if (roomNumber < 0) {
            throw new IllegalArgumentException("The room number is invalid.");
        }
        return get(roomNumber);
    }
    /**
     * Remove class room with roomNumber
     * @param roomNumber
     * the room to be remove
     * @throws IllegalArgumentException 
     * if there is not roomNumber exist or the roomNumber is invalid
     */
    public void removeClassroom(int roomNumber) throws IllegalArgumentException{
        if (!containsKey(roomNumber)) {
            throw new IllegalArgumentException("The class room is not exist.");
        }
        if (roomNumber < 0) {
            throw new IllegalArgumentException("The room number is invalid.");
        }
        remove(roomNumber);
    }
}
