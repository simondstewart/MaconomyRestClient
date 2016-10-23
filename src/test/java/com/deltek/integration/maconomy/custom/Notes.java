package com.deltek.integration.maconomy.custom;

import java.util.function.Function;

import com.deltek.integration.maconomy.client.MaconomyClient;
import com.deltek.integration.maconomy.containers.v1.CardTableData;
import com.deltek.integration.maconomy.containers.v1.CardTableRecord;
import com.deltek.integration.maconomy.containers.v1.Container;
import com.deltek.integration.maconomy.containers.v1.FilterData;
import com.deltek.integration.maconomy.containers.v1.FilterRecord;


/**
 * AUTO-GENERATED IMPLEMENTATION OF THE "NOTES" CONTAINER. (2016-10-23T16:48:37.518)
 */
public class Notes
    extends BaseContainer
    implements IHasCard<Notes.Card> , IHasFilter<Notes.Filter> , IHasTable<Notes.Table> , IInsertAction<Container, Notes.Card.InitRecord>
{

    public Notes(final MaconomyClient maconomyClient) {
        super(maconomyClient, "Notes");
    }

    @Override
    public Function<FilterData, Notes.Filter> getFilterCtorFn() {
        return filterData -> {
            return new Notes.Filter(this, filterData);
        }
        ;
    }

    @Override
    public Function<CardTableRecord, Notes.Card.InitRecord> getInitRecordCtorFn() {
        return cardTableRecord -> {
            return new Notes.Card.InitRecord(this, cardTableRecord);
        }
        ;
    }

    @Override
    public Function<CardTableData, Notes.Card> getCardCtorFn() {
        return cardTableData -> {
            return new Notes.Card(this, cardTableData);
        }
        ;
    }

    @Override
    public Function<CardTableData, Notes.Table> getTableCtorFn() {
        return cardTableData -> {
            return new Notes.Table(this, cardTableData);
        }
        ;
    }

    public static class Card
        extends BaseCardPane<Notes.Card.InitRecord, Notes.Card.Record>
    {

        private Card(final IHasClient iHasClient, final CardTableData cardTableData) {
            super(iHasClient, cardTableData, initRecord -> {
                return new Notes.Card.InitRecord(iHasClient, initRecord);
            }
            , record -> {
                return new Notes.Card.Record(iHasClient, record);
            }
            );
        }

        public static class InitRecord
            extends BaseCardTableRecord<Notes.Card>
            implements IInitRecord, ICreateAction<Notes.Card>
        {

            private InitRecord(final IHasClient iHasClient, final CardTableRecord cardTableRecord) {
                super(iHasClient, cardTableRecord, cardTableData -> {
                    return new Notes.Card(iHasClient, cardTableData);
                }
                );
            }

            public RWStringField noteNumber() {
                return new RWStringField(getContext().getData(), "notenumber");
            }

            public RWStringField description() {
                return new RWStringField(getContext().getData(), "description");
            }

            public RWStringField noteType() {
                return new RWStringField(getContext().getData(), "notetype");
            }

            public RWStringField accessLevelName() {
                return new RWStringField(getContext().getData(), "accesslevelname");
            }

            public RWStringField companyNumber() {
                return new RWStringField(getContext().getData(), "companynumber");
            }

            public RStringField createdBy() {
                return new RStringField(getContext().getData(), "createdby");
            }

            public RStringField changedBy() {
                return new RStringField(getContext().getData(), "changedby");
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

            public RWStringField documentArchiveNumber() {
                return new RWStringField(getContext().getData(), "documentarchivenumber");
            }

            public RStringField instanceKey() {
                return new RStringField(getContext().getData(), "instancekey");
            }

            public RWStringField internalRelationName() {
                return new RWStringField(getContext().getData(), "internalrelationname");
            }

            public RWStringField objectInstanceKey() {
                return new RWStringField(getContext().getData(), "objectinstancekey");
            }

            public RStringField transactionTimestamp() {
                return new RStringField(getContext().getData(), "transactiontimestamp");
            }

            public RStringField companyNameVar() {
                return new RStringField(getContext().getData(), "companynamevar");
            }

            public RStringField levelDescriptionVar() {
                return new RStringField(getContext().getData(), "leveldescriptionvar");
            }

            public RStringField documentArchiveDescriptionVar() {
                return new RStringField(getContext().getData(), "documentarchivedescriptionvar");
            }

            public RWStringField key1Var() {
                return new RWStringField(getContext().getData(), "key1var");
            }

            public RWStringField key2Var() {
                return new RWStringField(getContext().getData(), "key2var");
            }

            public RWStringField key3Var() {
                return new RWStringField(getContext().getData(), "key3var");
            }

            public RWStringField key4Var() {
                return new RWStringField(getContext().getData(), "key4var");
            }

            public RStringField keyField1Var() {
                return new RStringField(getContext().getData(), "keyfield1var");
            }

            public RStringField keyField2Var() {
                return new RStringField(getContext().getData(), "keyfield2var");
            }

            public RStringField keyField3Var() {
                return new RStringField(getContext().getData(), "keyfield3var");
            }

            public RStringField keyField4Var() {
                return new RStringField(getContext().getData(), "keyfield4var");
            }

            public RWStringField copyFromNoteNumberVar() {
                return new RWStringField(getContext().getData(), "copyfromnotenumbervar");
            }

            public RStringField changetypeFromNoteNumberVar() {
                return new RStringField(getContext().getData(), "changetypefromnotenumbervar");
            }

            public RStringField newNoteTypeVar() {
                return new RStringField(getContext().getData(), "newnotetypevar");
            }
        }

        public static class Record
            extends BaseCardTableRecord<Notes.Card>
            implements IRecord
        {

            private Record(final IHasClient iHasClient, final CardTableRecord cardTableRecord) {
                super(iHasClient, cardTableRecord, cardTableData -> {
                    return new Notes.Card(iHasClient, cardTableData);
                }
                );
            }

            public RStringField noteNumber() {
                return new RStringField(getContext().getData(), "notenumber");
            }

            public RWStringField description() {
                return new RWStringField(getContext().getData(), "description");
            }

            public RStringField noteType() {
                return new RStringField(getContext().getData(), "notetype");
            }

            public RWStringField accessLevelName() {
                return new RWStringField(getContext().getData(), "accesslevelname");
            }

            public RStringField companyNumber() {
                return new RStringField(getContext().getData(), "companynumber");
            }

            public RStringField createdBy() {
                return new RStringField(getContext().getData(), "createdby");
            }

            public RStringField changedBy() {
                return new RStringField(getContext().getData(), "changedby");
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

            public RWStringField documentArchiveNumber() {
                return new RWStringField(getContext().getData(), "documentarchivenumber");
            }

            public RStringField instanceKey() {
                return new RStringField(getContext().getData(), "instancekey");
            }

            public RWStringField internalRelationName() {
                return new RWStringField(getContext().getData(), "internalrelationname");
            }

            public RWStringField objectInstanceKey() {
                return new RWStringField(getContext().getData(), "objectinstancekey");
            }

            public RStringField transactionTimestamp() {
                return new RStringField(getContext().getData(), "transactiontimestamp");
            }

            public RStringField companyNameVar() {
                return new RStringField(getContext().getData(), "companynamevar");
            }

            public RStringField levelDescriptionVar() {
                return new RStringField(getContext().getData(), "leveldescriptionvar");
            }

            public RStringField documentArchiveDescriptionVar() {
                return new RStringField(getContext().getData(), "documentarchivedescriptionvar");
            }

            public RWStringField key1Var() {
                return new RWStringField(getContext().getData(), "key1var");
            }

            public RWStringField key2Var() {
                return new RWStringField(getContext().getData(), "key2var");
            }

            public RWStringField key3Var() {
                return new RWStringField(getContext().getData(), "key3var");
            }

            public RWStringField key4Var() {
                return new RWStringField(getContext().getData(), "key4var");
            }

            public RStringField keyField1Var() {
                return new RStringField(getContext().getData(), "keyfield1var");
            }

            public RStringField keyField2Var() {
                return new RStringField(getContext().getData(), "keyfield2var");
            }

            public RStringField keyField3Var() {
                return new RStringField(getContext().getData(), "keyfield3var");
            }

            public RStringField keyField4Var() {
                return new RStringField(getContext().getData(), "keyfield4var");
            }

            public RStringField copyFromNoteNumberVar() {
                return new RStringField(getContext().getData(), "copyfromnotenumbervar");
            }

            public RWStringField changetypeFromNoteNumberVar() {
                return new RWStringField(getContext().getData(), "changetypefromnotenumbervar");
            }

            public RWStringField newNoteTypeVar() {
                return new RWStringField(getContext().getData(), "newnotetypevar");
            }
        }
    }

    public static class Filter
        extends BaseFilterPane<Notes.Filter.InitRecord, Notes.Filter.Record>
    {

        private Filter(final IHasClient iHasClient, final FilterData filterData) {
            super(iHasClient, filterData, initRecord -> {
                return new Notes.Filter.InitRecord(iHasClient, initRecord);
            }
            , record -> {
                return new Notes.Filter.Record(iHasClient, record);
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

            public RStringField noteNumber() {
                return new RStringField(getContext().getData(), "notenumber");
            }

            public RStringField description() {
                return new RStringField(getContext().getData(), "description");
            }

            public RStringField noteType() {
                return new RStringField(getContext().getData(), "notetype");
            }

            public RStringField accessLevelName() {
                return new RStringField(getContext().getData(), "accesslevelname");
            }

            public RStringField companyNumber() {
                return new RStringField(getContext().getData(), "companynumber");
            }

            public RStringField createdBy() {
                return new RStringField(getContext().getData(), "createdby");
            }

            public RStringField changedBy() {
                return new RStringField(getContext().getData(), "changedby");
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

            public RStringField documentArchiveNumber() {
                return new RStringField(getContext().getData(), "documentarchivenumber");
            }

            public RStringField instanceKey() {
                return new RStringField(getContext().getData(), "instancekey");
            }

            public RStringField internalRelationName() {
                return new RStringField(getContext().getData(), "internalrelationname");
            }

            public RStringField objectInstanceKey() {
                return new RStringField(getContext().getData(), "objectinstancekey");
            }

            public RStringField transactionTimestamp() {
                return new RStringField(getContext().getData(), "transactiontimestamp");
            }
        }

        public static class Record
            extends BaseRecord<FilterRecord>
            implements IRecord
        {

            private Record(final IHasClient iHasClient, final FilterRecord filterRecord) {
                super(iHasClient, filterRecord);
            }

            public RStringField noteNumber() {
                return new RStringField(getContext().getData(), "notenumber");
            }

            public RStringField description() {
                return new RStringField(getContext().getData(), "description");
            }

            public RStringField noteType() {
                return new RStringField(getContext().getData(), "notetype");
            }

            public RStringField accessLevelName() {
                return new RStringField(getContext().getData(), "accesslevelname");
            }

            public RStringField companyNumber() {
                return new RStringField(getContext().getData(), "companynumber");
            }

            public RStringField createdBy() {
                return new RStringField(getContext().getData(), "createdby");
            }

            public RStringField changedBy() {
                return new RStringField(getContext().getData(), "changedby");
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

            public RStringField documentArchiveNumber() {
                return new RStringField(getContext().getData(), "documentarchivenumber");
            }

            public RStringField instanceKey() {
                return new RStringField(getContext().getData(), "instancekey");
            }

            public RStringField internalRelationName() {
                return new RStringField(getContext().getData(), "internalrelationname");
            }

            public RStringField objectInstanceKey() {
                return new RStringField(getContext().getData(), "objectinstancekey");
            }

            public RStringField transactionTimestamp() {
                return new RStringField(getContext().getData(), "transactiontimestamp");
            }
        }
    }

    public static class Table
        extends BaseTablePane<Notes.Table.InitRecord, Notes.Table.Record>
    {

        private Table(final IHasClient iHasClient, final CardTableData cardTableData) {
            super(iHasClient, cardTableData, initRecord -> {
                return new Notes.Table.InitRecord(iHasClient, initRecord);
            }
            , record -> {
                return new Notes.Table.Record(iHasClient, record);
            }
            );
        }

        public static class InitRecord
            extends BaseCardTableRecord<Notes.Card>
            implements IInitRecord
        {

            private InitRecord(final IHasClient iHasClient, final CardTableRecord cardTableRecord) {
                super(iHasClient, cardTableRecord, cardTableData -> {
                    return new Notes.Card(iHasClient, cardTableData);
                }
                );
            }

            public RStringField noteNumber() {
                return new RStringField(getContext().getData(), "notenumber");
            }

            public RStringField noteType() {
                return new RStringField(getContext().getData(), "notetype");
            }

            public RStringField heading() {
                return new RStringField(getContext().getData(), "heading");
            }

            public RWStringField enteringOfHeading() {
                return new RWStringField(getContext().getData(), "enteringofheading");
            }

            public RWStringField text() {
                return new RWStringField(getContext().getData(), "text");
            }

            public RStringField instanceKey() {
                return new RStringField(getContext().getData(), "instancekey");
            }

            public RWStringField string1() {
                return new RWStringField(getContext().getData(), "string1");
            }

            public RWStringField optionListNumber() {
                return new RWStringField(getContext().getData(), "optionlistnumber");
            }

            public RStringField transactionTimestamp() {
                return new RStringField(getContext().getData(), "transactiontimestamp");
            }

            public RWStringField enteredValueVar() {
                return new RWStringField(getContext().getData(), "enteredvaluevar");
            }
        }

        public static class Record
            extends BaseCardTableRecord<Notes.Card>
            implements IRecord
        {

            private Record(final IHasClient iHasClient, final CardTableRecord cardTableRecord) {
                super(iHasClient, cardTableRecord, cardTableData -> {
                    return new Notes.Card(iHasClient, cardTableData);
                }
                );
            }

            public RStringField noteNumber() {
                return new RStringField(getContext().getData(), "notenumber");
            }

            public RStringField noteType() {
                return new RStringField(getContext().getData(), "notetype");
            }

            public RStringField heading() {
                return new RStringField(getContext().getData(), "heading");
            }

            public RWStringField enteringOfHeading() {
                return new RWStringField(getContext().getData(), "enteringofheading");
            }

            public RWStringField text() {
                return new RWStringField(getContext().getData(), "text");
            }

            public RStringField instanceKey() {
                return new RStringField(getContext().getData(), "instancekey");
            }

            public RWStringField string1() {
                return new RWStringField(getContext().getData(), "string1");
            }

            public RWStringField optionListNumber() {
                return new RWStringField(getContext().getData(), "optionlistnumber");
            }

            public RStringField transactionTimestamp() {
                return new RStringField(getContext().getData(), "transactiontimestamp");
            }

            public RWStringField enteredValueVar() {
                return new RWStringField(getContext().getData(), "enteredvaluevar");
            }
        }
    }
}
