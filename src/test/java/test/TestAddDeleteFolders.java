package test;

import java.util.HashMap;

import methods.AddDeleteFolderMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

import Catalyst.sdf.BaseClass;
import Catalyst.sdf.Constants;

import com.jayway.restassured.response.Response;

public class TestAddDeleteFolders extends BaseClass{
	/**
	 * 
	 */
	@Test
	public void addDeleteCustomFolder() {
		logger = extent.startTest("addDeleteCustomFolder");
		AddDeleteFolderMethods addDeleteFolderMethods = new AddDeleteFolderMethods();
		HashMap<String, String> mapFolderDetails = new HashMap<String, String>();
		mapFolderDetails = (HashMap<String, String>) BaseClass
				.getAddCustomFolderParametersMap();

		Response response = addDeleteFolderMethods.addCustomFolder(userName,
				password, baseUrl, caseName, mapFolderDetails
						.get(Constants.PARENT_FOLDERID), mapFolderDetails
						.get(Constants.LEVEL), mapFolderDetails
						.get(Constants.FOLDERNAME), mapFolderDetails
						.get(Constants.FOLDERTYPE),
				mapFolderDetails.get(Constants.ISLOCKED).toLowerCase());
		Assert.assertEquals(response.getStatusCode(), 200, "Fail");

		response = addDeleteFolderMethods.deleteCustomFolder(userName,
				password, baseUrl, caseName, response.body().asString());
		Assert.assertEquals(response.getStatusCode(), 200, "Fail");
	}
}