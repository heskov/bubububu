import java.io.*;

class CalculationData implements Serializable {
    private double param1;
    private double param2;
    private double result;

    public CalculationData(double param1, double param2, double result) {
        this.param1 = param1;
        this.param2 = param2;
        this.result = result;
    }
    public double getParam1() {
        return param1;
    }

    public double getParam2() {
        return param2;
    }

    public double getResult() {
        return result;
    }
}

class Solver {
    public static double solve(double param1, double param2) {
        return param1 + param2;
    }
}

class Demo implements Serializable {
    private transient CalculationData data;

    public Demo(double param1, double param2) {
        double result = Solver.solve(param1, param2);
        this.data = new CalculationData(param1, param2, result);
    }

    // Метод для друкованого виведення результатів
    public void printResult() {
        if (data != null) {
            System.out.println("Param1: " + data.getParam1());
            System.out.println("Param2: " + data.getParam2());
            System.out.println("Result: " + data.getResult());
        } else {
            System.out.println("Calculation data is null.");
        }
    }


    public void saveState(String filename) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(this);
        out.close();
        fileOut.close();
    }

    public static Demo loadState(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        Demo demo = (Demo) in.readObject();
        in.close();
        fileIn.close();
        return demo;
    }
}


class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Demo demo = new Demo(3.5, 4.2);
        System.out.println("Before serialization:");
        demo.printResult();
        demo.saveState("demo.ser");
        Demo loadedDemo = Demo.loadState("demo.ser");
        System.out.println("\nAfter deserialization:");
        loadedDemo.printResult();
    }
}
