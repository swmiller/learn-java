package model;

import java.util.ArrayList;

public class Lab {
    private ArrayList<LabEquipment> labEquipments;

    public Lab() {
        labEquipments = new ArrayList<>();
    }

    public void addLabEquipment(LabEquipment equipment) {
        if (equipment != null) {
            labEquipments.add(equipment.clone());
        } else {
            throw new IllegalArgumentException("Lab equipment cannot be null");
        }
    }

    public void setLabEquipment(LabEquipment equipment, int index) {
        if (equipment == null) {
            throw new IllegalArgumentException("Lab equipment cannot be null");
        }
        if (index < 0 || index >= labEquipments.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        labEquipments.set(index, equipment.clone());
    }

    public LabEquipment getLabEquipment(int index) {
        if (index < 0 || index >= labEquipments.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        return labEquipments.get(index).clone();
    }
}
