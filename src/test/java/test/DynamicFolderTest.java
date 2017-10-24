package test;

import java.util.HashMap;

import methods.DynamicFolderMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

import Catalyst.sdf.BaseClass;
import Catalyst.sdf.Constants;
import Catalyst.sdf.Parsing;

import com.jayway.restassured.response.Response;

public class DynamicFolderTest extends BaseClass{

	@Test
	public void addDeleteDynamicFolder(){
		logger = extent.startTest("addDeleteDynamicFolder");
		DynamicFolderMethods dynamicFolderMethods = new DynamicFolderMethods();
		HashMap<String, String> mapFolderDetails = new HashMap<String, String>();
		mapFolderDetails = (HashMap<String, String>) BaseClass
				.getAddDynamicFolderData();

		Response response = dynamicFolderMethods.addDynamicFolder(userName,
				password, baseUrl, caseName,
				mapFolderDetails.get(Constants.SECURITY_VIEW),
				mapFolderDetails.get(Constants.FOLDER_NAME));
		Assert.assertEquals(response.getStatusCode(), 200, "Fail");
		String folderViewId = Parsing.parseJsonGetFolderViewId(response, mapFolderDetails.get(Constants.FOLDER_NAME));
		
		mapFolderDetails = (HashMap<String, String>) BaseClass
				.getDeleteDynamicFolderData();
		response = dynamicFolderMethods.deleteDynamicFolder(userName,
				password, baseUrl, caseName,
				mapFolderDetails.get(Constants.SECURITY_VIEW),
				folderViewId);
		Assert.assertEquals(response.getStatusCode(), 200, "Fail");
	}
}
