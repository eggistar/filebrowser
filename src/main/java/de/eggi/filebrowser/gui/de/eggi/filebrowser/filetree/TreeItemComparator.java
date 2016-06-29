package de.eggi.filebrowser.gui.de.eggi.filebrowser.filetree;

import javafx.scene.control.TreeItem;

import java.io.File;
import java.util.Comparator;

class TreeItemComparator {
    Comparator<TreeItem<File>> compare = (o1, o2) -> {
        if (o1.getValue().isDirectory() && !o2.getValue().isDirectory()) {
            return -1;
        } else {
            if (!o1.getValue().isDirectory() && o2.getValue().isDirectory()) {
                return 1;
            } else return o1.getValue().compareTo(o2.getValue());
        }
    };
}