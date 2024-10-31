package com.learning.blogblink.Service;

import com.learning.blogblink.Utils.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static com.learning.blogblink.Constant.StorageConstant.DEFAULT_IMAGE_NAME;
import static com.learning.blogblink.Constant.StorageConstant.PROFILE_STORAGE_PATH;

@Service
public class ImageServiceImpl implements ImageService {


    @Override
    public String saveProfileImage(String imageNameOld, String imageNameNew, MultipartFile profileImage) throws IOException {
        if ( profileImage.getSize() == 0) {
            return DEFAULT_IMAGE_NAME;
        }

        Path userFolderPath = Paths.get(PROFILE_STORAGE_PATH).toAbsolutePath().normalize();
        if ( imageNameOld != null) {
            FileUtils.deleteFileIfExists(userFolderPath.resolve(imageNameOld));
        }

        FileUtils.ensureDirectoryExists(userFolderPath);

        String originalFileName = profileImage.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        String finalFileName = imageNameNew + "." + extension;
        FileUtils.saveFile(profileImage.getInputStream(), userFolderPath.resolve(finalFileName), StandardCopyOption.REPLACE_EXISTING);

        return finalFileName;
    }

    @Override
    public void deleteUserProfileImage(String profileImageUrl) {
        try {
            Path userFolderPath = Paths.get(PROFILE_STORAGE_PATH).toAbsolutePath().normalize();
            FileUtils.deleteFileIfExists(userFolderPath.resolve(profileImageUrl));
        } catch (IOException e) {
            throw new RuntimeException("Error occurred while deleting user's profile image",e);
        }
    }
}
