package Broken;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		char ch;
		char chH = 'a';
		String dr = "newfolder-";
		String directoryPath = "newfolder-";
		String pa = "H:\\newfolder-a\newfolder-";
		for (char d = 'a'; d <= 'k'; ++d) {
			pa = "H:\\newfolder-a\\newfolder-" + d + "\\";
			for (char q = 'a'; q <= 'k'; ++q) {
				for (char l = 'a'; l <= 'k'; ++l) {
					for (char g = 'a'; g <= 'k'; ++g) {
						if (l == 'k')
							directoryPath = "\\" + "newfolder-" + q + "\\" + directoryPath + g;
						else if (q == 'k')
							directoryPath = directoryPath + g;
						else
							directoryPath = "newfolder-" + q + "\\" + "newfolder-" + l + "\\" + directoryPath + g;

						for (chH = 'a'; chH <= 'g'; ++chH) {

							// directoryPath = directoryPath + "\\" + dr + chH;

							File directory = new File(pa + directoryPath);

							if (directory.exists()) {
								if (directory.isDirectory()) {
									File[] files = directory.listFiles();
									if (files != null && files.length > 0) {

										for (File file : files) {
											String name = file.getName();
											if (name.indexOf("lock.dll") == -1) {
												System.out.println(name);
												System.out.println(
														"Existing files in the directory " + pa + directoryPath + " :");
											}
										}
									} else {
										// System.out.println("Directory is empty " + directoryPath + " .");
									}
								} else {
									// System.out.println("Not a valid directory path " + directoryPath + " .");
								}
							} else {
								// System.out.println("Directory does not exist " + pa + directoryPath + " .");
							}
						}
						directoryPath = "newfolder-";
						// System.out.println(ch);
					}
				}
			}
		}
	}
}
