create table addresses (id binary not null, city varchar(255), country varchar(255), street varchar(255), zip_code varchar(255), primary key (id))
create table customers (customer_type varchar(31) not null, id binary not null, name varchar(255), tax_id varchar(255), vat_number varchar(255), first_name varchar(255), last_name varchar(255), primary key (id))
create table customers_addresses (customer_id binary not null, addresses_id binary not null)
alter table customers_addresses add constraint UK_9jc324obdu44atlhb0iifw47u unique (addresses_id)
alter table customers_addresses add constraint FKr08vqw1090ujf8lg64q046ju2 foreign key (addresses_id) references addresses
alter table customers_addresses add constraint FKpsc9hohm5l7tcwi8yjho5ef9o foreign key (customer_id) references customers