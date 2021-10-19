package com.example.loadgithubprofiles;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseDTO{

	@SerializedName("ResponseDTO")
	private List<ResponseDTOItem> responseDTO;

	public List<ResponseDTOItem> getResponseDTO(){
		return responseDTO;
	}
}