package mmm;
import java.util.ArrayList;
import java.util.List;

public class GridComposite implements GridComponent {
	private List<GridComponent> components = new ArrayList<>();

    public void addComponent(GridComponent component) {
        components.add(component);
    }

    public void display() {
        for (GridComponent component : components) {
            component.display();
        }
    }

}
