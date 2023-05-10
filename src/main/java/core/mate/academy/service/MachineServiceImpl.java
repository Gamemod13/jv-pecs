package core.mate.academy.service;

import core.mate.academy.model.Machine;
import java.util.ArrayList;
import java.util.List;

public class MachineServiceImpl implements MachineService<Machine> {
    private static final BulldozerProducer BULLDOZER_PRODUCER = new BulldozerProducer();
    private static final ExcavatorProducer EXCAVATOR_PRODUCER = new ExcavatorProducer();
    private static final TruckProducer TRUCK_PRODUCER = new TruckProducer();

    @Override
    public List<Machine> getAll(Class<? extends Machine> type) {
        switch (type.getSimpleName()) {
            case "Bulldozer": {
                return new ArrayList<>(BULLDOZER_PRODUCER.get());
            }
            case "Excavator": {
                return new ArrayList<>(EXCAVATOR_PRODUCER.get());
            }
            case "Truck": {
                return new ArrayList<>(TRUCK_PRODUCER.get());
            }
            default:
                return Collections.emptyList();
        }
    }

    @Override
    public void fill(List<? super Machine> machines, Machine value) {
        for (int i = 0; i < machines.size(); i++) {
            machines.set(i, value);
        }
    }

    @Override
    public void startWorking(List<? extends Machine> machines) {
        for (Machine machine : machines) {
            machine.doWork();
        }
    }
}
