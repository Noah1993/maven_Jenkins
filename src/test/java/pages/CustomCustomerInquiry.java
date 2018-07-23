package pages;

import java.util.Random;

import baseClass.BaseClass;
import iSafe.ApplicationKeywords;

public class CustomCustomerInquiry extends ApplicationKeywords
{
	public CustomCustomerInquiry(BaseClass obj) {super(obj);}
	boolean verifyPageLoad = false;
	public static final String obj_PageLoad
		= " CUSTOMER INQUIRY "
		+ "#id=headerTextId";
	public static final String txt_PageLoad
		= "CUSTOMER INQUIRY";
	public static final String obj_CustomerLastName
		= " Customer Last Name "
		+ "#id=customerLastName";
	public static final String obj_ZipCode
		= " ZIP CODE "
		+ "#id=zipCodeId";
	public static final String obj_Search1
		= " SEARCH "
		+ "#id=submitSearchByNameAndZip";
	public static final String obj_PhoneNumber
		= " Phone Number "
		+ "#id=phoneNumberId";
	public static final String obj_Search2
		= " SEARCH "
		+ "#id=submitSearchByPhone";
	public static final String obj_AddCustomer
		= " ADD CUSTOMER "
		+ "#id=addCustomer";
	public static final String obj_ByPassSearch
		= " BYPASS SEARCH "
		+ "#id=bypassSearchId";
	public static final String obj_ClearSearchId
		= " CLEAR SEARCH "
		+ "#id=clearSearchId";
	public static final String obj_ChangeConsultantId
		= " CHANGE CONSULTANT ID "
		+ "#id=changeConsultantId";
	public static final String obj_FirstNameId
		= " FIRST NAME LABEL ID "
		+ "#id=firstNameId";
	public static final String obj_LastNameId
		= " LAST NAME ID "
		+ "#id=lastNameId";
	public static final String obj_AddressId
		= " ADDRESS ID "
		+ "#id=addressId";
	public static final String obj_Address2LabelId
		= " CHANGE CONSULTANT ID "
		+ "#id=address2LabelId";
	public static final String obj_City
		= " CITY ID "
		+ "#id=cityId";
	public static final String obj_ProvStateSelect
		= " PROVINCE STATE "
		+ "#id=provStateSelect";
	public static final String obj_ZipPostal
		= " ZIP POSTAL ID "
		+ "#id=zipPostalId";
	public static final String obj_Phone
		= " PHONE "
		+ "#id=phoneId";
	public static final String obj_AlternatePhone
		= " ALTERNATE PHONE "
		+ "#id=alternatePhoneId";
	public static final String obj_Email
		= " ALTERNATE PHONE "
		+ "#id=emailId";
	public static final String obj_UpdateButtonId
		= " UPDATE BUTTON ID "
		+ "#id=updateButtonId";
	public static final String obj_AddNewOrder
		= " ADD NEW ORDER "
		+ "#id=addNewOrderId";
	
	public boolean verifyPageLoad() {
		Boolean result = getText(obj_PageLoad).contains(txt_PageLoad);
		if(result){
			testStepPassed("Page loaded successfully found = "+txt_PageLoad);
			verifyPageLoad = true;
		} else {testStepFailed("Did not see page load text = "+txt_PageLoad
				+ " *** Actual = "+getText(obj_PageLoad));
			verifyPageLoad = false;}
		return verifyPageLoad;}
	
	public void searchByPhone(String phone) {
		if (phone.equals("@VALID")) {
			Random rand = new Random();
			double  randomNumber = rand.nextInt(10000000) + 6040000000.0;
			phone = randomNumber+"";}
		typeIn(obj_PhoneNumber, phone);
		clickOn(obj_Search2);
	}
	
	/*public void createCustomer(String firstName, String lastName, 
		String address, String city, String provStateSelect, 
		String zipPostal, String email) {
		if (firstName.equals("@DEFAULT")) {firstName = randomName();}
		typeIn(obj_FirstNameId, firstName);
		if (lastName.equals("@DEFAULT")) {lastName = randomName();}
		typeIn(obj_LastNameId, lastName);
		if (address.equals("@DEFAULT")) {address = randomAddress();}
		typeIn(obj_AddressId, address);
		if (city.equals("@DEFAULT")) {city = "Fremont";}
		typeIn(obj_City, city);
		if (provStateSelect.equals("@DEFAULT")){
			selectFromDropdown(obj_ProvStateSelect, 6);
		} else {selectFromDropdown(obj_ProvStateSelect, provStateSelect);}
		if (zipPostal.equals("@DEFAULT")) {zipPostal = "94538";}
		typeIn(obj_ZipPostal, zipPostal);
		if (email.equals("@DEFAULT")) {email = randomEmail();}
		typeIn(obj_Email, email);
		clickOn(obj_UpdateButtonId);
		waitTime(1);
	}*/
}
