package com.ndlanx.cwwarm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ndlan.framework.core.api.BusinessService;
import com.ndlan.framework.core.web.restful.BaseBusinessControllerImpl;

import com.ndlan.cwwarm.model.CwHoldActivityMsgBean;

import com.ndlan.cwwarm.query.CwHoldActivityMsgQuery;


@Controller
@RequestMapping("/business/cw/hold/activity/msg/")
public class CwHoldActivityMsgBeanBusinessControllerImpl 
extends BaseBusinessControllerImpl<CwHoldActivityMsgBean, CwHoldActivityMsgQuery> {

	@Autowired(required=true)
	@Qualifier(value="cwHoldActivityMsgBeanBusinessService")
	private BusinessService cwHoldActivityMsgBeanBusinessService;

	protected BusinessService<CwHoldActivityMsgBean> getBaseService(){
		return cwHoldActivityMsgBeanBusinessService;
	}

}

