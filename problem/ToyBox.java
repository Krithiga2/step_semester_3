
abstract class Toy {
    private static int counter = 1000;
    private final String toyId;
    private String name;

    public Toy(String name) {
        this.name = name;
        counter++;
        this.toyId = "TOY-" + counter;
    }

    public String getName() {
        return name;
    }

    public String getToyId() {
        return toyId;
    }

    public abstract String makeSound();
}

class ToyCar extends Toy {
    public ToyCar(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return getName() + ": Vroom vroom!";
    }
}

class ToyRobot extends Toy {
    public ToyRobot(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return getName() + ": Beep boop!";
    }
}

class ToyBox {
    public static void main(String[] args) {
        ToyCar c = new ToyCar("Speedster");
        System.out.println(c.makeSound());
        ToyRobot r = new ToyRobot("Bolt");
        System.out.println(r.makeSound());
        System.out.println(c.getToyId()); 
        System.out.println(r.getToyId()); 
    }
}
