package pt.ipp.isep.dei.esoft.project.ui.console.utils;

import pt.ipp.isep.dei.esoft.project.repository.Repositories;

import java.io.*;

public class SerializationUtil {

    // method to Serialize info (Repositories)
    public static void serializeInfo(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(Repositories.getInstance());
            System.out.println("Serialization successful!");
        } catch (IOException e) {
            System.out.println("Serialization failed!: "+e.getMessage());
        }
    }

    // method to DeSerialize info (get and redefine Repositories)
    @SuppressWarnings("unchecked")
    public static Repositories deserializeInfo(String filename) {
        Repositories instance = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            instance = (Repositories) ois.readObject();
            System.out.println("Deserialization successful!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization failed!: "+e.getMessage());
        }
        System.out.println(instance);
        return instance;
    }
}
