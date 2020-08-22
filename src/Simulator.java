package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import src.Aircraft.AircraftFactory;

public class Simulator {
	
	private static int cycles;
	private static BufferedReader reader;
	private static String cLine;
	
	private static WeatherTower tower;
	
	private static void initSimulation(File file) throws AvajException {
		try {
			reader = new BufferedReader(new FileReader(file));
			FileW.setFileName("simulation.txt");
			cycles = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException | IOException e) {
			throw new AvajException(e.getMessage());
		}
	}
	
	private static void loadAircrafts() throws AvajException {
		
		try {
			String arr[];
			tower = new WeatherTower();
			while ((cLine = reader.readLine()) != null) {
				arr = cLine.split("\\s+");
				AircraftFactory.newAircraft(arr[0], arr[1], Integer.parseInt(arr[2]),
					Integer.parseInt(arr[3]), Integer.parseInt(arr[4])).registerTower(tower);
			}
			reader.close();
		} catch (Exception e) {
			throw new AvajException(e.getMessage() + "\nPlease use the following format.\n25\nBaloon B1 2 3 20\nBaloon B2 1 8 66\nJetPlane J1 23 44 32\nHelicopter H1 654 33 20\nHelicopter H2 22 33 44\nHelicopter H3 98 68 99\nBaloon B3 102 22 34\nJetPlane J2 11 99 768\nHelicopter H4 223 23 54\n");
		}
	}
	
	public static void main(String[] args) {
		if (args.length < 1) { 
			System.out.println("No arguments were found");
			return;
		}
		
		try {
			if (args[0].equals("-f")) {
				if (args.length == 3) {
					FileW.setFileName(args[1]);
					initSimulation(new File(args[2]));
				}else {
					throw new AvajException("Invalid Arguments");
				}
			} else {
				initSimulation(new File(args[0]));
				FileW.setFileName("simulation.txt");
			}
			loadAircrafts();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		
		while (cycles-- > 0) {
			tower.ChangeWeather();
		}
	}
}