package Data;

import Model.SinhVien;

import java.io.*;
import java.util.List;

public class FileHandler {
    private static final String FILE_PATH = "sinhvien.dat";

    public static void saveToFile(List<SinhVien> sinhVienList) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(sinhVienList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<SinhVien> readFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<SinhVien>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
