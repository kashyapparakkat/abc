package methods;

import Catalyst.sdf.Constants;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class DynamicFolderMethods {

	public Response addDynamicFolder(String userName, String password, String baseUrl, String caseName, String  securityView, 
			String folderViewName){
		Response response = RestAssured.given().
				header(Constants.CONTENT_TYPE, "application/x-www-form-urlencoded").
				param(Constants.MODULE_NAME, "createFolderView").
				param(Constants.CASENAME, caseName).
				param(Constants.SECURITY_VIEW, securityView).
				param(Constants.FOLDER_NAME, folderViewName).
				authentication().preemptive().basic(userName, password)
					.when().post(baseUrl+"?createFolderView");
		
		return response;
	}
	
	public Response deleteDynamicFolder(String userName, String password, String baseUrl, String caseName, String  securityView, 
			String folderViewId){
		Response response = RestAssured.given().
				header(Constants.CONTENT_TYPE, "application/x-www-form-urlencoded").
				param(Constants.MODULE_NAME, "deleteFolderView").
				param(Constants.CASENAME, caseName).
				param(Constants.SECURITY_VIEW, securityView).
				param(Constants.FOLDER_VIEW_ID, folderViewId).
				authentication().preemptive().basic(userName, password)
					.when().post(baseUrl+"?deleteFolderView");
		
		return response;
	}
	
	
}
