package methods;

import Catalyst.sdf.Constants;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class AddDeleteFolderMethods {
	
	/**
	 * 
	 * @param parentFlolderId
	 * @param level
	 * @param folderName
	 * @param folderType
	 * @param isLocked
	 * @return
	 */
	public Response addCustomFolder(String userName, String password, String baseUrl, String caseName, String parentFlolderId, String level, String folderName, String folderType, String isLocked){
		Response response = RestAssured.given().
				header(Constants.CONTENT_TYPE, "application/x-www-form-urlencoded").
				param(Constants.MODULE_NAME, "addCustomFolder").
				param(Constants.CASENAME, caseName).
				param(Constants.PARENT_FOLDERID, parentFlolderId).
				param(Constants.LEVEL, level).
				param(Constants.FOLDERNAME, folderName).
				param(Constants.FOLDERTYPE, folderType).
				param(Constants.ISLOCKED, isLocked).
				authentication().preemptive().basic(userName, password)
					.when().post(baseUrl+"?addCustomFolder");
		
		return response;
	}
	
	/**
	 * 
	 * @param customFolderId
	 * @return
	 */
	public Response deleteCustomFolder(String userName, String password, String baseUrl, String caseName, String customFolderId){
		Response response = RestAssured.given().
				header(Constants.CONTENT_TYPE, "application/x-www-form-urlencoded").
				param(Constants.MODULE_NAME, "deleteCustomFolder").
				param(Constants.CASENAME, caseName).
				param(Constants.CUSTOM_FOLDERID, customFolderId).
				authentication().preemptive().basic(userName, password)
					.when().post(baseUrl+"?deleteCustomFolder");
		
		return response;
	}

}
