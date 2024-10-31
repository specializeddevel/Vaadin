package com.learning.blogblink.Constant;

import java.io.File;
import java.nio.file.Paths;
import java.nio.file.Path;


public class StorageConstant {


    static File file = new File(System.getProperty("user.home") + File.separator +"blogblink" + File.separator + "user" + File.separator);
    public static final String PROFILE_STORAGE_PATH = file.getPath() + File.separator; // Esto convierte la ruta en un formato compatible con el sistema operativo
    public static final String DEFAULT_IMAGE_NAME = "default.png";

}
