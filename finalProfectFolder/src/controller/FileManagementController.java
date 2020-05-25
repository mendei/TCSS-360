package controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import model.UserProfile;
import objectInterface.FileOperationInterface;

public class FileManagementController implements FileOperationInterface {

	private final String USER_INFO_PATH = "src/userInfo/userInfo.txt";


	/**
	 * Accessing the file to import userProfile
	 */
	@Override
	public void importSetting(UserProfile userProfile) {
		BufferedWriter bw = null;
		try {
			List<UserProfile> lstOfUser = getAllUser();
			bw = new BufferedWriter(new FileWriter(USER_INFO_PATH));
			for (UserProfile user : lstOfUser) {
				if (user.getUserName().equalsIgnoreCase(userProfile.getUserName())) {
					bw.write(userProfile.toString());
				} else {
					bw.write(user.toString());
				}
				bw.newLine();
			}
			bw.close();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	private List<UserProfile> getAllUser() throws IOException {
		List<UserProfile> lstOfUser = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(USER_INFO_PATH));
			String row = br.readLine();
			while (row != null) {
				String data[] = row.split(",");
				UserProfile user = new UserProfile();
				user.setUserName(data[0]);
				user.setPassword(data[1]);
				user.setName(data[2]);
				user.setEmail(data[3]);
				lstOfUser.add(user);
				row = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lstOfUser;
	}


}
