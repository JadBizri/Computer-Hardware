public class ComputerHardware {
	// instance fields for holding CPU and GPU clock speeds, number of cores, and
	// monitor resolution
	private int gpu;
	private int cpu;
	private int cpu_cores;
	private int choice;

	// no-arg constructor
	public ComputerHardware() {
		gpu = 0;
		cpu = 0;
		cpu_cores = 0;
		choice = 0;
	}

	/**
	 * Constructor that accepts arguments for computer hardware
	 * 
	 * @param gpu       The GPU clock speed
	 * @param cpu       The CPU clock speed
	 * @param cpu_cores The number of cores
	 * @param choice    The resolution choice number
	 */
	public ComputerHardware(int gpu_cs, int cpu_cs, int cores, int res_choice) {
		gpu = gpu_cs;
		cpu = cpu_cs;
		cpu_cores = cores;
		choice = res_choice;
	}

	/**
	 * Method that will return the correct resolution string
	 * 
	 * @return The correct resolution string based on choice
	 */
	public String getResolutionString() {
		String resolution = "N/A"; // to hold the resolution value

		// if statement to handle the user's input and assign the correct multiplier
		// value
		if (choice == 1) {
			resolution = "1280 x 720";
		} else if (choice == 2) {
			resolution = "1920 x 1080";
		} else if (choice == 3) {
			resolution = "2560 x 1440";
		} else if (choice == 4) {
			resolution = "3840 x 2160";
		}

		return resolution;
	}

	/**
	 * Method that will return the multiplier value
	 * 
	 * @return The value of multiplier based on choice
	 */
	public double getMultiplierValue() {
		// to hold multiplier values based on resolution
		double multiplier = 0;
		double multiplier_one = 1;
		double multiplier_two = .75;
		double multiplier_three = .55;
		double multiplier_four = .35;

		// if statement to handle the user's input and assign the correct multiplier
		// value
		if (choice == 1) {
			multiplier = multiplier_one;
		} else if (choice == 2) {
			multiplier = multiplier_two;
		} else if (choice == 3) {
			multiplier = multiplier_three;
		} else if (choice == 4) {
			multiplier = multiplier_four;
		}

		return multiplier;
	}

	/**
	 * Method that will return the performance score value
	 * 
	 * @return The value of performance_score
	 */
	public double calculatePerformanceScore() {
		return ((5 * gpu) + (cpu_cores * cpu)) * getMultiplierValue();
	}

	/**
	 * Method that will return the correct string for graphics_quality
	 * 
	 * @param performance_score The performance score needed to determine graphics
	 *                          quality
	 * @return The graphics_quality string based on the performance score
	 */
	public String getRecommendedQuality() {
		// constants to hold recommended graphics quality based on performance score
		final int ULTRA = 17000;
		final int HIGH = 15000;
		final int MEDIUM = 13000;
		final int LOW = 11000;

		String graphics_quality; // to hold graphics quality value

		// if statement that determines graphics quality based on performance score
		if (calculatePerformanceScore() > ULTRA) {
			graphics_quality = "Ultra";
		} else if (calculatePerformanceScore() > HIGH && calculatePerformanceScore() <= ULTRA) {
			graphics_quality = "High";
		} else if (calculatePerformanceScore() > MEDIUM && calculatePerformanceScore() <= HIGH) {
			graphics_quality = "Medium";
		} else if (calculatePerformanceScore() > LOW && calculatePerformanceScore() <= MEDIUM) {
			graphics_quality = "Low";
		} else {
			graphics_quality = "Unable to Play";
		}

		return graphics_quality;
	}

	/**
	 * Method that will display the information for a single computer
	 * 
	 * @param gpu               The clock speed of the GPU
	 * @param cpu               The clock speed of the CPU
	 * @param cpu_cores         The number of cores that the processor has
	 * @param resolution        The string the displays the monitor resolution
	 * @param performance_score The performance score of the computer
	 * @param graphics_quality  The string that displays the recommended graphics
	 *                          quality
	 */
	public void displayInformation() {
		// output
		System.out.println("\nGPU Clock Speed: " + gpu + " MHz");
		System.out.println("CPU Clock Speed: " + cpu + " MHz");
		System.out.println("Number of cores: " + cpu_cores);
		System.out.println("Monitor Resolution: " + getResolutionString());
		System.out.printf("Performance Score: %,.3f", calculatePerformanceScore());
		System.out.println("\nRecommended Graphics Quality: " + getRecommendedQuality() + "\n");
	}
}