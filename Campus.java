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

public class Campus extends HashMap<String, Building> implements Serializable{
    /**
     * Add building with buildingName and building
     * @param buildingName
     * the element to be set 
     * @param building
     * the element to be set
     * @throws IllegalArgumentException 
     * if there is roomNumber exist or the roomNumber is invalid
     */
    public void addBuilding(String buildingName, Building building) throws IllegalArgumentException{
        if (containsKey(buildingName)) {
            throw new IllegalArgumentException("The building name is already exist.");
        }
        if (buildingName == null) {
            throw new IllegalArgumentException("The building name is invaild.");
        }
        put(buildingName, building);
    }
    /**
     * Get building with buildingName
     * @param buildingName
     * the element to be find
     * @return
     * the Building
     * @throws IllegalArgumentException 
     * if there is not roomNumber exist or the roomNumber is invalid
     */
    public Building getBuilding(String buildingName) throws IllegalArgumentException{
        if (!containsKey(buildingName)) {
            throw new IllegalArgumentException("The building name is not exist.");
        }
        if (buildingName == null) {
            throw new IllegalArgumentException("The building name is invaild.");
        }
        return get(buildingName);
    }
    /**
     * Remove building with buildingName
     * @param buildingName
     * the element to be remove
     * @throws IllegalArgumentException 
     * if there is not roomNumber exist or the roomNumber is invalid
     */
    public void removeBuilding(String buildingName) throws IllegalArgumentException{
        if (!containsKey(buildingName)) {
            throw new IllegalArgumentException("The building name is not exist.");
        }
        if (buildingName == null) {
            throw new IllegalArgumentException("The building name is invaild.");
        }
        remove(buildingName);
    }
}
