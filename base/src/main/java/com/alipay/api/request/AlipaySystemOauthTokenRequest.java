package com.alipay.api.request;

import java.util.Map;

import com.alipay.api.AlipayRequest;
import com.alipay.api.internal.util.AlipayHashMap;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;

/**
 * ALIPAY API: alipay.system.oauth.token request
 * 
 * @author auto create
 * @since 1.0, 2014-12-12 16:55:57
 */
public class AlipaySystemOauthTokenRequest implements AlipayRequest<AlipaySystemOauthTokenResponse> {

	private AlipayHashMap udfParams; // add user-defined text parameters
	private String apiVersion="1.0";

	/** 
	* 授权码，用户对应用授权后得到。
	 */
	private String code;

	/** 
	* 获取访问令牌的类型，authorization_code表示用授权码换，refresh_token表示用刷新令牌来换。
	 */
	private String grantType;

	/** 
	* 刷新令牌，上次换取访问令牌时得到。
	 */
	private String refreshToken;

	public void setCode(String code) {
		this.code = code;
	}
	public String getCode() {
		return this.code;
	}

	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
	public String getGrantType() {
		return this.grantType;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getRefreshToken() {
		return this.refreshToken;
	}
	private String terminalType;
	private String terminalInfo;	
	private String prodCode;
	private String notifyUrl;

	public String getNotifyUrl() {
		return this.notifyUrl;
	}

	public void setNotifyUrl(String notifyUrl) {
		this.notifyUrl = notifyUrl;
	}

	public String getApiVersion() {
		return this.apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public void setTerminalType(String terminalType){
		this.terminalType=terminalType;
	}

    public String getTerminalType(){
    	return this.terminalType;
    }

    public void setTerminalInfo(String terminalInfo){
    	this.terminalInfo=terminalInfo;
    }

    public String getTerminalInfo(){
    	return this.terminalInfo;
    }	

	public void setProdCode(String prodCode) {
		this.prodCode=prodCode;
	}

	public String getProdCode() {
		return this.prodCode; 
	}

	public String getApiMethodName() {
		return "alipay.system.oauth.token";
	}

	public Map<String, String> getTextParams() {		
		AlipayHashMap txtParams = new AlipayHashMap();
		txtParams.put("code", this.code);
		txtParams.put("grant_type", this.grantType);
		txtParams.put("refresh_token", this.refreshToken);
		if(udfParams != null) {
			txtParams.putAll(this.udfParams);
		}
		return txtParams;
	}

	public void putOtherTextParam(String key, String value) {
		if(this.udfParams == null) {
			this.udfParams = new AlipayHashMap();
		}
		this.udfParams.put(key, value);
	}

	public Class<AlipaySystemOauthTokenResponse> getResponseClass() {
		return AlipaySystemOauthTokenResponse.class;
	}
}
