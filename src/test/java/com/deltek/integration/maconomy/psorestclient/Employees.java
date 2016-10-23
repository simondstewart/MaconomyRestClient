package com.deltek.integration.maconomy.psorestclient;

import java.util.function.Function;

import com.deltek.integration.maconomy.client.MaconomyClient;
import com.deltek.integration.maconomy.containers.v1.CardTableData;
import com.deltek.integration.maconomy.containers.v1.CardTableRecord;
import com.deltek.integration.maconomy.containers.v1.Container;
import com.deltek.integration.maconomy.containers.v1.FilterData;
import com.deltek.integration.maconomy.containers.v1.FilterRecord;
import com.deltek.integration.maconomy.custom.BaseCardPane;
import com.deltek.integration.maconomy.custom.BaseCardTableRecord;
import com.deltek.integration.maconomy.custom.BaseContainer;
import com.deltek.integration.maconomy.custom.BaseFilterPane;
import com.deltek.integration.maconomy.custom.BaseRecord;
import com.deltek.integration.maconomy.custom.BaseTablePane;
import com.deltek.integration.maconomy.custom.ICreateAction;
import com.deltek.integration.maconomy.custom.IHasCard;
import com.deltek.integration.maconomy.custom.IHasClient;
import com.deltek.integration.maconomy.custom.IHasFilter;
import com.deltek.integration.maconomy.custom.IHasTable;
import com.deltek.integration.maconomy.custom.IInitRecord;
import com.deltek.integration.maconomy.custom.IInsertAction;
import com.deltek.integration.maconomy.custom.IRecord;
import com.deltek.integration.maconomy.custom.RStringField;
import com.deltek.integration.maconomy.custom.RWStringField;


/**
 * AUTO-GENERATED IMPLEMENTATION OF THE "EMPLOYEES" CONTAINER. (2016-10-23T17:17:35.965)
 */
