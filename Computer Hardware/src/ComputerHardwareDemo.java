import java.util.Scanner; //needed in order to read input from user

public class ComputerHardwareDemo {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in); // initializing scanner tool to read input from user

		int gpu; // to hold GPU clock speed
		int cpu; // to hold CPU clock speed
		int cpu_cores; // to hold number of CPU cores
		int computers; // to hold the number of computers to be processed
		int choice; // to hold the menu choice
		double highest = 0; // to hold highest performance score value
		double lowest = 0; // to hold lowest performance score value

		// constants holding the minimum and maximum values of user inputs
		final int min_gpu = 800, max_gpu = 2000;
		final int min_cpu = 1000, max_cpu = 5500;
		final int min_cores = 1, max_cores = 16;
		final int min_menu = 1, max_menu = 4;

		// prompting user for the number of computers to be processed
		System.out.print("How many computers are being processed? ");
		computers = keyboard.nextInt();

		// validating number of computers
		while (computers <= 0) {
			System.out.println("\nERROR: AT LEAST 1 COMPUTER MUST BE ENTERED.\n");
			System.out.print("How many computers are being processed? ");
			computers = keyboard.nextInt();
		}

		// graphics quality tool title
		displayTitle();

		for (int i = 0; i < computers; i++) // for loop to process all the computers needed
		{
			// prompting user for their GPU clock speed
			System.out.print("Please enter the clock speed (in Megahertz) of your graphics card: ");
			gpu = keyboard.nextInt();

			// validating GPU input
			while (gpu < min_gpu || gpu > max_gpu) {
				System.out.println("\nERROR: The GPU clock speed should be between 800 and 2000 MHz.\n");
				System.out.print("Please enter the clock speed (in Megahertz) of your graphics card: ");
				gpu = keyboard.nextInt();
			}

			// prompting user for their CPU clock speed
			System.out.print("Please enter the clock speed (in Megahertz) of your processor: ");
			cpu = keyboard.nextInt();

			// validating CPU input
			while (cpu < min_cpu || cpu > max_cpu) {
				System.out.println("\nERROR: The CPU clock speed should be between 1000 and 5500 MHz.\n");
				System.out.print("Please enter the clock speed (in Megahertz) of your processor: ");
				cpu = keyboard.nextInt();
			}

			// prompting user for # of CPU cores
			System.out.print("Please enter the number of cores of your processor: ");
			cpu_cores = keyboard.nextInt();

			// validating number of cores
			while (cpu_cores < min_cores || cpu_cores > max_cores) {
				System.out.println("\nERROR: The number of cores should be between 1 and 16.");
				System.out.print("Please enter the number of cores of your processor: ");
				cpu_cores = keyboard.nextInt();
			}

			// displaying resolution menu and prompting user for their choice
			System.out.println("What is the resolution of your monitor?");
			System.out.println("\t1. 1280 x 720\n\t2. 1920 x 1080\n\t3. 2560 x 1440\n\t4. 3840 x 2160");
			System.out.print("Please select from the options above: ");
			choice = keyboard.nextInt();

			// validating user's choice
			while (choice < min_menu || choice > max_menu) {
				System.out.println("\nERROR: Invalid Menu Choice.\n");
				System.out.println("What is the resolution of your monitor?");
				System.out.println("\t1. 1280 x 720\n\t2. 1920 x 1080\n\t3. 2560 x 1440\n\t4. 3840 x 2160");
				System.out.print("Please select from the options above: ");
				choice = keyboard.nextInt();
			}

			ComputerHardware comp = new ComputerHardware(gpu, cpu, cpu_cores, choice);

			// calling the getResolutionString method to assign the correct string to
			// resolution
			comp.getResolutionString();

			// calling the getMultiplierString method to assign the correct value to
			// multiplier
			comp.getMultiplierValue();

			// calling the calculatePerformanceScore method to calculate the performance
			// score
			double performance_score = comp.calculatePerformanceScore();

			// calling the getRecommendedQuality method to assign the correct string to
			// graphics_quality
			comp.getRecommendedQuality();

			// calling the displayInformation method to display the output
			comp.displayInformation();

			// determining the highest and lowest performance scores after each loop
			if (i == 0) // the highest value always equals the lowest value in the first loop because
						// there would only be 1 value of performance_score
			{
				highest = performance_score;
				lowest = performance_score;
			} else {
				if (performance_score <= lowest) {
					lowest = performance_score;
				}
				if (performance_score >= highest) {
					highest = performance_score;
				}
			}
		}
		// displaying the highest and lowest values of the performance score
		System.out.printf("The highest performance score was: %,.3f", highest);
		System.out.printf("\nThe lowest performance score was: %,.3f", lowest);
		
		//closing the scanner
		keyboard.close();
	}

	/**
	 * Method that will display the main title
	 */
	public static void displayTitle() {
		System.out.println("\nComputer Hardware Graphics Quality Recommendation Tool\n");
	}
}