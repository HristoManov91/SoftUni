package onlineShop.models.products.computers;

import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return this.peripherals;
    }

    @Override
    public void addComponent(Component component) {
        for (Component comp : components) {
            if (comp.getClass().equals(component.getClass())) {
                //"Component %s already exists in %s with Id %d."
                throw new IllegalArgumentException(String.format(EXISTING_COMPONENT, component.getClass().getSimpleName(),
                        this.getClass().getSimpleName(), this.getId()));
            }
        }
        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {
//        if (components.stream().noneMatch(c -> c.getClass().getSimpleName().equals(componentType)))
        int index = -1;
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i).getClass().getSimpleName().equals(componentType)) {
                index = i;
                break;
            }
        }
        if (components.isEmpty() || index == -1) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT, componentType,
                    this.getClass().getSimpleName(), this.getId()));
        } else {
            return components.remove(index);
        }
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if (peripherals.stream().anyMatch(p -> p.getClass() == peripheral.getClass())) {
            throw new IllegalArgumentException(String.format(EXISTING_PERIPHERAL,
                    peripheral.getClass().getSimpleName(), this.getClass().getSimpleName(), this.getId()));
        }

        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        if (peripherals.stream().noneMatch(p -> p.getClass().getSimpleName().equals(peripheralType))) {
            throw new IllegalArgumentException(String.format(NOT_EXISTING_PERIPHERAL, peripheralType,
                    this.getClass().getSimpleName(), this.getId()));
        }

        int index = -1;
        for (int i = 0; i < peripherals.size(); i++) {
            if (peripherals.get(i).getClass().getSimpleName().equals(peripheralType)) {
                index = i;
                break;
            }
        }

        return peripherals.remove(index);
    }

    //if the components collection is empty, it should return only the computer overall performance,
    // otherwise return the sum of the computer overall performance and the average overall performance from all components
    @Override
    public double getOverallPerformance() {
        double average = components.stream().mapToDouble(Component::getOverallPerformance).average().orElse(0);
        return super.getOverallPerformance() + average;
    }

    @Override
    public double getPrice() {
        double componentsPrice = components.stream().mapToDouble(Component::getPrice).sum();
        double peripheralsPrice = peripherals.stream().mapToDouble(Peripheral::getPrice).sum();

        return super.getPrice() + componentsPrice + peripheralsPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());

        sb.append(" ").append(String.format(COMPUTER_COMPONENTS_TO_STRING , this.components.size()))
                .append(System.lineSeparator());

        for (Component comp : components) {
            sb.append("  ").append(comp.toString()).append(System.lineSeparator());
        }

        sb.append(" ").append(String.format(COMPUTER_PERIPHERALS_TO_STRING , this.peripherals.size() ,
                peripherals.stream().mapToDouble(Peripheral::getOverallPerformance).average().getAsDouble()))
                .append(System.lineSeparator());

        for (Peripheral perip : peripherals) {
            sb.append("  ").append(perip.toString()).append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
