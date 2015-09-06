package interfaces.base;

/**
 * This is the interface that the subject has to implement.
 * Created by Sripadmanaban on 9/6/2015.
 */
public interface Subject {

    /**
     * This is the function that is used to add the observer to be update list.
     *
     * @param observer A class that has implemented Observer interface.
     */
    void registerObserver(Observer observer);

    /**
     * This is the function that is used to remove an observer from the update list.
     *
     * @param observer A class that has implemented Observer interface.
     */
    void removeObserver(Observer observer);

    /**
     * This is the function that is used to notify all the observers.
     */
    void notifyObserver();
}
