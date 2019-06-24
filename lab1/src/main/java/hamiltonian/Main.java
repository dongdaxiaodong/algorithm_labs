package hamiltonian;

import Model.City;
import generate.Generate;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.print("input a number less 10:");
        Scanner scanner=new Scanner(System.in);
        String line=scanner.nextLine();
        Generate generate=new Generate(Integer.parseInt(line));
        City city=selectStartCity(generate);
        BruteForce.hamiltonian(generate,city);
    }

    public static City selectStartCity(Generate generate){
        return generate.getCitys().get((int)(Math.random()*generate.getCitys().size()));
    }
}
