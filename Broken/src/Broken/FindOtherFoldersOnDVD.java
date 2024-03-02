package Broken;

import java.io.File;

public class FindOtherFoldersOnDVD {
    public static void main(String[] args) {
        String dvdPath = "H:\\";  // Replace this with the actual DVD path
        String targetFolderName = "newfolder-a";

        findOtherFolders(dvdPath, targetFolderName);
    }

    private static void findOtherFolders(String currentPath, String targetFolderName) {
        File currentFolder = new File(currentPath);

        if (currentFolder.exists() && currentFolder.isDirectory()) {
            File[] subItems = currentFolder.listFiles();

            if (subItems != null) {
                for (File subItem : subItems) {
                    if (subItem.isDirectory()) {
                        if (!subItem.getName().equals(targetFolderName)) {
                            System.out.println("Found other folder: " + subItem.getAbsolutePath());
                        }
                        // Recursive call to explore subdirectories
                        findOtherFolders(subItem.getAbsolutePath(), targetFolderName);
                    }
                }
            } else {
                System.out.println("Error accessing the folder: " + currentFolder.getAbsolutePath());
            }
        } else {
            System.out.println("The specified path is not a valid directory: " + currentFolder.getAbsolutePath());
        }
    }
}
