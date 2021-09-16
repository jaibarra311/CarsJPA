import java.util.List;
import java.util.Scanner;

import controller.CarHelper;
import model.Car;


/**
 * @author jaiba - jaibarra
 * CIS175 - Fall 2021
 * Sep 15, 2021
 */
public class StartProgram {
	static Scanner in = new Scanner(System.in);
	static CarHelper ch = new CarHelper();

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		runMenu();



	}

	public static void runMenu() {

		boolean goAgain = true;
		System.out.println("--- Welcome to our car list ---");
		while (goAgain) {
			System.out.println("*  Select an item:");
			System.out.println("*  1 -- Add a car");
			System.out.println("*  2 -- Edit a car");
			System.out.println("*  3 -- Delete a car");
			System.out.println("*  4 -- List all cars");
			System.out.println("*  5 -- Exit the awesome program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addNewCar();
			} else if (selection == 2) {
				editACar();
			} else if (selection == 3) {
				deleteACar();
			} else if (selection == 4) {
				viewTheListOfCars();
			} else {
				ch.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}
		}

	}



	public static void addNewCar() {
		System.out.print("Enter a car model: ");
		String model = in.nextLine();
		System.out.print("Enter a color: ");
		String color = in.nextLine();
		System.out.print("Enter a year: ");
		int year = in.nextInt();
		Car toAdd = new Car(model, color, year);
		ch.insertCar(toAdd);


	}

	public static void editACar() {
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by model");
		System.out.println("2 : Search by color");
		int searchBy = in.nextInt();
		in.nextLine();
		List<Car> foundItems = null;
		if (searchBy == 1) {
			System.out.print("Enter the car model: ");
			String modelName = in.nextLine();
			foundItems = ch.searchForItemByModel(modelName);
		} else {
			System.out.print("Enter the color: ");
			String colorName = in.nextLine();
			foundItems = ch.searchForItemByColor(colorName);
		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (Car l : foundItems) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			Car toEdit = ch.searchForItemById(idToEdit);
			System.out.println("Retrieved " + toEdit.getColor() + " from " + toEdit.getModel());
			System.out.println("1 : Update model");
			System.out.println("2 : Update color");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New model: ");
				String newModel = in.nextLine();
				toEdit.setModel(newModel);
			} else if (update == 2) {
				System.out.print("New color: ");
				String newColor = in.nextLine();
				toEdit.setColor(newColor);
			}

			ch.updateCar(toEdit);

		} else {
			System.out.println("---- No results found");
		}

	}



	public static void deleteACar() {
		System.out.print("Enter the model to delete: ");
		String model = in.nextLine();
		System.out.print("Enter the color to delete: ");
		String color = in.nextLine();
		System.out.print("Enter the year to delete: ");
		int year = in.nextInt();




		Car toDelete = new Car(model, color, year);
		ch.deleteACar(toDelete);

	}

	public static void viewTheListOfCars() {
		List<Car> allCars = CarHelper.showAllCars();

		for(Car car : allCars){
			System.out.println(car.returnCarDetails());

		}


	}
}