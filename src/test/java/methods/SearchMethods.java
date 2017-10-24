package methods;

import Catalyst.sdf.Constants;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class SearchMethods {
	
	/**
	 * 
	 * @param userName
	 * @param password
	 * @param baseUrl
	 * @param caseName
	 * @return
	 */
	public Response freeFormSearch(String userName, String password, String baseUrl, String caseName){
		Response response = RestAssured.given().
				header(Constants.CONTENT_TYPE, "application/x-www-form-urlencoded").
				param(Constants.MODULE_NAME, "GetUserSubCollections").
				param(Constants.CASENAME, caseName).
				param(Constants.USERNAME, userName).
				authentication().preemptive().basic(userName, password)
					.when().post(baseUrl+"?GetUserSubCollections");
		
		return response;
	}
	
	public Response addSearch(String userName, String password, String baseUrl, String caseName, String sortSpec, 
			String searchLanguage, String matchCase, String diacritic, String stemmed, String showInRecentSearch, 
			String searchType, String moreLikeThis, String moreLikeThisDocId, String resultPercent, String catchAll, String subCollection){
		Response response = RestAssured.given().
				header(Constants.CONTENT_TYPE, "application/x-www-form-urlencoded").
				param(Constants.MODULE_NAME, "AddSearch").
				param(Constants.CASENAME, caseName).
				param(Constants.SORT_SPEC, sortSpec).
				param(Constants.SEARCH_LANGUAGE, searchLanguage).
				param(Constants.MATCH_CASE, matchCase).
				param(Constants.DIACRITIC, diacritic).
				param(Constants.STEMMED, stemmed).
				param(Constants.RECENT_SEARCH, showInRecentSearch).
				param(Constants.SEARCH_TYPE, searchType).
				param(Constants.MORE_LIKE_THIS, moreLikeThis).
				param(Constants.MORE_LIKE_THIS_DOC_ID, moreLikeThisDocId).
				param(Constants.RESULT_PERCENT, resultPercent).
				param(Constants.CATCH_ALL, catchAll).
				param(Constants.SUB_COLLECTION, subCollection).
				authentication().preemptive().basic(userName, password)
					.when().post(baseUrl+"?AddSearch");
		
		return response;
	}
	
	public Response getSearchDataById(String userName, String password, String baseUrl, String caseName, String searchId, 
			String currpage, String pagesize, String fieldlist, String getScoreAndConfidence, String getSnippets, 
 String truncate) {

		Response response = RestAssured
				.given()
				.header(Constants.CONTENT_TYPE,
						"application/x-www-form-urlencoded")
				.param(Constants.MODULE_NAME, "GetSearchDataById")
				.param(Constants.CASENAME, caseName)
				.param(Constants.SEARCH_ID, searchId)
				.param(Constants.CURRPAGE, currpage)
				.param(Constants.PAGE_SIZE, pagesize)
				.param(Constants.FIELD_LIST, fieldlist)
				.param(Constants.GET_SCORE_AND_CONFIDENCE,
						getScoreAndConfidence)
				.param(Constants.GET_SNIPPETS, getSnippets)
				.param(Constants.TRUNCATE, truncate).authentication()
				.preemptive().basic(userName, password).when()
				.post(baseUrl + "?GetSearchDataById");

		return response;

	}
	
	public Response getUriFieldsData(String userName, String password, String baseUrl, String caseName, String uri, 
			String additionalFields) {

		Response response = RestAssured
				.given()
				.header(Constants.CONTENT_TYPE,
						"application/x-www-form-urlencoded")
				.param(Constants.MODULE_NAME, "GetURIFieldsData")
				.param(Constants.CASENAME, caseName)
				.param(Constants.URI, uri)
				.param(Constants.ADDITINAL_FIELDS, additionalFields)
				.authentication()
				.preemptive().basic(userName, password).when()
				.post(baseUrl + "?GetURIFieldsData");

		return response;

	}

}
