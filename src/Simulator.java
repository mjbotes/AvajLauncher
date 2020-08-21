package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import src.Aircraft.AircraftFactory;

public class Simulator {
	
	public static class SimulationException extends Exception {
		private static final long serialVersionUID = -1928219242566779452L;

		public SimulationException() { super(); }
		public SimulationException(String exception) { super (exception); }
		public SimulationException(Throwable exception) { super (exception); }
	}
	
	private static int simulationCycles;
	private static BufferedReader br;
	private static String currentLine;
	
	private static WeatherTower tower;
	
	private static void initSimulation(File file) throws SimulationException {
		try {
			br = new BufferedReader(new FileReader(file));
			// System.out.println(br.readLine());
			FileW.setFileName("simulation.txt");
			simulationCycles = Integer.parseInt(br.readLine());
		} catch (NumberFormatException | IOException e) {
			throw new SimulationException(e);
		}
	}
	
	private static void loadAircrafts() throws SimulationException, NumberFormatException, AvajException {
		try {
			String info[];
			tower = new WeatherTower();
			while ((currentLine = br.readLine()) != null) {
				info = currentLine.split("\\s+");
				AircraftFactory.newAircraft(info[0], info[1], Integer.parseInt(info[2]),
					Integer.parseInt(info[3]), Integer.parseInt(info[4])).registerTower(tower);
			}
			br.close();
		} catch (IOException | AvajException | NumberFormatException e) {
			throw new SimulationException(e);
		}
	}
	
	public static void main(String[] args) {
		if (args.length < 1) { 
			System.out.println("No arguments were found");
			return;
		}
		
		try {
			initSimulation(new File(args[0]));
			loadAircrafts();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return;
		}
		
		while (simulationCycles-- > 0) {
			tower.ChangeWeather();
		}
	}
}