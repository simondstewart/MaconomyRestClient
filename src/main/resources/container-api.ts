export interface IContainerName {
  containerName: string;
}

export interface IContainer extends IContainerName {
  links: ILinks;
}

export interface ISpecificationResponse extends IContainerName {
  panes: {
    filter?: IPaneSpecification;
    card?: IPaneSpecification;
    table?: IPaneSpecification;
  };
  relatedContainers: IContainers;
}

export type IFieldSpecificationMap = { [fieldName: string]: IFieldSpecification; }

export interface IPaneSpecification extends IPaneName {
  title: string;
  entity: string;
  actions: { [rel: string]: IActionSpecification; };
  fields: IFieldSpecificationMap;
  foreignKeys: { [foreignKeyName: string]: IForeignKeySpecification; };
}

export interface IActionSpecification {
  title: string;
  rel: string;
}

export interface IFieldSpecification {
  name: string;
  title: string;
  type: string;
  create: boolean;
  autoSubmit: boolean;
  hidden: boolean;
  mandatory: boolean;
  maxLength?: number;
  multiLine: boolean;
  secret: boolean;
  suggestions: string;
  update: boolean;
  unfilterable: boolean;
  references: string[];
  key: boolean;
  subtypeContainer?: string;
  enumType?: string;
}

export interface IForeignKeySpecification {
  name: string;
  title: string;
  incomplete: boolean;
  searchContainer: string;
  searchPane: string;
  rel: string;
  fieldReferences: IFieldReference[];
  links: ILinks;
}

export interface IFieldReference {
  field: string;
  foreignField: string;
  supplement: boolean;
}

export interface IContainers {
  [containerName: string]: IContainer;
}

export interface IData {
  meta: IContainerName;
  links: ILinks;
}

export interface IFilterData extends IData {
  panes: {
    filter: IFilterPane;
  };
}

export interface ICardTableData extends IData {
  panes: {
    card: ICardTablePane;
    table?: ICardTablePane;
  };
}

export interface IPaneName {
  paneName: string;
}

export interface IHasRows {
  rowCount: number;
  rowOffset: number;
}

export interface IPane<PaneMetaType, RecordType> {
  meta: PaneMetaType;
  records: RecordType[];
  links: ILinks;
}

export interface IFilterPane extends IPane<IPaneName &
  IHasRows, IFilterRecord> {
}

export interface ICardTablePane extends IPane<IPaneName &
  IHasRows &
  IOptionalConcurrencyControl, ICardTableRecord> {
}

export type LinkRelation =
  'self' |
    'specification' |
    'file' |
    'data:filter' |
    'data:enumvalues' |
    'data:any-key' |
    'data:same-key' |
    'data:insert' |
    'data:add' |
    'data:create' |
    'data:read' |
    'data:update' |
    'data:delete' |
    'data:print' |
    string;

export interface ILinks {
  [rel: string]: IHrefLink | ITemplateLink;
}

export interface IHrefLink {
  rel: string;
  href: string;
}

export interface ITemplateLink {
  rel: string;
  template: string;
}

export interface IRecord<RecordMetaType> {
  meta: RecordMetaType;
  data: IRecordData;
  links: ILinks;
}

export interface IRecordData {
  [fieldName: string]: any;
}

export interface INumberedRow {
  rowNumber: number;
}

export interface IConcurrencyControl {
  concurrencyControl: string;
}

export interface IOptionalConcurrencyControl {
  concurrencyControl?: string;
}

export interface IFilterRecord extends IRecord<INumberedRow> {
}

export interface ICardTableRecord extends IRecord<INumberedRow & IConcurrencyControl> {
}

export interface IFilterRestriction {
  limit?: number;
  offset?: number;
  fields?: string;
  orderBy?: string;
  restriction?: string;
}