public class Employees
    extends BaseContainer
    implements IHasCard<Employees.Card> , IHasFilter<Employees.Filter> , IHasTable<Employees.Table> , IInsertAction<Container, Employees.Card.InitRecord>
{

    public Employees(final MaconomyClient maconomyClient) {
        super(maconomyClient, "Employees");
    }

    @Override
    public Function<FilterData, Employees.Filter> getFilterCtorFn() {
        return filterData -> {
            return new Employees.Filter(this, filterData);
        }
        ;
    }

    @Override
    public Function<CardTableRecord, Employees.Card.InitRecord> getInitRecordCtorFn() {
        return cardTableRecord -> {
            return new Employees.Card.InitRecord(this, cardTableRecord);
        }
        ;
    }

    @Override
    public Function<CardTableData, Employees.Card> getCardCtorFn() {
        return cardTableData -> {
            return new Employees.Card(this, cardTableData);
        }
        ;
    }

    @Override
    public Function<CardTableData, Employees.Table> getTableCtorFn() {
        return cardTableData -> {
            return new Employees.Table(this, cardTableData);
        }
        ;
    }

    public static class Card
        extends BaseCardPane<Employees.Card.InitRecord, Employees.Card.Record>
    {

        private Card(final IHasClient iHasClient, final CardTableData cardTableData) {
            super(iHasClient, cardTableData, initRecord -> {
                return new Employees.Card.InitRecord(iHasClient, initRecord);
            }
            , record -> {
                return new Employees.Card.Record(iHasClient, record);
            }
            );
        }

        public static class InitRecord
            extends BaseCardTableRecord<com.deltek.integration.maconomy.psorestclient.Employees.Card>
            implements ICreateAction<com.deltek.integration.maconomy.psorestclient.Employees.Card> , IInitRecord
        {

            private InitRecord(final IHasClient iHasClient, final CardTableRecord cardTableRecord) {
                super(iHasClient, cardTableRecord, cardTableData -> {
                    return new com.deltek.integration.maconomy.psorestclient.Employees.Card(iHasClient, cardTableData);
                }
                );
            }

            public RWStringField employeeNumber() {
                return new RWStringField(getContext().getData(), "employeenumber");
            }

            public RWStringField name1() {
                return new RWStringField(getContext().getData(), "name1");
            }

            public RWStringField name2() {
                return new RWStringField(getContext().getData(), "name2");
            }

            public RWStringField name3() {
                return new RWStringField(getContext().getData(), "name3");
            }

            public RWStringField name4() {
                return new RWStringField(getContext().getData(), "name4");
            }

            public RWStringField name5() {
                return new RWStringField(getContext().getData(), "name5");
            }

            public RWStringField telephone() {
                return new RWStringField(getContext().getData(), "telephone");
            }

            public RWStringField cNRNumber() {
                return new RWStringField(getContext().getData(), "cnrnumber");
            }

            public RWStringField itemNumber() {
                return new RWStringField(getContext().getData(), "itemnumber");
            }

            public RStringField createdBy() {
                return new RStringField(getContext().getData(), "createdby");
            }

            public RStringField changedBy() {
                return new RStringField(getContext().getData(), "changedby");
            }

            public RWStringField commissionAccount() {
                return new RWStringField(getContext().getData(), "commissionaccount");
            }

            public RWStringField commissionSetOffAccount() {
                return new RWStringField(getContext().getData(), "commissionsetoffaccount");
            }

            public RWStringField zipCode() {
                return new RWStringField(getContext().getData(), "zipcode");
            }

            public RWStringField postalDistrict() {
                return new RWStringField(getContext().getData(), "postaldistrict");
            }

            public RWStringField profession() {
                return new RWStringField(getContext().getData(), "profession");
            }

            public RWStringField education() {
                return new RWStringField(getContext().getData(), "education");
            }

            public RWStringField position() {
                return new RWStringField(getContext().getData(), "position");
            }

            public RWStringField bank() {
                return new RWStringField(getContext().getData(), "bank");
            }

            public RWStringField registrationNumber() {
                return new RWStringField(getContext().getData(), "registrationnumber");
            }

            public RWStringField bankAccountNumber() {
                return new RWStringField(getContext().getData(), "bankaccountnumber");
            }

            public RWStringField basicSalaryCode() {
                return new RWStringField(getContext().getData(), "basicsalarycode");
            }

            public RWStringField salarySupplementCode() {
                return new RWStringField(getContext().getData(), "salarysupplementcode");
            }

            public RWStringField overtimeRateCode() {
                return new RWStringField(getContext().getData(), "overtimeratecode");
            }

            public RWStringField pensionTypeCompany() {
                return new RWStringField(getContext().getData(), "pensiontypecompany");
            }

            public RWStringField pensionTypeOwn() {
                return new RWStringField(getContext().getData(), "pensiontypeown");
            }

            public RWStringField remark1() {
                return new RWStringField(getContext().getData(), "remark1");
            }

            public RWStringField remark2() {
                return new RWStringField(getContext().getData(), "remark2");
            }

            public RWStringField remark3() {
                return new RWStringField(getContext().getData(), "remark3");
            }

            public RWStringField remark4() {
                return new RWStringField(getContext().getData(), "remark4");
            }

            public RWStringField remark5() {
                return new RWStringField(getContext().getData(), "remark5");
            }

            public RWStringField superiorEmployee() {
                return new RWStringField(getContext().getData(), "superioremployee");
            }

            public RWStringField locationName() {
                return new RWStringField(getContext().getData(), "locationname");
            }

            public RWStringField entityName() {
                return new RWStringField(getContext().getData(), "entityname");
            }

            public RWStringField projectName() {
                return new RWStringField(getContext().getData(), "projectname");
            }

            public RStringField serviceInventoryName() {
                return new RStringField(getContext().getData(), "serviceinventoryname");
            }

            public RWStringField secretaryEmployee() {
                return new RWStringField(getContext().getData(), "secretaryemployee");
            }

            public RWStringField specification1Name() {
                return new RWStringField(getContext().getData(), "specification1name");
            }

            public RWStringField specification2Name() {
                return new RWStringField(getContext().getData(), "specification2name");
            }

            public RWStringField specification3Name() {
                return new RWStringField(getContext().getData(), "specification3name");
            }

            public RWStringField purposeName() {
                return new RWStringField(getContext().getData(), "purposename");
            }

            public RWStringField companyNumber() {
                return new RWStringField(getContext().getData(), "companynumber");
            }

            public RWStringField localSpec1Name() {
                return new RWStringField(getContext().getData(), "localspec1name");
            }

            public RWStringField localSpec2Name() {
                return new RWStringField(getContext().getData(), "localspec2name");
            }

            public RWStringField localSpec3Name() {
                return new RWStringField(getContext().getData(), "localspec3name");
            }

            public RWStringField weekCalendarNumber() {
                return new RWStringField(getContext().getData(), "weekcalendarnumber");
            }

            public RWStringField jobPriceGroupNumber() {
                return new RWStringField(getContext().getData(), "jobpricegroupnumber");
            }

            public RWStringField statistic1() {
                return new RWStringField(getContext().getData(), "statistic1");
            }

            public RWStringField statistic2() {
                return new RWStringField(getContext().getData(), "statistic2");
            }

            public RWStringField statistic3() {
                return new RWStringField(getContext().getData(), "statistic3");
            }

            public RWStringField statistic4() {
                return new RWStringField(getContext().getData(), "statistic4");
            }

            public RWStringField vendorNumber() {
                return new RWStringField(getContext().getData(), "vendornumber");
            }

            public RWStringField accessLevelName() {
                return new RWStringField(getContext().getData(), "accesslevelname");
            }

            public RStringField primaryEmployeeCategoryNumber() {
                return new RStringField(getContext().getData(), "primaryemployeecategorynumber");
            }

            public RWStringField dimensionCombNumber() {
                return new RWStringField(getContext().getData(), "dimensioncombnumber");
            }

            public RWStringField documentArchiveNumber() {
                return new RWStringField(getContext().getData(), "documentarchivenumber");
            }

            public RWStringField electronicMailAddress() {
                return new RWStringField(getContext().getData(), "electronicmailaddress");
            }

            public RStringField dimCombVersionNumber() {
                return new RStringField(getContext().getData(), "dimcombversionnumber");
            }

            public RWStringField accountNumber() {
                return new RWStringField(getContext().getData(), "accountnumber");
            }

            public RStringField instanceKey() {
                return new RStringField(getContext().getData(), "instancekey");
            }

            public RStringField contactPersonNumber() {
                return new RStringField(getContext().getData(), "contactpersonnumber");
            }

            public RWStringField initials() {
                return new RWStringField(getContext().getData(), "initials");
            }

            public RWStringField mobilePhone() {
                return new RWStringField(getContext().getData(), "mobilephone");
            }

            public RWStringField mobilePhone2() {
                return new RWStringField(getContext().getData(), "mobilephone2");
            }

            public RWStringField telephone2() {
                return new RWStringField(getContext().getData(), "telephone2");
            }

            public RWStringField optionListNumber1() {
                return new RWStringField(getContext().getData(), "optionlistnumber1");
            }

            public RWStringField selectedOption1() {
                return new RWStringField(getContext().getData(), "selectedoption1");
            }

            public RWStringField optionListNumber2() {
                return new RWStringField(getContext().getData(), "optionlistnumber2");
            }

            public RWStringField selectedOption2() {
                return new RWStringField(getContext().getData(), "selectedoption2");
            }

            public RWStringField optionListNumber3() {
                return new RWStringField(getContext().getData(), "optionlistnumber3");
            }

            public RWStringField selectedOption3() {
                return new RWStringField(getContext().getData(), "selectedoption3");
            }

            public RWStringField optionListNumber4() {
                return new RWStringField(getContext().getData(), "optionlistnumber4");
            }

            public RWStringField selectedOption4() {
                return new RWStringField(getContext().getData(), "selectedoption4");
            }

            public RWStringField optionListNumber5() {
                return new RWStringField(getContext().getData(), "optionlistnumber5");
            }

            public RWStringField selectedOption5() {
                return new RWStringField(getContext().getData(), "selectedoption5");
            }

            public RWStringField optionListNumber6() {
                return new RWStringField(getContext().getData(), "optionlistnumber6");
            }

            public RWStringField selectedOption6() {
                return new RWStringField(getContext().getData(), "selectedoption6");
            }

            public RWStringField optionListNumber7() {
                return new RWStringField(getContext().getData(), "optionlistnumber7");
            }

            public RWStringField selectedOption7() {
                return new RWStringField(getContext().getData(), "selectedoption7");
            }

            public RWStringField optionListNumber8() {
                return new RWStringField(getContext().getData(), "optionlistnumber8");
            }

            public RWStringField selectedOption8() {
                return new RWStringField(getContext().getData(), "selectedoption8");
            }

            public RWStringField optionListNumber9() {
                return new RWStringField(getContext().getData(), "optionlistnumber9");
            }

            public RWStringField selectedOption9() {
                return new RWStringField(getContext().getData(), "selectedoption9");
            }

            public RWStringField optionListNumber10() {
                return new RWStringField(getContext().getData(), "optionlistnumber10");
            }

            public RWStringField selectedOption10() {
                return new RWStringField(getContext().getData(), "selectedoption10");
            }

            public RWStringField text1() {
                return new RWStringField(getContext().getData(), "text1");
            }

            public RWStringField text2() {
                return new RWStringField(getContext().getData(), "text2");
            }

            public RWStringField text3() {
                return new RWStringField(getContext().getData(), "text3");
            }

            public RWStringField text4() {
                return new RWStringField(getContext().getData(), "text4");
            }

            public RWStringField text5() {
                return new RWStringField(getContext().getData(), "text5");
            }

            public RStringField purchaseOrderNumber() {
                return new RStringField(getContext().getData(), "purchaseordernumber");
            }

            public RWStringField absenceApprover() {
                return new RWStringField(getContext().getData(), "absenceapprover");
            }

            public RWStringField tutorEmployee() {
                return new RWStringField(getContext().getData(), "tutoremployee");
            }

            public RStringField transactionTimestamp() {
                return new RStringField(getContext().getData(), "transactiontimestamp");
            }

            public RWStringField subcontractorVendorNumber() {
                return new RWStringField(getContext().getData(), "subcontractorvendornumber");
            }

            public RWStringField text6() {
                return new RWStringField(getContext().getData(), "text6");
            }

            public RWStringField text7() {
                return new RWStringField(getContext().getData(), "text7");
            }

            public RWStringField text8() {
                return new RWStringField(getContext().getData(), "text8");
            }

            public RWStringField text9() {
                return new RWStringField(getContext().getData(), "text9");
            }

            public RWStringField text10() {
                return new RWStringField(getContext().getData(), "text10");
            }

            public RWStringField substitute1() {
                return new RWStringField(getContext().getData(), "substitute1");
            }

            public RWStringField substitute2() {
                return new RWStringField(getContext().getData(), "substitute2");
            }

            public RWStringField substitute3() {
                return new RWStringField(getContext().getData(), "substitute3");
            }

            public RWStringField substitute4() {
                return new RWStringField(getContext().getData(), "substitute4");
            }

            public RWStringField substitute5() {
                return new RWStringField(getContext().getData(), "substitute5");
            }

            public RWStringField vacationCalendarNumber() {
                return new RWStringField(getContext().getData(), "vacationcalendarnumber");
            }

            public RStringField approvalGroupInstanceKey() {
                return new RStringField(getContext().getData(), "approvalgroupinstancekey");
            }

            public RWStringField templateEmployeeNumber() {
                return new RWStringField(getContext().getData(), "templateemployeenumber");
            }

            public RWStringField linkingRuleName() {
                return new RWStringField(getContext().getData(), "linkingrulename");
            }

            public RStringField accessLevelDescriptionVar() {
                return new RStringField(getContext().getData(), "accessleveldescriptionvar");
            }

            public RStringField superiorEmployeeName() {
                return new RStringField(getContext().getData(), "superioremployeename");
            }

            public RStringField secretaryEmployeeName() {
                return new RStringField(getContext().getData(), "secretaryemployeename");
            }

            public RStringField tutorEmployeeNameVar() {
                return new RStringField(getContext().getData(), "tutoremployeenamevar");
            }

            public RStringField absenceApproverNameVar() {
                return new RStringField(getContext().getData(), "absenceapprovernamevar");
            }

            public RStringField substitute1EmployeeNameVar() {
                return new RStringField(getContext().getData(), "substitute1employeenamevar");
            }

            public RStringField substitute2EmployeeNameVar() {
                return new RStringField(getContext().getData(), "substitute2employeenamevar");
            }

            public RStringField substitute3EmployeeNameVar() {
                return new RStringField(getContext().getData(), "substitute3employeenamevar");
            }

            public RStringField substitute4EmployeeNameVar() {
                return new RStringField(getContext().getData(), "substitute4employeenamevar");
            }

            public RStringField substitute5EmployeeNameVar() {
                return new RStringField(getContext().getData(), "substitute5employeenamevar");
            }

            public RStringField vendorName1Var() {
                return new RStringField(getContext().getData(), "vendorname1var");
            }

            public RStringField subcontractorVendorName1Var() {
                return new RStringField(getContext().getData(), "subcontractorvendorname1var");
            }

            public RStringField documentDescriptionVar() {
                return new RStringField(getContext().getData(), "documentdescriptionvar");
            }

            public RStringField dimensionCombDescriptionVar() {
                return new RStringField(getContext().getData(), "dimensioncombdescriptionvar");
            }

            public RStringField companyNameVar() {
                return new RStringField(getContext().getData(), "companynamevar");
            }

            public RStringField locationDescriptionVar() {
                return new RStringField(getContext().getData(), "locationdescriptionvar");
            }

            public RStringField entityDescriptionVar() {
                return new RStringField(getContext().getData(), "entitydescriptionvar");
            }

            public RStringField projectDescriptionVar() {
                return new RStringField(getContext().getData(), "projectdescriptionvar");
            }

            public RStringField purposeDescriptionVar() {
                return new RStringField(getContext().getData(), "purposedescriptionvar");
            }

            public RStringField specification1DescriptionVar() {
                return new RStringField(getContext().getData(), "specification1descriptionvar");
            }

            public RStringField specification2DescriptionVar() {
                return new RStringField(getContext().getData(), "specification2descriptionvar");
            }

            public RStringField specification3DescriptionVar() {
                return new RStringField(getContext().getData(), "specification3descriptionvar");
            }

            public RStringField localSpec1DescriptionVar() {
                return new RStringField(getContext().getData(), "localspec1descriptionvar");
            }

            public RStringField localSpec2DescriptionVar() {
                return new RStringField(getContext().getData(), "localspec2descriptionvar");
            }

            public RStringField localSpec3DescriptionVar() {
                return new RStringField(getContext().getData(), "localspec3descriptionvar");
            }

            public RStringField vacationCalendarDescriptionVar() {
                return new RStringField(getContext().getData(), "vacationcalendardescriptionvar");
            }

            public RStringField ageVar() {
                return new RStringField(getContext().getData(), "agevar");
            }

            public RWStringField pensionAgeVar() {
                return new RWStringField(getContext().getData(), "pensionagevar");
            }

            public RStringField currentDimensionCombNumberVar() {
                return new RStringField(getContext().getData(), "currentdimensioncombnumbervar");
            }

            public RStringField currentAccountNumberVar() {
                return new RStringField(getContext().getData(), "currentaccountnumbervar");
            }

            public RStringField currentLocationNameVar() {
                return new RStringField(getContext().getData(), "currentlocationnamevar");
            }

            public RStringField currentEntityNameVar() {
                return new RStringField(getContext().getData(), "currententitynamevar");
            }

            public RStringField currentProjectNameVar() {
                return new RStringField(getContext().getData(), "currentprojectnamevar");
            }

            public RStringField currentPurposeNameVar() {
                return new RStringField(getContext().getData(), "currentpurposenamevar");
            }

            public RStringField currentSpecification1NameVar() {
                return new RStringField(getContext().getData(), "currentspecification1namevar");
            }

            public RStringField currentSpecification2NameVar() {
                return new RStringField(getContext().getData(), "currentspecification2namevar");
            }

            public RStringField currentSpecification3NameVar() {
                return new RStringField(getContext().getData(), "currentspecification3namevar");
            }

            public RStringField currentLocalSpec1NameVar() {
                return new RStringField(getContext().getData(), "currentlocalspec1namevar");
            }

            public RStringField currentLocalSpec2NameVar() {
                return new RStringField(getContext().getData(), "currentlocalspec2namevar");
            }

            public RStringField currentLocalSpec3NameVar() {
                return new RStringField(getContext().getData(), "currentlocalspec3namevar");
            }

            public RStringField currentCompanyNameVar() {
                return new RStringField(getContext().getData(), "currentcompanynamevar");
            }

            public RStringField currentDimensionCombDescriptionVar() {
                return new RStringField(getContext().getData(), "currentdimensioncombdescriptionvar");
            }

            public RStringField currentAccountTextVar() {
                return new RStringField(getContext().getData(), "currentaccounttextvar");
            }

            public RStringField currentLocationDescriptionVar() {
                return new RStringField(getContext().getData(), "currentlocationdescriptionvar");
            }

            public RStringField currentEntityDescriptionVar() {
                return new RStringField(getContext().getData(), "currententitydescriptionvar");
            }

            public RStringField currentProjectDescriptionVar() {
                return new RStringField(getContext().getData(), "currentprojectdescriptionvar");
            }

            public RStringField currentPurposeDescriptionVar() {
                return new RStringField(getContext().getData(), "currentpurposedescriptionvar");
            }

            public RStringField currentSpecification1DescriptionVar() {
                return new RStringField(getContext().getData(), "currentspecification1descriptionvar");
            }

            public RStringField currentSpecification2DescriptionVar() {
                return new RStringField(getContext().getData(), "currentspecification2descriptionvar");
            }

            public RStringField currentSpecification3DescriptionVar() {
                return new RStringField(getContext().getData(), "currentspecification3descriptionvar");
            }

            public RStringField currentLocalSpec1DescriptionVar() {
                return new RStringField(getContext().getData(), "currentlocalspec1descriptionvar");
            }

            public RStringField currentLocalSpec2DescriptionVar() {
                return new RStringField(getContext().getData(), "currentlocalspec2descriptionvar");
            }

            public RStringField currentLocalSpec3DescriptionVar() {
                return new RStringField(getContext().getData(), "currentlocalspec3descriptionvar");
            }

            public RStringField purchaseOrderDescriptionVar() {
                return new RStringField(getContext().getData(), "purchaseorderdescriptionvar");
            }

            public RStringField imageReferenceVar() {
                return new RStringField(getContext().getData(), "imagereferencevar");
            }

            public RWStringField createFromEmployeeNumberVar() {
                return new RWStringField(getContext().getData(), "createfromemployeenumbervar");
            }

            public RStringField templateEmployeeNameVar() {
                return new RStringField(getContext().getData(), "templateemployeenamevar");
            }

            public RStringField headerCurrentApprovalStatusDescriptionVar() {
                return new RStringField(getContext().getData(), "headercurrentapprovalstatusdescriptionvar");
            }

            public RWStringField createUserTypeVar() {
                return new RWStringField(getContext().getData(), "createusertypevar");
            }

            public RWStringField createUserNameVar() {
                return new RWStringField(getContext().getData(), "createusernamevar");
            }

            public RStringField aCCOUNTTEXTVAR() {
                return new RStringField(getContext().getData(), "accounttextvar");
            }
        }

        public static class Record
            extends BaseCardTableRecord<com.deltek.integration.maconomy.psorestclient.Employees.Card>
            implements IRecord
        {

            private Record(final IHasClient iHasClient, final CardTableRecord cardTableRecord) {
                super(iHasClient, cardTableRecord, cardTableData -> {
                    return new com.deltek.integration.maconomy.psorestclient.Employees.Card(iHasClient, cardTableData);
                }
                );
            }

            public RStringField employeeNumber() {
                return new RStringField(getContext().getData(), "employeenumber");
            }

            public RWStringField name1() {
                return new RWStringField(getContext().getData(), "name1");
            }

            public RWStringField name2() {
                return new RWStringField(getContext().getData(), "name2");
            }

            public RWStringField name3() {
                return new RWStringField(getContext().getData(), "name3");
            }

            public RWStringField name4() {
                return new RWStringField(getContext().getData(), "name4");
            }

            public RWStringField name5() {
                return new RWStringField(getContext().getData(), "name5");
            }

            public RWStringField telephone() {
                return new RWStringField(getContext().getData(), "telephone");
            }

            public RWStringField cNRNumber() {
                return new RWStringField(getContext().getData(), "cnrnumber");
            }

            public RWStringField itemNumber() {
                return new RWStringField(getContext().getData(), "itemnumber");
            }

            public RStringField createdBy() {
                return new RStringField(getContext().getData(), "createdby");
            }

            public RStringField changedBy() {
                return new RStringField(getContext().getData(), "changedby");
            }

            public RWStringField commissionAccount() {
                return new RWStringField(getContext().getData(), "commissionaccount");
            }

            public RWStringField commissionSetOffAccount() {
                return new RWStringField(getContext().getData(), "commissionsetoffaccount");
            }

            public RWStringField zipCode() {
                return new RWStringField(getContext().getData(), "zipcode");
            }

            public RWStringField postalDistrict() {
                return new RWStringField(getContext().getData(), "postaldistrict");
            }

            public RWStringField profession() {
                return new RWStringField(getContext().getData(), "profession");
            }

            public RWStringField education() {
                return new RWStringField(getContext().getData(), "education");
            }

            public RWStringField position() {
                return new RWStringField(getContext().getData(), "position");
            }

            public RWStringField bank() {
                return new RWStringField(getContext().getData(), "bank");
            }

            public RWStringField registrationNumber() {
                return new RWStringField(getContext().getData(), "registrationnumber");
            }

            public RWStringField bankAccountNumber() {
                return new RWStringField(getContext().getData(), "bankaccountnumber");
            }

            public RWStringField basicSalaryCode() {
                return new RWStringField(getContext().getData(), "basicsalarycode");
            }

            public RWStringField salarySupplementCode() {
                return new RWStringField(getContext().getData(), "salarysupplementcode");
            }

            public RWStringField overtimeRateCode() {
                return new RWStringField(getContext().getData(), "overtimeratecode");
            }

            public RWStringField pensionTypeCompany() {
                return new RWStringField(getContext().getData(), "pensiontypecompany");
            }

            public RWStringField pensionTypeOwn() {
                return new RWStringField(getContext().getData(), "pensiontypeown");
            }

            public RWStringField remark1() {
                return new RWStringField(getContext().getData(), "remark1");
            }

            public RWStringField remark2() {
                return new RWStringField(getContext().getData(), "remark2");
            }

            public RWStringField remark3() {
                return new RWStringField(getContext().getData(), "remark3");
            }

            public RWStringField remark4() {
                return new RWStringField(getContext().getData(), "remark4");
            }

            public RWStringField remark5() {
                return new RWStringField(getContext().getData(), "remark5");
            }

            public RWStringField superiorEmployee() {
                return new RWStringField(getContext().getData(), "superioremployee");
            }

            public RWStringField locationName() {
                return new RWStringField(getContext().getData(), "locationname");
            }

            public RWStringField entityName() {
                return new RWStringField(getContext().getData(), "entityname");
            }

            public RWStringField projectName() {
                return new RWStringField(getContext().getData(), "projectname");
            }

            public RStringField serviceInventoryName() {
                return new RStringField(getContext().getData(), "serviceinventoryname");
            }

            public RWStringField secretaryEmployee() {
                return new RWStringField(getContext().getData(), "secretaryemployee");
            }

            public RWStringField specification1Name() {
                return new RWStringField(getContext().getData(), "specification1name");
            }

            public RWStringField specification2Name() {
                return new RWStringField(getContext().getData(), "specification2name");
            }

            public RWStringField specification3Name() {
                return new RWStringField(getContext().getData(), "specification3name");
            }

            public RWStringField purposeName() {
                return new RWStringField(getContext().getData(), "purposename");
            }

            public RWStringField companyNumber() {
                return new RWStringField(getContext().getData(), "companynumber");
            }

            public RWStringField localSpec1Name() {
                return new RWStringField(getContext().getData(), "localspec1name");
            }

            public RWStringField localSpec2Name() {
                return new RWStringField(getContext().getData(), "localspec2name");
            }

            public RWStringField localSpec3Name() {
                return new RWStringField(getContext().getData(), "localspec3name");
            }

            public RWStringField weekCalendarNumber() {
                return new RWStringField(getContext().getData(), "weekcalendarnumber");
            }

            public RWStringField jobPriceGroupNumber() {
                return new RWStringField(getContext().getData(), "jobpricegroupnumber");
            }

            public RWStringField statistic1() {
                return new RWStringField(getContext().getData(), "statistic1");
            }

            public RWStringField statistic2() {
                return new RWStringField(getContext().getData(), "statistic2");
            }

            public RWStringField statistic3() {
                return new RWStringField(getContext().getData(), "statistic3");
            }

            public RWStringField statistic4() {
                return new RWStringField(getContext().getData(), "statistic4");
            }

            public RWStringField vendorNumber() {
                return new RWStringField(getContext().getData(), "vendornumber");
            }

            public RWStringField accessLevelName() {
                return new RWStringField(getContext().getData(), "accesslevelname");
            }

            public RWStringField primaryEmployeeCategoryNumber() {
                return new RWStringField(getContext().getData(), "primaryemployeecategorynumber");
            }

            public RWStringField dimensionCombNumber() {
                return new RWStringField(getContext().getData(), "dimensioncombnumber");
            }

            public RWStringField documentArchiveNumber() {
                return new RWStringField(getContext().getData(), "documentarchivenumber");
            }

            public RWStringField electronicMailAddress() {
                return new RWStringField(getContext().getData(), "electronicmailaddress");
            }

            public RStringField dimCombVersionNumber() {
                return new RStringField(getContext().getData(), "dimcombversionnumber");
            }

            public RWStringField accountNumber() {
                return new RWStringField(getContext().getData(), "accountnumber");
            }

            public RStringField instanceKey() {
                return new RStringField(getContext().getData(), "instancekey");
            }

            public RStringField contactPersonNumber() {
                return new RStringField(getContext().getData(), "contactpersonnumber");
            }

            public RWStringField initials() {
                return new RWStringField(getContext().getData(), "initials");
            }

            public RWStringField mobilePhone() {
                return new RWStringField(getContext().getData(), "mobilephone");
            }

            public RWStringField mobilePhone2() {
                return new RWStringField(getContext().getData(), "mobilephone2");
            }

            public RWStringField telephone2() {
                return new RWStringField(getContext().getData(), "telephone2");
            }

            public RWStringField optionListNumber1() {
                return new RWStringField(getContext().getData(), "optionlistnumber1");
            }

            public RWStringField selectedOption1() {
                return new RWStringField(getContext().getData(), "selectedoption1");
            }

            public RWStringField optionListNumber2() {
                return new RWStringField(getContext().getData(), "optionlistnumber2");
            }

            public RWStringField selectedOption2() {
                return new RWStringField(getContext().getData(), "selectedoption2");
            }

            public RWStringField optionListNumber3() {
                return new RWStringField(getContext().getData(), "optionlistnumber3");
            }

            public RWStringField selectedOption3() {
                return new RWStringField(getContext().getData(), "selectedoption3");
            }

            public RWStringField optionListNumber4() {
                return new RWStringField(getContext().getData(), "optionlistnumber4");
            }

            public RWStringField selectedOption4() {
                return new RWStringField(getContext().getData(), "selectedoption4");
            }

            public RWStringField optionListNumber5() {
                return new RWStringField(getContext().getData(), "optionlistnumber5");
            }

            public RWStringField selectedOption5() {
                return new RWStringField(getContext().getData(), "selectedoption5");
            }

            public RWStringField optionListNumber6() {
                return new RWStringField(getContext().getData(), "optionlistnumber6");
            }

            public RWStringField selectedOption6() {
                return new RWStringField(getContext().getData(), "selectedoption6");
            }

            public RWStringField optionListNumber7() {
                return new RWStringField(getContext().getData(), "optionlistnumber7");
            }

            public RWStringField selectedOption7() {
                return new RWStringField(getContext().getData(), "selectedoption7");
            }

            public RWStringField optionListNumber8() {
                return new RWStringField(getContext().getData(), "optionlistnumber8");
            }

            public RWStringField selectedOption8() {
                return new RWStringField(getContext().getData(), "selectedoption8");
            }

            public RWStringField optionListNumber9() {
                return new RWStringField(getContext().getData(), "optionlistnumber9");
            }

            public RWStringField selectedOption9() {
                return new RWStringField(getContext().getData(), "selectedoption9");
            }

            public RWStringField optionListNumber10() {
                return new RWStringField(getContext().getData(), "optionlistnumber10");
            }

            public RWStringField selectedOption10() {
                return new RWStringField(getContext().getData(), "selectedoption10");
            }

            public RWStringField text1() {
                return new RWStringField(getContext().getData(), "text1");
            }

            public RWStringField text2() {
                return new RWStringField(getContext().getData(), "text2");
            }

            public RWStringField text3() {
                return new RWStringField(getContext().getData(), "text3");
            }

            public RWStringField text4() {
                return new RWStringField(getContext().getData(), "text4");
            }

            public RWStringField text5() {
                return new RWStringField(getContext().getData(), "text5");
            }

            public RStringField purchaseOrderNumber() {
                return new RStringField(getContext().getData(), "purchaseordernumber");
            }

            public RWStringField absenceApprover() {
                return new RWStringField(getContext().getData(), "absenceapprover");
            }

            public RWStringField tutorEmployee() {
                return new RWStringField(getContext().getData(), "tutoremployee");
            }

            public RStringField transactionTimestamp() {
                return new RStringField(getContext().getData(), "transactiontimestamp");
            }

            public RWStringField subcontractorVendorNumber() {
                return new RWStringField(getContext().getData(), "subcontractorvendornumber");
            }

            public RWStringField text6() {
                return new RWStringField(getContext().getData(), "text6");
            }

            public RWStringField text7() {
                return new RWStringField(getContext().getData(), "text7");
            }

            public RWStringField text8() {
                return new RWStringField(getContext().getData(), "text8");
            }

            public RWStringField text9() {
                return new RWStringField(getContext().getData(), "text9");
            }

            public RWStringField text10() {
                return new RWStringField(getContext().getData(), "text10");
            }

            public RWStringField substitute1() {
                return new RWStringField(getContext().getData(), "substitute1");
            }

            public RWStringField substitute2() {
                return new RWStringField(getContext().getData(), "substitute2");
            }

            public RWStringField substitute3() {
                return new RWStringField(getContext().getData(), "substitute3");
            }

            public RWStringField substitute4() {
                return new RWStringField(getContext().getData(), "substitute4");
            }

            public RWStringField substitute5() {
                return new RWStringField(getContext().getData(), "substitute5");
            }

            public RWStringField vacationCalendarNumber() {
                return new RWStringField(getContext().getData(), "vacationcalendarnumber");
            }

            public RStringField approvalGroupInstanceKey() {
                return new RStringField(getContext().getData(), "approvalgroupinstancekey");
            }

            public RWStringField templateEmployeeNumber() {
                return new RWStringField(getContext().getData(), "templateemployeenumber");
            }

            public RWStringField linkingRuleName() {
                return new RWStringField(getContext().getData(), "linkingrulename");
            }

            public RStringField accessLevelDescriptionVar() {
                return new RStringField(getContext().getData(), "accessleveldescriptionvar");
            }

            public RStringField superiorEmployeeName() {
                return new RStringField(getContext().getData(), "superioremployeename");
            }

            public RStringField secretaryEmployeeName() {
                return new RStringField(getContext().getData(), "secretaryemployeename");
            }

            public RStringField tutorEmployeeNameVar() {
                return new RStringField(getContext().getData(), "tutoremployeenamevar");
            }

            public RStringField absenceApproverNameVar() {
                return new RStringField(getContext().getData(), "absenceapprovernamevar");
            }

            public RStringField substitute1EmployeeNameVar() {
                return new RStringField(getContext().getData(), "substitute1employeenamevar");
            }

            public RStringField substitute2EmployeeNameVar() {
                return new RStringField(getContext().getData(), "substitute2employeenamevar");
            }

            public RStringField substitute3EmployeeNameVar() {
                return new RStringField(getContext().getData(), "substitute3employeenamevar");
            }

            public RStringField substitute4EmployeeNameVar() {
                return new RStringField(getContext().getData(), "substitute4employeenamevar");
            }

            public RStringField substitute5EmployeeNameVar() {
                return new RStringField(getContext().getData(), "substitute5employeenamevar");
            }

            public RStringField vendorName1Var() {
                return new RStringField(getContext().getData(), "vendorname1var");
            }

            public RStringField subcontractorVendorName1Var() {
                return new RStringField(getContext().getData(), "subcontractorvendorname1var");
            }

            public RStringField documentDescriptionVar() {
                return new RStringField(getContext().getData(), "documentdescriptionvar");
            }

            public RStringField dimensionCombDescriptionVar() {
                return new RStringField(getContext().getData(), "dimensioncombdescriptionvar");
            }

            public RStringField companyNameVar() {
                return new RStringField(getContext().getData(), "companynamevar");
            }

            public RStringField locationDescriptionVar() {
                return new RStringField(getContext().getData(), "locationdescriptionvar");
            }

            public RStringField entityDescriptionVar() {
                return new RStringField(getContext().getData(), "entitydescriptionvar");
            }

            public RStringField projectDescriptionVar() {
                return new RStringField(getContext().getData(), "projectdescriptionvar");
            }

            public RStringField purposeDescriptionVar() {
                return new RStringField(getContext().getData(), "purposedescriptionvar");
            }

            public RStringField specification1DescriptionVar() {
                return new RStringField(getContext().getData(), "specification1descriptionvar");
            }

            public RStringField specification2DescriptionVar() {
                return new RStringField(getContext().getData(), "specification2descriptionvar");
            }

            public RStringField specification3DescriptionVar() {
                return new RStringField(getContext().getData(), "specification3descriptionvar");
            }

            public RStringField localSpec1DescriptionVar() {
                return new RStringField(getContext().getData(), "localspec1descriptionvar");
            }

            public RStringField localSpec2DescriptionVar() {
                return new RStringField(getContext().getData(), "localspec2descriptionvar");
            }

            public RStringField localSpec3DescriptionVar() {
                return new RStringField(getContext().getData(), "localspec3descriptionvar");
            }

            public RStringField vacationCalendarDescriptionVar() {
                return new RStringField(getContext().getData(), "vacationcalendardescriptionvar");
            }

            public RStringField ageVar() {
                return new RStringField(getContext().getData(), "agevar");
            }

            public RWStringField pensionAgeVar() {
                return new RWStringField(getContext().getData(), "pensionagevar");
            }

            public RStringField currentDimensionCombNumberVar() {
                return new RStringField(getContext().getData(), "currentdimensioncombnumbervar");
            }

            public RStringField currentAccountNumberVar() {
                return new RStringField(getContext().getData(), "currentaccountnumbervar");
            }

            public RStringField currentLocationNameVar() {
                return new RStringField(getContext().getData(), "currentlocationnamevar");
            }

            public RStringField currentEntityNameVar() {
                return new RStringField(getContext().getData(), "currententitynamevar");
            }

            public RStringField currentProjectNameVar() {
                return new RStringField(getContext().getData(), "currentprojectnamevar");
            }

            public RStringField currentPurposeNameVar() {
                return new RStringField(getContext().getData(), "currentpurposenamevar");
            }

            public RStringField currentSpecification1NameVar() {
                return new RStringField(getContext().getData(), "currentspecification1namevar");
            }

            public RStringField currentSpecification2NameVar() {
                return new RStringField(getContext().getData(), "currentspecification2namevar");
            }

            public RStringField currentSpecification3NameVar() {
                return new RStringField(getContext().getData(), "currentspecification3namevar");
            }

            public RStringField currentLocalSpec1NameVar() {
                return new RStringField(getContext().getData(), "currentlocalspec1namevar");
            }

            public RStringField currentLocalSpec2NameVar() {
                return new RStringField(getContext().getData(), "currentlocalspec2namevar");
            }

            public RStringField currentLocalSpec3NameVar() {
                return new RStringField(getContext().getData(), "currentlocalspec3namevar");
            }

            public RStringField currentCompanyNameVar() {
                return new RStringField(getContext().getData(), "currentcompanynamevar");
            }

            public RStringField currentDimensionCombDescriptionVar() {
                return new RStringField(getContext().getData(), "currentdimensioncombdescriptionvar");
            }

            public RStringField currentAccountTextVar() {
                return new RStringField(getContext().getData(), "currentaccounttextvar");
            }

            public RStringField currentLocationDescriptionVar() {
                return new RStringField(getContext().getData(), "currentlocationdescriptionvar");
            }

            public RStringField currentEntityDescriptionVar() {
                return new RStringField(getContext().getData(), "currententitydescriptionvar");
            }

            public RStringField currentProjectDescriptionVar() {
                return new RStringField(getContext().getData(), "currentprojectdescriptionvar");
            }

            public RStringField currentPurposeDescriptionVar() {
                return new RStringField(getContext().getData(), "currentpurposedescriptionvar");
            }

            public RStringField currentSpecification1DescriptionVar() {
                return new RStringField(getContext().getData(), "currentspecification1descriptionvar");
            }

            public RStringField currentSpecification2DescriptionVar() {
                return new RStringField(getContext().getData(), "currentspecification2descriptionvar");
            }

            public RStringField currentSpecification3DescriptionVar() {
                return new RStringField(getContext().getData(), "currentspecification3descriptionvar");
            }

            public RStringField currentLocalSpec1DescriptionVar() {
                return new RStringField(getContext().getData(), "currentlocalspec1descriptionvar");
            }

            public RStringField currentLocalSpec2DescriptionVar() {
                return new RStringField(getContext().getData(), "currentlocalspec2descriptionvar");
            }

            public RStringField currentLocalSpec3DescriptionVar() {
                return new RStringField(getContext().getData(), "currentlocalspec3descriptionvar");
            }

            public RStringField purchaseOrderDescriptionVar() {
                return new RStringField(getContext().getData(), "purchaseorderdescriptionvar");
            }

            public RStringField imageReferenceVar() {
                return new RStringField(getContext().getData(), "imagereferencevar");
            }

            public RStringField createFromEmployeeNumberVar() {
                return new RStringField(getContext().getData(), "createfromemployeenumbervar");
            }

            public RStringField templateEmployeeNameVar() {
                return new RStringField(getContext().getData(), "templateemployeenamevar");
            }

            public RStringField headerCurrentApprovalStatusDescriptionVar() {
                return new RStringField(getContext().getData(), "headercurrentapprovalstatusdescriptionvar");
            }

            public RStringField createUserTypeVar() {
                return new RStringField(getContext().getData(), "createusertypevar");
            }

            public RStringField createUserNameVar() {
                return new RStringField(getContext().getData(), "createusernamevar");
            }

            public RStringField aCCOUNTTEXTVAR() {
                return new RStringField(getContext().getData(), "accounttextvar");
            }
        }
    }

    public static class Filter
        extends BaseFilterPane<Employees.Filter.InitRecord, Employees.Filter.Record>
    {

        private Filter(final IHasClient iHasClient, final FilterData filterData) {
            super(iHasClient, filterData, initRecord -> {
                return new Employees.Filter.InitRecord(iHasClient, initRecord);
            }
            , record -> {
                return new Employees.Filter.Record(iHasClient, record);
            }
            );
        }

        public static class InitRecord
            extends BaseRecord<FilterRecord>
            implements IInitRecord
        {

            private InitRecord(final IHasClient iHasClient, final FilterRecord filterRecord) {
                super(iHasClient, filterRecord);
            }

            public RStringField employeeNumber() {
                return new RStringField(getContext().getData(), "employeenumber");
            }

            public RStringField name1() {
                return new RStringField(getContext().getData(), "name1");
            }

            public RStringField name2() {
                return new RStringField(getContext().getData(), "name2");
            }

            public RStringField name3() {
                return new RStringField(getContext().getData(), "name3");
            }

            public RStringField zipCode() {
                return new RStringField(getContext().getData(), "zipcode");
            }

            public RStringField postalDistrict() {
                return new RStringField(getContext().getData(), "postaldistrict");
            }

            public RStringField name4() {
                return new RStringField(getContext().getData(), "name4");
            }

            public RStringField name5() {
                return new RStringField(getContext().getData(), "name5");
            }

            public RStringField telephone() {
                return new RStringField(getContext().getData(), "telephone");
            }

            public RStringField electronicMailAddress() {
                return new RStringField(getContext().getData(), "electronicmailaddress");
            }

            public RStringField cNRNumber() {
                return new RStringField(getContext().getData(), "cnrnumber");
            }

            public RStringField companyNumber() {
                return new RStringField(getContext().getData(), "companynumber");
            }

            public RStringField position() {
                return new RStringField(getContext().getData(), "position");
            }

            public RStringField profession() {
                return new RStringField(getContext().getData(), "profession");
            }

            public RStringField education() {
                return new RStringField(getContext().getData(), "education");
            }

            public RStringField primaryEmployeeCategoryNumber() {
                return new RStringField(getContext().getData(), "primaryemployeecategorynumber");
            }

            public RStringField dimensionCombNumber() {
                return new RStringField(getContext().getData(), "dimensioncombnumber");
            }

            public RStringField accountNumber() {
                return new RStringField(getContext().getData(), "accountnumber");
            }

            public RStringField locationName() {
                return new RStringField(getContext().getData(), "locationname");
            }

            public RStringField entityName() {
                return new RStringField(getContext().getData(), "entityname");
            }

            public RStringField projectName() {
                return new RStringField(getContext().getData(), "projectname");
            }

            public RStringField purposeName() {
                return new RStringField(getContext().getData(), "purposename");
            }

            public RStringField specification1Name() {
                return new RStringField(getContext().getData(), "specification1name");
            }

            public RStringField specification2Name() {
                return new RStringField(getContext().getData(), "specification2name");
            }

            public RStringField specification3Name() {
                return new RStringField(getContext().getData(), "specification3name");
            }

            public RStringField localSpec1Name() {
                return new RStringField(getContext().getData(), "localspec1name");
            }

            public RStringField localSpec2Name() {
                return new RStringField(getContext().getData(), "localspec2name");
            }

            public RStringField localSpec3Name() {
                return new RStringField(getContext().getData(), "localspec3name");
            }

            public RStringField superiorEmployee() {
                return new RStringField(getContext().getData(), "superioremployee");
            }

            public RStringField secretaryEmployee() {
                return new RStringField(getContext().getData(), "secretaryemployee");
            }

            public RStringField vendorNumber() {
                return new RStringField(getContext().getData(), "vendornumber");
            }

            public RStringField commissionAccount() {
                return new RStringField(getContext().getData(), "commissionaccount");
            }

            public RStringField commissionSetOffAccount() {
                return new RStringField(getContext().getData(), "commissionsetoffaccount");
            }

            public RStringField itemNumber() {
                return new RStringField(getContext().getData(), "itemnumber");
            }

            public RStringField jobPriceGroupNumber() {
                return new RStringField(getContext().getData(), "jobpricegroupnumber");
            }

            public RStringField weekCalendarNumber() {
                return new RStringField(getContext().getData(), "weekcalendarnumber");
            }

            public RStringField documentArchiveNumber() {
                return new RStringField(getContext().getData(), "documentarchivenumber");
            }

            public RStringField remark1() {
                return new RStringField(getContext().getData(), "remark1");
            }

            public RStringField remark2() {
                return new RStringField(getContext().getData(), "remark2");
            }

            public RStringField remark3() {
                return new RStringField(getContext().getData(), "remark3");
            }

            public RStringField remark4() {
                return new RStringField(getContext().getData(), "remark4");
            }

            public RStringField remark5() {
                return new RStringField(getContext().getData(), "remark5");
            }

            public RStringField basicSalaryCode() {
                return new RStringField(getContext().getData(), "basicsalarycode");
            }

            public RStringField salarySupplementCode() {
                return new RStringField(getContext().getData(), "salarysupplementcode");
            }

            public RStringField overtimeRateCode() {
                return new RStringField(getContext().getData(), "overtimeratecode");
            }

            public RStringField bank() {
                return new RStringField(getContext().getData(), "bank");
            }

            public RStringField registrationNumber() {
                return new RStringField(getContext().getData(), "registrationnumber");
            }

            public RStringField bankAccountNumber() {
                return new RStringField(getContext().getData(), "bankaccountnumber");
            }

            public RStringField pensionTypeCompany() {
                return new RStringField(getContext().getData(), "pensiontypecompany");
            }

            public RStringField pensionTypeOwn() {
                return new RStringField(getContext().getData(), "pensiontypeown");
            }

            public RStringField statistic1() {
                return new RStringField(getContext().getData(), "statistic1");
            }

            public RStringField statistic2() {
                return new RStringField(getContext().getData(), "statistic2");
            }

            public RStringField statistic3() {
                return new RStringField(getContext().getData(), "statistic3");
            }

            public RStringField statistic4() {
                return new RStringField(getContext().getData(), "statistic4");
            }

            public RStringField createdBy() {
                return new RStringField(getContext().getData(), "createdby");
            }

            public RStringField changedBy() {
                return new RStringField(getContext().getData(), "changedby");
            }

            public RStringField accessLevelName() {
                return new RStringField(getContext().getData(), "accesslevelname");
            }

            public RStringField purchaseOrderNumber() {
                return new RStringField(getContext().getData(), "purchaseordernumber");
            }

            public RStringField absenceApprover() {
                return new RStringField(getContext().getData(), "absenceapprover");
            }

            public RStringField tutorEmployee() {
                return new RStringField(getContext().getData(), "tutoremployee");
            }

            public RStringField subcontractorVendorNumber() {
                return new RStringField(getContext().getData(), "subcontractorvendornumber");
            }

            public RStringField vacationCalendarNumber() {
                return new RStringField(getContext().getData(), "vacationcalendarnumber");
            }

            public RStringField substitute1() {
                return new RStringField(getContext().getData(), "substitute1");
            }

            public RStringField substitute2() {
                return new RStringField(getContext().getData(), "substitute2");
            }

            public RStringField substitute3() {
                return new RStringField(getContext().getData(), "substitute3");
            }

            public RStringField substitute4() {
                return new RStringField(getContext().getData(), "substitute4");
            }

            public RStringField substitute5() {
                return new RStringField(getContext().getData(), "substitute5");
            }

            public RStringField contactPersonNumber() {
                return new RStringField(getContext().getData(), "contactpersonnumber");
            }

            public RStringField initials() {
                return new RStringField(getContext().getData(), "initials");
            }

            public RStringField mobilePhone() {
                return new RStringField(getContext().getData(), "mobilephone");
            }

            public RStringField mobilePhone2() {
                return new RStringField(getContext().getData(), "mobilephone2");
            }

            public RStringField telephone2() {
                return new RStringField(getContext().getData(), "telephone2");
            }

            public RStringField optionListNumber1() {
                return new RStringField(getContext().getData(), "optionlistnumber1");
            }

            public RStringField selectedOption1() {
                return new RStringField(getContext().getData(), "selectedoption1");
            }

            public RStringField optionListNumber2() {
                return new RStringField(getContext().getData(), "optionlistnumber2");
            }

            public RStringField selectedOption2() {
                return new RStringField(getContext().getData(), "selectedoption2");
            }

            public RStringField optionListNumber3() {
                return new RStringField(getContext().getData(), "optionlistnumber3");
            }

            public RStringField selectedOption3() {
                return new RStringField(getContext().getData(), "selectedoption3");
            }

            public RStringField optionListNumber4() {
                return new RStringField(getContext().getData(), "optionlistnumber4");
            }

            public RStringField selectedOption4() {
                return new RStringField(getContext().getData(), "selectedoption4");
            }

            public RStringField optionListNumber5() {
                return new RStringField(getContext().getData(), "optionlistnumber5");
            }

            public RStringField selectedOption5() {
                return new RStringField(getContext().getData(), "selectedoption5");
            }

            public RStringField optionListNumber6() {
                return new RStringField(getContext().getData(), "optionlistnumber6");
            }

            public RStringField selectedOption6() {
                return new RStringField(getContext().getData(), "selectedoption6");
            }

            public RStringField optionListNumber7() {
                return new RStringField(getContext().getData(), "optionlistnumber7");
            }

            public RStringField selectedOption7() {
                return new RStringField(getContext().getData(), "selectedoption7");
            }

            public RStringField optionListNumber8() {
                return new RStringField(getContext().getData(), "optionlistnumber8");
            }

            public RStringField selectedOption8() {
                return new RStringField(getContext().getData(), "selectedoption8");
            }

            public RStringField optionListNumber9() {
                return new RStringField(getContext().getData(), "optionlistnumber9");
            }

            public RStringField selectedOption9() {
                return new RStringField(getContext().getData(), "selectedoption9");
            }

            public RStringField optionListNumber10() {
                return new RStringField(getContext().getData(), "optionlistnumber10");
            }

            public RStringField selectedOption10() {
                return new RStringField(getContext().getData(), "selectedoption10");
            }

            public RStringField text1() {
                return new RStringField(getContext().getData(), "text1");
            }

            public RStringField text2() {
                return new RStringField(getContext().getData(), "text2");
            }

            public RStringField text3() {
                return new RStringField(getContext().getData(), "text3");
            }

            public RStringField text4() {
                return new RStringField(getContext().getData(), "text4");
            }

            public RStringField text5() {
                return new RStringField(getContext().getData(), "text5");
            }

            public RStringField text6() {
                return new RStringField(getContext().getData(), "text6");
            }

            public RStringField text7() {
                return new RStringField(getContext().getData(), "text7");
            }

            public RStringField text8() {
                return new RStringField(getContext().getData(), "text8");
            }

            public RStringField text9() {
                return new RStringField(getContext().getData(), "text9");
            }

            public RStringField text10() {
                return new RStringField(getContext().getData(), "text10");
            }

            public RStringField templateEmployeeNumber() {
                return new RStringField(getContext().getData(), "templateemployeenumber");
            }

            public RStringField calculatedAbsenceType() {
                return new RStringField(getContext().getData(), "calculatedabsencetype");
            }

            public RStringField submittedBy() {
                return new RStringField(getContext().getData(), "submittedby");
            }

            public RStringField closedBy() {
                return new RStringField(getContext().getData(), "closedby");
            }

            public RStringField instanceKey() {
                return new RStringField(getContext().getData(), "instancekey");
            }

            public RStringField linkingRuleName() {
                return new RStringField(getContext().getData(), "linkingrulename");
            }
        }

        public static class Record
            extends BaseRecord<FilterRecord>
            implements IRecord
        {

            private Record(final IHasClient iHasClient, final FilterRecord filterRecord) {
                super(iHasClient, filterRecord);
            }

            public RStringField employeeNumber() {
                return new RStringField(getContext().getData(), "employeenumber");
            }

            public RStringField name1() {
                return new RStringField(getContext().getData(), "name1");
            }

            public RStringField name2() {
                return new RStringField(getContext().getData(), "name2");
            }

            public RStringField name3() {
                return new RStringField(getContext().getData(), "name3");
            }

            public RStringField zipCode() {
                return new RStringField(getContext().getData(), "zipcode");
            }

            public RStringField postalDistrict() {
                return new RStringField(getContext().getData(), "postaldistrict");
            }

            public RStringField name4() {
                return new RStringField(getContext().getData(), "name4");
            }

            public RStringField name5() {
                return new RStringField(getContext().getData(), "name5");
            }

            public RStringField telephone() {
                return new RStringField(getContext().getData(), "telephone");
            }

            public RStringField electronicMailAddress() {
                return new RStringField(getContext().getData(), "electronicmailaddress");
            }

            public RStringField cNRNumber() {
                return new RStringField(getContext().getData(), "cnrnumber");
            }

            public RStringField companyNumber() {
                return new RStringField(getContext().getData(), "companynumber");
            }

            public RStringField position() {
                return new RStringField(getContext().getData(), "position");
            }

            public RStringField profession() {
                return new RStringField(getContext().getData(), "profession");
            }

            public RStringField education() {
                return new RStringField(getContext().getData(), "education");
            }

            public RStringField primaryEmployeeCategoryNumber() {
                return new RStringField(getContext().getData(), "primaryemployeecategorynumber");
            }

            public RStringField dimensionCombNumber() {
                return new RStringField(getContext().getData(), "dimensioncombnumber");
            }

            public RStringField accountNumber() {
                return new RStringField(getContext().getData(), "accountnumber");
            }

            public RStringField locationName() {
                return new RStringField(getContext().getData(), "locationname");
            }

            public RStringField entityName() {
                return new RStringField(getContext().getData(), "entityname");
            }

            public RStringField projectName() {
                return new RStringField(getContext().getData(), "projectname");
            }

            public RStringField purposeName() {
                return new RStringField(getContext().getData(), "purposename");
            }

            public RStringField specification1Name() {
                return new RStringField(getContext().getData(), "specification1name");
            }

            public RStringField specification2Name() {
                return new RStringField(getContext().getData(), "specification2name");
            }

            public RStringField specification3Name() {
                return new RStringField(getContext().getData(), "specification3name");
            }

            public RStringField localSpec1Name() {
                return new RStringField(getContext().getData(), "localspec1name");
            }

            public RStringField localSpec2Name() {
                return new RStringField(getContext().getData(), "localspec2name");
            }

            public RStringField localSpec3Name() {
                return new RStringField(getContext().getData(), "localspec3name");
            }

            public RStringField superiorEmployee() {
                return new RStringField(getContext().getData(), "superioremployee");
            }

            public RStringField secretaryEmployee() {
                return new RStringField(getContext().getData(), "secretaryemployee");
            }

            public RStringField vendorNumber() {
                return new RStringField(getContext().getData(), "vendornumber");
            }

            public RStringField commissionAccount() {
                return new RStringField(getContext().getData(), "commissionaccount");
            }

            public RStringField commissionSetOffAccount() {
                return new RStringField(getContext().getData(), "commissionsetoffaccount");
            }

            public RStringField itemNumber() {
                return new RStringField(getContext().getData(), "itemnumber");
            }

            public RStringField jobPriceGroupNumber() {
                return new RStringField(getContext().getData(), "jobpricegroupnumber");
            }

            public RStringField weekCalendarNumber() {
                return new RStringField(getContext().getData(), "weekcalendarnumber");
            }

            public RStringField documentArchiveNumber() {
                return new RStringField(getContext().getData(), "documentarchivenumber");
            }

            public RStringField remark1() {
                return new RStringField(getContext().getData(), "remark1");
            }

            public RStringField remark2() {
                return new RStringField(getContext().getData(), "remark2");
            }

            public RStringField remark3() {
                return new RStringField(getContext().getData(), "remark3");
            }

            public RStringField remark4() {
                return new RStringField(getContext().getData(), "remark4");
            }

            public RStringField remark5() {
                return new RStringField(getContext().getData(), "remark5");
            }

            public RStringField basicSalaryCode() {
                return new RStringField(getContext().getData(), "basicsalarycode");
            }

            public RStringField salarySupplementCode() {
                return new RStringField(getContext().getData(), "salarysupplementcode");
            }

            public RStringField overtimeRateCode() {
                return new RStringField(getContext().getData(), "overtimeratecode");
            }

            public RStringField bank() {
                return new RStringField(getContext().getData(), "bank");
            }

            public RStringField registrationNumber() {
                return new RStringField(getContext().getData(), "registrationnumber");
            }

            public RStringField bankAccountNumber() {
                return new RStringField(getContext().getData(), "bankaccountnumber");
            }

            public RStringField pensionTypeCompany() {
                return new RStringField(getContext().getData(), "pensiontypecompany");
            }

            public RStringField pensionTypeOwn() {
                return new RStringField(getContext().getData(), "pensiontypeown");
            }

            public RStringField statistic1() {
                return new RStringField(getContext().getData(), "statistic1");
            }

            public RStringField statistic2() {
                return new RStringField(getContext().getData(), "statistic2");
            }

            public RStringField statistic3() {
                return new RStringField(getContext().getData(), "statistic3");
            }

            public RStringField statistic4() {
                return new RStringField(getContext().getData(), "statistic4");
            }

            public RStringField createdBy() {
                return new RStringField(getContext().getData(), "createdby");
            }

            public RStringField changedBy() {
                return new RStringField(getContext().getData(), "changedby");
            }

            public RStringField accessLevelName() {
                return new RStringField(getContext().getData(), "accesslevelname");
            }

            public RStringField purchaseOrderNumber() {
                return new RStringField(getContext().getData(), "purchaseordernumber");
            }

            public RStringField absenceApprover() {
                return new RStringField(getContext().getData(), "absenceapprover");
            }

            public RStringField tutorEmployee() {
                return new RStringField(getContext().getData(), "tutoremployee");
            }

            public RStringField subcontractorVendorNumber() {
                return new RStringField(getContext().getData(), "subcontractorvendornumber");
            }

            public RStringField vacationCalendarNumber() {
                return new RStringField(getContext().getData(), "vacationcalendarnumber");
            }

            public RStringField substitute1() {
                return new RStringField(getContext().getData(), "substitute1");
            }

            public RStringField substitute2() {
                return new RStringField(getContext().getData(), "substitute2");
            }

            public RStringField substitute3() {
                return new RStringField(getContext().getData(), "substitute3");
            }

            public RStringField substitute4() {
                return new RStringField(getContext().getData(), "substitute4");
            }

            public RStringField substitute5() {
                return new RStringField(getContext().getData(), "substitute5");
            }

            public RStringField contactPersonNumber() {
                return new RStringField(getContext().getData(), "contactpersonnumber");
            }

            public RStringField initials() {
                return new RStringField(getContext().getData(), "initials");
            }

            public RStringField mobilePhone() {
                return new RStringField(getContext().getData(), "mobilephone");
            }

            public RStringField mobilePhone2() {
                return new RStringField(getContext().getData(), "mobilephone2");
            }

            public RStringField telephone2() {
                return new RStringField(getContext().getData(), "telephone2");
            }

            public RStringField optionListNumber1() {
                return new RStringField(getContext().getData(), "optionlistnumber1");
            }

            public RStringField selectedOption1() {
                return new RStringField(getContext().getData(), "selectedoption1");
            }

            public RStringField optionListNumber2() {
                return new RStringField(getContext().getData(), "optionlistnumber2");
            }

            public RStringField selectedOption2() {
                return new RStringField(getContext().getData(), "selectedoption2");
            }

            public RStringField optionListNumber3() {
                return new RStringField(getContext().getData(), "optionlistnumber3");
            }

            public RStringField selectedOption3() {
                return new RStringField(getContext().getData(), "selectedoption3");
            }

            public RStringField optionListNumber4() {
                return new RStringField(getContext().getData(), "optionlistnumber4");
            }

            public RStringField selectedOption4() {
                return new RStringField(getContext().getData(), "selectedoption4");
            }

            public RStringField optionListNumber5() {
                return new RStringField(getContext().getData(), "optionlistnumber5");
            }

            public RStringField selectedOption5() {
                return new RStringField(getContext().getData(), "selectedoption5");
            }

            public RStringField optionListNumber6() {
                return new RStringField(getContext().getData(), "optionlistnumber6");
            }

            public RStringField selectedOption6() {
                return new RStringField(getContext().getData(), "selectedoption6");
            }

            public RStringField optionListNumber7() {
                return new RStringField(getContext().getData(), "optionlistnumber7");
            }

            public RStringField selectedOption7() {
                return new RStringField(getContext().getData(), "selectedoption7");
            }

            public RStringField optionListNumber8() {
                return new RStringField(getContext().getData(), "optionlistnumber8");
            }

            public RStringField selectedOption8() {
                return new RStringField(getContext().getData(), "selectedoption8");
            }

            public RStringField optionListNumber9() {
                return new RStringField(getContext().getData(), "optionlistnumber9");
            }

            public RStringField selectedOption9() {
                return new RStringField(getContext().getData(), "selectedoption9");
            }

            public RStringField optionListNumber10() {
                return new RStringField(getContext().getData(), "optionlistnumber10");
            }

            public RStringField selectedOption10() {
                return new RStringField(getContext().getData(), "selectedoption10");
            }

            public RStringField text1() {
                return new RStringField(getContext().getData(), "text1");
            }

            public RStringField text2() {
                return new RStringField(getContext().getData(), "text2");
            }

            public RStringField text3() {
                return new RStringField(getContext().getData(), "text3");
            }

            public RStringField text4() {
                return new RStringField(getContext().getData(), "text4");
            }

            public RStringField text5() {
                return new RStringField(getContext().getData(), "text5");
            }

            public RStringField text6() {
                return new RStringField(getContext().getData(), "text6");
            }

            public RStringField text7() {
                return new RStringField(getContext().getData(), "text7");
            }

            public RStringField text8() {
                return new RStringField(getContext().getData(), "text8");
            }

            public RStringField text9() {
                return new RStringField(getContext().getData(), "text9");
            }

            public RStringField text10() {
                return new RStringField(getContext().getData(), "text10");
            }

            public RStringField templateEmployeeNumber() {
                return new RStringField(getContext().getData(), "templateemployeenumber");
            }

            public RStringField calculatedAbsenceType() {
                return new RStringField(getContext().getData(), "calculatedabsencetype");
            }

            public RStringField submittedBy() {
                return new RStringField(getContext().getData(), "submittedby");
            }

            public RStringField closedBy() {
                return new RStringField(getContext().getData(), "closedby");
            }

            public RStringField instanceKey() {
                return new RStringField(getContext().getData(), "instancekey");
            }

            public RStringField linkingRuleName() {
                return new RStringField(getContext().getData(), "linkingrulename");
            }
        }
    }

    public static class Table
        extends BaseTablePane<Employees.Table.InitRecord, Employees.Table.Record>
    {

        private Table(final IHasClient iHasClient, final CardTableData cardTableData) {
            super(iHasClient, cardTableData, initRecord -> {
                return new Employees.Table.InitRecord(iHasClient, initRecord);
            }
            , record -> {
                return new Employees.Table.Record(iHasClient, record);
            }
            );
        }

        public static class InitRecord
            extends BaseCardTableRecord<com.deltek.integration.maconomy.psorestclient.Employees.Card>
            implements ICreateAction<com.deltek.integration.maconomy.psorestclient.Employees.Card> , IInitRecord
        {

            private InitRecord(final IHasClient iHasClient, final CardTableRecord cardTableRecord) {
                super(iHasClient, cardTableRecord, cardTableData -> {
                    return new com.deltek.integration.maconomy.psorestclient.Employees.Card(iHasClient, cardTableData);
                }
                );
            }

            public RWStringField employeeNumber() {
                return new RWStringField(getContext().getData(), "employeenumber");
            }

            public RStringField changeDescription() {
                return new RStringField(getContext().getData(), "changedescription");
            }

            public RStringField name1() {
                return new RStringField(getContext().getData(), "name1");
            }

            public RStringField name2() {
                return new RStringField(getContext().getData(), "name2");
            }

            public RStringField name3() {
                return new RStringField(getContext().getData(), "name3");
            }

            public RStringField name4() {
                return new RStringField(getContext().getData(), "name4");
            }

            public RStringField name5() {
                return new RStringField(getContext().getData(), "name5");
            }

            public RStringField telephone() {
                return new RStringField(getContext().getData(), "telephone");
            }

            public RStringField cNRNumber() {
                return new RStringField(getContext().getData(), "cnrnumber");
            }

            public RStringField itemNumber() {
                return new RStringField(getContext().getData(), "itemnumber");
            }

            public RStringField createdBy() {
                return new RStringField(getContext().getData(), "createdby");
            }

            public RStringField changedBy() {
                return new RStringField(getContext().getData(), "changedby");
            }

            public RStringField commissionAccount() {
                return new RStringField(getContext().getData(), "commissionaccount");
            }

            public RStringField commissionSetOffAccount() {
                return new RStringField(getContext().getData(), "commissionsetoffaccount");
            }

            public RStringField zipCode() {
                return new RStringField(getContext().getData(), "zipcode");
            }

            public RStringField postalDistrict() {
                return new RStringField(getContext().getData(), "postaldistrict");
            }

            public RStringField profession() {
                return new RStringField(getContext().getData(), "profession");
            }

            public RStringField education() {
                return new RStringField(getContext().getData(), "education");
            }

            public RStringField position() {
                return new RStringField(getContext().getData(), "position");
            }

            public RStringField bank() {
                return new RStringField(getContext().getData(), "bank");
            }

            public RStringField registrationNumber() {
                return new RStringField(getContext().getData(), "registrationnumber");
            }

            public RStringField bankAccountNumber() {
                return new RStringField(getContext().getData(), "bankaccountnumber");
            }

            public RStringField basicSalaryCode() {
                return new RStringField(getContext().getData(), "basicsalarycode");
            }

            public RStringField salarySupplementCode() {
                return new RStringField(getContext().getData(), "salarysupplementcode");
            }

            public RStringField overtimeRateCode() {
                return new RStringField(getContext().getData(), "overtimeratecode");
            }

            public RStringField pensionTypeCompany() {
                return new RStringField(getContext().getData(), "pensiontypecompany");
            }

            public RStringField pensionTypeOwn() {
                return new RStringField(getContext().getData(), "pensiontypeown");
            }

            public RStringField remark1() {
                return new RStringField(getContext().getData(), "remark1");
            }

            public RStringField remark2() {
                return new RStringField(getContext().getData(), "remark2");
            }

            public RStringField remark3() {
                return new RStringField(getContext().getData(), "remark3");
            }

            public RStringField remark4() {
                return new RStringField(getContext().getData(), "remark4");
            }

            public RStringField remark5() {
                return new RStringField(getContext().getData(), "remark5");
            }

            public RStringField superiorEmployee() {
                return new RStringField(getContext().getData(), "superioremployee");
            }

            public RStringField serviceInventoryName() {
                return new RStringField(getContext().getData(), "serviceinventoryname");
            }

            public RStringField secretaryEmployee() {
                return new RStringField(getContext().getData(), "secretaryemployee");
            }

            public RStringField weekCalendarNumber() {
                return new RStringField(getContext().getData(), "weekcalendarnumber");
            }

            public RStringField jobPriceGroupNumber() {
                return new RStringField(getContext().getData(), "jobpricegroupnumber");
            }

            public RStringField statistic1() {
                return new RStringField(getContext().getData(), "statistic1");
            }

            public RStringField statistic2() {
                return new RStringField(getContext().getData(), "statistic2");
            }

            public RStringField statistic3() {
                return new RStringField(getContext().getData(), "statistic3");
            }

            public RStringField statistic4() {
                return new RStringField(getContext().getData(), "statistic4");
            }

            public RStringField vendorNumber() {
                return new RStringField(getContext().getData(), "vendornumber");
            }

            public RStringField primaryEmployeeCategoryNumber() {
                return new RStringField(getContext().getData(), "primaryemployeecategorynumber");
            }

            public RStringField documentArchiveNumber() {
                return new RStringField(getContext().getData(), "documentarchivenumber");
            }

            public RStringField electronicMailAddress() {
                return new RStringField(getContext().getData(), "electronicmailaddress");
            }

            public RStringField instanceKey() {
                return new RStringField(getContext().getData(), "instancekey");
            }

            public RStringField initials() {
                return new RStringField(getContext().getData(), "initials");
            }

            public RStringField mobilePhone() {
                return new RStringField(getContext().getData(), "mobilephone");
            }

            public RStringField mobilePhone2() {
                return new RStringField(getContext().getData(), "mobilephone2");
            }

            public RStringField telephone2() {
                return new RStringField(getContext().getData(), "telephone2");
            }

            public RStringField optionListNumber1() {
                return new RStringField(getContext().getData(), "optionlistnumber1");
            }

            public RStringField selectedOption1() {
                return new RStringField(getContext().getData(), "selectedoption1");
            }

            public RStringField optionListNumber2() {
                return new RStringField(getContext().getData(), "optionlistnumber2");
            }

            public RStringField selectedOption2() {
                return new RStringField(getContext().getData(), "selectedoption2");
            }

            public RStringField optionListNumber3() {
                return new RStringField(getContext().getData(), "optionlistnumber3");
            }

            public RStringField selectedOption3() {
                return new RStringField(getContext().getData(), "selectedoption3");
            }

            public RStringField optionListNumber4() {
                return new RStringField(getContext().getData(), "optionlistnumber4");
            }

            public RStringField selectedOption4() {
                return new RStringField(getContext().getData(), "selectedoption4");
            }

            public RStringField optionListNumber5() {
                return new RStringField(getContext().getData(), "optionlistnumber5");
            }

            public RStringField selectedOption5() {
                return new RStringField(getContext().getData(), "selectedoption5");
            }

            public RStringField optionListNumber6() {
                return new RStringField(getContext().getData(), "optionlistnumber6");
            }

            public RStringField selectedOption6() {
                return new RStringField(getContext().getData(), "selectedoption6");
            }

            public RStringField optionListNumber7() {
                return new RStringField(getContext().getData(), "optionlistnumber7");
            }

            public RStringField selectedOption7() {
                return new RStringField(getContext().getData(), "selectedoption7");
            }

            public RStringField optionListNumber8() {
                return new RStringField(getContext().getData(), "optionlistnumber8");
            }

            public RStringField selectedOption8() {
                return new RStringField(getContext().getData(), "selectedoption8");
            }

            public RStringField optionListNumber9() {
                return new RStringField(getContext().getData(), "optionlistnumber9");
            }

            public RStringField selectedOption9() {
                return new RStringField(getContext().getData(), "selectedoption9");
            }

            public RStringField optionListNumber10() {
                return new RStringField(getContext().getData(), "optionlistnumber10");
            }

            public RStringField selectedOption10() {
                return new RStringField(getContext().getData(), "selectedoption10");
            }

            public RStringField text1() {
                return new RStringField(getContext().getData(), "text1");
            }

            public RStringField text2() {
                return new RStringField(getContext().getData(), "text2");
            }

            public RStringField text3() {
                return new RStringField(getContext().getData(), "text3");
            }

            public RStringField text4() {
                return new RStringField(getContext().getData(), "text4");
            }

            public RStringField text5() {
                return new RStringField(getContext().getData(), "text5");
            }

            public RStringField absenceApprover() {
                return new RStringField(getContext().getData(), "absenceapprover");
            }

            public RStringField tutorEmployee() {
                return new RStringField(getContext().getData(), "tutoremployee");
            }

            public RStringField transactionTimestamp() {
                return new RStringField(getContext().getData(), "transactiontimestamp");
            }

            public RStringField subcontractorVendorNumber() {
                return new RStringField(getContext().getData(), "subcontractorvendornumber");
            }

            public RStringField text6() {
                return new RStringField(getContext().getData(), "text6");
            }

            public RStringField text7() {
                return new RStringField(getContext().getData(), "text7");
            }

            public RStringField text8() {
                return new RStringField(getContext().getData(), "text8");
            }

            public RStringField text9() {
                return new RStringField(getContext().getData(), "text9");
            }

            public RStringField text10() {
                return new RStringField(getContext().getData(), "text10");
            }

            public RWStringField substitute1() {
                return new RWStringField(getContext().getData(), "substitute1");
            }

            public RWStringField substitute2() {
                return new RWStringField(getContext().getData(), "substitute2");
            }

            public RWStringField substitute3() {
                return new RWStringField(getContext().getData(), "substitute3");
            }

            public RWStringField substitute4() {
                return new RWStringField(getContext().getData(), "substitute4");
            }

            public RWStringField substitute5() {
                return new RWStringField(getContext().getData(), "substitute5");
            }

            public RStringField description() {
                return new RStringField(getContext().getData(), "description");
            }

            public RStringField dimensionCombNumber() {
                return new RStringField(getContext().getData(), "dimensioncombnumber");
            }

            public RStringField accountNumber() {
                return new RStringField(getContext().getData(), "accountnumber");
            }

            public RStringField locationName() {
                return new RStringField(getContext().getData(), "locationname");
            }

            public RStringField entityName() {
                return new RStringField(getContext().getData(), "entityname");
            }

            public RStringField projectName() {
                return new RStringField(getContext().getData(), "projectname");
            }

            public RStringField purposeName() {
                return new RStringField(getContext().getData(), "purposename");
            }

            public RStringField specification1Name() {
                return new RStringField(getContext().getData(), "specification1name");
            }

            public RStringField specification2Name() {
                return new RStringField(getContext().getData(), "specification2name");
            }

            public RStringField specification3Name() {
                return new RStringField(getContext().getData(), "specification3name");
            }

            public RStringField localSpec1Name() {
                return new RStringField(getContext().getData(), "localspec1name");
            }

            public RStringField localSpec2Name() {
                return new RStringField(getContext().getData(), "localspec2name");
            }

            public RStringField localSpec3Name() {
                return new RStringField(getContext().getData(), "localspec3name");
            }

            public RStringField selectedOption() {
                return new RStringField(getContext().getData(), "selectedoption");
            }

            public RStringField employeeRevisionDimCombDescriptionVar() {
                return new RStringField(getContext().getData(), "employeerevisiondimcombdescriptionvar");
            }

            public RStringField employeeRevisionAccountTextVar() {
                return new RStringField(getContext().getData(), "employeerevisionaccounttextvar");
            }

            public RStringField employeeRevisionLocationDescriptionVar() {
                return new RStringField(getContext().getData(), "employeerevisionlocationdescriptionvar");
            }

            public RStringField employeeRevisionEntityDescriptionVar() {
                return new RStringField(getContext().getData(), "employeerevisionentitydescriptionvar");
            }

            public RStringField employeeRevisionProjectDescriptionVar() {
                return new RStringField(getContext().getData(), "employeerevisionprojectdescriptionvar");
            }

            public RStringField employeeRevisionPurposeDescriptionVar() {
                return new RStringField(getContext().getData(), "employeerevisionpurposedescriptionvar");
            }

            public RStringField employeeRevisionSpecification1DescriptionVar() {
                return new RStringField(getContext().getData(), "employeerevisionspecification1descriptionvar");
            }

            public RStringField employeeRevisionSpecification2DescriptionVar() {
                return new RStringField(getContext().getData(), "employeerevisionspecification2descriptionvar");
            }

            public RStringField employeeRevisionSpecification3DescriptionVar() {
                return new RStringField(getContext().getData(), "employeerevisionspecification3descriptionvar");
            }

            public RStringField employeeRevisionLocalSpec1DescriptionVar() {
                return new RStringField(getContext().getData(), "employeerevisionlocalspec1descriptionvar");
            }

            public RStringField employeeRevisionLocalSpec2DescriptionVar() {
                return new RStringField(getContext().getData(), "employeerevisionlocalspec2descriptionvar");
            }

            public RStringField employeeRevisionLocalSpec3DescriptionVar() {
                return new RStringField(getContext().getData(), "employeerevisionlocalspec3descriptionvar");
            }
        }

        public static class Record
            extends BaseCardTableRecord<com.deltek.integration.maconomy.psorestclient.Employees.Card>
            implements IRecord
        {

            private Record(final IHasClient iHasClient, final CardTableRecord cardTableRecord) {
                super(iHasClient, cardTableRecord, cardTableData -> {
                    return new com.deltek.integration.maconomy.psorestclient.Employees.Card(iHasClient, cardTableData);
                }
                );
            }

            public RStringField employeeNumber() {
                return new RStringField(getContext().getData(), "employeenumber");
            }

            public RWStringField changeDescription() {
                return new RWStringField(getContext().getData(), "changedescription");
            }

            public RWStringField name1() {
                return new RWStringField(getContext().getData(), "name1");
            }

            public RWStringField name2() {
                return new RWStringField(getContext().getData(), "name2");
            }

            public RWStringField name3() {
                return new RWStringField(getContext().getData(), "name3");
            }

            public RWStringField name4() {
                return new RWStringField(getContext().getData(), "name4");
            }

            public RWStringField name5() {
                return new RWStringField(getContext().getData(), "name5");
            }

            public RWStringField telephone() {
                return new RWStringField(getContext().getData(), "telephone");
            }

            public RWStringField cNRNumber() {
                return new RWStringField(getContext().getData(), "cnrnumber");
            }

            public RWStringField itemNumber() {
                return new RWStringField(getContext().getData(), "itemnumber");
            }

            public RStringField createdBy() {
                return new RStringField(getContext().getData(), "createdby");
            }

            public RStringField changedBy() {
                return new RStringField(getContext().getData(), "changedby");
            }

            public RWStringField commissionAccount() {
                return new RWStringField(getContext().getData(), "commissionaccount");
            }

            public RWStringField commissionSetOffAccount() {
                return new RWStringField(getContext().getData(), "commissionsetoffaccount");
            }

            public RWStringField zipCode() {
                return new RWStringField(getContext().getData(), "zipcode");
            }

            public RWStringField postalDistrict() {
                return new RWStringField(getContext().getData(), "postaldistrict");
            }

            public RWStringField profession() {
                return new RWStringField(getContext().getData(), "profession");
            }

            public RWStringField education() {
                return new RWStringField(getContext().getData(), "education");
            }

            public RWStringField position() {
                return new RWStringField(getContext().getData(), "position");
            }

            public RWStringField bank() {
                return new RWStringField(getContext().getData(), "bank");
            }

            public RWStringField registrationNumber() {
                return new RWStringField(getContext().getData(), "registrationnumber");
            }

            public RWStringField bankAccountNumber() {
                return new RWStringField(getContext().getData(), "bankaccountnumber");
            }

            public RWStringField basicSalaryCode() {
                return new RWStringField(getContext().getData(), "basicsalarycode");
            }

            public RWStringField salarySupplementCode() {
                return new RWStringField(getContext().getData(), "salarysupplementcode");
            }

            public RWStringField overtimeRateCode() {
                return new RWStringField(getContext().getData(), "overtimeratecode");
            }

            public RWStringField pensionTypeCompany() {
                return new RWStringField(getContext().getData(), "pensiontypecompany");
            }

            public RWStringField pensionTypeOwn() {
                return new RWStringField(getContext().getData(), "pensiontypeown");
            }

            public RWStringField remark1() {
                return new RWStringField(getContext().getData(), "remark1");
            }

            public RWStringField remark2() {
                return new RWStringField(getContext().getData(), "remark2");
            }

            public RWStringField remark3() {
                return new RWStringField(getContext().getData(), "remark3");
            }

            public RWStringField remark4() {
                return new RWStringField(getContext().getData(), "remark4");
            }

            public RWStringField remark5() {
                return new RWStringField(getContext().getData(), "remark5");
            }

            public RWStringField superiorEmployee() {
                return new RWStringField(getContext().getData(), "superioremployee");
            }

            public RStringField serviceInventoryName() {
                return new RStringField(getContext().getData(), "serviceinventoryname");
            }

            public RWStringField secretaryEmployee() {
                return new RWStringField(getContext().getData(), "secretaryemployee");
            }

            public RWStringField weekCalendarNumber() {
                return new RWStringField(getContext().getData(), "weekcalendarnumber");
            }

            public RWStringField jobPriceGroupNumber() {
                return new RWStringField(getContext().getData(), "jobpricegroupnumber");
            }

            public RWStringField statistic1() {
                return new RWStringField(getContext().getData(), "statistic1");
            }

            public RWStringField statistic2() {
                return new RWStringField(getContext().getData(), "statistic2");
            }

            public RWStringField statistic3() {
                return new RWStringField(getContext().getData(), "statistic3");
            }

            public RWStringField statistic4() {
                return new RWStringField(getContext().getData(), "statistic4");
            }

            public RWStringField vendorNumber() {
                return new RWStringField(getContext().getData(), "vendornumber");
            }

            public RWStringField primaryEmployeeCategoryNumber() {
                return new RWStringField(getContext().getData(), "primaryemployeecategorynumber");
            }

            public RWStringField documentArchiveNumber() {
                return new RWStringField(getContext().getData(), "documentarchivenumber");
            }

            public RWStringField electronicMailAddress() {
                return new RWStringField(getContext().getData(), "electronicmailaddress");
            }

            public RStringField instanceKey() {
                return new RStringField(getContext().getData(), "instancekey");
            }

            public RWStringField initials() {
                return new RWStringField(getContext().getData(), "initials");
            }

            public RWStringField mobilePhone() {
                return new RWStringField(getContext().getData(), "mobilephone");
            }

            public RWStringField mobilePhone2() {
                return new RWStringField(getContext().getData(), "mobilephone2");
            }

            public RWStringField telephone2() {
                return new RWStringField(getContext().getData(), "telephone2");
            }

            public RWStringField optionListNumber1() {
                return new RWStringField(getContext().getData(), "optionlistnumber1");
            }

            public RWStringField selectedOption1() {
                return new RWStringField(getContext().getData(), "selectedoption1");
            }

            public RWStringField optionListNumber2() {
                return new RWStringField(getContext().getData(), "optionlistnumber2");
            }

            public RWStringField selectedOption2() {
                return new RWStringField(getContext().getData(), "selectedoption2");
            }

            public RWStringField optionListNumber3() {
                return new RWStringField(getContext().getData(), "optionlistnumber3");
            }

            public RWStringField selectedOption3() {
                return new RWStringField(getContext().getData(), "selectedoption3");
            }

            public RWStringField optionListNumber4() {
                return new RWStringField(getContext().getData(), "optionlistnumber4");
            }

            public RWStringField selectedOption4() {
                return new RWStringField(getContext().getData(), "selectedoption4");
            }

            public RWStringField optionListNumber5() {
                return new RWStringField(getContext().getData(), "optionlistnumber5");
            }

            public RWStringField selectedOption5() {
                return new RWStringField(getContext().getData(), "selectedoption5");
            }

            public RWStringField optionListNumber6() {
                return new RWStringField(getContext().getData(), "optionlistnumber6");
            }

            public RWStringField selectedOption6() {
                return new RWStringField(getContext().getData(), "selectedoption6");
            }

            public RWStringField optionListNumber7() {
                return new RWStringField(getContext().getData(), "optionlistnumber7");
            }

            public RWStringField selectedOption7() {
                return new RWStringField(getContext().getData(), "selectedoption7");
            }

            public RWStringField optionListNumber8() {
                return new RWStringField(getContext().getData(), "optionlistnumber8");
            }

            public RWStringField selectedOption8() {
                return new RWStringField(getContext().getData(), "selectedoption8");
            }

            public RWStringField optionListNumber9() {
                return new RWStringField(getContext().getData(), "optionlistnumber9");
            }

            public RWStringField selectedOption9() {
                return new RWStringField(getContext().getData(), "selectedoption9");
            }

            public RWStringField optionListNumber10() {
                return new RWStringField(getContext().getData(), "optionlistnumber10");
            }

            public RWStringField selectedOption10() {
                return new RWStringField(getContext().getData(), "selectedoption10");
            }

            public RWStringField text1() {
                return new RWStringField(getContext().getData(), "text1");
            }

            public RWStringField text2() {
                return new RWStringField(getContext().getData(), "text2");
            }

            public RWStringField text3() {
                return new RWStringField(getContext().getData(), "text3");
            }

            public RWStringField text4() {
                return new RWStringField(getContext().getData(), "text4");
            }

            public RWStringField text5() {
                return new RWStringField(getContext().getData(), "text5");
            }

            public RWStringField absenceApprover() {
                return new RWStringField(getContext().getData(), "absenceapprover");
            }

            public RWStringField tutorEmployee() {
                return new RWStringField(getContext().getData(), "tutoremployee");
            }

            public RStringField transactionTimestamp() {
                return new RStringField(getContext().getData(), "transactiontimestamp");
            }

            public RWStringField subcontractorVendorNumber() {
                return new RWStringField(getContext().getData(), "subcontractorvendornumber");
            }

            public RWStringField text6() {
                return new RWStringField(getContext().getData(), "text6");
            }

            public RWStringField text7() {
                return new RWStringField(getContext().getData(), "text7");
            }

            public RWStringField text8() {
                return new RWStringField(getContext().getData(), "text8");
            }

            public RWStringField text9() {
                return new RWStringField(getContext().getData(), "text9");
            }

            public RWStringField text10() {
                return new RWStringField(getContext().getData(), "text10");
            }

            public RWStringField substitute1() {
                return new RWStringField(getContext().getData(), "substitute1");
            }

            public RWStringField substitute2() {
                return new RWStringField(getContext().getData(), "substitute2");
            }

            public RWStringField substitute3() {
                return new RWStringField(getContext().getData(), "substitute3");
            }

            public RWStringField substitute4() {
                return new RWStringField(getContext().getData(), "substitute4");
            }

            public RWStringField substitute5() {
                return new RWStringField(getContext().getData(), "substitute5");
            }

            public RWStringField description() {
                return new RWStringField(getContext().getData(), "description");
            }

            public RWStringField dimensionCombNumber() {
                return new RWStringField(getContext().getData(), "dimensioncombnumber");
            }

            public RWStringField accountNumber() {
                return new RWStringField(getContext().getData(), "accountnumber");
            }

            public RWStringField locationName() {
                return new RWStringField(getContext().getData(), "locationname");
            }

            public RWStringField entityName() {
                return new RWStringField(getContext().getData(), "entityname");
            }

            public RWStringField projectName() {
                return new RWStringField(getContext().getData(), "projectname");
            }

            public RWStringField purposeName() {
                return new RWStringField(getContext().getData(), "purposename");
            }

            public RWStringField specification1Name() {
                return new RWStringField(getContext().getData(), "specification1name");
            }

            public RWStringField specification2Name() {
                return new RWStringField(getContext().getData(), "specification2name");
            }

            public RWStringField specification3Name() {
                return new RWStringField(getContext().getData(), "specification3name");
            }

            public RWStringField localSpec1Name() {
                return new RWStringField(getContext().getData(), "localspec1name");
            }

            public RWStringField localSpec2Name() {
                return new RWStringField(getContext().getData(), "localspec2name");
            }

            public RWStringField localSpec3Name() {
                return new RWStringField(getContext().getData(), "localspec3name");
            }

            public RWStringField selectedOption() {
                return new RWStringField(getContext().getData(), "selectedoption");
            }

            public RStringField employeeRevisionDimCombDescriptionVar() {
                return new RStringField(getContext().getData(), "employeerevisiondimcombdescriptionvar");
            }

            public RStringField employeeRevisionAccountTextVar() {
                return new RStringField(getContext().getData(), "employeerevisionaccounttextvar");
            }

            public RStringField employeeRevisionLocationDescriptionVar() {
                return new RStringField(getContext().getData(), "employeerevisionlocationdescriptionvar");
            }

            public RStringField employeeRevisionEntityDescriptionVar() {
                return new RStringField(getContext().getData(), "employeerevisionentitydescriptionvar");
            }

            public RStringField employeeRevisionProjectDescriptionVar() {
                return new RStringField(getContext().getData(), "employeerevisionprojectdescriptionvar");
            }

            public RStringField employeeRevisionPurposeDescriptionVar() {
                return new RStringField(getContext().getData(), "employeerevisionpurposedescriptionvar");
            }

            public RStringField employeeRevisionSpecification1DescriptionVar() {
                return new RStringField(getContext().getData(), "employeerevisionspecification1descriptionvar");
            }

            public RStringField employeeRevisionSpecification2DescriptionVar() {
                return new RStringField(getContext().getData(), "employeerevisionspecification2descriptionvar");
            }

            public RStringField employeeRevisionSpecification3DescriptionVar() {
                return new RStringField(getContext().getData(), "employeerevisionspecification3descriptionvar");
            }

            public RStringField employeeRevisionLocalSpec1DescriptionVar() {
                return new RStringField(getContext().getData(), "employeerevisionlocalspec1descriptionvar");
            }

            public RStringField employeeRevisionLocalSpec2DescriptionVar() {
                return new RStringField(getContext().getData(), "employeerevisionlocalspec2descriptionvar");
            }

            public RStringField employeeRevisionLocalSpec3DescriptionVar() {
                return new RStringField(getContext().getData(), "employeerevisionlocalspec3descriptionvar");
            }
        }
    }
}
