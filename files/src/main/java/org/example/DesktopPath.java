package org.example;

import javax.swing.filechooser.FileSystemView;

public class DesktopPath {
    public String getDesktopPathFromProps() {
        return System.getProperty("user.home").concat("/Desktop");
    }

    public String getDesktopPathFromSysView() {
        return FileSystemView.getFileSystemView().getHomeDirectory().getPath().concat("/Desktop");
    }
}
