package com.interfaceelements;

public interface PersonalDetailsInterfaceElements {

    String editButton_xpath="//span[@aria-label='Edit personal details']";

    String gender_xpath="//label[@for='gender_Male_male']";

    String maritalStatus_xpath="//label[@for='maritalStatus_Single/unmarried_N']";

    String dobDD_id="pd-dateFor";

    String dobMM_id="pd-monthFor";

    String dobYYYY_id="pd-yearFor";

    String workPermit_id="pd-workPermitForCountryFor";

    String permanentAddress_id="pd-permanent-address";

    String homeTown_id="pd-hometown";

    String pincode_id="pd-pincode";

    String addLanguage_xpath="//a[text()='Add language']";

    String selectLanguage_xpath="//input[@placeholder='Select language']";

    String selectProiciency_xpath="//input[@placeholder='Select proficiency']";

    String readCheckBox_xpath="//label[@for='pd-ability-read-0']";

    String writeCheckBox_xpath="//label[@for='pd-ability-write-0']";

    String speakCheckBox_xpath="//label[@for='pd-ability-speak-0']";

    String saveButton_xpath="//button[text()='Save']";




}
