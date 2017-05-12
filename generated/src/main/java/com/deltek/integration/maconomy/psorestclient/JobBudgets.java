package com.deltek.integration.maconomy.psorestclient;

import java.util.function.Function;
import com.deltek.integration.maconomy.client.MaconomyClient;
import com.deltek.integration.maconomy.containers.v1.data.CardTableData;
import com.deltek.integration.maconomy.containers.v1.data.CardTableRecord;
import com.deltek.integration.maconomy.containers.v1.data.Container;
import com.deltek.integration.maconomy.containers.v1.data.FilterData;
import com.deltek.integration.maconomy.containers.v1.data.FilterRecord;
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
 * AUTO-GENERATED IMPLEMENTATION OF THE "JOBBUDGETS" CONTAINER. (2017-03-23T14:46:26.442)
 */
public class JobBudgets
    extends BaseContainer
    implements IHasCard<JobBudgets.Card> , IHasFilter<JobBudgets.Filter> , IHasTable<JobBudgets.Table> , IInsertAction<Container, JobBudgets.Card.InitRecord>
{

    public JobBudgets(MaconomyClient maconomyClient) {
        super(maconomyClient, "JobBudgets");
    }

    @Override
    public Function<FilterData, JobBudgets.Filter> getFilterCtorFn() {
        return filterData -> {
            return new JobBudgets.Filter(this, filterData);
        }
        ;
    }

    @Override
    public Function<CardTableRecord, JobBudgets.Card.InitRecord> getInitRecordCtorFn() {
        return cardTableRecord -> {
            return new JobBudgets.Card.InitRecord(this, cardTableRecord);
        }
        ;
    }

    @Override
    public Function<CardTableData, JobBudgets.Card> getCardCtorFn() {
        return cardTableData -> {
            return new JobBudgets.Card(this, cardTableData);
        }
        ;
    }

    @Override
    public Function<CardTableData, JobBudgets.Table> getTableCtorFn() {
        return cardTableData -> {
            return new JobBudgets.Table(this, cardTableData);
        }
        ;
    }

    public static class Card
        extends BaseCardPane<JobBudgets.Card.InitRecord, JobBudgets.Card.Record>
    {

        private Card(IHasClient iHasClient, CardTableData cardTableData) {
            super(iHasClient, cardTableData, initRecord -> {
                return new JobBudgets.Card.InitRecord(iHasClient, initRecord);
            }
            , record -> {
                return new JobBudgets.Card.Record(iHasClient, record);
            }
            );
        }

        public static class InitRecord
            extends BaseCardTableRecord<com.deltek.integration.maconomy.psorestclient.JobBudgets.Card>
            implements ICreateAction<com.deltek.integration.maconomy.psorestclient.JobBudgets.Card> , IInitRecord
        {

            private InitRecord(IHasClient iHasClient, CardTableRecord cardTableRecord) {
                super(iHasClient, cardTableRecord, cardTableData -> {
                    return new com.deltek.integration.maconomy.psorestclient.JobBudgets.Card(iHasClient, cardTableData);
                }
                );
            }

            public RStringField jobNumber() {
                return new RStringField(getContext().getData(), "jobnumber");
            }

            public RStringField responsible() {
                return new RStringField(getContext().getData(), "responsible");
            }

            public RStringField description1() {
                return new RStringField(getContext().getData(), "description1");
            }

            public RStringField description2() {
                return new RStringField(getContext().getData(), "description2");
            }

            public RStringField description3() {
                return new RStringField(getContext().getData(), "description3");
            }

            public RStringField customerNumber() {
                return new RStringField(getContext().getData(), "customernumber");
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

            public RStringField attention() {
                return new RStringField(getContext().getData(), "attention");
            }

            public RStringField reference() {
                return new RStringField(getContext().getData(), "reference");
            }

            public RStringField telephone() {
                return new RStringField(getContext().getData(), "telephone");
            }

            public RStringField telefax() {
                return new RStringField(getContext().getData(), "telefax");
            }

            public RStringField telex() {
                return new RStringField(getContext().getData(), "telex");
            }

            public RStringField paymentCustomer() {
                return new RStringField(getContext().getData(), "paymentcustomer");
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

            public RStringField salesPerson() {
                return new RStringField(getContext().getData(), "salesperson");
            }

            public RStringField createdBy() {
                return new RStringField(getContext().getData(), "createdby");
            }

            public RStringField mainJobNumber() {
                return new RStringField(getContext().getData(), "mainjobnumber");
            }

            public RStringField remark() {
                return new RStringField(getContext().getData(), "remark");
            }

            public RStringField changedBy() {
                return new RStringField(getContext().getData(), "changedby");
            }

            public RStringField zipCode() {
                return new RStringField(getContext().getData(), "zipcode");
            }

            public RStringField postalDistrict() {
                return new RStringField(getContext().getData(), "postaldistrict");
            }

            public RStringField vATNumber() {
                return new RStringField(getContext().getData(), "vatnumber");
            }

            public RStringField salesPersonNumber() {
                return new RStringField(getContext().getData(), "salespersonnumber");
            }

            public RStringField jobName() {
                return new RStringField(getContext().getData(), "jobname");
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

            public RStringField text11() {
                return new RStringField(getContext().getData(), "text11");
            }

            public RStringField text12() {
                return new RStringField(getContext().getData(), "text12");
            }

            public RStringField text13() {
                return new RStringField(getContext().getData(), "text13");
            }

            public RStringField text14() {
                return new RStringField(getContext().getData(), "text14");
            }

            public RStringField text15() {
                return new RStringField(getContext().getData(), "text15");
            }

            public RStringField text16() {
                return new RStringField(getContext().getData(), "text16");
            }

            public RStringField text17() {
                return new RStringField(getContext().getData(), "text17");
            }

            public RStringField text18() {
                return new RStringField(getContext().getData(), "text18");
            }

            public RStringField text19() {
                return new RStringField(getContext().getData(), "text19");
            }

            public RStringField text20() {
                return new RStringField(getContext().getData(), "text20");
            }

            public RStringField exportedTo() {
                return new RStringField(getContext().getData(), "exportedto");
            }

            public RStringField taskList() {
                return new RStringField(getContext().getData(), "tasklist");
            }

            public RStringField jobAllocationName() {
                return new RStringField(getContext().getData(), "joballocationname");
            }

            public RStringField accessLevelName() {
                return new RStringField(getContext().getData(), "accesslevelname");
            }

            public RStringField jobPriceList() {
                return new RStringField(getContext().getData(), "jobpricelist");
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

            public RStringField purposeName() {
                return new RStringField(getContext().getData(), "purposename");
            }

            public RStringField companyNumber() {
                return new RStringField(getContext().getData(), "companynumber");
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

            public RStringField settlingCompany() {
                return new RStringField(getContext().getData(), "settlingcompany");
            }

            public RStringField jobSurchargeRuleName() {
                return new RStringField(getContext().getData(), "jobsurchargerulename");
            }

            public RStringField customerPaymentMode() {
                return new RStringField(getContext().getData(), "customerpaymentmode");
            }

            public RStringField convertedBy() {
                return new RStringField(getContext().getData(), "convertedby");
            }

            public RStringField employeeNumber1() {
                return new RStringField(getContext().getData(), "employeenumber1");
            }

            public RStringField employeeNumber2() {
                return new RStringField(getContext().getData(), "employeenumber2");
            }

            public RStringField employeeNumber3() {
                return new RStringField(getContext().getData(), "employeenumber3");
            }

            public RStringField employeeNumber4() {
                return new RStringField(getContext().getData(), "employeenumber4");
            }

            public RStringField employeeNumber5() {
                return new RStringField(getContext().getData(), "employeenumber5");
            }

            public RStringField employeeNumber6() {
                return new RStringField(getContext().getData(), "employeenumber6");
            }

            public RStringField employeeNumber7() {
                return new RStringField(getContext().getData(), "employeenumber7");
            }

            public RStringField employeeNumber8() {
                return new RStringField(getContext().getData(), "employeenumber8");
            }

            public RStringField employeeNumber9() {
                return new RStringField(getContext().getData(), "employeenumber9");
            }

            public RStringField employeeNumber10() {
                return new RStringField(getContext().getData(), "employeenumber10");
            }

            public RStringField intercompanyJobPriceList() {
                return new RStringField(getContext().getData(), "intercompanyjobpricelist");
            }

            public RStringField costJobPriceList() {
                return new RStringField(getContext().getData(), "costjobpricelist");
            }

            public RStringField blanketInvoiceReference() {
                return new RStringField(getContext().getData(), "blanketinvoicereference");
            }

            public RStringField projectManagerNumber() {
                return new RStringField(getContext().getData(), "projectmanagernumber");
            }

            public RStringField currentPhase() {
                return new RStringField(getContext().getData(), "currentphase");
            }

            public RStringField jobProcessingStatus() {
                return new RStringField(getContext().getData(), "jobprocessingstatus");
            }

            public RStringField jobProcessing() {
                return new RStringField(getContext().getData(), "jobprocessing");
            }

            public RStringField resultType() {
                return new RStringField(getContext().getData(), "resulttype");
            }

            public RStringField noteNumber() {
                return new RStringField(getContext().getData(), "notenumber");
            }

            public RStringField dimensionCombNumber() {
                return new RStringField(getContext().getData(), "dimensioncombnumber");
            }

            public RStringField approvedForInvoicingBy() {
                return new RStringField(getContext().getData(), "approvedforinvoicingby");
            }

            public RStringField documentArchiveNumber() {
                return new RStringField(getContext().getData(), "documentarchivenumber");
            }

            public RStringField dimCombVersionNumber() {
                return new RStringField(getContext().getData(), "dimcombversionnumber");
            }

            public RStringField instanceKey() {
                return new RStringField(getContext().getData(), "instancekey");
            }

            public RStringField templateJobNumber() {
                return new RStringField(getContext().getData(), "templatejobnumber");
            }

            public RStringField referenceJobNumber() {
                return new RStringField(getContext().getData(), "referencejobnumber");
            }

            public RStringField standardBillingPriceList() {
                return new RStringField(getContext().getData(), "standardbillingpricelist");
            }

            public RStringField invoiceEditingNumber() {
                return new RStringField(getContext().getData(), "invoiceeditingnumber");
            }

            public RStringField contactCompanyNumber() {
                return new RStringField(getContext().getData(), "contactcompanynumber");
            }

            public RStringField electronicMailAddress() {
                return new RStringField(getContext().getData(), "electronicmailaddress");
            }

            public RStringField hasBeenPutOnHoldBy() {
                return new RStringField(getContext().getData(), "hasbeenputonholdby");
            }

            public RStringField resumedBy() {
                return new RStringField(getContext().getData(), "resumedby");
            }

            public RStringField team1Number() {
                return new RStringField(getContext().getData(), "team1number");
            }

            public RStringField team2Number() {
                return new RStringField(getContext().getData(), "team2number");
            }

            public RStringField team3Number() {
                return new RStringField(getContext().getData(), "team3number");
            }

            public RStringField team4Number() {
                return new RStringField(getContext().getData(), "team4number");
            }

            public RStringField team5Number() {
                return new RStringField(getContext().getData(), "team5number");
            }

            public RStringField team6Number() {
                return new RStringField(getContext().getData(), "team6number");
            }

            public RStringField globalLocationNumber() {
                return new RStringField(getContext().getData(), "globallocationnumber");
            }

            public RStringField topJobNumber() {
                return new RStringField(getContext().getData(), "topjobnumber");
            }

            public RStringField opportunityNumber() {
                return new RStringField(getContext().getData(), "opportunitynumber");
            }

            public RStringField transactionTimestamp() {
                return new RStringField(getContext().getData(), "transactiontimestamp");
            }

            public RStringField onAccountVATSpecEntryKey() {
                return new RStringField(getContext().getData(), "onaccountvatspecentrykey");
            }

            public RStringField invoiceAllocationSubmittedBy() {
                return new RStringField(getContext().getData(), "invoiceallocationsubmittedby");
            }

            public RStringField feedbackInBatchInvoiceAllocation() {
                return new RStringField(getContext().getData(), "feedbackinbatchinvoiceallocation");
            }

            public RStringField firstJobClosureBy() {
                return new RStringField(getContext().getData(), "firstjobclosureby");
            }

            public RStringField appropriation() {
                return new RStringField(getContext().getData(), "appropriation");
            }

            public RStringField blanketInvoiceCollectionKey() {
                return new RStringField(getContext().getData(), "blanketinvoicecollectionkey");
            }

            public RStringField jobCollectionNumber() {
                return new RStringField(getContext().getData(), "jobcollectionnumber");
            }

            public RStringField invoiceName() {
                return new RStringField(getContext().getData(), "invoicename");
            }

            public RStringField fixedExchangeRatesUpdatedBy() {
                return new RStringField(getContext().getData(), "fixedexchangeratesupdatedby");
            }

            public RStringField customerJobOptionListNumber1() {
                return new RStringField(getContext().getData(), "customerjoboptionlistnumber1");
            }

            public RStringField customerJobOptionListNumber2() {
                return new RStringField(getContext().getData(), "customerjoboptionlistnumber2");
            }

            public RStringField customerJobOptionListNumber3() {
                return new RStringField(getContext().getData(), "customerjoboptionlistnumber3");
            }

            public RStringField selectedCustomerJobOption1() {
                return new RStringField(getContext().getData(), "selectedcustomerjoboption1");
            }

            public RStringField selectedCustomerJobOption2() {
                return new RStringField(getContext().getData(), "selectedcustomerjoboption2");
            }

            public RStringField selectedCustomerJobOption3() {
                return new RStringField(getContext().getData(), "selectedcustomerjoboption3");
            }

            public RStringField invoicingGroup() {
                return new RStringField(getContext().getData(), "invoicinggroup");
            }

            public RStringField accountManagerNumber() {
                return new RStringField(getContext().getData(), "accountmanagernumber");
            }

            public RStringField invoiceTextListName() {
                return new RStringField(getContext().getData(), "invoicetextlistname");
            }

            public RStringField submittedInvoiceDraftBy() {
                return new RStringField(getContext().getData(), "submittedinvoicedraftby");
            }

            public RStringField rolledForwardToJobNumber() {
                return new RStringField(getContext().getData(), "rolledforwardtojobnumber");
            }

            public RStringField konaSpaceNumber() {
                return new RStringField(getContext().getData(), "konaspacenumber");
            }

            public RStringField copiesFromJobNumberVar() {
                return new RStringField(getContext().getData(), "copiesfromjobnumbervar");
            }

            public RStringField companyNameVar() {
                return new RStringField(getContext().getData(), "companynamevar");
            }

            public RStringField settlingCompanyNameVar() {
                return new RStringField(getContext().getData(), "settlingcompanynamevar");
            }

            public RStringField revisionRemark1Var() {
                return new RStringField(getContext().getData(), "revisionremark1var");
            }

            public RStringField revisionRemark2Var() {
                return new RStringField(getContext().getData(), "revisionremark2var");
            }

            public RStringField revisionRemark3Var() {
                return new RStringField(getContext().getData(), "revisionremark3var");
            }

            public RStringField revisionRemark4Var() {
                return new RStringField(getContext().getData(), "revisionremark4var");
            }

            public RStringField revisionRemark5Var() {
                return new RStringField(getContext().getData(), "revisionremark5var");
            }

            public RStringField revisionRemark6Var() {
                return new RStringField(getContext().getData(), "revisionremark6var");
            }

            public RStringField revisionRemark7Var() {
                return new RStringField(getContext().getData(), "revisionremark7var");
            }

            public RStringField revisionRemark8Var() {
                return new RStringField(getContext().getData(), "revisionremark8var");
            }

            public RStringField revisionRemark9Var() {
                return new RStringField(getContext().getData(), "revisionremark9var");
            }

            public RStringField revisionRemark10Var() {
                return new RStringField(getContext().getData(), "revisionremark10var");
            }

            public RStringField submittedByVar() {
                return new RStringField(getContext().getData(), "submittedbyvar");
            }

            public RStringField approvedByVar() {
                return new RStringField(getContext().getData(), "approvedbyvar");
            }

            public RStringField reopenedByVar() {
                return new RStringField(getContext().getData(), "reopenedbyvar");
            }

            public RStringField createdByVar() {
                return new RStringField(getContext().getData(), "createdbyvar");
            }

            public RStringField changedByVar() {
                return new RStringField(getContext().getData(), "changedbyvar");
            }

            public RStringField employee1NameVar() {
                return new RStringField(getContext().getData(), "employee1namevar");
            }

            public RStringField employee2NameVar() {
                return new RStringField(getContext().getData(), "employee2namevar");
            }

            public RStringField employee3NameVar() {
                return new RStringField(getContext().getData(), "employee3namevar");
            }

            public RStringField employee4NameVar() {
                return new RStringField(getContext().getData(), "employee4namevar");
            }

            public RStringField employee5NameVar() {
                return new RStringField(getContext().getData(), "employee5namevar");
            }

            public RStringField employee6NameVar() {
                return new RStringField(getContext().getData(), "employee6namevar");
            }

            public RStringField employee7NameVar() {
                return new RStringField(getContext().getData(), "employee7namevar");
            }

            public RStringField employee8NameVar() {
                return new RStringField(getContext().getData(), "employee8namevar");
            }

            public RStringField employee9NameVar() {
                return new RStringField(getContext().getData(), "employee9namevar");
            }

            public RStringField employee10NameVar() {
                return new RStringField(getContext().getData(), "employee10namevar");
            }

            public RStringField copyFromActualsVar() {
                return new RStringField(getContext().getData(), "copyfromactualsvar");
            }

            public RStringField copyFromOpportunityNumberVar() {
                return new RStringField(getContext().getData(), "copyfromopportunitynumbervar");
            }

            public RStringField showJobBudgetTypeProperty1Var() {
                return new RStringField(getContext().getData(), "showjobbudgettypeproperty1var");
            }

            public RStringField showJobBudgetTypeProperty2Var() {
                return new RStringField(getContext().getData(), "showjobbudgettypeproperty2var");
            }

            public RStringField showJobBudgetTypeProperty3Var() {
                return new RStringField(getContext().getData(), "showjobbudgettypeproperty3var");
            }

            public RStringField currentBudgetTypeProperty1Var() {
                return new RStringField(getContext().getData(), "currentbudgettypeproperty1var");
            }

            public RStringField currentBudgetTypeProperty2Var() {
                return new RStringField(getContext().getData(), "currentbudgettypeproperty2var");
            }

            public RStringField currentBudgetTypeProperty3Var() {
                return new RStringField(getContext().getData(), "currentbudgettypeproperty3var");
            }

            public RStringField currentForecastBudgetTypeProperty1Var() {
                return new RStringField(getContext().getData(), "currentforecastbudgettypeproperty1var");
            }

            public RStringField currentForecastBudgetTypeProperty2Var() {
                return new RStringField(getContext().getData(), "currentforecastbudgettypeproperty2var");
            }

            public RStringField currentForecastBudgetTypeProperty3Var() {
                return new RStringField(getContext().getData(), "currentforecastbudgettypeproperty3var");
            }

            public RStringField currentPlanningBudgetTypeProperty1Var() {
                return new RStringField(getContext().getData(), "currentplanningbudgettypeproperty1var");
            }

            public RStringField currentPlanningBudgetTypeProperty2Var() {
                return new RStringField(getContext().getData(), "currentplanningbudgettypeproperty2var");
            }

            public RStringField currentPlanningBudgetTypeProperty3Var() {
                return new RStringField(getContext().getData(), "currentplanningbudgettypeproperty3var");
            }

            public RStringField copyFromBudgetTypeProperty1Var() {
                return new RStringField(getContext().getData(), "copyfrombudgettypeproperty1var");
            }

            public RStringField copyFromBudgetTypeProperty2Var() {
                return new RStringField(getContext().getData(), "copyfrombudgettypeproperty2var");
            }

            public RStringField copyFromBudgetTypeProperty3Var() {
                return new RStringField(getContext().getData(), "copyfrombudgettypeproperty3var");
            }

            public RStringField priceControlBudgetTypeProperty1Var() {
                return new RStringField(getContext().getData(), "pricecontrolbudgettypeproperty1var");
            }

            public RStringField priceControlBudgetTypeProperty2Var() {
                return new RStringField(getContext().getData(), "pricecontrolbudgettypeproperty2var");
            }

            public RStringField priceControlBudgetTypeProperty3Var() {
                return new RStringField(getContext().getData(), "pricecontrolbudgettypeproperty3var");
            }

            public RStringField employeeCategoryNumber1Var() {
                return new RStringField(getContext().getData(), "employeecategorynumber1var");
            }

            public RStringField employeeCategoryNumber2Var() {
                return new RStringField(getContext().getData(), "employeecategorynumber2var");
            }

            public RStringField employeeCategoryNumber3Var() {
                return new RStringField(getContext().getData(), "employeecategorynumber3var");
            }

            public RStringField employeeCategoryNumber4Var() {
                return new RStringField(getContext().getData(), "employeecategorynumber4var");
            }

            public RStringField employeeCategoryNumber5Var() {
                return new RStringField(getContext().getData(), "employeecategorynumber5var");
            }

            public RStringField employeeCategoryNumber6Var() {
                return new RStringField(getContext().getData(), "employeecategorynumber6var");
            }

            public RStringField employeeCategoryNumber7Var() {
                return new RStringField(getContext().getData(), "employeecategorynumber7var");
            }

            public RStringField employeeCategoryNumber8Var() {
                return new RStringField(getContext().getData(), "employeecategorynumber8var");
            }

            public RStringField employeeCategoryNumber9Var() {
                return new RStringField(getContext().getData(), "employeecategorynumber9var");
            }

            public RStringField employeeCategoryNumber10Var() {
                return new RStringField(getContext().getData(), "employeecategorynumber10var");
            }

            public RStringField employeeCategoryName1Var() {
                return new RStringField(getContext().getData(), "employeecategoryname1var");
            }

            public RStringField employeeCategoryName2Var() {
                return new RStringField(getContext().getData(), "employeecategoryname2var");
            }

            public RStringField employeeCategoryName3Var() {
                return new RStringField(getContext().getData(), "employeecategoryname3var");
            }

            public RStringField employeeCategoryName4Var() {
                return new RStringField(getContext().getData(), "employeecategoryname4var");
            }

            public RStringField employeeCategoryName5Var() {
                return new RStringField(getContext().getData(), "employeecategoryname5var");
            }

            public RStringField employeeCategoryName6Var() {
                return new RStringField(getContext().getData(), "employeecategoryname6var");
            }

            public RStringField employeeCategoryName7Var() {
                return new RStringField(getContext().getData(), "employeecategoryname7var");
            }

            public RStringField employeeCategoryName8Var() {
                return new RStringField(getContext().getData(), "employeecategoryname8var");
            }

            public RStringField employeeCategoryName9Var() {
                return new RStringField(getContext().getData(), "employeecategoryname9var");
            }

            public RStringField employeeCategoryName10Var() {
                return new RStringField(getContext().getData(), "employeecategoryname10var");
            }

            public RStringField approveTasksLinkVar() {
                return new RStringField(getContext().getData(), "approvetaskslinkvar");
            }

            public RStringField viewRevisionListVar() {
                return new RStringField(getContext().getData(), "viewrevisionlistvar");
            }

            public RStringField jobBudgetText1Var() {
                return new RStringField(getContext().getData(), "jobbudgettext1var");
            }

            public RStringField jobBudgetText2Var() {
                return new RStringField(getContext().getData(), "jobbudgettext2var");
            }

            public RStringField jobBudgetText3Var() {
                return new RStringField(getContext().getData(), "jobbudgettext3var");
            }

            public RStringField jobBudgetText4Var() {
                return new RStringField(getContext().getData(), "jobbudgettext4var");
            }

            public RStringField jobBudgetText5Var() {
                return new RStringField(getContext().getData(), "jobbudgettext5var");
            }

            public RStringField integrationStatusLastSentVar() {
                return new RStringField(getContext().getData(), "integrationstatuslastsentvar");
            }

            public RStringField headerApprovalObjectInstanceKeyVar() {
                return new RStringField(getContext().getData(), "headerapprovalobjectinstancekeyvar");
            }

            public RStringField headerCurrentApprovalStatusDescriptionVar() {
                return new RStringField(getContext().getData(), "headercurrentapprovalstatusdescriptionvar");
            }

            public RStringField sHOWNJOBNUMBERVAR() {
                return new RStringField(getContext().getData(), "shownjobnumbervar");
            }

            public RStringField iNTEGRATIONSTATUSBUDGETTYPETITLEVAR() {
                return new RStringField(getContext().getData(), "integrationstatusbudgettypetitlevar");
            }
        }

        public static class Record
            extends BaseCardTableRecord<com.deltek.integration.maconomy.psorestclient.JobBudgets.Card>
            implements IRecord
        {

            private Record(IHasClient iHasClient, CardTableRecord cardTableRecord) {
                super(iHasClient, cardTableRecord, cardTableData -> {
                    return new com.deltek.integration.maconomy.psorestclient.JobBudgets.Card(iHasClient, cardTableData);
                }
                );
            }

            public RStringField jobNumber() {
                return new RStringField(getContext().getData(), "jobnumber");
            }

            public RStringField responsible() {
                return new RStringField(getContext().getData(), "responsible");
            }

            public RWStringField description1() {
                return new RWStringField(getContext().getData(), "description1");
            }

            public RWStringField description2() {
                return new RWStringField(getContext().getData(), "description2");
            }

            public RWStringField description3() {
                return new RWStringField(getContext().getData(), "description3");
            }

            public RStringField customerNumber() {
                return new RStringField(getContext().getData(), "customernumber");
            }

            public RStringField name1() {
                return new RStringField(getContext().getData(), "name1");
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

            public RWStringField attention() {
                return new RWStringField(getContext().getData(), "attention");
            }

            public RStringField reference() {
                return new RStringField(getContext().getData(), "reference");
            }

            public RWStringField telephone() {
                return new RWStringField(getContext().getData(), "telephone");
            }

            public RWStringField telefax() {
                return new RWStringField(getContext().getData(), "telefax");
            }

            public RWStringField telex() {
                return new RWStringField(getContext().getData(), "telex");
            }

            public RWStringField paymentCustomer() {
                return new RWStringField(getContext().getData(), "paymentcustomer");
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

            public RStringField salesPerson() {
                return new RStringField(getContext().getData(), "salesperson");
            }

            public RStringField createdBy() {
                return new RStringField(getContext().getData(), "createdby");
            }

            public RWStringField mainJobNumber() {
                return new RWStringField(getContext().getData(), "mainjobnumber");
            }

            public RWStringField remark() {
                return new RWStringField(getContext().getData(), "remark");
            }

            public RStringField changedBy() {
                return new RStringField(getContext().getData(), "changedby");
            }

            public RWStringField zipCode() {
                return new RWStringField(getContext().getData(), "zipcode");
            }

            public RWStringField postalDistrict() {
                return new RWStringField(getContext().getData(), "postaldistrict");
            }

            public RWStringField vATNumber() {
                return new RWStringField(getContext().getData(), "vatnumber");
            }

            public RWStringField salesPersonNumber() {
                return new RWStringField(getContext().getData(), "salespersonnumber");
            }

            public RStringField jobName() {
                return new RStringField(getContext().getData(), "jobname");
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

            public RWStringField text11() {
                return new RWStringField(getContext().getData(), "text11");
            }

            public RWStringField text12() {
                return new RWStringField(getContext().getData(), "text12");
            }

            public RWStringField text13() {
                return new RWStringField(getContext().getData(), "text13");
            }

            public RWStringField text14() {
                return new RWStringField(getContext().getData(), "text14");
            }

            public RWStringField text15() {
                return new RWStringField(getContext().getData(), "text15");
            }

            public RWStringField text16() {
                return new RWStringField(getContext().getData(), "text16");
            }

            public RWStringField text17() {
                return new RWStringField(getContext().getData(), "text17");
            }

            public RWStringField text18() {
                return new RWStringField(getContext().getData(), "text18");
            }

            public RWStringField text19() {
                return new RWStringField(getContext().getData(), "text19");
            }

            public RWStringField text20() {
                return new RWStringField(getContext().getData(), "text20");
            }

            public RStringField exportedTo() {
                return new RStringField(getContext().getData(), "exportedto");
            }

            public RWStringField taskList() {
                return new RWStringField(getContext().getData(), "tasklist");
            }

            public RWStringField jobAllocationName() {
                return new RWStringField(getContext().getData(), "joballocationname");
            }

            public RWStringField accessLevelName() {
                return new RWStringField(getContext().getData(), "accesslevelname");
            }

            public RWStringField jobPriceList() {
                return new RWStringField(getContext().getData(), "jobpricelist");
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

            public RStringField companyNumber() {
                return new RStringField(getContext().getData(), "companynumber");
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

            public RStringField settlingCompany() {
                return new RStringField(getContext().getData(), "settlingcompany");
            }

            public RWStringField jobSurchargeRuleName() {
                return new RWStringField(getContext().getData(), "jobsurchargerulename");
            }

            public RWStringField customerPaymentMode() {
                return new RWStringField(getContext().getData(), "customerpaymentmode");
            }

            public RStringField convertedBy() {
                return new RStringField(getContext().getData(), "convertedby");
            }

            public RWStringField employeeNumber1() {
                return new RWStringField(getContext().getData(), "employeenumber1");
            }

            public RWStringField employeeNumber2() {
                return new RWStringField(getContext().getData(), "employeenumber2");
            }

            public RWStringField employeeNumber3() {
                return new RWStringField(getContext().getData(), "employeenumber3");
            }

            public RWStringField employeeNumber4() {
                return new RWStringField(getContext().getData(), "employeenumber4");
            }

            public RWStringField employeeNumber5() {
                return new RWStringField(getContext().getData(), "employeenumber5");
            }

            public RWStringField employeeNumber6() {
                return new RWStringField(getContext().getData(), "employeenumber6");
            }

            public RWStringField employeeNumber7() {
                return new RWStringField(getContext().getData(), "employeenumber7");
            }

            public RWStringField employeeNumber8() {
                return new RWStringField(getContext().getData(), "employeenumber8");
            }

            public RWStringField employeeNumber9() {
                return new RWStringField(getContext().getData(), "employeenumber9");
            }

            public RWStringField employeeNumber10() {
                return new RWStringField(getContext().getData(), "employeenumber10");
            }

            public RWStringField intercompanyJobPriceList() {
                return new RWStringField(getContext().getData(), "intercompanyjobpricelist");
            }

            public RWStringField costJobPriceList() {
                return new RWStringField(getContext().getData(), "costjobpricelist");
            }

            public RWStringField blanketInvoiceReference() {
                return new RWStringField(getContext().getData(), "blanketinvoicereference");
            }

            public RWStringField projectManagerNumber() {
                return new RWStringField(getContext().getData(), "projectmanagernumber");
            }

            public RStringField currentPhase() {
                return new RStringField(getContext().getData(), "currentphase");
            }

            public RStringField jobProcessingStatus() {
                return new RStringField(getContext().getData(), "jobprocessingstatus");
            }

            public RStringField jobProcessing() {
                return new RStringField(getContext().getData(), "jobprocessing");
            }

            public RStringField resultType() {
                return new RStringField(getContext().getData(), "resulttype");
            }

            public RStringField noteNumber() {
                return new RStringField(getContext().getData(), "notenumber");
            }

            public RWStringField dimensionCombNumber() {
                return new RWStringField(getContext().getData(), "dimensioncombnumber");
            }

            public RStringField approvedForInvoicingBy() {
                return new RStringField(getContext().getData(), "approvedforinvoicingby");
            }

            public RWStringField documentArchiveNumber() {
                return new RWStringField(getContext().getData(), "documentarchivenumber");
            }

            public RStringField dimCombVersionNumber() {
                return new RStringField(getContext().getData(), "dimcombversionnumber");
            }

            public RStringField instanceKey() {
                return new RStringField(getContext().getData(), "instancekey");
            }

            public RStringField templateJobNumber() {
                return new RStringField(getContext().getData(), "templatejobnumber");
            }

            public RWStringField referenceJobNumber() {
                return new RWStringField(getContext().getData(), "referencejobnumber");
            }

            public RWStringField standardBillingPriceList() {
                return new RWStringField(getContext().getData(), "standardbillingpricelist");
            }

            public RStringField invoiceEditingNumber() {
                return new RStringField(getContext().getData(), "invoiceeditingnumber");
            }

            public RStringField contactCompanyNumber() {
                return new RStringField(getContext().getData(), "contactcompanynumber");
            }

            public RWStringField electronicMailAddress() {
                return new RWStringField(getContext().getData(), "electronicmailaddress");
            }

            public RStringField hasBeenPutOnHoldBy() {
                return new RStringField(getContext().getData(), "hasbeenputonholdby");
            }

            public RStringField resumedBy() {
                return new RStringField(getContext().getData(), "resumedby");
            }

            public RWStringField team1Number() {
                return new RWStringField(getContext().getData(), "team1number");
            }

            public RWStringField team2Number() {
                return new RWStringField(getContext().getData(), "team2number");
            }

            public RWStringField team3Number() {
                return new RWStringField(getContext().getData(), "team3number");
            }

            public RWStringField team4Number() {
                return new RWStringField(getContext().getData(), "team4number");
            }

            public RWStringField team5Number() {
                return new RWStringField(getContext().getData(), "team5number");
            }

            public RWStringField team6Number() {
                return new RWStringField(getContext().getData(), "team6number");
            }

            public RWStringField globalLocationNumber() {
                return new RWStringField(getContext().getData(), "globallocationnumber");
            }

            public RStringField topJobNumber() {
                return new RStringField(getContext().getData(), "topjobnumber");
            }

            public RStringField opportunityNumber() {
                return new RStringField(getContext().getData(), "opportunitynumber");
            }

            public RStringField transactionTimestamp() {
                return new RStringField(getContext().getData(), "transactiontimestamp");
            }

            public RStringField onAccountVATSpecEntryKey() {
                return new RStringField(getContext().getData(), "onaccountvatspecentrykey");
            }

            public RStringField invoiceAllocationSubmittedBy() {
                return new RStringField(getContext().getData(), "invoiceallocationsubmittedby");
            }

            public RStringField feedbackInBatchInvoiceAllocation() {
                return new RStringField(getContext().getData(), "feedbackinbatchinvoiceallocation");
            }

            public RStringField firstJobClosureBy() {
                return new RStringField(getContext().getData(), "firstjobclosureby");
            }

            public RWStringField appropriation() {
                return new RWStringField(getContext().getData(), "appropriation");
            }

            public RStringField blanketInvoiceCollectionKey() {
                return new RStringField(getContext().getData(), "blanketinvoicecollectionkey");
            }

            public RWStringField jobCollectionNumber() {
                return new RWStringField(getContext().getData(), "jobcollectionnumber");
            }

            public RWStringField invoiceName() {
                return new RWStringField(getContext().getData(), "invoicename");
            }

            public RStringField fixedExchangeRatesUpdatedBy() {
                return new RStringField(getContext().getData(), "fixedexchangeratesupdatedby");
            }

            public RWStringField customerJobOptionListNumber1() {
                return new RWStringField(getContext().getData(), "customerjoboptionlistnumber1");
            }

            public RWStringField customerJobOptionListNumber2() {
                return new RWStringField(getContext().getData(), "customerjoboptionlistnumber2");
            }

            public RWStringField customerJobOptionListNumber3() {
                return new RWStringField(getContext().getData(), "customerjoboptionlistnumber3");
            }

            public RWStringField selectedCustomerJobOption1() {
                return new RWStringField(getContext().getData(), "selectedcustomerjoboption1");
            }

            public RWStringField selectedCustomerJobOption2() {
                return new RWStringField(getContext().getData(), "selectedcustomerjoboption2");
            }

            public RWStringField selectedCustomerJobOption3() {
                return new RWStringField(getContext().getData(), "selectedcustomerjoboption3");
            }

            public RWStringField invoicingGroup() {
                return new RWStringField(getContext().getData(), "invoicinggroup");
            }

            public RWStringField accountManagerNumber() {
                return new RWStringField(getContext().getData(), "accountmanagernumber");
            }

            public RWStringField invoiceTextListName() {
                return new RWStringField(getContext().getData(), "invoicetextlistname");
            }

            public RStringField submittedInvoiceDraftBy() {
                return new RStringField(getContext().getData(), "submittedinvoicedraftby");
            }

            public RStringField rolledForwardToJobNumber() {
                return new RStringField(getContext().getData(), "rolledforwardtojobnumber");
            }

            public RWStringField konaSpaceNumber() {
                return new RWStringField(getContext().getData(), "konaspacenumber");
            }

            public RWStringField copiesFromJobNumberVar() {
                return new RWStringField(getContext().getData(), "copiesfromjobnumbervar");
            }

            public RStringField companyNameVar() {
                return new RStringField(getContext().getData(), "companynamevar");
            }

            public RStringField settlingCompanyNameVar() {
                return new RStringField(getContext().getData(), "settlingcompanynamevar");
            }

            public RWStringField revisionRemark1Var() {
                return new RWStringField(getContext().getData(), "revisionremark1var");
            }

            public RWStringField revisionRemark2Var() {
                return new RWStringField(getContext().getData(), "revisionremark2var");
            }

            public RWStringField revisionRemark3Var() {
                return new RWStringField(getContext().getData(), "revisionremark3var");
            }

            public RWStringField revisionRemark4Var() {
                return new RWStringField(getContext().getData(), "revisionremark4var");
            }

            public RWStringField revisionRemark5Var() {
                return new RWStringField(getContext().getData(), "revisionremark5var");
            }

            public RWStringField revisionRemark6Var() {
                return new RWStringField(getContext().getData(), "revisionremark6var");
            }

            public RWStringField revisionRemark7Var() {
                return new RWStringField(getContext().getData(), "revisionremark7var");
            }

            public RWStringField revisionRemark8Var() {
                return new RWStringField(getContext().getData(), "revisionremark8var");
            }

            public RWStringField revisionRemark9Var() {
                return new RWStringField(getContext().getData(), "revisionremark9var");
            }

            public RWStringField revisionRemark10Var() {
                return new RWStringField(getContext().getData(), "revisionremark10var");
            }

            public RStringField submittedByVar() {
                return new RStringField(getContext().getData(), "submittedbyvar");
            }

            public RStringField approvedByVar() {
                return new RStringField(getContext().getData(), "approvedbyvar");
            }

            public RStringField reopenedByVar() {
                return new RStringField(getContext().getData(), "reopenedbyvar");
            }

            public RStringField createdByVar() {
                return new RStringField(getContext().getData(), "createdbyvar");
            }

            public RStringField changedByVar() {
                return new RStringField(getContext().getData(), "changedbyvar");
            }

            public RStringField employee1NameVar() {
                return new RStringField(getContext().getData(), "employee1namevar");
            }

            public RStringField employee2NameVar() {
                return new RStringField(getContext().getData(), "employee2namevar");
            }

            public RStringField employee3NameVar() {
                return new RStringField(getContext().getData(), "employee3namevar");
            }

            public RStringField employee4NameVar() {
                return new RStringField(getContext().getData(), "employee4namevar");
            }

            public RStringField employee5NameVar() {
                return new RStringField(getContext().getData(), "employee5namevar");
            }

            public RStringField employee6NameVar() {
                return new RStringField(getContext().getData(), "employee6namevar");
            }

            public RStringField employee7NameVar() {
                return new RStringField(getContext().getData(), "employee7namevar");
            }

            public RStringField employee8NameVar() {
                return new RStringField(getContext().getData(), "employee8namevar");
            }

            public RStringField employee9NameVar() {
                return new RStringField(getContext().getData(), "employee9namevar");
            }

            public RStringField employee10NameVar() {
                return new RStringField(getContext().getData(), "employee10namevar");
            }

            public RWStringField copyFromActualsVar() {
                return new RWStringField(getContext().getData(), "copyfromactualsvar");
            }

            public RWStringField copyFromOpportunityNumberVar() {
                return new RWStringField(getContext().getData(), "copyfromopportunitynumbervar");
            }

            public RWStringField showJobBudgetTypeProperty1Var() {
                return new RWStringField(getContext().getData(), "showjobbudgettypeproperty1var");
            }

            public RWStringField showJobBudgetTypeProperty2Var() {
                return new RWStringField(getContext().getData(), "showjobbudgettypeproperty2var");
            }

            public RWStringField showJobBudgetTypeProperty3Var() {
                return new RWStringField(getContext().getData(), "showjobbudgettypeproperty3var");
            }

            public RWStringField currentBudgetTypeProperty1Var() {
                return new RWStringField(getContext().getData(), "currentbudgettypeproperty1var");
            }

            public RWStringField currentBudgetTypeProperty2Var() {
                return new RWStringField(getContext().getData(), "currentbudgettypeproperty2var");
            }

            public RWStringField currentBudgetTypeProperty3Var() {
                return new RWStringField(getContext().getData(), "currentbudgettypeproperty3var");
            }

            public RWStringField currentForecastBudgetTypeProperty1Var() {
                return new RWStringField(getContext().getData(), "currentforecastbudgettypeproperty1var");
            }

            public RWStringField currentForecastBudgetTypeProperty2Var() {
                return new RWStringField(getContext().getData(), "currentforecastbudgettypeproperty2var");
            }

            public RWStringField currentForecastBudgetTypeProperty3Var() {
                return new RWStringField(getContext().getData(), "currentforecastbudgettypeproperty3var");
            }

            public RWStringField currentPlanningBudgetTypeProperty1Var() {
                return new RWStringField(getContext().getData(), "currentplanningbudgettypeproperty1var");
            }

            public RWStringField currentPlanningBudgetTypeProperty2Var() {
                return new RWStringField(getContext().getData(), "currentplanningbudgettypeproperty2var");
            }

            public RWStringField currentPlanningBudgetTypeProperty3Var() {
                return new RWStringField(getContext().getData(), "currentplanningbudgettypeproperty3var");
            }

            public RWStringField copyFromBudgetTypeProperty1Var() {
                return new RWStringField(getContext().getData(), "copyfrombudgettypeproperty1var");
            }

            public RWStringField copyFromBudgetTypeProperty2Var() {
                return new RWStringField(getContext().getData(), "copyfrombudgettypeproperty2var");
            }

            public RWStringField copyFromBudgetTypeProperty3Var() {
                return new RWStringField(getContext().getData(), "copyfrombudgettypeproperty3var");
            }

            public RStringField priceControlBudgetTypeProperty1Var() {
                return new RStringField(getContext().getData(), "pricecontrolbudgettypeproperty1var");
            }

            public RStringField priceControlBudgetTypeProperty2Var() {
                return new RStringField(getContext().getData(), "pricecontrolbudgettypeproperty2var");
            }

            public RStringField priceControlBudgetTypeProperty3Var() {
                return new RStringField(getContext().getData(), "pricecontrolbudgettypeproperty3var");
            }

            public RWStringField employeeCategoryNumber1Var() {
                return new RWStringField(getContext().getData(), "employeecategorynumber1var");
            }

            public RWStringField employeeCategoryNumber2Var() {
                return new RWStringField(getContext().getData(), "employeecategorynumber2var");
            }

            public RWStringField employeeCategoryNumber3Var() {
                return new RWStringField(getContext().getData(), "employeecategorynumber3var");
            }

            public RWStringField employeeCategoryNumber4Var() {
                return new RWStringField(getContext().getData(), "employeecategorynumber4var");
            }

            public RWStringField employeeCategoryNumber5Var() {
                return new RWStringField(getContext().getData(), "employeecategorynumber5var");
            }

            public RWStringField employeeCategoryNumber6Var() {
                return new RWStringField(getContext().getData(), "employeecategorynumber6var");
            }

            public RWStringField employeeCategoryNumber7Var() {
                return new RWStringField(getContext().getData(), "employeecategorynumber7var");
            }

            public RWStringField employeeCategoryNumber8Var() {
                return new RWStringField(getContext().getData(), "employeecategorynumber8var");
            }

            public RWStringField employeeCategoryNumber9Var() {
                return new RWStringField(getContext().getData(), "employeecategorynumber9var");
            }

            public RWStringField employeeCategoryNumber10Var() {
                return new RWStringField(getContext().getData(), "employeecategorynumber10var");
            }

            public RStringField employeeCategoryName1Var() {
                return new RStringField(getContext().getData(), "employeecategoryname1var");
            }

            public RStringField employeeCategoryName2Var() {
                return new RStringField(getContext().getData(), "employeecategoryname2var");
            }

            public RStringField employeeCategoryName3Var() {
                return new RStringField(getContext().getData(), "employeecategoryname3var");
            }

            public RStringField employeeCategoryName4Var() {
                return new RStringField(getContext().getData(), "employeecategoryname4var");
            }

            public RStringField employeeCategoryName5Var() {
                return new RStringField(getContext().getData(), "employeecategoryname5var");
            }

            public RStringField employeeCategoryName6Var() {
                return new RStringField(getContext().getData(), "employeecategoryname6var");
            }

            public RStringField employeeCategoryName7Var() {
                return new RStringField(getContext().getData(), "employeecategoryname7var");
            }

            public RStringField employeeCategoryName8Var() {
                return new RStringField(getContext().getData(), "employeecategoryname8var");
            }

            public RStringField employeeCategoryName9Var() {
                return new RStringField(getContext().getData(), "employeecategoryname9var");
            }

            public RStringField employeeCategoryName10Var() {
                return new RStringField(getContext().getData(), "employeecategoryname10var");
            }

            public RStringField approveTasksLinkVar() {
                return new RStringField(getContext().getData(), "approvetaskslinkvar");
            }

            public RStringField viewRevisionListVar() {
                return new RStringField(getContext().getData(), "viewrevisionlistvar");
            }

            public RWStringField jobBudgetText1Var() {
                return new RWStringField(getContext().getData(), "jobbudgettext1var");
            }

            public RWStringField jobBudgetText2Var() {
                return new RWStringField(getContext().getData(), "jobbudgettext2var");
            }

            public RWStringField jobBudgetText3Var() {
                return new RWStringField(getContext().getData(), "jobbudgettext3var");
            }

            public RWStringField jobBudgetText4Var() {
                return new RWStringField(getContext().getData(), "jobbudgettext4var");
            }

            public RWStringField jobBudgetText5Var() {
                return new RWStringField(getContext().getData(), "jobbudgettext5var");
            }

            public RStringField integrationStatusLastSentVar() {
                return new RStringField(getContext().getData(), "integrationstatuslastsentvar");
            }

            public RStringField headerApprovalObjectInstanceKeyVar() {
                return new RStringField(getContext().getData(), "headerapprovalobjectinstancekeyvar");
            }

            public RStringField headerCurrentApprovalStatusDescriptionVar() {
                return new RStringField(getContext().getData(), "headercurrentapprovalstatusdescriptionvar");
            }

            public RStringField sHOWNJOBNUMBERVAR() {
                return new RStringField(getContext().getData(), "shownjobnumbervar");
            }

            public RStringField iNTEGRATIONSTATUSBUDGETTYPETITLEVAR() {
                return new RStringField(getContext().getData(), "integrationstatusbudgettypetitlevar");
            }
        }
    }

    public static class Filter
        extends BaseFilterPane<JobBudgets.Filter.InitRecord, JobBudgets.Filter.Record>
    {

        private Filter(IHasClient iHasClient, FilterData filterData) {
            super(iHasClient, filterData, initRecord -> {
                return new JobBudgets.Filter.InitRecord(iHasClient, initRecord);
            }
            , record -> {
                return new JobBudgets.Filter.Record(iHasClient, record);
            }
            );
        }

        public static class InitRecord
            extends BaseRecord<FilterRecord>
            implements IInitRecord
        {

            private InitRecord(IHasClient iHasClient, FilterRecord filterRecord) {
                super(iHasClient, filterRecord);
            }

            public RStringField jobNumber() {
                return new RStringField(getContext().getData(), "jobnumber");
            }

            public RStringField jobName() {
                return new RStringField(getContext().getData(), "jobname");
            }

            public RStringField companyName() {
                return new RStringField(getContext().getData(), "companyname");
            }

            public RStringField projectManagerName() {
                return new RStringField(getContext().getData(), "projectmanagername");
            }

            public RStringField mainJobNumber() {
                return new RStringField(getContext().getData(), "mainjobnumber");
            }

            public RStringField jobProgressRemark() {
                return new RStringField(getContext().getData(), "jobprogressremark");
            }

            public RStringField convertedBy() {
                return new RStringField(getContext().getData(), "convertedby");
            }

            public RStringField projectManagerNumber() {
                return new RStringField(getContext().getData(), "projectmanagernumber");
            }

            public RStringField salesPersonNumber() {
                return new RStringField(getContext().getData(), "salespersonnumber");
            }

            public RStringField salesPerson() {
                return new RStringField(getContext().getData(), "salesperson");
            }

            public RStringField responsible() {
                return new RStringField(getContext().getData(), "responsible");
            }

            public RStringField customerNumber() {
                return new RStringField(getContext().getData(), "customernumber");
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

            public RStringField level1CustomerNumber() {
                return new RStringField(getContext().getData(), "level1customernumber");
            }

            public RStringField customerLevel1Name() {
                return new RStringField(getContext().getData(), "customerlevel1name");
            }

            public RStringField level2CustomerNumber() {
                return new RStringField(getContext().getData(), "level2customernumber");
            }

            public RStringField customerLevel2Name() {
                return new RStringField(getContext().getData(), "customerlevel2name");
            }

            public RStringField level3CustomerNumber() {
                return new RStringField(getContext().getData(), "level3customernumber");
            }

            public RStringField customerLevel3Name() {
                return new RStringField(getContext().getData(), "customerlevel3name");
            }

            public RStringField level4CustomerNumber() {
                return new RStringField(getContext().getData(), "level4customernumber");
            }

            public RStringField customerLevel4Name() {
                return new RStringField(getContext().getData(), "customerlevel4name");
            }

            public RStringField level5CustomerNumber() {
                return new RStringField(getContext().getData(), "level5customernumber");
            }

            public RStringField customerLevel5Name() {
                return new RStringField(getContext().getData(), "customerlevel5name");
            }

            public RStringField levelName() {
                return new RStringField(getContext().getData(), "levelname");
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

            public RStringField attention() {
                return new RStringField(getContext().getData(), "attention");
            }

            public RStringField telephone() {
                return new RStringField(getContext().getData(), "telephone");
            }

            public RStringField telefax() {
                return new RStringField(getContext().getData(), "telefax");
            }

            public RStringField telex() {
                return new RStringField(getContext().getData(), "telex");
            }

            public RStringField paymentCustomer() {
                return new RStringField(getContext().getData(), "paymentcustomer");
            }

            public RStringField description1() {
                return new RStringField(getContext().getData(), "description1");
            }

            public RStringField description2() {
                return new RStringField(getContext().getData(), "description2");
            }

            public RStringField description3() {
                return new RStringField(getContext().getData(), "description3");
            }

            public RStringField reference() {
                return new RStringField(getContext().getData(), "reference");
            }

            public RStringField remark() {
                return new RStringField(getContext().getData(), "remark");
            }

            public RStringField companyNumber() {
                return new RStringField(getContext().getData(), "companynumber");
            }

            public RStringField settlingCompany() {
                return new RStringField(getContext().getData(), "settlingcompany");
            }

            public RStringField currentPhase() {
                return new RStringField(getContext().getData(), "currentphase");
            }

            public RStringField jobProcessing() {
                return new RStringField(getContext().getData(), "jobprocessing");
            }

            public RStringField jobProcessingStatus() {
                return new RStringField(getContext().getData(), "jobprocessingstatus");
            }

            public RStringField resultType() {
                return new RStringField(getContext().getData(), "resulttype");
            }

            public RStringField dimensionCombNumber() {
                return new RStringField(getContext().getData(), "dimensioncombnumber");
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

            public RStringField jobCollectionNumber() {
                return new RStringField(getContext().getData(), "jobcollectionnumber");
            }

            public RStringField taskList() {
                return new RStringField(getContext().getData(), "tasklist");
            }

            public RStringField jobAllocationName() {
                return new RStringField(getContext().getData(), "joballocationname");
            }

            public RStringField vATNumber() {
                return new RStringField(getContext().getData(), "vatnumber");
            }

            public RStringField customerPaymentMode() {
                return new RStringField(getContext().getData(), "customerpaymentmode");
            }

            public RStringField globalLocationNumber() {
                return new RStringField(getContext().getData(), "globallocationnumber");
            }

            public RStringField invoiceName() {
                return new RStringField(getContext().getData(), "invoicename");
            }

            public RStringField costJobPriceList() {
                return new RStringField(getContext().getData(), "costjobpricelist");
            }

            public RStringField intercompanyJobPriceList() {
                return new RStringField(getContext().getData(), "intercompanyjobpricelist");
            }

            public RStringField jobPriceList() {
                return new RStringField(getContext().getData(), "jobpricelist");
            }

            public RStringField standardBillingPriceList() {
                return new RStringField(getContext().getData(), "standardbillingpricelist");
            }

            public RStringField jobSurchargeRuleName() {
                return new RStringField(getContext().getData(), "jobsurchargerulename");
            }

            public RStringField accessLevelName() {
                return new RStringField(getContext().getData(), "accesslevelname");
            }

            public RStringField createdBy() {
                return new RStringField(getContext().getData(), "createdby");
            }

            public RStringField changedBy() {
                return new RStringField(getContext().getData(), "changedby");
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

            public RStringField text11() {
                return new RStringField(getContext().getData(), "text11");
            }

            public RStringField text12() {
                return new RStringField(getContext().getData(), "text12");
            }

            public RStringField text13() {
                return new RStringField(getContext().getData(), "text13");
            }

            public RStringField text14() {
                return new RStringField(getContext().getData(), "text14");
            }

            public RStringField text15() {
                return new RStringField(getContext().getData(), "text15");
            }

            public RStringField text16() {
                return new RStringField(getContext().getData(), "text16");
            }

            public RStringField text17() {
                return new RStringField(getContext().getData(), "text17");
            }

            public RStringField text18() {
                return new RStringField(getContext().getData(), "text18");
            }

            public RStringField text19() {
                return new RStringField(getContext().getData(), "text19");
            }

            public RStringField text20() {
                return new RStringField(getContext().getData(), "text20");
            }

            public RStringField text21() {
                return new RStringField(getContext().getData(), "text21");
            }

            public RStringField text22() {
                return new RStringField(getContext().getData(), "text22");
            }

            public RStringField text23() {
                return new RStringField(getContext().getData(), "text23");
            }

            public RStringField text24() {
                return new RStringField(getContext().getData(), "text24");
            }

            public RStringField text25() {
                return new RStringField(getContext().getData(), "text25");
            }

            public RStringField employeeNumber1() {
                return new RStringField(getContext().getData(), "employeenumber1");
            }

            public RStringField employeeNumber2() {
                return new RStringField(getContext().getData(), "employeenumber2");
            }

            public RStringField employeeNumber3() {
                return new RStringField(getContext().getData(), "employeenumber3");
            }

            public RStringField employeeNumber4() {
                return new RStringField(getContext().getData(), "employeenumber4");
            }

            public RStringField employeeNumber5() {
                return new RStringField(getContext().getData(), "employeenumber5");
            }

            public RStringField employeeNumber6() {
                return new RStringField(getContext().getData(), "employeenumber6");
            }

            public RStringField employeeNumber7() {
                return new RStringField(getContext().getData(), "employeenumber7");
            }

            public RStringField employeeNumber8() {
                return new RStringField(getContext().getData(), "employeenumber8");
            }

            public RStringField employeeNumber9() {
                return new RStringField(getContext().getData(), "employeenumber9");
            }

            public RStringField employeeNumber10() {
                return new RStringField(getContext().getData(), "employeenumber10");
            }

            public RStringField instanceKey() {
                return new RStringField(getContext().getData(), "instancekey");
            }

            public RStringField transactionTimeStamp() {
                return new RStringField(getContext().getData(), "transactiontimestamp");
            }

            public RStringField blanketInvoiceCollectionKey() {
                return new RStringField(getContext().getData(), "blanketinvoicecollectionkey");
            }

            public RStringField blanketInvoiceReference() {
                return new RStringField(getContext().getData(), "blanketinvoicereference");
            }

            public RStringField submittedInvoiceDraftBy() {
                return new RStringField(getContext().getData(), "submittedinvoicedraftby");
            }

            public RStringField approvedForInvoicingBy() {
                return new RStringField(getContext().getData(), "approvedforinvoicingby");
            }

            public RStringField documentArchiveNumber() {
                return new RStringField(getContext().getData(), "documentarchivenumber");
            }

            public RStringField noteNumber() {
                return new RStringField(getContext().getData(), "notenumber");
            }

            public RStringField templateJobNumber() {
                return new RStringField(getContext().getData(), "templatejobnumber");
            }

            public RStringField referenceJobNumber() {
                return new RStringField(getContext().getData(), "referencejobnumber");
            }

            public RStringField opportunityNumber() {
                return new RStringField(getContext().getData(), "opportunitynumber");
            }

            public RStringField electronicMailAddress() {
                return new RStringField(getContext().getData(), "electronicmailaddress");
            }

            public RStringField contactPerson() {
                return new RStringField(getContext().getData(), "contactperson");
            }

            public RStringField team1Number() {
                return new RStringField(getContext().getData(), "team1number");
            }

            public RStringField team2Number() {
                return new RStringField(getContext().getData(), "team2number");
            }

            public RStringField team3Number() {
                return new RStringField(getContext().getData(), "team3number");
            }

            public RStringField team4Number() {
                return new RStringField(getContext().getData(), "team4number");
            }

            public RStringField team5Number() {
                return new RStringField(getContext().getData(), "team5number");
            }

            public RStringField team6Number() {
                return new RStringField(getContext().getData(), "team6number");
            }

            public RStringField customerRemark15() {
                return new RStringField(getContext().getData(), "customerremark15");
            }

            public RStringField customerRemark16() {
                return new RStringField(getContext().getData(), "customerremark16");
            }

            public RStringField customerRemark17() {
                return new RStringField(getContext().getData(), "customerremark17");
            }

            public RStringField customerRemark18() {
                return new RStringField(getContext().getData(), "customerremark18");
            }

            public RStringField customerRemark19() {
                return new RStringField(getContext().getData(), "customerremark19");
            }

            public RStringField customerRemark20() {
                return new RStringField(getContext().getData(), "customerremark20");
            }

            public RStringField parentCustomer() {
                return new RStringField(getContext().getData(), "parentcustomer");
            }

            public RStringField customerJobOptionListNumber1() {
                return new RStringField(getContext().getData(), "customerjoboptionlistnumber1");
            }

            public RStringField customerJobOptionListNumber2() {
                return new RStringField(getContext().getData(), "customerjoboptionlistnumber2");
            }

            public RStringField customerJobOptionListNumber3() {
                return new RStringField(getContext().getData(), "customerjoboptionlistnumber3");
            }

            public RStringField selectedCustomerJobOption1() {
                return new RStringField(getContext().getData(), "selectedcustomerjoboption1");
            }

            public RStringField selectedCustomerJobOption2() {
                return new RStringField(getContext().getData(), "selectedcustomerjoboption2");
            }

            public RStringField selectedCustomerJobOption3() {
                return new RStringField(getContext().getData(), "selectedcustomerjoboption3");
            }

            public RStringField rolledForwardToJobNumber() {
                return new RStringField(getContext().getData(), "rolledforwardtojobnumber");
            }

            public RStringField accountManagerNumber() {
                return new RStringField(getContext().getData(), "accountmanagernumber");
            }

            public RStringField konaSpaceNumber() {
                return new RStringField(getContext().getData(), "konaspacenumber");
            }

            public RStringField accountManagerName() {
                return new RStringField(getContext().getData(), "accountmanagername");
            }

            public RStringField employee1Name() {
                return new RStringField(getContext().getData(), "employee1name");
            }

            public RStringField employee2Name() {
                return new RStringField(getContext().getData(), "employee2name");
            }

            public RStringField employee3Name() {
                return new RStringField(getContext().getData(), "employee3name");
            }

            public RStringField employee4Name() {
                return new RStringField(getContext().getData(), "employee4name");
            }

            public RStringField employee5Name() {
                return new RStringField(getContext().getData(), "employee5name");
            }

            public RStringField employee6Name() {
                return new RStringField(getContext().getData(), "employee6name");
            }

            public RStringField employee7Name() {
                return new RStringField(getContext().getData(), "employee7name");
            }

            public RStringField employee8Name() {
                return new RStringField(getContext().getData(), "employee8name");
            }

            public RStringField employee9Name() {
                return new RStringField(getContext().getData(), "employee9name");
            }

            public RStringField employee10Name() {
                return new RStringField(getContext().getData(), "employee10name");
            }
        }

        public static class Record
            extends BaseRecord<FilterRecord>
            implements IRecord
        {

            private Record(IHasClient iHasClient, FilterRecord filterRecord) {
                super(iHasClient, filterRecord);
            }

            public RStringField jobNumber() {
                return new RStringField(getContext().getData(), "jobnumber");
            }

            public RStringField jobName() {
                return new RStringField(getContext().getData(), "jobname");
            }

            public RStringField companyName() {
                return new RStringField(getContext().getData(), "companyname");
            }

            public RStringField projectManagerName() {
                return new RStringField(getContext().getData(), "projectmanagername");
            }

            public RStringField mainJobNumber() {
                return new RStringField(getContext().getData(), "mainjobnumber");
            }

            public RStringField jobProgressRemark() {
                return new RStringField(getContext().getData(), "jobprogressremark");
            }

            public RStringField convertedBy() {
                return new RStringField(getContext().getData(), "convertedby");
            }

            public RStringField projectManagerNumber() {
                return new RStringField(getContext().getData(), "projectmanagernumber");
            }

            public RStringField salesPersonNumber() {
                return new RStringField(getContext().getData(), "salespersonnumber");
            }

            public RStringField salesPerson() {
                return new RStringField(getContext().getData(), "salesperson");
            }

            public RStringField responsible() {
                return new RStringField(getContext().getData(), "responsible");
            }

            public RStringField customerNumber() {
                return new RStringField(getContext().getData(), "customernumber");
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

            public RStringField level1CustomerNumber() {
                return new RStringField(getContext().getData(), "level1customernumber");
            }

            public RStringField customerLevel1Name() {
                return new RStringField(getContext().getData(), "customerlevel1name");
            }

            public RStringField level2CustomerNumber() {
                return new RStringField(getContext().getData(), "level2customernumber");
            }

            public RStringField customerLevel2Name() {
                return new RStringField(getContext().getData(), "customerlevel2name");
            }

            public RStringField level3CustomerNumber() {
                return new RStringField(getContext().getData(), "level3customernumber");
            }

            public RStringField customerLevel3Name() {
                return new RStringField(getContext().getData(), "customerlevel3name");
            }

            public RStringField level4CustomerNumber() {
                return new RStringField(getContext().getData(), "level4customernumber");
            }

            public RStringField customerLevel4Name() {
                return new RStringField(getContext().getData(), "customerlevel4name");
            }

            public RStringField level5CustomerNumber() {
                return new RStringField(getContext().getData(), "level5customernumber");
            }

            public RStringField customerLevel5Name() {
                return new RStringField(getContext().getData(), "customerlevel5name");
            }

            public RStringField levelName() {
                return new RStringField(getContext().getData(), "levelname");
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

            public RStringField attention() {
                return new RStringField(getContext().getData(), "attention");
            }

            public RStringField telephone() {
                return new RStringField(getContext().getData(), "telephone");
            }

            public RStringField telefax() {
                return new RStringField(getContext().getData(), "telefax");
            }

            public RStringField telex() {
                return new RStringField(getContext().getData(), "telex");
            }

            public RStringField paymentCustomer() {
                return new RStringField(getContext().getData(), "paymentcustomer");
            }

            public RStringField description1() {
                return new RStringField(getContext().getData(), "description1");
            }

            public RStringField description2() {
                return new RStringField(getContext().getData(), "description2");
            }

            public RStringField description3() {
                return new RStringField(getContext().getData(), "description3");
            }

            public RStringField reference() {
                return new RStringField(getContext().getData(), "reference");
            }

            public RStringField remark() {
                return new RStringField(getContext().getData(), "remark");
            }

            public RStringField companyNumber() {
                return new RStringField(getContext().getData(), "companynumber");
            }

            public RStringField settlingCompany() {
                return new RStringField(getContext().getData(), "settlingcompany");
            }

            public RStringField currentPhase() {
                return new RStringField(getContext().getData(), "currentphase");
            }

            public RStringField jobProcessing() {
                return new RStringField(getContext().getData(), "jobprocessing");
            }

            public RStringField jobProcessingStatus() {
                return new RStringField(getContext().getData(), "jobprocessingstatus");
            }

            public RStringField resultType() {
                return new RStringField(getContext().getData(), "resulttype");
            }

            public RStringField dimensionCombNumber() {
                return new RStringField(getContext().getData(), "dimensioncombnumber");
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

            public RStringField jobCollectionNumber() {
                return new RStringField(getContext().getData(), "jobcollectionnumber");
            }

            public RStringField taskList() {
                return new RStringField(getContext().getData(), "tasklist");
            }

            public RStringField jobAllocationName() {
                return new RStringField(getContext().getData(), "joballocationname");
            }

            public RStringField vATNumber() {
                return new RStringField(getContext().getData(), "vatnumber");
            }

            public RStringField customerPaymentMode() {
                return new RStringField(getContext().getData(), "customerpaymentmode");
            }

            public RStringField globalLocationNumber() {
                return new RStringField(getContext().getData(), "globallocationnumber");
            }

            public RStringField invoiceName() {
                return new RStringField(getContext().getData(), "invoicename");
            }

            public RStringField costJobPriceList() {
                return new RStringField(getContext().getData(), "costjobpricelist");
            }

            public RStringField intercompanyJobPriceList() {
                return new RStringField(getContext().getData(), "intercompanyjobpricelist");
            }

            public RStringField jobPriceList() {
                return new RStringField(getContext().getData(), "jobpricelist");
            }

            public RStringField standardBillingPriceList() {
                return new RStringField(getContext().getData(), "standardbillingpricelist");
            }

            public RStringField jobSurchargeRuleName() {
                return new RStringField(getContext().getData(), "jobsurchargerulename");
            }

            public RStringField accessLevelName() {
                return new RStringField(getContext().getData(), "accesslevelname");
            }

            public RStringField createdBy() {
                return new RStringField(getContext().getData(), "createdby");
            }

            public RStringField changedBy() {
                return new RStringField(getContext().getData(), "changedby");
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

            public RStringField text11() {
                return new RStringField(getContext().getData(), "text11");
            }

            public RStringField text12() {
                return new RStringField(getContext().getData(), "text12");
            }

            public RStringField text13() {
                return new RStringField(getContext().getData(), "text13");
            }

            public RStringField text14() {
                return new RStringField(getContext().getData(), "text14");
            }

            public RStringField text15() {
                return new RStringField(getContext().getData(), "text15");
            }

            public RStringField text16() {
                return new RStringField(getContext().getData(), "text16");
            }

            public RStringField text17() {
                return new RStringField(getContext().getData(), "text17");
            }

            public RStringField text18() {
                return new RStringField(getContext().getData(), "text18");
            }

            public RStringField text19() {
                return new RStringField(getContext().getData(), "text19");
            }

            public RStringField text20() {
                return new RStringField(getContext().getData(), "text20");
            }

            public RStringField text21() {
                return new RStringField(getContext().getData(), "text21");
            }

            public RStringField text22() {
                return new RStringField(getContext().getData(), "text22");
            }

            public RStringField text23() {
                return new RStringField(getContext().getData(), "text23");
            }

            public RStringField text24() {
                return new RStringField(getContext().getData(), "text24");
            }

            public RStringField text25() {
                return new RStringField(getContext().getData(), "text25");
            }

            public RStringField employeeNumber1() {
                return new RStringField(getContext().getData(), "employeenumber1");
            }

            public RStringField employeeNumber2() {
                return new RStringField(getContext().getData(), "employeenumber2");
            }

            public RStringField employeeNumber3() {
                return new RStringField(getContext().getData(), "employeenumber3");
            }

            public RStringField employeeNumber4() {
                return new RStringField(getContext().getData(), "employeenumber4");
            }

            public RStringField employeeNumber5() {
                return new RStringField(getContext().getData(), "employeenumber5");
            }

            public RStringField employeeNumber6() {
                return new RStringField(getContext().getData(), "employeenumber6");
            }

            public RStringField employeeNumber7() {
                return new RStringField(getContext().getData(), "employeenumber7");
            }

            public RStringField employeeNumber8() {
                return new RStringField(getContext().getData(), "employeenumber8");
            }

            public RStringField employeeNumber9() {
                return new RStringField(getContext().getData(), "employeenumber9");
            }

            public RStringField employeeNumber10() {
                return new RStringField(getContext().getData(), "employeenumber10");
            }

            public RStringField instanceKey() {
                return new RStringField(getContext().getData(), "instancekey");
            }

            public RStringField transactionTimeStamp() {
                return new RStringField(getContext().getData(), "transactiontimestamp");
            }

            public RStringField blanketInvoiceCollectionKey() {
                return new RStringField(getContext().getData(), "blanketinvoicecollectionkey");
            }

            public RStringField blanketInvoiceReference() {
                return new RStringField(getContext().getData(), "blanketinvoicereference");
            }

            public RStringField submittedInvoiceDraftBy() {
                return new RStringField(getContext().getData(), "submittedinvoicedraftby");
            }

            public RStringField approvedForInvoicingBy() {
                return new RStringField(getContext().getData(), "approvedforinvoicingby");
            }

            public RStringField documentArchiveNumber() {
                return new RStringField(getContext().getData(), "documentarchivenumber");
            }

            public RStringField noteNumber() {
                return new RStringField(getContext().getData(), "notenumber");
            }

            public RStringField templateJobNumber() {
                return new RStringField(getContext().getData(), "templatejobnumber");
            }

            public RStringField referenceJobNumber() {
                return new RStringField(getContext().getData(), "referencejobnumber");
            }

            public RStringField opportunityNumber() {
                return new RStringField(getContext().getData(), "opportunitynumber");
            }

            public RStringField electronicMailAddress() {
                return new RStringField(getContext().getData(), "electronicmailaddress");
            }

            public RStringField contactPerson() {
                return new RStringField(getContext().getData(), "contactperson");
            }

            public RStringField team1Number() {
                return new RStringField(getContext().getData(), "team1number");
            }

            public RStringField team2Number() {
                return new RStringField(getContext().getData(), "team2number");
            }

            public RStringField team3Number() {
                return new RStringField(getContext().getData(), "team3number");
            }

            public RStringField team4Number() {
                return new RStringField(getContext().getData(), "team4number");
            }

            public RStringField team5Number() {
                return new RStringField(getContext().getData(), "team5number");
            }

            public RStringField team6Number() {
                return new RStringField(getContext().getData(), "team6number");
            }

            public RStringField customerRemark15() {
                return new RStringField(getContext().getData(), "customerremark15");
            }

            public RStringField customerRemark16() {
                return new RStringField(getContext().getData(), "customerremark16");
            }

            public RStringField customerRemark17() {
                return new RStringField(getContext().getData(), "customerremark17");
            }

            public RStringField customerRemark18() {
                return new RStringField(getContext().getData(), "customerremark18");
            }

            public RStringField customerRemark19() {
                return new RStringField(getContext().getData(), "customerremark19");
            }

            public RStringField customerRemark20() {
                return new RStringField(getContext().getData(), "customerremark20");
            }

            public RStringField parentCustomer() {
                return new RStringField(getContext().getData(), "parentcustomer");
            }

            public RStringField customerJobOptionListNumber1() {
                return new RStringField(getContext().getData(), "customerjoboptionlistnumber1");
            }

            public RStringField customerJobOptionListNumber2() {
                return new RStringField(getContext().getData(), "customerjoboptionlistnumber2");
            }

            public RStringField customerJobOptionListNumber3() {
                return new RStringField(getContext().getData(), "customerjoboptionlistnumber3");
            }

            public RStringField selectedCustomerJobOption1() {
                return new RStringField(getContext().getData(), "selectedcustomerjoboption1");
            }

            public RStringField selectedCustomerJobOption2() {
                return new RStringField(getContext().getData(), "selectedcustomerjoboption2");
            }

            public RStringField selectedCustomerJobOption3() {
                return new RStringField(getContext().getData(), "selectedcustomerjoboption3");
            }

            public RStringField rolledForwardToJobNumber() {
                return new RStringField(getContext().getData(), "rolledforwardtojobnumber");
            }

            public RStringField accountManagerNumber() {
                return new RStringField(getContext().getData(), "accountmanagernumber");
            }

            public RStringField konaSpaceNumber() {
                return new RStringField(getContext().getData(), "konaspacenumber");
            }

            public RStringField accountManagerName() {
                return new RStringField(getContext().getData(), "accountmanagername");
            }

            public RStringField employee1Name() {
                return new RStringField(getContext().getData(), "employee1name");
            }

            public RStringField employee2Name() {
                return new RStringField(getContext().getData(), "employee2name");
            }

            public RStringField employee3Name() {
                return new RStringField(getContext().getData(), "employee3name");
            }

            public RStringField employee4Name() {
                return new RStringField(getContext().getData(), "employee4name");
            }

            public RStringField employee5Name() {
                return new RStringField(getContext().getData(), "employee5name");
            }

            public RStringField employee6Name() {
                return new RStringField(getContext().getData(), "employee6name");
            }

            public RStringField employee7Name() {
                return new RStringField(getContext().getData(), "employee7name");
            }

            public RStringField employee8Name() {
                return new RStringField(getContext().getData(), "employee8name");
            }

            public RStringField employee9Name() {
                return new RStringField(getContext().getData(), "employee9name");
            }

            public RStringField employee10Name() {
                return new RStringField(getContext().getData(), "employee10name");
            }
        }
    }

    public static class Table
        extends BaseTablePane<JobBudgets.Table.InitRecord, JobBudgets.Table.Record>
    {

        private Table(IHasClient iHasClient, CardTableData cardTableData) {
            super(iHasClient, cardTableData, initRecord -> {
                return new JobBudgets.Table.InitRecord(iHasClient, initRecord);
            }
            , record -> {
                return new JobBudgets.Table.Record(iHasClient, record);
            }
            );
        }

        public static class InitRecord
            extends BaseCardTableRecord<com.deltek.integration.maconomy.psorestclient.JobBudgets.Card>
            implements ICreateAction<com.deltek.integration.maconomy.psorestclient.JobBudgets.Card> , IInitRecord
        {

            private InitRecord(IHasClient iHasClient, CardTableRecord cardTableRecord) {
                super(iHasClient, cardTableRecord, cardTableData -> {
                    return new com.deltek.integration.maconomy.psorestclient.JobBudgets.Card(iHasClient, cardTableData);
                }
                );
            }

            public RStringField jobNumber() {
                return new RStringField(getContext().getData(), "jobnumber");
            }

            public RWStringField activityNumber() {
                return new RWStringField(getContext().getData(), "activitynumber");
            }

            public RWStringField text() {
                return new RWStringField(getContext().getData(), "text");
            }

            public RWStringField employeeNumber() {
                return new RWStringField(getContext().getData(), "employeenumber");
            }

            public RStringField vATCode() {
                return new RStringField(getContext().getData(), "vatcode");
            }

            public RWStringField supplierNumber() {
                return new RWStringField(getContext().getData(), "suppliernumber");
            }

            public RWStringField remark() {
                return new RWStringField(getContext().getData(), "remark");
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

            public RWStringField deliveryRemark() {
                return new RWStringField(getContext().getData(), "deliveryremark");
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

            public RWStringField taskName() {
                return new RWStringField(getContext().getData(), "taskname");
            }

            public RStringField yourReference() {
                return new RStringField(getContext().getData(), "yourreference");
            }

            public RStringField companyNumber() {
                return new RStringField(getContext().getData(), "companynumber");
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

            public RWStringField purposeName() {
                return new RWStringField(getContext().getData(), "purposename");
            }

            public RWStringField financeVATCode() {
                return new RWStringField(getContext().getData(), "financevatcode");
            }

            public RStringField executingCompanyNumber() {
                return new RStringField(getContext().getData(), "executingcompanynumber");
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

            public RWStringField remark6() {
                return new RWStringField(getContext().getData(), "remark6");
            }

            public RWStringField remark7() {
                return new RWStringField(getContext().getData(), "remark7");
            }

            public RWStringField remark8() {
                return new RWStringField(getContext().getData(), "remark8");
            }

            public RWStringField remark9() {
                return new RWStringField(getContext().getData(), "remark9");
            }

            public RWStringField remark10() {
                return new RWStringField(getContext().getData(), "remark10");
            }

            public RWStringField employeeCategoryNumber() {
                return new RWStringField(getContext().getData(), "employeecategorynumber");
            }

            public RStringField skillRequirementKey() {
                return new RStringField(getContext().getData(), "skillrequirementkey");
            }

            public RStringField skillNumber() {
                return new RStringField(getContext().getData(), "skillnumber");
            }

            public RStringField skillLevel() {
                return new RStringField(getContext().getData(), "skilllevel");
            }

            public RStringField styleName() {
                return new RStringField(getContext().getData(), "stylename");
            }

            public RStringField lineKey() {
                return new RStringField(getContext().getData(), "linekey");
            }

            public RStringField secondaryStyleName() {
                return new RStringField(getContext().getData(), "secondarystylename");
            }

            public RStringField approvedAsInstanceKey() {
                return new RStringField(getContext().getData(), "approvedasinstancekey");
            }

            public RStringField instanceKey() {
                return new RStringField(getContext().getData(), "instancekey");
            }

            public RStringField hasBeenPutOnHoldBy() {
                return new RStringField(getContext().getData(), "hasbeenputonholdby");
            }

            public RStringField resumedBy() {
                return new RStringField(getContext().getData(), "resumedby");
            }

            public RWStringField team1Number() {
                return new RWStringField(getContext().getData(), "team1number");
            }

            public RWStringField team2Number() {
                return new RWStringField(getContext().getData(), "team2number");
            }

            public RWStringField team3Number() {
                return new RWStringField(getContext().getData(), "team3number");
            }

            public RWStringField team4Number() {
                return new RWStringField(getContext().getData(), "team4number");
            }

            public RWStringField team5Number() {
                return new RWStringField(getContext().getData(), "team5number");
            }

            public RWStringField team6Number() {
                return new RWStringField(getContext().getData(), "team6number");
            }

            public RWStringField parentJobBudgetLineInstanceKey() {
                return new RWStringField(getContext().getData(), "parentjobbudgetlineinstancekey");
            }

            public RStringField priceListLineInstanceKey() {
                return new RStringField(getContext().getData(), "pricelistlineinstancekey");
            }

            public RStringField transactionTimestamp() {
                return new RStringField(getContext().getData(), "transactiontimestamp");
            }

            public RStringField vATCode2() {
                return new RStringField(getContext().getData(), "vatcode2");
            }

            public RStringField vATCode3() {
                return new RStringField(getContext().getData(), "vatcode3");
            }

            public RStringField firstInstanceKey() {
                return new RStringField(getContext().getData(), "firstinstancekey");
            }

            public RStringField jobBudgetLineReference() {
                return new RStringField(getContext().getData(), "jobbudgetlinereference");
            }

            public RWStringField externalDescription() {
                return new RWStringField(getContext().getData(), "externaldescription");
            }

            public RStringField supplierNameVar() {
                return new RStringField(getContext().getData(), "suppliernamevar");
            }

            public RStringField executingCompanyNameVar() {
                return new RStringField(getContext().getData(), "executingcompanynamevar");
            }

            public RStringField activityTextVar() {
                return new RStringField(getContext().getData(), "activitytextvar");
            }

            public RStringField taskDescriptionVar() {
                return new RStringField(getContext().getData(), "taskdescriptionvar");
            }

            public RStringField employeeCategoryNameVar() {
                return new RStringField(getContext().getData(), "employeecategorynamevar");
            }

            public RStringField employeeNameVar() {
                return new RStringField(getContext().getData(), "employeenamevar");
            }
        }

        public static class Record
            extends BaseCardTableRecord<com.deltek.integration.maconomy.psorestclient.JobBudgets.Card>
            implements IRecord
        {

            private Record(IHasClient iHasClient, CardTableRecord cardTableRecord) {
                super(iHasClient, cardTableRecord, cardTableData -> {
                    return new com.deltek.integration.maconomy.psorestclient.JobBudgets.Card(iHasClient, cardTableData);
                }
                );
            }

            public RStringField jobNumber() {
                return new RStringField(getContext().getData(), "jobnumber");
            }

            public RWStringField activityNumber() {
                return new RWStringField(getContext().getData(), "activitynumber");
            }

            public RWStringField text() {
                return new RWStringField(getContext().getData(), "text");
            }

            public RWStringField employeeNumber() {
                return new RWStringField(getContext().getData(), "employeenumber");
            }

            public RStringField vATCode() {
                return new RStringField(getContext().getData(), "vatcode");
            }

            public RWStringField supplierNumber() {
                return new RWStringField(getContext().getData(), "suppliernumber");
            }

            public RWStringField remark() {
                return new RWStringField(getContext().getData(), "remark");
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

            public RWStringField deliveryRemark() {
                return new RWStringField(getContext().getData(), "deliveryremark");
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

            public RWStringField taskName() {
                return new RWStringField(getContext().getData(), "taskname");
            }

            public RWStringField yourReference() {
                return new RWStringField(getContext().getData(), "yourreference");
            }

            public RStringField companyNumber() {
                return new RStringField(getContext().getData(), "companynumber");
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

            public RWStringField purposeName() {
                return new RWStringField(getContext().getData(), "purposename");
            }

            public RWStringField financeVATCode() {
                return new RWStringField(getContext().getData(), "financevatcode");
            }

            public RStringField executingCompanyNumber() {
                return new RStringField(getContext().getData(), "executingcompanynumber");
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

            public RWStringField remark6() {
                return new RWStringField(getContext().getData(), "remark6");
            }

            public RWStringField remark7() {
                return new RWStringField(getContext().getData(), "remark7");
            }

            public RWStringField remark8() {
                return new RWStringField(getContext().getData(), "remark8");
            }

            public RWStringField remark9() {
                return new RWStringField(getContext().getData(), "remark9");
            }

            public RWStringField remark10() {
                return new RWStringField(getContext().getData(), "remark10");
            }

            public RWStringField employeeCategoryNumber() {
                return new RWStringField(getContext().getData(), "employeecategorynumber");
            }

            public RStringField skillRequirementKey() {
                return new RStringField(getContext().getData(), "skillrequirementkey");
            }

            public RStringField skillNumber() {
                return new RStringField(getContext().getData(), "skillnumber");
            }

            public RStringField skillLevel() {
                return new RStringField(getContext().getData(), "skilllevel");
            }

            public RStringField styleName() {
                return new RStringField(getContext().getData(), "stylename");
            }

            public RStringField lineKey() {
                return new RStringField(getContext().getData(), "linekey");
            }

            public RStringField secondaryStyleName() {
                return new RStringField(getContext().getData(), "secondarystylename");
            }

            public RStringField approvedAsInstanceKey() {
                return new RStringField(getContext().getData(), "approvedasinstancekey");
            }

            public RStringField instanceKey() {
                return new RStringField(getContext().getData(), "instancekey");
            }

            public RStringField hasBeenPutOnHoldBy() {
                return new RStringField(getContext().getData(), "hasbeenputonholdby");
            }

            public RStringField resumedBy() {
                return new RStringField(getContext().getData(), "resumedby");
            }

            public RWStringField team1Number() {
                return new RWStringField(getContext().getData(), "team1number");
            }

            public RWStringField team2Number() {
                return new RWStringField(getContext().getData(), "team2number");
            }

            public RWStringField team3Number() {
                return new RWStringField(getContext().getData(), "team3number");
            }

            public RWStringField team4Number() {
                return new RWStringField(getContext().getData(), "team4number");
            }

            public RWStringField team5Number() {
                return new RWStringField(getContext().getData(), "team5number");
            }

            public RWStringField team6Number() {
                return new RWStringField(getContext().getData(), "team6number");
            }

            public RWStringField parentJobBudgetLineInstanceKey() {
                return new RWStringField(getContext().getData(), "parentjobbudgetlineinstancekey");
            }

            public RStringField priceListLineInstanceKey() {
                return new RStringField(getContext().getData(), "pricelistlineinstancekey");
            }

            public RStringField transactionTimestamp() {
                return new RStringField(getContext().getData(), "transactiontimestamp");
            }

            public RStringField vATCode2() {
                return new RStringField(getContext().getData(), "vatcode2");
            }

            public RStringField vATCode3() {
                return new RStringField(getContext().getData(), "vatcode3");
            }

            public RStringField firstInstanceKey() {
                return new RStringField(getContext().getData(), "firstinstancekey");
            }

            public RStringField jobBudgetLineReference() {
                return new RStringField(getContext().getData(), "jobbudgetlinereference");
            }

            public RWStringField externalDescription() {
                return new RWStringField(getContext().getData(), "externaldescription");
            }

            public RStringField supplierNameVar() {
                return new RStringField(getContext().getData(), "suppliernamevar");
            }

            public RStringField executingCompanyNameVar() {
                return new RStringField(getContext().getData(), "executingcompanynamevar");
            }

            public RStringField activityTextVar() {
                return new RStringField(getContext().getData(), "activitytextvar");
            }

            public RStringField taskDescriptionVar() {
                return new RStringField(getContext().getData(), "taskdescriptionvar");
            }

            public RStringField employeeCategoryNameVar() {
                return new RStringField(getContext().getData(), "employeecategorynamevar");
            }

            public RStringField employeeNameVar() {
                return new RStringField(getContext().getData(), "employeenamevar");
            }
        }
    }
}
