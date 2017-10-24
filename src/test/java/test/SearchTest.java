package test;

import java.util.HashMap;

import methods.SearchMethods;

import org.testng.Assert;
import org.testng.annotations.Test;

import Catalyst.sdf.BaseClass;
import Catalyst.sdf.Constants;
import Catalyst.sdf.Parsing;

import com.jayway.restassured.response.Response;

public class SearchTest extends BaseClass{
	
	
	/**
	 * 
	 */
	@Test
	public void freeFormSearch(){
		logger = extent.startTest("freeFormSearch");
		SearchMethods searchMethods = new SearchMethods();
		HashMap<String, String> mapFolderDetails = new HashMap<String, String>();
		mapFolderDetails = (HashMap<String, String>) BaseClass
				.getUserSubCollections();

		Response response = searchMethods.freeFormSearch(userName,
				password, baseUrl, caseName);
		Assert.assertEquals(response.getStatusCode(), 200, "Fail");
		String subCollectionNames = Parsing.parseJson(response);
		
		mapFolderDetails = (HashMap<String, String>) BaseClass
				.addSearch();
		response = searchMethods.addSearch(userName,
				password, baseUrl, caseName, mapFolderDetails
						.get(Constants.SORT_SPEC), mapFolderDetails
						.get(Constants.SEARCH_LANGUAGE), mapFolderDetails
						.get(Constants.MATCH_CASE), mapFolderDetails
						.get(Constants.DIACRITIC),
						mapFolderDetails
						.get(Constants.STEMMED),
						mapFolderDetails
						.get(Constants.RECENT_SEARCH).toLowerCase(),
						mapFolderDetails
						.get(Constants.SEARCH_TYPE),
						mapFolderDetails
						.get(Constants.MORE_LIKE_THIS).toLowerCase(),
						mapFolderDetails
						.get(Constants.MORE_LIKE_THIS_DOC_ID),
						mapFolderDetails
						.get(Constants.RESULT_PERCENT),
						mapFolderDetails
						.get(Constants.CATCH_ALL), subCollectionNames);
		Assert.assertEquals(response.getStatusCode(), 200, "Fail");
	}
	

	/**
	 * 
	 */
	@Test
	public void getFieldsData(){
		logger = extent.startTest("getUriFieldsData");
		SearchMethods searchMethods = new SearchMethods();
		HashMap<String, String> mapFolderDetails = new HashMap<String, String>();
		mapFolderDetails = (HashMap<String, String>) BaseClass
				.getUserSubCollections();

		Response response = searchMethods.freeFormSearch(userName,
				password, baseUrl, caseName);
		Assert.assertEquals(response.getStatusCode(), 200, "Fail");
		String subCollectionNames = Parsing.parseJson(response);
		
		mapFolderDetails = (HashMap<String, String>) BaseClass
				.addSearch();
		response = searchMethods.addSearch(userName,
				password, baseUrl, caseName, mapFolderDetails
						.get(Constants.SORT_SPEC), mapFolderDetails
						.get(Constants.SEARCH_LANGUAGE), mapFolderDetails
						.get(Constants.MATCH_CASE), mapFolderDetails
						.get(Constants.DIACRITIC),
						mapFolderDetails
						.get(Constants.STEMMED),
						mapFolderDetails
						.get(Constants.RECENT_SEARCH).toLowerCase(),
						mapFolderDetails
						.get(Constants.SEARCH_TYPE),
						mapFolderDetails
						.get(Constants.MORE_LIKE_THIS).toLowerCase(),
						mapFolderDetails
						.get(Constants.MORE_LIKE_THIS_DOC_ID),
						mapFolderDetails
						.get(Constants.RESULT_PERCENT),
						mapFolderDetails
						.get(Constants.CATCH_ALL), subCollectionNames);
		Assert.assertEquals(response.getStatusCode(), 200, "Fail");
		
		
		mapFolderDetails = (HashMap<String, String>) BaseClass
				.getSearchDataById();
		response = searchMethods.getSearchDataById(userName,
				password, baseUrl, caseName, response.body().asString(), mapFolderDetails
						.get(Constants.CURRPAGE), mapFolderDetails
						.get(Constants.PAGE_SIZE), mapFolderDetails
						.get(Constants.FIELD_LIST),
						mapFolderDetails
						.get(Constants.GET_SCORE_AND_CONFIDENCE).toLowerCase(),
						mapFolderDetails
						.get(Constants.GET_SNIPPETS).toLowerCase(),
						mapFolderDetails
						.get(Constants.TRUNCATE).toLowerCase());
		Assert.assertEquals(response.getStatusCode(), 200, "Fail");
		
		String docId = Parsing.parseJsonGetDocId(response).get(0);
		
		mapFolderDetails = (HashMap<String, String>)BaseClass.getUriFieldsData();
		
		response = searchMethods.getUriFieldsData(userName,
				password, baseUrl, caseName, docId, mapFolderDetails
						.get(Constants.ADDITINAL_FIELDS));
		Assert.assertEquals(response.getStatusCode(), 200, "Fail");

	}
}
