package de.eggi.filebrowser.gui.de.eggi.filebrowser.filetree;

import java.io.File;
import java.util.Comparator;

public class FileComparator {

    public Comparator<File> compare = (o1, o2) -> {
        if (o1.isDirectory() && !o2.isDirectory()) {
            return -1;
        } else if (!o1.isDirectory() && o2.isDirectory()) {
            return 1;
        } else {
            return o1.compareTo(o2);
        }
    };
}