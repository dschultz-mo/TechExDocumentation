/*
 *    Licensed Materials - Property of IBM
 *    5725-I43 (C) Copyright IBM Corp. 2015. All Rights Reserved.
 *    US Government Users Restricted Rights - Use, duplication or
 *    disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
*/

package com.ibm;

import java.util.List;
import java.util.logging.Logger;
import java.io.IOException;


import com.ibm.json.java.JSONObject;


//additional imports :
import com.ibm.json.java.JSONArray;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.commons.io.IOUtils;


public class pojoEmployee {
	/*
	 * simple java class 
	 */
	//Define logger (Standard java.util.Logger)
	static Logger logger = Logger.getLogger(pojoEmployee.class.getName());


    public String getEmployees() throws IOException{
        logger.info(">>pojoEmployee -> in getEmployees() ...");
        JSONObject rsp = new JSONObject();
        try {
            rsp.put("employees", getList());
        } catch (Exception e) {
            e.printStackTrace();
            rsp.put("employees", "null");
        }
        return rsp.toString();
    }
    
      
    public String getEmployeeDetails(String id) throws IOException{
    logger.info(">>pojoEmployee -> in getEmployeeDetails() ...:" + id);
    JSONObject rsp = new JSONObject();
    try {
        JSONArray details = getDetails();
        for(int i=0; i<details.size();i++){
            JSONObject obj = (JSONObject)details.get(i);
            logger.info(">> obj.get(_id).toString():" + obj.get("_id").toString());
            if(obj.get("_id").toString().equals(id)){
                rsp.put("details", obj);
                return rsp.toString();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return rsp.toString();
}
    
        /* Creating the employee list */
public JSONArray getList() throws IOException{
    JSONArray employees = new JSONArray();
    employees = JSONArray.parse(getEmployeeDataString());
    logger.info("getList returning " + employees.serialize());
    return employees;
}

/* Creating the details list */
public JSONArray getDetails() throws IOException{
    JSONArray details = new JSONArray();
    details = JSONArray.parse(getEmployeeDetailsDataString());
    return details;
}

    /* Hard coded employee list */
public String getEmployeeDataString(){
return "[{'_id' : '01800192','first_name' : 'Mike','last_name' : 'Chepesky','img' :'male1.png','job_title' : 'SalesAssociate'},{'_id' : '01800193','first_name' : 'Amy','last_name' : 'Jones','img' :'female1.png','job_title' : 'Sales Representative'},    {'_id' : '01800121','first_name' : 'Eugene','last_name' : 'Lee','img' :'male2.png' ,'job_title' : 'CFO'},{'_id' : '01800114','first_name' : 'Gary','last_name' : 'Donovan','img' :'male3.png' ,'job_title' : 'Marketing Manager'},    {'_id' : '01800145','first_name' : 'John','last_name' : 'Williams','img' :'male4.png' ,'job_title' : 'VP of Marketing'       },{'_id' : '01800231','first_name' : 'Kathleen','last_name' : 'Byrne','img' :'female2.png', 'job_title' : 'Sales' },{'_id' : '01800211','first_name' : 'Lisa','last_name' : 'Wong','img' :'female3.png' ,'job_title' : 'Marketing Manager'       },{'_id' : '01800133','first_name' : 'Paula','last_name' : 'Gates','img': 'female4.png' ,'job_title' : 'Software Architect' },{'_id' : '01800091','first_name' : 'Paul','last_name' : 'Jones','img' : 'male5.png' ,'job_title' : 'QA Manager'},{'_id' : '01800292','first_name' : 'Steven','last_name' : 'Wells','img' : 'unknown.png' ,'job_title' : 'Software Architect'}]";

}

    /* Hard coded employee details list */
public String getEmployeeDetailsDataString(){
    return "[{'_id' : '01800192','address': '3721 S Ocean Dr, Hollywood, FL,33019','email':'Mike_Chepesky@ibm.com','mobile': '347-344-1101','fax': '347-344-1102'},{'_id' : '01800193','address': '305 E 86th St, New York, NY, 10028','email': 'Amy.Jones@us.ibm.com','mobile': '646-020-1121','fax': '637-033-2211'    },{'_id' : '01800121','address': '1211 3rd Ave, New York, NY, 10021','email': 'Eugene_Lee@ca.ibm.com','mobile': '433-111-2212','fax': '322-332-1121'    },{'_id' : '01800114','address': '251 174th St, Sunny Isles Beach, FL, 33016','email': 'Gary.Donovan@us.ibm.com','mobile': '929-222-2210','fax': '321-444-3120'    },{'_id' : '01800145','address': '100 Park Ave, New York, NY, 10022','email': 'John.Williams@ca.ibm.com','mobile': '917-019-1193','fax': '212-002-2211'    },{'_id' : '01800231','address': '200 E 65th St, New York, NY, 10021','email': 'Kathleen.Byrne@us.ibm.com','mobile': '646-003-1199','fax': '212-001-8989'    },{'_id' : '01800211','address': '12191 2nd Ave, New York, NY, 10022','email': 'Lise.Wong@ibm.com','mobile': '212-001-4431','fax': ''    },{'_id' : '01800133','address': '50 Astor Place, New York, NY, 10001','email': 'Paula_Gates@ibm.com','mobile': '212-992-8818','fax': ''    },{'_id' : '01800091','address': '3800 S Ocean Dr, Hollywood, FL, 33019','email': 'Paul_Jones@ibm.com','mobile': '954-990-1121','fax': ''       },{'_id' : '01800292','address': '121 5th Ave, New York, NY, 10010','email':'Steven.Wells@us.ibm.com','mobile': '347-002-9911','fax': ''}]";
     }

 
}