/*
SubLC3VM
Nikita Koba
CSCI 4200-DB
Dr. Abi Salimi
 */

package vmPackage;

import java.io.*;
import java.util.*;

public class VirtualMachine {
	public static void main(String[] args) throws IOException {
		final int MAX_MEMORY_SIZE = 500;
		TreeMap<String, Integer> internalMemory = new TreeMap<>();
		TreeMap<String, Integer> labelMemory = new TreeMap<>();
		String[] memory = new String[MAX_MEMORY_SIZE];

		String nameAndClassInfo = "Nikita Koba CSCI 4200-DB";
		String lineOfAsterisks = "**********************************************************************";

		System.out.println(nameAndClassInfo);

		System.out.println();
		System.out.println(lineOfAsterisks);
		System.out.println();

		BufferedReader br = new BufferedReader(new FileReader("src\\vmPackage\\mySubLC3.txt"));
		String line = br.readLine(); // Creates a String line and stores the first line from the File into a String
										// line
		int i = 0;
		while (line != null) {
			memory[i] = line;
			String[] labelChecker = memory[i].split(" ");

			// Checks if Label is a single statement and if it starts with ; or a number
			if (labelChecker.length == 1 && !labelChecker[0].equals(";")
					&& (labelChecker[0].charAt(0) < '0' || labelChecker[0].charAt(0) > '9')) {
				// System.out.println("System recorded "+memory[i]+" and counter is at "+i);
				labelMemory.put(memory[i], i);
			}
			line = br.readLine(); // stores a line from the File into the String line1
			System.out.println(memory[i]);
			i++;
		}
		System.out.println();
		System.out.println(lineOfAsterisks);
		System.out.println();

		Scanner scan = new Scanner(System.in);

		String command = "";
		String statement = "";
		String[] commandArray;

		int counter = 0;
		while (!command.equals("HALT")) {
			command = memory[counter];
			// System.out.println("***System is looking at "+command+" and the counter is
			// "+counter);
			counter++;

			commandArray = command.split(" ");
			statement = commandArray[0];

			// ***** OPERATION *****

			// ADD Destination Source1 Source2
			if (statement.equals("ADD")) {
				String destination = commandArray[1];
				String source1 = commandArray[2];
				String source2 = commandArray[3];

				int intSource1 = 0;
				int intSource2 = 0;

				// If Source1 is a number
				if (source1.charAt(0) >= '0' && source1.charAt(0) <= '9') {
					intSource1 = Integer.parseInt(source1);
				}
				// If Source1 is a variable
				else if (source1.charAt(0) >= 'a' && source1.charAt(0) <= 'z') {
					intSource1 = internalMemory.get(source1);
				}
				// If Source2 is a number
				if (source2.charAt(0) >= '0' && source2.charAt(0) <= '9') {
					intSource2 = Integer.parseInt(source2);
				}
				// If Source2 is a variable
				else if (source2.charAt(0) >= 'a' && source2.charAt(0) <= 'z') {
					intSource2 = internalMemory.get(source2);
				}

				int answer = intSource1 + intSource2;
				internalMemory.put(destination, answer);

				// ADD accepts two integer values, Source1 and Source2, and stores their sum in
				// the Destination variable, Destination.
				// Each Source can be either a variable or an integer constant.
			}
			// SUB Destination Source1 Source2
			else if (statement.equals("SUB")) {
				String destination = commandArray[1];
				String source1 = commandArray[2];
				String source2 = commandArray[3];

				int intSource1 = 0;
				int intSource2 = 0;

				// If Source1 is a number
				if (source1.charAt(0) >= '0' && source1.charAt(0) <= '9') {
					intSource1 = Integer.parseInt(source1);
				}
				// If Source1 is a variable
				else if (source1.charAt(0) >= 'a' && source1.charAt(0) <= 'z') {
					intSource1 = internalMemory.get(source1);
				}
				// If Source2 is a number
				if (source2.charAt(0) >= '0' && source2.charAt(0) <= '9') {
					intSource2 = Integer.parseInt(source2);
				}
				// If Source2 is a variable
				else if (source2.charAt(0) >= 'a' && source2.charAt(0) <= 'z') {
					intSource2 = internalMemory.get(source2);
				}

				int answer = intSource1 - intSource2;
				internalMemory.put(destination, answer);

				// SUB accepts two integer values, Source1 and Source2, and stores the result of
				// (Source1 – Source2) in the Destination variable, Destination.
				// Each Source can be either a variable or an integer constant.
			}
			// MUL Destination Source1 Source2
			else if (statement.equals("MUL")) {
				String destination = commandArray[1];
				String source1 = commandArray[2];
				String source2 = commandArray[3];

				int intSource1 = 0;
				int intSource2 = 0;

				// If Source1 is a number
				if (source1.charAt(0) >= '0' && source1.charAt(0) <= '9') {
					intSource1 = Integer.parseInt(source1);
				}
				// If Source1 is a variable
				else if (source1.charAt(0) >= 'a' && source1.charAt(0) <= 'z') {
					intSource1 = internalMemory.get(source1);
				}
				// If Source2 is a number
				if (source2.charAt(0) >= '0' && source2.charAt(0) <= '9') {
					intSource2 = Integer.parseInt(source2);
				}
				// If Source2 is a variable
				else if (source2.charAt(0) >= 'a' && source2.charAt(0) <= 'z') {
					intSource2 = internalMemory.get(source2);
				}

				int answer = intSource1 * intSource2;
				internalMemory.put(destination, answer);

				// MUL accepts two integer values, Source1 and Source2, and stores the result of
				// (Source1 * Source2) in the Destination variable, Destination.
				// Each Source can be either a variable or an integer constant.
			}
			// DIV Destination Source1 Source2
			else if (statement.equals("DIV")) {
				String destination = commandArray[1];
				String source1 = commandArray[2];
				String source2 = commandArray[3];

				int intSource1 = 0;
				int intSource2 = 0;

				// If Source1 is a number
				if (source1.charAt(0) >= '0' && source1.charAt(0) <= '9') {
					intSource1 = Integer.parseInt(source1);
				}
				// If Source1 is a variable
				else if (source1.charAt(0) >= 'a' && source1.charAt(0) <= 'z') {
					intSource1 = internalMemory.get(source1);
				}
				// If Source2 is a number
				if (source2.charAt(0) >= '0' && source2.charAt(0) <= '9') {
					intSource2 = Integer.parseInt(source2);
				}
				// If Source2 is a variable
				else if (source2.charAt(0) >= 'a' && source2.charAt(0) <= 'z') {
					intSource2 = internalMemory.get(source2);
				}

				int answer = intSource1 / intSource2;
				internalMemory.put(destination, answer);

				// DIV accepts two integer values, Source1 and Source2, and stores the result of
				// (Source1 / Source2) in the Destination variable, Destination.
				// Each Source can be either a variable or an integer constant.
			}
			// IN Variable
			else if (statement.equals("IN")) {
				String variable = commandArray[1];
				int integer = scan.nextInt();

				internalMemory.put(variable, integer);
				// Inputs an integer value and stores it in Variable.
			}
			// OUT Value
			else if (statement.equals("OUT")) {
				String value = commandArray[1];
				
				if (value.charAt(0) == '"') {
					commandArray[1] = commandArray[1].substring(1); // Removes first quotation mark
					commandArray[commandArray.length - 1] = commandArray[commandArray.length - 1].substring(0,
							commandArray[commandArray.length - 1].length() - 1); // Removes last quotation mark
					
					for (int n = 1; n < commandArray.length; n++) {
						System.out.print(commandArray[n] + " ");
					}
					System.out.println();
				} else {
					int variable = internalMemory.get(value);
					System.out.println(variable);
				}

				// Display Value.
				// Value can be either an integer variable or a string of characters enclosed in
				// quotation marks (" ")
			}
			// ***** DATA MOVEMENT *****

			// STO Destination Source
			else if (statement.equals("STO")) {
				String destination = commandArray[1];
				String source1 = commandArray[2];
				
				// If source is a number
				if (source1.charAt(0) >= '0' || source1.charAt(0) <= '9') {
					// System.out.println(source1);
					int integerConstant = Integer.parseInt(source1);
					// System.out.println(integerConstant);
					internalMemory.put(destination, integerConstant);
				}
				// If source is a variable
				else if (source1.charAt(0) >= 'a' || source1.charAt(0) <= 'z') {
					int variable = internalMemory.get(destination);
					internalMemory.put(destination, variable);
				}
				// System.out.println("*System did STO and stored "+source1+" in "+destination);
				// The STO instruction stores the value of Source in Destination variable.
				// Source can be either a variable or an integer constant.
			}
			// ***** CONTROL *****

			// BRn Variable Label
			else if (statement.equals("BRn")) {
				// If the value of Variable is negative, jump to Label.
				String variable = commandArray[1];
				String label = commandArray[2];
				int number = internalMemory.get(variable);

				if (number < 0) {
					counter = labelMemory.get(label);
				}
			}
			// BRz Variable Label
			else if (statement.equals("BRz")) {
				// If the value of Variable is zero, jump to Label.
				String variable = commandArray[1];
				String label = commandArray[2];
				int number = internalMemory.get(variable);

				if (number == 0) {
					counter = labelMemory.get(label);
				}
			}
			// BRp Variable Label
			else if (statement.equals("BRp")) {
				// If the value of Variable is positive, jump to Label.
				String variable = commandArray[1];
				String label = commandArray[2];
				int number = internalMemory.get(variable);

				if (number > 0) {
					counter = labelMemory.get(label);
				}
			}
			// BRzp Variable Label
			else if (statement.equals("BRzp")) {
				String variable = commandArray[1];
				String label = commandArray[2];

				int number = internalMemory.get(variable);

				if (number >= 0) {
					counter = labelMemory.get(label);
				}
			}
			// BRzn Variable Label
			else if (statement.equals("BRzn")) {
				String variable = commandArray[1];
				String label = commandArray[2];
				int number = internalMemory.get(variable);

				if (number <= 0) {
					counter = labelMemory.get(label);
				}
				// If the value of Variable is zero or negative, jump to Label.
			}
			// JMP Label
			else if (statement.equals("JMP")) {
				String label = commandArray[1];
				counter = labelMemory.get(label);
			}
			// Semicolon (;) at the beginning of a line indicates a comment line, which will
			// be ignored by SubLC3VM.
			else if (statement.equals(";")) {
			}
		}
	}
}