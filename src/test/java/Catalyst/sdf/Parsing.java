package Catalyst.sdf;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.jayway.restassured.response.Response;

public class Parsing {

	private static JSONObject obj;
	private static JSONArray array;

	
	/**
	 * 
	 * @param response
	 * @return
	 */
	public static String parseJson(Response response){
		String a = response.asString();
		obj = new JSONObject(a);
		a = obj.get("SubCollections").toString();
		obj = new JSONObject(a);
		array = (JSONArray) obj.get("subcollection");
		String subCollectionNameString = "";
		for(int i = 0; i<array.length(); i++){
			subCollectionNameString += array.getJSONObject(i).get("subcollectionname")+",";
		}
		System.out.println(subCollectionNameString);
		subCollectionNameString = subCollectionNameString.substring(0, subCollectionNameString.lastIndexOf(","));
		return subCollectionNameString;

	}
	
	/**
	 * 
	 * @param response
	 * @return
	 */
	public static List<String> parseJsonGetDocId(Response response){
		List<String> listDocId = new ArrayList<String>();
		String a = response.asString();
		obj = new JSONObject(a);
		a = obj.get("documents").toString();
		obj = new JSONObject(a);
		array = (JSONArray) obj.get("document");
		for(int i = 0; i<array.length(); i++){
			listDocId.add(array.getJSONObject(i).get("DocId").toString());
		}
		System.out.println(listDocId);
		return listDocId;

	}
	
	/**
	 * 
	 * @param response
	 * @return
	 */
	public static String parseJsonGetFolderViewId(Response response, String folderName){
		String a = response.asString();
		String folderViewId = "";
		obj = new JSONObject(a);
		a = obj.get("FolderViews").toString();
		obj = new JSONObject(a);
		array = (JSONArray) obj.get("FolderView");
		for(int i = 0; i<array.length(); i++){
			if(array.getJSONObject(i).get("name").toString().equals(folderName)) {
				folderViewId = array.getJSONObject(i).get("id").toString();
				break;
			}
		}
		System.out.println(folderViewId);
		return folderViewId;

	}
}
